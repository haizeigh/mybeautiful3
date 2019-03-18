package com.company.service.dubbo.impl;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.store.DataStore;
import com.alibaba.dubbo.common.utils.ExecutorUtil;
import com.company.service.dubbo.DubboLifeCircleAO;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ExecutorService;

/*
 * dubbo生命周期辅助类
 */
public class DubboLifeCircleAOImpl implements DubboLifeCircleAO {

	private Logger logger = Logger.getLogger(DubboLifeCircleAOImpl.class);
	private DataStore dataStore;// 数据存储器
	private Map<String, Object> executorMap;// 执行器

	// 初始化
	public void init() {
		dataStore = ExtensionLoader.getExtensionLoader(DataStore.class).getDefaultExtension();
		executorMap = dataStore.get(Constants.EXECUTOR_SERVICE_COMPONENT_KEY);
		logger.info(">> DubboLifeCircleImpl init()");
	}

	// 关闭执行器
	private void shutdownExecutors() {
		logger.info(">> DubboLifeCircleImpl shutdownExecutors()");

		if (MapUtils.isNotEmpty(executorMap)){
			for (Map.Entry<String,Object> entry : executorMap.entrySet()){
				String key = entry.getKey();
                Object obj = entry.getValue();
                logger.info("  > key=" + key + " value=" + obj);
                ExecutorService es = (ExecutorService) obj;
                ExecutorUtil.shutdownNow(es, 20);
            }
		}
	}

	// 销毁
	public void destroy() {
		logger.info(">> DubboLifeCircleImpl destroy()");

		this.shutdownExecutors();

		this.systemExit();

	}

	public void systemExit() {
		logger.info(">> DubboLifeCircleImpl systemExit()");
		logger.info("  >> System.exit(0);");
		System.exit(0);
	}

	public DataStore getDataStore() {
		return dataStore;
	}

	public void setDataStore(DataStore dataStore) {
		this.dataStore = dataStore;
	}

	public Map<String, Object> getExecutorMap() {
		return executorMap;
	}

	public void setExecutorMap(Map<String, Object> executorMap) {
		this.executorMap = executorMap;
	}
}

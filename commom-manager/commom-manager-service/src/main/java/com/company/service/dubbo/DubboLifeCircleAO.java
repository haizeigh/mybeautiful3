package com.company.service.dubbo;

import com.alibaba.dubbo.common.store.DataStore;

import java.util.Map;

/*
 * dubbo生命周期辅助类
 */
public interface DubboLifeCircleAO {

	// 初始化
	public void init();

	// 销毁
	public void destroy();

	public DataStore getDataStore();

	public Map<String, Object> getExecutorMap();

}

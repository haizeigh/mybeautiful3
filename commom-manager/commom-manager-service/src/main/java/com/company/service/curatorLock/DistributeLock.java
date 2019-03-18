package com.company.service.curatorLock;

import com.company.service.constants.ConstantsProperties;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by tomyu on 2018/10/9.
 */
@Service
public class DistributeLock {
	public   String ROOT_PATH="/testPatch222/";  //注意  Path must start with “/”
	public   String ZK_PATH= ConstantsProperties.getPropertyByKey("zookeeper.address");
//只使用一把锁测试
	private   String locakName="ceshi";
	private  InterProcessMutex threadLock;

	private  CuratorFramework curatorFramework;

	public DistributeLock(){

	}
	/*public DistributeLock(String locakName){
		this.locakName=locakName;
	}*/

	@PostConstruct
	public  void  init(){
		RetryPolicy retryPolicy=new ExponentialBackoffRetry(1000,3);
		curatorFramework=CuratorFrameworkFactory.newClient(ZK_PATH,retryPolicy);
		//建立连接诶
		curatorFramework.start();
		//建立竞争锁
		threadLock=new InterProcessMutex(curatorFramework,ROOT_PATH+locakName);
	}

	public  boolean  tryLock(){
//		init();
		//重试三次获得锁
		for (int i=0;i<3;i++){
			try {
				boolean acquire = threadLock.acquire(1, TimeUnit.SECONDS);
				if (acquire) return acquire ;
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		return false ;
	}

	public   void unLock(){
		if (threadLock!=null && threadLock.isAcquiredInThisProcess()){
			try {
				//释放锁
				threadLock.release();
				//删除节点
				//发起一个删除操作. 可以组合其他方法(version 或background) 最后以forPath()方法结尾
				curatorFramework.delete().inBackground().forPath(ROOT_PATH+locakName);
			}
			catch (Exception e) {
				System.out.println("释放锁失败");
			}
		}
	}

	public static void main(String[] args) {

		DistributeLock distributeLock=new DistributeLock();
		distributeLock.ZK_PATH="10.200.114.48:2181";
		distributeLock.init();
		try {
			if (distributeLock.tryLock()){
				System.out.println("测试锁成功");
			}
		}
		catch (Exception e) {
			distributeLock.unLock();
		}

	}


}

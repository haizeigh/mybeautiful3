package com.company.service.test;


import java.util.HashMap;
		import java.util.Map;
		import java.util.concurrent.locks.ReadWriteLock;
		import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {

	//声明一个map,用来作为缓存模型
	private static Map<String, Object> map = new HashMap<String, Object>();
	//声明一个读写锁
	private static ReadWriteLock rwl = new ReentrantReadWriteLock();


	public static Object getValue(String key) {
		Object value = null;
		try {
			rwl.readLock().lock();//开启读锁
			value = map.get(key);
			if (value == null) {
				try {
					rwl.readLock().unlock();//关闭读锁
					System.out.println(Thread.currentThread().getName()+"关闭解锁");
					Thread.sleep(10);
					rwl.writeLock().lock();//开启写锁
					System.out.println(Thread.currentThread().getName()+"获得了写锁");
					Thread.sleep(10000);
					value = map.get(key);
					if (value == null) {
						System.out.println(Thread.currentThread().getName()+"value为空");
						value = "abc";//这里是去数据库查询
						map.put(key, value);//将数据放到缓存模型中
					}else {
						System.out.println(Thread.currentThread().getName()+"value 不为空="+value);
					}
				}catch (Exception e){
					e.printStackTrace();
				}
				finally {
					rwl.writeLock().unlock();//关闭写锁
					System.out.println(Thread.currentThread().getName()+"关闭写锁");
					rwl.readLock().lock();//开启读锁
					System.out.println(Thread.currentThread().getName()+"获得读锁");
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		finally {
			rwl.readLock().unlock();//关闭读锁
		}
		return value;
	}

	public static void main(String[] args) {
//		System.out.println(TestReadWriteLock.getValue("22"));
		for (int i=0;i<4;i ++){
			Thread thread =new Thread(new Runnable() {
				@Override public void run() {
					System.out.println(TestReadWriteLock.getValue("22"));
				}
			});
			thread.start();
		}
	}
}

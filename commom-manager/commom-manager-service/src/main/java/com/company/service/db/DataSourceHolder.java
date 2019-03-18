package com.company.service.db;

/**
 * Created by v-leiyu on 2018/4/18.
 */
public class DataSourceHolder {
	private static ThreadLocal<String> DATA_KEY_HOLDER=new ThreadLocal<>();

	public static String getDataKey(){
		String dataKey = DATA_KEY_HOLDER.get();
		return  dataKey;
	}

	public static void setDataKey(String dataKey){
		DATA_KEY_HOLDER.set(dataKey);
	}

	public static void deleteDataKey(){
		DATA_KEY_HOLDER.remove();
	}

}

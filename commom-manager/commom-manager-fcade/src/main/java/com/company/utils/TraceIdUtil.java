package com.company.utils;

/**
 * Created by tomyu on 2019/1/2.
 */
public class TraceIdUtil {
	private static final ThreadLocal<String> TREACE_ID_CACHE =new ThreadLocal();

	public static  void setTreaceId(String traceId){
		TREACE_ID_CACHE.set(traceId);
	}

	public static  String getTreaceId(){
		return  TREACE_ID_CACHE.get();
	}

	public static  void clearTreaceId( ){
		TREACE_ID_CACHE.remove();
	}
}

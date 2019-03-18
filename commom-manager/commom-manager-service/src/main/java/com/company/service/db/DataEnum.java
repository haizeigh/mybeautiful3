package com.company.service.db;

/**
 * Created by v-leiyu on 2018/4/18.
 */
public enum  DataEnum {
	MasterData("master","主数据库"),
	SalverData("slaver","从数据库");

	private String key;
	private String desc;

	DataEnum(String key,String desc){
		this.key=key;
		this.desc=desc;
	}

	public String getKey(){
		return  key;
	}

	public String getDesc(){
		return  desc;
	}
}

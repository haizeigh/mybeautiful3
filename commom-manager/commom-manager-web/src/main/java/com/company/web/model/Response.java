package com.company.web.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by v-leiyu on 2018/5/28.
 */
@XmlRootElement(name = "MyRoot")
public class Response implements  Serializable{

	private String code;

	private  String msg;

//	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	@XmlElement
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

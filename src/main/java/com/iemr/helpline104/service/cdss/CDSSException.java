package com.iemr.helpline104.service.cdss;

public class CDSSException extends Exception{

	String msg;
String key;
	public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

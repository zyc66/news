package com.qihang.news.exception;

/**
 * 多数情况下，创建自定义异常需要继承Exception，本例继承Exception的子类RuntimeException
 */
public class CheckException extends RuntimeException {

	private Integer retCd;  //异常对应的返回码
	private String msgDes;  //异常对应的描述信息

	public CheckException() {
		super();
	}

	public CheckException(String message) {
		super(message);
		msgDes = message;
	}

	public CheckException(Integer retCd, String msgDes) {
		super();
		this.retCd = retCd;
		this.msgDes = msgDes;
	}

	public Integer getRetCd() {
		return retCd;
	}

	public String getMsgDes() {
		return msgDes;
	}
}
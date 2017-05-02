package com.thinkgem.jeesite.modules.sub.entity;
/**
* 
* @author xingyu
* @version 2017年5月2日 
*/
public class PShortMsg {

	private String mobile;
	private String msg;
	private int type;
	private String sendTime;
	private int status;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public PShortMsg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PShortMsg(String mobile, String msg, int type, String sendTime, int status) {
		super();
		this.mobile = mobile;
		this.msg = msg;
		this.type = type;
		this.sendTime = sendTime;
		this.status = status;
	}
	
}

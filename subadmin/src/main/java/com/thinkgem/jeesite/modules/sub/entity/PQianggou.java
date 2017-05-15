package com.thinkgem.jeesite.modules.sub.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
* 
* @author xingyu
* @version 2017年5月13日 
*/

public class PQianggou implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String title;		
	private String totalAmount;		
	private String clickUrl;		
	private String categoryName;		
	private String zkFinalPrice;		
	private String endTime;		
	private int soldNum;		
	private String startTime;		
	private String reservePrice;		
	private String picUrl;
	private int type;
	private BigInteger numiid;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getZkFinalPrice() {
		return zkFinalPrice;
	}
	public void setZkFinalPrice(String zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getSoldNum() {
		return soldNum;
	}
	public void setSoldNum(int soldNum) {
		this.soldNum = soldNum;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReservePrice() {
		return reservePrice;
	}
	public void setReservePrice(String reservePrice) {
		this.reservePrice = reservePrice;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public BigInteger getNumiid() {
		return numiid;
	}
	public void setNumiid(BigInteger numiid) {
		this.numiid = numiid;
	}
	
	
	public String getClickUrl() {
		return clickUrl;
	}
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public PQianggou(String title, String totalAmount, String clickUrl, String categoryName, String zkFinalPrice,
			String endTime, int soldNum, String startTime, String reservePrice, String picUrl, int type,
			BigInteger numiid) {
		super();
		this.title = title;
		this.totalAmount = totalAmount;
		this.clickUrl = clickUrl;
		this.categoryName = categoryName;
		this.zkFinalPrice = zkFinalPrice;
		this.endTime = endTime;
		this.soldNum = soldNum;
		this.startTime = startTime;
		this.reservePrice = reservePrice;
		this.picUrl = picUrl;
		this.type = type;
		this.numiid = numiid;
	}
	public PQianggou() {
		super();
	}
	
}
package com.thinkgem.jeesite.modules.sub.entity;

import java.io.Serializable;
import java.math.BigInteger;

/**
* 
* @author xingyu
* @version 2017年5月3日 
*/
public class PJzdy implements Serializable {

	private int id ;
	private int type;
	private String content;
	private double price;
	private String mobile;
	private String createTime;
	private String txTime;
	private BigInteger goodsId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getTxTime() {
		return txTime;
	}
	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}
	public BigInteger getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(BigInteger goodsId) {
		this.goodsId = goodsId;
	}
	public PJzdy(int id, int type, String content, double price, String mobile, String createTime, String txTime,
			BigInteger goodsId) {
		super();
		this.id = id;
		this.type = type;
		this.content = content;
		this.price = price;
		this.mobile = mobile;
		this.createTime = createTime;
		this.txTime = txTime;
		this.goodsId = goodsId;
	}
	public PJzdy() {
		super();
	}
	
	
}

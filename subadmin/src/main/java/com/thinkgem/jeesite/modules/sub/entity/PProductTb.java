/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 商品表Entity
 * @author 邢宇
 * @version 2017-04-17
 */
public class PProductTb extends DataEntity<PProductTb> {
	
	private static final long serialVersionUID = 1L;
	private String title;		// 商品标题
	private String pictUrl;		// 商品主图
	private String reservePrice;		// 商品一口价格
	private String zkFinalPrice;		// 商品折扣价格
	private String userType;		// 卖家类型，0表示集市，1表示商城
	private String provcity;		// 宝贝所在地
	private String itemUrl;		// 商品地址
	private String nick;		// 卖家昵称
	private Long sellerId;		// 卖家id
	private String volume;		// 30天销量
	
	public PProductTb() {
		super();
	}

	public PProductTb(String id){
		super(id);
	}

	@Length(min=0, max=255, message="商品标题长度必须介于 0 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="商品主图长度必须介于 0 和 255 之间")
	public String getPictUrl() {
		return pictUrl;
	}

	public void setPictUrl(String pictUrl) {
		this.pictUrl = pictUrl;
	}
	
	@Length(min=0, max=255, message="商品一口价格长度必须介于 0 和 255 之间")
	public String getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(String reservePrice) {
		this.reservePrice = reservePrice;
	}
	
	@Length(min=0, max=255, message="商品折扣价格长度必须介于 0 和 255 之间")
	public String getZkFinalPrice() {
		return zkFinalPrice;
	}

	public void setZkFinalPrice(String zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}
	
	@Length(min=0, max=11, message="卖家类型，0表示集市，1表示商城长度必须介于 0 和 11 之间")
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Length(min=0, max=255, message="宝贝所在地长度必须介于 0 和 255 之间")
	public String getProvcity() {
		return provcity;
	}

	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	
	@Length(min=0, max=255, message="商品地址长度必须介于 0 和 255 之间")
	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	
	@Length(min=0, max=255, message="卖家昵称长度必须介于 0 和 255 之间")
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	
	@Length(min=0, max=11, message="30天销量长度必须介于 0 和 11 之间")
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
}
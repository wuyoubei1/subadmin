package com.thinkgem.jeesite.modules.sub.entity;

import java.math.BigInteger;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class PProductTb extends DataEntity<PProductTb> {

	private String id;
	private String title;
	private String picturl;
	private String resercePrice;
	private String zkFinalPrice;
	private int usertype;
	private String provcity;
	private String itemurl;
	private String nick;
	private BigInteger sellerId;
	private int volume;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicturl() {
		return picturl;
	}
	public void setPicturl(String picturl) {
		this.picturl = picturl;
	}
	public String getResercePrice() {
		return resercePrice;
	}
	public void setResercePrice(String resercePrice) {
		this.resercePrice = resercePrice;
	}
	public String getZkFinalPrice() {
		return zkFinalPrice;
	}
	public void setZkFinalPrice(String zkFinalPrice) {
		this.zkFinalPrice = zkFinalPrice;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getProvcity() {
		return provcity;
	}
	public void setProvcity(String provcity) {
		this.provcity = provcity;
	}
	public String getItemurl() {
		return itemurl;
	}
	public void setItemurl(String itemurl) {
		this.itemurl = itemurl;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public BigInteger getSellerId() {
		return sellerId;
	}
	public void setSellerId(BigInteger sellerId) {
		this.sellerId = sellerId;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public PProductTb(String id, String title, String picturl, String resercePrice, String zkFinalPrice, int usertype,
			String provcity, String itemurl, String nick, BigInteger sellerId, int volume) {
		super();
		this.id = id;
		this.title = title;
		this.picturl = picturl;
		this.resercePrice = resercePrice;
		this.zkFinalPrice = zkFinalPrice;
		this.usertype = usertype;
		this.provcity = provcity;
		this.itemurl = itemurl;
		this.nick = nick;
		this.sellerId = sellerId;
		this.volume = volume;
	}
	public PProductTb() {
		super();
	}
	public PProductTb(String id) {
		super(id);
	}
	
}

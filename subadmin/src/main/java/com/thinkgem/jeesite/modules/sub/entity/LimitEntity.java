package com.thinkgem.jeesite.modules.sub.entity;
/**
* 分页参数类
* 
* @author xingyu
* @version 2017年5月13日 
*/
public class LimitEntity {

	private String title;
	private int page;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public LimitEntity(String title, int page) {
		super();
		this.title = title;
		this.page = (page-1)*20;
	}
	
}

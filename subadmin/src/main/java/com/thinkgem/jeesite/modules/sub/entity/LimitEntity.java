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
	private String sort; //排序字段
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**每页条数**/
	private int pageSize=20;
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
		this.page = (page-1)*20;
	}
	public LimitEntity(String title, int page) {
		super();
		this.title = title;
		this.page = (page-1)*20;
	}
	public LimitEntity() {
		super();
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(0==pageSize){
			pageSize=20;
		}
		this.pageSize = pageSize;
	}
	
}

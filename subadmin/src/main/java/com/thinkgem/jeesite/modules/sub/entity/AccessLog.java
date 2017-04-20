/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 日志Entity
 * @author xingyu
 * @version 2017-04-20
 */
public class AccessLog extends DataEntity<AccessLog> {
	
	private static final long serialVersionUID = 1L;
	private String method;		// 访问方法名
	private String param;		// 访问方法参数
	private String mobile;		// 访问手机号
	private String nice;		// 用户昵称
	private String accessTime;		// 时间 yyyy-MM-dd HH:mm:ss  24小时制
	private String remark;		// 备注
	
	public AccessLog() {
		super();
	}

	public AccessLog(String id){
		super(id);
	}

	@Length(min=0, max=20, message="访问方法名长度必须介于 0 和 20 之间")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	@Length(min=0, max=64, message="访问方法参数长度必须介于 0 和 64 之间")
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	@Length(min=0, max=11, message="访问手机号长度必须介于 0 和 11 之间")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=64, message="用户昵称长度必须介于 0 和 64 之间")
	public String getNice() {
		return nice;
	}

	public void setNice(String nice) {
		this.nice = nice;
	}
	
	@Length(min=0, max=20, message="时间 yyyy-MM-dd HH:mm:ss  24小时制长度必须介于 0 和 20 之间")
	public String getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(String accessTime) {
		this.accessTime = accessTime;
	}
	
	@Length(min=0, max=128, message="备注长度必须介于 0 和 128 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
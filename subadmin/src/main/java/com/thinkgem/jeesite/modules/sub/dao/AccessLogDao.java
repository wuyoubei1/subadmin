/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.AccessLog;

/**
 * 日志DAO接口
 * @author xingyu
 * @version 2017-04-20
 */
@MyBatisDao
public interface AccessLogDao  {

	public void insert(AccessLog accessLog);

	public Page<AccessLog> findPage(Page<AccessLog> page, AccessLog accessLog);

	public AccessLog get(String id);

	public List<AccessLog> findList(AccessLog accessLog);

	public void delete(AccessLog accessLog);

}
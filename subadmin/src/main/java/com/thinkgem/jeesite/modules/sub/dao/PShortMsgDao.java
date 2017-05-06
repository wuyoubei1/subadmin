/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.PShortMsg;

/**
 * 日志DAO接口
 * @author xingyu
 * @version 2017-04-20
 */
@MyBatisDao
public interface PShortMsgDao  {

	public void insert(PShortMsg pShortMsg);

	public List<PShortMsg> findList(PShortMsg pShortMsg);

	public List<PShortMsg> check(PShortMsg pShortMsg);

}
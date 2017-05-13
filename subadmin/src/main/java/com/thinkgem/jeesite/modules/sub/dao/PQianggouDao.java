package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.LimitEntity;
import com.thinkgem.jeesite.modules.sub.entity.PQianggou;

/**
* 
* @author xingyu
* @version 2017年5月13日 
*/
@MyBatisDao
public interface PQianggouDao {

	public List<PQianggou> get(String numiid);
	
	public List<PQianggou> findList(LimitEntity le);
	
	public List<PQianggou> findListByTitle(LimitEntity le);
}

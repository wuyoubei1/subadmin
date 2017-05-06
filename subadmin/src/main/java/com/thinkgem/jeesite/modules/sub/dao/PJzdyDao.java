package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.PJzdy;

/**
* 
* @author xingyu
* @version 2017年5月3日 
*/
@MyBatisDao
public interface PJzdyDao {

	public void insert(PJzdy pJzdy);
	
	public List<PJzdy> findList(PJzdy pJzdy);
}

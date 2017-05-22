package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.LimitEntity;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;

/**
* 
* @author xingyu
* @version 2017年5月5日 
*/

@MyBatisDao
public interface YouHuiQuanDao {

	public List<YouHuiQuan> getByGoodsId(String goodsId);
	
	/***获取列表数据***/
	public List<YouHuiQuan> getList(LimitEntity limit);
	
	public List<YouHuiQuan> getListByTitle(LimitEntity limit);

	public List<YouHuiQuan> getListSort(LimitEntity limit);
}

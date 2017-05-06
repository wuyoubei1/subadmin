package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;

/**
* 
* @author xingyu
* @version 2017年5月5日 
*/

@MyBatisDao
public interface YouhuiQuanDao {

	public List<YouHuiQuan> getByGoodsId(String goodsId);
}

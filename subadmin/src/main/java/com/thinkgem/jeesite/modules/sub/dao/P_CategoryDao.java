package com.thinkgem.jeesite.modules.sub.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sub.entity.P_Category;

@MyBatisDao
public interface P_CategoryDao {

	/**
	 * 根据标题获取分类
	 * @param str
	 * @return
	 */
	public List<P_Category> getClassify(String str);
}

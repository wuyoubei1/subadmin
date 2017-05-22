package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sub.dao.YouHuiQuanDao;
import com.thinkgem.jeesite.modules.sub.entity.LimitEntity;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;

/**
* 
* @author xingyu
* @version 2017年5月13日 
*/
@Service
public class YouHuiQuanService {

	@Autowired
	private YouHuiQuanDao youHuiQuanDao;
	public List<YouHuiQuan> getList(String page,int pageSize){
		LimitEntity limit=new LimitEntity();
		limit.setPage(Integer.parseInt(page));
		limit.setPageSize(pageSize);
		return youHuiQuanDao.getList(limit);
	}
	
	public List<YouHuiQuan> getByGoodsId(String goodsId){
		return youHuiQuanDao.getByGoodsId(goodsId);
	}
	
	public List<YouHuiQuan> getListByTitle(String title,String page){
		LimitEntity limit=new LimitEntity(title, Integer.parseInt(page));
		return youHuiQuanDao.getListByTitle(limit);
	}

	public List<YouHuiQuan> getListSort(String key, String page, String sort) {
		LimitEntity limit=new LimitEntity();
		limit.setPage(Integer.parseInt(page));
		limit.setTitle(key);
		if("1".equals(sort)){
			limit.setSort("quan_surplus");
		}else if("2".equals(sort)){
			limit.setSort("quan_time desc");
		}else if("3".equals(sort)){
			limit.setSort("salesNum");
		}else if("4".equals(sort)){
			limit.setSort("orgPrice");
		}
		return youHuiQuanDao.getListSort(limit);
	}
}

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
	public List<YouHuiQuan> getList(int page){
		return youHuiQuanDao.getList(page);
	}
	
	public List<YouHuiQuan> getByGoodsId(String goodsId){
		return youHuiQuanDao.getByGoodsId(goodsId);
	}
	
	public List<YouHuiQuan> getListByTitle(String title,String page){
		LimitEntity le=new LimitEntity(title, Integer.parseInt(page));
		return youHuiQuanDao.getListByTitle(le);
	}
}

package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sub.dao.PQianggouDao;
import com.thinkgem.jeesite.modules.sub.entity.LimitEntity;
import com.thinkgem.jeesite.modules.sub.entity.PQianggou;

/**
* 
* @author xingyu
* @version 2017年5月13日 
*/
@Service
public class PQianggouService {

	@Autowired
	private PQianggouDao pQianggouDao;
	public List<PQianggou> get(String numiid){
		return pQianggouDao.get(numiid);
	}
	
	public List<PQianggou> findList(String page,Integer pageSize){
		LimitEntity le=new LimitEntity();
		le.setPage(Integer.parseInt(page));
		le.setPageSize(pageSize);
		return pQianggouDao.findList(le);
	}
	
	public List<PQianggou> findListByTitle(String title,String page){
		LimitEntity le=new LimitEntity(title, Integer.parseInt(page));
		return pQianggouDao.findListByTitle(le);
	}
}

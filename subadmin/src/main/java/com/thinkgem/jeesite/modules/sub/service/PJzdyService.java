package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sub.dao.PJzdyDao;
import com.thinkgem.jeesite.modules.sub.dao.YouHuiQuanDao;
import com.thinkgem.jeesite.modules.sub.entity.PJzdy;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;

/**
* 
* @author xingyu
* @version 2017年5月3日 
*/
@Service
public class PJzdyService {

	@Autowired
	private PJzdyDao pJzdyDao;
	
	@Autowired
	private YouHuiQuanDao quanDao;
	public void insert(PJzdy pJzdy){
		pJzdyDao.insert(pJzdy);
	}
	
	public List<PJzdy> findList(PJzdy pJzdy){
		return pJzdyDao.findList(pJzdy);
	}

	public List<YouHuiQuan> getGoods(String goodsId) {
		return quanDao.getByGoodsId(goodsId);
	}
}

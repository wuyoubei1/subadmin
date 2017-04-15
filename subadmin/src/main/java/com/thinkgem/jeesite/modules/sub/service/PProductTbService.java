package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sub.dao.PProductTbDao;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;

/**
 * 淘宝商品表Service
 * @author xingyu
 * @date 2017年4月13日
 */
@Service
@Transactional(readOnly=true)
public class PProductTbService extends CrudService<PProductTbDao,PProductTb> {

	public PProductTb get(String id){
		return super.get(id);
	}
	
	public List<PProductTb> findList(PProductTb pProductTb){
		return super.findList(pProductTb);
	}
}

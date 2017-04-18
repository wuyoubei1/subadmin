/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;
import com.thinkgem.jeesite.modules.sub.dao.PProductTbDao;

/**
 * 商品表Service
 * @author 邢宇
 * @version 2017-04-17
 */
@Service
@Transactional(readOnly = true)
public class PProductTbService extends CrudService<PProductTbDao, PProductTb> {

	public PProductTb get(String id) {
		return super.get(id);
	}
	
	public List<PProductTb> findList(PProductTb pProductTb) {
		return super.findList(pProductTb);
	}
	
	public Page<PProductTb> findPage(Page<PProductTb> page, PProductTb pProductTb) {
		return super.findPage(page, pProductTb);
	}
	
	@Transactional(readOnly = false)
	public void save(PProductTb pProductTb) {
		super.save(pProductTb);
	}
	
	@Transactional(readOnly = false)
	public void delete(PProductTb pProductTb) {
		super.delete(pProductTb);
	}
	
}
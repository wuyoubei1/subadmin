/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.modules.sub.dao.PShortMsgDao;
import com.thinkgem.jeesite.modules.sub.entity.PShortMsg;

/**
 * 验证码Service
 * @author xingyu
 * @version 2017-04-20
 */
@Service
@Transactional(readOnly = true)
public class PShortMsgService {

	@Autowired
	private PShortMsgDao pShortMsgDao;

	public List<PShortMsg> findList(PShortMsg pShortMsg) {
		return pShortMsgDao.findList(pShortMsg);
	}
	
	
	@Transactional(readOnly = false)
	public void insert(PShortMsg pShortMsg) {
		pShortMsgDao.insert(pShortMsg);
	}
	/**
	 * 生成验证码
	 * @return 
	 */
	public String createCode(){
		StringBuffer code=new StringBuffer();
		for (int i = 0; i < 6; i++) {
			code.append((int)(Math.random()*10)+"");
		}
		return code.toString();
	}
	/**
	 * 验证码验证
	 * @param msg
	 * @param mobile
	 * @return
	 */
	public String check(PShortMsg shortMsg) {
		List<PShortMsg> list=pShortMsgDao.check(shortMsg);
		if(list!=null&&list.size()>0){
			return list.get(0).getSendTime();
		}else{
			return "";
		}
	}
	public static void main(String[] args) {
		PShortMsgService s=new PShortMsgService();
		s.createCode();
	}

}
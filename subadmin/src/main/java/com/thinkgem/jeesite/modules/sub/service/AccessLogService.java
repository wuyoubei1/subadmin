/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sub.dao.AccessLogDao;
import com.thinkgem.jeesite.modules.sub.entity.AccessLog;

/**
 * 日志Service
 * @author xingyu
 * @version 2017-04-20
 */
@Service
@Transactional(readOnly = true)
public class AccessLogService {

	@Autowired
	private AccessLogDao accessLogDao;
	public AccessLog get(String id) {
		return accessLogDao.get(id);
	}
	
	public List<AccessLog> findList(AccessLog accessLog) {
		return accessLogDao.findList(accessLog);
	}
	
	public Page<AccessLog> findPage(Page<AccessLog> page, AccessLog accessLog) {
		return accessLogDao.findPage(page, accessLog);
	}
	
	@Transactional(readOnly = false)
	public void insert(AccessLog accessLog) {
		accessLogDao.insert(accessLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccessLog accessLog) {
		accessLogDao.delete(accessLog);
	}
	/**
	 * 日志
	 * @param request
	 * @param accessLog
	 */
	public void logForTable(HttpServletRequest request,@Param("accessLog") AccessLog accessLog){
		HttpSession session = request.getSession();
		List <AccessLog> list=(List<AccessLog>) session.getAttribute("logList");
		if(list!=null){
			if(list.size()>=1){
				this.logSave(list);
				list.clear();
			}
		}else{
			list=new ArrayList<AccessLog>();
		}
		list.add(accessLog);
		session.setAttribute("logList", list);
	}
	
	public synchronized void logSave(final List<AccessLog> list){
		if(list!=null&&list.size()>0){
			new Thread(){
				@Override
				public void run() {
					System.out.println("日志入库开始");
					for (AccessLog accessLog : list) {
						insert(accessLog);
					}
				}
			}.start();
		}
	}
}
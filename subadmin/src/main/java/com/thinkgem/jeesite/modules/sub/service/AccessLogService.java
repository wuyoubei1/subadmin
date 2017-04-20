/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
public class AccessLogService extends CrudService<AccessLogDao, AccessLog> {

	public AccessLog get(String id) {
		return super.get(id);
	}
	
	public List<AccessLog> findList(AccessLog accessLog) {
		return super.findList(accessLog);
	}
	
	public Page<AccessLog> findPage(Page<AccessLog> page, AccessLog accessLog) {
		return super.findPage(page, accessLog);
	}
	
	@Transactional(readOnly = false)
	public void save(AccessLog accessLog) {
		super.save(accessLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(AccessLog accessLog) {
		super.delete(accessLog);
	}
	/**
	 * 日志
	 * @param request
	 * @param accessLog
	 */
	public void logForTable(HttpServletRequest request,AccessLog accessLog){
		HttpSession session = request.getSession();
		List <AccessLog> list=(List<AccessLog>) session.getAttribute("logList");
		if(list!=null){
			if(list.size()>=20){
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
					for (AccessLog accessLog : list) {
						save(accessLog);
					}
				}
			}.start();
		}
	}
}
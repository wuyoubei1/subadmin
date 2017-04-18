/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.web.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;
import com.thinkgem.jeesite.modules.sub.service.PProductTbService;

/**
 * 商品表Controller
 * @author 邢宇 
 * @version 2017-04-17
 */
@Controller
@RequestMapping(value = "${frontPath}/sub/pProductTb")
public class PProductTbFrontController extends BaseController {

	@Autowired
	private PProductTbService pProductTbService;
	
	@RequestMapping(value="onejson")
	@ResponseBody
	public String getOneJson(HttpServletRequest request,@RequestParam String id){
		PProductTb pProductTb=pProductTbService.get(id);
		String result=null;
		if(pProductTb!=null){
			ObjectMapper om=new ObjectMapper();
			String callback=request.getParameter("callback");
			try {
				String json=om.writeValueAsString(pProductTb);
				result=callback+"("+json+")";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}			
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("alljson")
	@ResponseBody
	public String getAllJson(HttpServletRequest request,PProductTb pProductTb){
		List<PProductTb> list=pProductTbService.findList(pProductTb);
		String result=null;
		if(list!=null&&list.size()>0){
			ObjectMapper om=new ObjectMapper();
			String callback=request.getParameter("callback");
			try {
				String json=om.writeValueAsString(list);
				result=callback+"("+json+")";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

}
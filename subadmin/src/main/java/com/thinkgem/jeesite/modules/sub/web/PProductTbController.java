/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.web;

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
@RequestMapping(value = "${adminPath}/sub/pProductTb")
public class PProductTbController extends BaseController {

	@Autowired
	private PProductTbService pProductTbService;
	
	@ModelAttribute
	public PProductTb get(@RequestParam(required=false) String id) {
		PProductTb entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = pProductTbService.get(id);
		}
		if (entity == null){
			entity = new PProductTb();
		}
		return entity;
	}
	
	//@RequiresPermissions("sub:pProductTb:view")
	@RequestMapping(value = {"list", ""})
	public String list(PProductTb pProductTb, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PProductTb> page = pProductTbService.findPage(new Page<PProductTb>(request, response), pProductTb); 
		model.addAttribute("page", page);
		return "modules/sub/pProductTbList";
	}

	//@RequiresPermissions("sub:pProductTb:view")
	@RequestMapping(value = "form")
	public String form(PProductTb pProductTb, Model model) {
		model.addAttribute("pProductTb", pProductTb);
		return "modules/sub/pProductTbForm";
	}

	//@RequiresPermissions("sub:pProductTb:edit")
	@RequestMapping(value = "save")
	public String save(PProductTb pProductTb, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, pProductTb)){
			return form(pProductTb, model);
		}
		pProductTbService.save(pProductTb);
		addMessage(redirectAttributes, "保存保存商品成功成功");
		return "redirect:"+Global.getAdminPath()+"/sub/pProductTb/?repage";
	}
	
	//@RequiresPermissions("sub:pProductTb:edit")
	@RequestMapping(value = "delete")
	public String delete(PProductTb pProductTb, RedirectAttributes redirectAttributes) {
		pProductTbService.delete(pProductTb);
		addMessage(redirectAttributes, "删除保存商品成功成功");
		return "redirect:"+Global.getAdminPath()+"/sub/pProductTb/?repage";
	}
	
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
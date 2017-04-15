package com.thinkgem.jeesite.modules.sub.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;
import com.thinkgem.jeesite.modules.sub.service.PProductTbService;
/**
 * 淘宝商品表controller
 * @author xingyu
 * @date 2017年4月13日
 */
@Controller
@RequestMapping(value="${adminPath}/sub/pProductTb")
public class PProductTbController extends BaseController {

	@Autowired
	private PProductTbService pProductTbService;
	
	@RequestMapping(value="f_view")
 	public String toView(){
 		return "modules/sub/jsonTest";
 	}
	
	/*
	 * 根据ID获取单条数据并返回json串
	 */
	@RequestMapping(value="f_getTableOne")
	@ResponseBody
	public String get(@RequestParam(required=false) String id){
		PProductTb pProductTb=pProductTbService.get(id);
		ObjectMapper om= new ObjectMapper();
		String json;
		try {
			json = om.writeValueAsString(pProductTb);
			System.out.println(json);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	/*
	 * 获取全部数据
	 */
	@RequestMapping(value = "f_getTableAll")
	@ResponseBody
	public List<PProductTb> findList(PProductTb pProductTb){
		List<PProductTb> findList = pProductTbService.findList(pProductTb);
		if(findList!=null&&findList.size()>0){
			return findList;
		}else{
			return null;
		}
	}
	
}

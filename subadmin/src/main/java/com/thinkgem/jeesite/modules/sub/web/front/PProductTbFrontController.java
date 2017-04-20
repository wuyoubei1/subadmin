/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sub.web.front;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;
import com.thinkgem.jeesite.modules.sub.service.PProductTbService;

/**
 * 商品表Controller
 * @author 邢宇 
 * @version 2017-04-17
 */
@Controller
@RequestMapping(value = "${frontPath}/sub/pTb")
public class PProductTbFrontController extends BaseController {
	
	public static String url="http://gw.api.taobao.com/router/rest";
	
	public static String appkey="23760845";
	
	public static String secret="e5cf5879a13d0c453c3bb1a9bff4b861";

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
	
	@RequestMapping("getJson")
	@ResponseBody
	public String getJson(HttpServletRequest request,PProductTb pProductTb){
		String json="";
		ObjectMapper om=new ObjectMapper();
		List<PProductTb> list=pProductTbService.findList(pProductTb);
		try {
			json=om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return json;
	}
	
	/**
	 * 商品筛选接口 需要根据关键字查询商品 条件：关键字key 页面：pageNo
	 * @param request
	 * @param pProductTb
	 * @return
	 */
	@RequestMapping("spsx")
	@ResponseBody
	public String spsx(HttpServletRequest request,TbkItemGetRequest req){
		String json="";
		ObjectMapper om=new ObjectMapper();
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemGetResponse rsp;
		try {
			request.setCharacterEncoding("UTF-8");
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			json=om.writeValueAsString(rsp);
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		} catch (ApiException e1) {
			e1.printStackTrace();
		}catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}

}
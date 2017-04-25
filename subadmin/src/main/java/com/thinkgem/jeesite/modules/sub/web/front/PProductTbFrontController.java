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
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkJuTqgGetRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkJuTqgGetResponse;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sub.entity.AccessLog;
import com.thinkgem.jeesite.modules.sub.entity.PProductTb;
import com.thinkgem.jeesite.modules.sub.service.AccessLogService;
import com.thinkgem.jeesite.modules.sub.service.PProductTbService;
import com.thinkgem.jeesite.modules.sub.util.DateUtil;

/**
 * 商品表Controller
 * 
 * @author 邢宇
 * @version 2017-04-17
 */
@Controller
@RequestMapping(value = "${frontPath}/sub/pTb")
public class PProductTbFrontController extends BaseController {

	public static String url="http://gw.api.taobao.com/router/rest";
	
	public static String appkey="23760845";
	
	public static String secret="e5cf5879a13d0c453c3bb1a9bff4b861";
	
	public static Long adzoneId=80460157L;
	
	public static String pid="mm_10221473_23986300_80460157";
	
	private TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);

	@Autowired
	private PProductTbService pProductTbService;

	@Autowired
	private AccessLogService accessLogService;

	@RequestMapping(value = "onejson")
	@ResponseBody
	public String getOneJson(HttpServletRequest request, @RequestParam String id) {
		PProductTb pProductTb = pProductTbService.get(id);
		String result = null;
		if (pProductTb != null) {
			ObjectMapper om = new ObjectMapper();
			String callback = request.getParameter("callback");
			try {
				String json = om.writeValueAsString(pProductTb);
				result = callback + "(" + json + ")";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

	@RequestMapping("alljson")
	@ResponseBody
	public String getAllJson(HttpServletRequest request, PProductTb pProductTb) {
		List<PProductTb> list = pProductTbService.findList(pProductTb);
		String result = null;
		if (list != null && list.size() > 0) {
			ObjectMapper om = new ObjectMapper();
			String callback = request.getParameter("callback");
			try {
				String json = om.writeValueAsString(list);
				result = callback + "(" + json + ")";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}

	@RequestMapping("getJson")
	@ResponseBody
	public String getJson(HttpServletRequest request, PProductTb pProductTb) {
		String json = "";
		ObjectMapper om = new ObjectMapper();
		List<PProductTb> list = pProductTbService.findList(pProductTb);
		try {
			json = om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return json;
	}

	/**
	 * 商品筛选接口 需要根据关键字查询商品 条件：关键字key 页面：pageNo
	 * 
	 * @param request
	 * @param pProductTb
	 * @return
	 */
	@RequestMapping("spsx")
	@ResponseBody
	public String spsx(HttpServletRequest request, TbkItemGetRequest req) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e3) {
			e3.printStackTrace();
		}
		String json = "";
		ObjectMapper om = new ObjectMapper();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setPageSize(Long.parseLong("20"));
		TbkItemGetResponse rsp;
		AccessLog accessLog = new AccessLog();
		accessLog.setAccessTime(DateUtil.getNow());
		accessLog.setMethod(this.getClass().getName());
		try {
			if(null!=request.getParameter("nice")){
				accessLog.setNice(new String(request.getParameter("nice").getBytes("iso-8859-1"),"utf-8"));
			}
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		System.out.println(request.getCharacterEncoding());
		System.out.println(accessLog.getNice());
		accessLog.setMobile(request.getParameter("mobile"));
		accessLog.setRemark("测试数据");
		accessLog.setParam(request.toString());
		accessLogService.logForTable(request, accessLog);
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			json = om.writeValueAsString(rsp);
		} catch (ApiException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 *商品详情
	 * wuyb
	 * @param request
	 * @param pProductTb
	 * @return
	 */
	@RequestMapping("dt")
	@ResponseBody
	public String detail(HttpServletRequest request, TbkItemInfoGetRequest req) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e3) {
			e3.printStackTrace();
		}
		
		ObjectMapper om = new ObjectMapper();
		String json = "";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		//req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setPlatform(1L);
		try {
			TbkItemInfoGetResponse rsp = client.execute(req);
			System.out.println(rsp.getBody());
			json = om.writeValueAsString(rsp);
		} catch (ApiException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		this.logRecord(request);
		return json;
	}

	/**
	 * 获取淘抢购的数据
	 * @return
	 */
	@RequestMapping(value="tqgsj")
	@ResponseBody
	public String tqgsj(HttpServletRequest request,TbkJuTqgGetRequest req){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e3) {
			e3.printStackTrace();
		}
		String json = "";
		req.setAdzoneId(adzoneId);
		req.setFields("click_url,pic_url,reserve_price,zk_final_price,total_amount,sold_num,title,category_name,start_time,end_time");
		req.setPageSize(40L);
		TbkJuTqgGetResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			json = rsp.getBody();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		this.logRecord(request);
		return json;
	}
	
	@RequestMapping(value="jhssj")
	@ResponseBody
	public String jhssj(HttpServletRequest request,TopItemQuery itemQuery){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e3) {
			e3.printStackTrace();
		}
		String json = "";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		itemQuery.setCurrentPage(1L);
		itemQuery.setPageSize(20L);
		itemQuery.setPid(pid);
		itemQuery.setPostage(true);
		itemQuery.setStatus(2L);
		//obj1.setTaobaoCategoryId(1000L);
		itemQuery.setWord("毛衣");
		req.setParamTopItemQuery(itemQuery);
		JuItemsSearchResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			json=rsp.getBody();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 日志记录
	 * @param request
	 */
	public void logRecord(HttpServletRequest request){
		AccessLog accessLog = new AccessLog();
		accessLog.setAccessTime(DateUtil.getNow());
		accessLog.setMethod(this.getClass().getName());
		try {
			if(null!=request.getParameter("nice")){
				accessLog.setNice(new String(request.getParameter("nice").getBytes("iso-8859-1"),"utf-8"));
			}
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		accessLog.setMobile(request.getParameter("mobile"));
		accessLog.setRemark("测试数据");
		accessLog.setParam(request.toString());
		accessLogService.logForTable(request, accessLog);
	}
}
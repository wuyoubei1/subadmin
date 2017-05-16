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
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.modules.sub.entity.PJzdy;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;
import com.thinkgem.jeesite.modules.sub.service.PJzdyService;
import com.thinkgem.jeesite.modules.sub.util.TestTKJDJob;

/**
* 
* @author xingyu
* @version 2017年5月3日 
*/
@Controller
@RequestMapping(value="${frontPath}/sub/jzdy")
public class PJzdyController {

	@Autowired
	private PJzdyService pJzdyService;
	
	/**
	 * 新增精准订阅信息
	 * @param request
	 * @param pJzdy
	 * @return
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public String insert(HttpServletRequest request,PJzdy pJzdy){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		pJzdy.setCreateTime(DateUtils.getDate("yyyy-MM-dd HH:mm:ss"));
		//pJzdy.setTxTime(DateUtils.getDate());
		pJzdyService.insert(pJzdy);
		return "0";
	}
	
	/**
	 * 获取优惠商品
	 * @param goodsid 商品id
	 * @return
	 */
	@RequestMapping(value="goods")
	@ResponseBody
	public String goodsById(@RequestParam String goodsId){
		List<YouHuiQuan> list=pJzdyService.getGoods(goodsId);
		ObjectMapper om=new ObjectMapper();
		String data="";
		if(list!=null&&list.size()>0){
			try {
				data=om.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	/**
	 * 根据短连接获取商品id
	 * @param url
	 * @return
	 */
	@RequestMapping(value="url")
	@ResponseBody
	public String getLongUrl(@RequestParam String url){
		String id="";
		if(url!=null&&!"".equals(url)){
			id=TestTKJDJob.synJob(url);
		}
		return id;
	}
}

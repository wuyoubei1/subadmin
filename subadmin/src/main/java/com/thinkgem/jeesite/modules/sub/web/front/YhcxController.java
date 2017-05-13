package com.thinkgem.jeesite.modules.sub.web.front;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;
import com.thinkgem.jeesite.modules.sub.service.YouHuiQuanService;

/**
* 优惠查询controller
* @author xingyu
* @version 2017年5月13日 
*/
@Controller
@RequestMapping(value="${frontPath}/sub/yhcx")
public class YhcxController {

	@Autowired
	private YouHuiQuanService youHuiQuanService;
	/**
	 * 获取优惠券信息
	 * @param page
	 * @return
	 */
	@RequestMapping(value="data")
	@ResponseBody
	public String getData(@RequestParam String key,@RequestParam String page,HttpServletRequest request){
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if(page==null||page==""||"0".equals(page)){
			page=1+"";
		}
		List<YouHuiQuan> list =new ArrayList<YouHuiQuan>();
		ObjectMapper om=new ObjectMapper();
		String data="";
		if(null!=key&&!"".equals(key)){//没有关键字或id
			try {
				key=new String(key.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(key.matches("^[0-9]*[1-9][0-9]*$")&&15>key.length()&&key.length()>8){//为数字并且位数小于15大于8，认为是商品id
				list=youHuiQuanService.getByGoodsId(key);
			}else{
				//关键字
				list=youHuiQuanService.getListByTitle(key, page);
			}
		}else{
			list=youHuiQuanService.getList(Integer.parseInt(page));
		}
		try {
			data=om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return data;
		
	}
}

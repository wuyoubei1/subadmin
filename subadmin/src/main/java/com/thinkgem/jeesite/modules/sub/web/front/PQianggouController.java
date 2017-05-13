package com.thinkgem.jeesite.modules.sub.web.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.modules.sub.entity.PQianggou;
import com.thinkgem.jeesite.modules.sub.service.PQianggouService;

/**
* 
* @author xingyu
* @version 2017年5月13日 
*/
@Controller
@RequestMapping(value="${frontPath}/sub/tqg")
public class PQianggouController {

	@Autowired
	private PQianggouService pQianggouService;
	
	@RequestMapping(value="data")
	@ResponseBody
	public String getData(@RequestParam String key,@RequestParam String page){
		if(page==null||page.equals("")||Integer.parseInt(page)<=0){
			page="1";
		}
		String data="";
		ObjectMapper om=new ObjectMapper();
		List<PQianggou> list=new ArrayList<PQianggou>();
		if(key!=null&&!"".equals(key)){
			if(key.matches("^[0-9]*[1-9][0-9]*$")&&15>key.length()&&key.length()>8){
				list=pQianggouService.get(key);
			}else{
				list=pQianggouService.findListByTitle(key, page);
			}
		}else{
			list=pQianggouService.findList(page);
		}
		try {
			data=om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return data;
	}
}

package com.thinkgem.jeesite.modules.sub.web.front;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sub.entity.PShortMsg;
import com.thinkgem.jeesite.modules.sub.service.PShortMsgService;
import com.thinkgem.jeesite.modules.sub.util.DateUtil;

/**
 * 短信验证码+短信提醒
 * @author wuyb
 *
 */
@Controller
@RequestMapping(value="${frontPath}/sub/shortmsg")
public class ShortMsgController extends BaseController {
	
public static String url="http://gw.api.taobao.com/router/rest";
	
	/**
	 * 短信验证码专用
	 */
	public static String appkey="23765976";
	
	/**
	 * 短信验证码专用
	 */
	public static String secret="91e4df782367baad6abaf04a5181cacf";
	
	@Autowired
	private PShortMsgService msgService;

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		ShortMsgController controller=new ShortMsgController();
		controller.getverificationCode("18511588849");
	}
	/**
	 * 验证码
	 * @param mobile
	 * @return
	 */
	
	@RequestMapping(value="gv")
	@ResponseBody
	public String getverificationCode(@RequestParam String mobile){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		ObjectMapper mapper=new ObjectMapper();
		Map<String,String> map=new HashMap<String, String>();
		String data=null;
		String msg=msgService.createCode();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("券购365");//签名
		req.setSmsParamString("{\"code\":\""+msg+"\"}");//短信模板变量
		req.setRecNum(mobile);
		req.setSmsTemplateCode("SMS_63140066");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		PShortMsg psm=new PShortMsg();
		psm.setMobile(mobile);
		psm.setMsg(msg);
		psm.setType(0);
		psm.setSendTime(DateUtil.getNow());
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			map.put("message", "发送成功，请注意接收！！");
		} catch (ApiException e) {
			e.printStackTrace();
			psm.setStatus(1);
			map.put("message", "发送失败，请重新尝试获取！！");
		}
		try {
			data=mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		msgService.insert(psm);
		return data;
	}
	//在此类中增加，接收手机号，发送短信验证码的功能，验证码为随机生成的6位数字，具体设计看设计文档
	/**
	 * 验证码验证
	 * @param msg
	 * @param mobile
	 * @return
	 */
	@RequestMapping(value="check")
	@ResponseBody
	public String check(@RequestParam String msg,@RequestParam String mobile){
		String data="";
		PShortMsg shortMsg=new PShortMsg();
		shortMsg.setMobile(mobile);
		shortMsg.setMsg(msg);
		String datetime=msgService.check(shortMsg);
		if(datetime!=null){
			Date now=new Date();
			long time=(now.getTime()-DateUtil.toDate(datetime).getTime())/1000;
			if(time>300){
				data="0";
			}else{
				data="1";
			}
		}else{
			data="2";
		}
		return data;
	}
}

package com.thinkgem.jeesite.modules.sub.web.front;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 短信验证码+短信提醒
 * @author wuyb
 *
 */
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

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("券购365");//签名
		req.setSmsParamString("{\"code\":\"金迎春+吴禹璇\"}");//短信模板变量
		req.setRecNum("18610151061");
		req.setSmsTemplateCode("SMS_63140066");
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}

	}
	
	//在此类中增加，接收手机号，发送短信验证码的功能，验证码为随机生成的6位数字，具体设计看设计文档

}

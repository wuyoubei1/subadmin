package com.thinkgem.jeesite.modules.sub.util;

import java.text.ParseException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 淘客链接提取商品ID
 * @author wuyb
 *
 */
public class TestTKJDJob extends ParentYhyJob{

	private static Log log=LogFactory.getLog(TestTKJDJob.class);
	
	/***淘宝短连接***/
	
	private static int page = 1;
	
	public static String synJob(String url) {
		String json = httpGetRequest(url.replace("[page]", page + ""));
		System.out.println(json);
		String j1=json.substring(json.indexOf("id="));
		String j2=j1.substring(3, j1.indexOf("&"));
		log.info(" 提取的商品ID= "+j2);
		return j2;
	}

	public static void main(String[] args) throws ParseException {
	//	private String url = "http://c.b0yp.com/h.6f2UJx?cv=VRN6HdKVVf&sm=7fdec9";
		TestTKJDJob b = new TestTKJDJob();
		b.synJob("http://c.b0yp.com/h.6f2UJx?cv=VRN6HdKVVf&sm=7fdec9");
	}
}

package com.thinkgem.jeesite.modules.sub.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 日期工具类
* @author xingyu
* @version 2017年4月20日 
*/
public class DateUtil {

	public static String getNow(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
		return df.format(new Date());
	}
	
	public static void main(String[] args) {
		DateUtil dateUtil=new DateUtil();
		dateUtil.getNow();
	}
}

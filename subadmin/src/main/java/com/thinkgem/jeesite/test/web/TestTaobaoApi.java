package com.thinkgem.jeesite.test.web;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.internal.util.StringUtils;
import com.taobao.api.request.JuItemsSearchRequest;
import com.taobao.api.request.JuItemsSearchRequest.TopItemQuery;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkJuTqgGetRequest;
import com.taobao.api.response.JuItemsSearchResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkJuTqgGetResponse;


/**
* 
* @author xingyu
* @version 2017年4月18日 
*/
public class TestTaobaoApi  {

	public static String url="http://gw.api.taobao.com/router/rest";
	
	public static String appkey="23760845";
	
	public static String secret="e5cf5879a13d0c453c3bb1a9bff4b861";
	
	public static Long adzoneId=80460157L;
	
	public static String pid="mm_10221473_23986300_80460157";
	
	/**
	 * 淘宝商品数据
	 * @return
	 */
	public String getdata(){ 
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setQ("女装");
	//	req.setCat("16,18");
		req.setItemloc("杭州");
//		req.setSort("tk_rate_des");
//		req.setIsTmall(false);
//		req.setIsOverseas(false);
//		req.setStartPrice(10L);
//		req.setEndPrice(1000L);
//		req.setStartTkRate(123L);
//		req.setEndTkRate(123L);
//		req.setPlatform(1L);
		req.setPageNo(1L);
		req.setPageSize(20L);
		TbkItemGetResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println("======"+rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 淘抢购数据、
	 * @return
	 */
	public String getData2(){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkJuTqgGetRequest req = new TbkJuTqgGetRequest();
		req.setAdzoneId(adzoneId);
		req.setFields("click_url,pic_url,reserve_price,zk_final_price,total_amount,sold_num,title,category_name,start_time,end_time");
		req.setStartTime(StringUtils.parseDateTime("2016-08-09 09:00:00"));
		req.setEndTime(StringUtils.parseDateTime("2016-08-09 16:00:00"));
		req.setPageNo(1L);
		req.setPageSize(40L);
		TbkJuTqgGetResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 搜索聚划算商品
	 * @return
	 */
	public String getData3(){
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		JuItemsSearchRequest req = new JuItemsSearchRequest();
		TopItemQuery obj1 = new TopItemQuery();
		obj1.setCurrentPage(1L);
		obj1.setPageSize(20L);
		obj1.setPid(pid);
		obj1.setPostage(true);
		obj1.setStatus(2L);
		//obj1.setTaobaoCategoryId(1000L);
		obj1.setWord("毛衣");
		req.setParamTopItemQuery(obj1);
		JuItemsSearchResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		TestTaobaoApi aa=new TestTaobaoApi();
		aa.getdata();
		System.out.println("++++++++++++++++");
		String json=aa.getData3();
	}
}

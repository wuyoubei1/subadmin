package com.thinkgem.jeesite.modules.sub.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sub.dao.P_CategoryDao;
import com.thinkgem.jeesite.modules.sub.dao.PJzdyDao;
import com.thinkgem.jeesite.modules.sub.dao.YouHuiQuanDao;
import com.thinkgem.jeesite.modules.sub.entity.P_Category;
import com.thinkgem.jeesite.modules.sub.entity.PJzdy;
import com.thinkgem.jeesite.modules.sub.entity.YouHuiQuan;

/**
* 
* @author xingyu
* @version 2017年5月3日 
*/
@Service
public class PJzdyService {

	@Autowired
	private PJzdyDao pJzdyDao;
	@Autowired
	private P_CategoryDao pCategoryDao;
	
	@Autowired
	private YouHuiQuanDao quanDao;
	
	public void insert(PJzdy pJzdy){
		pJzdyDao.insert(pJzdy);
	}
	
	public List<PJzdy> findList(PJzdy pJzdy){
		return pJzdyDao.findList(pJzdy);
	}

	public List<YouHuiQuan> getGoods(String goodsId) {
		return quanDao.getByGoodsId(goodsId);
	}

	public List<P_Category> getClassify(String str) {
		return pCategoryDao.getClassify(str);
	}
	/**
	 * 将结果集进行去重
	 * @param list
	 * @return
	 */
	public List<YouHuiQuan> mySort(List<YouHuiQuan> list){
	      HashMap<Integer,YouHuiQuan> tempMap = new HashMap<>();
	      for (YouHuiQuan youHuiQuan : list) {
	        int key = (int) youHuiQuan.getGoodsId();
	        if(!tempMap.containsKey(key)){
	        	//HashMap是不允许key重复的，所以如果有key重复的话，那么前面的value会被后面的value覆盖         
	        	tempMap.put(key, youHuiQuan);
	        }
	      }
	      List<YouHuiQuan> tempList = new ArrayList<YouHuiQuan>();
	      for(int key : tempMap.keySet()){
	        tempList.add(tempMap.get(key));
	      }
	      return tempList;
	  }
}

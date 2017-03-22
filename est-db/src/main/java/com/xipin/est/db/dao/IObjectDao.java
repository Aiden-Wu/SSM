package com.xipin.est.db.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.LogIDBean;

@Repository
public interface IObjectDao {
	
	/**
	 * 
	 * 方法用途: 获取对象<br>
	 * 实现步骤: <br>
	 * @param map
	 * @return
	 */
	Map<String, Object> get(LogIDBean logIDBean);

}

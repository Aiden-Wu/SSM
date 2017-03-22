package com.xipin.est.db.cache;

import java.util.List;
import java.util.Set;

public interface ICommSetCache {

	/**
	 * 保存Set<String> 到redis缓存中
	 * @param key
	 * @param val
	 */
	void set(String key, Set<byte[]> val);


	/**
	 * 查看缓存中是否存在该数据
	 * 
	 * @param key
	 * @return
	 */
	boolean exists(String key, String val);

	/**
	 * 从缓存中删除该数据
	 * 
	 * @param key
	 */
	void delete(String key, String val);


	Set<byte[]> get(String key);


	void setOne(String key, String val);


	void delete(String key, List<byte[]> val);
	
}

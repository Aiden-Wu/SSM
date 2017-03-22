package com.xipin.est.db.cache;

import java.util.List;

public interface ICommCollectCache {

	/**
	 * 保存List<String> 到redis缓存中
	 * @param key
	 * @param val
	 */
	void set(String key, List<String> val);

	/**
	 * 获取List<String>从redis缓存中
	 * 
	 * @param key
	 * @return
	 */
	List<String> get(String key);

	/**
	 * 查看缓存中是否存在该数据
	 * 
	 * @param key
	 * @return
	 */
	boolean exists(String key);

	/**
	 * 从缓存中删除该数据
	 * 
	 * @param key
	 */
	void delete(String key);
}

package com.xipin.est.db.cache;

import com.xipin.est.model.Model;


public interface ICommObjectCache {
	/**
	 * 保存byte[] 到redis缓存中
	 * 
	 * @param key
	 *            String
	 * @param val
	 *            byte[]
	 */
	void set(String key, Model bean);

	/**
	 * 获取byte[] 从redis缓存中
	 * 
	 * @param key
	 * @return
	 */
	 Model get(String key);

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

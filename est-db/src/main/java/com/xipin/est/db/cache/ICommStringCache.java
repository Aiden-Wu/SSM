package com.xipin.est.db.cache;

import java.util.List;
import java.util.Map;

public interface ICommStringCache {

	/**
	 * 添加字符串缓存数据
	 * 
	 * @param key
	 * @param val
	 * @param time 秒
	 */
	void set(String key, String val, Long time);

	void set(Map<String, String> map);

	void delete(String key);

	void delete(List<String> keys);

	String get(String key);

	boolean exists(String key);

	Long incr(String key, Long time);

	void set(String key, String val);

	String getAndSet(String key, String value, Long time);
	
	/**
	 * 设置key过期时间
	 * @param key
	 * @param time s/秒
	 */
	void expire(final String key, final Long time);
}

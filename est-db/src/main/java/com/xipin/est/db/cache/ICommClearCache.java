package com.xipin.est.db.cache;

import java.util.List;

/**
 * 查看、清除满足特定正则表达式的redis缓存
 * 
 * @author Administrator
 *
 */
public interface ICommClearCache {
	/**
	 * 查看特定正则表达式的redis缓存key
	 * 
	 * @param pattern
	 * @return
	 */
	List<String> getKeys(String pattern);

	/**
	 * 清除满足特定正则表达式的redis缓存
	 * 
	 * @param keys
	 */
	void clear(List<String> keys);

	/**
	 * 清除特定key的redis缓存
	 * 
	 * @param key
	 */
	void delete(String key);
}

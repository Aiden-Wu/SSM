package com.xipin.est.db.cache.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.cache.ICommClearCache;
import com.xipin.est.db.cache.RedisBase;

/**
 * 主从时请勿使用
 * @author danny duan
 *
 */
@Repository
public class CommClearCache extends RedisBase<String, String> implements ICommClearCache {

	@Override
	public List<String> getKeys(final String pattern) {
		List<String> keys = redisTemplate.execute(new RedisCallback<List<String>>() {
			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				Set<String> set = (Set<String>) strConn.keys(pattern);
				return new ArrayList<String>(set);
			}

		});
		return keys;
	}

	@Override
	public void delete(final String key) {
		redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				System.out.println(strConn.get(key));
				strConn.del(key);
				System.out.println(strConn.exists(key));
				return true;
			}

		});
	}

	@Override
	public void clear(final List<String> keys) {
		redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				String[] kArr = (String[]) keys.toArray();
				strConn.del(kArr);
				return true;
			}

		});
	}
}

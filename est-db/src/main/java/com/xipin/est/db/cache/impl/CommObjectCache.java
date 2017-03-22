package com.xipin.est.db.cache.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.cache.ICommObjectCache;
import com.xipin.est.db.cache.RedisBase;
import com.xipin.est.model.Model;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

@Repository
public class CommObjectCache extends RedisBase<String, String> implements ICommObjectCache {

	@Override
	public void set(final String key, final Model bean) {
		redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(key.getBytes(), ObjectSerializeUtils.serializeObject(bean));
				return null;
			}

		});
	}

	@Override
	public Model get(final String key) {
		byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.get(key.getBytes());
			}

		});
		return (Model) ObjectSerializeUtils.deserializeObject(result);
	}

	@Override
	public boolean exists(final String key) {
		Boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.exists(key.getBytes());
			}

		});
		return result;
	}

	@Override
	public void delete(final String key) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del(key.getBytes());
				return null;
			}
		});
	}

}

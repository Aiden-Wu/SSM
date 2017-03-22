package com.xipin.est.db.cache.impl;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.cache.ICommSetCache;
import com.xipin.est.db.cache.RedisBase;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

@Repository
public class CommSetCache extends RedisBase<String, String> implements ICommSetCache{

	@Override
	public void set(final String key, final Set<byte[]> val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.sAdd(ObjectSerializeUtils.serializeObject(key), val.toArray(new byte[][]{}));
				return true;
			}
		});
	}

	@Override
	public void setOne(final String key, final String val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.sAdd(ObjectSerializeUtils.serializeObject(key), ObjectSerializeUtils.serializeObject(val));
				return true;
			}
		});
	}
	
	@Override
	public Set<byte[]> get(final String key) {
		Set<byte[]> set = redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.sMembers(ObjectSerializeUtils.serializeObject(key));
			}
		});
		return set;
	}

	@Override
	public void delete(final String key, final String val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.sRem(ObjectSerializeUtils.serializeObject(key), ObjectSerializeUtils.serializeObject(val));
				return true;
			}
		});
	}

	@Override
	public void delete(final String key, final List<byte[]> val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.sRem(ObjectSerializeUtils.serializeObject(key), val.toArray(new byte[][]{}));
				return true;
			}
		});
	}

	@Override
	public boolean exists(final String key, final String val) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.sIsMember(ObjectSerializeUtils.serializeObject(key), ObjectSerializeUtils.serializeObject(val));
			}
		});
	}

}

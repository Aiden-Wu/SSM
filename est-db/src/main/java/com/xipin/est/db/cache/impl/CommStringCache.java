package com.xipin.est.db.cache.impl;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.cache.ICommStringCache;
import com.xipin.est.db.cache.RedisBase;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

@Repository
public class CommStringCache extends RedisBase<String, String> implements ICommStringCache {

	@Override
	public void set(final String key, final String val, final Long time) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.pSetEx(ObjectSerializeUtils.serializeObject(key), time * 1000, ObjectSerializeUtils.serializeObject(val));
				return true;
			}
		});
	}
	
	@Override
	public void set(final String key, final String val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(ObjectSerializeUtils.serializeObject(key), ObjectSerializeUtils.serializeObject(val));
				return true;
			}
		});
	}

	/**
	 * 主从时请勿请勿使用，后果自负
	 */
	@Override
	public void set(final Map<String, String> map) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				strConn.mSetString(map);
				return true;
			}
		});
	}

	@Override
	public void delete(final String key) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del(ObjectSerializeUtils.serializeObject(key));
				return true;
			}
		});
	}

	/**
	 * 主从时请勿请勿使用，后果自负
	 */
	@Override
	public void delete(final List<String> keys) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				String[] keyArr = (String[]) keys.toArray();
				strConn.del(keyArr);
				return true;
			}
		});
	}

	@Override
	public String get(final String key) {
		if(StringUtils.isEmpty(key)){
			return "";
		}
		String result = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				byte[] barr = connection.get(ObjectSerializeUtils.serializeObject(key));
				if(barr == null){
					return "";
				}
				return (String)ObjectSerializeUtils.deserializeObject(barr);
			}
		});
		return result;
	}

	@Override
	public boolean exists(final String key) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.exists(ObjectSerializeUtils.serializeObject(key));
			}
		});
		return result;
	}

	/**
	 * time s
	 */
	@Override
	public Long incr(final String key, final Long time) {
		Long rslt = redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				long val = connection.incr(ObjectSerializeUtils.serializeObject(key));
				if (time != null) {
					connection.expire(ObjectSerializeUtils.serializeObject(key), time);
				}
				return val;
			}
		});
		return rslt;
	}

	@Override
	public String getAndSet(final String key, final String value, final Long time) {
		String rslt = redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection) throws DataAccessException {
				String str = (String)ObjectSerializeUtils.deserializeObject(connection.get(ObjectSerializeUtils.serializeObject(key)));
				if(StringUtils.isEmpty(str)){
					connection.set(ObjectSerializeUtils.serializeObject(key), ObjectSerializeUtils.serializeObject(value));
					connection.expire(ObjectSerializeUtils.serializeObject(key), time);
				}
				return str;
			}
		});
		return rslt;
	}

	@Override
	public void expire(final String key, final Long time) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				connection.expire(ObjectSerializeUtils.serializeObject(key), time);
				return true;
			}
		});
	}
}

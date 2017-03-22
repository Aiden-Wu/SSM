package com.xipin.est.db.cache.impl;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.cache.ICommCollectCache;
import com.xipin.est.db.cache.RedisBase;
import com.xipin.est.utils.serialize.ConnectionSerializeUtils;

/**
 * 主从时请勿使用
 * @author danny duan
 *
 */
@Repository
public class CommCollectCache extends RedisBase<String, String> implements ICommCollectCache {

	@Override
	public void set(final String key, final List<String> val) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				strConn.set(key.getBytes(), ConnectionSerializeUtils.serializeConnection(val));
				return true;
			}
		});
	}

	@Override
	public List<String> get(final String key) {
		byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				return strConn.get(key.getBytes());
			}
		});
		return deserializeObject(result);
	}

	@Override
	public boolean exists(final String key) {
		boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				return strConn.exists(key.getBytes());
			}
		});
		return result;
	}

	@Override
	public void delete(final String key) {
		redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				StringRedisConnection strConn = (StringRedisConnection) connection;
				strConn.del(key.getBytes());
				return true;
			}
		});

	}

	private List<String> deserializeObject(byte[] b) {
		if (b == null) {
			return null;
		}
		List<String> list = new ArrayList<>();
		ByteArrayInputStream ba = null;
		ObjectInputStream oi = null;
		try {
			ba = new ByteArrayInputStream(b);
			oi = new ObjectInputStream(ba);

			while (true) {
				String s = (String) oi.readObject();
				if (s == null) {
					break;
				}
				list.add(s);
			}
			ba.close();
			oi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

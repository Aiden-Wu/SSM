package com.xipin.est.utils.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializeUtils {
	public static byte[] serializeObject(Object obj) {
		if (obj == null) {
			return null;
		}
		byte[] b = null;
		ByteArrayOutputStream ba = null;
		ObjectOutputStream os = null;
		try {
			ba = new ByteArrayOutputStream();
			os = new ObjectOutputStream(ba);
			os.writeObject(obj);
			os.writeObject(null);
			os.close();
			ba.close();
			b = ba.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	/***
	 * 不通用 ， 目前留着测试用
	 * 
	 * @param b
	 * @return
	 */
	public static Object deserializeObject(byte[] b) {
		if(b == null){
			return null;
		}
		if (b.length <=0) {
			return null;
		}
		Object obj = new Object();
		ByteArrayInputStream ba = null;
		ObjectInputStream oi = null;
		try {
			ba = new ByteArrayInputStream(b);
			oi = new ObjectInputStream(ba);
			obj = oi.readObject();
			ba.close();
			oi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}

package com.xipin.est.utils.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ConnectionSerializeUtils {
	public static byte[] serializeConnection(List<String> list) {
		if (list == null) {
			return null;
		}
		byte[] b = null;
		ByteArrayOutputStream ba = null;
		ObjectOutputStream os = null;
		try {
			ba = new ByteArrayOutputStream();
			os = new ObjectOutputStream(ba);
			for (String s : list) {
				os.writeObject(s);
			}
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
	public static List<String> deserializeConnection(byte[] b) {
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

	public static List<String> getTestData() {
		List<String> list = new ArrayList<String>();
		list.add("list");
		list.add("集合");
		list.add("close");
		return list;
	}

	public static void main(String[] args) {
		List<String> list = getTestData();
		byte[] b = serializeConnection(list);
		System.out.println(b.toString());
		List<String> t = deserializeConnection(b);
		System.out.println(t);
	}
}

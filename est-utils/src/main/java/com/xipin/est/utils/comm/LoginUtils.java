package com.xipin.est.utils.comm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class LoginUtils {
	
	/**
	 * 生成4位的随机数作为盐
	 * @return
	 */
	public static String generateSalt(){
		Random random = new Random();
		int salt = random.nextInt(9000) + 1000;
		return salt+"";
	}
	
	/**
	 * 生成sessionId
	 * @param userName
	 * @return    
	 * @return String    返回类型
	 *
	 */
	public static String generateSessionId(String userName){
		SimpleDateFormat sdf = new SimpleDateFormat("YYMMddHHmmss");
		String s = sdf.format(new Date());
		int max=9999;
	    int min=1000;
	    int n= new Random().nextInt(max - min) + min;
	    return  NMD5.passwordEncode(s+n, userName);
	}

}

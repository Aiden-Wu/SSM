package com.xipin.est.utils.comm;

public class CheckEmptyUtils {
	
	public static boolean checkNotEmpty(Long data) {
		if(data != null && data > 0){
			return true;
		}
		return false;
	}
	
}

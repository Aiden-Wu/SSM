package com.xipin.est.utils.rslt.code;

public enum ResultStatusCode {
	成功("1"),
	请求参数错误("-1"),
	系统错误("-2"),
	数据错误("-3"),
	权限不足("-4"),
	未知错误("-5"),
	登录超时("-6"),
	非法请求("-7");
	
	private ResultStatusCode(String code){
		this.code = code;
	}
	
	private String code;

	public String getCode() {
		return code;
	}

}

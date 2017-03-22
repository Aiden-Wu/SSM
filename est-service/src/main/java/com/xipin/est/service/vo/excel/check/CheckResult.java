package com.xipin.est.service.vo.excel.check;

public class CheckResult {

	private String msg;
	private String sign;
	private Short type;
	private String id;

	public CheckResult() {
	}

	public CheckResult(Short type, String sign, String msg) {
		this.msg = msg;
		this.type = type;
		this.sign = sign;
	}

	public CheckResult(Short type, String sign, String msg, String id) {
		this.msg = msg;
		this.type = type;
		this.sign = sign;
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

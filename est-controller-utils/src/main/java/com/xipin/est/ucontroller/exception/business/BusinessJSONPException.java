package com.xipin.est.ucontroller.exception.business;

import com.xipin.est.ucontroller.exception.JSONPException;
import com.xipin.est.utils.exception.business.BusinessException;

public class BusinessJSONPException extends BusinessException implements JSONPException{

	private static final long serialVersionUID = 7718260091819983685L;

	public BusinessJSONPException(String msg) {
		super(msg);
	}
}

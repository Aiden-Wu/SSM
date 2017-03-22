package com.xipin.est.ucontroller.exception.business;

import com.xipin.est.ucontroller.exception.JSONException;
import com.xipin.est.utils.exception.business.BusinessException;

public class BusinessJSONException extends BusinessException implements JSONException{

	private static final long serialVersionUID = -3035777996694265799L;

	public BusinessJSONException(String msg) {
		super(msg);
	}
}

package com.xipin.est.ucontroller.exception.param;

import org.springframework.validation.FieldError;

import com.xipin.est.ucontroller.exception.JSONPException;

public class RequestParamInvalidJSONPException extends ParamException implements JSONPException{

	private static final long serialVersionUID = -8458485206922963849L;

	public RequestParamInvalidJSONPException(String errMsg) {
		super(errMsg);
	}
	
	public RequestParamInvalidJSONPException(FieldError fieldErr) {
		super(fieldErr);
	}
}

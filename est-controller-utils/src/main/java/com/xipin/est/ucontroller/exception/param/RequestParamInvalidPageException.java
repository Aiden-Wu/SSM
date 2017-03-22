package com.xipin.est.ucontroller.exception.param;

import org.springframework.validation.FieldError;

import com.xipin.est.ucontroller.exception.PageException;

public class RequestParamInvalidPageException extends ParamException implements PageException{

	private static final long serialVersionUID = 5326750565155662443L;

	public RequestParamInvalidPageException(FieldError fieldErr) {
		super(fieldErr);
	}
	
	public RequestParamInvalidPageException(String errMsg) {
		super(errMsg);
	}
	
}

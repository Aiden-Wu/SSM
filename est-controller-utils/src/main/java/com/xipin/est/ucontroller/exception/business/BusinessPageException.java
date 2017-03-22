package com.xipin.est.ucontroller.exception.business;

import com.xipin.est.ucontroller.exception.PageException;
import com.xipin.est.utils.exception.business.BusinessException;

public class BusinessPageException extends BusinessException implements PageException{

	private static final long serialVersionUID = -2423883624603295119L;
	
	public BusinessPageException(String msg) {
		super(msg);
	}
}

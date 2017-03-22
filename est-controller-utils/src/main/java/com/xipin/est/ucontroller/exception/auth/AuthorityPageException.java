package com.xipin.est.ucontroller.exception.auth;

import com.xipin.est.ucontroller.exception.PageException;
import com.xipin.est.utils.exception.auth.AuthorityException;

public class AuthorityPageException extends AuthorityException implements PageException{

	private static final long serialVersionUID = -2423883624603295119L;
	
	public AuthorityPageException(String msg) {
		super(msg);
	}
}

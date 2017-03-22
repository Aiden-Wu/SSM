package com.xipin.est.ucontroller.exception.auth;

import com.xipin.est.ucontroller.exception.JSONPException;
import com.xipin.est.utils.exception.auth.AuthorityException;

public class AuthorityJSONPException extends AuthorityException implements JSONPException{

	private static final long serialVersionUID = 1720736881995348479L;

	public AuthorityJSONPException(String msg) {
		super(msg);
	}

}

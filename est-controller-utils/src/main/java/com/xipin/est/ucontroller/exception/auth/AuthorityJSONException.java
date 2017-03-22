package com.xipin.est.ucontroller.exception.auth;

import com.xipin.est.ucontroller.exception.JSONException;
import com.xipin.est.utils.exception.auth.AuthorityException;

public class AuthorityJSONException extends AuthorityException implements JSONException{

	private static final long serialVersionUID = -3035777996694265799L;

	public AuthorityJSONException(String msg) {
		super(msg);
	}
}

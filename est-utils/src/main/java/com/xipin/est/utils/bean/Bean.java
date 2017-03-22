package com.xipin.est.utils.bean;

/**
 * 
 * @author danny
 *
 */
public class Bean {
	/**
	 * 请求用户的SessionId
	 */
	private String sessionId;

	/**
	 * 请求IP
	 */
	private String requestIp;

	private String language;

	/**
	 * {@linkplain #sessionId}
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * {@linkplain #sessionId}
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * {@linkplain #requestIp}
	 */
	public String getRequestIp() {
		return requestIp;
	}

	/**
	 * {@linkplain #requestIp}
	 */
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}

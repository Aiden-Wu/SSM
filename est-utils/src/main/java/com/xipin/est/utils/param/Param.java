package com.xipin.est.utils.param;

/**
 * 接口所传参数
 * 
 * @author danny
 *
 */
public class Param {

	public interface Insert{
		
	}
	public interface Update{
		
	}
	public interface Delete{
		
	}

	/**
	 * 请求类型 1 ajax, 2 page, ref ActionType enum.
	 */
	private Integer actionType;

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
	 * {@linkplain #actionType}
	 */
	public Integer getActionType() {
		return actionType;
	}

	/**
	 * {@linkplain #actionType}
	 */
	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

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
	public void setRequestIp(String requestId) {
		this.requestIp = requestId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}

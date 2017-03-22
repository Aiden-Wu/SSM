package com.xipin.est.model;

import java.io.Serializable;

/**
 * 请写出类的用途 
 * @author tan.yf
 * @date  2016-05-17 14:19:10
 * @version 1.0.0
 * @copyright (C) 2015 XiPinTech Information Technology Co.,Ltd 
 * All Rights Reserved. 
 * 
 * The software for the XiPinTech technology development, without the 
 * company's written consent, and any other individuals and 
 * organizations shall not be used, Copying, Modify or distribute 
 * the software.
 * 
 */
public class UserResources implements Serializable {
	private static final long serialVersionUID = 852561534892230129L;

	/**
     * 资源ID
     */
    private Long resourcesId;

    /**
     * 
     */
    private Long userId;

	public Long getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(Long resourcesId) {
		this.resourcesId = resourcesId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    
    
}
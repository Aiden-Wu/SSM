package com.xipin.est.service.base.inf;

import org.apache.log4j.Logger;

import com.xipin.est.model.Model;


/**
 * 
 * @author danny
 *
 * @param <T>
 */
public class BaseService<T> {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	protected boolean checkModelIsEmpty(Model m){
		if(m == null || m.getId() == null){
			return true;
		}
		return false;
	}
	
}

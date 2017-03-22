package com.xipin.est.utils.param;

import com.xipin.est.utils.bean.Bean;

public interface BeanParam<E extends Bean> {
	
	E initBean();
	
}

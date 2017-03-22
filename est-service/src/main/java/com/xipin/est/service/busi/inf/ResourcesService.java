package com.xipin.est.service.busi.inf;


import java.util.List;

/**
 * 
 * <p>Description: 用户数据库服务接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface ResourcesService {
    
	public List<String> getResourcesPoListByUserId(Long userId);

	

}

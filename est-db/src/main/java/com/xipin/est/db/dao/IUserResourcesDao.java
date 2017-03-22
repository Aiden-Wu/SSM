package com.xipin.est.db.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.UserResourcesBean;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.model.UserResources;

/**
 * 目录权限
 * @author JiaJia.Song 
 * @date May 17, 2016 2:35:11 PM
 */
@Repository
public interface IUserResourcesDao {
	/**
	 * 通过主键获取唯一记录
	 * @param id
	 * @return
	 */
	public OrgPo getByKey(Long id);
	
	/**
	 * 条件查询
	 * @param OrgJGPo
	 * @return
	 */
	public List<OrgPo> queryListByBiz(UserResourcesBean userResourcesBean);
	
	/**
	 * 主键删除
	 * @param id
	 */
	public int deleteByUserId(Long userId);
	
	/**
	 * 非空字段插入
	 * @param OrgJGPo
	 */
	public int insertSel(UserResourcesBean userResourcesBean);
	
	/**
	 * 非空字段更新
	 * @param OrgJGPo
	 */
	public int updateByPKSel(UserResourcesBean userResourcesBean);
	
	/**
	 * 全字段更新
	 * @param OrgJGPo
	 */
	public void update(UserResourcesBean userResourcesBean);

	public int queryListCountByBiz(UserResourcesBean userResourcesBean);

	public void insertBatch(List<UserResources> userResourceslist);
   
}

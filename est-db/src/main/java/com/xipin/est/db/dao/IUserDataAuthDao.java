package com.xipin.est.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.UserDataAuthBean;
import com.xipin.est.db.po.UserDataAuthPo;

/**
 * @author lvjl
 *
 */
@Repository
public interface IUserDataAuthDao{
	/**
	 * 通过主键获取唯一记录
	 * @param id
	 * @return
	 */
	public UserDataAuthPo getByKey(Long id);
	
	/**
	 * 条件查询
	 * @param userPo
	 * @return
	 */
	public List<UserDataAuthPo> queryListByBiz(UserDataAuthBean userDataAuthBean);
	
	/**
	 * 主键删除
	 * @param id
	 */
	public void deleteByKey(Long id);
	
	/**
	 * 全字段插入
	 * @param userPo
	 */
	public void insert(UserDataAuthBean userDataAuthBean);
	
	/**
	 * 非空字段插入
	 * @param userPo
	 */
	public void insertSel(UserDataAuthBean userDataAuthBean);
	
	/**
	 * 非空字段更新
	 * @param userPo
	 */
	public void updateByPKSel(UserDataAuthBean userDataAuthBean);
	
	/**
	 * 全字段更新
	 * @param userPo
	 */
	public void update(UserDataAuthBean userDataAuthBean);
	
	/**
	 * 通过user删除权限
	 * @param id
	 */
	public void deleteByUserId(Long id);
}

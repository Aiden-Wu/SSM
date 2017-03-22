package com.xipin.est.db.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.db.po.user.UserOrgPo;

/**
 * userDao
 * @author lvjl
 *
 */
@Repository
public interface IUserDao{
	
	/**
	 * 通过主键获取唯一记录
	 * @param id
	 * @return
	 */
	public UserPo getByKey(Long id);
	
	/**
	 * 条件查询
	 * @param userPo
	 * @return
	 */
	public List<UserPo> queryListByBiz(UserBean userBean);
	
	/**
	 * 前台页面条件查询
	 * @param userPo
	 * @return
	 */
	public List<UserPo> queryUserForJsp(UserBean userBean);
	
	
	/**
	 * 全字段插入
	 * @param userPo
	 */
	public void insert(UserBean userBean);
	
	/**
	 * 非空字段插入
	 * @param userPo
	 */
	public void insertSel(UserBean userBean);
	
	/**
	 * 非空字段更新
	 * @param userPo
	 */
	public void updateByPKSel(UserBean userBean);
	
	/**
	 * 
	 * 方法用途: 删除用户<br>
	 * 实现步骤: <br>
	 * @param id
	 */
	void delete(Long id);
	

	public int queryListCountByBiz(UserBean userBean);
    /**
     * 获取当前部门最大的人员编号
     * @param orgId
     * @return    
     * @return String    返回类型
     *
     */
	public String getMaxUserNoByOrgId(Long orgId);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	UserOrgPo getUserInOrgId(Long userId);
}

package com.xipin.est.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.DataAuthBean;
import com.xipin.est.db.bean.UserAuthCheckBean;
import com.xipin.est.db.po.DataAuthTreePo;

/**
 * 数据权限dao
 * @author lvjl
 *
 */
@Repository
public interface IDataAuthDao{
	
	/**
	 * 通过orgid删除
	 * @param id
	 */
	public void deleteByOrgId(Long id);
	
	/**
	 * 通过org父id批量删除
	 * @param id
	 */
	public void deleteByOrgPid(Long id);
	
	/**
	 * 用户数据权限校验
	 * @param userAuthCheckBean
	 * @return 大于0成功
	 */
	public Integer checkUserAuth(UserAuthCheckBean userAuthCheckBean);
	
	/**
	 * 非空字段插入
	 * @param userPo
	 */
	public void insertSel(DataAuthBean dataAuthBean);
	
	/**
	 * 
	 * 方法用途: 查询用户授权的部门ID列表<br>
	 * 实现步骤: <br>
	 * @param userId
	 * @return
	 */
	public List<Long> queryUserAuthBM(@Param("userId")Long userId, @Param("type")Integer type, @Param("jgOrgId")Integer jgOrgId);
	
	/**
	 * 获取用户可以被授予的数据权限
	 * @param userId
	 * @return
	 */
	List<DataAuthTreePo> getDataAuthByUser(Long userId);
	
	List<Long> checkAuth(@Param("userId") Long userId, @Param("list") List<Long> list);
	
	List<Long> getUserBMAuth(Long userId);
}

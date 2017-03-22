package com.xipin.est.db.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.org.OrgListBean;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.db.po.post.OrgJGPo;

/**
 * 组织机构dao
 * @author lvjl
 *
 */
@Repository
public interface IOrgDao{
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
	public List<OrgPo> queryListByBiz(OrgBean orgBean);
	
	List<OrgJGPo> getBMByPId(Long id);
	
	public List<OrgPo> queryPostList(OrgBean orgBean);
	
	public int queryPostListNum(OrgBean orgBean);
	
	public List<OrgPo> queryClientList(OrgBean orgBean);
	
	
	public int queryClientListNum(OrgBean orgBean);
	
	/**
	 * 
	 * 查询部门列表
	 * @param orgBean
	 * @return
	 */
	public List<OrgPo> queryDepartList(OrgBean orgBean);
	
	/**
	 * 
	 * 查询部门列表数量
	 * @param orgBean
	 * @return
	 */
	public int queryDepartListNum(OrgBean orgBean);
	
	/**
	 * 主键删除
	 * @param id
	 */
	public int deleteByKey(Long id);
	
	/**
	 * 非空字段插入
	 * @param OrgJGPo
	 */
	public int insertSel(OrgBean orgBean);
	
	/**
	 * 非空字段更新
	 * @param OrgJGPo
	 */
	public int updateByPKSel(OrgBean orgBean);
	
	public int queryListCountByBiz(OrgBean orgBean);
	
	/**
	 * 条件删除
	 * @param orgBean
	 */
	public void deleteByCondition(OrgBean orgBean);
	
	List<OrgJGPo> getJGByUserId(Long userId);
	
	List<OrgJGPo> getJGByUserIdP(Long userId);
	
	/**
	 * 
	 * 获取邮局（type=0|level=1）
	 * @return
	 */
	public List<OrgPo> getOrgForPostoffice();
	 
	/* 
	 * 方法用途: 查询机构列表<br>
	 * 实现步骤: <br>
	 * @param orgListBean
	 * @return
	 */
	List<OrgListPo> queryOrgList(OrgListBean orgListBean);
	
	/**
	 * 
	 * 方法用途: 查询机构数量<br>
	 * 实现步骤: <br>
	 * @param orgListBean
	 * @return
	 */
	Integer queryOrgCount(OrgListBean orgListBean);

	/**
	 * 
	 * 方法用途: 获取新增机构的编号<br>
	 * 实现步骤: <br>
	 * @param prefix
	 * @return
	 */
	String queryMaxNo(@Param("prefix")String prefix);
	
	
	OrgListPo getOrgPoListByUserId(Long userID);
	
	/**
	 * 
	 * 方法用途: 根据名称查询机构数量<br>
	 * 实现步骤: <br>
	 * @param name
	 * @return
	 */
	int queryCountByName(String name);
	
	@MapKey("id")
	Map<Long, OrgPo> queryAll();
}

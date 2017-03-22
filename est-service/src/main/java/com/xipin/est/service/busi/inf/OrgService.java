package com.xipin.est.service.busi.inf;

import java.util.List;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.bean.org.OrgListBean;
import com.xipin.est.db.po.OrgPcPo;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.utils.bean.PageBean;

/**
 * 
 * <p>Description: 用户数据库服务接口类</p>
 * @date 2016年5月12日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public interface OrgService {
    
	public OrgPo add(OrgBean orgBean);

	public void delete(IDBean idBean);

	public void update(OrgBean orgBean);

	public PageBean<OrgPo> queryListByBiz(OrgBean orgBean,
			PageBean<OrgPo> page);
	
	public PageBean<OrgPo> queryPostList(OrgBean orgBean,
			PageBean<OrgPo> page);
	
	
	public PageBean<OrgPo> queryClientList(OrgBean orgBean,
			PageBean<OrgPo> page);
	
	public PageBean<OrgPo> queryDepartList(OrgBean orgBean,
			PageBean<OrgPo> page);
	

	public OrgPo get(Long id);

	/**
	 * 单个获取机构信息，包含关联邮局信息
	 * @param clientId
	 * @return
	 */
	public OrgPcPo getOrgPc(Long clientId);
	
	/**
	 * 为客户机构添加注册邮局
	 * @param postClientBean
	 * @return
	 */
	public PostClientPo addPostForClient(PostClientBean postClientBean);
	
	/**
	 * 客户机构删除注册邮局
	 * @param postClientBean
	 * @return
	 */
	public void deletePostForClient(PostClientBean postClientBean);
	
	/**
	 * 删除客户机构
	 * @param orgId
	 */
	public void deleteClient(IDBean idBean);
	
	/**
	 * 删除邮局/邮局部门
	 * @param postId
	 */
	public void deletePost(IDBean idBean);

	/**
	 * 通过用户去获取邮局数据<权限>
	 * @param userId
	 * @return
	 */
	List<OrgJGPo> getOrJGInfoByUser(Long userId);
	
	/**
	 * 通过用户去获取机构数据<权限>
	 * @param userId
	 * @return
	 */
	List<OrgJGPo> getJGByUserIdP(Long userId);
	
	public List<OrgPo> getOrgForPostoffice();
	/**
	 * 
	 * 方法用途: 查询机构列表<br>
	 * 实现步骤: <br>
	 * @param orgListBean
	 * @param pageBean
	 * @return
	 */
	PageBean<OrgListPo> queryOrgList(OrgListBean orgListBean, PageBean<OrgListPo> page);
	
	/**
	 * 
	 * 方法用途: 获取新增机构的编号<br>
	 * 实现步骤: <br>
	 * @param id
	 * @return
	 */
	String queryNo(Long id);
	
	OrgListPo getOrgPoListByUserId(Long userID);

}

package com.xipin.est.manager.user;

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
import com.xipin.est.utils.rslt.type.Result;

public interface OrgManager {
    /**
     * 机构新增
     * @param orgParam    
     * @return void    返回类型
     *
     */
	public Result<OrgPo> add(OrgBean orgBean);

	public Result<String> delete(IDBean idBean);
	
	public Result<OrgPo> update(OrgBean orgBean);
	
	public Result<List<OrgPo>> queryListByBiz(OrgBean orgBean, PageBean<OrgPo> page);
	
	public Result<List<OrgPo>> queryPostList(OrgBean orgBean, PageBean<OrgPo> page);
	
	public Result<List<OrgPo>> queryClientList(OrgBean orgBean, PageBean<OrgPo> page);
	
	public Result<List<OrgPo>> queryDepartList(OrgBean orgBean, PageBean<OrgPo> page);
	
	public OrgPo get(Long id);
	
	/**
	 * 获取客户信息，包含关联邮局
	 * @param clientId
	 * @return
	 */
	public Result<OrgPcPo> getClientInfo(Long clientId);
	
	/**
	 * 为客户机构添加注册邮局
	 * @param postClientBean
	 * @return
	 */
	public Result<PostClientPo> addPostForClient(PostClientBean postClientBean);
	
	/**
	 * 客户机构删除注册邮局
	 * @param postClientBean
	 * @return
	 */
	public Result<?> deletePostForClient(PostClientBean postClientBean);
	
	/**
	 * 删除客户机构，及其下属部门
	 * @param clientId
	 * @return
	 */
	public Result<?> deleteClient(Long clientId);
	
	/**
	 * 删除邮局
	 * @param postId
	 * @return
	 */
	public Result<?> deletePost(Long postId);
	
	Result<List<OrgJGPo>> getJGByUserIdP(Long userId);
	
	public List<OrgPo> getOrgForPostoffice();
	
	public Result<List<PostClientPo>> getPostClientPoByClientId(PostClientBean postClientBean);
	
	public Result<List<PostClientPo>> getPostClientPo(PageBean<PostClientPo> page,PostClientBean postClientBean);
	/**
	 * 
	 * 方法用途: 查询机构列表<br>
	 * 实现步骤: <br>
	 * @param orgListBean
	 * @param pageBean
	 * @return
	 */
	Result<List<OrgListPo>> queryOrgList(OrgListBean orgListBean, PageBean<OrgListPo> page);

	/**
	 * 
	 * 方法用途: 获取新增的机构的编号<br>
	 * 实现步骤: <br>
	 * @param id
	 * @return
	 */
	Result<String> queryNo(Long id);
	
	
	Result<String> deletePostClientById(IDBean idBean);
	
	OrgListPo getOrgPoListByUserId(Long userID);
	
}

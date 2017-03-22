package com.xipin.est.manager.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.bean.org.OrgListBean;
import com.xipin.est.db.po.OrgPcPo;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.manager.user.OrgManager;
import com.xipin.est.service.busi.inf.DetailListService;
import com.xipin.est.service.busi.inf.OrgService;
import com.xipin.est.service.busi.inf.PackageService;
import com.xipin.est.service.busi.inf.PostClientService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.rslt.type.Result;

@Service
public class OrgManagerImpl implements OrgManager {

	@Autowired
	private DetailListService detailListService;
	
	@Autowired
	private PackageService packageService;
	
	@Resource
	private OrgService orgService;
	
	@Autowired
	private PostClientService postClientService;


	@Override
	public Result<OrgPo> add(OrgBean orgBean) {
		Result<OrgPo> result = new Result<OrgPo>();
		orgService.add(orgBean);
		OrgPo orgPo = new OrgPo();
		BeanUtils.copyProperties(orgBean, orgPo);
		result.setData(orgPo);
		return result;
	}

	@Override
	public Result<String> delete(IDBean idBean) {
	   Result<String> result =new Result<String>();
	   orgService.delete(idBean);
	   PostClientBean postClientBean = new PostClientBean();
	   postClientBean.setClientId(idBean.getId());
	   postClientBean.setPostId(idBean.getId());
	   postClientService.deleteByCondition(postClientBean);
	   return result;
	}

	@Override
	public Result<OrgPo> update(OrgBean orgBean) {
		Result<OrgPo> result = new Result<OrgPo>();
		orgService.update(orgBean);
		OrgPo orgPo = orgService.get(orgBean.getId());
		result.setData(orgPo);
		return result;
	}

	@Override
	public Result<List<OrgPo>> queryListByBiz(OrgBean orgBean, PageBean<OrgPo> page) {
		Result<List<OrgPo>> result = new Result<>();
		PageBean<OrgPo> pageBean = orgService.queryListByBiz(orgBean, page);
		result.initRslt(pageBean);
		return result;
	}
	
	
	
	

	@Override
	public Result<List<OrgPo>> queryPostList(OrgBean orgBean,
			PageBean<OrgPo> page) {
		Result<List<OrgPo>> result = new Result<>();
		PageBean<OrgPo> pageBean = orgService.queryPostList(orgBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<OrgPo>> queryClientList(OrgBean orgBean,
			PageBean<OrgPo> page) {
		Result<List<OrgPo>> result = new Result<>();
		PageBean<OrgPo> pageBean = orgService.queryClientList(orgBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<List<OrgPo>> queryDepartList(OrgBean orgBean,
			PageBean<OrgPo> page) {
		Result<List<OrgPo>> result = new Result<>();
		PageBean<OrgPo> pageBean = orgService.queryDepartList(orgBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public OrgPo get(Long id) {
		 return orgService.get(id);
	}

	@Override
	public Result<OrgPcPo> getClientInfo(Long clientId) {
		Result<OrgPcPo> result = new Result<OrgPcPo>();
		result.setData(orgService.getOrgPc(clientId));
		return result;
	}

	@Override
	public Result<PostClientPo> addPostForClient(PostClientBean postClientBean) {
		Result<PostClientPo> result = new Result<PostClientPo>();
		result.setData(orgService.addPostForClient(postClientBean));
		return result;
	}

	@Override
	public Result<String> deletePostForClient(PostClientBean postClientBean) {
		Result<String> result = new Result<String>();
		orgService.deletePostForClient(postClientBean);
		return result;
	}

	@Override
	public Result<?> deleteClient(Long clientId) {
		Result<String> result = new Result<String>();
		IDBean idBean = new IDBean();
		idBean.setId(clientId);
		orgService.deleteClient(idBean);
		return result;
	}

	@Override
	public Result<?> deletePost(Long postId) {
		Result<String> result = new Result<String>();
		IDBean idBean = new IDBean();
		idBean.setId(postId);
		orgService.deletePost(idBean);
		return result;
	}

	@Override
	public Result<List<OrgJGPo>> getJGByUserIdP(Long userId) {
		Result<List<OrgJGPo>> result = new Result<List<OrgJGPo>>();
		result.setData(orgService.getJGByUserIdP(userId));
		return result;
	}

	@Override
	public List<OrgPo> getOrgForPostoffice() {
		return orgService.getOrgForPostoffice();
	}

	@Override
	public Result<List<PostClientPo>> getPostClientPoByClientId(
			PostClientBean postClientBean) {
		
		Result<List<PostClientPo>> result = new Result<>();
		List<PostClientPo> orgPoList =  postClientService.queryListByBiz(postClientBean);
		result.setData(orgPoList);
		return result;
	}
	
	@Override
	public Result<List<PostClientPo>> getPostClientPo(PageBean<PostClientPo> page, PostClientBean postClientBean) {
		Result<List<PostClientPo>> result = new Result<>();
		PageBean<PostClientPo> pageData =  postClientService.getPostClientPo(postClientBean, page);
		result.initRslt(pageData);
		return result;
	}

	public Result<List<OrgListPo>> queryOrgList(OrgListBean orgListBean,
			PageBean<OrgListPo> page) {
		Result<List<OrgListPo>> result = new Result<List<OrgListPo>>();
		PageBean<OrgListPo> pageBean = orgService.queryOrgList(orgListBean, page);
		result.initRslt(pageBean);
		return result;
	}

	@Override
	public Result<String> queryNo(Long id) {
		Result<String> result = new Result<>();
		result.setData(orgService.queryNo(id));
		return result;
	}

	@Override
	public Result<String> deletePostClientById(IDBean idBean) {
		Result<String> result = new Result<>();
		postClientService.deleteByKey(idBean);
		return result;
	}

	@Override
	public OrgListPo getOrgPoListByUserId(Long userID) {
		return orgService.getOrgPoListByUserId(userID);
	}
	
	
	

}

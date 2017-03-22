package com.xipin.est.service.busi.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.xipin.est.db.bean.DataAuthBean;
import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.bean.org.OrgListBean;
import com.xipin.est.db.dao.IDataAuthDao;
import com.xipin.est.db.dao.IOrgDao;
import com.xipin.est.db.dao.IPostClientDao;
import com.xipin.est.db.dao.IUserDao;
import com.xipin.est.db.po.OrgPcPo;
import com.xipin.est.db.po.OrgPo;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.db.po.org.OrgListPo;
import com.xipin.est.db.po.post.OrgJGPo;
import com.xipin.est.model.user.Org;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.apsect.annotation.InsertLog;
import com.xipin.est.service.apsect.annotation.UpdateLog;
import com.xipin.est.service.busi.inf.OrgService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ObjectType;
import com.xipin.est.utils.exception.business.BusinessException;
import com.xipin.est.utils.msg.eum.MsgEnum;

@Service
public class OrgServiceImpl implements OrgService {

	@Resource
	private IOrgDao orgDao;
	@Resource
	private IPostClientDao postClientDao;
	@Resource
	private IDataAuthDao dataAuthDao;
	@Resource
	private IUserDao userDao;

	@Override
	@InsertLog(description = "新增机构", tableName = "org", objectType = ObjectType.ORG)
	public OrgPo add(OrgBean orgBean) {
		if (null == orgBean.getParentId()) {
			throw new BusinessException(MsgEnum.s_choose_parentorg.getVal());
		}
		if (null == orgBean.getType()) {
			throw new BusinessException(MsgEnum.s_choose_orgtype.getVal());
		}
		if (null == orgBean.getLevel()) {
			throw new BusinessException(MsgEnum.s_choose_orglevel.getVal());
		}
		if (orgDao.queryCountByName(orgBean.getName()) > 0) {
			throw new BusinessException(MsgEnum.s_orgname_repeat.getVal());
		}
		// 获取机构代码
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		orgBean.setStatus(1);
		orgBean.setCreateDate(ts);
		orgBean.setUpdateDate(ts);
		orgDao.insertSel(orgBean);
		// 添加机构-同时添加数据权限
		DataAuthBean dataAuthBean = new DataAuthBean();
		dataAuthBean.setCreatedate(new Date());
		dataAuthBean.setOrgId(orgBean.getId());
		if (StringUtils.hasText(orgBean.getName())) {
			dataAuthBean.setOrgName(orgBean.getName());
		}
		dataAuthBean.setType(getDataAuthType(orgBean.getType(), orgBean.getLevel()));
		dataAuthDao.insertSel(dataAuthBean);
		// 返回
		OrgPo orgPo = new OrgPo();
		BeanUtils.copyProperties(orgBean, orgPo);
		return orgPo;
	}

	/**
	 * 通过org类别和级别获取数据权限类别
	 * @param orgType org类别 0-邮局，1-客户
	 * @param orgLevel org级别 1-客户/邮局，2-机构，3-部门
	 * @return 1-客户，2-客户机构，3-客户机构部门，4-邮局，5-邮局机构，6-邮局机构部门
	 */
	private Byte getDataAuthType(Byte orgType, Byte orgLevel) {
		Byte result = 0;// 未知
		if (Constants.ORG_TYPE_POST.byteValue() == orgType.byteValue()) {
			if (Constants.ORG_LEVEL_ONE.byteValue() == orgLevel.byteValue()) {
				result = 4;
			} else if (Constants.ORG_LEVEL_TWO.byteValue() == orgLevel.byteValue()) {
				result = 5;
			} else if (Constants.ORG_LEVEL_THREE.byteValue() == orgLevel.byteValue()) {
				result = 6;
			}
		} else if (Constants.ORG_TYPE_CLIENT.byteValue() == orgType.byteValue()) {
			if (Constants.ORG_LEVEL_ONE.byteValue() == orgLevel.byteValue()) {
				result = 1;
			} else if (Constants.ORG_LEVEL_TWO.byteValue() == orgLevel.byteValue()) {
				result = 2;
			} else if (Constants.ORG_LEVEL_THREE.byteValue() == orgLevel.byteValue()) {
				result = 3;
			}
		}
		return result;
	}

	@Override
	@Transactional
	@DeleteLog(description = "删除机构", tableName = "org", objectType = ObjectType.ORG)
	public void delete(IDBean idBean) {
		if(idBean.getId() < 1000){
			throw new BusinessException(MsgEnum.s_initdata_delete.getVal());
		}
		OrgBean orgBean = new OrgBean();
		orgBean.setParentId(idBean.getId());
		if (orgDao.queryClientListNum(orgBean) > 0) {
			throw new BusinessException(MsgEnum.s_hasbm_delete.getVal());
		}
		UserBean userBean = new UserBean();
		userBean.setOrgId(idBean.getId());
		userBean.setStatus((byte) 1);
		if (userDao.queryListCountByBiz(userBean) > 0) {
			throw new BusinessException(MsgEnum.s_hasry_delete.getVal());
		}
		// 删除数据权限
		dataAuthDao.deleteByOrgId(idBean.getId());
		dataAuthDao.deleteByOrgPid(idBean.getId());
		orgDao.deleteByKey(idBean.getId());
	}

	@Override
	@UpdateLog(description = "修改机构", tableName = "org", objectType = ObjectType.ORG)
	public void update(OrgBean orgBean) {
		orgDao.updateByPKSel(orgBean);
	}

	@Override
	public OrgPo get(Long id) {
		return orgDao.getByKey(id);
	}

	@Override
	public PageBean<OrgPo> queryListByBiz(OrgBean orgBean, PageBean<OrgPo> page) {
		orgBean.setBeginIndex(page.getStart());
		orgBean.setPageSize(page.getPageSize());
		List<OrgPo> list = orgDao.queryListByBiz(orgBean);
		page.setCount(orgDao.queryListCountByBiz(orgBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<OrgPo> queryPostList(OrgBean orgBean, PageBean<OrgPo> page) {
		orgBean.setBeginIndex(page.getStart());
		orgBean.setPageSize(page.getPageSize());

		// 判断是否是管理员
		if (orgBean.getUserType() == -1) {
			orgBean.setOrgId(null);
		}

		List<OrgPo> list = orgDao.queryPostList(orgBean);
		page.setCount(orgDao.queryPostListNum(orgBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<OrgPo> queryClientList(OrgBean orgBean, PageBean<OrgPo> page) {
		orgBean.setBeginIndex(page.getStart());
		orgBean.setPageSize(page.getPageSize());

		Byte userType = orgBean.getUserType();
		if (userType == -1) {
			orgBean.setOrgId(null);
		}
		List<OrgPo> list = orgDao.queryClientList(orgBean);
		page.setCount(orgDao.queryClientListNum(orgBean));
		page.setData(list);
		return page;
	}

	@Override
	public PageBean<OrgPo> queryDepartList(OrgBean orgBean, PageBean<OrgPo> page) {
		orgBean.setBeginIndex(page.getStart());
		orgBean.setPageSize(page.getPageSize());
		List<OrgPo> list = orgDao.queryDepartList(orgBean);
		page.setCount(orgDao.queryDepartListNum(orgBean));
		page.setData(list);
		return page;
	}

	@Override
	public OrgPcPo getOrgPc(Long clientId) {
		OrgPcPo orgPcPo = new OrgPcPo();
		// 机构信息
		OrgPo orgPo = orgDao.getByKey(clientId);
		// 是否客户查询
		if (null != orgPo.getType()
				&& Constants.ORG_TYPE_CLIENT.byteValue() == orgPo.getType().byteValue()) {
			BeanUtils.copyProperties(orgPo, orgPcPo);
			PostClientBean postClientBean = new PostClientBean();
			postClientBean.setClientId(orgPo.getId());
			List<PostClientPo> pcList = postClientDao.queryListByBiz(postClientBean);
			if (null != pcList) {
				orgPcPo.setPcList(pcList);
			}
		} else {
			throw new BusinessException("不允许非客户查询！");
		}
		return orgPcPo;
	}

	@Override
	@InsertLog(description = "关联邮局和客户", tableName = "post_client", objectType = ObjectType.POST_CLIENT)
	public PostClientPo addPostForClient(PostClientBean postClientBean) {
		if (null == postClientBean.getClientId()) {
			throw new BusinessException(MsgEnum.s_cunstomer_empty.getVal());
		}
		if (null == postClientBean.getPostId()) {
			throw new BusinessException(MsgEnum.s_postid_empty.getVal());
		}
		if (null == postClientBean.getAccountNo()) {
			throw new BusinessException(MsgEnum.s_postaccountno_empty.getVal());
		}
		if (null == postClientBean.getPpiNo()) {
			throw new BusinessException(MsgEnum.s_postpino_empty.getVal());
		}
		// 注册邮局到国家级别
		OrgPo orgPo = orgDao.getByKey(postClientBean.getPostId());
		if (Constants.ORG_LEVEL_TWO.byteValue() != orgPo.getLevel().byteValue()) {
			throw new BusinessException(MsgEnum.s_post_unreasonable.getVal());
		}
		// 重复校验
		PostClientBean checkBean = new PostClientBean();
		checkBean.setClientId(postClientBean.getClientId());
		checkBean.setPostId(postClientBean.getPostId());
		List<PostClientPo> checkList = postClientDao.queryListByBiz(checkBean);
		if (null != checkList && checkList.size() > 0) {
			throw new BusinessException(MsgEnum.s_registerpost_repeat.getVal());
		}
		
		//客户名字
		OrgPo orgTemp = orgDao.getByKey(postClientBean.getClientId());
		postClientBean.setClientName(orgTemp.getName());//客户名字
		Date nowDate = new Date();
		postClientBean.setCreateDate(nowDate);
		postClientBean.setUpdateDate(nowDate);
		postClientDao.insertSel(postClientBean);
		PostClientPo postClientPo = new PostClientPo();
		BeanUtils.copyProperties(postClientBean, postClientPo);
		return postClientPo;
	}

	@Override
	public void deletePostForClient(PostClientBean postClientBean) {
		if (null == postClientBean.getClientId()) {
			throw new BusinessException(MsgEnum.s_cunstomer_empty.getVal());
		}
		if (null == postClientBean.getPostId()) {
			throw new BusinessException(MsgEnum.s_postid_empty.getVal());
		}
		PostClientBean conditionBean = new PostClientBean();
		conditionBean.setClientId(postClientBean.getClientId());
		conditionBean.setPostId(postClientBean.getPostId());
		postClientDao.deleteByCondition(conditionBean);
	}

	@Override
	@DeleteLog(description = "删除客户", tableName = "org", objectType = ObjectType.ORG)
	public void deleteClient(IDBean idBean) {
		if(idBean.getId() < 1000){
			throw new BusinessException(MsgEnum.s_initdata_delete.getVal());
		}
		// 校验客户，1-属于客户类别，2-级别为客户机构
		OrgPo orgPo = orgDao.getByKey(idBean.getId());
		if (null == orgPo) {
			throw new BusinessException(MsgEnum.s_customer_unexists.getVal());
		}
		if (Constants.ORG_TYPE_CLIENT.byteValue() != orgPo.getType().byteValue()) {
			throw new BusinessException(MsgEnum.s_org_notcustomer.getVal());
		}
		if (Constants.ORG_LEVEL_TWO.byteValue() != orgPo.getLevel().byteValue()) {
			throw new BusinessException(MsgEnum.s_org_notcustomer.getVal());
		}
		// 删除数据权限
		dataAuthDao.deleteByOrgPid(idBean.getId());
		dataAuthDao.deleteByOrgId(idBean.getId());
		// 删除机构下属部门
		OrgBean orgBean = new OrgBean();
		orgBean.setParentId(idBean.getId());
		orgDao.deleteByCondition(orgBean);
		// 删除机构
		orgDao.deleteByKey(idBean.getId());
	}

	@Override
	@DeleteLog(description = "删除邮局", tableName = "org", objectType = ObjectType.ORG)
	public void deletePost(IDBean idBean) {
		// 校验邮局，1-属于邮局类别，2-判断级别，邮局删除及其下属部门/邮局部门
		if (1000 < idBean.getId()) {
			throw new BusinessException(MsgEnum.s_initdata_delete.getVal());
		}
		OrgPo orgPo = orgDao.getByKey(idBean.getId());
		if (null == orgPo) {
			throw new BusinessException(MsgEnum.s_post_empty.getVal());
		}
		if (Constants.ORG_TYPE_POST.byteValue() != orgPo.getType().byteValue()) {
			throw new BusinessException(MsgEnum.s_org_notpost.getVal());
		}
		// 删除数据权限
		dataAuthDao.deleteByOrgPid(idBean.getId());
		dataAuthDao.deleteByOrgId(idBean.getId());
		if (Constants.ORG_LEVEL_TWO.byteValue() == orgPo.getLevel().byteValue()) {
			// 机构级别，删除下属部门
			OrgBean orgBean = new OrgBean();
			orgBean.setParentId(idBean.getId());
			orgDao.deleteByCondition(orgBean);
			// 删除机构
			orgDao.deleteByKey(idBean.getId());
		} else if (Constants.ORG_LEVEL_THREE.byteValue() == orgPo.getLevel().byteValue()) {
			orgDao.deleteByKey(idBean.getId());
		}
	}

	@Override
	public List<OrgJGPo> getOrJGInfoByUser(Long userId) {
		return orgDao.getJGByUserId(userId);
	}

	@Override
	public List<OrgJGPo> getJGByUserIdP(Long userId) {
		return orgDao.getJGByUserIdP(userId);
	}

	@Override
	public List<OrgPo> getOrgForPostoffice() {
		return orgDao.getOrgForPostoffice();
	}

	public PageBean<OrgListPo> queryOrgList(OrgListBean orgListBean, PageBean<OrgListPo> page) {
		orgListBean.setBeginIndex(page.getStart());
		orgListBean.setPageSize(page.getPageSize());
		List<OrgListPo> list = orgDao.queryOrgList(orgListBean);
		page.setCount(orgDao.queryOrgCount(orgListBean));
		page.setData(list);
		return page;
	}

	@Override
	public String queryNo(Long id) {
		String idStr = "";
		Org parentOrg = orgDao.getByKey(id);
		String prefix = "XX";

		if (1 == parentOrg.getLevel()) {// 机构
			prefix = "JG";
		} else if (2 == parentOrg.getLevel() && 0 == parentOrg.getType() && 1000 >= id) {// 马邮、泰邮、巴邮
			prefix = parentOrg.getNo().substring(0, 2);
		} else if (2 == parentOrg.getLevel()) {// 其它
			prefix = "BM";
		}

		if ("XX".equals(prefix)) {
			throw new BusinessException(MsgEnum.s_bmprefix_illegality.getVal());
		}

		String maxIdStr = orgDao.queryMaxNo(prefix);
		if (StringUtils.isEmpty(maxIdStr) || prefix.equals(maxIdStr)) {
			if ("MY".equals(prefix) || "TH".equals(prefix) || "PY".equals(prefix)) {
				idStr = prefix + "01";
			}else{
				idStr = prefix + "000001";
			}
		} else {
			Long newId = Long.parseLong(maxIdStr.substring(2)) + 1;
			if ("MY".equals(prefix) || "TH".equals(prefix) || "PY".equals(prefix)) {
				if (newId > 99) {
					idStr = maxIdStr.substring(0, 2) + String.format("%04d", newId);
				} else {
					idStr = maxIdStr.substring(0, 2) + String.format("%02d", newId);
				}
			} else {
				idStr = maxIdStr.substring(0, 2) + String.format("%07d", newId);
			}
		}
		return idStr;
	}

	@Override
	public OrgListPo getOrgPoListByUserId(Long userID) {
		return orgDao.getOrgPoListByUserId(userID);
	}

}

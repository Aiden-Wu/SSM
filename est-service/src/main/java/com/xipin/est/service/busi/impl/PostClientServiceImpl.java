package com.xipin.est.service.busi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.dao.IPostClientDao;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.service.apsect.annotation.DeleteLog;
import com.xipin.est.service.busi.inf.PostClientService;
import com.xipin.est.utils.bean.PageBean;
import com.xipin.est.utils.contants.ObjectType;

@Service
public class PostClientServiceImpl implements PostClientService {
	
	@Autowired
	private IPostClientDao postClientDao;

	@Override
	public List<PostClientPo> queryListByBiz(PostClientBean postClientBean) {
		return postClientDao.queryListByBiz(postClientBean);
	}

	@Override
	public PageBean<PostClientPo> getPostClientPo(PostClientBean postClientBean, PageBean<PostClientPo> page) {
		page.setData(postClientDao.getPostClientPo(postClientBean, page.getStart(), page.getPageSize()));
		page.setCount(postClientDao.countPostClient(postClientBean));
		return page;
	}

	@Override
	@DeleteLog(description="删除邮局和客户关联", tableName="post_client", objectType=ObjectType.POST_CLIENT)
	public void deleteByKey(IDBean idBean) {
		postClientDao.deleteByKey(idBean.getId());
	}

	@Override
	public void deleteByCondition(PostClientBean postClientBean) {
		postClientDao.deleteByCondition(postClientBean);
	}

}

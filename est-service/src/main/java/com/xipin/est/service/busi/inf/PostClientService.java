package com.xipin.est.service.busi.inf;

import java.util.List;

import com.xipin.est.db.bean.IDBean;
import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.utils.bean.PageBean;

public interface PostClientService {
	
	/**
	 * 条件查询
	 * @param userPo
	 * @return
	 */
	public List<PostClientPo> queryListByBiz(PostClientBean postClientBean);
	
	/**
	 * 
	 * 获取和用户关联的有效的邮局
	 * @param postClientBean
	 * @return
	 */
	PageBean<PostClientPo> getPostClientPo(PostClientBean postClientBean, PageBean<PostClientPo> page) ;
	
	/**
	 * 主键删除
	 * @param id
	 */
	public void deleteByKey(IDBean idBean);
	
	/**
	 * 条件删除-有关联才可删除
	 * @param postClientBean
	 */
	public void deleteByCondition(PostClientBean postClientBean);
}

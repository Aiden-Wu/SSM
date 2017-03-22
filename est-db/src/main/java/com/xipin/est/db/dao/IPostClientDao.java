package com.xipin.est.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.po.PostClientPo;

/**
 * @author lvjl
 *
 */
@Repository
public interface IPostClientDao{
	
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
	List<PostClientPo> getPostClientPo(@Param("bean")PostClientBean postClientBean, @Param("start")Integer start, @Param("pageSize")Integer pageSize);
	
	/**
	 * 主键删除
	 * @param id
	 */
	public void deleteByKey(Long id);
	
	/**
	 * 非空字段插入
	 * @param userPo
	 */
	public void insertSel(PostClientBean postClientBean);
	
	/**
	 * 条件删除-有关联才可删除
	 * @param postClientBean
	 */
	public void deleteByCondition(PostClientBean postClientBean);
	
	int countPostClient(PostClientBean postClientBean);
}

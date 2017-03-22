package com.xipin.est.master.param.client;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.PostClientBean;
import com.xipin.est.db.po.PostClientPo;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

public class PostClientDeleteParam extends PageParam<PostClientPo> implements BeanParam<PostClientBean> {

	/**
     * 
     */
	@NotNull(message=ParamConstants.ID_CANNOT_NULL)
    private Long id;

    /**
     * 邮局Id
     */
    private Long postId;

    /**
     * 邮局名称
     */
    private String postName;

    /**
     * 
     */
    private String accountNo;

    /**
     * 客户Id
     */
    private Long clientId;

    /**
     * 客户名称
     */
    private String clientName;

    /**
     * 
     */
    private String ppiNo;

    /**
     * 
     */
    private String code;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 创建人名称
     */
    private String createrName;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPpiNo() {
		return ppiNo;
	}

	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCreater() {
		return creater;
	}

	public void setCreater(Long creater) {
		this.creater = creater;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public PostClientBean initBean() {
		PostClientBean postClientBean = new PostClientBean();
		BeanUtils.copyProperties(this, postClientBean);
		return postClientBean;
	}

}

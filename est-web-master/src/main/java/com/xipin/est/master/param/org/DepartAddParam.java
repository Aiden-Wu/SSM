package com.xipin.est.master.param.org;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.OrgBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 部门参数验证类</p>
 * @date 2016年5月20日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class DepartAddParam extends Param implements BeanParam<OrgBean> {
	
    /**
     * 父部门ID
     */
	@NotNull(message=ParamConstants.DEPART_PARENTID_CANNOT_NULL)
    private Long parentId;

    /**
     * 部门名称
     */
	@NotEmpty(message=ParamConstants.DEPART_NAME_CANNOT_NULL)
    private String name;

    /**
     * 部门代码
     */
	@NotEmpty(message=ParamConstants.DEPART_NO_CANNOT_NULL)
    private String no;

    /**
     * 部门地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phoneNum;
	
	@Override
	public OrgBean initBean() {
		OrgBean bean = new OrgBean();
		BeanUtils.copyProperties(this, bean);
		bean.setType((byte)0);
		bean.setLevel((byte)3);
		return bean;
	}

	/**
	 * {@linkplain #parentId}
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * {@linkplain #parentId}
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * {@linkplain #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@linkplain #name}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@linkplain #no}
	 */
	public String getNo() {
		return no;
	}

	/**
	 * {@linkplain #no}
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * {@linkplain #address}
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * {@linkplain #address}
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * {@linkplain #phoneNum}
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * {@linkplain #phoneNum}
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

}

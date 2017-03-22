package com.xipin.est.master.param.user;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.UserBean;
import com.xipin.est.db.po.UserPo;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

public class UserLoginParam extends PageParam<UserPo> implements BeanParam<UserBean> {

    private Long id;

    private String username;

    private String password;

    private String salt;
    
    private String name;

    private Byte userType;

    private Byte userStatus;

    private Byte status;

    private String title;

    private String no;

    private Long orgId;

    private String orgName;

    private Date createDate;

    private Date updateDate;

    private Long creater;

    private String createrName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Byte getUserType() {
		return userType;
	}

	public void setUserType(Byte userType) {
		this.userType = userType;
	}

	public Byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	@Override
	public UserBean initBean() {
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(this, userBean);
		return userBean;
	}

}

package com.xipin.est.master.param.post;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.PackageListBean;
import com.xipin.est.db.po.post.PackageListPo;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

/**
 * 
 * <p>Description: 获取包裹列表请求参数</p>
 * @date 2016年6月28日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class PackageListParam extends PageParam<PackageListPo> implements BeanParam<PackageListBean> {

	/**
	 * 批次号
	 */
	@NotEmpty(message = ParamConstants.DEPART_NO_CANNOT_NULL)
	private String dispatchNo;

	/**
	 * CN35
	 */
	private String CN35;

	/**
	 * 邮局英文名称
	 */
	@NotEmpty(message = ParamConstants.POST_OFFICE_ENAME_CANNOT_NULL)
	private String postofficeEnName;

	/**
	 * 产品
	 */
	private String dispatchType;

	/** 1:pending, 2:doing, 3:finish, 4:all */
	private int from;

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #cN35}
	 */
	public String getCN35() {
		return CN35;
	}

	/**
	 * {@linkplain #cN35}
	 */
	public void setCN35(String cN35) {
		CN35 = cN35;
	}

	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	@Override
	public PackageListBean initBean() {
		PackageListBean packageListBean = new PackageListBean();
		BeanUtils.copyProperties(this, packageListBean);
		return packageListBean;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

}

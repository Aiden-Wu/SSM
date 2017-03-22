package com.xipin.est.master.param.post;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.DetailListListBean;
import com.xipin.est.db.po.post.DetailListListPo;
import com.xipin.est.ucontroller.date.DateFomatEnum;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

/**
 * 
 * <p>Description: 邮局清单列表请求参数</p>
 * @date 2016年5月10日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class DetailListListParam extends PageParam<DetailListListPo> implements
		BeanParam<DetailListListBean> {

	/**
	 * 起始提交日期
	 */
	private Date beginAddTime;

	/**
	 * 截至提交日期
	 */
	private Date endAddTime;

	/**
	 * 批次号
	 */
	private String dispatchNo;

	/**
	 * 服务类型
	 */
	private String serviceType;
	/**
	 * 机构ID
	 */
	private Integer jgOrgId;

	/**
	 * 请求用户ID
	 */
	private Long meId;

	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	private int from;

	/**
	 * {@linkplain #beginAddTime}
	 */
	public Date getBeginAddTime() {
		return beginAddTime;
	}

	/**
	 * {@linkplain #beginAddTime}
	 */
	public void setBeginAddTime(String beginAddTime) {
		this.beginAddTime = DateFomatEnum.DATETIME.toDate(beginAddTime, " 00:00:00", "起始提交日期格式错误");
	}

	/**
	 * {@linkplain #endAddTime}
	 */
	public Date getEndAddTime() {
		return endAddTime;
	}

	/**
	 * {@linkplain #endAddTime}
	 */
	public void setEndAddTime(String endAddTime) {
		this.endAddTime = DateFomatEnum.DATETIME.toDate(endAddTime, " 23:59:59", "截至提交日期格式错误");
	}

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
	 * {@linkplain #serviceType}
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * {@linkplain #serviceType}
	 */
	public void setServiceType(String serviceType) {
		if (!serviceType.matches(Constants.longMatchesString)) {
			throw new ParamException("服务类型参数格式不正确");
		}
		this.serviceType = serviceType;
	}

	/**
	 * {@linkplain #jgOrgId}
	 */
	public Integer getJgOrgId() {
		return jgOrgId;
	}

	/**
	 * {@linkplain #jgOrgId}
	 */
	public void setJgOrgId(Integer jgOrgId) {
		this.jgOrgId = jgOrgId;
	}

	/**
	 * {@linkplain #meId}
	 */
	public Long getMeId() {
		return meId;
	}

	/**
	 * {@linkplain #meId}
	 */
	public void setMeId(Long meId) {
		this.meId = meId;
	}

	@Override
	public DetailListListBean initBean() {
		DetailListListBean taskListBean = new DetailListListBean();
		BeanUtils.copyProperties(this, taskListBean);
		return taskListBean;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	/**
	 * {@linkplain #from}
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * {@linkplain #from}
	 */
	public void setFrom(int from) {
		this.from = from;
	}

}
package com.xipin.est.db.bean;

import java.util.Date;
import java.util.List;

import com.xipin.est.utils.bean.Bean;

/**
 * 
 * <p>Description: 清单列表查询参数</p>
 * @date 2016年5月10日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class DetailListListBean extends Bean {
	
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
	
	private Integer noServiceType;
	
	/**
	 * 产品
	 */
	private String dispatchType;
	private String noDispatchType;
	
	/**
	 * 客户机构ID
	 */
	private Integer cJgOrgId;
	
	/**
	 * 邮局机构ID
	 */
	private Integer pJgOrgId;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 状态列表
	 */
	private List<Integer> statusList;
	
	/**
	 * 分页开始
	 */
	private Integer beginIndex;
	
	/**
	 * 分页大小
	 */
	private Integer pageSize;
	
	/**
	 * 授权邮局部门ID集合
	 */
	private List<Long> bmOrgIds;
	
	/**
	 * 授权客户部门ID集合
	 */
	private List<Long> cBmOrgIds;
	
	/**
	 * 请求用户ID
	 */
	private Long meId;
	
	/**
	 * 是否是已完成列表
	 */
	private Integer isFinish;

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
	public void setBeginAddTime(Date beginAddTime) {
		this.beginAddTime = beginAddTime;
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
	public void setEndAddTime(Date endAddTime) {
		this.endAddTime = endAddTime;
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
		if(!"-1".equals(serviceType)){
			this.serviceType = serviceType;
		}
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public String getDispatchType() {
		return dispatchType;
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	/**
	 * {@linkplain #cJgOrgId}
	 */
	public Integer getcJgOrgId() {
		return cJgOrgId;
	}

	/**
	 * {@linkplain #cJgOrgId}
	 */
	public void setcJgOrgId(Integer cJgOrgId) {
		this.cJgOrgId = cJgOrgId;
	}

	/**
	 * {@linkplain #pJgOrgId}
	 */
	public Integer getpJgOrgId() {
		return pJgOrgId;
	}

	/**
	 * {@linkplain #pJgOrgId}
	 */
	public void setpJgOrgId(Integer pJgOrgId) {
		this.pJgOrgId = pJgOrgId;
	}

	/**
	 * {@linkplain #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * {@linkplain #status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * {@linkplain #statusList}
	 */
	public List<Integer> getStatusList() {
		return statusList;
	}

	/**
	 * {@linkplain #statusList}
	 */
	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}

	/**
	 * {@linkplain #beginIndex}
	 */
	public Integer getBeginIndex() {
		return beginIndex;
	}

	/**
	 * {@linkplain #beginIndex}
	 */
	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * {@linkplain #bmOrgIds}
	 */
	public List<Long> getBmOrgIds() {
		return bmOrgIds;
	}

	/**
	 * {@linkplain #bmOrgIds}
	 */
	public void setBmOrgIds(List<Long> bmOrgIds) {
		this.bmOrgIds = bmOrgIds;
	}

	/**
	 * {@linkplain #pageSize}
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	/**
	 * {@linkplain #cBmOrgIds}
	 */
	public List<Long> getcBmOrgIds() {
		return cBmOrgIds;
	}

	/**
	 * {@linkplain #cBmOrgIds}
	 */
	public void setcBmOrgIds(List<Long> cBmOrgIds) {
		this.cBmOrgIds = cBmOrgIds;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public Integer getIsFinish() {
		return isFinish;
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

	/**
	 * {@linkplain #isFinish}
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}

	/**
	 * {@linkplain #noServiceType}
	 */
	public Integer getNoServiceType() {
		return noServiceType;
	}

	/**
	 * {@linkplain #noServiceType}
	 */
	public void setNoServiceType(Integer noServiceType) {
		this.noServiceType = noServiceType;
	}

	/**
	 * {@linkplain #nodispatchType}
	 */
	public String getNoDispatchType() {
		return noDispatchType;
	}

	/**
	 * {@linkplain #nodispatchType}
	 */
	public void setNoDispatchType(String noDispatchType) {
		this.noDispatchType = noDispatchType;
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
	
}

package com.xipin.est.db.po.post;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xipin.est.model.eum.DataStatusEnum;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.contants.ConstantsEscape;

/**
 * 
 * <p>
 * Description: 清单列表展现对象
 * </p>
 * 
 * @date 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 *          <p>
 *          Company:XiPinTech
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2015
 *          </p>
 */
public class DetailListListPo {

	/**
	 * 账户编号
	 */
	private String accountNo;

	/**
	 * 实际到达时间
	 */
	private String actualArrivceDate;
	/**
	 * 实际邮袋数量
	 */
	private BigDecimal actualBagNum;
	/**
	 * 实际邮袋总重
	 */
	private BigDecimal actualTotalWeight;
	/**
	 * 航运单号
	 */
	private String airwayBillNo;
	/**
	 * 邮局部门ID
	 */
	private Long bmOrgId;
	/**
	 * 邮局部门名称
	 */
	private String bmOrgName;
	/**
	 * 创建人
	 */
	private String createPerson;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 客户编号
	 */
	private String customerNo;
	/**
	 * 发货日期
	 */
	private String dispatchDate;
	/**
	 * 批次号
	 */
	private String dispatchNo;
	/**
	 * 邮寄类型
	 */
	private String dispatchType;
	/**
	 * 预计到达时间
	 */
	private String estimateArrivceDate;
	/**
	 * 预报邮袋数量
	 */
	private BigDecimal estimateBagNum;

	/**
	 * 预报邮袋总重
	 */
	private BigDecimal estimateTotalWeight;
	/**
	 * 是否可以录入
	 */
	private Integer isInput;
	/**
	 * 邮局机构ID
	 */
	private Long jgOrgId;
	/**
	 * 邮局机构名称
	 */
	private String jgOrgName;
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	/**
	 * 许可邮件号
	 */
	private String ppiNo;
	/**
	 * 服务类型
	 */
	private Integer serviceType;
	/**
	 * 服务类型描述
	 */
	private String serviceTypeMessage;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 状态
	 */
	private String statusMessage;
	/**
	 * 状态时间
	 */
	private String statusTime;
	/**
	 * 提交时间
	 */
	private String submitDate;
	/**
	 * 航班号
	 */
	private String truckingNo;
	/**
	 * 是否不完整
	 */
	private Integer isBroken;

	/**
	 * {@linkplain #accountNo}
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * {@linkplain #actualArrivceDate}
	 */
	public String getActualArrivceDate() {
		return actualArrivceDate;
	}

	/**
	 * {@linkplain #actualBagNum}
	 */
	public BigDecimal getActualBagNum() {
		return actualBagNum;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public BigDecimal getActualTotalWeight() {
		return actualTotalWeight;
	}

	/**
	 * {@linkplain #airwayBillNo}
	 */
	public String getAirwayBillNo() {
		return airwayBillNo;
	}

	/**
	 * {@linkplain #bmOrgId}
	 */
	public Long getBmOrgId() {
		return bmOrgId;
	}

	/**
	 * {@linkplain #bmOrgName}
	 */
	public String getBmOrgName() {
		return bmOrgName;
	}

	/**
	 * {@linkplain #createPerson}
	 */
	public String getCreatePerson() {
		return createPerson;
	}

	/**
	 * {@linkplain #customerName}
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * {@linkplain #customerNo}
	 */
	public String getCustomerNo() {
		return customerNo;
	}

	/**
	 * {@linkplain #dispatchDate}
	 */
	public String getDispatchDate() {
		return dispatchDate;
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public String getDispatchNo() {
		return dispatchNo;
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public String getDispatchType() {
		return dispatchType;
	}

	/**
	 * {@linkplain #estimateArrivceDate}
	 */
	public String getEstimateArrivceDate() {
		return estimateArrivceDate;
	}

	/**
	 * {@linkplain #estimateBagNum}
	 */
	public BigDecimal getEstimateBagNum() {
		return estimateBagNum;
	}

	/**
	 * {@linkplain #estimateTotalWeight}
	 */
	public BigDecimal getEstimateTotalWeight() {
		return estimateTotalWeight;
	}

	/**
	 * {@linkplain #isInput}
	 */
	public Integer getIsInput() {
		return isInput;
	}

	/**
	 * {@linkplain #jgOrgId}
	 */
	public Long getJgOrgId() {
		return jgOrgId;
	}

	/**
	 * {@linkplain #jgOrgName}
	 */
	public String getJgOrgName() {
		return jgOrgName;
	}

	public String getLanguage() {
		return language;
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public String getPostofficeEnName() {
		return postofficeEnName;
	}

	/**
	 * {@linkplain #ppiNo}
	 */
	public String getPpiNo() {
		return ppiNo;
	}

	/**
	 * {@linkplain #serviceType}
	 */
	public Integer getServiceType() {
		return serviceType;
	}

	/**
	 * {@linkplain #serviceTypeMessage}
	 */
	public String getServiceTypeMessage() {
		return serviceTypeMessage;
	}

	/**
	 * {@linkplain #status}
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * {@linkplain #statusMessage}
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public String getStatusTime() {
		return statusTime;
	}

	/**
	 * {@linkplain #submitDate}
	 */
	public String getSubmitDate() {
		return submitDate;
	}

	/**
	 * {@linkplain #truckingNo}
	 */
	public String getTruckingNo() {
		return truckingNo;
	}

	/**
	 * {@linkplain #isBroken}
	 */
	public Integer getIsBroken() {
		return isBroken;
	}

	/**
	 * {@linkplain #isBroken}
	 */
	public void setIsBroken(Integer isBroken) {
		this.isBroken = isBroken;
	}

	/**
	 * {@linkplain #accountNo}
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * {@linkplain #actualArrivceDate}
	 */
	public void setActualArrivceDate(Date actualArrivceDate) {
		this.actualArrivceDate = new SimpleDateFormat(Constants.DATE_FORMAT)
				.format(actualArrivceDate);
	}

	/**
	 * {@linkplain #actualBagNum}
	 */
	public void setActualBagNum(String actualBagNum) {
		this.actualBagNum = new BigDecimal(actualBagNum);
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public void setActualTotalWeight(String actualTotalWeight) {
		this.actualTotalWeight = new BigDecimal(actualTotalWeight);
	}

	/**
	 * {@linkplain #airwayBillNo}
	 */
	public void setAirwayBillNo(String airwayBillNo) {
		this.airwayBillNo = airwayBillNo;
	}

	/**
	 * {@linkplain #bmOrgId}
	 */
	public void setBmOrgId(Long bmOrgId) {
		this.bmOrgId = bmOrgId;
	}

	/**
	 * {@linkplain #bmOrgName}
	 */
	public void setBmOrgName(String bmOrgName) {
		this.bmOrgName = bmOrgName;
	}

	/**
	 * {@linkplain #createPerson}
	 */
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	/**
	 * {@linkplain #customerName}
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * {@linkplain #customerNo}
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	/**
	 * {@linkplain #dispatchDate}
	 */
	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = new SimpleDateFormat(Constants.DATE_FORMAT)
				.format(dispatchDate);
	}

	/**
	 * {@linkplain #dispatchNo}
	 */
	public void setDispatchNo(String dispatchNo) {
		this.dispatchNo = dispatchNo;
	}

	/**
	 * {@linkplain #dispatchType}
	 */
	public void setDispatchType(String dispatchType) {
		this.dispatchType = dispatchType;
	}

	/**
	 * {@linkplain #estimateArrivceDate}
	 */
	public void setEstimateArrivceDate(Date estimateArrivceDate) {
		this.estimateArrivceDate = new SimpleDateFormat(Constants.DATE_FORMAT)
				.format(estimateArrivceDate);

	}

	/**
	 * {@linkplain #estimateBagNum}
	 */
	public void setEstimateBagNum(String estimateBagNum) {
		this.estimateBagNum = new BigDecimal(estimateBagNum);
	}

	/**
	 * {@linkplain #estimateTotalWeight}
	 */
	public void setEstimateTotalWeight(String estimateTotalWeight) {
		this.estimateTotalWeight = new BigDecimal(estimateTotalWeight);
	}

	/**
	 * {@linkplain #isInput}
	 */
	public void setIsInput(Integer isInput) {
		this.isInput = isInput;
	}

	/**
	 * {@linkplain #jgOrgId}
	 */
	public void setJgOrgId(Long jgOrgId) {
		this.jgOrgId = jgOrgId;
	}

	/**
	 * {@linkplain #jgOrgName}
	 */
	public void setJgOrgName(String jgOrgName) {
		this.jgOrgName = jgOrgName;
	}

	public void setLanguage(String language) {
		this.language = language;
		if(status != null){
			this.statusMessage = DataStatusEnum.getEscape(Integer.valueOf(status), language);
		}
	}

	/**
	 * {@linkplain #postofficeEnName}
	 */
	public void setPostofficeEnName(String postofficeEnName) {
		this.postofficeEnName = postofficeEnName;
	}

	/**
	 * {@linkplain #ppiNo}
	 */
	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	/**
	 * {@linkplain #serviceType}
	 */
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
		this.serviceTypeMessage = ConstantsEscape.serviceTypeEscap(serviceType);
	}

	/**
	 * {@linkplain #status}
	 */
	public void setStatus(Integer status) {
		this.status = status;
		this.statusMessage = DataStatusEnum.getEscape(status, language);
	}

	/**
	 * {@linkplain #statusTime}
	 */
	public void setStatusTime(Date statusTime) {
		this.statusTime = new SimpleDateFormat(Constants.DATETIME_FORMAT)
				.format(statusTime);
	}

	/**
	 * {@linkplain #submitDate}
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = new SimpleDateFormat(Constants.DATETIME_FORMAT)
				.format(submitDate);
	}

	/**
	 * {@linkplain #truckingNo}
	 */
	public void setTruckingNo(String truckingNo) {
		this.truckingNo = truckingNo;
	}

}

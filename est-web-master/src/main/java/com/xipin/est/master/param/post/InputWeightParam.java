package com.xipin.est.master.param.post;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.DetailListInputWeightBean;
import com.xipin.est.db.bean.InputWeightBean;
import com.xipin.est.db.bean.PackageInputWeightBean;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 录入重量确认请求参数</p>
 * @date 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class InputWeightParam extends Param implements BeanParam<InputWeightBean> {

	/**
	 * 包裹重量JSON串
	 */
	@NotEmpty(message = ParamConstants.PACKAGE_WEIGHT_LIST_CANNOT_NULL)
	private String packageJsonString;

	/**
	 * 批次号
	 */
	@NotEmpty(message = ParamConstants.DEPART_NO_CANNOT_NULL)
	private String dispatchNo;

	/**
	 * 实际总邮袋数
	 */
	@NotNull(message = ParamConstants.ACTUALBAGNUM_CANNOT_NULL)
	private String actualBagNum;

	/**
	 * 实际总重量
	 */
	@NotNull(message = ParamConstants.ACTUALTOTALWEIGHT_CANNOT_NULL)
	private String actualTotalWeight;
	
	/**
	 * 邮局英文名称
	 */
	private String postofficeEnName;
	
	/**
	 * 是否录入完毕
	 */
	private Integer isFinish = 1;

	/**
	 * {@linkplain #packageJsonString}
	 */
	public String getPackageJsonString() {
		return packageJsonString;
	}

	/**
	 * {@linkplain #packageJsonString}
	 */
	public void setPackageJsonString(String packageJsonList) {
		this.packageJsonString = packageJsonList;
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
	 * {@linkplain #actualBagNum}
	 */
	public String getActualBagNumStr() {
		return actualBagNum;
	}
	
	public BigDecimal getActualBagNum() {
		return new BigDecimal(actualBagNum);
	}

	/**
	 * {@linkplain #actualBagNum}
	 */
	public void setActualBagNum(String actualBagNum) {
		this.actualBagNum = actualBagNum;
	}

	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public String getActualTotalWeightStr() {
		return actualTotalWeight;
	}

	public BigDecimal getActualTotalWeight() {
		return new BigDecimal(actualTotalWeight);
	}
	
	/**
	 * {@linkplain #actualTotalWeight}
	 */
	public void setActualTotalWeight(String actualTotalWeight) {
		this.actualTotalWeight = actualTotalWeight;
	}

	@SuppressWarnings("unchecked")
	@Override
	public InputWeightBean initBean() {
		validate();
		InputWeightBean inputWeightBean = new InputWeightBean();
		//清单
		DetailListInputWeightBean detailListInputWeightBean = new DetailListInputWeightBean();
		BeanUtils.copyProperties(this, detailListInputWeightBean);
		inputWeightBean.setDetailListInputWeightBean(detailListInputWeightBean);
		
		//邮包
		List<PackageInputWeightBean> packageBeanList = JSONArray.toList(JSONArray.fromObject(packageJsonString), new PackageInputWeightBean(), new JsonConfig());
		for (PackageInputWeightBean packageBean : packageBeanList) {
			BeanUtils.copyProperties(this, packageBean);
		}
		inputWeightBean.setPackageList(packageBeanList);
		
		return inputWeightBean;
	}

	/**
	 * 
	 * 方法用途: 验证数据正确性<br>
	 * 实现步骤: <br>
	 */
	private void validate() {
		this.checkInt(this.actualBagNum, ParamConstants.ACTUALBAGNUM_FOMAT_ERROR);
		this.checkDoule(this.actualTotalWeight, ParamConstants.ACTUALTOTALWEIGHT_FOMAT_ERROR);
		for (Object object : JSONArray.fromObject(packageJsonString)) {
			JSONObject opt = JSONObject.fromObject(object);
			if (!opt.containsKey("actualPackageNum")) {
				throw new ParamException(ParamConstants.NO_ACTUALPACKAGENUM_PARAM);
			}
			if (!opt.containsKey("actualPackageWeight")) {
				throw new ParamException(ParamConstants.NO_ACTUALPACKAGEWEIGHT_PARAM);
			}
			if (!opt.containsKey("packageNo")) {
				throw new ParamException(ParamConstants.NO_PACKAGENO_PARAM);
			}
			if (!opt.containsKey("errorValue")) {
				throw new ParamException(ParamConstants.NO_ERRORVALUE_PARAM);
			}
			this.checkInt(opt.optString("actualPackageNum"), ParamConstants.ACTUALPACKAGENUM_FOMAT_ERROR);
			this.checkDoule(opt.optString("actualPackageWeight"), ParamConstants.ACTUALPACKAGEWEIGHT_FOMAT_ERROR);
			this.checkDoule(opt.optString("errorValue"), ParamConstants.ERRORVALUE_FOMAT_ERROR, false);
		}
	}

	/**
	 * plus
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param str
	 * @param errorMsg
	 * @return
	 */
	private int checkInt(String str, String errorMsg) {
		int n = 0;
		try {
			n = new Double(Double.parseDouble(str)).intValue();
		} catch (NumberFormatException e) {
			throw new ParamException(errorMsg);
		}
		if (n < 0) {
			throw new ParamException(errorMsg);
		}
		return n;
	}

	/**
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @return
	 */
	private BigDecimal checkDoule(String str, String errorMsg, boolean isPlus) {
		BigDecimal n = BigDecimal.ZERO;
		try {
			n = new BigDecimal(str);
		} catch (NumberFormatException e) {
			throw new ParamException(errorMsg);
		}
		if (isPlus && !(BigDecimal.ZERO.compareTo(n) != 1)) {
			throw new ParamException(errorMsg);
		}
		return n;
	}

	private BigDecimal checkDoule(String str, String errorMsg) {
		return this.checkDoule(str, errorMsg, true);
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
	 * {@linkplain #isFinish}
	 */
	public Integer getIsFinish() {
		return isFinish;
	}

	/**
	 * {@linkplain #isFinish}
	 */
	public void setIsFinish(Integer isFinish) {
		this.isFinish = isFinish;
	}
}

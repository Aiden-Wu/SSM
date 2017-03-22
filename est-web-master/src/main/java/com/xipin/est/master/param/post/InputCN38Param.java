package com.xipin.est.master.param.post;

import java.util.List;

import javax.validation.constraints.NotNull;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.InputCNBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 录入CN38请求参数</p>
 * @date 2016年6月22日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class InputCN38Param extends Param implements BeanParam<InputCNBean> {
	/**
	 * 批次号
	 */
	@NotNull(message =  ParamConstants.DEPART_NO_CANNOT_NULL)
	private String dispatchNo;
	
	/**
	 * CN38Json串
	 */
	@NotNull(message = ParamConstants.CN38_CANNOT_NULL)
	private String cn38JsonString;
	/**
	 * 邮局英文名称
	 */
	@NotNull(message = ParamConstants.POST_OFFICE_ENAME_CANNOT_NULL)
	private String postofficeEnName;
	/**
	 * 是否录入完毕
	 */
	@NotNull(message = ParamConstants.ISFINISH_CANNOT_NULL)
	private Integer isFinish;

	@SuppressWarnings("unchecked")
	@Override
	public InputCNBean initBean() {
		validate();
		InputCNBean inputCNBean = new InputCNBean();
		List<PackageBean> CNBeanList = JSONArray.toList(JSONArray.fromObject(cn38JsonString), new PackageBean(), new JsonConfig());
		for (PackageBean packageBean : CNBeanList) {
			BeanUtils.copyProperties(this, packageBean);
		}
		inputCNBean.setCNList(CNBeanList);
		BeanUtils.copyProperties(this, inputCNBean);
		return inputCNBean;
	}
	
	private void validate(){
		for (Object object : JSONArray.fromObject(cn38JsonString)) {
			JSONObject opt = JSONObject.fromObject(object);
			if (!opt.containsKey("cn38")) {
				throw new ParamException(ParamConstants.NO_CN38_PARAM);
			}
			if (!opt.containsKey("countryCode")) {
				throw new ParamException(ParamConstants.NO_COUNTRYCODE_PARAM);
			}
			if ("".equals(opt.optString("cn38"))) {
				throw new ParamException(ParamConstants.CN38_CANNOT_NULL);
			}
			if ("".equals(opt.optString("countryCode"))) {
				throw new ParamException(ParamConstants.COUNTRYCODE_CANNOT_NULL);
			}
		}
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
	 * {@linkplain #cn38JsonString}
	 */
	public String getCn38JsonString() {
		return cn38JsonString;
	}

	/**
	 * {@linkplain #cn38JsonString}
	 */
	public void setCn38JsonString(String cn38JsonString) {
		this.cn38JsonString = cn38JsonString;
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

package com.xipin.est.master.param.post;

import java.util.List;

import javax.validation.constraints.NotNull;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.InputCNBean;
import com.xipin.est.db.bean.PackageBean;
import com.xipin.est.ucontroller.exception.param.ParamException;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

/**
 * 
 * <p>Description: 录入CN35请求参数</p>
 * @date 2016年5月11日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class InputCN35Param extends Param implements BeanParam<InputCNBean> {

	/**
	 * CN35列表JSON串
	 */
	@NotEmpty(message = ParamConstants.CN35_CANNOT_EMPTY)
	private String cn35JsonString;

	/**
	 * 批次号
	 */
	@NotEmpty(message = ParamConstants.DEPART_NO_CANNOT_NULL)
	private String dispatchNo;

	/**
	 * 邮局英文名称
	 */
	@NotNull(message = ParamConstants.POST_OFFICE_ENAME_CANNOT_NULL)
	private String postofficeEnName;

	/**
	 * {@linkplain #cn35JsonString}
	 */
	public String getCn35JsonString() {
		return cn35JsonString;
	}

	/**
	 * {@linkplain #cn35JsonString}
	 */
	public void setCn35JsonString(String cn35JsonString) {
		this.cn35JsonString = cn35JsonString;
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

	@SuppressWarnings("unchecked")
	@Override
	public InputCNBean initBean() {
		validate();
		InputCNBean inputCNBean = new InputCNBean();
		List<PackageBean> CNBeanList = JSONArray.toList(JSONArray.fromObject(cn35JsonString), new PackageBean(), new JsonConfig());
		for (PackageBean packageBean : CNBeanList) {
			BeanUtils.copyProperties(this, packageBean);
		}
		inputCNBean.setCNList(CNBeanList);
		BeanUtils.copyProperties(this, inputCNBean);
		return inputCNBean;
	}

	/**
	 * 
	 * 方法用途: 验证数据正确性<br>
	 * 实现步骤: <br>
	 */
	private void validate() {
		for (Object object : JSONArray.fromObject(cn35JsonString)) {
			JSONObject opt = JSONObject.fromObject(object);
			if (!opt.containsKey("cn35")) {
				throw new ParamException(ParamConstants.NO_CN35_PARAM);
			}
			if ("".equals(opt.optString("cn35"))) {
				throw new ParamException(ParamConstants.CN35_CANNOT_EMPTY);
			}
		}
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

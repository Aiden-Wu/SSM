package com.xipin.est.master.param;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.StringListBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

//XXX zz
public class StringListParam extends Param implements BeanParam<StringListBean> {

	@NotNull(message = ParamConstants.DEPART_NO_CANNOT_NULL)
	private List<String> list;
	
	@NotNull(message = ParamConstants.POST_OFFICE_ENAME_CANNOT_NULL)
	private List<String> poenList;
	
	@Override
	public StringListBean initBean() {
		StringListBean stringListBean = new StringListBean();
		BeanUtils.copyProperties(this, stringListBean);
		return stringListBean;
	}

	/**
	 * {@linkplain #list}
	 */
	public List<String> getList() {
		return list;
	}

	/**
	 * {@linkplain #list}
	 */
	public void setList(List<String> list) {
		this.list = list;
	}

	public List<String> getPoenList() {
		return poenList;
	}

	public void setPoenList(List<String> poenList) {
		this.poenList = poenList;
	}
	
	

}

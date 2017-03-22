package com.xipin.est.master.param.client;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.DetailListDeleteBean;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.Param;

public class DetailListDeleteParam extends Param implements BeanParam<DetailListDeleteBean>{

	@NotNull(message=ParamConstants.DISPATCHNO_CANNOT_NULL)
	private List<String> list; //批次号列表
	
	@NotNull(message=ParamConstants.POST_OFFICE_ENAME_CANNOT_NULL)
	private List<String> poenList;//邮局英文名列表

	@Override
	public DetailListDeleteBean initBean() {
		DetailListDeleteBean detailListDeleteBean = new DetailListDeleteBean();
		BeanUtils.copyProperties(this, detailListDeleteBean);
		return detailListDeleteBean;
	}

	public List<String> getList() {
		return list;
	}

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

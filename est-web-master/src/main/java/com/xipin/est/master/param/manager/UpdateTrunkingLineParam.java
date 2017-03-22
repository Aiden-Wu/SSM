package com.xipin.est.master.param.manager;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.xipin.est.db.bean.TrunkingLineBean;
import com.xipin.est.db.po.manager.TrunkingLinePo;
import com.xipin.est.utils.msg.eum.ParamConstants;
import com.xipin.est.utils.param.BeanParam;
import com.xipin.est.utils.param.PageParam;

public class UpdateTrunkingLineParam extends PageParam<TrunkingLinePo> implements BeanParam<TrunkingLineBean>{
	
	private Long id;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_NAME_CANNOT_NULL)
	private String name;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_PRICE_CANNOT_NULL)
	private BigDecimal price;
	
	private String no;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_START_CANNOT_NULL)
	private String start;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_END_CANNOT_NULL)
	private String end;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_ISTRANSPORT_CANNOT_NULL)
	private String isTransport;
	
	@NotNull(message=ParamConstants.TRUNKINGLINE_TRUNKSTATUS_CANNOT_NULL)
	private String trunkStatus;
	
	private Date createDate;
	
	private Date updateDate;
	
	private String departmentName;
	
	private String departmentID;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getIsTransport() {
		return isTransport;
	}

	public void setIsTransport(String isTransport) {
		this.isTransport = isTransport;
	}

	public String getTrunkStatus() {
		return trunkStatus;
	}

	public void setTrunkStatus(String trunkStatus) {
		this.trunkStatus = trunkStatus;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
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

	@Override
	public TrunkingLineBean initBean() {
		TrunkingLineBean trunkingLineBean = new TrunkingLineBean();
		BeanUtils.copyProperties(this, trunkingLineBean);
		return trunkingLineBean;
	}

	@Override
	public String toString() {
		return "TrunkingLineParam [id=" + id + ", name=" + name + ", price="
				+ price + ", no=" + no + ", start=" + start + ", end=" + end
				+ ", isTransport=" + isTransport + ", trunkStatus="
				+ trunkStatus + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", departmentName=" + departmentName
				+ ", departmentID=" + departmentID + "]";
	}
	

}

package com.xipin.est.db.po.post;

import java.io.Serializable;
import java.util.List;

public class OrgJGPo implements Serializable {

	private static final long serialVersionUID = 735207259170745469L;

	private String ename;
	private String name;
	private String customerNo;
	private String ppiNo;
	// BM
	private Long id;
	private String address;
	private List<OrgJGPo> line;
	// JG
	private Long pid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public String getPpiNo() {
		return ppiNo;
	}

	public void setPpiNo(String ppiNo) {
		this.ppiNo = ppiNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrgJGPo> getLine() {
		return line;
	}

	public void setLine(List<OrgJGPo> line) {
		this.line = line;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}

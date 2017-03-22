package com.xipin.est.db.po.org;

/**
 * 
 * <p>
 * Description: 机构列表展示类
 * </p>
 * 
 * @date 2016年5月21日
 * @author Jianwen Zhu
 * @version 1.0
 *          <p>
 *          Company:XiPinTech
 *          </p>
 *          <p>
 *          Copyright:Copyright(c)2015
 *          </p>
 */
public class OrgListPo {

	/**
	 * 机构ID
	 */
	private Long id;
	/**
	 * 机构名称
	 */
	private String name;

	/**
	 * 英文名称
	 */
	private String ename;
	/**
	 * 父机构ID
	 */
	private String parentName;

	private String parentEName;

	/**
	 * 机构编号
	 */
	private String no;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 级别
	 */
	private Integer level;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 联系电话
	 */
	private String phoneNum;

	/**
	 * {@linkplain #id}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * {@linkplain #id}
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * {@linkplain #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@linkplain #name}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@linkplain #parentName}
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * {@linkplain #parentName}
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * {@linkplain #no}
	 */
	public String getNo() {
		return no;
	}

	/**
	 * {@linkplain #no}
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * {@linkplain #type}
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * {@linkplain #type}
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * {@linkplain #level}
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * {@linkplain #level}
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * {@linkplain #address}
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * {@linkplain #address}
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * {@linkplain #phoneNum}
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/**
	 * {@linkplain #phoneNum}
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getParentEName() {
		return parentEName;
	}

	public void setParentEName(String parentEName) {
		this.parentEName = parentEName;
	}

}

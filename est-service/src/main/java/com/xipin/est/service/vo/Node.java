package com.xipin.est.service.vo;


import java.util.ArrayList;
import java.util.List;
/**
 * 按照前端要求 生成目录树的中间类
 * @author JiaJia.Song 
 * @date May 18, 2016 3:01:21 PM
 */
public class Node {

	private Long id; // 权限编号
	private long pid; // 父权限编号
	private String name; //权限名
	private String ename; //权限英文名
	private String url;//URL、
	private String type;//item表示端节点，folder表示还有其他儿子节点
	private int isPermisson; //用户是否拥有此权限
	private List<Node> childrens = new ArrayList<Node>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getIsPermisson() {
		return isPermisson;
	}
	public void setIsPermisson(int isPermisson) {
		this.isPermisson = isPermisson;
	}
	public List<Node> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<Node> childrens) {
		this.childrens = childrens;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
    
}

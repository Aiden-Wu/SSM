package com.xipin.est.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuDto implements Comparable<MenuDto>, Serializable {
	private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private String url;

    private String iconCls;
    
    private Long pid;
    
    private Integer sort;
    

    private List<MenuDto> children = new ArrayList<>();
    
    private Attributes attributes;
    
    public static class Attributes implements Serializable{
		private static final long serialVersionUID = 1L;
		private String href;
		public Attributes(String href) {
			super();
			this.href = href;
		}
		public String getHref() {
			return href;
		}
		public void setHref(String href) {
			this.href = href;
		}
	}

	

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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getIconCls() {
		return iconCls;
	}



	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}



	public Long getPid() {
		return pid;
	}



	public void setPid(Long pid) {
		this.pid = pid;
	}



	public Integer getSort() {
		return sort;
	}



	public void setSort(Integer sort) {
		this.sort = sort;
	}



	public List<MenuDto> getChildren() {
		return children;
	}



	public void setChildren(List<MenuDto> children) {
		this.children = children;
	}



	public Attributes getAttributes() {
		return attributes;
	}



	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}



	@Override
	public int compareTo(MenuDto o) {
		if(this.getSort()==null||o.getSort()==null){//sort不是必填字段、如果sort为空会异常
			return -1;
		}
		 return this.getSort().compareTo(o.getSort());
	}

}

package com.xipin.est.model;

public enum ResourcesType {
	system("系统"),module("模块"),menu("菜单"),button("按钮"),input("输入框");
	
	 private final String info;
     private ResourcesType(String info) {
         this.info = info;
     }

     public String getInfo() {
         return info;
     }
     
}

package com.xipin.est.service.apsect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * <p>Description: 日志自定义注解标签</p>
 * @date 2016年5月18日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
@Target({ ElementType.PARAMETER,ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UpdateLog {
	
	/**
	 * 
	 * 方法用途: 描述<br>
	 * 实现步骤: <br>
	 * @return
	 */
	public String description() default "";
	
	/**
	 * 
	 * 方法用途: 对象类型<br>
	 * 实现步骤: <br>
	 * @return
	 */
	public int objectType();
	
	/**
	 * 
	 * 方法用途: 表名<br>
	 * 实现步骤: <br>
	 * @return
	 */
	public String tableName();
	
}

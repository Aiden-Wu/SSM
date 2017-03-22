package com.xipin.est.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <p>Description: 时间格式枚举类</p>
 * @date 2016年6月28日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public enum DateFomatEnum {
	/**
	 * 日期格式——MM/dd/yyyy
	 */
	DATE("MM/dd/yyyy"),
	/**
	 * 日期时间格式——MM/dd/yyyy HH:mm:ss
	 */
	DATETIME("MM/dd/yyyy HH:mm:ss");

	private String fomat;
	private SimpleDateFormat simpleDateFormat;

	/**
	 * 
	 * 方法用途: 转换为字符串<br>
	 * 实现步骤: <br>
	 * @param date
	 * @return
	 */
	public String toString(Date date) {
		if(date == null){
			return "";
		}
		return this.simpleDateFormat.format(date);
	}

	/**
	 * 
	 * 方法用途: 转换为日期<br>
	 * 实现步骤: <br>
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public Date toDate(String str) throws ParseException {
		return this.simpleDateFormat.parse(str);
	}

	private DateFomatEnum(String fomat) {
		this.fomat = fomat;
		this.simpleDateFormat = new SimpleDateFormat(fomat);
	}

	/**
	 * {@linkplain #fomat}
	 */
	public String getFomat() {
		return fomat;
	}

	/**
	 * {@linkplain #simpleDateFormat}
	 */
	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}
}

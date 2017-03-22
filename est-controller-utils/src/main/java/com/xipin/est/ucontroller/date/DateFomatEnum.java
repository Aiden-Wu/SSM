package com.xipin.est.ucontroller.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.xipin.est.ucontroller.exception.param.ParamException;

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

	public String toString(Date date) {
		if(date == null){
			return "";
		}
		return this.simpleDateFormat.format(date);
	}

	public Date toDate(String str) throws ParseException {
		return this.simpleDateFormat.parse(str);
	}

	public Date toDate(String str, String message) throws ParamException {
		if(StringUtils.isEmpty(str)){
			return null;
		}
		try {
			return this.simpleDateFormat.parse(str);
		} catch (ParseException e) {
			throw new ParamException(message);
		}
	}

	public Date toDate(String preStr, String sufStr, String message) throws ParamException {
		if(StringUtils.isEmpty(preStr)){
			return null;
		}
		try {
			return this.simpleDateFormat.parse(preStr+sufStr);
		} catch (ParseException e) {
			throw new ParamException(message);
		}
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

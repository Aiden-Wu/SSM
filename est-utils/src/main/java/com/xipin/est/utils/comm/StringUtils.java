package com.xipin.est.utils.comm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 */
public class StringUtils {
	
	public static final String EMPTY = "";
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 截取前250个字符(动态内容)
	 * @return
	 */
	public static String subPre250(String str){
		if(str == null) return "";
		if(str.length() > 120){
			return str.substring(0, 120)+"...";
		}
		return str;
	}
	
	/***
	 * 验证是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String... str){
		for(String s:str){
			if(s == null || "".equals(s)){
				return true;
			}
		}
		return false;
	}
	
	/***
	 * 处理掉字符串中的特殊字符:html版
	 * (符号处理在标签之前)
	 * @param str
	 * @return
	 */
	private static String[] speChar = {"&","<",">","\"","\r\n"};
	private static String[] replaceChar={"&amp;", "&lt;", "&gt;", "&quot;", "<br/>"};
	public static String dealHtmlSpeChar(String str){
		if(str == null) return str;
		for(int i=0; i<speChar.length; i++){
			str = str.replaceAll(speChar[i], replaceChar[i]);
		}
		return str;
	}
	
	/**
	 * 把引号转换成转义的引号，如果已经转移不变
	 * @param str
	 * @return
	 */
	public static String dealQuot(String str){
		if(str == null) return str;
		str = str.replaceAll("\\\\\"", "\"");
		return str.replaceAll("\"", "\\\\\""); 
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String reDealQuot(String str){
		if(!isEmpty(str)){
			str = str.replaceAll("\\\\\"", "\"");
		}
		return str;
	}
	
	/***
	 * 处理掉字符串中的特殊字符:java版
	 * @param str
	 * @return
	 */
	public static String dealJavaSpeChar(String str){
		if(str == null) return null;
		str = str.replaceAll("\r\n", "\\r\\n");
		return str;
	}
	
	
	public static String dealBlank(String content){
		if(content == null) return content;
		return content.replaceAll("\\s", "");
	}
	/**
	 *去掉字符串中的标签 
	 * @param content
	 * @return
	 */
	public static String delHtmlTag(String content){
		if(content == null) return content;
		return dealBlank(content.replaceAll("<(.*?)>", ""));
	}
	
	/**
	 * Redis 中JSON转换问题
	 * @param str
	 * @return
	 */
	public static String delJsonFromRedis(String str){
		if(isEmpty(str)){
			return "";
		}
		if(str.indexOf("\\") > 0){
			if(str.length() > 2){
				str = StringUtils.reDealQuot(str);
				str = str.substring(1, str.length() - 1);
			} else {
				return "";
			}
		}
		return str;
	}
	
	public static String toString(Object o){
		if(o != null){
			return o.toString();
		}
		return "";
	}
	
	
	/**
	 * 把日期字符串装换为时间格式
	 * @param dateStr
	 * @param str " 00:00:00"、" 23:59:59"
	 * @return
	 * @throws ParseException
	 */
	public static Date StrFormatToDate(String dateStr,String str) throws ParseException{
		Date date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(dateStr+str);
		return date;
	}
	
	
	public static void main(String[] args) {
		String str = "{\"a\":\"b\"a\"a\"}";
		System.out.println(str);
		System.out.println(dealQuot(str));
	}
}

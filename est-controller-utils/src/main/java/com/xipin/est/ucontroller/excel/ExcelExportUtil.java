package com.xipin.est.ucontroller.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
 * <p>Description: EXCEL模板导出工具类</p>
 * @date 2016年5月10日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public class ExcelExportUtil {

	/**
	 * 
	 * 方法用途: <br>
	 * 实现步骤: <br>
	 * @param request 请求对象
	 * @param response 回复对象
	 * @param templateName Excel模板名称
	 * @param fileName 导出文件名
	 * @param beanParams 导出数据
	 * @throws Exception 异常
	 */
	public static void exportExcel(HttpServletRequest request, HttpServletResponse response,
			String templateName, String fileName, Map<String, Object> beanParams) throws Exception {

		XLSTransformer transformer = new XLSTransformer();
		String realPath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/excel_template");
		Workbook workbook = transformer.transformXLS(new FileInputStream(realPath + File.separator
				+ templateName), beanParams);

		export(request, response, workbook, fileName);
	}

	/**
	 * 
	 * 方法用途: 输出Excel工作簿<br>
	 * 实现步骤: <br>
	 * @param request 请求对象
	 * @param response 回复对象
	 * @param workbook 工作簿
	 * @param fileName 文件名
	 * @throws UnsupportedEncodingException 字符编码异常
	 * @throws IOException IO异常
	 */
	public static void export(HttpServletRequest request, HttpServletResponse response,
			Workbook workbook, String fileName) throws UnsupportedEncodingException, IOException {

		OutputStream out = response.getOutputStream();
		response.reset();

		String outFileName = "";
		if (request.getHeader("User-Agent").indexOf("MSIE") != -1) {
			outFileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		} else {
			outFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		response.setContentType("application/msexcel");
		response.setHeader("Content-disposition", "attachment; filename=" + outFileName + ".xls");

		workbook.write(out);
	}

}

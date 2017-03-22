package com.xipin.est.ucontroller.excel.eum;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xipin.est.utils.comm.StringUtils;

public enum ExcelTypeEnum {
	选择(""),
	XLS("xls") {
		@Override
		public Workbook export(InputStream is) throws IOException {
			return new HSSFWorkbook(is);
		}
	}, 
	XLSX("xlsx") {
		@Override
		public Workbook export(InputStream is) throws IOException {
			return new XSSFWorkbook(is);
		}
	};
	private String name;

	private ExcelTypeEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Workbook export(InputStream is) throws IOException{
		return null;	
	}
	
	public ExcelTypeEnum get(String name){
		if(!StringUtils.isEmpty(name)){
			for(ExcelTypeEnum e : ExcelTypeEnum.values()){
				if(e.getName().equals(name.toLowerCase())){
					return e;
				}
			}
		}
		return null;
	}
}

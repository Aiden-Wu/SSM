package com.xipin.est.db.po;

import com.xipin.est.model.Items;
import com.xipin.est.utils.convert.CommConvertUtils;

public class ItemsPo extends Items {

	private static final long serialVersionUID = -6303059779880034039L;

	private Integer SerialNumber;

	private String message;

	private int rowNum;

	private String postal;

	private String service;

	private String quantity;

	public Integer getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public void setDispatchDate(String dispatchDateStr) {
		this.setDispatchDate(CommConvertUtils.convertToTimestamp(
				dispatchDateStr, "yyyy-MM-dd HH:mm:ss"));
	}

	public void setEta(String etaStr) {
		this.setEta(CommConvertUtils.convertToTimestamp(etaStr,
				"yyyy-MM-dd HH:mm:ss"));
	}

	public void setQty(String qtyStr) {
		this.setQty(CommConvertUtils.converToBigDecimal(qtyStr, null));
	}

	public void setWeight(String weightStr) {
		this.setWeight(CommConvertUtils.converToBigDecimal(weightStr, null));
	}

	public void setHeight(String heightStr) {
		this.setHeight(CommConvertUtils.converToBigDecimal(heightStr, null));
	}

	public void setWidth(String widthStr) {
		this.setWidth(CommConvertUtils.converToBigDecimal(widthStr, null));
	}
	
	public void setLength(String lenStr) {
		this.setLength(CommConvertUtils.converToBigDecimal(lenStr, null));
	}

	public void setItemValue(String itemValueStr) {
		this.setItemValue(CommConvertUtils.converToBigDecimal(itemValueStr,
				null));
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}

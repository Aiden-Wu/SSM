package com.xipin.est.model.eum;

public enum ServiceTypeEnum {

	选择("",""),TS("1", "TS"), DE("2", "DE");

	private String type;
	private String typeName;

	private ServiceTypeEnum(String type, String typeName) {
		this.type = type;
		this.typeName = typeName;
	}

	public String getType() {
		return type;
	}

	public String getTypeName(String type) {
		for(ServiceTypeEnum e : ServiceTypeEnum.values()){
			if(e.type.equals(type)){
				return e.typeName;
			}
		}
		return "";
	}

}

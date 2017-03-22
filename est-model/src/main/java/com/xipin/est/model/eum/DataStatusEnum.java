package com.xipin.est.model.eum;

/**
 * 
 * <p>Description: 数据状态枚举类</p>
 * @date 2016年6月28日
 * @author Jianwen Zhu
 * @version 1.0
 * <p>Company:XiPinTech</p>
 * <p>Copyright:Copyright(c)2015</p>
 */
public enum DataStatusEnum {
	/**
	 * 已上传
	 */
	UPLOAD(1, "Uploaded", "已上传") {
		@Override
		public boolean to(int status) {
			return false;
		}
	},
	/**
	 * 清单已提交
	 */
	COMMIT(3, "Pre Alert", "清单已提交") {

		@Override
		public boolean to(int status) {
			if (UPLOAD.getValue() == status) {
				return true;
			}
			return false;
		}

	},
	/**
	 * 录入重量中
	 */
	INPUTING_WEIGHT(5, "Acceptance in Progress", "录入重量中") {

		@Override
		public boolean to(int status) {
			if (COMMIT.getValue() == status) {
				return true;
			}
			if (INPUTING_WEIGHT.getValue() == status) {
				return true;
			}
			return false;
		}

	},
	/**
	 * 已录入重量
	 */
	INPUTED_WEIGHT(7, "Acceptanced", "已录入重量") {

		@Override
		public boolean to(int status) {
			if (COMMIT.getValue() == status) {
				return true;
			}
			if (INPUTING_WEIGHT.getValue() == status) {
				return true;
			}
			return false;
		}

	},
	/**
	 * 已录入重量（强制提交，将删除未录入重量的邮包）
	 */
	INPUTED_WEIGHT_T(8, "Acceptanced", "已录入重量") {

		@Override
		public boolean to(int status) {
			if (COMMIT.getValue() == status) {
				return true;
			}
			if (INPUTING_WEIGHT.getValue() == status) {
				return true;
			}
			return false;
		}

	},
	/**
	 * 邮局操作完毕
	 */
	OPERAT_FINISH(9, "Process Completed", "邮局操作完毕") {

		@Override
		public boolean to(int status) {
			if (INPUTED_WEIGHT.getValue() == status) {
				return true;
			}
			if (INPUTED_WEIGHT_T.getValue() == status) {
				return true;
			}
			return false;
		}

	},
	/**
	 * 邮局CN38操作完毕
	 */
	CN38_FINISH(11, "Process Completed with CN38", "邮局CN38操作完毕") {

		@Override
		public boolean to(int status) {
			if (INPUTED_WEIGHT.getValue() == status) {
				return true;
			}
			if (INPUTED_WEIGHT_T.getValue() == status) {
				return true;
			}
			if (OPERAT_FINISH.getValue() == status) {
				return true;
			}
			if (CN38_FINISH.getValue() == status) {
				return true;
			}
			return false;
		}

	};
	private int value;
	private String messageEn;
	private String messageCn;

	/**
	 * 
	 * 方法用途: 跳转前置状态验证<br>
	 * 实现步骤: <br>
	 * @param status
	 * @return
	 */
	public abstract boolean to(int status);
	
	/**
	 * 
	 * 方法用途: 获取状态描述<br>
	 * 实现步骤: <br>
	 * @param status
	 * @param local
	 * @return
	 */
	public static String getEscape(int status, String local){
		DataStatusEnum returnDataStatus = null;
		for (DataStatusEnum dataStatus : DataStatusEnum.values()) {
			if(dataStatus.getValue() == status){
				returnDataStatus = dataStatus;
			}
		}
		if(returnDataStatus == null){
			return "";
		}
		if("en_US".equals(local)){
			return returnDataStatus.messageEn;
		}else{
			return returnDataStatus.messageCn;
		}
	}
	
	public boolean equals(Integer status){
		return this.getValue() == status;
	}

	private DataStatusEnum(int value, String messageEn, String messageCn) {
		this.value = value;
		this.messageEn = messageEn;
		this.messageCn = messageCn;
	}

	/**
	 * {@linkplain #value}
	 */
	public int getValue() {
		return value;
	}

	/**
	 * {@linkplain #messageEn}
	 */
	public String getMessageEn() {
		return messageEn;
	}

	/**
	 * {@linkplain #messageCn}
	 */
	public String getMessageCn() {
		return messageCn;
	}
}

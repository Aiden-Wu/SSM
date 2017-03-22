package com.xipin.est.service.impl.item.check.eum;

import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.model.eum.ServiceTypeEnum;
import com.xipin.est.service.impl.item.check.DataForExcelCheck;
import com.xipin.est.service.impl.item.check.RedisConstant;
import com.xipin.est.service.vo.excel.check.CheckResult;
import com.xipin.est.utils.comm.StringUtils;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;
import com.xipin.est.utils.serialize.ObjectSerializeUtils;

public enum ExcelRuleEnum {

	规则1_列值不为和格式空校验A((short) 1, MsgEnum.S_RULE_MSG_1.getVal(), "列不为空和格式校验") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			ItemsPo po = data.getItem();
			StringBuilder sb = new StringBuilder();
			boolean hasErr = false;
			CheckResult rslt = new CheckResult();
			rslt.setType(this.getType());
			rslt.setSign("第" + po.getRowNum() + "行");
			rslt.setId(data.getItem().getRowNum() + "");
			if (po.getDispatchDate() == null) {
				hasErr = true;
				sb.append("DispatchDate").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getCustomerNo())) {
				hasErr = true;
				sb.append("CustomerNo").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getDispatchNo())) {
				hasErr = true;
				sb.append("DispatchNo").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getDispatchType())) {
				hasErr = true;
				sb.append("DispatchType").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getLockedBagNo())) {
				hasErr = true;
				sb.append("LockedBagNo").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getPpiNo())) {
				hasErr = true;
				sb.append("PpiNo").append(this.getMsg()).append("<br>");
			}
			if (po.getEta() == null) {
				hasErr = true;
				sb.append("ETA").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getBagNo())) {
				hasErr = true;
				sb.append("BagNo").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getReceiverCountryCode())) {
				hasErr = true;
				sb.append("ReceiverCountryCode").append(this.getMsg())
						.append("<br>");
			}
			if (StringUtils.isEmpty(po.getItemDescription())) {
				hasErr = true;
				sb.append("ItemDescription").append(this.getMsg())
						.append("<br>");
			}
			if (po.getQty() == null) {
				hasErr = true;
				sb.append("QTY").append(this.getMsg()).append("<br>");
			}
			if (po.getItemValue() == null) {
				hasErr = true;
				sb.append("ITEM_VALUE").append(this.getMsg()).append("<br>");
			}
			if (po.getTerms() == null) {
				hasErr = true;
				sb.append("Terms").append(this.getMsg()).append("<br>");
			}
			if (!hasErr) {
				return null;
			} else {
				rslt.setMsg(sb.toString());
				return rslt;
			}
		}
	},
	规则2_批次号与预报清单是否一致((short) 2, MsgEnum.S_RULE_MSG_2.getVal(), "批次号与预报清单是否一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getDispatchNo() != null
					&& !data.getDispatchNo().equals(
							data.getItem().getDispatchNo())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则3_国家代码在系统中是否存在((short) 3, MsgEnum.S_RULE_MSG_3.getVal(), "国家代码在系统中是否存在") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getCountryCode() != null
					&& !data.getCountryCode().contains(
							data.getItem().getReceiverCountryCode())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则4_航班号是否与预报清单所填一致((short) 4, MsgEnum.S_RULE_MSG_4.getVal(),
			"规则4_航班号是否与预报清单所填一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getTrunkNo() != null
					&& !data.getTrunkNo()
							.equals(data.getItem().getTruckingNo())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则5_客户编号是否与预报清单中是否一致((short) 5, MsgEnum.S_RULE_MSG_5.getVal(),
			"客户编号是否与预报清单中一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getCustomerCode() != null
					&& !data.getCustomerCode().equals(
							data.getItem().getCustomerNo())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则6_邮寄方式与预报清单中是否一致((short) 6, MsgEnum.S_RULE_MSG_6.getVal(),
			"邮寄方式与预报清单中是否一致") {

		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getPostType() != null
					&& !data.getPostType().equals(
							data.getItem().getDispatchType())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}

	},
	规则7_邮袋非MX开头目的国是否保持一致((short) 7, MsgEnum.S_RULE_MSG_7.getVal(),
			"非混合邮袋目的国是否保持一致") {

		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getBagNo() != null
					&& !data.getBagNo().toLowerCase().startsWith("mx")) {
				if (data.getTargetCountryCode() != null
						&& !data.getTargetCountryCode().equals(
								data.getItem().getReceiverCountryCode())) {
					return new CheckResult(this.getType(), "第"
							+ data.getItem().getRowNum() + "行", this.getMsg(),
							data.getItem().getRowNum() + "");
				}
			}
			return null;
		}

	},
	规则8_邮袋号是否重复((short) 8, MsgEnum.S_RULE_MSG_8.getVal(), "邮袋号是否重复") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			// List<CheckResult> rslt = data.getMap().get(this.getType());
			// if(data.getMap().get(this.getType()) != null && rslt.size() > 0){
			// return new CheckResult(this.getType(), "第" +
			// data.getItem().getRowNum() + "行", this.getMsg(),
			// data.getItem().getRowNum()+"");
			// }
			if (!StringUtils.isEmpty(data.getItem().getBagNo())
					&& data.getCommSetCache().exists(RedisConstant.BAG_NO_SET,
							data.getItem().getBagNo())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			data.getBagNoSet().add(
					ObjectSerializeUtils.serializeObject(data.getBagNo()));
			return null;
		}
	},
	规则9_跟踪号是否重复((short) 9, MsgEnum.S_RULE_MSG_9.getVal(), "跟踪号是否重复") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			String no = data.getItem().getReferenceId();
			if (!StringUtils.isEmpty(no)
					&& data.getCommSetCache().exists(RedisConstant.REF_ID_SET,
							no)) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			data.getRefIdSet().add(
					ObjectSerializeUtils.serializeObject(data.getItem()
							.getReferenceId()));
			data.getRefIdStrSet().add(data.getItem().getReferenceId());
			return null;
		}
	},
	规则10_许可邮号与预报清单中是否一致((short) 10, MsgEnum.S_RULE_MSG_10.getVal(),
			"许可邮号与预报清单中是否一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getPpiNo() != null
					&& !data.getPpiNo().equals(data.getItem().getPpiNo())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则11_跟踪号在本批次重复((short) 11, MsgEnum.S_RULE_MSG_11.getVal(), "跟踪号在本批次是否重复") {// 配置的时候需要在规则9之后
		@Override
		public CheckResult check(DataForExcelCheck data) {
			String no = data.getItem().getReferenceId();
			if (!StringUtils.isEmpty(no) && data.getRefIdStrSet().contains(no)) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg() + "["
						+ no + "]", data.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则12_邮袋号格式校验((short) 12, MsgEnum.S_RULE_MSG_12.getVal(), "邮袋号格式是否正确") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			String bagNo = data.getItem().getBagNo();
			if (data.getTargetCountryCode().equals("ES")) {
				System.out.println(data.getRefRegx());
				System.out.println(bagNo);
			}
			if (!StringUtils.isEmpty(bagNo)
					&& !bagNo.matches(data.getBagRegx())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg() + "["
						+ bagNo + "]" + "[" + data.getBagRegx() + "]", data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则13_批次号格式校验((short) 13, MsgEnum.S_RULE_MSG_13.getVal(), "批次号格式是否正确") {
		@Override
		public CheckResult check(DataForExcelCheck data) {// 待确定
			return null;
		}
	},
	规则14_跟踪号格式校验((short) 14, MsgEnum.S_RULE_MSG_14.getVal(), "跟踪号格式是否正确") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			String ref = data.getItem().getReferenceId();
			if (!StringUtils.isEmpty(ref) && !ref.matches(data.getRefRegx())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg() + "["
						+ ref + "]" + "[" + data.getRefRegx() + "]", data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则15_扎带号是否重复((short) 15, MsgEnum.S_RULE_MSG_15.getVal(), "扎带号是否重复") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			String sealNo = data.getItem().getSealNo();
			if (!StringUtils.isEmpty(sealNo)
					&& data.getCommSetCache().exists(RedisConstant.SEAL_NO_SET,
							sealNo)) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			data.getSealSet().add(ObjectSerializeUtils.serializeObject(sealNo));
			return null;
		}
	},
	规则16_列值不为和格式空校验B((short) 16, MsgEnum.S_RULE_MSG_16.getVal(), "列不为空和格式校验") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			ItemsPo po = data.getItem();
			StringBuilder sb = new StringBuilder();
			boolean hasErr = false;
			CheckResult rslt = new CheckResult();
			rslt.setType(this.getType());
			rslt.setSign("第" + po.getRowNum() + "行");
			rslt.setId(data.getItem().getRowNum() + "");
			if (StringUtils.isEmpty(po.getDispatchNo())) {
				hasErr = true;
				sb.append("DispatchNo").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getPostal())) {
				hasErr = true;
				sb.append("Postal").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getService())) {
				hasErr = true;
				sb.append("Service").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getBagNo())) {
				hasErr = true;
				sb.append("Bag No").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getReceiverCountryCode())) {
				hasErr = true;
				sb.append("Country Code").append(this.getMsg()).append("<br>");
			}
			if (po.getWeight() == null) {
				hasErr = true;
				sb.append("Weight").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getSealNo())) {
				hasErr = true;
				sb.append("Seal No").append(this.getMsg()).append("<br>");
			}
			if (StringUtils.isEmpty(po.getDispatchNo())) {
				hasErr = true;
				sb.append("Dispatch No").append(this.getMsg()).append("<br>");
			}
			if (data.getPostType().equals("OM")) {
				if (po.getQuantity() == null) {
					hasErr = true;
					sb.append("Quantity").append(this.getMsg()).append("<br>");
				}
			} else {
				if (StringUtils.isEmpty(po.getReferenceId())) {
					hasErr = true;
					sb.append("Tracking No").append(this.getMsg())
							.append("<br>");
				}
			}

			if (!hasErr) {
				return null;
			} else {
				rslt.setMsg(sb.toString());
				return rslt;
			}
		}
	},
	规则17_邮局编码与清单所填是否一致((short) 17, MsgEnum.S_RULE_MSG_17.getVal(),
			"邮局编码与清单所填是否一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getBmCode() != null
					&& !data.getBmCode().equals(data.getItem().getPostal())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	},
	规则18_服务类型与清单所填是否一致((short) 18, MsgEnum.S_RULE_MSG_18.getVal(),
			"服务类型与清单所填是否一致") {
		@Override
		public CheckResult check(DataForExcelCheck data) {
			if (data.getServiceType() != null
					&& !ServiceTypeEnum.选择.getTypeName(data.getServiceType())
							.equals(data.getItem().getService())) {
				return new CheckResult(this.getType(), "第"
						+ data.getItem().getRowNum() + "行", this.getMsg(), data
						.getItem().getRowNum() + "");
			}
			return null;
		}
	};

	public abstract CheckResult check(DataForExcelCheck data);

	private Short type;
	private String msg;
	private String title;
	private String lanuage;

	private ExcelRuleEnum(Short type, String msg, String title) {
		this.type = type;
		this.msg = msg;
		this.title = title;
	}

	public Short getType() {
		return type;
	}

	public String getMsg() {
		return MsgConfig.getMessage(this.msg, this.lanuage);
	}

	public String getTitle() {
		return title;
	}

	public void setLanuage(String lanuage) {
		this.lanuage = lanuage;
	}

}

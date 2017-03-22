package com.xipin.est.service.impl.item.check;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.xipin.est.db.po.ItemsPo;
import com.xipin.est.service.impl.item.check.eum.ExcelRuleEnum;
import com.xipin.est.service.vo.excel.check.CheckResult;
import com.xipin.est.utils.contants.Constants;
import com.xipin.est.utils.msg.MsgConfig;
import com.xipin.est.utils.msg.eum.MsgEnum;

public enum PostOfficeStaticRuleEnum {
	选择(null, "-1", "", null, null), 
	巴拉圭PZ(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"6",
			"PZ",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}	
			), 
	巴拉圭OM(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"6",
			"OM",
			new String[]{"Postal","Service","Product", "Bag No", "Country", "Weight", "Quantity", "Seal No", "Dispatch No"},
			new String[]{"Postal", "Service", "DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "Qty", "SealNo", "DispatchNo"}
			),
	巴拉圭R(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"6",
			"R",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}
			),
	巴拉圭EMS(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"6",
			"EMS",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}
			),
	泰国PZ(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"5",
			"PZ",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}		
			), 
	泰国OM(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"5",
			"OM",
			new String[]{"Postal","Service","Product", "Bag No", "Country", "Weight", "Quantity", "Seal No", "Dispatch No"},
			new String[]{"Postal", "Service", "DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "Qty", "SealNo", "DispatchNo"}
			),
	泰国R(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"5",
			"R",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}
			),
	泰国EMS(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则16_列值不为和格式空校验B,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则17_邮局编码与清单所填是否一致,
			ExcelRuleEnum.规则18_服务类型与清单所填是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则12_邮袋号格式校验,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则14_跟踪号格式校验,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则13_批次号格式校验,
			ExcelRuleEnum.规则15_扎带号是否重复
			},
			"5",
			"EMS",
			new String[]{"Postal","Service", "Product", "Bag No", "Country", "Weight", "Tracking No", "Seal No", "Dispatch No"},
			new String[]{"Postal","Service","DispatchType", "BagNo", "ReceiverCountryCode", "Weight", "ReferenceId", "SealNo", "DispatchNo"}
			),		
	台湾(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则1_列值不为和格式空校验A,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则4_航班号是否与预报清单所填一致,
			ExcelRuleEnum.规则5_客户编号是否与预报清单中是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则10_许可邮号与预报清单中是否一致
			},
			"7",
			"",
			new String[]{"ID","DispatchDate","CustomerNo","DispatchNo","DispatchType","LockedBagNo","PpiNo","AirwayBillNo","Flight/TruckingNo","ETA",
			"ReferenceID","BagNo","ShipperName","ShipperAddress1","ShipperAddress2","ShipperCity","ShipperState","ShipperPostalCode","ShipperCountryCode","ReceiverAddress1",
			"ReceiverAddress2","ReceiverCity","ReceiverState","ReceiverPostcode","ReceiverCountryCode","ReceiverName","ReceiverPhone","ReceiverEmail","ItemDescription","Qty",
			"Weight","Length","Height","Width","ITEM_VALUE","ReferenceIdentificationB","Terms"},
			new String[]{"","DispatchDate","CustomerNo","DispatchNo","DispatchType","LockedBagNo","PpiNo","AirwayBillNo","TruckingNo","Eta",
			"ReferenceId","BagNo","ShipperName","ShipperAddress1","ShipperAddress2","ShipperCity","ShipperState","ShipperPostalCode","ShipperCountryCode","ReceiverAddress1",
			"ReceiverAddress2","ReceiverCity","ReceiverState","ReceiverPostcode","ReceiverCountryCode","ReceiverName","ReceiverPhone","ReceiverEmail","ItemDescription","Qty",
			"Weight","Length","Height","Width","ItemValue","ReferenceIdentificationB","Terms"}
			),
	马邮(new ExcelRuleEnum[] {
			ExcelRuleEnum.规则1_列值不为和格式空校验A,
			ExcelRuleEnum.规则2_批次号与预报清单是否一致,
			ExcelRuleEnum.规则3_国家代码在系统中是否存在,
			ExcelRuleEnum.规则4_航班号是否与预报清单所填一致,
			ExcelRuleEnum.规则5_客户编号是否与预报清单中是否一致,
			ExcelRuleEnum.规则6_邮寄方式与预报清单中是否一致,
			ExcelRuleEnum.规则7_邮袋非MX开头目的国是否保持一致,
			ExcelRuleEnum.规则8_邮袋号是否重复,
			ExcelRuleEnum.规则11_跟踪号在本批次重复,
			ExcelRuleEnum.规则9_跟踪号是否重复,
			ExcelRuleEnum.规则10_许可邮号与预报清单中是否一致
			},
			"4",
			"",
			new String[]{"ID","DispatchDate","CustomerNo","DispatchNo","DispatchType","LockedBagNo","PpiNo","AirwayBillNo","Flight/TruckingNo","ETA",
			"ReferenceID","BagNo","ShipperName","ShipperAddress1","ShipperAddress2","ShipperCity","ShipperState","ShipperPostalCode","ShipperCountryCode","ReceiverAddress1",
			"ReceiverAddress2","ReceiverCity","ReceiverState","ReceiverPostcode","ReceiverCountryCode","ReceiverName","ReceiverPhone","ReceiverEmail","ItemDescription","Qty",
			"Weight","Length","Height","Width","ITEM_VALUE","ReferenceIdentificationB","Terms"},
			new String[]{"","DispatchDate","CustomerNo","DispatchNo","DispatchType","LockedBagNo","PpiNo","AirwayBillNo","TruckingNo","Eta",
			"ReferenceId","BagNo","ShipperName","ShipperAddress1","ShipperAddress2","ShipperCity","ShipperState","ShipperPostalCode","ShipperCountryCode","ReceiverAddress1",
			"ReceiverAddress2","ReceiverCity","ReceiverState","ReceiverPostcode","ReceiverCountryCode","ReceiverName","ReceiverPhone","ReceiverEmail","ItemDescription","Qty",
			"Weight","Length","Height","Width","ItemValue","ReferenceIdentificationB","Terms"}
			);

	private ExcelRuleEnum[] rules;
	private String type;
	private String[] headers;
	private String dispatchType;
	private String[] names;

	private PostOfficeStaticRuleEnum(ExcelRuleEnum[] rules, String type, String dispatchType, String[] headers, String[] names) {
		this.rules = rules;
		this.type = type;
		this.headers = headers;
		this.dispatchType = dispatchType;
		this.names = names;
	}

	public ExcelRuleEnum[] getRules() {
		return rules;
	}

	public String getType() {
		return type;
	}

	public String[] getHeaders() {
		return headers;
	}

	public String[] getNames() {
		return names;
	}

	public String getDispatchType() {
		return dispatchType;
	}

	public PostOfficeStaticRuleEnum get(String type, String dispatchType) {
		for (PostOfficeStaticRuleEnum e : PostOfficeStaticRuleEnum.values()) {
			if (e.getType().equals(type)) {
				if(StringUtils.isEmpty(e.getDispatchType()) || e.getDispatchType().equals(dispatchType)){
					return e;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(PostOfficeStaticRuleEnum.选择.get("5", "PZ"));
	}

	public void check(DataForExcelCheck data) {
		HashMap<Short, List<CheckResult>> map = data.getMap();
		HashMap<Short, Integer> totalMap = data.getTotalMap();
//		Set<Short> set = new HashSet<>();
		for (ExcelRuleEnum e : this.rules) {
//			if(set.contains(e.getType())){
//				continue;
//			}
			{//国际化
				e.setLanuage(data.getLanuage());
			}
			CheckResult rslt = e.check(data);
			if(rslt != null){
				if(map.get(rslt.getType()) == null){
					ArrayList<CheckResult> rsltList = new ArrayList<>();
					rsltList.add(rslt);
					map.put(rslt.getType(), rsltList);
					totalMap.put(rslt.getType(), 1);
				} else {
					List<CheckResult> list = map.get(rslt.getType());
					if(list.size() <= 20){
						list.add(rslt);
						map.put(rslt.getType(), list);
					} else {//控制错误返回信息， 超过20的抛弃
						//set.add(e.getType());
					}
					totalMap.put(rslt.getType(), totalMap.get(rslt.getType()) + 1);
				}
			}
		}
	}
	
	public List<CheckResult> checkCloumnName(String[] headers, HashMap<String, Integer> map, String language){
		List<CheckResult> list = new ArrayList<CheckResult>();
		int j = 0;
		for(String h : this.getHeaders()){
			boolean flag = false;
			int i = 0;
			for(String header : headers){
				if(header != null && h.toLowerCase().equals(header.toLowerCase())){
					flag = true;
					map.put(h, i);
				}
				i++; 
			}
			if(!flag){
				CheckResult rslt = new CheckResult();
				rslt.setSign(h);
				rslt.setType((short)1);
				rslt.setMsg(MsgConfig.getMessage(MsgEnum.MISS_COL.getVal(), language));
				rslt.setId(h);
				list.add(rslt);
			} else {
				map.put(h + Constants.SYS_HEAD, j);
			}
			j++;
		}
		return list;
	}

	public ItemsPo setVaFromExcel(String[] headers, String[] row, HashMap<String, Integer> map){
		ItemsPo po = new ItemsPo();
		Class<?> clazz = po.getClass();
		for(String head : headers){
			if(StringUtils.isNotEmpty(this.getNames()[map.get(head + Constants.SYS_HEAD)])){
				String methodName = "set" + this.getNames()[map.get(head + Constants.SYS_HEAD)];
				try {
					Method method = clazz.getMethod(methodName, String.class);
					method.invoke(po, row[map.get(head)]);
				} catch (Exception e) {
					//Do nothing
					e.printStackTrace();
				} 
			}
		}
		return po;
	}
}

var language = $.cookie("Language") || "zh_CN";

var _name = 'name';
var _parentName = 'parentName';
var _departmentName = 'departmentName';
var _orgName = 'orgName';
var _pageName = '{0} 共  {1} 页',
	_recordtextName = '{0} - {1} 共	{2}';
var _tips = "提示信息";
var _sure = "确定";
var _cancel = "取消";
var rsltMsg = {
		"0":"Excel数据为空",
		"1":"上传表格格式错误",
		"2":"[DispatchNo]批次号与预报清单不一致",
		"3":"[ReceiverCountryCode]国家代码不存在",
		"4":"[Flight/TruckingNo]航班号与预报清单所填不一致",
		"5":"[CustomerNo]客户编号与预报清单不一致",
		"6":"[DispatchType]邮寄方式与预报清单中不一致",
		"7":"[ReceiverCountryCode]邮袋非MX开头目的国未保持一致",
		"8":"[BagNo]邮袋号已存在",
		"9":"[referenceId]跟踪号已存在",
		"10":"[ppiNo]与预报清单中不一致",
		"11":"[referenceId]在本批次重复",
		"12":"[bagNo]格式有误",
		"13":"[dispatchNo]格式有误",
		"14":"[referenceId]格式有误",
		"15":"[Seal Number]扎带号已存在",
		"16":"格式不正确或者列值为空",
		"17":"[Postal]邮局编码与清单所填不一致",
		"18":"[Service]服务类型与清单所填不一致"
};
if(language == "en_US"){
	/**
	 * 表单验证js国际化
	 * */
	formValidation.defMsg = {"NOTNULL":"Required", "LEN_MIN_ERR":"Min length x", "LEN_MAX_ERR":"Max length x"};
	
	/**
	 * 名称国际化
	 */
	_name = 'ename';
	_parentName = 'parentEName';
	_departmentName = 'departmentEName';
	_orgName = 'orgEName';
	_pageName = 'Page {0} of {1}';
	_recordtextName = 'View {0} - {1} of {2}';
	_tips = "Tips";
	_sure = "OK";
	_cancel = "Cancel";
	rsltMsg = {
			"0":"Excel data is empty",
			"1":"Upload a tabular format error",
			"2":"[DispatchNo]Dispatch No. inconsistent with pre list filled",
			"3":"[ReceiverCountryCode]Country code does not exist",
			"4":"[Flight/TruckingNo]Flight No. inconsistent with pre list filled",
			"5":"[CustomerNo]Customer No. inconsistent with pre list filled",
			"6":"[DispatchType]DispatchType inconsistent with pre list filled",
			"7":"[ReceiverCountryCode]The bags's receiver country inconsistent which not start with 'MX'",
			"8":"[BagNo]Bag No. already exist",
			"9":"[referenceId]ReferenceId already exist",
			"10":"[ppiNo]PPI No. inconsistent with pref list filled",
			"11":"[referenceId]The referenceId is repeat in this dispatch",
			"12":"[bagNo]Format Invalid",
			"13":"[dispatchNo]Format Invalid",
			"14":"[referenceId]Format Invalid",
			"15":"[Seal Number]Seal No. already exist",
			"16":"Upload a tabular format error or the null value",
			"17":"[Postal]Post code inconsistent with pre list filled",
			"18":"[Service]Service type inconsistent with pre list filled"
	};
}


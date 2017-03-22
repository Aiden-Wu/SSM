package com.xipin.est.utils.msg.eum;

import com.xipin.est.utils.comm.ConfigEnum;

public enum MsgEnum implements ConfigEnum {
	
	S_DISPATCH_EXISTS("s_dispatch_exists"),
	S_CREATE_NO_FAILED("s_create_no_failed"),
	S_RULE_MSG_0("s_rule_msg_0"),
	S_RULE_MSG_1("s_rule_msg_1"),
	S_RULE_MSG_2("s_rule_msg_2"),
	S_RULE_MSG_3("s_rule_msg_3"),
	S_RULE_MSG_4("s_rule_msg_4"),
	S_RULE_MSG_5("s_rule_msg_5"),
	S_RULE_MSG_6("s_rule_msg_6"),
	S_RULE_MSG_7("s_rule_msg_7"),
	S_RULE_MSG_8("s_rule_msg_8"),
	S_RULE_MSG_9("s_rule_msg_9"),
	S_RULE_MSG_10("s_rule_msg_10"),
	S_RULE_MSG_11("s_rule_msg_11"),
	S_RULE_MSG_12("s_rule_msg_12"),
	S_RULE_MSG_13("s_rule_msg_13"),
	S_RULE_MSG_14("s_rule_msg_14"),
	S_RULE_MSG_15("s_rule_msg_15"),
	S_RULE_MSG_16("s_rule_msg_16"),
	S_RULE_MSG_17("s_rule_msg_17"),
	S_RULE_MSG_18("s_rule_msg_18"),
	MISS_COL("miss_col"),
	NO_DATA("no_data"),
	EXCEL_DATA_INVAILD("excel_data_invaild"),
	FILE_LIMIT_30M("file_limit_30M"),
	FILE_FORMAT_XLS_OR_XLSX("file_format_xls_or_xlsx"),
	s_password_not_empty("s_password_not_empty"),
	s_passwordorusername_error("s_passwordorusername_error"),
	s_parentorg_empty("s_parentorg_empty"),
	s_username_repeat("s_username_repeat"),
	s_user_repeat("s_user_repeat"),
	s_user_empty("s_user_empty"),
	s_userstatus_exception("s_userstatus_exception"),
	s_password_error("s_password_error"),
	s_choose_parentorg("s_choose_parentorg"),
	s_choose_orgtype("s_choose_orgtype"),
	s_choose_orglevel("s_choose_orglevel"),
	s_orgname_repeat("s_orgname_repeat"),
	s_initdata_delete("s_initdata_delete"),
	s_hasbm_delete("s_hasbm_delete"),
	s_hasry_delete("s_hasry_delete"),
	s_cunstomer_empty("s_cunstomer_empty"),
	s_postid_empty("s_postid_empty"),
	s_postaccountno_empty("s_postaccountno_empty"),
	s_postpino_empty("s_postpino_empty"),
	s_post_unreasonable("s_post_unreasonable"),
	s_registerpost_repeat("s_registerpost_repeat"),
	s_customer_unexists("s_customer_unexists"),
	s_org_notcustomer("s_org_notcustomer"),
	s_org_notpost("s_org_notpost"),
	s_post_empty("s_post_empty"),
	s_bmprefix_illegality("s_bmprefix_illegality"),
	s_post_notauthority("s_post_notauthority"),
	s_postdata_dealt("s_postdata_dealt"),
	s_authdata_illegality("s_authdata_illegality"),
	s_userinfo_error("s_userinfo_error"),
	s_bminfo_error("s_bminfo_error"),
	s_countrycode_repeat("s_countrycode_repeat"),
	m_cn35_exist("m_cn35_exist"),
	m_detailList_not_exist("m_detailList_not_exist"),
	m_detailList_state_not_correct("m_detailList_state_not_correct"),
	m_detailList_service_not_correct("m_detailList_service_not_correct"),
	m_detailList_post_office_not_correct("m_detailList_post_office_not_correct"),
	m_detailList_product_not_correct("m_detailList_product_not_correct"),
	m_upload_success_remind_1("m_upload_success_remind_1"),
	m_upload_success_remind_2("m_upload_success_remind_2"),
	c_bag_weight_details_list("c_bag_weight_details_list"),
	c_export_list("c_export_list"),
	SERVER_ERR("server_err"),
	BAGS("bags"),
	WEIGHT("weight"),
	
//	p_start_date_format_error("p_start_date_format_error"),
//	p_end_date_format_error("p_end_date_format_error"),
//	p_start_submit_date_format_error("p_start_submit_date_format_error"),
//	p_end_submit_date_format_error("p_end_submit_date_format_error"),
//	p_server_type_format_error("p_server_type_format_error"),//服务类型参数格式不正确
//	p_lack_cn35_parameter("p_lack_cn35_parameter"),//缺少cn35参数
//	p_cn35_is_null("p_cn35_is_null"),//cn35为空
//	p_lack_cn38_parameter("p_lack_cn38_parameter"),////缺少cn38参数
//	p_lack_country_code_parameter("p_lack_country_code_parameter"),
//	p_cn38_is_null("p_cn38_is_null"),
//	p_country_code_is_null("p_country_code_is_null"),
//	p_actual_package_num_format_error("p_actual_package_num_format_error"),//实际邮袋数量格式不正确
//	p_actual_package_weight_format_error("p_actual_package_weight_format_error"),
	
	;

	private String val;

	private MsgEnum(String val) {
		this.val = val;
	}

	@Override
	public String getVal() {
		return val;
	}

}

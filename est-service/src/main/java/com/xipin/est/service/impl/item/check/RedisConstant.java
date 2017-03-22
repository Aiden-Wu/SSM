package com.xipin.est.service.impl.item.check;

public interface RedisConstant {

	String EST_IS_USER_REDIS_CHECK_REPEAT = "est_check_repeat";
	
	String EST_REF_ID_START = "EST";
	
	String LOT_NUM_SET = "lot_num_set";
	
	String BAG_NO_SET = "bag_no_set";
	
	String REF_ID_SET = "ref_id_set";
	
	String LOT_NUM_SET_ING = "lot_num_ing";
	
	String SEAL_NO_SET  = "seal_no_set";
	
	Long LOT_NUM_TIMEOUT = 60*10L;
}


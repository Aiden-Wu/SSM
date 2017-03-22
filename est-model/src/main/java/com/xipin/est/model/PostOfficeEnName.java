package com.xipin.est.model;

public enum PostOfficeEnName {
	
	选择("-1","-1", -1L),
	巴拉圭邮局("BLG","巴拉圭邮局", 6L),
	泰国("TG","泰国", 5L),
	中国台湾("TW","中国台湾", 7L),
	马邮("MY","马邮", 4L),
	其他("QT", "", -2L);
	
	private String enName;
	private String chName;
	private Long id;
	
	private PostOfficeEnName(String enName, String chName, Long id) {
		this.enName = enName;
		this.chName = chName;
		this.id = id;
	}


	public String getEnName(Long id) {
		for(PostOfficeEnName e : PostOfficeEnName.values()){
			if(id != null && id > 0 && e.id.equals(id)){
				return e.enName;
			} 
		}
		return 其他.enName;
	}

	public String getChName() {
		return chName;
	}


	public Long getId() {
		return id;
	}

	public static void main(String[] args) {
		System.out.println(PostOfficeEnName.选择.getEnName(10L));
		System.out.println(PostOfficeEnName.选择.getEnName(4L));
		System.out.println(PostOfficeEnName.选择.getEnName(null));
		System.out.println(PostOfficeEnName.选择.getEnName(-1L));
	}
}

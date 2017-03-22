package com.xipin.est.service.impl.item.check;

public enum PostOfficeTypeName {
	选择(-1L, -1L, ""),
	MY01(4L, 8L, "VP"),
	MY02(4L, 9L, "SVP"),
	MY(4L, -1L, "MY"),
	TH01(5L, 10L, "TH"),
	TH(5L, -1L, "TH"),
	PY01(6L, 11L, "PY"),
	PY02(6L, 12L, "PY"),
	PY03(6L, 13L, "PY"),
	PY(6L, -1L, "PY"),
	TW01(7L, 14L, "TW"),
	TW(7L, -1L, "TW"),
	DEFAULT(null, null, "..");
	
	private Long jgId;
	
	private Long bmId;
	
	private String name;
	
	private PostOfficeTypeName(Long jgId, Long bmId, String name) {
		this.jgId = jgId;
		this.bmId = bmId;
		this.name = name;
	}

	public Long getJgId() {
		return jgId;
	}

	public Long getBmId() {
		return bmId;
	}

	public String getName(Long jgId, Long bmId) {
		String n = null;
		if(bmId == null || jgId == null){
			return DEFAULT.name;
		}
		for(PostOfficeTypeName e : PostOfficeTypeName.values()){
			if(jgId.equals(e.jgId) && bmId.equals(e.bmId)){
				return e.name;
			}
		}
		if(bmId.equals(-1L) && n == null){
			return DEFAULT.name;
		}
		if(n == null && !bmId.equals(-1L)){
			n = this.getName(jgId, -1L);
			return n;
		}
		return DEFAULT.name;
	}
	
	public static void main(String[] args) {
		System.out.println(选择.getName(7L, 9L));
		System.out.println(选择.getName(10L, 11L));
		System.out.println(选择.getName(4L, 8L));
		System.out.println(选择.getName(null, null));
	}
	
}

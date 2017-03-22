function SysConfig(static_resource_url, pub_resource_url, domain, up_domain, master_login_url){
	var static_resource_url = static_resource_url;
	var pub_resource_url = pub_resource_url;
	var domain = domain;
	var up_domain = up_domain;
	var master_login_url = master_login_url;
	return {
		getStatic_resource_url : function(){
			return static_resource_url;
		},
		getPub_resource_url : function(){
			return pub_resource_url;
		},
		getDomain : function(){	
			return domain;
		},
		getUp_domain : function(){
			return up_domain;
		},
		getMaster_Login_Url : function(){
			return master_login_url;
		}
	};
};

function MatchName(obj){
	this.obj = obj;
	
	this.getName = function(key){
		return obj[key];
	};
};


var TypeEnum = function(){
	var obj = {
		REG_TYPE_ENUM:{"1":"自有用户_手机", "2":"自有用户_邮箱", "3":"快捷登录", "4":"第三方登录"},
		USER_SEX__ENUM:{"1":"男", "2":"女", "0":"未选择"},
		DESIGNER_AUDITSTATUS__ENUM:{"0":"未审核", "1":"审核通过", "2":"审核不通过"},
		GOODS_AUDITSTATUS__ENUM:{"0":"未审核", "1":"审核通过", "2":"审核不通过"},
		
		
		COMM_STATUS__ENUM:{"0":"禁用", "1":"正常"}
	};
	return {
		get : function(key){
			return obj[key];
		}
	};
};
var typeEnum = TypeEnum();


/**
 * required bootstrap tooltip
 * @Author: danny duan
 */
function FormValidation(){
	
	/** jq objcet */
	this.formObj = {};
	
	this.setFormObj = function(formObj){
		this.formObj = formObj;
	};
	
	this.defMsg = {"NOTNULL":"不能为空", "LEN_MIN_ERR":"长度不能小于x", "LEN_MAX_ERR":"长度不能大于x"};
	
	/**
	 * data: {isBlur: true/false, }
	 */
	this.init = function(data){
		var me = this;
		{//just log for test, if in product please delete!
			var sign = this.formObj.attr("id") || this.fromObj.attr("name") || this.formObj.attr("action");
			//console.log("The " + sign + " is adding vaildation now!");
		}
		var inputs = this.formObj.find("input");
		for(var i = 0; i < inputs.length; i++){
			var ist = $(inputs[i]).attr("validate") || "";
			$(inputs[i]).bind("blur", function(){
				if($(this).attr("validate")){
					var vArr = $(this).attr("validate").split("&");
					for(var j = 0; j < vArr.length; j++){
						var n = vArr[j];
						if(n.indexOf("(") > 0){
							n = n.substring(0, n.indexOf("("));
						}
						if(me.vaildator[n]){
							var msg = me.vaildator[n]($(this));
							if(msg){
								me.style($(this), msg);
								return ;
							} 
						}
					}
					$(this).parent("span").removeClass("common-red-border");
					$(this).attr("data-original-title","");
				}
			});
		}
	};
	
	/**
	 * form submit check
	 */
	this.check = function(){
		var me = this;
		var inputs = this.formObj.find("input");
		for(var i = 0; i < inputs.length; i++){
			var obj = $(inputs[i]);
			var istr = $(inputs[i]).attr("validate") || "";
			var vArr = istr.split("&");
			for(var j = 0; j < vArr.length; j++){
				var n = vArr[j];
				if(n.indexOf("(") > 0){
					n = n.substring(0, n.indexOf("("));
				}
				if(me.vaildator[n]){
					var msg = me.vaildator[n](obj);
					if(msg){
						me.style(obj, msg);
						return false;
					} 
				}
			}
			obj.parent("span").removeClass("common-red-border");
			obj.attr("data-original-title","");
		}
		return true;
	};
	
	/**
	 * obj is jq object	
	 */
	this.style = function(obj, msg){
		this.clear(obj);
		obj.addClass("tooltip-error").attr("title", msg);
		obj.parent("span").addClass("common-red-border");
		//obj.focus();
		obj.validTooltip();
	};
	
	this.clear = function(obj){
		obj.parent("span").removeClass("common-red-border");
		obj.validTooltip('destroy');
	};
	
	this.notnull = function(obj){
		if(typeof(obj.val()) != "undefined" && obj.val() != ""){
			obj.validTooltip('destroy');
			return false;
		} else {
			return formValidation.defMsg.NOTNULL;
		}
	};
	
	this.len = function(obj){
		var min = 0;
		var max = null;
		var vArr = obj.attr("validate").split("&");
		var arr = [];
		for(var i = 0; i < vArr.length; i++){
			if(vArr[i].indexOf("len(") >= 0){
				arr = vArr[i].replace("len(", "").replace(")","").split("-");
				break;
			}
		}
		if(arr.length == 2){
			min = parseInt(arr[0]) || 0;
			max = parseInt(arr[1]) || null;
		}
		var val = obj.val();
		if(val.length < min){
			return formValidation.defMsg.LEN_MIN_ERR.replace("x", min);
		}
		if(max != null && val.length > max){
			return formValidation.defMsg.LEN_MAX_ERR.replace("x", max);
		}
		return false;
	};
	
	this.vaildator = {"notnull": this.notnull,"len":this.len};
};

var formValidation = formValidation || new FormValidation();
//输入框验证提示
$.fn.validTooltip = function(){
	var _a=arguments[0],self = this;
	if(_a && _a == 'destroy'){
		$(self).next('.validTooltip').remove();
	}else{
		if($(self).next('.validTooltip').length == 0){
			$('<div class="tooltip fade right validTooltip in" style="top: 2px; left: 100%; display: block;white-space: nowrap;"><div class="tooltip-arrow"></div><div class="tooltip-inner">'+$(self).attr('title')+'</div></div>').insertAfter(self)
		}else{
			$(self).next('.validTooltip').show().find('.tooltip-inner').text($(self).attr('title'));
		}
	};
}

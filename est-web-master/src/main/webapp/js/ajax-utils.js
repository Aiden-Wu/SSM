/** @author danny*/
var ajaxEngine = ajaxEngine || new AjaxEngine();

function AjaxEngine(){
	
	this.isAnsy = true;
	
	this.isCache = false;
	
	this.POST_TYPE = "POST";
	
	this.GET_TYP = "GET";
	
	this.dataType = "json";
	
	this.postAjax = function(u, d, callback){
		this.core(this.POST_TYPE, u, d, callback);
	};
	
	this.getAjax = function(u, d, callback){
		this.core(this.GET_TYPE, u, d, callback);
	};
	
	this.formAjax = function(formObj, callback){
		this.core(this.POST_TYPE, formObj.attr("action"), formObj.serialize(), callback);
	};
	
	this.core = function(t, u, d, callback){
		var me = this;
		$.ajax({
			type : t,
			url : u,
			data : d,
			ansy : this.isAnsy,
			cache : this.isCache,
			dataType : this.dataType,
			/*error : function(msg){
				me._errorFunction();
			},*/
			success : function(msg){
				if(typeof(callback) != "function"){
					return;
				}
			   callback.call(this, msg);
			}
		});
	};
	
	this.setIsAnsy = function(ansy){
		isAnsy = ansy;
	};
	
	this.setIsCache = function(cache){
		isCache = cache;
	};
	
	this._errorFunction = function(){
		alert("系统异常，请重新登录！");
		//window.location.href=zbsconf.getMaster_Login_Url();
	};

	this._callbackFunction = function(msg){
		alert("请求成功！");
	};

};
var JSON = JSON || new Json();
if(typeof(JSON) == "undefined"){
	function Json(){
		this.stringify = function(json){
			var str = "";
			if(typeof(json) != "object"){
				return "\"" + json + "\"";
			}
			if(json.length){
				str += "[";
				for(var i = 0; i < json.length; i++){
					str += this.stringify(json[i]) + ",";
				}
				str = str.substring(0, str.length - 1);
				str += "]";
			} else {
				str += "{";
				for(var j in json){
					 str += "\"" + j + "\":" + this.stringify(json[j]) + ",";
				}
				str = str.substring(0, str.length - 1);
				str += "}";
			}
			return str;
		};
		
		this.parse = function(str){
			return eval("(" + str + ")");
		};
	}
};
String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
};
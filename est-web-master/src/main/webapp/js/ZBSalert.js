var ZBS=ZBS || {};

(function(ZBS){
	
	var ZBSalert=function(option){
		var self=this;
		self.settting=$.extend({
			content:"请输入内容",
			nowShow:false,
			width:"50%",	//弹框宽度,默认50%
			state:1,	//如果为0，则一个按钮，如果不为0，则2个按钮
			buttons:["确定","取消"]	//按钮名称，如果state:"judge"，则第二个参数才会显示出来
		},option || {});
		self.DOM={};	//存储DOM节点
		self.thisClickObj={}	//存储点击事件对象
		self.runHide=true;	//执行隐藏
		self.dealFun={};	//存储要调用的方法
		var comfirmHide=function(){	//隐藏弹框
			self.DOM.zAlert.removeClass("showIt");
			/*window.setTimeout(function(){
				self.DOM.zAlert.css({"display":"none"});
			},500);*/
			self.DOM.zAlert.one("webkitTransitionEnd transitionEnd",function(){
				if(!($(this).hasClass("showIt"))){
					self.DOM.zAlert.css({"display":"none"});
				}
			});
		};
		var popShow=function(){	//显示弹框
			self.DOM.zAlert.css({"display":"block"});
			while(true){
				var thisState=self.DOM.zAlert.css("display");
				if(thisState=="block"){
					self.DOM.zAlert.addClass("showIt");
					break;	
				}
			}
			self.showBack && self.showBack();	//回调
		};
		var bindEvent=function(){	//绑定事件
			self.DOM.comfirm && self.DOM.comfirm.on("click",function(){	//点击确认按钮
				comfirmHide();
				self.hideBack && self.hideBack(self.thisClickObj);	//回调
				self.dealFun && self.dealFun.apply(null,self.paramArr);	//执行函数
			});
			self.DOM.comCancel && self.DOM.comCancel.on("click",function(){	//点击取消按钮
				comfirmHide();
				self.cancelBack && self.cancelBack(self.thisClickObj);	//回调
			});
		};
		var initBTN=function(num){
			self.DOM.BTNArea.empty();
			if(num){	//如果有2个按钮
				self.DOM.comfirm=$("<div class='comfirm comBTN  moreBTN'>"+self.settting.buttons[0]+"</div>").appendTo(self.DOM.BTNArea);
				self.DOM.comCancel=$("<div class='comCancel comBTN moreBTN'>"+self.settting.buttons[1]+"</div>").appendTo(self.DOM.BTNArea);
				self.DOM.BTNbroder=$("<div class='BTNbroder'></div>").appendTo(self.DOM.BTNArea);
			}else{
				self.DOM.comfirm=$("<div class='comfirm comBTN'>"+self.settting.buttons[0]+"</div>").appendTo(self.DOM.BTNArea);
				self.DOM.BTNArea.attr("style",{"content":""});
			}
			bindEvent();	//绑定事件
		}
		var init=function(){
			self.DOM.zAlert=$("<div class='ZBSalert'></div>");
			self.DOM.popBG=$("<div class='popBG'></div>").appendTo(self.DOM.zAlert);
			self.DOM.popCont=$("<div class='popCont'></div>").appendTo(self.DOM.zAlert);
			self.DOM.title=$("<p class='title'>"+self.settting.content+"</p>").appendTo(self.DOM.popCont);
			self.DOM.BTNArea=$("<div class='BTNArea'></div>").appendTo(self.DOM.popCont);
			initBTN(self.settting.state);	//初始化按钮
			
			
			if(self.settting.width != "50%"){	//控制弹框宽度
				self.DOM.popCont.css({width:self.settting.width});
			}
			$("body").append(self.DOM.zAlert);
			if(self.settting.nowShow){	//需要一开始显示
				popShow();
			}
		};
		this.showing=function(){	//显示弹框的接口
			self.thisClickObj={};
			self.dealFun=null;
			for(var i=0,thisArg=arguments.length;i<thisArg;i++){
				if(typeof arguments[i] =="object" && arguments[i].name ==undefined && !(arguments[i] instanceof Array) ){	//点击对象
					self.thisClickObj=arguments[i];
				}else if(typeof arguments[i] =="function"){	//回调
					self.showBack=arguments[i];
				}else if(arguments[i] instanceof Array){	//执行方法
					self.dealFun=arguments[i][0];	//存储方法
					self.paramArr=[];	//存储参数
					if(arguments[i].length==2){	//如果有传参
						var thisParams=arguments[i][1];
						for(var k=0,paramLen=thisParams.length;k<paramLen;k++){
							self.paramArr.push(thisParams[k]);
						}
					}
				}
			}
			popShow();	//显示弹框
		};
		this.sureHide=function(hideBack){	//点确定,隐藏弹框的回调
			self.hideBack=hideBack;
		};
		this.cancelHide=function(cancelBack){	//点击取消的回调
			self.cancelBack=cancelBack;
		};
		this.changeText=function(txt){	//修改内容
			self.DOM.title.html(txt);
		};
		this.BTNNumber=function(num){	//设置按钮数量
			initBTN(num);
		};
		init();
	};
	
	ZBS.ZBSalert=ZBSalert;
	
})(ZBS)

var showAlert=new ZBS.ZBSalert({
    header:"温馨提示",
	content:"请输入内容",	//默认为“请输入内容”
	nowShow:false,	//是否立刻显示，默认为false
	width:"60%",	//弹框宽度,默认50%
	state:1,	//如果为0，则一个按钮，如果不为0，则2个按钮
	buttons:["确定","取消"]	//按钮名称，如果state大于0，则第二个参数才会显示出来
});



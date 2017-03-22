/**
 * Created by duanye.sz on 2014/9/9.
 * Version:2.0
 */
var alertDiv = alertDiv || new AlertDiv();
function AlertDiv(){
    this.cBoxStyle = "";
    this.wallStyle = "";
    this._setTimeoutReturn = 0;
    this.param = "";
    this.callback = "";
    this.wallId = "";
    this.cBoxId = "";
    this.defBoxTopH = 50;
    this.jdoc = $(document);
	this.ROOT_IMG_URL = "images/";
	var s_top = '';
	var s_left = '';
	var n_top = '';
	var n_left = '';
    /**
     * @action: 创建一个模态背景
     * @param oStyle，模态背景样式，object格式. eg: {"width":"10px"}
     */
    this.grayWall = function(oStyle){
        var me = this;
		if(this.wallId == "") {
			var wallStyle = {"left":"0px", "top":"0px","opacity":"0.5","display":"none","background-color":"black",
				"width":me.jdoc.width() + "px","height":me.jdoc.height() + "px",
				"position":"absolute", "z-index":9999};
			this._createId();
			$(document.body).append("<div id='" + this.wallId + "'></div>");
			var wall = $("#" + this.wallId);
			wall.attr("style", this._createElementStyle(oStyle, wallStyle));
			$(window).resize(function(){
				 wall.width(me.jdoc.width());
				 wall.height(me.jdoc.height());
			});
		} else {
			var wallStyle = this._styleToObj($("#" + this.wallId).attr("style")); 
			$("#" + this.wallId).attr("style", this._createElementStyle(oStyle, wallStyle));
		}
    };

    /**
     *
     * @param type 执行操作类型: fix 原来存在，显示成弹框，create创建默认弹框
     * @param oStyle 弹框的样式 json格式
	 * @param boxId 需要显示弹框的id/或者要显示内容的ID
     */
    this.showAlert = function(type, oStyle, boxId){
        var me = this;
        var jBoxObj;
        var width = 0;
        var height = me.defBoxTopH;
        var left = 0;
        if(type == "create") {
			if($(this.cBoxId).length == 0) {
				$("#" + this.wallId).after("<div style='height:536px;width:800px;display:none;;overflow:hidden;padding:20px;border-radius: 5px;' id='" + this.cBoxId + "'>"  
								+ "<span class='alert-close' onclick='alertDiv.close();'></span><div class='content'></div>" 	
								+ "</div>");
				jBoxObj = $("#" + this.cBoxId);
			} else {
				jBoxObj = $("#" + this.cBoxId);
			}	
			jBoxObj.find('.content').html($("#" + boxId).html());	
        } else if(type == "fix") {
            jBoxObj = $("#" + boxId);
            this.cBoxId = boxId;
        }
        left = (me.jdoc.width() - jBoxObj.width())/2;

        var boxStyle = {"left":left + "px", "top":height + "px", "z-index":99999, "position":"absolute", "background-image":"url('" + this.ROOT_IMG_URL + "transparent.png')"};
		var selfStyle = jBoxObj.attr("style");
		boxStyle = this._objAdd(this._styleToObj(selfStyle), boxStyle);
        jBoxObj.attr("style", this._createElementStyle(oStyle, boxStyle));
        $(window).resize(function(){
			n_left == ($("body").width() - jBoxObj.width())/2;			
            jBoxObj.css("left",(n_left + "px"));
        });
    };

    /**
     * @param oStyle : 外部传入的json样式1
     *         iStyle : 内部定义的json样式
     * @action: 整合元素样式，以外部设置为主
     * @returns string
     * @private
     * */
    this._createElementStyle = function(oStyle, iStyle){
        if(typeof (oStyle) != "undefined"){
            for(var o in oStyle){
                iStyle[o] = oStyle[o];
            }
        }
        return this._objToStyleStr(iStyle);
    };

    /**
     * @action: 产生ID
     * @private
     */
    this._createId = function(){
        var d = new Date();
        this.wallId = "zues-AD-w-" + d.getTime();
        this.cBoxId = "zues-AD-cb-" + d.getTime();
    };

    /**
     * @action: 对象转化为Style字符串
     * @param obj
     * @returns {string}
     * @private
     */
    this._objToStyleStr = function(obj){
        var str = "";
        for(var o in obj){
            if(o == "opacity"){
                var op = parseFloat(obj[o]);
                str += "opacity:" + op + ";filter:alpha(opacity:" + op*100+ ");-moz-opacity:" + op + ";";
            }else{
                str += o + ":" + obj[o] + ";"
            }
        }
        return str;
    };
	
	this._styleToObj = function(styleStr) {
		var sArr = styleStr.split(";");
		var obj = {};
		for(var i = 0; i < sArr.length; i++){
			if(sArr[i].split(":")[0] != "background-image"){
				obj[sArr[i].split(":")[0]] = sArr[i].split(":")[1];
			}	
		}
		return obj;
	};

	this._objAdd = function(){
		var tObj = {};
		for(var i = 0; i < arguments.length; i++) {
			if(typeof(arguments[i]) == "object"){
				var obj = arguments[i];
				for(var o in obj){
					tObj[o] = obj[o];
				}
			}else {
				continue;
			}
		}
		return tObj;
	};

	this.setBoxContent = function(contentId){
		$("#" + this.cBoxId).find(".content").html($("#" + contentId).html());
	};	
/** 用于记录点击事件的坐标 */
	
	this.close = function(){
		var me = this;
		$("#" + this.cBoxId).animate({
			width:0,
			height:0,
			left:s_left,
			top:s_top
		},500, function(){
				$("#" + me.cBoxId).hide();
				$("#" + me.wallId).hide();
				$("#" + this.cBoxId).css("top", n_top + "px").css("left", n_left + "px");	
				});
		$(".alert-close").hide();
	};
	
	this.clickShow = function(self){
		var me = this;
		s_top = self.offset().top;
		s_left = self.offset().left;
		if(n_top == '' && n_left == ''){
			n_top = parseFloat($("#" + me.cBoxId).css("top"));
			n_left = parseFloat($("#" + me.cBoxId).css("left"));	
		}
		$("#" + this.wallId).show().animate({
		opacity:0.3
		}, 100);
		$("#" + this.cBoxId).css("top", s_top + "px").css("left", s_left + "px").css("height", "0px").css("width","0px").show().animate({
			width:800,
			height:536,
			left:n_left,
			top:n_top
		},500);
		$(".alert-close").show();
	};
	
	this.fixAlert = function(args){
        this.grayWall(args.wallStyle);
        this.showAlert("fix", args.boxStyle, args.showId);
    };
	
	this.createAlert = function(args){
        this.grayWall(args.wallStyle);
        this.showAlert("create", args.boxStyle, args.showId);
    };
};
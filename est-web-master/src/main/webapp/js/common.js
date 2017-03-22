/*
自定义jquery函数，完成将form 数据转换为 json格式 
*/
$.fn.serializeJson=function(){ 
	 var serializeObj={}; // 目标对象 
	 var array= [];
	 if(this.is('form')){
	 	array = this.serializeArray(); // 转换数组格式 
	 }else{
	 	var _obj;
	 	this.find('[name]').each(function(){
	 		_obj = {};
	 		_obj.name = $(this).attr('name');
	 		_obj.value = $(this).val();
	 		array.push(_obj);
	 	});
	 }; 
	 $(array).each(function(){ // 遍历数组的每个元素 {name : xx , value : xxx}
		 if(serializeObj[this.name]){ // 判断对象中是否已经存在 name，如果存在name 
		   if($.isArray(serializeObj[this.name])){ 
		   	//if(this.value!=''){
		   		serializeObj[this.name].push(this.value); // 追加一个值 hobby : ['音乐','体育'] 
		   	//}
		   }else{ 
		 	//if(this.value!=''){
		       // 将元素变为 数组 ，hobby : ['音乐','体育'] 
		       serializeObj[this.name]=[serializeObj[this.name],this.value]; 
		 	//}
		   } 
		 }else{ 
			//if(this.value!=''){
		     serializeObj[this.name]=this.value; // 如果元素name不存在，添加一个属性 name:value 
			//}
		 } 
	 }); 
 return serializeObj; 
}; 
/*grid function
 * searchOption:{
		searchButton:'搜索按钮',
		searchFormId:"搜索表单form"
	}
 * */
$.fn.datagrid_ace = function(o){
	var self = this,_id = this.attr('id'),_pagerId = _id+"_pager";
	var options = $.extend({
		data: '',
		url:'',
		mtype:'POST',
		caption:'Grid',
		height: "100%",
		width: "100%",
		datatype : "json",
		colNames:[],
		colModel:[],
		viewrecords:true,
		rowNum:10,
		rowList:[10,20,30],
		showPager:true,
		autoScroll:false,
		altRows:true,
		shrinkToFit:false,
		multiselect:true,
		page:0,
		postData:{},
		editurl:'',
		scroll:false,
		rownumbers:false,
		sortable:false,
		ondblClickRow:function(rowid,iRow,iCol,e,rowContent){},
		onSelectRow: function(id){},
		gridComplete:function(id){},
		searchOption:null,
		loadComplete:function(xhr){}
	},o||{});
	if($('#'+_pagerId).length ==0){
		$('<div id="'+_pagerId+'"></div>').insertAfter('#'+_id)
	};
	if(options.searchOption){
		$(options.searchOption.searchButton).unbind('click.search').bind('click.search',function(){
			searchJqgird(self,options.searchOption.searchFormId);
		})
	};
	//排序
	if(!options.sortable){
		$.each(options.colModel,function(k,v){
			options.colModel[k].sortable = false
		})
	};
	self.scrollAble = options.scroll;
	//序号
	if(options.rownumbers){
		self.nPage = 0;self.nRowNum = 0;self.nCurPage = 0,self.scrollNo = 0;
		self._colNames = ['No.'];self._colModel = [{name:'rowNumberz',index:'rowNumberz',align:'center',sortable:false,width:35,formatter:function(cellvalue, options, rowObject){
			self.nPage = $(this).jqGrid('getGridParam','page');
			self.nRowNum = $(this).jqGrid('getGridParam','rowNum');
			self.arrIds =  $(this).jqGrid('getDataIDs')
			self.rId = options.rowId;
			if(self.scrollAble){
				self.scrollNo +=1;
				self.nCurPage = parseInt(self.scrollNo)
			}else{
				self.nCurPage = parseInt(self.rId) + (self.nPage-1)*self.nRowNum;
			};
			return self.nCurPage
		}}];
		$.each(options.colNames,function(k1,v1){
			self._colNames.push(v1)
		});
		$.each(options.colModel,function(k2,v2){
			self._colModel.push(v2)
		});
		options.colModel = self._colModel;
		options.colNames = self._colNames;
	};
	$(this).jqGrid({
		data: options.data,
		mtype:options.mtype,
		url : options.url,
	    datatype : options.datatype,
		height: options.height,
		width:options.width,
		colNames:options.colNames,
		colModel:options.colModel, 
		viewrecords : options.viewrecords,
		rowNum:options.rowNum,
		rowList:options.rowList,
		pager : '#'+_pagerId,
		page:options.page,
		altRows:options.altRows,
		shrinkToFit:options.shrinkToFit,
		autoScroll:options.autoScroll,
		multiselect:options.multiselect,
        multiboxonly:false,
        autowidth:true,
        postData:options.postData,
        scroll:options.scroll,
        sortable:options.sortable,
        pgtext:_pageName,
        recordtext:_recordtextName,
		loadComplete:function(xhr) {
			var table = this;
			setTimeout(function(){
				updatePagerIcons(table);
			}, 0);
			if(options.loadComplete && typeof(options.loadComplete) == "function"){
				options.loadComplete(xhr)
			}
			setTimeout(function(){
				$(self).setGridWidth($(self).parents('.gridContent:eq(0)').width());
				resizeGirdWidth(self);
			}, 100);
		},
		rownumbers:false,
		rownumWidth:33,
		editurl: options.editurl,//nothing is saved
		caption: options.caption,
		jsonReader:{
			page:"curPage",
			rows:"pageSize"
		},
		ondblClickRow:function(rowid,iRow,iCol,e){
			if(options.ondblClickRow && typeof(options.ondblClickRow) == "function"){
				options.ondblClickRow(rowid,iRow,iCol,e,$(this).getRowData(rowid))
			}
		},
		onSelectRow:function(id){
			if(options.onSelectRow && typeof(options.onSelectRow) == "function"){
				options.onSelectRow(id)
			}
		},
		gridComplete:function(){
			if(options.gridComplete && typeof(options.gridComplete) == "function"){
				options.gridComplete()
			};
			setTimeout(function(){
				$(self).setGridWidth($(self).parents('.gridContent:eq(0)').width());
				resizeGirdWidth(self);
			}, 300);
			//$('<span style="margin-top: -7px;display:block">序号</span>').prependTo('#jqgh_'+self.attr('id')+'_rn')
		},
		onPaging:function(pgButton){
			self.pageData = $(self).jqGrid('getGridParam');
			self.nowCur = self.pageData.postData.page;
			self.pageTotal = self.pageData.lastpage;
			self.nCurPage = 0;
			switch(pgButton.split('_')[0]){
				case 'next':
					if(self.nowCur < self.pageTotal){
						self._curPage = self.pageData.postData.page+1
					}
					break;
				case 'last':
					self._curPage = self.pageTotal
					break;
				case 'first':
					if(self.nowCur - 1 >= 0){
						self._curPage = self.nowCur - 1
					}
					break;
				case 'prev':
					self._curPage = 1
					break;
			}
			
			$(self).jqGrid('setGridParam',{postData:{
				"curPage":self._curPage,
				"pageSize":self.pageData.postData.rows
			}})
		}
	});
};
//表格宽度设置
function setGirdWidth(grid){
	$(grid).setGridWidth($(grid).parents('.gridContent:eq(0)').width());
}
//表格自适应
function resizeGirdWidth(grid){
	$(window).resize(function(){
		setGirdWidth(grid)
	})
}
//表格查询功能
function searchJqgird(gridId,searchFormId){
	var _data = $(searchFormId).serializeJson();
	 $(gridId).jqGrid('setGridParam', {
		postData:_data,
	    page : 1,
	    datatype:"JSON"
	  }).trigger("reloadGrid");
	 _data = null;
}
//replace icons with FontAwesome icons like above
function updatePagerIcons(table) {
	var replacement = 
	{
		'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
		'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
		'ui-icon-seek-next' : 'icon-angle-right bigger-140',
		'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		
		if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
	})
}

// 获取表格选中行的数据  传入参数：表格ID,需要获取的字段名(数组)
//getCheckRowsData("dataGridId",["a","b","c",...])
function getCheckRowsData(dataGridId){
	var _g=$("#"+dataGridId),
		_id = _g.jqGrid("getGridParam", "selarrrow");

	if(_id.length>0){
		var rowsData={},
			_d='',
			_a=arguments[1];

		for (var i = 0; i < _id.length; i++) {
			_d=_g.jqGrid("getRowData", _id[i]);
			for (var k = 0; k < _a.length; k++) {
				if(rowsData[_a[k]]){
		            rowsData[_a[k]].push(_d[_a[k]]||'');
		        }else{
		            rowsData[_a[k]]=[_d[_a[k]]];
		        }
			};
		};
		return rowsData;
	}else{
		return false;
	}
}

function getCheckRowsDataToJson(dataGridId){
	var _g=$("#"+dataGridId),
		_id = _g.jqGrid("getGridParam", "selarrrow");

	if(_id.length>0){
		var rowsData=[],
			_d='',
			_a=arguments[1];
		for (var i = 0; i < _id.length; i++) {
			_d=_g.jqGrid("getRowData", _id[i]);
			var d = {};
			for (var k = 0; k < _a.length; k++) {
		            d[_a[k]]=_d[_a[k]]||'';
			}
			rowsData[i]=d;
		}
		return rowsData;
	}else{
		return false;
	}
}
//ztree
/*
 * 
container:tree对象,
url:请求路径,
postData:传入参数,
dataType:数据类型,
simpleData: {
	enable: true,
	pIdKey: "pid"
},
keyName: "name",
treeDataFormat:返回值格式
view: {
	selectedMulti: false,
	showIcon: false
},
check: {
	enable: false,
	chkStyle: "checkbox",
	chkboxType: { "Y" : "ps", "N" : "ps" }
},
_callback: 回调
 */
function loadZtree(options){
	var self = this;
	var o = $.extend({
		container:'',
		url:'',
		postData:{},
		dataType:'POST',
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid"
		},

		keyName: _name,

		treeDataFormat:'data.resource',//返回值格式
		view: {
			selectedMulti: false,
			showIcon: false
		},
		check: {
			enable: false,
			chkStyle: "checkbox",
			chkboxType: { "Y" : "ps", "N" : "ps" }
		},
		_callback: function(){},
		_loadZTreeSuccessCallback:function(){}
	},options||{});
	//配置
	self.setting = {
			data: {
				simpleData: {
					enable: o.simpleData.enable,
					idKey: o.simpleData.idKey,
					pIdKey: o.simpleData.pIdKey
				},
				key: {
					name: o.keyName
				}
			},
			view: {
				selectedMulti: o.view.selectedMulti,
				showIcon: o.view.showIcon
			},
			check:{
				enable: o.check.enable,
				chkStyle: o.check.chkStyle,
				chkboxType: o.check.chkboxType
			},
			callback: {
				onClick: o._callback
			}
		};
	//刷新树
	self.reloadZTree = function(){
		$.ajax({
			url: o.url,
			data:o.postData,
			cache:true,
			success:function(data){
				if(data.data.resource[0].icon != ""){
					$.each(data.data.resource,function(k,v){
						data.data.resource[k].icon = ""
					})
				};
				self.user_org_tree = $.fn.zTree.init($(o.container), self.setting, eval("data."+o.treeDataFormat));
				self.user_org_tree.expandAll(true);
				o._loadZTreeSuccessCallback(data);
			}
		})
	};
	self.reloadZTree();
	//勾选树
	self.checkedNode = function(d){
		for(var i = 0; i < d.length;i++){
			var node = self.user_org_tree.getNodeByParam("id", d[i], null);
			self.user_org_tree.checkNode(node, true, false);
		}
	}
}
/*表格高度设置
//minusElementArr:需要减去的对象，[obj1,obj2,obj3...]
*/
function datagridHeight(minusElementArr){
	var contentHeight = parseInt($(window).height()) - parseInt($('#navbar').height()) - parseInt($('#breadcrumbs').height());
	if(minusElementArr && minusElementArr.length > 0){
		$.each(minusElementArr,function(k,v){
			if(typeof(v) == "number" ){
				contentHeight -= v 
			}else if(typeof(v) == "string" || typeof(v) == "object"){
				if($(v).length != 0){
					contentHeight -= parseInt($(v).height());
				}
			}
		})
	};
	return contentHeight
}
/*
 * 显示loading 
 */
function showLoading(msg){
	$('#loadingFilter').fadeIn("fast").find('.loadingTxt').text(msg);
}
/*
 * 关闭loading 
 */
function hideLoading(){
	$('#loadingFilter').fadeOut("fast").find('.loadingTxt').text("");
}
/*
 * 动画效果
 */
window.requestAnimFrame = (function(){  
    return  window.requestAnimationFrame       ||   
    window.webkitRequestAnimationFrame ||   
    window.mozRequestAnimationFrame    ||   
    window.oRequestAnimationFrame      ||   
    window.msRequestAnimationFrame     ||   
    function( callback ){  
        window.setTimeout(callback, 1000/60);  
    };  
})(); 
/*
 * 带进度条loading
 * msg:提示信息
 * dataPercent:进度 ，初始:0,结束1
 */
var showBarLoading = function(msg,dataPercent){
	var self = this;
	self.speed = 1,self.step = 1,self.nowWidth = 0,self.barContentWidth = 280,self.barWidth=0,self.textSum = 0,self.nowNum = 0,self.goNum = 0,self.goWidth = 0/*需要扩展的宽度*/;
	$('#loadingFilterForBar').fadeIn("fast").find('.loadingTxt').text(msg);
	/*载入动画*/
	self.viewAnimateInit = function(msg, percent,_callback){
		$('#loadingFilterForBar .progress-bar').removeClass('progress-bar-danger');
		$('#loadingFilterForBar').fadeIn("fast").find('.loadingTxt').text(msg);
		self.nowWidth = $('#loadingFilterForBar .progress-bar').width();
		self.nowNum = $('#loadingFilterForBar .barNum').attr('data-num');
		self.goWidth = self.barContentWidth * percent - self.nowWidth;
		self.goNum = percent*100 - self.nowNum
		self.stepWidth = self.goWidth*60/self.speed;
		self.stepTextNum = self.goNum*60/self.speed;
		/*启动动画*/
		self.viewAnimate = function(){
			if(self.barWidth < self.barContentWidth*percent){
				self.textSum += self.stepTextNum;
				self.barWidth += self.stepWidth;
				$('#loadingFilterForBar .barNum').attr('data-num',self.textSum);
				$('#loadingFilterForBar .barNum').text(Math.round(self.textSum)+"%");
				$('#loadingFilterForBar .progress-bar').width(self.barWidth);
				requestAnimFrame(self.viewAnimate);
			}else{
				self.barWidth = self.barContentWidth*percent;
				$('#loadingFilterForBar .barNum').text(Math.round(percent*100)+"%");
				$('#loadingFilterForBar .progress-bar').width(self.barWidth);
			};
			if(self.barWidth == self.barContentWidth){
				$('#loadingFilterForBar').delay(300).fadeOut("fast",function(){
					$('#loadingFilterForBar .progress-bar').width(0);
					self.step = 1,self.nowWidth = 0,self.barContentWidth = 280,self.barWidth=0,self.textSum = 0,self.goWidth = 0;
					if(_callback && typeof(_callback) == "function"){
						_callback()
					}
				});
				
			};
		};
		self.viewAnimate();
	};
	/*载入失败*/
	self.loadingError = function(msg){
		$('#loadingFilterForBar .progress-bar').addClass('progress-bar-danger');
		$('#loadingFilterForBar').find('.loadingTxt').text(msg);
		$('#loadingFilterForBar').delay(1000).fadeOut("fast",function(){
			$('#loadingFilterForBar .progress-bar').width(0);
			self.step = 1,self.nowWidth = 0,self.barContentWidth = 280,self.barWidth=0,self.textSum = 0,self.goWidth = 0;
		});
	}
	self.viewAnimateInit(msg,dataPercent);
}
//移除validTooltip
function destroyValidTooltip(){
	$('.validTooltip').remove();
}
//数字输入框
//文本框只能输入数字，并屏蔽输入法和粘贴  
$.fn.numeral = function() {     
   $(this).css("ime-mode", "disabled");     
    
   this.bind("paste", function() {     
	   $(this).val($(this).val().replace(/[^0-9.]/g,''));      
   });     
   this.bind("dragenter", function() {     
       return false;     
   });     
   this.keyup(function () {
       var reg = $(this).val().match(/\d+\.?\d{0,2}/);
       var txt = '';
       if (reg != null) {
           txt = reg[0];
       }
       $(this).val(txt);
   }).change(function () {
       $(this).keypress();
       var v = $(this).val();
       if (/\.$/.test(v))
       {
           $(this).val(v.substr(0, v.length - 1));
       }
   });     
};    
//浏览器版本信息
(function(jQuery){ 
	if(jQuery.browser) return; 
	jQuery.browser = {}; 
	jQuery.browser.mozilla = false; 
	jQuery.browser.webkit = false; 
	jQuery.browser.opera = false; 
	jQuery.browser.msie = false; 

	var nAgt = navigator.userAgent; 
	jQuery.browser.name = navigator.appName; 
	jQuery.browser.fullVersion = ''+parseFloat(navigator.appVersion); 
	jQuery.browser.majorVersion = parseInt(navigator.appVersion,10); 
	var nameOffset,verOffset,ix; 

	// In Opera, the true version is after "Opera" or after "Version" 
	if ((verOffset=nAgt.indexOf("Opera"))!=-1) { 
	jQuery.browser.opera = true; 
	jQuery.browser.name = "Opera"; 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+6); 
	if ((verOffset=nAgt.indexOf("Version"))!=-1) 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+8); 
	} 
	// In MSIE, the true version is after "MSIE" in userAgent 
	else if ((verOffset=nAgt.indexOf("MSIE"))!=-1) { 
	jQuery.browser.msie = true; 
	jQuery.browser.name = "Microsoft Internet Explorer"; 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+5); 
	} 
	// In Chrome, the true version is after "Chrome" 
	else if ((verOffset=nAgt.indexOf("Chrome"))!=-1) { 
	jQuery.browser.webkit = true; 
	jQuery.browser.name = "Chrome"; 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+7); 
	} 
	// In Safari, the true version is after "Safari" or after "Version" 
	else if ((verOffset=nAgt.indexOf("Safari"))!=-1) { 
	jQuery.browser.webkit = true; 
	jQuery.browser.name = "Safari"; 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+7); 
	if ((verOffset=nAgt.indexOf("Version"))!=-1) 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+8); 
	} 
	// In Firefox, the true version is after "Firefox" 
	else if ((verOffset=nAgt.indexOf("Firefox"))!=-1) { 
	jQuery.browser.mozilla = true; 
	jQuery.browser.name = "Firefox"; 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+8); 
	} 
	// In most other browsers, "name/version" is at the end of userAgent 
	else if ( (nameOffset=nAgt.lastIndexOf(' ')+1) < 
	(verOffset=nAgt.lastIndexOf('/')) ) 
	{ 
	jQuery.browser.name = nAgt.substring(nameOffset,verOffset); 
	jQuery.browser.fullVersion = nAgt.substring(verOffset+1); 
	if (jQuery.browser.name.toLowerCase()==jQuery.browser.name.toUpperCase()) { 
	jQuery.browser.name = navigator.appName; 
	} 
	} 
	// trim the fullVersion string at semicolon/space if present 
	if ((ix=jQuery.browser.fullVersion.indexOf(";"))!=-1) 
	jQuery.browser.fullVersion=jQuery.browser.fullVersion.substring(0,ix); 
	if ((ix=jQuery.browser.fullVersion.indexOf(" "))!=-1) 
	jQuery.browser.fullVersion=jQuery.browser.fullVersion.substring(0,ix); 

	jQuery.browser.majorVersion = parseInt(''+jQuery.browser.fullVersion,10); 
	if (isNaN(jQuery.browser.majorVersion)) { 
	jQuery.browser.fullVersion = ''+parseFloat(navigator.appVersion); 
	jQuery.browser.majorVersion = parseInt(navigator.appVersion,10); 
	} 
	jQuery.browser.version = jQuery.browser.majorVersion; 
})(jQuery); 


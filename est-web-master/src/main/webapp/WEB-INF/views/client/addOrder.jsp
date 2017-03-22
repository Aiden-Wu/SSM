<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
<!-- 	预报清单 --><spring:message code="l_pre_predict_detail_list"/>
	</h5>
</div>

<div class="container-fluid" id="orderPage">
	<ul class="nav nav-tabs nav-justified">
	  <li role="presentation" class="active"><a href="#infoTabContent" aria-controls="infoTabContent" role="tab" data-toggle="tab">
	  <!-- 配送邮路信息 -->
	  <spring:message code="l_configure_route_info"></spring:message>
	  </a></li>
	  <li role="presentation"><a href="#uploadTabContent" aria-controls="uploadTabContent" role="tab" data-toggle="tab">
	  <!-- 上传 -->
	  <spring:message code="l_upload"></spring:message>
	  </a></li>
	</ul>
	<form action="${pageContext.request.contextPath}/client/uploadExcel.html" enctype="multipart/form-data" method="post" id="addOrderForm" target="addOrder_iframe">
		<input type="hidden" name="uuid"/>
		<div class="tab-content">
		    <div role="tabpanel" class="tab-pane active" id="infoTabContent">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 国家邮局： -->
								<spring:message code="l_country_postoffice"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control start_select" id="select1" name="postoffice">
									<option>请选择</option>
								</select>
								<input type="hidden" name="postId" value="" id="postId"/>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 账号编号： -->
								<spring:message code="l_account_number"></spring:message>
							</label>
							<div class="col-md-8 form-control-static">
								<input type="text" class="form-control" name="customerNo" value="" readonly="readonly"/>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 许可邮件号： -->
								<spring:message code="l_mail_number"></spring:message>
							</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="ppiNo" value="" readonly="readonly"/>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 转运路线： -->
								<spring:message code="l_transit_route"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control start_select" name="transportLine" id="transportLine">
									<option>请选择</option>
								</select>
								<input type="hidden" name="transportLineId" value="" />
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 邮局地址： -->
								<spring:message code="l_postoffice_address"></spring:message>
							</label>
							<div class="col-md-8">
								<input type="text" class="form-control" name="postofficeAddr" value="" readonly="readonly">
							</div>
						</div>
					</div>
				</div>
				<div class="form-line"></div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 服务： -->
								<spring:message code="l_service"></spring:message>
							</label>
							<div class="col-md-8 form-control-static">
								<label class="radio-inline">
								  <input type="radio" class="ace" id="inlineRadio2" name="serviceType" value="1" checked="checked"/>
								  <span class="lbl"> 
								  	<!-- 中转 -->
								  	<spring:message code="l_service_transfer_stock"></spring:message>
								  </span>
								</label>
								<label class="radio-inline">
								  <input type="radio" class="ace" id="inlineRadio1" name="serviceType" value="2"/>
								  <span class="lbl"> 
								  	<!-- 直邮 -->
								  	<spring:message code="l_service_direct_mail"></spring:message>
								  </span>
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 批次号： -->
								<font color="red">*</font><spring:message code="l_batch_number"></spring:message>
							</label>
							<div class="col-md-8">
								<input type="text" id="dispatchNo" validate="notnull" name="dispatchNo" class="form-control" placeholder="<spring:message code="l_js_batch_number"/>">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 邮寄方式： -->
								<spring:message code="l_Shipping_method"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control start_select" id="dispatchTypeSelect" name="dispatchType">
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 批次号： -->
								<font color="red">*</font><spring:message code="l_batch_number"></spring:message>
							</label>
							<div class="col-md-8">
								<input type="text" id="dispatchNo" validate="notnull" name="dispatchNo" class="form-control" placeholder="<spring:message code="l_js_batch_number"/>">
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 邮寄方式： -->
								<spring:message code="l_Shipping_method"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control start_select" id="dispatchTypeSelect" name="dispatchType">
								</select>
							</div>
						</div>
					</div> --%>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 航班号： -->
								<spring:message code="l_flight_number"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control" id="truckingNo" name="truckingNo">
									<option value=".">.</option>
								</select>
								<input type="hidden" value="" name="truckingNoId"/>
							</div>
						</div>
					</div> --%>
				</div>
				<div class="row">
					<%-- <div class="col-md-4" style="display:none">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 付款方式： -->
								<spring:message code="l_pay_mode"></spring:message>
							</label>
							<div class="col-md-8">
								<select class="form-control start_select" name="payMode">
									<option>信用额度</option>
								</select>
							</div>
						</div>
					</div>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 邮袋数： -->
								<spring:message code="l_mail_bag_num"></spring:message>
							</label>
							<div class="col-md-8">
								<div class="input-group">
							      <input type="text" class="form-control" id="" name="estimateBagNum" placeholder="<spring:message code="l_js_pouch_number"/>">
							      <div class="input-group-addon">PCS</div>
							    </div>
							</div>
						</div>
					</div> --%>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 总重量： -->
								<spring:message code="l_total_weight"></spring:message>
							</label>
							<div class="col-md-8">
								<div class="input-group">
							      <input type="text" name="estimateTotalWeight" class="form-control" id="" placeholder="<spring:message code="l_js_forecast_total_weight_of_pouch"/>">
							      <div class="input-group-addon">KG</div>
							    </div>
							</div>
						</div>
					</div> --%>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 航运单号： -->
								<spring:message code="l_shipping_ordercode"></spring:message>
							</label>
							<div class="col-md-8">
								<input name="airwayBillNo" type="text" class="form-control" placeholder="<spring:message code="l_js_shipping_ordercode"/>" value="">
							</div>
						</div>
					</div> --%>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 发货日期： -->
								<spring:message code="l_send_date"></spring:message>
							</label>
							<div class="col-md-8">
								<div class="input-group">
									<input class="form-control date-picker" id="id-date-picker-1" name="dispatchDate" type="text" data-date-format="dd-mm-yyyy">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div> --%>
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 预计到达日期： -->
								<spring:message code="l_arrive_date"></spring:message>
							</label>
							<div class="col-md-8">
								<div class="input-group">
									<input class="form-control date-picker" name="estimateArrivceDate" id="id-date-picker-2" type="text" data-date-format="dd-mm-yyyy">
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					</div> --%>
				</div>
				<div class="row">
					<%-- <div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 航运单号： -->
								<spring:message code="l_shipping_ordercode"></spring:message>
							</label>
							<div class="col-md-8">
								<input name="airwayBillNo" type="text" class="form-control" placeholder="<spring:message code="l_js_shipping_ordercode"/>" value="">
							</div>
						</div>
					</div> --%>
				</div>
			</div>
		   <div role="tabpanel" class="tab-pane" id="uploadTabContent">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group clearfix">
							<label class="col-md-4 control-label no-padding-right">
								<!-- 上传Excel文件： -->
								<spring:message code="l_upload_excel_file"></spring:message>
							</label>
							<div class="col-md-8">
								<input type="file" name="excelFile" id="id-input-file-2" />
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="row">
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-5 control-label no-padding-right">输入纪录－头列表：</label>
							<div class="col-md-7 form-control-static">
								缺失
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group clearfix">
							<label class="col-md-5 control-label no-padding-right">纪录：</label>
							<div class="col-md-7 form-control-static">
								0
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<label class="checkbox-inline">
							<input name="form-field-checkbox" class="ace ace-checkbox-2" type="checkbox">
							<span class="lbl"> 第一行是列名</span>
						</label>
					</div>
				</div> -->
				<div class="clearfix form-actions center">
					<button class="btn btn-success" type="button" onclick="asubmit();">
						<i class="icon-ok"></i>
						<!-- 保存 -->
						<spring:message code="l_save"></spring:message>
					</button>
				</div>
			</div>
		</div>
		<iframe style="display:none;" id="addOrder_iframe" name="addOrder_iframe"></iframe>
	</form>
</div>
<!-- 数据检验 -->
<div class="modal fade" id="checkDataModal" style="" tabindex="-1" role="dialog" >
  <div class="modal-dialog" style="margin-top:20px;width:60%;height:90%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">检验数据</h4>
      </div>
      <div class="modal-body" style="height:90%; overflow-y:scroll" id="checkDataModalContent">
      	<div class="bs-callout-danger" id="_errMsg">
      		<!-- <h4 class="h4-error">错误提示1:</h4>
      		<p>您上传了文件 “英国－20160503－马邮.xlsx</p>
			<p>文件格式为：上传清单标准格式2016版<a href="#">（点此下载excel示例文件）</a>。</p>
			<p>文件存在异常 缺少关键列信息</p>
			
			<table id="grid-table1"></table>
			<div id="grid-pager1"></div>
			<p>请返回下载上传清单标准格式2016版<a href="#">示例文件</a>，与您的Excel文件对比修正后，重新上传。</p>
			<div class="form-line"></div> -->
			
			<h4 class="h4-error">错误提示1:</h4>
			<p>您提交了100个包裹，其中有10个包裹追踪号重复，请更换后再重新上传。<span class="badge" data-toggle="modal" data-target="#detailModal">?</span></p>
			<!-- 表格 stat -->
			<!-- <table class="gridCls">
				<thead>
					<tr>
						<th></th>
						<th>ID</th>
						<th>Last Sales</th>
						<th>Name</th>
						<th>Stock</th>
						<th>Ship via</th>
						<th>Notes</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td></td>
						<td>ID</td>
						<td>Last Sales</td>
						<td>Name</td>
						<td>Stock</td>
						<td>Ship via</td>
						<td>Notes</td>
					</tr>
					<tr class="secondary">
						<td></td>
						<td>ID</td>
						<td>Last Sales</td>
						<td>Name</td>
						<td>Stock</td>
						<td>Ship via</td>
						<td>Notes</td>
					</tr>
					<tr>
						<td></td>
						<td>ID</td>
						<td>Last Sales</td>
						<td>Name</td>
						<td>Stock</td>
						<td>Ship via</td>
						<td>Notes</td>
					</tr>
				</tbody>
			</table> -->
			<!-- 表格 end -->
      	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
      </div>
    </div>
  </div>
</div>
<!-- 明细弹窗 -->
<div class="modal fade" id="detailModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">提示</h4>
      </div>
      <div class="modal-body">
        <p>1.邮袋编号、追踪号、批次号不能重复</p>
        <p>2. 需要检验到国家。</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
<script>
formValidation.setFormObj($("#addOrderForm"));
formValidation.init();
$('#checkDataModalContent').height($(window).height()-260);
var DISPATCH_TYPE_MD = {4:["EMD","EMC","R","R-M"],5:["OM","PZ","R"],6:["OM","PZ","R"],"def":["EMD","EMC","R","R-M"]};
var DISPATCH_TYPE_DE = {4:["EMD","EMC","R","R-M"],5:["OM","PZ","R","EMS"],6:["OM","PZ","R","EMS"],"def":["EMD","EMC","R","R-M"]};
var uuid = "";
{//init post info
	var rslt = '${rslt}';
	if(rslt != ''){
		rslt = JSON.parse(rslt);
	}
	var _post = rslt.data;
	if(_post.length > 0){
		var s1Html = "";
		var _postObj = {};
		for(var i = 0; i < _post.length; i++){
			var tempObj = {};
			if(_postObj[_post[i].name]){
				_postObj[_post[i].name]["line"] = _postObj[_post[i].name]["line"].concat(_post[i].line);
			} else{
				tempObj["customerNo"] = _post[i].customerNo;
				tempObj["ppiNo"] = _post[i].ppiNo;
				tempObj["pid"] = _post[i].pid;
				tempObj["address"] = _post[i].address;
				tempObj["line"] = _post[i].line;
				_postObj[_post[i].name] = tempObj;
			}
			
		}
		var s1Html = "";
		var firstObj = {};
		var updateTLine = function(rslt){
			if(rslt.code == "1"){
				var thtml = "";
				var arr = rslt.data;
				if(arr.length > 0){
					thtml += "<option value='.'>.</option>";
					for(var i=0; i < arr.length; i++){
						thtml += "<option value='" + arr[i].name + "' data-id='" + arr[i].id + "'>" + arr[i].name + "</option>";
					}
				} else{
					thtml += "<option value='.'>.</option>";
				}
			} else {
				thtml += "<option value='.'>.</option>";
			}
			$("#addOrderForm").find("input[name='truckingNoId']").val("-1");
			$("#truckingNo").html(thtml);
			$("#truckingNo").trigger("chosen:updated");
			$("#truckingNo").on("change",function(){
				var dataId = $(this).find("option:selected").attr("data-id");
				dataId = dataId || -1;
				$("#addOrderForm").find("input[name='truckingNoId']").val(dataId);
			});
		};
		var initTrunkNo = function(bmid){
			ajaxEngine.getAjax('/client/getTrunkingLineListByDepartmentID.html', {id:bmid}, updateTLine);
		};
		var initDispatchType = function(id, obj){
			var types = obj[id] || obj["def"]; 
			var html = "";
			for(var _i = 0 ; _i < types.length; _i++){
				html += "<option>"+types[_i] + "</option>";
			}
			$("#dispatchTypeSelect").html(html);
			$("#dispatchTypeSelect").trigger("chosen:updated");
		};
		$("#addOrderForm").find("input[name='serviceType']").bind('change',function(){
			initDispatchType($("#postId").val(), $(this).val() == 1 ? DISPATCH_TYPE_MD : DISPATCH_TYPE_DE);
		});
		var initPostVal = function(obj){
			$("#addOrderForm").find("input[name='customerNo']").val(obj.customerNo);
			$("#addOrderForm").find("input[name='ppiNo']").val(obj.ppiNo);
			$("#postId").val(obj.pid);
			initDispatchType(obj.pid, DISPATCH_TYPE_MD);
			if(obj.line.length > 0){
				var thtml = "";
				var arr = obj.line;
				for(var i = 0; i < arr.length; i++){
					 thtml += "<option value='" + arr[i].name + "' data-id='" + arr[i].id + "' address='" + arr[i].address + "'>" + arr[i].name + "</option>";
				}
				$("#transportLine").html(thtml).bind("change", function(){
					var saddress = $(this).find("option:selected").attr("address");
					var dataId = $(this).find("option:selected").attr("data-id");
					$("#addOrderForm").find("input[name='postofficeAddr']").val(saddress);
					$("#addOrderForm").find("input[name='transportLineId']").val(dataId);
					initTrunkNo($(this).find("option:selected").attr("data-id"));
					//根据转运线路查找航班号
				});
				$("#transportLine").trigger("chosen:updated");  
				initTrunkNo(arr[0].id);
				$("#addOrderForm").find("input[name='postofficeAddr']").val(arr[0].address);
				$("#addOrderForm").find("input[name='transportLineId']").val(arr[0].id);
			} else {
				$("#addOrderForm").find("input[name='transportLineId']").val(obj.id);
				$("#addOrderForm").find("input[name='postofficeAddr']").val(obj.address);
			}
		};
		for(var o in _postObj){
			if(s1Html == ""){
				firstObj = _postObj[o];
			}
			s1Html += "<option value='" + o + "'>" + o + "</option>";
		}
		initPostVal(firstObj);
		$("#select1").html(s1Html).bind("change", function(){
			initPostVal(_postObj[$(this).val()]);
		});
	}
}
var updateTUUID = function(rslt){
	uuid = rslt;
	$("#addOrderForm").find("input[name='uuid']").val(uuid);
};
var getUUID = function(){
	ajaxEngine.getAjax('/client/getUUID.html', {}, updateTUUID);
};
var idUpdate = function(rslt){
	uuid = rslt;
};
var _file = {};
$('#id-date-picker-1').datepicker().bind('changeDate',function(ev){
	var startTime = $('#id-date-picker-1').val();
	$('#id-date-picker-2').datepicker('setStartDate',startTime);
	$('#id-date-picker-1').datepicker('hide')
});
$('#id-date-picker-2').datepicker().bind('changeDate',function(ev){
	var endTime = $('#id-date-picker-2').val();
	$('#id-date-picker-1').datepicker('setEndDate',endTime);
	$('#id-date-picker-2').datepicker('hide')
});
$('.start_select').chosen();
$('#id-input-file-2').ace_file_input({
	no_file:'未选择文件',
	btn_choose:'Choose',
	btn_change:'Change',
	droppable:false,
	whitelist:'xls|xlsx',
	preview_error : function(filename, error_code) {
		
		alert(error_code);
	}
}).on('change', function(){
	 _file = $(this).data('ace_input_files')[0];
});

$("#dispatchNo").unbind("change").bind("change", function(){
	var obj = $(this);
	getUUID();
	if(obj.val() == ""){
		modalAlert("批次号不能为空");
		return;
	}
	ajaxEngine.postAjax("client/checkDispatchNo.html", {str : obj.val()}, function(rslt){
		if(rslt.code == "1"){
			//Do nothing!!!
		} else {
			obj.focus();
			modalAlert("批次号异常:"+rslt.info);
		}
	});
});
var processBar = {},IframeFncInt = true;
var p_time = 0;
var updateProcessBar = function(){
	ajaxEngine.getAjax("/client/checkProcess.html", {uuid:uuid}, function(rslt){
		if(rslt == "0"){
			processBar.viewAnimateInit("解析数据中", 0.1);
			//console.log(rslt);
			return;
		}
		if(rslt.indexOf("I") != -1){
			//console.log(rslt);
			processBar.viewAnimateInit("插入数据中", parseFloat(rslt.substring(1,rslt.length)));
			return;
		}
		if(rslt.indexOf("D") != -1){
			//console.log(rslt);
			processBar.viewAnimateInit("校验数据中", parseFloat(rslt.substring(1,rslt.length)));
			return;
		}
	});
};
var asubmit = function(){
	if(!$('#id-input-file-2').data('ace_input_files')){
		modalAlert("未选择上传文件");
		return;
	}
	var _file = $('#id-input-file-2').data('ace_input_files')[0];
	if(!$.browser.msie){
		if(!_file.size){
			modalAlert("未选择上传文件");
			return;
		}
		if(_file.name.lastIndexOf(".xlsx") == -1 && _file.name.lastIndexOf(".xls") == -1){
			modalAlert("上传文件必须为xlsx或者xls");
			return;
		}
		if(_file.size/(1000*1000) > 30){
			modalAlert("所选择文件不能超过30M");
			return;
		}
	};
	processBar = new showBarLoading('解析数据中', 0);
	p_time = setInterval(updateProcessBar, 5000);
	$("#addOrderForm").submit();
	if(IframeFncInt){
		addOrderIframeFnc()
	}
};

function addOrderIframeFnc(){
	IframeFncInt = false;
	$("#addOrder_iframe").on("load",function(){
		getUUID();
		var data = {},self = this,errorTxt = '';
		clearInterval(p_time);
		processBar.viewAnimateInit("完成",1,function(){
			try{
				data = self.contentWindow.document.getElementById('jsonData').innerHTML;
				var jdata = JSON.parse(data);
				var map = jdata.data.map;
				var totalMap = jdata.data.totalMap;
				if(!map){
					modalAlert(JSON.parse(data).data).on(function(){$("#_menu a[href='/client/toAddOrder.html']").trigger("click");});
					return;
				}
				var errHtml = "";
				for(var o in map){
					errorTxt = '(共有'+totalMap[o]+'条错误';
					errorTxt += (totalMap[o]>20)?'当前只展示20条数据':'';
					errorTxt += ')';
					errHtml +='<h4 class="h4-error">错误提示:' + o + ' '+errorTxt+'</h4>';
					errHtml +='<p>' + rsltMsg[o] + '</p>';
					errHtml += infoToTable(map[o], totalMap[o]);
				}
				$("#_errMsg").html(errHtml);
				$("#checkDataModal").modal("show");
			} catch(err){
				if(self.contentWindow.document.body.innerHTML.length < 1000){
					modalAlert(self.contentWindow.document.body.innerHTML);
				} else {
					window.location.href = "/toLogin.html";
				}
			}
		});
	});
}



var infoToTable = function(data, data2){
	var html = '<table class="gridCls">'+
	'<thead>' +
		'<tr>' +
			'<th>ID</th>' +
			'<th>消息</th>' +
		'</tr>'+
	'</thead><tbody>';
	
	for(var i = 0; i < data.length; i++){
		html += '<tr>';
		html += '<td>' + data[i].id + '</td>';
		html += '<td>' + data[i].msg + '</td>'
		html += '</tr>';
	}
	html += '</tbody></table>';
	return html;
};
</script>

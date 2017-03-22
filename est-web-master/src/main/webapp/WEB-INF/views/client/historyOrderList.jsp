<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="clientListPage">
	<div class="page-content">
		<form action="" id="clientList">
			<div class="row">
				<div class="col-sm-12">
					<div class="widget-box transparent">
						<div class="widget-header widget-header-flat">
							<h4 class="lighter">
								<i class="icon-search"></i>
								<!-- 历史预报清单 -->
								<spring:message code="l_pre_history_detial_list"></spring:message>
							</h4>
							<div class="widget-toolbar">
								<a href="#" data-action="collapse">
									<i class="icon-chevron-up"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<div class="widget-main ">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 预报日期： -->
												<spring:message code="l_pre_submit_start_date"></spring:message>
											</label>
											<div class="col-md-8">
												<div class="input-group">
													<span class="input-group-addon">
														<!-- 从 -->
														<spring:message code="l_pre_from"></spring:message>
													</span>
													<input class="form-control" type="text" name="beginSubmitTime" id="beginAddTime-forClient" />
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 预报日期： -->
												<spring:message code="l_pre_submit_end_date"></spring:message>
											</label>
											<div class="col-md-8">
												<div class="input-group">
													<span class="input-group-addon">
														<!-- 到 -->
														<spring:message code="l_pre_to"></spring:message>
													</span>
													<input class="form-control" type="text" name="endSubmitTime" id="endAddTime-forClient" />
													<span class="input-group-addon">
														<i class="icon-calendar bigger-110"></i>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 批次号： -->
												<spring:message code="l_pre_batch_number"></spring:message>
											</label>
											<div class="col-md-8">
												<input type="text" class="form-control" placeholder='<spring:message code="l_pre_c_batch_number" />' name="dispatchNo" id="dispatchNo">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 邮局： -->
												<spring:message code="l_pre_postoffice"></spring:message>
											</label>
											<div class="col-md-8">
												<select class="form-control" name="postoffice" id="postoffice">
													<c:if test="${fn:length(postOfficeList) > 1}">
														<option value="" selected="selected">
															<!-- 请选择 -->
															<spring:message code="l_pre_please_choose"></spring:message>
														</option>
													</c:if>
													<c:forEach var="item" items="${postOfficeList}">
														<option value="${item.pid }">${item.name}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<%-- <div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 目的国： -->
												<spring:message code="l_pre_destination_country"></spring:message>
											</label>
											<div class="col-md-8">
												<select class="form-control" name="countryCode" id="countryCode">
													<option value="" selected="selected">
														<!-- 请选择 -->
														<spring:message code="l_pre_please_choose"></spring:message>
													</option>
													<c:forEach var="item" items="${countryList}">
														<option value="${item.code }">${item.zhName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div> --%>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 邮寄类型： -->
												<spring:message code="l_pre_mail_type"></spring:message>
											</label>
											<div class="col-md-8">
												<select class="form-control" name="dispatchType" id="dispatchType">
													<option value="">
														<!-- 请选择 -->
														<spring:message code="l_pre_please_choose"></spring:message>
													</option>
													<option value="R">R</option>
													<option value="EMC">EMC</option>
													<option value="EMD">EMD</option>
													<option value="DE-R">DE-R</option>
													<option value="R-M">R-M</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-5">
										<div class="form-group clearfix">
											<label class="col-md-3 control-label no-padding-right">
												<!-- 服务类型： -->
												<spring:message code="l_pre_service_type"></spring:message>
											</label>
											<div class="col-md-9 form-control-static">
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio1" name="serviceType" value="" checked="checked">
												  <span class="lbl"> 
												  	<!-- 所有 -->
												  	<spring:message code="l_pre_service_all"></spring:message>
												  </span>
												</label> 
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio2" name="serviceType" value="1">
												  <span class="lbl">
												  	<!-- 中转 -->
												  	<spring:message code="l_pre_service_transfer_stock"></spring:message>
												  </span>
												</label>
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio3" name="serviceType" value="2">
												  <span class="lbl"> 
												  	<!-- 直邮 -->
												  	<spring:message code="l_service_direct_mail"></spring:message>
												  </span>
												</label>
											</div>
										</div>
									</div>
									
									
									
									<%-- <div class="col-md-5">
										<div class="form-group clearfix">
											<label class="col-md-3 control-label no-padding-right">
												<!-- 邮寄类型： -->
												<spring:message code="l_pre_mail_type"></spring:message>
											</label>
											<div class="col-md-9 form-control-static">
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio-mail-1" name="dispatchType" value="" checked="checked">
												  <span class="lbl"> 
												  	<!-- 全部 -->
												  	<spring:message code="l_pre_mail_type_all"></spring:message>
												  </span>
												</label> 
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio-mail-2" name="dispatchType" value="1">
												  <span class="lbl">
												   	<!-- 平邮小包 -->
												   	<spring:message code="l_pre_mail_type_surface_mail_bag"></spring:message>
												   </span>
												</label>
												<label class="radio-inline">
												  <input type="radio" class="ace" id="inlineRadio-mail-3" name="dispatchType" value="2">
												  <span class="lbl">
												  	 <!-- 挂号小包 -->
												  	 <spring:message code="l_pre_mail_type_registration_bag"></spring:message>
												   </span>
												</label>
											</div>
										</div>
									</div> --%>
									
									
									
								</div>
								<div class="row-fluid wizard-actions">
									<button type="button" onclick="formReset()" class="btn btn-default btn-sm">
										<!-- 重置 -->
										<spring:message code="l_pre_reset"></spring:message>
									</button>
									<button type="button" onclick="" id="selectBtn" class="btn btn-primary btn-sm">
										<!-- 查询 -->
										<spring:message code="l_pre_select"></spring:message>
									</button>
								</div>
							</div><!-- /widget-main -->
						</div><!-- /widget-body -->
					</div><!-- /widget-box -->
				</div>
			</div>
		</form>
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
					<!-- 历史中列表 -->
					<spring:message code="l_pre_history_list"></spring:message>
				</h5>
				<div class="widget-toolbar no-border">
					<!-- <button class="btn btn-xs btn-info"><i class="icon-legal"></i> 新建</button> -->
					<button class="btn btn-xs btn-danger" id="deleteTarget-client"><i class="icon-trash"></i>
						 <!-- 删除 -->
						 <spring:message code="l_pre_delete"></spring:message>
					 </button>
					<button class="btn btn-xs btn-success" id="downloadTarget-client" onclick="download()"><i class="icon-ok"></i>
						<!-- 下载 -->
						<spring:message code="l_pre_download"></spring:message>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="table-client"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 预报清单 -->
<div class="modal fade" id="clientDetialModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" style="width:100%; height:100%">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
        	<!-- 预报清单 -->
        	<spring:message code="l_pre_history_list"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
       	 <div id="clientModalMain"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
        	<!-- 返回 -->
        	<spring:message code="l_pre_back"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>

<!-- 删除机构信息 -->
<div class="modal fade" id="deleteDetailListAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         删除 --><spring:message code="l_delete"/>
        </h4>
      </div>
      <div class="modal-body" id="del_msg">
<!--        	 确定要删除该机构吗？ --><spring:message code="l_delete_remind"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="detailListDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>

<!-- 航班、航空提单 -->
<div class="modal fade" id="optsModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="optsModalHeader">
<!--        航班号--><spring:message code="l_pre_edit_truckingNo_and_airwayBillNo_info"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="optsForm">
        	<input type="hidden" id="dispatchNo_inp" name="dispatchNo">
        	<input type="hidden" id="postofficeEnName_inp" name="postofficeEnName">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
								<!--航班号 -->
								<spring:message code="l_flight_number"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="truckingNo_inp" name="truckingNo" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
								<!-- 航空提单： -->
								<spring:message code="l_shipping_ordercode"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="airwayBillNo_inp" name="airwayBillNo" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
        	</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="optsSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
var DISPATCH_TYPE_MD = {4:["EMD","EMC","R","R-M"],5:["OM","PZ","R"],6:["OM","PZ","R"],"def":["EMD","EMC","R","R-M"],"":["EMD","EMC","R","R-M","PZ","OM"]};
var DISPATCH_TYPE_DE = {4:["EMD","EMC","R","R-M"],5:["OM","PZ","R","EMS"],6:["OM","PZ","R","EMS"],"def":["EMD","EMC","R","R-M"],"":["EMD","EMC","R","R-M","PZ","OM"]};
{
	var initDispatchType = function(id, obj){
		var types = obj[id] || obj["def"];
		var html = "<option value=''><spring:message code='l_pre_please_choose'/></option>";
		for(var _i = 0 ; _i < types.length; _i++){
			html += "<option value='"+types[_i]+"'>"+types[_i] + "</option>";
		}
		$("#dispatchType").html(html);
		$("#dispatchType").trigger("chosen:updated");
	};
	$("#clientList").find("input[name='serviceType']").bind('change',function(){
		initDispatchType($("#postoffice").val(), $(this).val() == 1 ? DISPATCH_TYPE_MD : DISPATCH_TYPE_DE);
	});
	$("#postoffice").bind('change',function(){
		initDispatchType($(this).val(), $("#clientList").find("input[name='serviceType'][checked='checked']").val() == 1 ? DISPATCH_TYPE_MD : DISPATCH_TYPE_DE);
	});
	initDispatchType($("#postoffice").val(), $("#clientList").find("input[name='serviceType'][checked='checked']").val() == 1 ? DISPATCH_TYPE_MD : DISPATCH_TYPE_DE);
}
$('#beginAddTime-forClient').datepicker().bind('changeDate',function(ev){
	var startTime = $('#beginAddTime-forClient').val();
	$('#endAddTime-forClient').datepicker('setStartDate',startTime);
	$('#beginAddTime-forClient').datepicker('hide')
});
$('#endAddTime-forClient').datepicker().bind('changeDate',function(ev){
	var endTime = $('#endAddTime-forClient').val();
	$('#beginAddTime-forClient').datepicker('setEndDate',endTime);
	$('#endAddTime-forClient').datepicker('hide')
});
$('#clientList select').chosen();
$('#table-client').datagrid_ace({
	caption:'',
	url: '/client/list/getCommitDetailList.html',
	colNames:['<spring:message code="l_pre_serial_number"/>', '<spring:message code="l_pre_submit_time"/>',
	          '邮局地址','<spring:message code="l_pre_c_postOffice"/>',
	          '<spring:message code="l_pre_send_date"/>','<spring:message code="l_pre_predict_arrive_time"/>', 
	          '<spring:message code="l_pre_actual_arrive_time"/>', '<spring:message code="l_js_shipping_ordercode"/>',
	          '<spring:message code="l_pre_c_batch_number"/>','<spring:message code="l_pre_c_account_number"/>',
	          '<spring:message code="l_pre_c_fight_number"/>','<spring:message code="l_pre_c_service"/>',
	          '<spring:message code="l_pre_product"/>',
	          '<spring:message code="l_js_forecast_number_of_pouch"/>',
	          '<spring:message code="l_js_forecast_total_weight"/>',
	          '许可邮件号',
	          '付款方式','状态',
	          '<spring:message code="l_pre_status_time"/>','<spring:message code="l_pre_status_content"/>',
	          '邮局英文名','服务类型','是否不完整','<spring:message code="l_pre_truckingNo_and_airwayBillNo"/>'],
	height:380,
	rownumbers:true,
	colModel:[
		{name:'myac',index:'', width:60,hidden:true},
		{name:'submitDate',index:'id', width:150},
		{name:'postofficeAddr',index:'postofficeAddr', hidden:true},
		{name:'postoffice',index:'postoffice',width:100},
		{name:'dispatchDate',index:'sdate',width:160,hidden:true},
		{name:'estimateArrivceDate',index:'name', width:150,hidden:true},
		{name:'actualArrivceDate',index:'stock', width:150,hidden:true},
		{name:'airwayBillNo',index:'ship', width:100,hidden:true},
		{name:'dispatchNo',index:'note', width:160},
		{name:'accountNo',index:'id2', width:160,hidden:true},
		{name:'truckingNo',index:'sdate2',width:150,hidden:true},
		{name:'serviceTypeName',index:'name2', width:100},
		{name:'dispatchType',index:'stock2', width:100},
		{name:'estimateBagNum',index:'ship2', width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(0);
		}},
		{name:'estimateTotalWeight',index:'note2', width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'ppiNo',index:'ppiNo', hidden:true},
		{name:'payMode',index:'payMode', hidden:true},
		{name:'status',index:'status', hidden:true},
		{name:'statusTime',index:'statusTime',width:150,hidden:true},
		{name:'statusContent',index:'statusContent',width:335},
		{name:'postofficeEnName',index:'postofficeEnName',hidden:true},
		{name:'serviceType',index:'serviceType', hidden:true},
		{name:'isBroken',index:'isBroken', hidden:true},
		{name:'opts',index:'opts', width:350,formatter:function(cellvalue, options, rowObject){
			var content = '<div class="btn-group"><button class="btn btn-xs btn-info" onclick="optFunc(\''+rowObject.dispatchNo+"\',\'"+rowObject.postofficeEnName+"\',\'"+rowObject.truckingNo+"\',\'"+rowObject.airwayBillNo+'\')">';
			var tempStr = '';
			if(rowObject.truckingNo!= '' && rowObject.airwayBillNo!=''){
				tempStr = rowObject.truckingNo+'/'+rowObject.airwayBillNo;
			}
			content += '<i class="icon-edit bigger-120"></i></button>'+tempStr+'</div>';
			return content;
		}}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		$('#clientDetialModal').modal('show');
		$('#clientModalMain').load('/client/toHistoryOrderDetail.html',function(){
			$('#dispatchNoForDetial').val(rowData.dispatchNo);
			$('#postofficeEnName').val(rowData.postofficeEnName);
			$('#input_dispatchType').val(rowData.dispatchType);
			for(var o in rowData){
				if($("#orderPage-orderdetial select[name='" + o + "']").length > 0){
					$("#orderPage-orderdetial select[name='" + o + "']").html("<option>" + rowData[o] + "</option>");
				}else if($("#orderPage-orderdetial input[name='" + o + "']").is('[type=radio]') > 0){
					$("#orderPage-orderdetial input[name='" + o + "'][value='" + eval("rowData."+o) + "']").attr('checked',true);
				}else{
					$("#orderPage-orderdetial input[name='" + o + "']").val(rowData[o]);
				}
			};
			$('#orderPage-orderdetial select').chosen({width:"100%"});
		})
	},
	searchOption:{
		searchButton:'#selectBtn',
		searchFormId:"#clientList"
	},
	gridComplete:function(){
		afterCompleteFunction('#table-client')
	}
});
$( "#deleteTarget-client" ).tooltip({
	/* html:true,
	show: null,
	position: {
		my: "left top",
		at: "left bottom"
	},
	open: function( event, ui ) {
		ui.tooltip.animate({ top: ui.tooltip.position().top + 10 }, "fast" );
	},
	title:"<div style='text-align:left'><p>1.物理删除</p><p>2.可以批次删除</p></div>" */
}).click(function(){
	var _v=getCheckRowsData('table-client',['dispatchNo']);
	var _poen=getCheckRowsData('table-client',['postofficeEnName']);
	if(!_v){
		/* modalAlert('请先选择需要操作的数据！'); */
		modalAlert('<spring:message code="l_pre_please_select_operate_data"/>');
	}else{
		var d_msg = "[";
		for(var i = 0; i < _v['dispatchNo'].length; i++){
			d_msg += _v['dispatchNo'][i] + ",";
		}
		if(d_msg.length > 0){
			d_msg = d_msg.substring(0, d_msg.length - 1);
		}
		d_msg += "]";
		delAlert('show');
		$('#detailListDeleteSubmit').unbind('click').bind('click',function(){
			delAlert('hide');
	 		ajaxEngine.postAjax("/client/list/deleteDetailListByDispatchNo.html", {"list":_v.dispatchNo.join(","),"poenList":_poen.postofficeEnName.join(",")}, updateDelete)
		});
	}
});
var delAlert = function(op, msg){
	$('#deleteDetailListAlert').modal(op);
	if(op == 'show'){
		var text = $("#del_msg").text();
		if(text.indexOf("[") != -1){
			text = text.substring(0, text.indexOf("["));
		}
		if(msg){
			text += msg;
		}
		$("#del_msg").text(text);
	}
};
var updateDelete = function(rslt){
	if(rslt.code == "1"){
		$('#table-client').trigger("reloadGrid");
	} else{
		modalAlert(rslt.info);
	}
};

var download = function(){
	var _v=getCheckRowsData('table-client',['dispatchNo']);
	if(!_v){
		/* modalAlert('请先选择需要操作的数据！') */
		modalAlert('<spring:message code="l_pre_please_select_operate_data"/>')
	}else{
		window.open('/client/list/downloadDetailList.html?dispatchNoArray='+_v.dispatchNo.join(","));
	}
}

var formReset = function(){
	$('#clientList')[0].reset();
	$("#clientList select").trigger("chosen:updated");
}
$('#clientDetialModal').on('hidden.bs.modal', function () {
	$('#clientModalMain').empty();
	//$("#orderPage-orderdetial select").chosen("destroy");
});
//改变行颜色
function afterCompleteFunction(_grid){
	//获取列表数据
	var rowDatas = $(_grid).jqGrid('getRowData'),cls = 'datagrid-info';
	for(i=0;i<rowDatas.length;i++){
		var rowData = rowDatas[i]; 
		if(rowData.status=='3'){
			cls= 'datagrid-info';
		}else if(rowData.status=='5' || rowData.status=='7'){
			cls= 'datagrid-success'
		}else if(rowData.status=='9' || rowData.status=='11'){
			cls= 'datagrid-muted'
		}else if(rowData.status=='8'){
			cls= 'datagrid-success';
		};
		if(rowData.isBroken==1){
			$(_grid).find('#'+(i+1)).addClass("text-danger2");
		}
		$(_grid).find('#'+(i+1)).addClass(cls)
	}
	return true;
}
//航班、航空提单
function optFunc(dispatchNo,postofficeEnName,truckingNo,airwayBillNo){
	$('#optsModal').modal('show');
	$('#optsForm')[0].reset();
	$('#dispatchNo_inp').val(dispatchNo);
	$('#postofficeEnName_inp').val(postofficeEnName);
	$('#truckingNo_inp').val(truckingNo);
	$('#airwayBillNo_inp').val(airwayBillNo);
	
}
//
$('#optsSubmit').bind('click',function(){
	
	formValidation.setFormObj($("#optsForm"));
	formValidation.init();
	
	if(formValidation.check()){
		$.ajax({
		   type: "POST",
		   url: '/client/updateTruckingNo.html',
		   data:$("#optsForm").serializeJson(),
		   dataType: "json",
		   success: function(rslt) {
				$('#optsModal').modal('hide');
			   if(rslt.code="1"){
				   $('#table-client').trigger("reloadGrid");
				   modalAlert('<spring:message code="l_pre_save_sucess"/>');
			   }else{
				   modalAlert('<spring:message code="l_pre_save_fail"/>');
			   }
		   }
		});
	}
	
})
</script>

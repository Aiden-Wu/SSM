<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
		<!-- 预报中列表详情 -->
		<spring:message code="l_pre_history_detial_list_details"/>
	</h5>
</div>
<div class="container-fluid" id="orderPage-orderdetial">
	<ul class="nav nav-tabs nav-justified">
	  <li role="presentation" class="active"><a href="#infoTabContent" aria-controls="infoTabContent" role="tab" data-toggle="tab">
	  	<!-- 配送邮路信息 -->
	  	<spring:message code="l_pre_delivery_route_info"/>
	  </a></li>
	  <li role="presentation"><a href="#infoTabContent2" aria-controls="infoTabContent2" role="tab" data-toggle="tab" id="infoTabContentTarget2">
	  	<!-- 详情 -->
	  	<spring:message code="l_pre_details"/>
	  </a></li>
	</ul>
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
							<!-- <select class="form-control" id="" name="postoffice" disabled="disabled">
								
							</select> -->
							<input type="text" class="form-control" id="postoffice" name="postoffice" value="" disabled="disabled">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 账户编号： -->
							<spring:message code="l_account_number"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="accountNo" value="1" disabled="disabled">
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
							<input type="text" class="form-control" name="ppiNo" value="" disabled="disabled">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 邮局地址： -->
							<spring:message code="l_postoffice_address"></spring:message>
						</label>
						<div class="col-md-8">
							<!-- <select class="form-control" id="" name="postofficeAddr">
							</select> -->
							<input type="text" class="form-control" id="postofficeAddr" name="postofficeAddr" value="" disabled="disabled">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 服务： -->
							<spring:message code="l_service"></spring:message>
						</label>
						<div class="col-md-8 form-control-static">
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio2" name="serviceType" value="1"><span class="lbl"> 
							  	<!-- 中转 -->
							  	<spring:message code="l_service_transfer_stock"></spring:message>
							  </span>
							</label>
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio1" name="serviceType" value="2"><span class="lbl"> 
							  	<!-- 直邮 -->
							  	<spring:message code="l_service_direct_mail"></spring:message>
							  </span>
							</label> 
						</div>
					</div>
				</div>
				<%-- <div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 航运单号： -->
							<spring:message code="l_shipping_ordercode"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="airwayBillNo" value="" disabled="disabled">
						</div>
					</div>
				</div> --%>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 邮寄方式： -->
							<spring:message code="l_Shipping_method"></spring:message>
						</label>
						<div class="col-md-8">
							<select class="form-control" id="" name="dispatchType" disabled="disabled">
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<%-- <div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 航班号： -->
							<spring:message code="l_flight_number"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" name="truckingNo" value="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4" style="display: none">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 付款方式： -->
							<spring:message code="l_pay_mode"></spring:message>
						</label>
						<div class="col-md-8">
							<select class="form-control" id="" name="payMode" disabled="disabled">
								<option>信用额度</option>
							</select>
						</div>
					</div>
				</div> --%>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 邮袋数： -->
							<spring:message code="l_mail_bag_num"></spring:message>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" class="form-control" id="" name="estimateBagNum" placeholder="邮袋数" readonly="readonly">
						      <div class="input-group-addon">PCS</div>
						    </div>
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
						      <input type="text" class="form-control" id="" name="estimateBagNum" placeholder="邮袋数" readonly="readonly">
						      <div class="input-group-addon">PCS</div>
						    </div>
						</div>
					</div>
				</div> --%>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 总重量： -->
							<spring:message code="l_total_weight"></spring:message>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" name="estimateTotalWeight" class="form-control" id="" name="estimateTotalWeight" placeholder="总重量" readonly="readonly">
						      <div class="input-group-addon">KG</div>
						    </div>
						</div>
					</div>
				</div>
				<%-- <div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 发货日期： -->
							<spring:message code="l_send_date"></spring:message>
						</label>
						<div class="col-md-8">
							<div class="input-group">
								<input class="form-control date-picker" id="id-date-picker-orderdetial-1" name="dispatchDate" type="text" data-date-format="dd-mm-yyyy" disabled="disabled">
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
							<!-- 预计到达日期： -->
							<spring:message code="l_arrive_date"></spring:message>
						</label>
						<div class="col-md-8">
							<div class="input-group">
								<input class="form-control date-picker" name="estimateArrivceDate" id="id-date-picker-orderdetial-2" type="text" data-date-format="dd-mm-yyyy" disabled="disabled">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
				</div> --%>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 批次号： -->
							<spring:message code="l_batch_number"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" name="dispatchNo" class="form-control" placeholder="批次号" readonly="readonly">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div role="tabpanel" class="tab-pane" id="infoTabContent2">
			<div class="gridContent" style="width:99%" id="orderDetialContent">
				<table class="table table-bordered" id="table-orderDetial-r"></table>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="dispatchNoForDetial"/>
<input type="hidden" id="postofficeEnName"/>
<input type="hidden" id="input_dispatchType"/>
<script>
var lastsel;
setTimeout(function(){
	$('#id-date-picker-orderdetial-1').datepicker().bind('changeDate',function(ev){
		var startTime = $('#id-date-picker-orderdetial-1').val();
		$('#id-date-picker-orderdetial-2').datepicker('setStartDate',startTime);
		$('#id-date-picker-orderdetial-1').datepicker('hide')
	});
	$('#id-date-picker-orderdetial-2').datepicker().bind('changeDate',function(ev){
		var endTime = $('#id-date-picker-orderdetial-2').val();
		$('#id-date-picker-orderdetial-1').datepicker('setEndDate',endTime);
		$('#id-date-picker-orderdetial-2').datepicker('hide')
	});
	//$('#orderPage-orderdetial select').chosen();
	$('#table-orderDetial-r').datagrid_ace({
		url: '/client/package.html',
		caption: "",
		colNames:['<spring:message code="l_pre_bag_no"/>','<spring:message code="l_pre_referenceId"/>',
		          'CN35', '<spring:message code="l_pre_country_no"/>',
		          '<spring:message code="l_pre_product"/>','<spring:message code="l_js_forecast_total_number_of_packages"/>', 
		          '<spring:message code="l_js_forecast_total_weight_of_pouch"/>','邮局英文名字',
		          '<spring:message code="l_js_actual_number_of_pouch"/>','<spring:message code="l_js_actual_total_weight"/>'],
		height:250,
		autoScroll:true,
		altRows:false,
		shrinkToFit:true,
		rownumbers:true,
		scroll:true,
		multiselect:false,
		colModel:[
			{name:'packageNo',index:'packageNo', width:120},
			{name:'referenceId',index:'referenceId', width:120,hidden:true},
			{name:'cn35',index:'id', width:120,hidden:true},
			{name:'countryCode',index:'id', width:120},
			{name:'dispatchType',index:'id', width:120},
			{name:'estimatePackageNum',index:'name', width:150},
			{name:'estimatePackageWeight',index:'ship'},
			{name:'postofficeEnName',index:'ship',hidden:true},
			{name:'actualPackageNum',index:'ship'},
			{name:'actualPackageWeight',index:'ship'}
		],
		ondblClickRow:function(rowid,iRow,iCol,e,rowData){
			
		}
        //editurl : "/client/updatePackageInfo.html"
	});	
},0);
$('#infoTabContentTarget2').on('shown.bs.tab', function (e) {
	setGridWidthFnc();
	$('#table-orderDetial-r').jqGrid('setGridParam', {
		url: '/client/package.html',
		postData:{dispatchNo:$('#dispatchNoForDetial').val(), postofficeEnName:$('#postofficeEnName').val(),dispatchType:$('#input_dispatchType').val()},
	    page : 1,
	    datatype:"JSON"
	  }).trigger("reloadGrid");
});
//设置弹窗表格宽度
function setGridWidthFnc(){
	$('#table-orderDetial-r').setGridWidth($('#orderDetialContent').width()*.99)
};

</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
		<!-- 预报中列表详情 -->
		<spring:message code="l_pre_predict_detial_list_details"/>
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
							  <input type="radio" class="ace" id="inlineRadio2" name="serviceType" value="1" ><span class="lbl"> 
							  	<!-- 中转 -->
							  	<spring:message code="l_service_transfer_stock"></spring:message>
							  </span>
							</label>
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio1" name="serviceType" value="2" ><span class="lbl"> 
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
							<input type="text" class="form-control" name="airwayBillNo" value="">
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
							<select class="form-control hidden" id="truckingNo_edit_select" name="">
								<option value=".">.</option>
							</select>
							<input type="text" class="form-control hidden" id="truckingNo_edit_input" name="" value="">
							<input type="hidden" value="" name="truckingNoId"/>
						</div>
					</div>
				</div> --%>
				<%-- <div class="col-md-4" style="display: none">
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
							<!-- 批次号： -->
							<spring:message code="l_batch_number"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" name="dispatchNo" class="form-control" placeholder="批次号" readonly="readonly">
						</div>
					</div>
				</div>
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
			</div>
			<div class="row">
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
				<%-- <div class="col-md-4">
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
				</div> --%>
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
				</div> --%>
				<%-- <div class="col-md-4">
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
				<%-- <div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
							<!-- 批次号： -->
							<spring:message code="l_batch_number"></spring:message>
						</label>
						<div class="col-md-8">
							<input type="text" name="dispatchNo" class="form-control" placeholder="批次号" readonly="readonly">
						</div>
					</div>
				</div> --%>
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
<input type="hidden" id="bmOrgId"/>
<input type="hidden" id="truckingNo"/>
<script>
var lastsel;
function loadBag(){
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
	
	$('#table-orderDetial-r').datagrid_ace({
		url: '/client/package.html',
		caption: "",
		colNames:['<spring:message code="l_pre_bag_no"/>','<spring:message code="l_pre_referenceId"/>',
		          'CN35', '<spring:message code="l_pre_country_no"/>',
		          '<spring:message code="l_pre_product"/>','<spring:message code="l_js_forecast_total_number_of_packages"/>', 
		          '<spring:message code="l_js_forecast_total_weight_of_pouch"/>','邮局英文名字'],
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
			{name:'cn35',index:'id', width:120, hidden:true},
			{name:'countryCode',index:'id', width:120},
			{name:'dispatchType',index:'id', width:120},
			{name:'estimatePackageNum',index:'name', width:120},
			{name:'estimatePackageWeight',index:'ship',width:120},
			{name:'postofficeEnName',index:'ship',hidden:true}
		],
		ondblClickRow:function(rowid,iRow,iCol,e,rowData){
			
		},
		onSelectRow : function(id) {
         // if (id && id !== lastsel) {
            $('#table-orderDetial-r').jqGrid('restoreRow', lastsel);
           // $('#table-orderDetial-r').jqGrid('editRow', id, true);
            var rowIds = $('#table-orderDetial-r').jqGrid('getDataIDs');
            lastsel = id;
            var _rowD = $('#table-orderDetial-r').jqGrid('getRowData', lastsel);
            _rowD.dispatchNo=$('#dispatchNoForDetial').val();
            _rowD.cn35 = $("#"+id+'_cn35').val();
            $('#table-orderDetial-r').jqGrid('editRow', id,{  
                keys : true,        //这里按[enter]保存  
                url: "/client/updatePackageInfo.html",  
                mtype : "POST",  
                extraparam: _rowD,  
                oneditfunc: function(rowid){  
                    
                },  
                successfunc: function(res){
                	var data = JSON.parse(res.responseText);
                	if(data.code == "1"){
                		if($.inArray(lastsel,rowIds)+1 < rowIds.length){
          		   			lastsel = rowIds[$.inArray(lastsel,rowIds)+1];
          		   			$('#table-orderDetial-r').jqGrid('setSelection',lastsel);
          		   		} 
                	    return true;
             		} else{
               			modalAlert(data.info);
               		}
                	
                    return false;  
                },  
                errorfunc: function(rowid, res){  
                     
                }  
            });  
            /* $('#table-orderDetial-r input').bind('keydown',function(e){
            	var ev = document.all ? window.event : e;
                if(ev.keyCode==13) {
                	var _rowD = $('#table-orderDetial-r').jqGrid('getRowData', lastsel);
                	_rowD.cn35 = $("#"+lastsel+"_cn35").val();
                	
                	if(_rowD.cn35 == ''){
                		modalAlert('cn35不能为空');
                		return false;
                	}
                	_rowD.dispatchNo=$('#dispatchNoForDetial').val();
                	$.ajax({
               		   type: "POST",
               		   url: "/client/updatePackageInfo.html",
               		   data:_rowD,
               		   success: function(data) {
               			if(data.code == "1"){
               			//$('#table-orderDetial-r').trigger("reloadGrid");
              		   		//$('#table-orderDetial-r').jqGrid('saveRow', lastsel,false);
              		   		//$('#table-orderDetial-r').jqGrid('resetSelection',lastsel);
              		   		if($.inArray(lastsel,rowIds)+1 < rowIds.length){
              		   			lastsel = rowIds[$.inArray(lastsel,rowIds)+1];
              		   			$('#table-orderDetial-r').jqGrid('setSelection',lastsel);
	               		   		//$('#table-orderDetial-r').jqGrid('restoreRow', lastsel);
	               	            //$('#table-orderDetial-r').jqGrid('editRow', lastsel, true);
              		   		} 
               			} else{
               				modalAlert(data.info);
               			}
              		   		
               		   }
               		});
                	
					return false
                }
            }) */
          //}
        }
        //editurl : "/client/updatePackageInfo.html"
	});
	initTrunkNo($('#bmOrgId').val());
};
loadBag();
$('#infoTabContentTarget2').on('shown.bs.tab', function (e) {
	setGridWidthFnc();
	lastsel = null;
	$('#table-orderDetial-r').jqGrid('setGridParam', {
		url: '/client/package.html',
		postData:{dispatchNo:$('#dispatchNoForDetial').val(),postofficeEnName:$('#postofficeEnName').val(),dispatchType:$('#input_dispatchType').val()},
	    page : 1,
	    datatype:"JSON"
	  }).trigger("reloadGrid");
});
//设置弹窗表格宽度
function setGridWidthFnc(){
	$('#table-orderDetial-r').setGridWidth($('#orderDetialContent').width()*.99)
};

function initTrunkNo(bmid){
	ajaxEngine.getAjax('/client/getTrunkingLineListByDepartmentID.html', {id:bmid}, updateTLine);
};

var updateTLine = function(rslt){
	if(rslt.code == "1"){
		var arr = rslt.data;
		if(arr.length > 0){
			$('#truckingNo_edit_input').addClass('hidden');
			$('#truckingNo_edit_select').removeClass('hidden');
			$('#truckingNo_edit_input').attr('name', '');
			$('#truckingNo_edit_select').attr('name', 'truckingNo');
			var thtml = "<option value='.'>.</option>";
			for(var i=0; i < arr.length; i++){
				thtml += "<option value='" + arr[i].name + "' data-id='" + arr[i].id + "'>" + arr[i].name + "</option>";
			}
			$("#infoTabContent").find("input[name='truckingNoId']").val("-1");
			$("#truckingNo_edit_select").html(thtml);
// 			$("#truckingNo_edit_select").trigger("chosen:updated");
			$("#truckingNo_edit_select").on("change",truckingNo_edit_select_change);
			$('#truckingNo_edit_select').val($('#truckingNo').val());
			truckingNo_edit_select_change();
		} else{
			$('#truckingNo_edit_select').addClass('hidden');
			$('#truckingNo_edit_input').removeClass('hidden');
			$('#truckingNo_edit_select').attr('name', '');
			$('#truckingNo_edit_input').attr('name', 'truckingNo');
		}
	} else {
		$('#truckingNo_edit_select').addClass('hidden');
		$('#truckingNo_edit_input').removeClass('hidden');
		$('#truckingNo_edit_select').attr('name', '');
		$('#truckingNo_edit_input').attr('name', 'truckingNo');
	}
};

var truckingNo_edit_select_change = function(){
	var dataId = $('#truckingNo_edit_select').find("option:selected").attr("data-id");
	dataId = dataId || -1;
	$("#infoTabContent").find("input[name='truckingNoId']").val(dataId);
}
</script>

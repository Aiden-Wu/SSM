<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="pendingListPage">
	<div class="page-header">
		<h5>
<!-- 		搜索待处理任务 --><spring:message code="l_search_for_processing_tasks"/>
		</h5>
	</div>
	<div class="page-content">
		<form action="" id="pendingTaskList">
			<div class="row">
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 						提交开始日期： --><spring:message code="l_submit_the_start_date"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
								<input class="form-control" type="text" name="beginAddTime" id="id-date-picker-search-1" />
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
<!-- 						提交截至日期： --><spring:message code="l_submission_deadline"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
								<input class="form-control" type="text" name="endAddTime" id="id-date-picker-search-2" />
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
<!-- 						批次号： --><spring:message code="l_batch_number"/>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" placeholder="<spring:message code="l_js_batch_number"/>" name="dispatchNo" id="dispatchNo">
						</div>
					</div>
				</div>
				<%-- <div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 						客户： --><spring:message code="l_customer"/>
						</label>
						<div class="col-md-8">
							<select class="form-control" name="jgOrgId" id="jgOrgId">
									<option value="" selected="selected">
										<!-- 请选择 -->
										<spring:message code="l_pre_please_choose"></spring:message>
									</option>
							</select>
						</div>
					</div>
				</div> --%>
				<div class="col-md-5">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 						服务： --><spring:message code="l_service"/>
						</label>
						<div class="col-md-9 form-control-static">
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio1" name="serviceType" value="-1" checked="checked"><span class="lbl">
<!-- 							   所有 --><spring:message code="l_all"/>
							   </span>
							</label> 
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio2" name="serviceType" value="1"><span class="lbl">
<!-- 							   中转 --><spring:message code="l_transit"/>
							   </span>
							</label>
							<label class="radio-inline">
							  <input type="radio" class="ace" id="inlineRadio3" name="serviceType" value="2"><span class="lbl">
<!-- 							   直邮 --><spring:message code="l_direct_mail"/>
							   </span>
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right"></label>
						<div class="col-md-8 form-control-static">
							<button type="reset" class="btn btn-default btn-sm">
	<!-- 						重置 --><spring:message code="l_reset"></spring:message>
							</button>
							<button type="button" id="pending-search" onclick="" class="btn btn-primary btn-sm">
	<!-- 						查询 --><spring:message code="l_query"/>
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
<!-- 					待处理任务 --><spring:message code="l_to_do_tasks"/>
				</h5>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="table-pending"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 录入重量 -->
<div class="modal fade" id="weightModal" tabindex="-1" role="dialog" >
  <div class="modal-dialog" style="width:100%;height:100%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         录入重量 --><spring:message code="l_input_the_weight"/>
        </h4>
      </div>
      <div class="modal-body">
      	<form id="inputWeightForm">
        	<input type="hidden" id="postofficeEnName_edit">
	      	<div class="row">
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							扫描CN35查找邮袋编号： --><spring:message code="l_scanning_cn35_find_pouch_number"/>
						</label>
						<div class="col-md-8">
							<input type="text" id="packageNo" name="packageNo" class="form-control" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<div class="col-md-4">
							<button id="inputWeightButton" type="button" onclick="queryPackage();" class="col-md-6 btn btn-primary btn-sm pull-left">
<!-- 							查询 --><spring:message code="l_query"/>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4" style="display: none">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							客户： --><spring:message code="l_customer"/>
						</label>
						<div class="col-md-8">
							<input id="weightModalCustomerName" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							账户编号： --><spring:message code="l_account_number"/>
						</label>
						<div class="col-md-8">
							<input id="weightModalCustomerNo" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							批次号： --><spring:message code="l_batch_number"/>
						</label>
						<div class="col-md-8">
							<input id="weightModalDispatchNo" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							航班号： --><spring:message code="l_flight_number"/>
						</label>
						<div class="col-md-8">
							<input id="weightModalTruckingNo" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							航运提单： --><spring:message code="l_shipping_bill"/>
						</label>
						<div class="col-md-8">
							<input id="weightModalAirwayBillNo" type="text" class="form-control" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							发货时间： --><spring:message code="l_send_date"/>
						</label>
						<div class="col-md-8">
							<input class="form-control date-picker" id="weightModalDispatchDate" type="text" data-date-format="dd/mm/yyyy" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							实际总邮袋数： --><spring:message code="l_actual_total_number_of_pouch"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" class="form-control" id="weightModalActualPackageNum" placeholder="" readonly="readonly">
						      <div class="input-group-addon">PCS</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							预报总邮袋数： --><spring:message code="l_forecast_the_total_number_of_pouch"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" class="form-control" id="weightModalEstimateBagNum" placeholder="" readonly="readonly">
						      <div class="input-group-addon">PCS</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							实际总重量： --><spring:message code="l_the_actual_total_weight"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" class="form-control" id="weightModalActualPackageWeight" placeholder="" readonly="readonly">
						      <div class="input-group-addon">KG</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group clearfix">
						<label class="col-md-4 control-label no-padding-right">
<!-- 							预报总重量： --><spring:message code="l_forecast_the_total_weight"/>
						</label>
						<div class="col-md-8">
							<div class="input-group">
						      <input type="text" class="form-control" id="weightModalEstimateTotalWeight" placeholder="" readonly="readonly">
						      <div class="input-group-addon">KG</div>
						    </div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<div class="gridContent">
			<table class="table table-bordered" id="table-pending-weight"></table>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary pull-left" onclick="updataNowPageData(0)">
<!--         确定 --><spring:message code="l_save"/>
        </button>
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         返回 --><spring:message code="l_back"/>
        </button>
        <button type="button" class="btn btn-primary" onclick="updataNowPageData(1)">
<!--         确定 --><spring:message code="l_pre_submit"/>
        </button>
      </div>
    </div>
  </div>
</div>

<!-- 重量调整 -->
<div class="modal fade" id="editWeightModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         编辑 --><spring:message code="l_edit"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="input_weight_from">
        <input type="hidden" id="postofficeEnName_edit">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							预报总重量： --><spring:message code="l_forecast_the_total_weight"/>
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="text" class="form-control" id="estimatePackageWeight-edit" placeholder="" readonly="readonly">
						      <div class="input-group-addon">KG</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							实际总重量： --><spring:message code="l_the_actual_total_weight"/>
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="number" class="form-control" id="actualPackageWeight-edit" validate="notnull" placeholder="">
						      <div class="input-group-addon">KG</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							误差值： --><spring:message code="l_error_value"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="errorValue-edit" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							预报包裹数量： --><spring:message code="l_forecast_the_number_of_package"/>
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="text" class="form-control" id="estimatePackageNum-edit" placeholder="" readonly="readonly">
						      <div class="input-group-addon">PCS</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							实际包裹数量： --><spring:message code="l_actual_number_of_packages"/>
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="number" class="form-control" id="actualPackageNum-edit" validate="notnull" placeholder="">
						      <div class="input-group-addon">PCS</div>
						    </div>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							备注： --><spring:message code="l_remark"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="remark-edit" placeholder="">
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
        <button type="button" class="btn btn-primary" id="weightEditTarget">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 提示信息 -->
<div class="modal fade" id="messageAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         提示 --><spring:message code="l_prompt"/>
        </h4>
      </div>
      <div class="modal-body">
<!--        	提交之后将无法修改，是否确认提交？ --><spring:message code="l_input_weight_submit_remind"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="messageSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
{
	var nowDate = new Date().toLocaleDateString("EN");
	$('#id-date-picker-search-2').datepicker('setEndDate',nowDate);
	$('#id-date-picker-search-1').datepicker('setEndDate',nowDate);
}
var isSearch = false;
var errorRange = '${errorRange}';
$(document).ready(function() {
	formValidation.setFormObj($("#input_weight_from"));
	formValidation.init();
	var rslt = '${rslt}';
	if(rslt != ''){
		rslt = JSON.parse(rslt);
		var org = rslt.data;
		if(org.length > 0){
			for(var index in org){
				$('#jgOrgId').append('<option value="' + org[index].pid + '">' + org[index].name + '</option>');
			}
		}
	}
});
$('#id-date-picker-search-1').datepicker().bind('changeDate',function(ev){
	var startTime = $('#id-date-picker-search-1').val();
	$('#id-date-picker-search-2').datepicker('setStartDate',startTime);
	$('#id-date-picker-search-1').datepicker('hide');
});
$('#id-date-picker-search-2').datepicker().bind('changeDate',function(ev){
	var endTime = $('#id-date-picker-search-2').val();
	$('#id-date-picker-search-1').datepicker('setEndDate',endTime);
	$('#id-date-picker-search-2').datepicker('hide');
});
$('#customer-for-pending').chosen();
$('#table-pending').datagrid_ace({
	caption: "",
	url: '/post/list/pending.html',
// 	colNames:['提交时间','发货日期','预计到达时间', '实际到达时间', '航运单号', '客户名称', '批次号', '服务类型', '邮寄类型', '邮袋数量', '总重', '状态时间', '状态', '客户编号', '航班号', '邮局英文名称', '实际总邮袋数', '实际总重量'],
	colNames:['<spring:message code="l_js_submit_time"/>','<spring:message code="l_js_send_date"/>',
	          '<spring:message code="l_js_estimated_time_of_arrival"/>', '<spring:message code="l_js_actual_time_of_arrival"/>', 
	          '<spring:message code="l_js_shipping_ordercode"/>', '<spring:message code="l_js_customer_name"/>', 
	          '<spring:message code="l_js_batch_number"/>', '<spring:message code="l_js_shipping_info"/>', '<spring:message code="l_js_service_type"/>', 
	          '<spring:message code="l_js_mail_type"/>', '<spring:message code="l_js_pouch_number"/>', 
	          '<spring:message code="l_js_total_weight"/>', '<spring:message code="l_js_status_time"/>', 
	          '<spring:message code="l_js_status"/>', '<spring:message code="l_js_customer_number"/>', '航班号', '航运提单', '邮局英文名称', '实际总邮袋数', '实际总重量'],
	height:380,
	multiselect:false,
	rownumbers:true,
	colModel:[
		{name:'submitDate',index:'submitDate',width:200},
		{name:'dispatchDate',index:'dispatchDate',width:100,hidden:true},
		{name:'estimateArrivceDate',index:'estimateArrivceDate', width:100,hidden:true},
		{name:'actualArrivceDate',index:'actualArrivceDate', width:100,hidden:true},
		{name:'airwayBillNo',index:'airwayBillNo', width:100,hidden:true},
		{name:'customerName',index:'customerName', width:150, hidden:true},
		{name:'dispatchNo',index:'dispatchNo', width:200},
		{name:'',index:'', width:200,formatter:function(cellvalue, options, rowObject){
			return rowObject.truckingNo+'/'+rowObject.airwayBillNo;
		}},
		{name:'serviceTypeMessage',index:'serviceTypeMessage', width:100},
		{name:'dispatchType',index:'dispatchType', width:100},
		{name:'estimateBagNum',index:'estimateBagNum', width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(0);
		}},
		{name:'estimateTotalWeight',index:'estimateTotalWeight', width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'statusTime',index:'statusTime', width:200},
		{name:'statusMessage',index:'statusMessage', width:150},
		{name:'customerNo',index:'customerNo', width:100, hidden:true},
		{name:'truckingNo',index:'truckingNo', width:100, hidden:true},
		{name:'airwayBillNo',index:'airwayBillNo', width:100, hidden:true},
		{name:'postofficeEnName',index:'postofficeEnName', width:100, hidden:true},
		{name:'actualBagNum',index:'actualBagNum', width:100, hidden:true},
		{name:'actualTotalWeight',index:'actualTotalWeight', width:100, hidden:true}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		$('#weightModal').modal('show');
		$('#inputWeightForm')[0].reset();
		setTimeout(function(){weightModalGrid(rowData)},500);
	},
	searchOption:{
		searchButton:'#pending-search',
		searchFormId:"#pendingTaskList"
	}
});
$('#table-pending-weight').datagrid_ace({
	caption: "",
// 	colNames:['邮袋编号','CN35','包裹类型', '预报总包裹数', '实际包裹数','邮袋预报总重量', '邮袋实际总重量', '误差值', '备注', '邮局英文名称'],
	colNames:['<spring:message code="l_js_pouch_no"/>','<spring:message code="l_js_cn35"/>',
	          '<spring:message code="l_js_package_type"/>', '<spring:message code="l_js_forecast_total_number_of_packages"/>', 
	          '<spring:message code="l_js_actual_total_number_of_packages"/>','<spring:message code="l_js_forecast_total_weight_of_pouch"/>', 
	          '<spring:message code="l_js_actual_total_weight_of_pouch"/>', '<spring:message code="l_js_error_value"/>', 
	          '<spring:message code="l_js_remark"/>', '邮局英文名称'],
	height:380,
	rowList:[30,50,100],
	rowNum:100,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	scroll:true,
	colModel:[
		{name:'packageNo',index:'packageNo', width:120},
		{name:'cn35',index:'cn35',width:120, hidden:true},
		{name:'dispatchType',index:'dispatchType', width:120},
		{name:'estimatePackageNum',index:'estimatePackageNum', width:120,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(0);
		}},
		{name:'actualPackageNum',index:'actualPackageNum', width:120,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(0);
		}},
		{name:'estimatePackageWeight',index:'estimatePackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'actualPackageWeight',index:'actualPackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'errorValue',index:'errorValue', width:120, formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'remark',index:'remark'},
		{name:'postofficeEnName',index:'postofficeEnName', width:100, hidden:true}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		jqgClickRow(rowData,rowid);
		$('#table-pending-weight').jqGrid("setSelection",rowid);
	},
	gridComplete:function(){
		afterCompleteFunction('#table-pending-weight');
		addUpdate();
		if(isSearch){
			$('#table-pending-weight tbody tr td').trigger('dblclick')
			isSearch = false;
		}
	}
});
//双击表格行
function jqgClickRow(rowData,rowid){
	$('#editWeightModal').modal('show');
	$('#estimatePackageWeight-edit').val(rowData.estimatePackageWeight);
	$('#actualPackageWeight-edit').val(rowData.actualPackageWeight);
	$('#estimatePackageNum-edit').val(rowData.estimatePackageNum);
	$('#actualPackageNum-edit').val(rowData.actualPackageNum);
	$('#errorValue-edit').val(rowData.errorValue);
	$('#remark-edit').val(rowData.remark);
	$('#weightEditTarget').attr('data-rowid',rowid);
}
function weightModalGrid(rowData){
	$('#postofficeEnName_edit').val(rowData.postofficeEnName);
	$('#weightModalCustomerName').val(rowData.customerName);
	$('#weightModalCustomerNo').val(rowData.customerNo);
	$('#weightModalDispatchNo').val(rowData.dispatchNo);
	$('#weightModalTruckingNo').val(rowData.truckingNo);
	$('#weightModalAirwayBillNo').val(rowData.airwayBillNo);
	$('#weightModalDispatchDate').val(rowData.dispatchDate);
	$('#weightModalEstimateBagNum').val(parseFloat(rowData.estimateBagNum).toFixed(0));
	$('#weightModalEstimateTotalWeight').val(parseFloat(rowData.estimateTotalWeight).toFixed(3));
	$('#weightModalActualPackageWeight').val(parseFloat(rowData.actualTotalWeight).toFixed(3));
	$('#weightModalActualPackageNum').val(parseFloat(rowData.actualBagNum).toFixed(0));
	$('#table-pending-weight').jqGrid('setGridParam', {
	 	url: '/post/package.html',
	    page : 1,
	    postData:{'dispatchNo':rowData.dispatchNo, 'postofficeEnName':rowData.postofficeEnName,from:1},
	    datatype:"JSON"
	}).trigger("reloadGrid");
	$('#table-pending-weight').jqGrid('setGridWidth',$('#table-pending-weight').parents('.gridContent').width())
};

/*更新行数据*/
function updataGridRow(id){
	$('#table-pending-weight').setRowData(id,{
		'actualPackageWeight':$('#actualPackageWeight-edit').val(),
		'actualPackageNum':$('#actualPackageNum-edit').val(),
		'errorValue':$('#errorValue-edit').val(),
		'remark':$('#remark-edit').val()
	});
	var errorValue = parseFloat($('#errorValue-edit').val());
	$('#table-pending-weight #'+id+' .text-success').removeClass('text-success');
	$('#table-pending-weight #'+id+' .text-danger').removeClass('text-danger');
	if(errorValue >= errorRange || errorValue <= errorRange*-1){
		$('#table-pending-weight').setCell(id,"errorValue","", "text-danger");
	}else{
		$('#table-pending-weight').setCell(id,"errorValue","", "text-success");
	}
	
};

$('#weightEditTarget').bind('click',function(e){
	if(!formValidation.check()){
		return false;
	}
	if($('#editWeightModal #actualPackageWeight-edit').hasClass('editing')){
		//用户修改实际总重量， 当实际总重量为0或空时，则自动讲其赋值为预报总重量
		if($('#editWeightModal #actualPackageWeight-edit').val() == 0 ||$('#editWeightModal #actualPackageWeight-edit').val() == ''){
			$('#editWeightModal #actualPackageWeight-edit').val($('#estimatePackageWeight-edit').val());
			var _errorV = parseFloat($('#actualPackageWeight-edit').val())-parseFloat($('#estimatePackageWeight-edit').val())
			$('#errorValue-edit').val(_errorV.toFixed(3));
		}
	}else{
		//用户没修改实际总重量， 当实际总重量为0时，则自动讲其赋值为预报总重量
		if($('#editWeightModal #actualPackageWeight-edit').val() == 0){
			$('#editWeightModal #actualPackageWeight-edit').val($('#estimatePackageWeight-edit').val());
			var _errorV = parseFloat($('#actualPackageWeight-edit').val())-parseFloat($('#estimatePackageWeight-edit').val())
			$('#errorValue-edit').val(_errorV.toFixed(3));
		}
	};
	if($('#editWeightModal #actualPackageNum-edit').hasClass('editing')){
		//用户修改实际包裹数量， 当实际包裹数量为0或空时，则自动讲其赋值为预报包裹数量
		if($('#editWeightModal #actualPackageNum-edit').val() == 0 ||$('#editWeightModal #actualPackageNum-edit').val() == ''){
			$('#editWeightModal #actualPackageNum-edit').val($('#estimatePackageNum-edit').val())
		}
	}else{
		//用户没修改实际包裹数量， 当实际包裹数量为0时，则自动讲其赋值为预报包裹数量
		if($('#editWeightModal #actualPackageNum-edit').val() == 0){
			$('#editWeightModal #actualPackageNum-edit').val($('#estimatePackageNum-edit').val())
		}
	}
	if(!/^\d+(\.\d+)?$/.test($('#actualPackageWeight-edit').val()) || !/^[1-9]\d*$/.test($('#actualPackageNum-edit').val())){
		modalAlert('<spring:message code="l_js_input_weight_remind"/>');
		return false;
	}
	$('#editWeightModal').modal('hide');
	updataGridRow($(this).attr('data-rowid'));
	addUpdate();
	
});

/*提交当前表格内容*/
function updataNowPageData(isFinish){
	$('#table-pending-weight').attr('isFinish', isFinish);
	var _data = null;
	var arr = $('#table-pending-weight').getRowData(),_num = 0;
	_data = {
			postofficeEnName:$('#postofficeEnName_edit').val(),
			dispatchNo:$('#weightModalDispatchNo').val(),
			packageJsonString:JSON.stringify(arr),
			actualBagNum:$('#weightModalActualPackageNum').val(),
			actualTotalWeight:$('#weightModalActualPackageWeight').val(),
			isFinish:isFinish
	};
	
	//保存
	if(isFinish == 0){
		ajaxEngine.postAjax('/post/inputWeigt.html', _data, inputWeight);
		return;
	}
	
	if(arr.length != $('#weightModalActualPackageNum').val()){
		//强制提交
		_num = arr.length - $('#weightModalActualPackageNum').val();
		$('#messageAlert .modal-body').html('<spring:message code="l_js_input_weight_submit_remind_1"/><span style="color: red;font-size: 20px;"> '+_num+' </span><spring:message code="l_js_input_weight_submit_remind_2"/>');
		$('#messageAlert').modal('show');
		$('#messageSubmit').unbind('click').bind('click',function(){
			ajaxEngine.postAjax('/post/inputWeigt.html', _data, inputWeight);
		});
	}else if(arr.length > 0){
		//完成提交
		$('#messageAlert .modal-body').html('<spring:message code="l_input_weight_submit_remind"/>');
		$('#messageAlert').modal('show');
		$('#messageSubmit').unbind('click').bind('click',function(){
			ajaxEngine.postAjax('/post/inputWeigt.html', _data, inputWeight);
		});
	} else {
		$("#weightModal").modal('hide');
	}	
}

var inputWeight = function(rslt){
	var isFinish = $('#table-pending-weight').attr('isFinish');
	$('#messageAlert').modal('hide');
	if(rslt.code == '1'){
		modalAlert('<spring:message code="l_js_school_success"/>');
		if(isFinish == 1){
			$('#weightModal').modal('hide');
		}
		update();
	}else{
		modalAlert(rslt.info);
	}
};

$('#actualPackageWeight-edit').bind('blur', function(e){
	var errorV = parseFloat($('#actualPackageWeight-edit').val())-parseFloat($('#estimatePackageWeight-edit').val())
	$('#errorValue-edit').val(errorV.toFixed(3));
}).bind('keyup',function(){
	$(this).addClass('editing');
});
$('#actualPackageNum-edit').bind('keyup',function(){
	$(this).addClass('editing');
});

//统计清单实际数据和重量
function addUpdate(){
	var _getGridData = $('#table-pending-weight').getRowData(),totalNum = 0,totalWeight = 0;
	$.each(_getGridData,function(t,v1){
		if(v1.actualPackageWeight != '0' && v1.actualPackageNum != '0'){
			totalNum += 1;
			totalWeight += parseFloat(v1.actualPackageWeight);
		};
	});
	$('#weightModalActualPackageNum').val(totalNum);
	$('#weightModalActualPackageWeight').val(totalWeight.toFixed(3));
	_getGridData = null
}

function reduceUpdate(){
	$('#weightModalActualPackageWeight').val(parseFloat($('#weightModalActualPackageWeight').val()) - parseFloat($('#actualPackageWeight-edit').val()));
	if($('#actualPackageWeight-edit').val() != '0' || $('#actualPackageNum-edit').val() != '0'){
		$('#weightModalActualPackageNum').val(parseFloat($('#weightModalActualPackageNum').val()) - parseFloat('1'));
	}
}

function afterCompleteFunction(_grid){
	//获取列表数据
	var rowDatas = $(_grid).jqGrid('getRowData'),cls = 'datagrid-info';
	for(i=0;i<rowDatas.length;i++){
		var rowData = rowDatas[i]; 
		var errorValue = parseFloat(rowData.errorValue),rowIds = $(_grid).getDataIDs();
		if(errorValue >= errorRange || errorValue <= errorRange*-1){
			$(_grid).setCell(rowIds[i],"errorValue","", "text-danger");
		}else{
			$(_grid).setCell(rowIds[i],"errorValue","", "text-success");
		}
	}
	if(rowDatas.length == 0){
		//modalAlert('<spring:message code="l_js_no_package_remind"/>');
	}
}

function update(){
	$('#table-pending').jqGrid('setGridParam', {
	 	url:  '/post/list/pending.html?isPaging='+1,
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}

//重置表单
function resetForm(){
	$('#pendingTaskList')[0].reset();
	$("#jgOrgId").trigger("chosen:updated");
}

$('#packageNo').keydown(function(e){
	if(e.which == 13){
		queryPackage();
	}
})

//查找邮袋
function queryPackage(){
	var dispatchNo = $('#weightModalDispatchNo').val();
	var packageNo = $('#packageNo').val();
	var data = $('#table-pending-weight').jqGrid("getRowData");
	$('#table-pending-weight').jqGrid("resetSelection");
	for(var i = 0; i < data.length; i++){
		if(packageNo == data[i].packageNo){
			$($('#table-pending-weight tbody tr')[i + 1]).trigger('dblclick');
			scrollToTarget(i + 1);
			return;
		}
	}
	modalAlert('<spring:message code="l_js_no_package_remind"/>');
	isSearch = true;
}
//表格焦点定位 for scroll
function scrollToTarget(i){
	$('#table-pending-weight').parents('.ui-jqgrid-bdiv').scrollTop($('#table-pending-weight tr.ui-widget-content').height()*i-$('#table-pending-weight').parents('.ui-jqgrid-bdiv').height())
	
}
</script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="doingListPage">
	<div class="page-header">
		<h5>
<!-- 		搜索处理中任务 --><spring:message code="l_search_for_all_tasks"/>
		</h5>
	</div>
	<div class="page-content">
		<form action="" id="doingTaskList">
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
							<input type="text" class="form-control" placeholder="<spring:message code="l_batch_number2"/>" name="dispatchNo" id="dispatchNo">
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
							<button type="button" id="doing-search" onclick="" class="btn btn-primary btn-sm">
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
<!-- 					处理中任务 --><spring:message code="l_all_tasks"/>
				</h5>
				<div class="widget-toolbar no-border hidden">
					<button class="btn btn-xs btn-success" id="finish"><i class="icon-ok"></i>
<!-- 					 结单 --><spring:message code="l_statement"/>
					 </button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="table-doing"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 邮袋列表 -->
<div class="modal fade" id="weightModal" tabindex="-1" role="dialog" >
  <div class="modal-dialog" style="width:100%;height:100%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         录入重量 --><spring:message code="l_detail_list_detail"/>
        </h4>
      </div>
      <div class="modal-body">
      	<form id="inputWeightForm">
	      	<div class="row hidden">
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
			<table class="table table-bordered" id="table_doing_detail"></table>
		</div>
      </div>
      <div class="modal-footer">
         <button type="button" class="btn btn-primary pull-left" id="doingExcelTarget" onclick="exportDoing()">
<!--          导出Excel --><spring:message code="l_export_excel"/>
         </button>
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         返回 --><spring:message code="l_back"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 录入CN35 -->
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
        <form id="input_cn_from">
        <input type="hidden" id="postofficeEnName_edit">
        	<div class="row">
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
							CN35：
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="text" class="form-control" id="cn35_edit" validate="notnull" placeholder="">
						    </div>
						</div>
					</div>
				</div>
        		<div class="col-md-12 hidden">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
							CN38：
						</label>
						<div class="col-md-9">
							<div class="input-group">
						      <input type="text" class="form-control" id="cn38_edit" placeholder="">
						    </div>
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

	formValidation.setFormObj($("#input_cn_from"));
	formValidation.init();
}
{
	var errorRange = '${errorRange}';
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
	
}

$('#id-date-picker-search-1').datepicker().bind('changeDate',function(ev){
	var startTime = $('#id-date-picker-search-1').val();
	$('#id-date-picker-search-2').datepicker('setStartDate',startTime);
	$('#id-date-picker-search-1').datepicker('hide')
});
$('#id-date-picker-search-2').datepicker().bind('changeDate',function(ev){
	var endTime = $('#id-date-picker-search-2').val();
	$('#id-date-picker-search-1').datepicker('setEndDate',endTime);
	$('#id-date-picker-search-2').datepicker('hide')
});
$('#customer-for-doing').chosen();
$('#table-doing').datagrid_ace({
	caption: "",
	url: '/post/list/query.html',
// 	colNames:['发货日期','预计到达时间','实际到达时间', '航运单号', '客户名称','批次号', '服务类型', '邮寄类型', '预报邮袋数量', '预报邮袋总重', '实际邮袋数量', '实际邮袋总重', '状态时间', '状态', '创建人', '邮局英文名称'],
	colNames:['<spring:message code="l_js_submit_time"/>',
	          '<spring:message code="l_js_send_date"/>','<spring:message code="l_js_estimated_time_of_arrival"/>',
	          '<spring:message code="l_js_actual_time_of_arrival"/>', '<spring:message code="l_js_shipping_ordercode"/>', 
	          '<spring:message code="l_js_customer_name"/>','<spring:message code="l_js_batch_number"/>', '<spring:message code="l_js_shipping_info"/>', 
	          '<spring:message code="l_js_service_type"/>', '<spring:message code="l_js_mail_type"/>', 
	          '<spring:message code="l_js_forecast_number_of_pouch"/>', '<spring:message code="l_js_forecast_total_weight_of_pouch"/>', 
	          '<spring:message code="l_js_actual_number_of_pouch"/>', '<spring:message code="l_js_actual_total_weight"/>', 
	          '<spring:message code="l_js_status_time"/>', '<spring:message code="l_js_status"/>', '状态',
	          '<spring:message code="l_js_creater"/>', '邮局英文名称', '账户编号', '航班号', '航运提单', '是否不完整'],
	height:380,
	multiselect:false,
	rownumbers:true,
	colModel:[
		{name:'submitDate',index:'submitDate', width:200},
		{name:'dispatchDate',index:'dispatchDate',width:100,hidden:true},
		{name:'estimateArrivceDate',index:'estimateArrivceDate',width:100,hidden:true},
		{name:'actualArrivceDate',index:'actualArrivceDate',width:100,hidden:true},
		{name:'airwayBillNo',index:'airwayBillNo',width:100,hidden:true},
		{name:'customerName',index:'customerName',width:150, hidden:true},
		{name:'dispatchNo',index:'dispatchNo',width:200},
		{name:'',index:'', width:200,formatter:function(cellvalue, options, rowObject){
			return rowObject.truckingNo+'/'+rowObject.airwayBillNo;
		}},
		{name:'serviceTypeMessage',index:'serviceTypeMessage',width:100},
		{name:'dispatchType',index:'dispatchType',width:100},
		{name:'estimateBagNum',index:'estimateBagNum',width:150,hidden:true,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 0);
		}},
		{name:'estimateTotalWeight',index:'estimateTotalWeight',width:150,hidden:true,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 3);
		}},
		{name:'actualBagNum',index:'actualBagNum',width:150,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 0);
		}},
		{name:'actualTotalWeight',index:'actualTotalWeight',width:150,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 3);
		}},
		{name:'statusTime',index:'statusTime',width:150,hidden:true},
		{name:'statusMessage',index:'statusMessage',width:150},
		{name:'status',index:'status',width:150,hidden:true},
		{name:'createPerson',index:'createPerson',width:200},
		{name:'postofficeEnName',index:'postofficeEnName',width:100,hidden:true},
		{name:'customerNo',index:'customerNo',width:100,hidden:true},
		{name:'truckingNo',index:'truckingNo',width:100,hidden:true},
		{name:'airwayBillNo',index:'airwayBillNo', width:100, hidden:true},
		{name:'isBroken',index:'isBroken', width:100, hidden:true}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		$('#weightModal').modal('show');
		setTimeout(function(){weightModalGrid(rowData)},400);
	},
	searchOption:{
		searchButton:'#doing-search',
		searchFormId:"#doingTaskList"
	},
	gridComplete:function(){
		setRowColor('#table-doing');
	}
});
function weightModalGrid(rowData){
	$('#postofficeEnName_edit').val(rowData.postofficeEnName);
	$('#weightModalCustomerName').val(rowData.customerName);
	$('#weightModalCustomerNo').val(rowData.customerNo);
	$('#weightModalDispatchNo').val(rowData.dispatchNo);
	$('#weightModalTruckingNo').val(rowData.truckingNo);
	$('#weightModalAirwayBillNo').val(rowData.airwayBillNo);
	$('#weightModalDispatchDate').val(rowData.dispatchDate);
	$('#weightModalEstimateBagNum').val(formatValue(rowData.estimateBagNum, 0));
	$('#weightModalEstimateTotalWeight').val(formatValue(rowData.estimateTotalWeight, 3));
	$('#weightModalActualPackageWeight').val(formatValue(rowData.actualTotalWeight, 3));
	$('#weightModalActualPackageNum').val(formatValue(rowData.actualBagNum, 0));
	$('#table_doing_detail').jqGrid('setGridParam', {
	 	url: '/post/package.html',
	    page : 1,
	    postData:{'dispatchNo':rowData.dispatchNo, 'postofficeEnName':rowData.postofficeEnName, from:4},
	    datatype:"JSON"
	}).trigger("reloadGrid");
	$('#table_doing_detail').jqGrid('setGridWidth',$('#table_doing_detail').parents('.gridContent').width())
}

$('#table_doing_detail').datagrid_ace({
	caption: "",
// 	colNames:['邮袋编号','CN35','包裹类型', '预报总包裹数', '实际包裹数','邮袋预报总重量', '邮袋实际总重量', '误差值', '备注', '邮局英文名称'],
	colNames:['<spring:message code="l_js_pouch_no"/>','<spring:message code="l_js_cn35"/>','CN38',
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
		{name:'cn35',index:'cn35',width:120},
		{name:'cn38',index:'cn38',width:120},
		{name:'dispatchType',index:'dispatchType', width:120},
		{name:'estimatePackageNum',index:'estimatePackageNum', width:120,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 0);
		}},
		{name:'actualPackageNum',index:'actualPackageNum', width:120,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 0);
		}},
		{name:'estimatePackageWeight',index:'estimatePackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 3);
		}},
		{name:'actualPackageWeight',index:'actualPackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
			return formatValue(cellvalue, 3);
		}},
		{name:'errorValue',index:'errorValue', width:120},
		{name:'remark',index:'remark'},
		{name:'postofficeEnName',index:'postofficeEnName', width:100, hidden:true}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		jqgClickRow(rowData, rowid);
		$('#table_doing_detail').jqGrid("setSelection",rowid);
	},
	gridComplete:function(){
		afterCompleteFunction('#table_doing_detail');
	}
});

//导出EXCEL
function exportDoing(){
	window.open('/post/exportExcel.html?dispatchNo='+$('#weightModalDispatchNo').val()+'&postofficeEnName='+$('#postofficeEnName_edit').val());
}

//设置误差值颜色
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
}


//改变行颜色
function setRowColor(_grid){
	//获取列表数据
	var rowDatas = $(_grid).jqGrid('getRowData'),cls = 'datagrid-info';
	for(i=0;i<rowDatas.length;i++){
		var rowData = rowDatas[i]; 
		if(rowData.status=='3'){
			cls= 'datagrid-info'
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

function formatValue(value, precision){
	var str = '';
	if(value != null && value != ''){
		str = parseFloat(value).toFixed(precision);
	}
	return str;
}
</script>

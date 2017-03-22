<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="doingListPage">
	<div class="page-header">
		<h5>
<!-- 		结单费用 --><spring:message code="l_search_statement_fee"/>
		</h5>
	</div>
	<div class="page-content">
		<form action="" id="finishTaskList">
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
							<button type="button" id="finish-search" onclick="" class="btn btn-primary btn-sm">
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
<!-- 		结单费用 --><spring:message code="l_statement_fee"/>
				</h5>
				<div class="widget-toolbar no-border">
<!-- 					<button class="btn btn-xs btn-success" id="finish"><i class="icon-ok"></i> -->
<%-- <!-- 					 结单 --><spring:message code="l_statement"/> --%>
<!-- 					 </button> -->
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="table_finish"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 邮袋列表-->
<div class="modal fade" id="weightModal" tabindex="-1" role="dialog" >
  <div class="modal-dialog" style="width:100%;height:100%;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         录入重量 --><spring:message code="l_detail_list"/>
        </h4>
      </div>
      <div class="modal-body">
      	<div id="weightModalMain"></div>
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

<!-- 录入CN38 -->
<div class="modal fade" id="input_cn38_modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         编辑 --><spring:message code="l_input_the_cn38"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="input_cn_from">
        <input type="hidden" id="postofficeEnName_edit">
        	<div class="row">
				<div class="col-md-12 hidden">
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
        		<div class="col-md-12">
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
        <button type="button" class="btn btn-primary" id="submit_cn38_button" onclick="submitCN38()">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>


<!-- 录入国家CN38 -->
<div class="modal fade" id="input_country_cn38_modal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">
					<!--         编辑 -->
					<spring:message code="l_input_the_cn38" />
				</h4>
			</div>
			<div class="modal-body">
				<form id="input_country_cn38_from">
					<div class="row">
						<div class="col-md-12 country_cn38">
							
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<!--         取消 -->
					<spring:message code="l_cancel" />
				</button>
		        <button type="button" class="btn btn-primary" onclick="submitCN38Batch()">
		<!--         确定 --><spring:message code="l_ok"/>
		        </button>
			</div>
		</div>
	</div>
</div>

<!-- 录入国家CN38模板 -->
<div id="input_country_input" class="col-md-12 hidden">
	<div class="form-group clearfix">
		<label class="col-md-3 control-label no-padding-right"></label>
		<div class="col-md-9">
			<div class="input-group">
				<input type="text" class="form-control" name="country_cn38" placeholder="">
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
{
	var isInputCN38 = 0;
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
$('#table_finish').datagrid_ace({
	caption: "",
	url: '/post/list/finish.html?from=1',
// 	colNames:['结单时间','客户名称','批次号', '服务类型', '邮寄类型', '实际邮包数量(pcs)', '实际总重量(kg)', '费用($)', '操作', '邮局英文名称'],
	colNames:['<spring:message code="l_js_statement_of_time"/>','<spring:message code="l_js_customer_name"/>',
	          '<spring:message code="l_js_batch_number"/>', '<spring:message code="l_js_shipping_info"/>', '<spring:message code="l_js_service_type"/>', 
	          '<spring:message code="l_js_mail_type"/>', '<spring:message code="l_js_actual_number_of_pouch"/>', 
	          '<spring:message code="l_js_actual_total_weight"/>', '<spring:message code="l_js_status"/>', '邮局英文名称', '账户编号', '航班号', '航运提单', '发货日期', '预报总邮袋数', '预报总重量', '航班号', '是否可以录入'],
	height:380,
	multiselect:false,
	rownumbers:true,
	colModel:[
		{name:'statusTime',index:'statusTime',width:200},
		{name:'customerName',index:'customerName',width:150,hidden:true},
		{name:'dispatchNo',index:'dispatchNo',width:200},
		{name:'',index:'', width:200,formatter:function(cellvalue, options, rowObject){
			return rowObject.truckingNo+'/'+rowObject.airwayBillNo;
		}},
		{name:'serviceTypeMessage',index:'serviceTypeMessage',width:100},
		{name:'dispatchType',index:'dispatchType',width:100},
		{name:'actualBagNum',index:'actualBagNum',width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(0);
		}},
		{name:'actualTotalWeight',index:'actualTotalWeight',width:150,formatter:function(cellvalue, options, rowObject){
			return parseFloat(cellvalue).toFixed(3);
		}},
		{name:'statusMessage',index:'statusMessage',width:150},
		{name:'postofficeEnName',index:'postofficeEnName',width:100,hidden:true},
		{name:'customerNo',index:'customerNo',width:100,hidden:true},
		{name:'truckingNo',index:'truckingNo',width:100,hidden:true},
		{name:'dispatchDate',index:'dispatchDate',width:100,hidden:true},
		{name:'estimateBagNum',index:'estimateBagNum',width:100,hidden:true},
		{name:'estimateTotalWeight',index:'estimateTotalWeight',width:100,hidden:true},
		{name:'truckingNo',index:'truckingNo',width:100,hidden:true},
		{name:'airwayBillNo',index:'airwayBillNo', width:100, hidden:true},
		{name:'isInput',index:'isInput', width:100, hidden:true}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		$('#weightModal').modal('show');
		$('#weightModalMain').load('/post/finishDetail.html',function(){
			setTimeout(function(){weightModalGrid(rowData)},400);
		});
	},
	searchOption:{
		searchButton:'#finish-search',
		searchFormId:"#finishTaskList"
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
	$('#weightModalEstimateBagNum').val(parseFloat(rowData.estimateBagNum).toFixed(0));
	$('#weightModalEstimateTotalWeight').val(parseFloat(rowData.estimateTotalWeight).toFixed(3));
	$('#weightModalActualPackageWeight').val(parseFloat(rowData.actualTotalWeight).toFixed(3));
	$('#weightModalActualPackageNum').val(parseFloat(rowData.actualBagNum).toFixed(0));
	$('#table_finish_detail').jqGrid('setGridParam', {
	 	url: '/post/package.html',
	    page : 1,
	    postData:{'dispatchNo':rowData.dispatchNo, 'postofficeEnName':rowData.postofficeEnName,from:3},
	    datatype:"JSON"
	}).trigger("reloadGrid");
	$('#table_finish_detail').jqGrid('setGridWidth',$('#table_finish_detail').parents('.gridContent').width());
	if (rowData.isInput == 1) {
		isInputCN38 = 1;
	}else{
		isInputCN38 = 0;
		$('#inputCN38Button').addClass('hidden');
	}
}

//更新详情表
function updateDetail(){
	$('#table_finish_detail').jqGrid('setGridParam', {
	 	url:  '/post/package.html',
	    page : 1,
	    postData:{'dispatchNo':$('#weightModalDispatchNo').val(), 'postofficeEnName':$('#postofficeEnName_edit').val()},
	    datatype:"JSON"
	}).trigger("reloadGrid");
	updateMain();
}

//更新主表
function updateMain(){
	$('#table_finish').jqGrid('setGridParam', {
	 	url:  '/post/list/finish.html?from=1',
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}

//导出EXCEL
function exportDoing(){
	 window.open('/post/exportExcel.html?dispatchNo='+$('#weightModalDispatchNo').val()+'&postofficeEnName='+$('#postofficeEnName_edit').val());
}
</script>

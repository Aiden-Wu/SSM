<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid" id="logPage">
	<div class="page-content">
		<form action="" id="logList">
			<div class="row">
				<div class="col-sm-12">
					<div class="widget-box transparent">
						<div class="widget-body">
							<div class="widget-main ">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
<!-- 											日志类型： --><spring:message code="l_log_type"></spring:message>
											</label>
											<div class="col-md-8">
												<select class="form-control" name="type" id="logSelect">
													<option value="" selected="selected">所有</option>
													<option value="1">操作日志</option>
													<option value="2">登录日志</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
<!-- 											起始时间： --><spring:message code="l_start_time"></spring:message>
											</label>
											<div class="col-md-8">
												<div class="input-group">
													<input class="form-control" type="text" name="beginTime" id="beginAddTime-forLog" />
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
<!-- 											截至时间： --><spring:message code="l_end_time"></spring:message>
											</label>
											<div class="col-md-8">
												<div class="input-group">
													<input class="form-control" type="text" name="endTime" id="endAddTime-forLog" />
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
<!-- 											操作人名称： --><spring:message code="l_operator_name"></spring:message>
											</label>
											<div class="col-md-8">
												<input type="text" class="form-control" placeholder="" name="operatorName" id="">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
<!-- 											ip地址： --><spring:message code="l_ip_address_form"></spring:message>
											</label>
											<div class="col-md-8">
												<input type="text" class="form-control" placeholder="" name="ip" id="">
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group clearfix wizard-actions">
											<button type="reset" class="btn btn-default btn-sm">
					<!-- 						重置 --><spring:message code="l_reset"></spring:message>
											</button>
											<button type="button" id="selectBtn" onclick="" class="btn btn-primary btn-sm">
					<!-- 						查询 --><spring:message code="l_query"/>
											</button>
										</div>
									</div>
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
<!-- 					日志列表 --><spring:message code="l_log_list"></spring:message>
				</h5>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="table-log"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
{
	var nowDate = new Date().toLocaleDateString("EN");
	$('#endAddTime-forLog').datepicker('setEndDate',nowDate);
	$('#beginAddTime-forLog').datepicker('setEndDate',nowDate);
}
$('#beginAddTime-forLog').datepicker().bind('changeDate',function(ev){
	var startTime = $('#beginAddTime-forLog').val();
	$('#endAddTime-forLog').datepicker('setStartDate',startTime);
	$('#beginAddTime-forLog').datepicker('hide')
});
$('#endAddTime-forLog').datepicker().bind('changeDate',function(ev){
	var endTime = $('#endAddTime-forLog').val();
	$('#beginAddTime-forLog').datepicker('setEndDate',endTime);
	$('#endAddTime-forLog').datepicker('hide')
});;
$('#logList select').chosen();
$('#table-log').datagrid_ace({
	caption:'',
	url: '/log/logList.html',
// 	colNames:['ID', '日期','操作人','IP', '操作', '描述'],
	colNames:['<spring:message code="l_js_id"/>', '<spring:message code="l_js_date"/>',
	          '<spring:message code="l_js_operator"/>','<spring:message code="l_js_ip"/>', 
	          '<spring:message code="l_js_operation"/>', '<spring:message code="l_js_description"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	colModel:[
		{name:'id',index:'id',width:200,hidden:true },
		{name:'time',index:'time',width:200},
		{name:'operatorName',index:'operatorName',width:200},
		{name:'ip',index:'ip',width:300},
		{name:'operatorType',index:'operatorType',width:200},
		{name:'description',index:'description',width:400}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		
	},
	searchOption:{
		searchButton:'#selectBtn',
		searchFormId:"#logList"
	}
});
//重置表单
function resetForm(){
	$('#logList')[0].reset();
	$("#logSelect").trigger("chosen:updated");
}
</script>
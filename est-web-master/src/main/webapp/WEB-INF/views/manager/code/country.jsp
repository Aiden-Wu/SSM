<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="doingListPage">
	<div class="page-header">
		<h5>
<!-- 		国家二字代码 --><spring:message code="l_js_country_code"/>
		</h5>
	</div>
	<div class="page-content">		
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
<!-- 					国家二字代码 --><spring:message code="l_js_country_code"/>
				</h5>
				<div class="widget-toolbar no-border">
					<button class="btn btn-xs btn-success" id="newTarget"><i class="icon-ok"></i> 
<!-- 					新增 --><spring:message code="l_add"/>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="country_code"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 编辑国家信息 -->
<div class="modal fade" id="editCountryModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="countryModalTitle">
<!--         编辑 --><spring:message code="l_edit"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editCountryForm">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							国家二字代码： --><spring:message code="l_country_code_form"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control hidden" id="codeId" name="id" placeholder="">
							<input type="text" class="form-control" id="codeCode" name="code" placeholder=""  validate="notnull" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							中文名称： --><spring:message code="l_chinese_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="codeZhName" name="zhName" validate="notnull" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							英文名称： --><spring:message code="l_english_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="codeEnName" name="enName" validate="notnull" placeholder="">
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
        <button type="button" class="btn btn-primary" id="countrySubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 删除国家信息 -->
<div class="modal fade" id="deleteCountryAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         删除 --><spring:message code="l_delete"/>
        </h4>
      </div>
      <div class="modal-body">
<!--        	 确定要删除这条信息吗？ --><spring:message code="l_delete_remind"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="countryDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
	formValidation.setFormObj($("#editCountryForm"));
	formValidation.init();
});

$('#country_code').datagrid_ace({
	caption: "",
	url: '/country/countryList.html',
// 	colNames:['国家ID','国家代码','中文名称', '英文名称','操作'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_country_code"/>',
	          '<spring:message code="l_js_chinese_name"/>', '<spring:message code="l_js_english_name"/>',
	          '<spring:message code="l_js_operation"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	colModel:[
		{name:'id',index:'id',width:100,hidden:true},
		{name:'code',index:'code',width:100},
		{name:'zhName',index:'zhName',width:200},
		{name:'enName',index:'enName',width:200},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialModalFnc('+rowObject.id+')"><i class="icon-eye-open bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-info" onclick="updateModalFnc('+rowObject.id+')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deleteModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
				return temp;
		}}
	]
});
//新增
$('#newTarget').bind('click',function(){
	destroyValidTooltip();
	$('#editCountryForm')[0].reset();
	$('#editCountryModal').modal('show');
	$('#countryModalTitle').text('<spring:message code="l_add"/>');
	$('#codeCode').attr('readonly',false);
	$('#codeZhName').attr('readonly',false);
	$('#codeEnName').attr('readonly',false);
	$('#countrySubmit').show();
	$('#countrySubmit').unbind('click').bind('click',function(){
		if(formValidation.check()){
			$.ajax({
				url:'/country/countryAdd.html',
				type: 'POST',
				data: $('#editCountryForm').serializeJson(),
				success:function(data){
					$('#editCountryModal').modal('hide');
					if(data.code == 1){
						update();
					}else{
						modalAlert(data.info);
					}
				}
			});
		}
	})
})
//查看
function detialModalFnc(id){
	var rowData = $('#country_code').getRowData(id);
	$('#editCountryModal').modal('show');
	$('#codeCode').val(rowData.code).attr('readonly',true);
	$('#codeZhName').val(rowData.zhName).attr('readonly',true);
	$('#codeEnName').val(rowData.enName).attr('readonly',true);
	$('#countrySubmit').unbind('click').hide();
	$('#countryModalTitle').text('<spring:message code="l_js_view"/>');
}
//编辑
function updateModalFnc(id){
	destroyValidTooltip();
	var rowData = $('#country_code').getRowData(id);
	$('#editCountryModal').modal('show');
	$('#codeId').val(rowData.id);
	$('#codeCode').val(rowData.code).attr('readonly',true);
	$('#codeZhName').val(rowData.zhName).attr('readonly',false);
	$('#codeEnName').val(rowData.enName).attr('readonly',false);
	$('#countryModalTitle').text('<spring:message code="l_edit"/>');
	$('#countrySubmit').show();
	$('#countrySubmit').unbind('click').bind('click',function(){
		if(formValidation.check()){
			$.ajax({
				url:'/country/countryUpdate.html',
				type: 'POST',
				data: $('#editCountryForm').serializeJson(),
				success:function(data){
					$('#editCountryModal').modal('hide');
					if(data.code == 1){
						update();
					}else{
						modalAlert(data.info);
					}
				}
			});
		}
	})
}
//删除
function deleteModalFnc(id){
	var rowData = $('#country_code').getRowData(id);
	$('#deleteCountryAlert').modal('show');
	$('#countryDeleteSubmit').unbind('click').bind('click',function(){
		$.ajax({
			url:'/country/countryDelete.html',
			type: 'POST',
			data: rowData,
			success:function(data){
				$('#deleteCountryAlert').modal('hide');
				update();
			}
		});
	})
}

function update(){
	$('#country_code').jqGrid('setGridParam', {
	 	url: '/country/countryList.html',
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}
</script>
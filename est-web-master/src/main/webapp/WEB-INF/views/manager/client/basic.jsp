<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="clientListPage">
	<div class="page-content">
		<form action="" id="clientList" >
			<div class="row">
				<div class="col-sm-12">
					<div class="widget-box transparent">
						<div class="widget-body">
							<div class="widget-main ">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group clearfix">
											<label class="col-md-4 control-label no-padding-right">
												<!-- 机构名称： -->
												<spring:message code="l_cus_organization_name"></spring:message>
											</label>
											<div class="col-md-8">
												<input type="text" class="form-control" placeholder="" name="name" id="">
											</div>
										</div>
									</div>
								</div>
								<div class="row-fluid wizard-actions">
									<button type="reset" class="btn btn-default btn-sm">
										<!-- 重置 -->
										<spring:message code="l_cus_reset"></spring:message>
									</button>
									<button type="button" onclick="" id="selectBtn" class="btn btn-primary btn-sm">
										<!-- 查询 -->
										<spring:message code="l_cus_select"></spring:message>
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
					<!-- 客户信息列表 -->
					<spring:message code="l_cus_info_list"></spring:message>
				</h5>
				<div class="widget-toolbar no-border">
					<button class="btn btn-xs btn-info" id="newClientBasicTarget"><i class="icon-legal"></i> 
					<!-- 新建 -->
					<spring:message code="l_cus_register_postOffice"></spring:message>
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

<div class="modal fade" id="editModal" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="width:800px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="modalTitle">
				<!-- 编辑 -->
				<spring:message code="l_cus_edit"/>
				</h4>
			</div>
			<div class="modal-body">
				<form id="editClientBasicForm">
					<input type="hidden" id="clientId" name="clientId">
					<input type="hidden" id="id" name="id">
					<h4 class="modal-title">
						<!-- 客户基本信息 -->
						<spring:message code="l_cus_customer_basic_info"></spring:message>
					</h4>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 名称： -->
									<spring:message code="l_cus_name"></spring:message>
								</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="name" name="name" validate="notnull" placeholder="">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 机构编号： -->
									<spring:message code="l_cus_organization_no"></spring:message>
								</label>
								<div class="col-md-9">
									<%-- <select class="form-control" id="no" name="no">
										<c:forEach var="item" items="${orgListPoList}">
											<option value="${item.id }">${item.name}</option>
										</c:forEach>	
									</select> --%>
									<input type="text" class="form-control" id="" name="" value="${orgListPo.no}" readonly="readonly" />
								</div>
							</div>
						</div>
					</div>	
					<div class="row">
						<div class="col-md-6">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 地点： -->
									<spring:message code="l_cus_address"></spring:message>
								</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="address" name="address" placeholder="" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 联系电话： -->
									<spring:message code="l_cus_phone"></spring:message>
								</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<button type="button" class="btn btn-primary pull-right" id="tableClientUserSubmit">
							<!-- 确定 -->
							<spring:message code="l_cus_ensure"></spring:message>
							</button>
						</div>
					</div>
				</form>
				<div class=""></div>
				<div class="widget-box">
					<div class="widget-header header-color-blue">
						<h5 class="bigger lighter">
							<!-- 邮局注册信息 -->
							<spring:message code="l_cus_postOffice_register_info"></spring:message>
						</h5>
						<div class="widget-toolbar no-border">
							<button class="btn btn-xs btn-info" onclick="" id="creatPostoffice"><i class="icon-legal"></i> 
							<!-- 新建 -->
							<spring:message code="l_cus_new_add"></spring:message>
							</button>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main no-padding">
							<div class="gridContent">
								<table class="table table-bordered" id="table-client-basic"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
				<!-- 取消 -->
				<spring:message code="l_cus_cancel"></spring:message>
				</button>
				<button type="button" class="btn btn-primary" id="tableClientBasicSubmit">
				<!-- 确定 -->
				<spring:message code="l_cus_ensure"></spring:message>
				</button>
			</div>
		</div>
	</div>
</div>
<!-- 删除邮局信息 -->
<div class="modal fade" id="deleteClientBasicAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
        	<!-- 删除 -->
        	<spring:message code="l_cus_delete"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
       	<!--  确定要删除这条信息吗？ -->
       	<spring:message code="l_cus_ensure_delete_this_info"></spring:message>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
        	<!-- 取消 -->
        	<spring:message code="l_cus_cancel"></spring:message>
        </button>
        <button type="button" class="btn btn-primary" id="detialClientBasicDeleteSubmit">
        	<!-- 确定 -->
        	<spring:message code="l_cus_ensure"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 新增邮局 -->
<div class="modal fade" id="editForPostModal" tabindex="-1" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="">
				<!-- 邮局注册信息 -->
				<spring:message code="l_cus_postOffice_register_info"></spring:message>
				</h4>
			</div>
			<div class="modal-body">
				<form id="editClientBasicPostOfficeForm">
					<input type="hidden" id="clientId_newPost" name="clientId">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 注册邮局： -->
									<spring:message code="l_cus_register_postOffice"></spring:message>
									
								</label>
								<div class="col-md-9">
									<select class="form-control" name="postId" id="postId">
										<c:forEach var="item" items="${orgPoList}">
											<option value="${item.id }">${item.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 账户编号： -->
									<spring:message code="l_cus_account_no"></spring:message>
								</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="accountNo" name="accountNo" value="" validate="notnull"/>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group clearfix">
								<label class="col-md-3 control-label no-padding-right">
									<!-- 许可邮件号： -->
									<spring:message code="l_cus_ppi_no"></spring:message>
								</label>
								<div class="col-md-9">
									<input type="text" class="form-control" id="ppiNo" name="ppiNo" value="" validate="notnull"/>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
				<!-- 取消 -->
				<spring:message code="l_cus_cancel"></spring:message>
				</button>
				<button type="button" class="btn btn-primary" id="tableClientBasicForPostSubmit">
				<!-- 确定 -->
				<spring:message code="l_cus_ensure"></spring:message>
				</button>
			</div>
		</div>
	</div>
</div>
<script>
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

var delPc = function(id){
	$('#deleteClientBasicAlert').modal('show');
	$('#detialClientBasicDeleteSubmit').unbind('click').bind('click',function(){
		$('#deleteClientBasicAlert').modal('hide');
		//填写删除
		ajaxEngine.postAjax('/org/deletePostClientById.html', {id:id}, function(rstl){
			if(rstl.code == "1"){
				 $('#table-client-basic').trigger("reloadGrid");
			}else{
				modalAlert('<spring:message code="l_cus_delete_fail"/>');
			}
		});
	})
};

//isPaging
$('#table-client').datagrid_ace({
	caption:'',
	url: '/clientInfo/clientList.html',
	colNames:['id','<spring:message code="l_cus_org_name"/>',
	          '<spring:message code="l_cus_org_no"/>','<spring:message code="l_cus_addr"/>',
	          '<spring:message code="l_cus_telephone"/>','<spring:message code="l_cus_org_type"/>', 
	          '<spring:message code="l_cus_operate"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
 	multiselect:false,
	postData:{isPaging:1},
	colModel:[
   		{name:'id',index:'id',width:100,hidden:true},
   		{name:'name',index:'name',width:100},
   		{name:'no',index:'no',width:100},
   		{name:'address',index:'address',width:200},
   		{name:'phoneNum',index:'phoneNum',width:200},
		{name:'type',index:'type', width:150,formatter:function(cellvalue){
			var _name = null;
			if(cellvalue == 1){
				_name = "客户"
			}else{
				_name = "邮局"
			};
			return _name
		}},
		{name:'editor',index:'editor',width:200,formatter:function(cellvalue, options, rowObject){
			var userType = ${userType};
			var temp;
			temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialClientBasicModalFnc('+rowObject.id+')"><i class="icon-eye-open bigger-120"></i></button>';
			temp += '<button class="btn btn-xs btn-info" onclick="updateClientBasicModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
			
			return temp;
		}}
	],
	ondblClickRow:function(rowid,iRow,iCol,e,rowData){
		
	},
	searchOption:{
		searchButton:'#selectBtn',
		searchFormId:"#clientList"
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
	if(!_v){
		modalAlert('<spring:message code="l_pre_please_select_operate_data"/>')
	}else{
		$.ajax({
			url: '/path/to/file',
			type: 'POST',
			data: JSON.stringify(_v)
		})
		.done(function(data) {
			console.log("success");
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});
	}
});

//邮局注册信息列表
function initPostOfficeGrid(){
	$('#table-client-basic').datagrid_ace({
		caption:'',
		url: '/org/getPostOfficeByClientId.html',
// 		postData:{id:-1},
		colNames:['id','<spring:message code="l_cus_postoffice_no"/>',
		          '<spring:message code="l_cus_postoffice_name"/>','<spring:message code="l_cus_account_no"/>',
		          '<spring:message code="l_cus_ppi"/>','<spring:message code="l_cus_operate"/>'],
		height:250,
		autoScroll:true,
		altRows:false,
		shrinkToFit:true,
		multiselect:false,
		colModel:[
			{name:'id',index:'id', width:50},
			{name:'no',index:'no', width:100},
			{name:'postName',index:'postName', width:150},
			{name:'accountNo',index:'accountNo',width:200},
			{name:'ppiNo',index:'ppiNo', width:150},
			{name:'editor',index:'editor',width:100,formatter:function(cellvalue, options, rowObject){
				var temp = '<button class="_pc btn btn-xs btn-danger" onclick="delPc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
					return temp;
				}
			}
		]
	});
}
initPostOfficeGrid();
var curOperateId;
//新增
$('#newClientBasicTarget').bind('click',function(){
	destroyValidTooltip();
	$('#editClientBasicForm').hide();
	curOperateId = $('#table-client').jqGrid('getGridParam','selrow');
	//获取选择行id
	if(!curOperateId){
		modalAlert('<spring:message code="l_cus_please_select_org"/>');
		return;
	}
	
	
	$('#editModal').modal('show');
	$('#modalTitle').text('<spring:message code="l_add"/>');
	$('#table-client-basic').jqGrid('setGridParam', {datatype:'json', postData:{"id":curOperateId}}).trigger('reloadGrid');
	setTimeout(function(){
		$('#table-client-basic').jqGrid('setGridWidth',$('#table-client-basic').parents('.gridContent').width())
	},500);
	$('#editClientBasicForm input').attr('readonly',false);
	$('#creatPostoffice').show();
	$('#editClientBasicForm')[0].reset();
	
	//新增用户
	/* $('#tableClientUserSubmit').unbind('click').bind('click',function(){
		if(formValidation.check()){
			$.ajax({
				url:'/clientInfo/addClient.html',
				type: 'POST',
				data: $('#editClientBasicForm').serializeJson(),
				success:function(data){
					if(data.code == "1"){
						var clientId = data.data.id;
						$('#clientId_newPost').val(clientId);
						$('#table-client').trigger('reloadGrid');
					} else {
						modalAlert(data.info);
					}
				}
			})
		}
	}) */
	
})
//查看
function detialClientBasicModalFnc(id){
	$('#editModal').modal('show');
	$('#editModal button:not(.close)').hide();
	$('#modalTitle').text('<spring:message code="l_js_view"/>');
	curOperateId = id;
	var data = $('#table-client').jqGrid("getRowData", id);
	for(var o in data){
		var _obj = $("#editClientBasicForm").find("input[name='"+o+"']");
		if(_obj.length > 0){
			_obj.val(data[o]);
		}
	}
	$('#table-client-basic').jqGrid('setGridParam', {datatype:'json', postData:{"id":id}}).trigger('reloadGrid');
	$('#table-client-basic').hide();
	setTimeout(function(){
		$('#table-client-basic').show();
		$('#table-client-basic').jqGrid('setGridWidth',$('#table-client-basic').parents('.gridContent').width());
	},500);
	$('#editClientBasicForm input').attr('readonly',true);
	$('#tableClientBasicSubmit').unbind('click').bind('click',function(){
		$('#editModal').modal('hide');
	});
	$('#creatPostoffice').hide();
}
//编辑
var selectCustomerId;
function updateClientBasicModalFnc(id, rowId){
// 	$('#editModal input').attr('readonly');

	$('#editClientBasicForm').show();
	$('#modalTitle').text('<spring:message code="l_edit"/>');
	curOperateId = id;
	selectCustomerId = id;
	$('#table-client-basic').jqGrid('setGridParam', {datatype:'json', postData:{"id":id}}).trigger('reloadGrid');
	var data = $('#table-client').jqGrid("getRowData", rowId);
	for(var o in data){
		var _obj = $("#editClientBasicForm").find("input[name='"+o+"']");
		if(_obj.length > 0){
			_obj.val(data[o]);
		}
	}
	$('#clientId_newPost').val($('#id').val());
	$('#editModal').modal('show');
	$('#editModal button').show();
	setTimeout(function(){
		$('#table-client-basic').jqGrid('setGridWidth',$('#table-client-basic').parents('.gridContent').width())
	},500);
	
	$('#editClientBasicForm #name').attr('readonly',true);
	$('#editClientBasicForm #no').attr('readonly',true);
	$('#editClientBasicForm #address').attr('readonly',false);
	$('#editClientBasicForm #phoneNum').attr('readonly',false);
	
	$('#creatPostoffice').show();
	
	$('#tableClientUserSubmit').unbind('click').bind('click',function(){
		$('#editModal').modal('hide');
		//填写提交操作
		$.ajax({
		   type: "POST",
		   url: '/org/update.html',
		   data:$("#editClientBasicForm").serializeJson(),
		   dataType: "json",
		   success: function(rslt) {
			  if(rslt.code == "1"){
				  $('#table-client').trigger('reloadGrid');
			  }else{
				  modalAlert(rslt.info);
			  }
		   }
		});
		
		
	});
	
	
}

$('#tableClientBasicSubmit').unbind('click').bind('click',function(){
	$('#editModal').modal('hide');
});
//删除
// function deleteClientBasicModalFnc(id){
// 	curOperateId = id;
// 	$('#deleteClientBasicAlert').modal('show');
// 	$('#detialClientBasicDeleteSubmit').unbind('click').bind('click',function(){
// 		$('#deleteClientBasicAlert').modal('hide');
// 		//填写删除
// 		ajaxEngine.postAjax('/org/delete.html?', {id:id}, function(rslt) {
// 			  if(rslt.code == "1"){
// 				  $('#table-client').trigger("reloadGrid");
// 			  }else{
// 				  modalAlert('<spring:message code="l_cus_delete_fail"/>');
				  
// 			  }
// 		   })
// 	})
// }
//新增邮局
$('#creatPostoffice').bind('click',function(){
	selectCustomerId = selectCustomerId || curOperateId;
	if(!selectCustomerId){
		/* modalAlert('请先选择客户信息！') */
		modalAlert('<spring:message code="l_cus_please_select_customer_info"/>')
	}else{
// 		var clientId = getCheckRowsData('table-client',['id']).id[0];
		var clientId = selectCustomerId;
		
		destroyValidTooltip();
		$("#editClientBasicPostOfficeForm")[0].reset();
		$('#editForPostModal').modal('show');
		$('#tableClientBasicForPostSubmit').unbind('click').bind('click',function(){
			
			formValidation.setFormObj($("#editClientBasicPostOfficeForm"));
			formValidation.init();
			
			if(formValidation.check()){
				$.ajax({
					url:'/clientInfo/addPost.html',
					type: 'POST',
	// 				data: $('#editClientBasicPostOfficeForm').serializeJson(),
					data: {
						"clientId":clientId,
						"postId":$('#postId').val(),
						"postName":$('#postId').find("option:selected").text(),
						"ppiNo":$('#ppiNo').val(),
						"accountNo":$('#accountNo').val()
					},
					success:function(data){
						if(data.code == "1"){
							$("#editForPostModal").modal("hide");
							curOperateId = clientId;
							$('#table-client-basic').jqGrid('setGridParam', {datatype:'json', postData:{"id":curOperateId}}).trigger('reloadGrid');
						} else {
							$("#editForPostModal").modal("hide");
							modalAlert(data.info);
						}
					}
				})
			}
			
		})
	}
});

$(document).ready(function() {//init form valid
	formValidation.setFormObj($("#editClientBasicForm"));
	formValidation.init();
});

</script>

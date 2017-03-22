<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
<!-- 	人员管理 --><spring:message code="l_personnel_management"/>
	</h5>
</div>
<script src="${static_resource_url}/ace/assets/js/fuelux/data/fuelux.tree-sampledata.js"></script>
<script src="${static_resource_url}/ace/assets/js/fuelux/fuelux.tree.js"></script>
<style type="text/css">
	.tree .tree-h-selected{background-color:rgba(98,168,209,0.3);color:#6398b0;}
	.tree .tree-h-selected:hover{background-color:rgba(98,168,209,0.3);}
	.tree .tree-selected{background-color:rgba(98,168,209,0.3);color:#6398b0;}
	.tree .tree-selected:hover{background-color:rgba(98,168,209,0.3);}
	.tree-folder-header:hover {background-color:rgba(98,168,209,0.3);}
	.tree .tree-folder .tree-h-selected:hover{background-color:rgba(98,168,209,0.3);}
</style>
<div class="row">
	<div class="col-sm-3">
		<div class="widget-box">
			<div class="widget-header header-color-blue2">
				<h4 class="lighter smaller">
<!-- 				人员管理 --><spring:message code="l_personnel"/>
				</h4>
			</div>
		
			<div class="widget-body">
				<div class="widget-main padding-8">
					<div id="tree_user" class="ztree"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-sm-9">
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
					
				</h5>
				<div class="widget-toolbar no-border">
					<button class="btn btn-xs btn-success" id="newUserTarget"><i class="icon-ok"></i> 
<!-- 					新增 --><spring:message code="l_add"/>
					</button>
					<button class="btn btn-xs btn-info" id="modifyPassword"><i class="icon-knock"></i> 
<!-- 					重置密码 --><spring:message code="l_reset_password"/>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="user-table"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 编辑人员信息 -->
<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" style="width:780px; height:240px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="userModalTitle">
<!--         编辑 --><spring:message code="l_edit"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editUserForm">
        	<input name="id" value="" type="hidden"/>
        	<div class="row">
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							登陆账号： --><spring:message code="l_login_account"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="username" name="username" validate="notnull&len(6-20)" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							初始密码： --><spring:message code="l_initial_password"/>
						</label>
						<div class="col-md-9">
							<input type="text" readonly="readonly" value="123456" class="form-control" id="" name="password" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							所属机构： --><spring:message code="l_subsidiary_organization"/>
						</label>
						<div class="col-md-9">
							<select class="form-control" name="jgId" id="jgId" disabled="disabled">
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							上级部门： --><spring:message code="l_superior_department"/>
						</label>
						<div class="col-md-9">
							<select class="form-control" name="orgId" id="orgId" disabled="disabled">
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							人员名称： --><spring:message code="l_personnel_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="" name="name" validate="notnull" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							人员类型： --><spring:message code="l_personnel_type"/>
						</label>
						<div class="col-md-9">
							<select class="form-control" name="title" id="ed_title" disabled="disabled">
								<option value="">请选择</option>
								<option value="老板">老板</option>
								<option value="经理">经理</option>
								<option value="财务">财务</option>
								<option value="文员">文员</option>
								<option value="业务员">业务员</option>
								<option value="司机">司机</option>
								<option value="仓库人员">仓库人员</option>
								<option value="客服">客服</option>
							</select>
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
        <button type="button" class="btn btn-primary" id="userSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 重置密码 -->
<div class="modal fade" id="editUserPasswordModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         重置密码 --><spring:message code="l_reset_password"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editPasswordForm">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							请输入新密码： --><spring:message code="l_new_password"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="resetPwd" name="resetPwd" validate="notnull&len(6-12)" placeholder="">
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
        <button type="button" class="btn btn-primary" id="userPasswordSubmit" onclick="resetpassword();">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 删除国家信息 -->
<div class="modal fade" id="deleteUserAlert" tabindex="-1" role="dialog">
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
        <button type="button" class="btn btn-primary" id="userDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
	formValidation.setFormObj($("#editUserForm"));
	formValidation.init();
	formValidation.setFormObj($("#editPasswordForm"));
	formValidation.init();
});
var curNode = {};
jQuery(function($){
	//初始化树
	var ztree1 = new loadZtree({
		container:'#tree_user',
		url:'/dataAuth/orgTree.html?clientFlag=0',
		data:{userId:1},
		_callback:function(event, treeId, treeNode){
			var _id=treeNode.id;
			event.preventDefault();
			curNode = treeNode;
			$('#user-table').jqGrid('setGridParam', {datatype:'json', postData:{"orgId":_id, "isPaging":1}}).trigger('reloadGrid');
			row = {};
		},
		_loadZTreeSuccessCallback:function(){
			setGirdWidth('#user-table')
		}
	});
});
var row={}; //表格选中行数据
$('#user-table').datagrid_ace({
	caption: "",
	url: '/user/query.html?isPaging='+1,
// 	colNames:['id','人员编号','姓名','登记账号','所属部门','所属机构','人员类型','操作'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_personnel_numbers"/>',
	          '<spring:message code="l_js_name"/>','<spring:message code="l_js_login_account"/>',
	          '<spring:message code="l_js_subsidiary_department"/>','<spring:message code="l_js_subsidiary_organization"/>',
	          '<spring:message code="l_js_personnel_type"/>','<spring:message code="l_js_operation"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	colModel:[
        {name:'id',index:'id',width:100,hidden:true},
		{name:'no',index:'no',width:100},
		{name:'name',index:'name',width:200},
		{name:'username',index:'username',width:100},
		{name:_departmentName,index:_departmentName,width:200},
		{name:_orgName,index:_orgName,width:200},
		{name:'title',index:'title',width:200},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialUserModalFnc('+rowObject.id+')"><i class="icon-eye-open bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-info" onclick="updateUserModalFnc('+rowObject.id+')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deleteUserModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
				return temp;
		}}
	],
	onSelectRow:function(id){
		// 获取选中行的数数据
		row=$('#user-table').jqGrid("getRowData", id);
	}
});
//新增
$('#newUserTarget').bind('click',function(){
	if(!curNode.level || curNode.level != 3){
		modalAlert('<spring:message code="l_js_add_personnel_remind"/>');
		return;
	}
	destroyValidTooltip();
	$('#editUserForm')[0].reset();
	$("#editUserModal input[name='username']").removeAttr("readOnly");
	
	$("#jgId").removeAttr("disabled").html("<option value=" + curNode.getParentNode().id + ">" + curNode.getParentNode().name + "</option>");
	$("#orgId").removeAttr("disabled").html("<option value=" + curNode.id + ">" + curNode.name + "</option>");
	
	$("#editUserModal input[name='name']").removeAttr("readOnly");
	$("#ed_title").removeAttr("disabled");
	$('#editUserModal').modal('show');
	$('#userModalTitle').text('<spring:message code="l_add"/>');
	$('#userSubmit').show();
	$('#userSubmit').unbind('click').bind('click',function(){
		var re = /^[a-z0-9A-Z_]{6,20}$/;
		var userName = $('#username').val();
		if(!re.test(userName)){
			modalAlert('<spring:message code="l_js_username_rule"/>');
			return false;
		}
		formValidation.setFormObj($("#editUserForm"));
		if(!formValidation.check()){
			return false;
		}
		$.ajax({
			url:'/user/add.html',
			type: 'POST',
			data: $('#editUserForm').serializeJson(),
			success:function(data){
				if(data.code == "1"){
					$('#editUserModal').modal('hide');
					update();
				} else {
					modalAlert(data.info);
				}
			}
		})
	})
});
var initUserData = function(rowData){
	$("#username").val(rowData.username);
	$("#jgId").html("<option>" + rowData.orgName + "</option>");
	$("#orgId").html("<option>" + rowData.departmentName + "</option>");
	$("#editUserModal input[name='name']").val(rowData.name);
	$("#ed_title").find("option[value='" + rowData.title + "']").attr("selected",true);
	$("#editUserModal input[name='password']").val("......");
	$("#editUserModal input[name='id']").val(rowData.id);
};
//查看
function detialUserModalFnc(id){
	var rowData = $('#user-table').getRowData(id);
	$('#editUserModal').modal('show');
	$('#userSubmit').unbind('click').hide();
	$('#userModalTitle').text('<spring:message code="l_js_view"/>');
	$("#editUserModal input[name='name']").attr("readOnly", "readOnly");
	$("#ed_title").attr("disabled", "disabled");
	initUserData(rowData);
};
//编辑
function updateUserModalFnc(id){
	destroyValidTooltip();
	var rowData = $('#user-table').getRowData(id);
	initUserData(rowData);
	$("#editUserModal input[name='name']").removeAttr("readOnly");
	$("#ed_title").removeAttr("disabled");
	$('#editUserModal').modal('show');
	$('#userModalTitle').text('<spring:message code="l_edit"/>');
	$('#userSubmit').show();
	$('#userSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editUserForm"));
		if(!formValidation.check()){
			return false;
		}
		$.ajax({
			url:'/user/update.html',
			type: 'POST',
			data: $('#editUserForm').serialize(),
			success:function(data){
				if(data.code == "1"){
					$('#editUserModal').modal('hide');
					$('#editUserModal #id').val("");
					update();
				} else {
					modalAlert(data.info);
				}
			}
		})
	})
}
//重置密码
$('#modifyPassword').bind('click',function(){
	if(!row.id){
		$("#editUserPasswordModal").modal('hide');
		modalAlert('<spring:message code="l_js_select_personnel_remind"/>');
		return;
	}
	destroyValidTooltip();
	$('#editUserPasswordModal').modal('show');
})
//删除
function deleteUserModalFnc(id){
	$('#deleteUserAlert').modal('show');
	$('#userDeleteSubmit').unbind('click').bind('click',function(){
		$.ajax({
			url:'/user/del.html',
			type: 'POST',
			data: {"id":id},
			success:function(data){
				$('#deleteUserAlert').modal('hide');
				update();
			}
		})
	})
}

function update(){
	$('#user-table').jqGrid('setGridParam', {
	 	url:  '/user/query.html?isPaging='+1,
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}

var resetpassword = function(){
	formValidation.setFormObj($("#editPasswordForm"));
	if(!formValidation.check()){
		return false;
	}
	var userId = row.id;
	var pwd = $("#resetPwd").val();
	ajaxEngine.postAjax("user/resetPassword.html", {id:userId,password:pwd}, function(rslt){
		if(rslt.code == "1"){
			$("#editUserPasswordModal").modal('hide');
			modalAlert('<spring:message code="l_js_reset_password_success"/>');
		} else {
			$("#editUserPasswordModal").modal('hide');
			modalAlert(rslt.info);
		}
	})
};
</script>
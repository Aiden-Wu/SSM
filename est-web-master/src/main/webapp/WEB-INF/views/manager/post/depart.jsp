<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="">
	<div class="page-header">
		<h5>
<!-- 		部门信息 --><spring:message code="l_department_information"></spring:message>
		</h5>
	</div>
	<div class="page-content">		
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
<!-- 					邮局部门信息列表 --><spring:message code="l_add_post_office_department_information_list"></spring:message>
				</h5>
				<div class="widget-toolbar no-border">
					<button class="btn btn-xs btn-success" id="newDepartTarget"><i class="icon-fighter-jet"></i> 
<!-- 					为选中的部门添加航线信息 --><spring:message code="l_add_route_information_for_the_selected_department"></spring:message>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="depart_table"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 编辑邮局信息 -->
<div class="modal fade" id="editPostofficeModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editPostofficeModalHeader">
<!--         编辑邮局部门信息 --><spring:message code="l_edit_the_post_office_department_information"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editPostofficeForm">
        	<input type="hidden" id="depart_id_edit" name="id">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门名称： --><spring:message code="l_department_name"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_name_edit" name="name" validate="notnull" placeholder="" >
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门编号： --><spring:message code="l_department_number"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_no_edit" name="no" validate="notnull" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门地址： --><spring:message code="l_department_address"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_address_edit" name="address" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							联系电话/邮箱： --><spring:message code="l_phone_email"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_phoneNum_edit" name="phoneNum" placeholder="">
						</div>
					</div>
				</div>
        	</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"></spring:message>
        </button>
        <button type="button" class="btn btn-primary" id="postofficeSubmit">
<!--         确定 --><spring:message code="l_ok"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 航线信息 -->
<div class="modal fade" id="departModal" tabindex="-1" role="dialog">
  <div class="modal-dialog" style="width:100%; height:100%">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="">
<!--         添加航线 --><spring:message code="l_add_routes"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
        <div class="page-content">		
			<div class="widget-box">
				<div class="widget-header header-color-blue">
					<h5 class="bigger lighter">
<!-- 						航线列表 --><spring:message code="l_course_list"></spring:message>
					</h5>
					<div class="widget-toolbar no-border">
						<button class="btn btn-xs btn-success" id="routeNewForDetial"><i class="icon-ok"></i> 
<!-- 						新增 --><spring:message code="l_add"></spring:message>
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main no-padding">
						<div class="gridContent">
							<table class="table table-bordered" id="departDetial_table"></table>
						</div>
					</div>
				</div>
			</div>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         返回 --><spring:message code="l_back"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 删除邮局信息 -->
<div class="modal fade" id="deletePostofficeAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         删除 --><spring:message code="l_delete"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
<!--        	 确定要删除这条信息吗？ --><spring:message code="l_delete_alert"></spring:message>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"></spring:message>
        </button>
        <button type="button" class="btn btn-primary" id="detialDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 编辑航线信息 -->
<div class="modal fade" id="editRouteModal" tabindex="1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="routeModalTitle">
<!--         航线信息 --><spring:message code="l_route_information"></spring:message>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editRouteForm">
        	<input type="hidden" id="depId" name="departmentID">
        	<input type="hidden" id="id" name="id">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							航线名称： --><spring:message code="l_route_name"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="name" name="name" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							航线ID： --><spring:message code="l_route_id"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="no" name="no" placeholder="" >
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							航线价格： --><spring:message code="l_route_price"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="price" name="price" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							航线起点： --><spring:message code="l_routes_starting_point"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="start" name="start" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							航线终点： --><spring:message code="l_route_the_end"></spring:message>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="end" name="end" placeholder="" validate="notnull">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							是否转运： --><spring:message code="l_whether_transshipment"></spring:message>
						</label>
						<div class="col-md-9">
							<select class="form-control" name="isTransport" id="isTransport">
								<option value="Y" selected="selected">
<!-- 								是 --><spring:message code="l_Y"></spring:message>
								</option>
								<option value="N">
<!-- 								否 --><spring:message code="l_N"></spring:message>
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							状态： --><spring:message code="l_status"></spring:message>
						</label>
						<div class="col-md-9">
							<select class="form-control" name="trunkStatus" id="trunkStatus">
								<option value="Y" selected="selected">
<!-- 								可用 --><spring:message code="l_Y"></spring:message>
								</option>
								<option value="N">
<!-- 								不可用 --><spring:message code="l_N"></spring:message>
								</option>
							</select>
						</div>
					</div>
				</div>
        	</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"></spring:message>
        </button>
        <button type="button" class="btn btn-primary" id="routeSubmit">
<!--         确定 --><spring:message code="l_ok"></spring:message>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
	formValidation.setFormObj($("#editPostofficeForm"));
	formValidation.init();
	formValidation.setFormObj($("#editRouteForm"));
	formValidation.init();
});
var postId = '${postId}';
var departTableUrl = '';
if(postId == '-1'){
	departTableUrl = '/org/depart/list.html';
}else{
	departTableUrl = '/org/depart/list.html?parentId='+postId;
}
$('#depart_table').datagrid_ace({
	caption: "",
	url: departTableUrl,
// 	colNames:['ID','部门名称','部门编号','机构类型','地址','联系电话/邮箱','操作'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_department_name"/>',
	          '<spring:message code="l_js_department_number"/>','<spring:message code="l_js_institutional_type"/>',
	          '<spring:message code="l_js_address"/>','<spring:message code="l_js_phone_email"/>',
	          '<spring:message code="l_js_operation"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	colModel:[
  		{name:'id',index:'id',width:100,hidden:true},
		{name:'name',index:'name',width:100},
		{name:'no',index:'no',width:100},
		{name:'',index:'',width:200,formatter:function(cellvalue, options, rowObject){
			return '<spring:message code="l_js_department"/>';
		}},
		{name:'address',index:'address',width:200,hidden:true},
		{name:'phoneNum',index:'phoneNum',width:200,hidden:true},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var userType = ${userType};
			var temp;
			if(userType == -1){
			    temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialPostofficeModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-eye-open bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-info" onclick="updatePostofficeModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deletePostofficeModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
			}else{
			    temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialPostofficeModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-eye-open bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-info" onclick="updatePostofficeModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
			}
			return temp;
			
		}}
	],
	onSelectRow:function(rowid,iRow,iCol,e,rowData){
		$('#depId').val(rowid)
	}
});
//查看
function detialPostofficeModalFnc(id, rowId){
	var depart = $("#depart_table").jqGrid("getRowData", rowId);
	setDepartEdit(depart);
	$('#editPostofficeModal button:not(.close)').hide();
	$('#editPostofficeModalHeader').text('<spring:message code="l_js_view"/>');
	$('#editPostofficeModal').modal('show');
	$('#editPostofficeForm input').attr('readonly',true);
	$('#postofficeSubmit').unbind('click').bind('click',function(){
		$('#editPostofficeModal').modal('hide');
	})
}
//设置部门信息
function setDepartEdit(depart){
	$('#depart_id_edit').val(depart.id);
	$('#depart_name_edit').val(depart.name);
	$('#depart_no_edit').val(depart.no);
	$('#depart_address_edit').val(depart.address);
	$('#depart_phoneNum_edit').val(depart.phoneNum);
}
//编辑
function updatePostofficeModalFnc(id, rowId){
	destroyValidTooltip();
	var depart = $("#depart_table").jqGrid("getRowData", rowId);
	setDepartEdit(depart);
	$('#editPostofficeModal button').show();
	$('#editPostofficeModalHeader').text('<spring:message code="l_edit"/>');
	$('#editPostofficeModal').modal('show');
	$('#editPostofficeForm input').attr('readonly',false);
	$('#depart_no_edit').attr('readonly',true);
	$('#depart_name_edit').attr('readonly',true);
	$('#postofficeSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editPostofficeForm"));
		if(!formValidation.check()){
			return false;
		}
		$('#editPostofficeModal').modal('hide');
		$.ajax({
		   type: "POST",
		   url: '/org/update.html',
		   data:$("#editPostofficeForm").serializeJson(),
		   dataType: "json",
		   success: function(rslt) {
			  if(rslt.code == "1"){
				  modalAlert('<spring:message code="l_js_update_success"/>');
				  update();
			  }else{
				  modalAlert('<spring:message code="l_js_update_failure"/>');
			  }
		   }
		});
	})
}
//删除
function deletePostofficeModalFnc(id){
	$('#deletePostofficeAlert').modal('show');
	$('#detialDeleteSubmit').unbind('click').bind('click',function(){
		$('#deletePostofficeAlert').modal('hide');
		$.ajax({
		   type: "POST",
		   url: '/org/delete.html',
		   data:{'id':id},
		   dataType: "json",
		   success: function(rslt) {
			  if(rslt.code == "1"){
				  modalAlert('<spring:message code="l_js_delete_success"/>');
				  update();
			  }else{
				  modalAlert('<spring:message code="l_js_delete_failure"/>');
			  }
		   }
		});
	})
}

function update(){
	$('#depart_table').jqGrid('setGridParam', {
	 	url: departTableUrl,
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}
//航线列表
/* $('#departDetial_table').datagrid_ace({
	caption: "",
	url: '/estmanager/getTrunkingLine.html?departmentID='+$('#depart_table').jqGrid("getGridParam", "selrow"),
	colNames:['部门编号','部门名称','航线价格','航线ID','航线起点','航线终点','是否转运','状态','创建人','操作'],
	height:250,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	colModel:[
		{name:'id',index:'id',width:100},
		{name:'name',index:'id',width:100},
		{name:'price',index:'code',width:100},
		{name:'no',index:'zhName',width:200},
		{name:'start',index:'id',width:100},
		{name:'end',index:'code',width:100},
		{name:'isTransport',index:'zhName',width:200},
		{name:'trunkStatus',index:'id',width:100},
		{name:'createName',index:'code',width:100},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var temp = '<div class="btn-group"><button class="btn btn-xs btn-info" onclick="updateRouteModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deleteRouteModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
				return temp;
		}}
	]
}); */

$('#departDetial_table').datagrid_ace({
	caption: "",
	url: '/estmanager/getTrunkingLine.html?departmentID=-1',
//		colNames:['ID','部门编号','部门名称','航线价格','航线ID','航线起点','航线终点','是否转运','状态','创建人','操作'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_department_number"/>',
	          '<spring:message code="l_js_department_name"/>','<spring:message code="l_js_route_price"/>',
	          '<spring:message code="l_js_route_id"/>','<spring:message code="l_js_routes_starting_point"/>',
	          '<spring:message code="l_js_route_the_end"/>','<spring:message code="l_js_whether_transshipment"/>',
	          '<spring:message code="l_js_status"/>','<spring:message code="l_js_creater"/>',
	          '<spring:message code="l_js_operation"/>'],
	height:250,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	colModel:[
		{name:'id',index:'id',width:100,hidden:true},
		{name:'departmentID',index:'id',width:100},
		{name:'name',index:'id',width:100},
		{name:'price',index:'code',width:100},
		{name:'no',index:'zhName',width:200},
		{name:'start',index:'id',width:100},
		{name:'end',index:'code',width:100},
		{name:'isTransport',index:'zhName',width:200},
		{name:'trunkStatus',index:'id',width:100},
		{name:'createName',index:'code',width:100},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var temp = '<div class="btn-group"><button class="btn btn-xs btn-info" onclick="updateRouteModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deleteRouteModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
				return temp;
		}}
	]
});
//添加航线 _列表
$('#newDepartTarget').bind('click',function(){
	var _id = $('#depart_table').jqGrid("getGridParam", "selrow");
	//alert(_id);
	if(_id == null){
		modalAlert('<spring:message code="l_js_please_select_the_post_office"/>');
		return false
	};
	$('#departModal').modal('show');
	setTimeout(function(){
		$('#departDetial_table').jqGrid('setGridWidth',$('#departDetial_table').parents('.gridContent').width())
	},500);
	$('#departDetial_table').jqGrid('setGridParam', {
	 	url: '/estmanager/getTrunkingLine.html?departmentID='+_id,
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
});
//添加航线
$('#routeNewForDetial').bind('click',function(){
	destroyValidTooltip();
	$('#editRouteModal').modal('show');
	$("#editRouteForm .row input").val("");
	$("#editRouteForm .row select").val("Y");
	$('#routeSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editRouteForm"));
		if(!formValidation.check()){
			return false;
		}
		$('#editRouteModal').modal('hide');
		$.ajax({
		   type: "POST",
		   url: '/estmanager/addTrunkingLine.html',
		   data:$("#editRouteForm").serializeJson(),
		   dataType: "json",
		   success: function(rslt) {
			  if(rslt.code == "1"){
				  modalAlert('<spring:message code="l_js_add_success"/>');
				  $('#departDetial_table').trigger("reloadGrid");
			  }else{
				  modalAlert('<spring:message code="l_js_add_failure"/>');
			  }
		   }
		});
	})
})
//编辑
function updateRouteModalFnc(id, rowId){
	destroyValidTooltip();
	$('#editRouteModal').modal('show');
	var data = $('#departDetial_table').jqGrid("getRowData", rowId);
	for(var o in data){
		var _obj = $("#editRouteForm").find("input[name='"+o+"']");
		if(_obj.length > 0){
			_obj.val(data[o]);
		}
	}
	$('#routeSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editRouteForm"));
		if(!formValidation.check()){
			return false;
		}
		$('#editRouteModal').modal('hide');
		$.ajax({
			   type: "POST",
			   url: '/estmanager/updateTrunkingLine.html',
			   data:$("#editRouteForm").serializeJson(),
			   dataType: "json",
			   success: function(rslt) {
				  if(rslt.code == "1"){
					  modalAlert('<spring:message code="l_js_update_success"/>');
					  $('#departDetial_table').trigger("reloadGrid");
				  }else{
					  modalAlert('<spring:message code="l_js_update_failure"/>');
				  }
			   }
			});
		
	})
}
//删除
function deleteRouteModalFnc(id){
	$('#deletePostofficeAlert').modal('show');
	$('#detialDeleteSubmit').unbind('click').bind('click',function(){
		$('#deletePostofficeAlert').modal('hide');
		//填写删除
		$.ajax({
			   type: "GET",
			   url: '/estmanager/deleteTrunkingLine.html?id='+id,
			   success: function(rslt) {
				  if(rslt.code == "1"){
					  modalAlert('<spring:message code="l_js_delete_success"/>');
					  $('#departDetial_table').trigger("reloadGrid");
				  }else{
					  modalAlert('<spring:message code="l_js_delete_failure"/>');
				  }
			   }
			});
	})
}
$("#price").numeral(); 
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid" id="">
	<div class="page-header">
		<h5>
<!-- 		基本信息 --><spring:message code="l_basic_information"/>
		</h5>
	</div>
	<div class="page-content">		
		<div class="widget-box">
			<div class="widget-header header-color-blue">
				<h5 class="bigger lighter">
<!-- 					邮局信息列表 --><spring:message code="l_post_office_information_list"/>
				</h5>
				<div class="widget-toolbar no-border">
					<button class="btn btn-xs btn-success" id="newPostBasicTarget"><i class="icon-ok"></i> 
<!-- 					新增部门 --><spring:message code="l_add_department"/>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="post_basic_code"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 编辑邮局信息 -->
<div class="modal fade" id="editPostModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="editPostModalHeader">
<!--         编辑邮局信息 --><spring:message code="l_edit_post_office_information"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editPostForm">
        	<input type="hidden" id="post_id_edit" name="id">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门名称： --><spring:message code="l_cus_organization_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="post_name_edit" name="name" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门编号： --><spring:message code="l_cus_organization_no"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="post_no_edit" name="no" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门地址： --><spring:message code="l_institution_address"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="post_address_edit" name="address" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							联系电话/邮箱： --><spring:message code="l_phone_email"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="post_phoneNum_edit" name="phoneNum" placeholder="">
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
        <button type="button" class="btn btn-primary" id="postSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>

<!-- 编辑邮局部门信息 -->
<div class="modal fade" id="editDepartModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="">
<!--         新增邮局部门信息 --><spring:message code="l_add_post_office_department_information"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editDepartForm">
        	<input type="hidden" id="depart_id_edit" name="parentId">
        	<div class="row">
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门编号： --><spring:message code="l_department_number"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_no_edit" name="no" validate="notnull" placeholder="" readonly="readonly">
						</div>
					</div>
				</div>
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门名称： --><spring:message code="l_department_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_name_edit" name="name" validate="notnull" placeholder="" >
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							部门地址： --><spring:message code="l_department_address"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="depart_address_edit" name="address" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							联系电话/邮箱： --><spring:message code="l_phone_email"/>
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
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="departSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 删除邮局信息 -->
<div class="modal fade" id="deletePostBasicAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         删除 --><spring:message code="l_delete"/>
        </h4>
      </div>
      <div class="modal-body">
<!--        	 确定要删除这条信息吗？ --><spring:message code="l_delete_alert"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="detialPostBasicDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
	formValidation.setFormObj($("#editDepartForm"));
	formValidation.init();
	formValidation.setFormObj($("#editPostForm"));
	formValidation.init();
});
$('#post_basic_code').datagrid_ace({
	caption: "",
	url: '/org/post/list.html',
// 	colNames:['ID','机构名称','机构编号','机构类型','地址','联系电话/邮箱','操作'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_name_of_organization"/>',
	          '<spring:message code="l_js_agency_number"/>','<spring:message code="l_js_institutional_type"/>',
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
		{name:'address',index:'address',width:200},
		{name:'phoneNum',index:'phoneNum',width:200},
		{name:'',index:'',width:200,formatter:function(cellvalue, options, rowObject){
			return '<spring:message code="l_js_post"/>';
		}},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var userType = ${userType};
			var temp;
			temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialPostBasicModalFnc('+rowObject.id+')"><i class="icon-eye-open bigger-120"></i></button>';
			temp += '<button class="btn btn-xs btn-info" onclick="updatePostBasicModalFnc('+rowObject.id+',' + options.rowId + ')"><i class="icon-edit bigger-120"></i></button>';
			
			return temp;
		}}
	],
	onSelectRow:function(rowid,iRow,iCol,e,rowData){
		$('#depart_id_edit').val(rowid)
	}
});
//新增
$('#newPostBasicTarget').bind('click',function(){
	destroyValidTooltip();
	var id = $('#post_basic_code').jqGrid("getGridParam", "selrow");
	if(id == null){
		modalAlert('<spring:message code="l_js_please_select_the_post_office"/>');
		return false;
	}
	queryNo();
	$('#editDepartModal').modal('show');
	$('#departSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editDepartForm"));
		if(!formValidation.check()){
			return false;
		}
		$('#editDepartModal').modal('hide');
		$.ajax({
		   type: "POST",
		   url: '/org/depart/add.html',
		   data:$("#editDepartForm").serializeJson(),
		   dataType: "json",
		   success: function(rslt) {
			  if(rslt.code == "1"){
				  modalAlert('<spring:message code="l_js_add_success"/>');
			  }else{
				  modalAlert('<spring:message code="l_js_add_failure"/>');
			  }
		   }
		});
	})
})
//查看
function detialPostBasicModalFnc(id){
	$(".loadingImg").fadeIn("fast");
	$("#_content").load('org/post/depart.html?str='+id,function(responseTxt,statusTxt,xhr){
		 if(statusTxt=="success"){
			 $(".loadingImg").fadeOut("fast");
		}else if(statusTxt=="error"){
		    alert("Error: "+xhr.status+": "+xhr.statusText);
		}
	});
	$("#_menu").find(".submenu").find("li").removeClass("active");
	$("#_menu a[href='/org/post/depart.html']").parent().addClass("active");
}
//编辑
function updatePostBasicModalFnc(id, rowId){
	destroyValidTooltip();
	var post = $("#post_basic_code").jqGrid("getRowData", rowId);
	setPostEdit(post);
	$('#editPostModal').modal('show');
	$('#postSubmit').unbind('click').bind('click',function(){
		formValidation.setFormObj($("#editPostForm"));
		if(!formValidation.check()){
			return false;
		}
		$('#editPostModal').modal('hide');
		$.ajax({
			   type: "POST",
			   url: '/org/update.html',
			   data:$("#editPostForm").serializeJson(),
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
//设置邮局信息
function setPostEdit(post){
	$('#post_id_edit').val(post.id);
	$('#post_name_edit').val(post.name);
	$('#post_no_edit').val(post.no);
	$('#post_address_edit').val(post.address);
	$('#post_phoneNum_edit').val(post.phoneNum);
}
// //删除
// function deletePostBasicModalFnc(id){
// 	$('#deletePostBasicAlert').modal('show');
// 	$('#detialPostBasicDeleteSubmit').unbind('click').bind('click',function(){
// 		$('#deletePostBasicAlert').modal('hide');
// 		$.ajax({
// 			   type: "POST",
// 			   url: '/org/delete.html',
// 			   data:{'id':id},
// 			   dataType: "json",
// 			   success: function(rslt) {
// 				  if(rslt.code == "1"){
// 					  modalAlert('<spring:message code="l_js_delete_success"/>');
// 					  update();
// 				  }else{
// 					  modalAlert('<spring:message code="l_js_delete_failure"/>');
// 				  }
// 			   }
// 			});
// 	})
// }

function update(){
	$('#post_basic_code').jqGrid('setGridParam', {
	 	url: '/org/post/list.html',
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}

//获取机构编号
function queryNo(){
	$.ajax({
		url:'/org/queryNo.html?id=3',
		type: 'POST',
		async:false,
		success:function(data){
			$('#depart_no_edit').val(data.rows);
		}
	});
}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
<!-- 	机构管理 --><spring:message code="l_organization_management"/>
	</h5>
</div>
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
<!-- 				机构管理 --><spring:message code="l_organization"/>
				</h4>
			</div>
		
			<div class="widget-body">
				<div class="widget-main padding-8">
					<div id="tree1" class="ztree"></div>
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
					<button class="btn btn-xs btn-success" id="newOrgTarget"><i class="icon-ok"></i> 
<!-- 					新增 --><spring:message code="l_add"/>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="org_table"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 编辑机构信息 -->
<div class="modal fade" id="editOrgModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="orgModalTitle">
<!--         编辑 --><spring:message code="l_edit"/>
        </h4>
      </div>
      <div class="modal-body">
        <form id="editOrgForm">
        	<input type="hidden" id="org_id_edit" name="id">
        	<div class="row">
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							父机构名称： --><spring:message code="l_parent_organization_name"/>
						</label>
						<div class="col-md-9">
							<input type="hidden" id="org_parentId_edit" name="parentId">
							<input type="text" class="form-control" id="org_parentName_edit" placeholder="" disabled="disabled">
						</div>
					</div>
				</div>
        		<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							机构编号： --><spring:message code="l_cus_organization_no"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="org_no_edit" name="no" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix" id="org_level_div">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							级别： --><spring:message code="l_level"/>
						</label>
						<div class="col-md-9">
							<input id="org_level_id_edit" name="level" type="hidden" value=""/>
							<input type="text" class="form-control" id="org_level_name_edit" disabled="disabled">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							机构类型： --><spring:message code="l_institutional_type"/>
						</label>
						<div class="col-md-9">
							<input id="org_type_id_edit" name="type" type="hidden" value=""/>
							<input type="text" class="form-control" id="org_type_name_edit" disabled="disabled">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							机构名称： --><spring:message code="l_cus_organization_name"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="org_name_edit" name="name" validate="notnull" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							机构名称： --><spring:message code="l_cus_organization_ename"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="org_ename_edit" name="ename" validate="notnull" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							机构地址： --><spring:message code="l_institution_address"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="org_address_edit" name="address" placeholder="">
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group clearfix">
						<label class="col-md-3 control-label no-padding-right">
<!-- 							联系电话/邮箱： --><spring:message code="l_phone_email"/>
						</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="org_phoneNum_edit" name="phoneNum" placeholder="">
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
        <button type="button" class="btn btn-primary" id="orgSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<!-- 删除机构信息 -->
<div class="modal fade" id="deleteOrgAlert" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">
<!--         删除 --><spring:message code="l_delete"/>
        </h4>
      </div>
      <div class="modal-body">
<!--        	 确定要删除该机构吗？ --><spring:message code="l_delete_remind"/>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="orgDeleteSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
$(document).ready(function() {
	formValidation.setFormObj($("#editOrgModal"));
	formValidation.init();
});

var parentJG = null;
var ztree1 = null;
jQuery(function($){
	//初始化树
	ztree1 = new loadZtree({
		container:'#tree1',
		url:'/dataAuth/orgTree.html?clientFlag=0',
		data:{userId:1},
		_callback:function(event, treeId, treeNode){
			event.preventDefault();
			if(treeNode.level == 3){
				$('#newOrgTarget').hide();
			}else{
				$('#newOrgTarget').show();
			}
			parentJG = treeNode;
			updateTable();
		},
		_loadZTreeSuccessCallback:function(){
			setGirdWidth('#org_table')
		}
	});
	
	//重新加载树
// 	ztree1.reloadZTree();
});

var levelName = {"2":'机构',"3":'部门'};
var typeName = {"0":'邮局',"1":'客户'};

$('#org_table').datagrid_ace({
	caption: "",
	url: '/org/query.html',
// 	colNames:['ID','机构编号','机构名称','所属机构','操作','类型','级别','地址','联系电话'],
	colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_agency_number"/>',
	          '<spring:message code="l_js_name_of_organization"/>','','','<spring:message code="l_js_subsidiary_organization"/>',
	          '<spring:message code="l_js_operation"/>','<spring:message code="l_js_type"/>',
	          '<spring:message code="l_js_level"/>','<spring:message code="l_js_address"/>',
	          '<spring:message code="l_js_phone_email"/>'],
	height:380,
	autoScroll:true,
	altRows:false,
	shrinkToFit:true,
	multiselect:false,
	colModel:[
  		{name:'id',index:'id',width:200,hidden:true},
		{name:'no',index:'no',width:100},
		{name:_name,index:_name,width:200},
		{name:'ename',index:'ename',width:200, hidden:true},
		{name:'name',index:'name',width:200, hidden:true},
		{name:_parentName,index:_parentName,width:200},
		{name:'editor',index:'editor',formatter:function(cellvalue, options, rowObject){
			var temp = '<div class="btn-group"><button class="btn btn-xs btn-primary" onclick="detialOrgModalFnc('+rowObject.id+')"><i class="icon-eye-open bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-info" onclick="updateOrgModalFnc('+rowObject.id+')"><i class="icon-edit bigger-120"></i></button>';
				temp += '<button class="btn btn-xs btn-danger" onclick="deleteOrgModalFnc('+rowObject.id+')"><i class="icon-trash bigger-120"></i></button></div>';
				return temp;
		}},
		{name:'type',index:'type',width:200,hidden:true},
		{name:'level',index:'level',width:200,hidden:true},
		{name:'address',index:'address',width:200,hidden:true},
		{name:'phoneNum',index:'phoneNum',width:200,hidden:true}
	]
});

//刷新列表
function updateTable(){
	var id = 0;
	if(parentJG != null){
		id = parentJG.id;
	}
	if(parentJG != null && (parentJG.level == 3 || parentJG.level == 0)){
		return false;
	}
	$('#org_table').jqGrid('setGridParam', {
	 	url: '/org/query.html?parentId='+id,
	    page : 1,
	    datatype:"JSON"
	}).trigger("reloadGrid");
}

//新增
$('#newOrgTarget').bind('click',function(){
	if(parentJG == null){
		modalAlert('<spring:message code="l_js_please_select_a_parent_organization"/>');
		return false;
	}
	if(parentJG.level != 1 && parentJG.level != 2){
		return false;
	}
	destroyValidTooltip();
	$('#editOrgModal input').attr('readonly',false);
	$('#editOrgModal select').attr('disabled',false);
	$('#org_no_edit').attr('readonly',true);
	$('#org_level_div').show();
	
	$('#editOrgForm')[0].reset();
	
	$('#org_parentId_edit').val(parentJG.id);
	$('#org_parentName_edit').val(parentJG.name);
	$('#org_level_id_edit').val(parentJG.level+1);
	$('#org_type_id_edit').val(parentJG.type);
	$('#org_level_name_edit').val(levelName[parentJG.level+1]);
	$('#org_type_name_edit').val(typeName[parentJG.type]);
	queryNo();
	
	$('#editOrgModal').modal('show');
	$('#orgModalTitle').text('<spring:message code="l_add"/>');
	$('#codeName').attr('readonly',false);
	$('#orgSubmit').show();
	$('#orgSubmit').unbind('click').bind('click',function(){
		if(formValidation.check()){
			$.ajax({
				url:'/org/add.html',
				type: 'POST',
				data: $('#editOrgForm').serializeJson(),
				success:function(result){
					if(result.code == '1'){
						$('#editOrgModal').modal('hide');
						updateTable();
						ztree1.reloadZTree();
					}else{
						modalAlert(result.info);
					}
				}
			});
		}
	})
});

//获取机构编号
function queryNo(){
	var level = $('#org_parentId_edit').val();
	$.ajax({
		url:'/org/queryNo.html?id='+level,
		type: 'POST',
		async:false,
		success:function(data){
			$('#org_no_edit').val(data.rows);
		}
	});
}
//查看
function detialOrgModalFnc(id){
	$('#editOrgModal input').attr('readonly',true);
	$('#editOrgModal select').attr('disabled',true);
	$('#org_level_div').hide();
	
	var org = $('#org_table').getRowData(id);
	setOrg(org);
	$('#editOrgModal').modal('show');
	$('#orgSubmit').unbind('click').hide();
	$('#orgModalTitle').text('<spring:message code="l_js_view"/>');
}

//设置机构属性
function setOrg(org){
	$('#org_id_edit').val(org.id);
	$('#org_name_edit').val(org.name);
	$('#org_ename_edit').val(org.ename);
	$('#org_no_edit').val(org.no);
	$('#org_type_name_edit').val(typeName[org.type]);
	$('#org_level_name_edit').val(levelName[org.level]);
	$('#org_address_edit').val(org.address);
	$('#org_phoneNum_edit').val(org.phoneNum);
	$('#org_parentName_edit').val(org.parentName);
}
//编辑
function updateOrgModalFnc(id){
	destroyValidTooltip();
	$('#editOrgModal input').attr('readonly',false);
	$('#editOrgModal select').attr('disabled',true);
	$('#org_no_edit').attr('readonly',true);
	$('#org_name_edit').attr('readonly',true);
	$('#org_ename_edit').attr('readonly',true);
	$('#org_level_div').hide();
	
	var org = $('#org_table').getRowData(id);
	setOrg(org);
	$('#editOrgModal').modal('show');
	$('#orgModalTitle').text('<spring:message code="l_edit"/>');
	$('#orgSubmit').show();
	$('#orgSubmit').unbind('click').bind('click',function(){
		if(formValidation.check()){
			$.ajax({
				url:'org/update.html',
				type: 'POST',
				data: $('#editOrgForm').serializeJson(),
				success:function(data){
					if(data.code == '1'){
						$('#editOrgModal').modal('hide');
						updateTable();
					}else{
						modalAlert(data.info);
					}
				}
			});
		}
	})
}
//删除
function deleteOrgModalFnc(id){
	var rowData = $('#org_table').getRowData(id);
	$('#deleteOrgAlert').modal('show');
	$('#orgDeleteSubmit').unbind('click').bind('click',function(){
		$.ajax({
			url:'/org/delete.html',
			type: 'POST',
			data: rowData,
			success:function(data){
				if(data.code == 1){
					updateTable();
					ztree1.reloadZTree();
				}else{
					modalAlert(data.info);
				}
				$('#deleteOrgAlert').modal('hide');
			}
		})
	})
}
</script>
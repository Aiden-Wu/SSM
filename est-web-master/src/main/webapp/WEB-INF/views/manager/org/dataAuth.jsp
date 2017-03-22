<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-header">
	<h5>
<!-- 	数据权限管理 --><spring:message code="l_data_authorization_management"/>
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
<!-- 				组织 --><spring:message code="l_organization"/>
				</h4>
			</div>
			<div class="widget-body">
				<div class="widget-main padding-8">
					<div id="tree_data" class="ztree"></div>
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
					<button class="btn btn-xs btn-success" id="dataAuthTarget"><i class="icon-ok"></i> 
<!-- 					授权 --><spring:message code="l_authorization"/>
					</button>
				</div>
			</div>
			<div class="widget-body">
				<div class="widget-main no-padding">
					<div class="gridContent">
						<table class="table table-bordered" id="dataAuth-table"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 权限信息 -->
<div class="modal fade" id="authModal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="authTitle">
<!--         数据授权 --><spring:message code="l_data_authorization"/>
        </h4>
      </div>
      <div class="modal-body">
       	 <div class="ztree" id="authTreeForEdit"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">
<!--         取消 --><spring:message code="l_cancel"/>
        </button>
        <button type="button" class="btn btn-primary" id="authSubmit">
<!--         确定 --><spring:message code="l_ok"/>
        </button>
      </div>
    </div>
  </div>
</div>
<script>
jQuery(function($){
	var row={}; //表格选中行数据

	//加载节点数
	var ztree1 = new loadZtree({
		container:'#tree_data',
		url:'/dataAuth/orgTree.html?clientFlag=0',
		// simpleData: {
		// 	pIdKey: "parentId"
		// },
		_callback:function(event, treeId, treeNode){
			// 点击节点时的回调函数
			var _id=treeNode.id;
			event.preventDefault();
			$('#dataAuth-table').jqGrid('setGridParam', {datatype:'json', postData:{"orgId":_id, "isPaging":1}}).trigger('reloadGrid');
		},
		_loadZTreeSuccessCallback:function(){
			setGirdWidth('#dataAuth-table')
		}
	});

	// 获取ztree checkbox选中的节点ID，返回数组，参数treeId=ztree的容器ID
	function getCheckData(treeId) {
		var treeObj=$.fn.zTree.getZTreeObj(treeId),
	    	nodes=treeObj.getNodes(),
	    	nodes_array=treeObj.transformToArray(nodes),
	    	treeChecked=[];
	    for(var i=0;i<nodes_array.length;i++){
	    	if(nodes_array[i].checked==true && nodes_array[i].level == 3){
				treeChecked.push(nodes_array[i].dataAuthId);
	    	}
	    }
	    return treeChecked;
	}

	// 是否有选中表格数据
	$('#dataAuthTarget').click(function(){
		if(!row.id){
			modalAlert('<spring:message code="l_js_select_personnel_remind"/>');
			return false;
		}
		$('#authModal').modal('show');
	})
	
	// 更新授权
	$('#authSubmit').click(function(){
		var _a=getCheckData("authTreeForEdit");
		
		$.ajax({
			url: '/dataAuth/auth.html',
			type: 'POST',
			data:{'userId': row.id,'dataAuthIds':_a+""},
		})
		.done(function(data) {
			if(data.code==1){
				modalAlert('<spring:message code="l_js_authorization_success"/>');
				$('#authModal').modal('hide');
			}else{
				modalAlert(data.info);
			}
		})
		.fail(function() {
			modalAlert('<spring:message code="l_js_request_failed"/>');
		})
	})
	$('#authModal').on('show.bs.modal', function (e) {
		var ztree2 = new loadZtree({
			container:'#authTreeForEdit',
			url:'/dataAuth/authTree.html?id='+row.id,
			check:{
				enable:true
			},
			simpleData: {
				enable: true,
				idKey: "orgId",
				pIdKey: "parentId"
			},
			_callback:function(event, treeId, treeNode){
				// 点击节点时的回调函数
				event.preventDefault();
			},
			_loadZTreeSuccessCallback:function(data){ //加载节点数成功时的回调函数
				var _data=data.data.permission
				// 回填结构树选中数据 
				var treeObj=$.fn.zTree.getZTreeObj("authTreeForEdit");
				treeObj.checkAllNodes(false);
				if(_data.length>0){
					for(var i=0;i<_data.length;i++) {
						treeObj.checkNode(treeObj.getNodeByParam("orgId",_data[i]),true);
					}
				}
			}
		});
	})

	$('#authModal').on('hide.bs.modal', function (e){
		$('#authSubmit').css({'display':'inline-block'});
	})

	$('#dataAuth-table').on('click','.viewBtn',function(){
		$('#authSubmit').css({'display':'none'});
	})

	//重新加载树
	//ztree1.reloadZTree();

	$('#dataAuth-table').datagrid_ace({
		caption: "",
		url: '/user/query.html?isPaging='+1,
// 		colNames:['id','人员编号','姓名','登记账号','所属部门','所属机构','人员类型'],
		colNames:['<spring:message code="l_js_id"/>','<spring:message code="l_js_personnel_numbers"/>',
		          '<spring:message code="l_js_name"/>','<spring:message code="l_js_login_account"/>',
		          '<spring:message code="l_js_subsidiary_department"/>','<spring:message code="l_js_subsidiary_organization"/>',
		          '<spring:message code="l_js_personnel_type"/>'],
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
			{name:'title',index:'title',width:200}
		],
		onSelectRow:function(id){
			// 获取选中行的数数据
			row=$('#dataAuth-table').jqGrid("getRowData", id);
		}
	});
});
</script>
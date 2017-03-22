<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<form id="inputWeightForm">
	<div class="row">
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
		<div class="col-md-4">
			<div class="form-group clearfix">
				<label class="col-md-4 control-label no-padding-right">
				</label>
				<div class="col-md-8">
					<button id="inputCN38Button" type="button" onclick="isCountryInput();" class="col-md-6 btn btn-primary btn-sm pull-left">
<!-- 							录入CN38 --><spring:message code="l_input_cn38"/>
					</button>
				</div>
			</div>
		</div>
	</div>
</form>
<div class="gridContent">
	<table class="table table-bordered" id="table_finish_detail"></table>
</div>

<script>
	$('#table_finish_detail').datagrid_ace({
		caption: "",
		colNames:['<spring:message code="l_js_pouch_no"/>','<spring:message code="l_js_cn35"/>','CN38',
		          '<spring:message code="l_js_package_type"/>', '<spring:message code="l_js_forecast_total_number_of_packages"/>', 
		          '<spring:message code="l_js_actual_total_number_of_packages"/>','<spring:message code="l_js_forecast_total_weight_of_pouch"/>', 
		          '<spring:message code="l_js_actual_total_weight_of_pouch"/>', '<spring:message code="l_js_error_value"/>', 
		          '<spring:message code="l_js_remark"/>', '邮局英文名称', '国家代码'],
		height:380,
		rowList:[30,50,100],
		rowNum:100,
		autoScroll:true,
		altRows:false,
		shrinkToFit:true,
		multiselect:false,
		scroll:true,
		colModel:[
			{name:'packageNo',index:'packageNo', width:160},
			{name:'cn35',index:'cn35',width:120},
			{name:'cn38',index:'cn38',width:120},
			{name:'dispatchType',index:'dispatchType', width:80},
			{name:'estimatePackageNum',index:'estimatePackageNum', width:120,formatter:function(cellvalue, options, rowObject){
				return parseFloat(cellvalue).toFixed(0);
			}},
			{name:'actualPackageNum',index:'actualPackageNum', width:120,formatter:function(cellvalue, options, rowObject){
				return parseFloat(cellvalue).toFixed(0);
			}},
			{name:'estimatePackageWeight',index:'estimatePackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
				return parseFloat(cellvalue).toFixed(3);
			}},
			{name:'actualPackageWeight',index:'actualPackageWeight', width:120,formatter:function(cellvalue, options, rowObject){
				return parseFloat(cellvalue).toFixed(3);
			}},
			{name:'errorValue',index:'errorValue', width:120},
			{name:'remark',index:'remark'},
			{name:'postofficeEnName',index:'postofficeEnName', width:100, hidden:true},
			{name:'countryCode',index:'countryCode', width:100, hidden:true}
		],
		ondblClickRow:function(rowid,iRow,iCol,e,rowData){
			jqgClickRow(rowData, rowid)
			$('#table_finish_detail').jqGrid("setSelection",rowid);
		},
		gridComplete:function(){
			afterCompleteFunction('#table_finish_detail');
		}
	});
	
	//录入国家CN38
	function inputCountryCN38() {
		var countryCodes = {};
		var arr = $('#table_finish_detail').getRowData();
		for ( var item in arr) {
			countryCodes[arr[item].countryCode] = arr[item].cn38 || "";
		}
		$('#input_country_cn38_from .country_cn38').empty();
		$.each(countryCodes,function(key, value) {
			var htmlText = $('#input_country_input').clone().attr('id', '').removeClass('hidden');
			htmlText.find('label').text(key);
			htmlText.find('input').val(value);
			htmlText.find('input').attr('data_countryCode', key);
// 			htmlText.find('input').unbind('keydown').bind('keydown', function(e) {
// 				if (e.which == 13) {
// 					submitCN38Batch();
// 				}
// 			});
			$('#input_country_cn38_from .country_cn38').append(htmlText);
		});
		$('#input_country_cn38_modal').modal('show');
	}

	function updatePackageList(rslt) {
		if (rslt.code == '1') {
			if($('#input_country_cn38_modal').attr('isFinish') == 1){
				$('#input_country_cn38_modal').modal('hide');
			}
			$('#table_finish_detail').jqGrid('setGridParam', {
				url : '/post/package.html',
				page : 1,
				postData : {
					'dispatchNo' : $('#weightModalDispatchNo').val(),
					'postofficeEnName' : $('#postofficeEnName_edit').val(),
					from : 3
				},
				datatype : "JSON"
			}).trigger("reloadGrid");
			updateMain();
		} else {
			modalAlert(rslt.info);
		}
	}
	
	//批量提交CN38
	function submitCN38Batch(){
		var isFinish = 0;
		var totalNum = 0;
		var arr = $('#input_country_cn38_from .country_cn38 input');
		var datas = [];
		arr.each(function(value) {
			if ($(this).val() != '') {
				totalNum += 1;
				var dataItem = {
					countryCode : $(this).attr('data_countryCode'),
					cn38 : $(this).val()
				}
				datas.push(dataItem);
			}
		});
		if (totalNum == arr.length) {
			isFinish = 1;
		}
		var data = {
			postofficeEnName : $('#postofficeEnName_edit').val(),
			dispatchNo : $('#weightModalDispatchNo').val(),
			cn38JsonString:JSON.stringify(datas),
			isFinish : isFinish
		};
		$('#input_country_cn38_modal').attr('isFinish', isFinish);
		console.info(data);
		ajaxEngine.postAjax('/post/inputCN38.html', data, updatePackageList);
	}

	//是否可以录入CN38
	function isCountryInput() {
		if(isInputCN38 != 1){
			return ;
		}
		var data = {
			"str" : $('#weightModalDispatchNo').val()
		};
		ajaxEngine.postAjax('/post/isInputCN38.html', data, function(data) {
			if (data.data == '1') {
				inputCountryCN38();
			}
		});
	}

	//双击表格行
	function jqgClickRow(rowData, rowid) {
		if(isInputCN38 != 1){
			return ;
		}
		$('#input_cn38_modal').modal('show');
		$('#cn38_edit').val(rowData.cn38);
		$('#submit_cn38_button').attr('data-countryCode', rowData.countryCode);
		$('#submit_cn38_button').attr('data-rowid', rowid);
	}

	//提交CN38
	function submitCN38() {
		var isFinish = 0;
		var totalNum = 0;
		var arr = $('#table_finish_detail').getRowData();
		for ( var item in arr) {
			if (arr[item].cn38 != null && arr[item].cn38 != '') {
				totalNum += 1;
			}
		}
		if (totalNum == arr.length - 1) {
			isFinish = 1;
		}
		var datas = [];
		var dataItem = {
			countryCode : $('#submit_cn38_button').attr('data-countryCode'),
			cn38 : $('#cn38_edit').val()
		}
		datas.push(dataItem);
		var _data = {
			postofficeEnName : $('#postofficeEnName_edit').val(),
			dispatchNo : $('#weightModalDispatchNo').val(),
			cn38JsonString:JSON.stringify(datas),
			isFinish : isFinish
		};
		ajaxEngine.postAjax('/post/inputCN38.html', _data, submitCN38Finish);
	}

	//提交CN38结果处理
	var submitCN38Finish = function(rslt) {
		if (rslt.code == '1') {
			modalAlert('<spring:message code="l_js_school_success"/>');
			$('#input_cn38_modal').modal('hide');
			//刷新列表
			updateDetail();
		} else {
			modalAlert(rslt.info);
		}
	};

	//扫描邮袋号
	$('#packageNo').keydown(function(e) {
		if (e.which == 13) {
			queryPackage();
		}
	})

	//回填CN38
	$('#cn38_edit').keydown(function(e) {
		if (e.which == 13) {
			submitCN38();
		}
	})

	//查找邮袋
	function queryPackage() {
		var dispatchNo = $('#weightModalDispatchNo').val();
		var packageNo = $('#packageNo').val();
		var data = $('#table_finish_detail').jqGrid("getRowData");
		$('#table_finish_detail').jqGrid("resetSelection");
		for (var i = 0; i < data.length; i++) {
			if (packageNo == data[i].packageNo || packageNo == data[i].cn35) {
				$($('#table_finish_detail tbody tr')[i + 1]).trigger('dblclick');
				scrollToTarget(i + 1);
				return;
			}
		}
		modalAlert('<spring:message code="l_js_no_package_remind"/>');
		isSearch = true;
	}

	//表格焦点定位 for scroll
	function scrollToTarget(i) {
		$('#table_finish_detail').parents('.ui-jqgrid-bdiv').scrollTop($('#table_finish_detail tr.ui-widget-content').height() * i - $('#table_finish_detail').parents('.ui-jqgrid-bdiv').height())
	}

	//设置误差值颜色
	function afterCompleteFunction(_grid) {
		//获取列表数据
		var rowDatas = $(_grid).jqGrid('getRowData'), cls = 'datagrid-info';
		for (i = 0; i < rowDatas.length; i++) {
			var rowData = rowDatas[i];
			var errorValue = parseFloat(rowData.errorValue), rowIds = $(_grid).getDataIDs();
			if (errorValue >= errorRange || errorValue <= errorRange * -1) {
				$(_grid).setCell(rowIds[i], "errorValue", "", "text-danger");
			} else {
				$(_grid).setCell(rowIds[i], "errorValue", "", "text-success");
			}
		}
	}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<meta charset="utf-8" />
		<title>ITS</title>
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@ include file="/common/headResource_css.jsp"%>
		<%@ include file="/common/headResource_script.jsp"%>
	</head>
	<body>
	<!--普通loading -->
	<div class="loadingImg"></div>
	<!-- 带文字内容loading -->
	<div class="loadingImgForTxt" id="loadingFilter"><div class="loadIconMain"><span class="loadIcon"></span><p class="loadingTxt"></p></div></div>
	<!-- 带进度条loading -->
	<div class="loadingImgForBar" id="loadingFilterForBar">
		<div class="loadginBarBody">
			<div class="progress">
				<div class="progress-bar" style="width:0%;"></div>
				<span class="barNum">0%</span>
			</div>
			<p class="loadingTxt"></p>
		</div>
	</div>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="logoIcon"><img src="" id="l_g"></i>
							<i class="logoIcon"><img src="" id="l_l"></i>
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="list-inline" style="line-height:34px;margin-bottom: 0;">
						<li>
							
							<span class="showFinger" style="color: #fff;font-size: 14px;vertical-align: middle;">
<!-- 							你好， --><spring:message code="l_hello"/>
							${user_info.username}
							</span>
						</li>
						<li style="vertical-align: middle; */">
							<div class="pull-left setSkin">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span style="color:#fff;">&nbsp; 
<!-- 							更换皮肤 --><spring:message code="l_choose_skin"/>
							</span>
						</li>
						<!-- <li>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container">
							<label class="lbl showFinger" for="ace-settings-add-container" style="color:#fff;">
								窄屏显示
							</label>
						</li> -->
						<li>
							<span class="showFinger"  data-toggle="modal" data-target="#updatePwd" style="color: #fff;font-size: 14px;vertical-align: middle;">
<!-- 							修改密码 --><spring:message code="l_password"/>
							</span>
						</li>
						<li>
							<span class="showFinger" onclick="logOut()" style="color: #fff;font-size: 14px;vertical-align: middle;">
<!-- 							退出 --><spring:message code="l_exit"/>
							</span>
						</li>
					</ul>
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts" style=" display:none;">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list" id="_menu">
								
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<span>
<!-- 								主页 --><spring:message code="l_home"/>
								</span>
							</li>

							<li style="display:none;">
								<span href="#" id="level_two"></span>
							</li>
							<li class="active" id="level_three" style="display:none;"></li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search" style="display:none;">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content" style="padding-top: 0px;padding-left: 12px;padding-bottom:0;">
						<div class="row">
							<div class="col-xs-12" id="_content">
								<!-- PAGE CONTENT BEGINS -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

				<div class="ace-settings-container" id="ace-settings-container" style="display:none;">
					<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
						<i class="icon-cog bigger-150"></i>
					</div>

					<div class="ace-settings-box" id="ace-settings-box">
						<div>
							<div class="pull-left">
								<select id="skin-colorpicker" class="hide">
									<option data-skin="default" value="#438EB9">#438EB9</option>
									<option data-skin="skin-1" value="#222A2D">#222A2D</option>
									<option data-skin="skin-2" value="#C6487E">#C6487E</option>
									<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
								</select>
							</div>
							<span>&nbsp; Choose Skin</span>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
							<label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
							<label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
							<label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
							<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
						</div>

						<div>
							<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
							<label class="lbl" for="ace-settings-add-container">
								Inside
								<b>.container</b>
							</label>
						</div>
					</div>
				</div><!-- /#ace-settings-container -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
	</body>
	
	<!-- 管理员忘记密码 start -->
	<div class="modal fade" id="updatePwd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" data-toggle="modal" data-target="#forgetPwd" id="myModalLabel">
<!-- 					修改密码 --><spring:message code="l_password"/>
					</h4>
				</div>
				<form id="updatePwdForm" method="post" action="/user/updatePwd.html">
					<input id="userId" name="id" type="hidden" value="${user_info.id}" />
					<div class="modal-body no-padding-left ">
						<div class="container">
							<div class="row" style="font-size: 0px; padding-top: 10px;">
								<label class="dExplain col-lg-5 text-right">
<!-- 								旧密码： --><spring:message code="l_old_password"/>
								</label>
								<div class="dExplain col-lg-7">
									<input name="oldPassword" validate="notnull&amp;len(6-32)" type="password" class="ace">
								</div>
							</div>
							<div class="row" style="font-size: 0px; padding-top: 10px;">
								<label class="dExplain col-lg-5 text-right">
<!-- 								新密码： --><spring:message code="l_new_password"/>
								</label>
								<div class="dExplain col-lg-7">
									<input name="newPassword" validate="notnull&amp;len(6-32)" type="password" class="ace">
								</div>
							</div>
							<div class="row" style="font-size: 0px; padding-top: 10px;">
								<label class="dExplain col-lg-5 text-right">
<!-- 								重复密码： --><spring:message code="l_repeat_password"/>
								</label>
								<div class="dExplain col-lg-7">
									<input name="rePassword" validate="notnull&amp;len(6-32)" type="password" class="ace">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input id="errorMsg" type="hidden" value="" />
						<button type="button" class="btn btn-primary" onclick="updatePwd()">
<!-- 						确认 --><spring:message code="l_ok"/>
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
<!-- 						取消 --><spring:message code="l_cancel"/>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 管理员忘记密码 end -->
<li id="firstMenuModel" class="hidden"> 
	<a href="#" class="dropdown-toggle">
		<i class="icon"></i>
		<span class="menu-text">代码管理</span>
		<b class="arrow icon-angle-down"></b>
	</a>
	<ul class="submenu">
	</ul>
</li>

<li id="secondMenuModel" class="hidden">
	<a href="">
	<i class="icon-double-angle-right"></i>
		<span class="menu-text">国家二字代码</span>
	</a>
</li>
	
<script>
var intervalArr=[];
var L_L = {6:"images/6g.png", 5:"images/5g.png"};
var L_G = {6:"images/6l.png", 5:"images/5l.png"};
var _pid = ${user_info.pid};
$(document).ready(function(){
	if(L_L[_pid]){
		$("#l_l").attr("src",L_L[_pid]);
	} else {
		$("#l_l").parent().remove();
	}
	if(L_G[_pid]){
		$("#l_g").attr("src", L_G[_pid]);
	} else {
		$("#l_g").parent().remove();
	}
	
	//加载目录
	ajaxEngine.getAjax('/resources/menu.html', null, createMenu);
	$("#_content").load("/welcome.html", function(responseTxt,statusTxt,xhr){
			
	});
});
{//..init
	var zbsconf = zbsconf || SysConfig('${static_resource_url}', '${pub_resource_url}', '${domain}', '${up_domain}' , '${master_login_url}');
	formValidation.setFormObj($("#updatePwdForm"));
	formValidation.init();
}
var logOut=function(){
	ajaxEngine.getAjax("./logOut.html", null, logOutCall);
}
var logOutCall = function(r){
	if(r == "1"){
		//modalAlert("退出登录成功");
		window.location.href="./toLogin.html";
	} else {
		modalAlert(r.info);
	}
};

var clearIntervalArr=function(){
	for(var index in intervalArr){
		window.clearInterval(intervalArr[index]);
	}
}

var updatePwd=function(){
	if(!formValidation.check()){
		return false;
	}
	ajaxEngine.formAjax($("#updatePwdForm"), function(r){
		if (r.code == "1") {
			modalAlert("密码修改成功");
			window.location.href="./toLogin.html";
		} else {
			modalAlert(r.info);
		}
	});
};

//创建目录树
function createMenu (result){
	for (var index in result.data) {
		var menuItem = result.data[index];
		if(menuItem.pid == 0 && menuItem.id != 0){
			var menuHtml = $('#firstMenuModel').clone().attr('id', 'first_'+menuItem.id).removeClass('hidden');
			menuHtml.find('a').attr('href', menuItem.url);
			if(language == "en_US"){
				menuHtml.find('.menu-text').html(menuItem.ename);
			} else {
				menuHtml.find('.menu-text').html(menuItem.name);
			}
			menuHtml.find('.icon').addClass(menuItem.icon);
			$('#_menu').append(menuHtml);
		}else{
			var menuHtml = $('#secondMenuModel').clone().attr('id', 'second_'+menuItem.id).removeClass('hidden');
			menuHtml.find('a').attr('href', menuItem.url);
			menuHtml.find('.menu-text').html(menuItem.name);
			if(language == "en_US"){
				menuHtml.find('.menu-text').html(menuItem.ename);
			} else {
				menuHtml.find('.menu-text').html(menuItem.name);
			}
			$('#first_'+menuItem.pid+' .submenu').append(menuHtml);
		}
	}
	setMenuClick();
};

function setMenuClick(){
	$("#_menu").find("a").bind("click",function(e){		
		e.preventDefault();
		
		clearIntervalArr();//清除查询定时器
		
		var url = $(this).attr("href") || "";
		var text = $(this).text();
		if(url != "" && url != "#"){
			$("#level_three").text(text).show();
			//$("#level_three").show();
			$(".loadingImg").fadeIn("fast");
			$("#_content").load(url,function(responseTxt,statusTxt,xhr){
				//$(".loadingImg").show();
				 if(statusTxt=="success"){
					 $(".loadingImg").fadeOut("fast");
				}else if(statusTxt=="error"){
				    alert("Error: "+xhr.status+": "+xhr.statusText);
				};
				$(".modal").on("hidden.bs.modal",function(event){
					destroyValidTooltip()
				})
			});
			$("#_menu").find(".submenu").find("li").removeClass("active");
			$(this).parent().addClass("active");
		} else {
			var t = $("#level_two").text();
			if(t == text){
				$("#level_three").text("").hide();
				$("#level_two").text("").parent().hide();
			} else {
				$("#level_two").text(text).parent().show();
				$("#level_three").text("").hide();
			}
		}
	});
}

/*
author:dreamy
date:2012-08-21
work://拿到页面大小
*/
function GetPageSize() {
    /// <summary>拿到页面大小</summary>
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
        xScroll = window.innerWidth + window.scrollMaxX;
        yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight) { // all but Explorer Mac
        xScroll = document.body.scrollWidth;
        yScroll = document.body.scrollHeight;
    } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
        xScroll = document.body.offsetWidth;
        yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if (self.innerHeight) {	// all except Explorer
        if (document.documentElement.clientWidth) {
            windowWidth = document.documentElement.clientWidth;
        } else {
            windowWidth = self.innerWidth;
        }
        windowHeight = self.innerHeight;
    } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
        windowWidth = document.documentElement.clientWidth;
        windowHeight = document.documentElement.clientHeight;
    } else if (document.body) { // other Explorers
        windowWidth = document.body.clientWidth;
        windowHeight = document.body.clientHeight;
    }
    // for small pages with total height less then height of the viewport
    if (yScroll < windowHeight) {
        pageHeight = windowHeight;
    } else {
        pageHeight = yScroll;
    }
    // for small pages with total width less then width of the viewport
    if (xScroll < windowWidth) {
        pageWidth = xScroll;
    } else {
        pageWidth = windowWidth;
    }
    arrayPageSize = new Array(pageWidth, pageHeight, windowWidth, windowHeight);
    return arrayPageSize;
}
var iframeSize = function(){
	var winSize=GetPageSize();
	var thisWid= winSize[2]-200;
	var thisHieght = winSize[3]-88;
	
	$("#easemob").css({"width":thisWid+"px","height":thisHieght+"px"});
	return winSize;
	
}
iframeSize();
$(window).resize(function() {
	var winSize=GetPageSize();
	iframeSize();
})
/* $("#charItSwitch,.submenu>li").on("click",function(){
		$("#easemob").hide();
		$("#_content").show();
}); */

</script>
</html>

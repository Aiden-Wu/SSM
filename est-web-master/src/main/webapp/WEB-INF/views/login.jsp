<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8" />
<title>ITS</title>
<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%@ include file="/common/headResource_css.jsp"%>
<%@ include file="/common/headResource_script.jsp"%>
<script>
	 if(window.parent.document.getElementById("_content")){
	 	window.location.href = zbsconf.getMaster_Login_Url();
	 };
	$(document).ready(function() {//init form valid
		formValidation.setFormObj($("#loginForm"));
		formValidation.init();
	});
</script>
<style type="text/css">
.login-layout *:not(i){font-family:"微软雅黑";}
.login-layout .widget-box{ overflow:inherit;}
</style>
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
						<div style="float:right;">
							<span class="showFinger" style="color: #fff;font-size: 16px;vertical-align: middle;">
								<a href="/i18n/switchLanguage.html?langType=zh" style="color: #fff" >中文</a> 
							</span> <span class="showFinger" style="color: #fff;font-size: 14px;vertical-align: middle;">|</span>
							<span class="showFinger" style="color: #fff;font-size: 16px;vertical-align: middle;">
								<a href="/i18n/switchLanguage.html?langType=en" style="color: #fff" >EN</a>
							</span>
						</div>					
			<div class="row" style="position: absolute;left: 50%;top: 15%;margin-left:-181px;">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1 style="color:#fff;">ITS ONLINE</h1>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<img src="/images/pen.png" width="20px" /> 
											<!-- 请输入您的信息 -->
											<spring:message code="l_pl_input_u_info"></spring:message>
										</h4>

										<div class="space-6"></div>

										<form id="loginForm" method="post" action="./login.html">
											<fieldset>
												<label class="block clearfix"> 
													<span class="block input-icon input-icon-right"> 
													<input id="userName" name="username" type="text" class="form-control" placeholder="<spring:message code="l_js_username"></spring:message>" validate="notnull&len(2-32)" /> 
													<i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> 
													<span class="block input-icon input-icon-right"> 
													<input name="password" type="password" class="form-control" validate="notnull" placeholder="<spring:message code="l_js_password"></spring:message>" /> <i class="icon-lock"></i>
												</span>
												</label> 
												<!-- <label class="block clearfix"> 
												<span class="inline">
														<input name="validateCode" validate="notnull" type="text"class="form-control" placeholder="验证码" />
												</span> <span class="width-35 pull-right form-control" onclick="flushCode()"> <img
														id="vilidCode" style="width: 110px; height: 42px; margin-top: -15px; margin-left: -15px;"
														src="../valicode/get.html" alt="验证码" title="验证码">
												</span>
												</label> -->
												<div class="space"></div>

												<div class="clearfix">
													<!-- <label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl" style="font-size: 12px;">下次自动登录</span>
													</label> -->
													<button type="button" onclick="login()"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 
														<!-- 登录 -->
														<spring:message code="l_login"/>
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
											<input id="errorMsg" type="hidden" value="" />
										</form>

										<div class="social-or-login center">
											<span class="bigger-110"></span>
										</div>
									</div>
									<!-- /widget-main -->

								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->

						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->

	<script type="text/javascript">
		var login = function() {
			var userName = $('#userName').val().trim();
			$('#userName').val(userName);
			var re = /^[a-z0-9A-Z_]{3,20}$/;
			if(!re.test(userName)){
				modalAlert('<spring:message code="l_js_username_error"/>');
				return false;
			}
			if (formValidation.check()) {
				ajaxEngine.formAjax($("#loginForm"), updateLogin);
			}
		};
		var language = $.cookie("Language") || "zh_CN";
		if(language == "en_US"){
			$($(".showFinger")[1]).hide();
			$($(".showFinger")[2]).hide();
		} else{
			$($(".showFinger")[0]).hide();
			$($(".showFinger")[1]).hide();
		}

		var updateLogin = function(r) {
			if (r.code == "1") {
				var url = "./main.html";
				window.location.href = url;
			} else {
				modalAlert(r.info);
			}
		};
		//回车提交表单事件
		$(document).keydown(function(e){
			if(e.which == 13){
				login();
			}
		})
		/** window.history.forward(1); */
	</script>
</body>
</html>
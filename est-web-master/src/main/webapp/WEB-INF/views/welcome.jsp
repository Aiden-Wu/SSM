<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- <div class="welcome_content">
	<h4>Hi SVPSYL_OPS,SHENZHEN SUNYOU LOGISTICS CO.,LTD - VIRTUAL POS</h4>
	<h1>WELCOME TO</h1>
	<div>
		<h1>EST</h1>
		<dl>
			<dt>EST - Electronic Shipping Tool - is a products to cater for business customer.</dt>
			<dd>
				The system provides convenient especially for bulk printing by providing facility to generate and print consignment note,barcode label, manifest, store consignees's details etc
			</dd>
		</dl>
	</div>
	
</div> -->
<div class="welcome_contentForImg">
	<img src="${static_resource_url}/images/welcome.png?v=2" width="100%" height="100%">
</div>
<script>
$('.welcome_contentForImg').css({
	width:$('.page-content').outerWidth(),
	height:$(window).height() - ($('#navbar').outerHeight()+$('#breadcrumbs').outerHeight())
})
</script>
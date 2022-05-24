<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"     uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>A PICTURE DIARY</title>
	<meta name="description" content="">
    <meta name="msapplication-tap-highlight" content="yes" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0" />

    <!-- Google Web Font -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lekton:400,700,400italic' rel='stylesheet' type='text/css'>

    <!--  Bootstrap 3-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

    <!-- OWL Carousel -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.css">

    <!--  Slider -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.kenburnsy.css">

    <!-- Animate -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">

    <!-- Web Icons Font -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/iconmoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/et-line.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ionicons.css">

    <!-- Magnific PopUp -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">

    <!-- Tabs -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tabs.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tabstyles.css" />

    <!-- Loader Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loader-1.css">

    <!-- Costum Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">

    <!-- Modernizer & Respond js -->
    <script src="${pageContext.request.contextPath}/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

    <!-- jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Filepond stylesheet -->
    <link href="https://unpkg.com/filepond/dist/filepond.css" rel="stylesheet"/>
    <link href="https://unpkg.com/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.css" rel="stylesheet"/>

	<!-- toast UI -->
	<link rel="stylesheet" href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css" />

	<!-- the-carbon-components -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/the-carbon-components.css">
	
</head>

<body>

	<!-- google login -->
	<script src="https://accounts.google.com/gsi/client" async defer></script>
	
	<!-- Filepond js -->
 	<script src="https://unpkg.com/filepond-plugin-image-preview/dist/filepond-plugin-image-preview.js"></script>
    <script src="https://unpkg.com/filepond-plugin-image-resize/dist/filepond-plugin-image-resize.js"></script>
    <script src="https://unpkg.com/filepond-plugin-image-transform/dist/filepond-plugin-image-transform.js"></script>
    <script src="https://unpkg.com/filepond/dist/filepond.js"></script>

    <!-- toast UI -->
	<script src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.js"></script>
	
	<!-- sweetAlert -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

	<!-- Preloader -->
	<div class="cover"></div>

	<div class="header">
	    <div class="container">
	        <div class="logo">
	            <a href="/">
	                <img src="${pageContext.request.contextPath}/images/logo.png" alt="Logo">
	            </a>
	        </div>

	    	<a href="javascript:openPop()" style="">로그인/회원가입 </a>
	        <!-- Menu Hamburger (Default) -->
	        <button class="main-menu-indicator" id="open-button">
	            <span class="line"></span>
	        </button>
	        <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/right-sidebar.jsp"></jsp:include>
	        <!-- End of Menu Hamburger (Default) -->

	    </div>
	</div>

	<div class="popup_layer" id="popup_layer" style="display: none;">
	  <div class="popup_box">
	      <div style="height: 10px; float: top;">
	        <a href="javascript:closePop();"><img src="${pageContext.request.contextPath}/images/close.svg" class="m_header-banner-close" width="60px" height="60px" style="float: right;"></a>
	      </div>
	      <!--팝업 컨텐츠 영역-->
	      <div class="popup_cont">
	          <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/user/join.jsp"></jsp:include>
	          <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/user/login.jsp"></jsp:include>
	      </div>
	  </div>
	</div>

	<script>
	// 로그인 메시지
	<c:if test="${ not empty msg }">
	   openPop();
	   Swal.fire(
			   '',
			   '${msg}',
			   'question'
		);
	</c:if>
	
	//팝업 띄우기
	function openPop() {
	    document.getElementById("popup_layer").style.display = "block";
	    $(".login").show();
	    $(".wrap").hide();
	}

	//팝업 닫기
	function closePop() {
	    document.getElementById("popup_layer").style.display = "none";
	}

	function switchBtn() {
		if($(".login").css("display") != "none"){
			$(".login").hide();
		    $(".wrap").show();
		}else {
			$(".login").show();
		    $(".wrap").hide();
		}
	}

	</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<c:if test="${ diaryDto.getPath() ne null }" >
	<div class="container">
	    <div class="single-project-slider">
	        <div><img class="img-responsive center-block" src="${pageContext.request.contextPath}${ diaryDto.getPath() }" alt="slider"></div>
	    </div>
	</div>
</c:if>

<div class="container">
    <div class="single-portfolio-wrapper">
        <div class="row">
            <div class="">
                <h1>${ diaryDto.getTitle() }</h1>
                <span class="info"><fmt:formatDate value="${diaryDto.getDiaryDate()}" pattern="yyyy-MM-dd"/></span>
                <p>${ diaryDto.getContent()}</p>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
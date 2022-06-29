<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container margin-top">
    <div class="similar-project">
        <h4>BOOKMARK</h4>
        <div class="row">
        	<c:choose>
        		<c:when test="${ bookmarkList ne null }" >
		        	<c:forEach items="${ bookmarkList }" var="bookmark">
			            <div class="col-md-4 col-sm-4 col-xs-12">
			                <div class="img">
			                    <img src="${bookmark.path}" onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/images/diary/img_2.jpg'" alt="Portfolio Item">
			                    <div class="overlay-thumb">
			                        <a href="javascript:void(0)" class="like-product">
			                        	<c:choose>
		                            		<c:when test="${bookmark.bookmark eq '1'}">
				                                <i class="press ion-ios-heart"></i>
		                            		</c:when>
		                            		<c:otherwise>
				                                <i class="ion-ios-heart-outline"></i>
		                            		</c:otherwise>
		                            	</c:choose>
			                            <i class="ion-ios-heart-outline"></i>
			                            <span class="like-product">Liked</span>
			                        </a>
			                        <div class="details">
			                            <span class="title">${ bookmark.title }</span>
			                            <span class="info">${ bookmark.content }</span>
			                        </div>
			                        <span class="btnBefore"></span>
			                        <span class="btnAfter"></span>
			                        <a class="main-portfolio-link" href="single-project.html"></a>
			                    </div>
			                </div>
			            </div>
		        	</c:forEach>
        		</c:when>
        		<c:otherwise>
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container margin-top">
    <div class="similar-project">
        <h4>BOOKMARK</h4>
        <div class="row">
        	<c:choose>
        		<c:when test="${ bookmarkList ne '[]' }" >
		        	<c:forEach items="${ bookmarkList }" var="bookmark">
			            <div class="col-md-4 col-sm-4 col-xs-12">
			                <div class="img">
			                    <img src="${bookmark.path}" onerror="this.onerror=null;this.src='${pageContext.request.contextPath}/images/defaultImg.jpg'" alt="Portfolio Item">
			                    <div class="overlay-thumb">
			                        <a href="javascript:void(0)" class="like-product" data-diary="${bookmark.diaryId}">
			                        	<c:choose>
		                            		<c:when test="${bookmark.bookmark eq '1'}">
				                                <i class="press ion-ios-heart"></i>
		                            		</c:when>
		                            		<c:otherwise>
				                                <i class="ion-ios-heart-outline"></i>
		                            		</c:otherwise>
		                            	</c:choose>
			                            <span class="like-product">Bookmark</span>
			                        </a>
			                        <div class="details">
			                            <span class="title">${ bookmark.title }</span>
			                            <span class="info">${ bookmark.content }</span>
			                        </div>
			                        <span class="btnBefore"></span>
			                        <span class="btnAfter"></span>
			                        <a class="main-portfolio-link" href="/diary/detail.do?diaryId=${ bookmark.diaryId }""></a>
			                    </div>
			                </div>
			            </div>
		        	</c:forEach>
        		</c:when>
        		<c:otherwise>
		            <div class="col-md-4 col-sm-4 col-xs-12">
        				<p>북마크 된 일기가 없습니다.</p>
        			</div>
        		</c:otherwise>
        	</c:choose>
        </div>
    </div>
</div>

<c:if test="${sessionScope.nickname ne null}">
	<div class="container">
	<ul class="pagination-ef wow animated fadeInUp" data-wow-delay="0.20s">${ pageBar }</ul>
	</div>
</c:if>


<script>
//like
$(document).on('click', '.like-product', function(){
	
	$.ajax({
		url : '${ pageContext.request.contextPath }/diary/bookmarkUpdate.do',
		type : 'POST',
		dataType : 'text',
		data : {
			"userId" : ${sessionScope.userId},
			"diaryId" : this.dataset.diary
		},
		success : function(data){
			console.log(data);
			console.log($(this).children().first());
		}
	});
	// heart color
	if($(this).children().first().hasClass('ion-ios-heart-outline')){
		$(this).children().first().removeClass();
		$(this).children().first().addClass('press ion-ios-heart');
	}else {
		$(this).children().first().removeClass();
		$(this).children().first().addClass('ion-ios-heart-outline');
	}
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp"%>
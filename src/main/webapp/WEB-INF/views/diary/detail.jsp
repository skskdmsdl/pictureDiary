<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/detail.css">

<c:choose>
	<c:when test="${ diaryDto.getPath() ne null }" >
		<div class="container">
		    <div class="single-project-slider">
		        <div>
		        	<a href="javascript:void(0)" class="like-product" data-diary="${diaryDto.getDiaryId()}">
			       		<c:choose>
	                  		<c:when test="${diaryDto.getBookmark() eq '1'}">
	                        	<i class="press ion-ios-heart"></i>
	                  		</c:when>
	                  		<c:otherwise>
	                        	<i class="ion-ios-heart-outline"></i>
	                  		</c:otherwise>
	                  	</c:choose>
					</a>
		        	<img class="img-responsive center-block" src="${pageContext.request.contextPath}${ diaryDto.getPath() }" alt="slider">
		        </div>
		    </div>
		</div>
<div class="container">
	</c:when>
	<c:otherwise>
<div class="container">
		<a href="javascript:void(0)" class="like-product" data-diary="${diaryDto.getDiaryId()}">
			<c:choose>
				<c:when test="${diaryDto.getBookmark() eq '1'}">
			     	<i class="press ion-ios-heart"></i>
				</c:when>
				<c:otherwise>
			     	<i class="ion-ios-heart-outline"></i>
				</c:otherwise>
			</c:choose>
		</a>
	</c:otherwise>
</c:choose>

    <div class="single-portfolio-wrapper">
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
<jsp:include page="../common/footer.jsp"></jsp:include>
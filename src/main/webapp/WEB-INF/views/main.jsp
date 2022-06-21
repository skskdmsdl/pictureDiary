<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container" id="bannerContainer">
	<c:choose>
   		<c:when test="${ diaryList ne null }">
	   		<c:forEach items="${ diaryImageList }" var="diaryImage" >
				<c:if test="${diaryImage.diaryId eq diaryList[0].diaryId}" >
		   			<div class="header-page ef-parallax-bg" style="background-image:url('${diaryImage.path}'), url(images/blog-header.jpg); ">
				        <div class="col-md-6 col-md-offset-6">
				            <div class="row">
				                <div class="inner-content">
				                    <div id="header-content" class="header-content">
				                        <h1>${ diaryList[0].title }</h1>
				                        <hr>
				                        <p>${ diaryList[0].content }</p>
				                    </div>
				                </div>
				            </div>
				        </div>
				    </div>
				</c:if>
			</c:forEach>
   		</c:when>
   		<c:otherwise>
   			<div class="header-page ef-parallax-bg" style="background-image:url(images/blog-header.jpg)">
		        <div class="col-md-6 col-md-offset-6">
		            <div class="row">
		                <div class="inner-content">
		                    <div id="header-content" class="header-content">
		                        <h1></h1>
		                        <hr>
		                        <p>로그인이 필요합니다.</p>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </div>
   		</c:otherwise>
   	</c:choose>
		    
</div>

<div class="container margin-top">
    <div class="blog-wrapper">
        <div class="main">
            <ul class="cbp_tmtimeline">
            <c:choose>
            	<c:when test="${ diaryList ne null }">
            	총 ${ totalContents } 건
		            <c:forEach items="${diaryList}" var="diary" varStatus="status">
		                <li>
		                    <div class="cbp_tmtime">
		                        <span><fmt:formatDate value="${diary.diaryDate}" pattern="yyyy-MM-dd"/></span>
		                    </div>
		                    <div class="cbp_tmicon icon-calendar"></div>
		                    <div class="cbp_tmlabel wow animated fadeInUp" data-wow-delay="0.10s">
		                        <div class="blog-v2-image">
		                        	<c:forEach items="${diaryImageList}" var="diaryImage" >
		                        		<c:if test="${ diaryImage.diaryId eq diary.diaryId }" >
		                            	<img src="${ diaryImage.path }" alt="Blog Post">
		                            	</c:if>
		                            </c:forEach>
		                        </div>
		                        <a href="diary/detail.do">
		                            <h1>${ diary.title }</h1>
		                        </a>
		
		                        <p>${ diary.content }</p>
		                    </div>
		                </li>
		                </c:forEach>
            	</c:when>
            	<c:otherwise>
            	
            	</c:otherwise>
            </c:choose>
            </ul>
        </div>
    </div>
</div>

<c:if test="${sessionScope.nickname ne null}">
	<div class="container">
	<ul class="pagination-ef wow animated fadeInUp" data-wow-delay="0.20s">${ pageBar }</ul>
	</div>
</c:if>

<script>
$(document).ready(function () {
	if("${pageBar}" == ''){
		/* if($('.pagination-ef').children('li:nth-child(n+'+page+'):nth-child(-n+'+page+')').text() == page-1){
			$('.pagination-ef').children('li:nth-child(n+'+page+'):nth-child(-n+'+page+')').addClass('current');
		} */
		$('.pagination-ef').hide();
	} 
});

//controller 메시지
const message = '${mainMsg}';

if(message != ""){
	Swal.fire({
		text: message,
		confirmButtonColor: '#12B886'
	});
};

// 배너 이미지 없는 경우 동적 html 추가
if($('#header-content').hasClass('header-content') == ''){
	const container = $('#bannerContainer');
	$(container).prepend('<div class="header-page ef-parallax-bg" style="background-image:url(images/blog-header.jpg); ">'
		+'<div class="col-md-6 col-md-offset-6">'
		+'<div class="row">'
		+'<div class="inner-content">'
		+'<div id="header-content" class="header-content">'
		+'<h1>${ diaryList[0].title }</h1><hr>'
		+'<p>${ diaryList[0].content }</p>'
		+'</div></div></div></div></div>');
} 
   
</script>

<jsp:include page="common/footer.jsp"></jsp:include>
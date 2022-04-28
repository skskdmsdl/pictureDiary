<jsp:include page="../common/header.jsp"></jsp:include>

<div class="container" id="container" style="background-image: url(${pageContext.request.contextPath}/images/searchBanner.jpg);">
	<div data-search role="search" class="bx--search bx--search--xl">
	    <label id="search-input-label-1" class="bx--label" for="search__input-1">Search</label>
	    <input class="bx--search-input" type="text" id="search__input-1" placeholder="Search" >
	    <svg focusable="false" preserveAspectRatio="xMidYMid meet" style="will-change: transform;" xmlns="http://www.w3.org/2000/svg" class="bx--search-magnifier" width="16" height="16" viewBox="0 0 16 16" aria-hidden="true"><path d="M15,14.3L10.7,10c1.9-2.3,1.6-5.8-0.7-7.7S4.2,0.7,2.3,3S0.7,8.8,3,10.7c2,1.7,5,1.7,7,0l4.3,4.3L15,14.3z M2,6.5	C2,4,4,2,6.5,2S11,4,11,6.5S9,11,6.5,11S2,9,2,6.5z"></path></svg>
	    <button class="bx--search-close bx--search-close--hidden" title="Clear search
	        input" aria-label="Clear search input">
	      <svg focusable="false" preserveAspectRatio="xMidYMid meet" style="will-change: transform;" xmlns="http://www.w3.org/2000/svg" class="bx--search-clear" width="20" height="20" viewBox="0 0 32 32" aria-hidden="true"><path d="M24 9.4L22.6 8 16 14.6 9.4 8 8 9.4 14.6 16 8 22.6 9.4 24 16 17.4 22.6 24 24 22.6 17.4 16 24 9.4z"></path></svg>
	    </button>
	  </div>
</div>

<div class="container margin-top">
    <div class="portfolio-wrapper">
        <button class="nav">
        <span class="icon-container">
            <span class="line line01"></span>
            <span class="line line02"></span>
            <span class="line line03"></span>
            <span class="line line04"></span>
        </span>
        </button>
        <div class="works-filter">
            <a href="javascript:void(0)" class="filter active" data-filter="mix">All</a>
            <a href="javascript:void(0)" class="filter" data-filter="title">Title</a>
            <a href="javascript:void(0)" class="filter" data-filter="content">Content</a>
        </div>
        <div class="js-masonry">
            <div class="row" id="work-grid">
                <!-- Begin of Thumbs Portfolio -->
                <div class="col-md-6 col-sm-6 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="${pageContext.request.contextPath}/images/diaryImage/img_1.jpg" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="ion-ios-heart-outline"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">250</span>
                            </a>
                            <div class="details">
                                <span class="title">STYLE FASHION</span>
                                <span class="info">NEW BAG & STYLE FASHION</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="single-project.html"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 mix web">
                    <div class="img home-portfolio-image">
                        <img src="${pageContext.request.contextPath}/images/diaryImage/img_2.jpg" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="ion-ios-heart-outline"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">250</span>
                            </a>
                            <div class="details">
                                <span class="title">STYLE FASHION</span>
                                <span class="info">NEW BAG & STYLE FASHION</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="single-project.html"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 mix branding">
                    <div class="img home-portfolio-image">
                        <img src="${pageContext.request.contextPath}/images/diaryImage/img_1.jpg" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="ion-ios-heart-outline"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">250</span>
                            </a>
                            <div class="details">
                                <span class="title">STYLE FASHION</span>
                                <span class="info">NEW BAG & STYLE FASHION</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="single-project.html"></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 mix web">
                    <div class="img home-portfolio-image">
                        <img src="${pageContext.request.contextPath}/images/diaryImage/img_2.jpg" alt="Portfolio Item">
                        <div class="overlay-thumb">
                            <a href="javascript:void(0)" class="like-product">
                                <i class="ion-ios-heart-outline"></i>
                                <span class="like-product">Liked</span>
                                <span class="output">250</span>
                            </a>
                            <div class="details">
                                <span class="title">STYLE FASHION</span>
                                <span class="info">NEW BAG & STYLE FASHION</span>
                            </div>
                            <span class="btnBefore"></span>
                            <span class="btnAfter"></span>
                            <a class="main-portfolio-link" href="single-project.html"></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="load-more">
            <a href="javascript:void(0)" id="load-more-2col"><i class="icon-refresh"></i></a>
        </div>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
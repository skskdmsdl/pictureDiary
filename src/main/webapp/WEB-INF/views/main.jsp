<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp"%>

<div class="container">
    <div class="header-page ef-parallax-bg" style="background-image:url(images/blog-header.jpg)">
        <div class="col-md-6 col-md-offset-6">
            <div class="row">
                <div class="inner-content">
                    <div class="header-content">
                        <h1>Blog Posts</h1>
                        <hr>
                        <p>Everything created in simple way</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container margin-top">
    <div class="blog-wrapper">
        <div class="main">
            <ul class="cbp_tmtimeline">
                <li>
                    <div class="cbp_tmtime">
                        <span>1 OCT - 2015</span>
                    </div>
                    <div class="cbp_tmicon icon-calendar"></div>
                    <div class="cbp_tmlabel wow animated fadeInUp" data-wow-delay="0.10s">
                        <div class="blog-v2-image">
                            <img src="images/blog/img_4.jpg" alt="Blog Post">
                        </div>
                        <a href="diary/detail.do">
                            <h1>Kosovo the young europeans</h1>
                        </a>
                        <p>Winter purslane courgette pumpkin quandong komatsuna fennel green bean cucumber watercress. Pea sprouts wattle seed rutabaga okra yarrow cress avocado grape radish bush tomato ricebean black-eyed pea maize eggplant. Cabbage lentil cucumber chickpea sorrel gram garbanzo plantain lotus root bok choy squash cress potato summer purslane salsify fennel horseradish dulse. Winter purslane garbanzo artichoke broccoli lentil corn okra silver beet celery quandong.</p>
                    </div>
                </li>
                <li>
                    <div class="cbp_tmtime">
                        <span>3 OCT - 2015</span>
                    </div>
                    <div class="cbp_tmicon icon-calendar"></div>
                    <div class="cbp_tmlabel wow animated fadeInUp" data-wow-delay="0.10s">
                        <div class="blog-v2-image">
                            <img src="images/blog/img_3.jpg" alt="Blog Post">
                        </div>
                        <a href="/diary/detail.do">
                            <h1>Denouncing pleasure clean and praising pain was born</h1>
                        </a>
                        <p>Winter purslane courgette pumpkin quandong komatsuna fennel green bean cucumber watercress. Pea sprouts wattle seed rutabaga okra yarrow cress avocado grape radish bush tomato ricebean black-eyed pea maize eggplant. Cabbage lentil cucumber chickpea sorrel gram garbanzo plantain lotus root bok choy squash cress potato summer purslane salsify fennel horseradish dulse. Winter purslane garbanzo artichoke broccoli lentil corn okra silver beet celery quandong.</p>
                    </div>
                </li>

                <li>
                    <div class="cbp_tmtime">
                        <span>20 SEP 2015</span>
                    </div>
                    <div class="cbp_tmicon icon-calendar"></div>
                    <div class="cbp_tmlabel wow animated fadeInUp" data-wow-delay="0.10s">
                        <a href="/diary/detail.do">
                            <h1>Denouncing pleasure clean and praising pain was born</h1>
                        </a>
                        <p>Winter purslane courgette pumpkin quandong komatsuna fennel green bean cucumber watercress. Pea sprouts wattle seed rutabaga okra yarrow cress avocado grape radish bush tomato ricebean black-eyed pea maize eggplant. Cabbage lentil cucumber chickpea sorrel gram garbanzo plantain lotus root bok choy squash cress potato summer purslane salsify fennel horseradish dulse. Winter purslane garbanzo artichoke broccoli lentil corn okra silver beet celery quandong.</p>
                    </div>
                </li>

                <li>
                    <div class="cbp_tmtime">
                        <span>16 SEP 2015</span>
                    </div>
                    <div class="cbp_tmicon icon-calendar"></div>
                    <div class="cbp_tmlabel wow animated fadeInUp" data-wow-delay="0.10s">
                        <div class="blog-v2-image">
                            <img src="images/blog/img_1.jpg" alt="Blog Post">
                        </div>
                        <a href="/diary/detail.do">
                            <h1>Denouncing pleasure clean and praising pain was born</h1>
                        </a>
                        <p>Winter purslane courgette pumpkin quandong komatsuna fennel green bean cucumber watercress. Pea sprouts wattle seed rutabaga okra yarrow cress avocado grape radish bush tomato ricebean black-eyed pea maize eggplant. Cabbage lentil cucumber chickpea sorrel gram garbanzo plantain lotus root bok choy squash cress potato summer purslane salsify fennel horseradish dulse. Winter purslane garbanzo artichoke broccoli lentil corn okra silver beet celery quandong.</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <ul class="pagination-ef wow animated fadeInUp" data-wow-delay="0.20s">
        <li>
            <a href="#">
                <i class="pe-7s-angle-left"></i>
            </a>
        </li>
        <li class="current"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">...</a></li>
        <li><a href="#">8</a></li>
        <li>
            <a href="#">
                <i class="pe-7s-angle-right"></i>
            </a>
        </li>
    </ul>
</div>

<jsp:include page="common/footer.jsp"></jsp:include>
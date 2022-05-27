<div class="menu-wrap" style="background-image: url(${pageContext.request.contextPath}/images/nav_bg.jpg)">
    <div class="menu-content">
        <div class="navigation">
            <span class="pe-7s-close close-menu" id="close-button"></span>
            <div class="search-wrap js-ui-search">
                <input class="js-ui-text" type="text" placeholder="Search Here...">
                <span class="eks js-ui-close"></span>
            </div>
        </div>
        <nav class="menu">
            <div class="menu-list">
                <ul>
                    <li><a href="/">Diary</a></li>
                    <li><a href="#" onclick="pageLinkBtn('write','${sessionScope.userId}')">Write</a></li>
                    <li><a href="#" onclick="pageLinkBtn('search','${sessionScope.userId}')">Search</a></li>
                </ul>
            </div>
        </nav>

        <div class="hidden-xs">
            <div class="menu-social-media">
                <ul>
                    <li><a href="#"><i class="iconmoon-github"></i></a></li>
                    <li><a href="#"><i class="iconmoon-blogger"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script>
function pageLinkBtn(pageInfo, sessionCheck){
	if(sessionCheck==""){
		 document.getElementById("popup_layer").style.display = "block";
		    $(".login").show();
		    $(".wrap").hide();
		    return false;
	};
	
 	if(pageInfo == 'write'){
		location.href="/write/write.do"
	};
	if(pageInfo == 'search'){
		location.href="/search/searchList.do"
	};
}
</script>
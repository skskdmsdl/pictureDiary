<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<div class="login">
  <h1>로그인</h1>
  <hr />
  <form method="post" class="login-form">
    <input type="text" class="login-input" name="eamil" placeholder="이메일을 입력하세요." tabindex="1" required="required" />
    <input type="password" class="login-input" name="password" placeholder="비밀번호를 입력하세요." tabindex="2" required="required" />
    <div class="parent">
	    <div class="naverLogin">
	    </div>
	    <div class="googleLogin">
			<div id="g_id_onload"
		         data-client_id="396812205052-sgmtre571iqcko7ctv504bi625al27vc.apps.googleusercontent.com"
		         data-callback="handleCredentialResponse"
		         data-auto_select="true"
		 		 data-prompt_parent_id="divonetap">
		    </div>
		    <div class="g_id_signin" data-type="icon" data-shape="circle" ></div>
		</div>
	    <div class="kakaoLogin">third</div>
    </div>
    <button type="submit" class="btn btn-primary btn-block btn-large" onclick="ajaxbtn()" tabindex="6">로그인</button>
  </form>
  <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">회원가입</div></div>
</div>

<script>
//google signin API2
/* function attachSignin(element) {
    auth2.attachClickHandler(element, {},
        function(googleUser) {
    	var profile = googleUser.getBasicProfile();
    	var id_token = googleUser.getAuthResponse().id_token;
	  	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  	  console.log('ID토큰: ' + id_token);
	  	  console.log('Name: ' + profile.getName());
	  	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
			$(function() {
				$.ajax({
				    url: '/member/loginGoogle',
				    type: 'post',
				    data: {
						"id" : <!-- 필요한 데이터 담기 -->,
						"pw" : <!-- 필요한 데이터 담기 -->,
				        "username": profile.getName(),
						"email": profile.getEmail()
					    },
				    success: function (data) {
				            alert("구글아이디로 로그인 되었습니다");
				            location.href="/member/main";
				        }
				});
			})
        }, function(error) {
          alert(JSON.stringify(error, undefined, 2));
        });
    console.log("구글API 끝");
  } */

function handleCredentialResponse(response) {

    // decodeJwtResponse() is a custom function defined by you
    // to decode the credential response.
    const responsePayload = parseJwt(response.credential);
  
    console.log("ID: " + responsePayload.sub);
    console.log('Full Name: ' + responsePayload.name);
    console.log('Given Name: ' + responsePayload.given_name);
    console.log('Family Name: ' + responsePayload.family_name);
    console.log("Image URL: " + responsePayload.picture);
    console.log("Email: " + responsePayload.email); 
    console.log("token: " + response.credential); 

    $.ajax({
   		type: "POST",
   		url: "${ pageContext.request.contextPath }/user/login.do",
   		dataType : "json",
   		data: {
   			"id" : responsePayload.sub,
   			"email" : responsePayload.email,
   			"snsType" : "google"
   		},
   		success :function(data){
   			alert("성공");
   			console.log(data);
   		},
   		error : function(xhr, status, err) {
			console.log("처리실패", xhr, status, err);
   		}
   	});
};
 
function parseJwt (token) {
	const base64Url = token.split('.')[1];
	const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
	const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};

function onSignout() {
    google.accounts.id.disableAutoSelect();
  }
</script>
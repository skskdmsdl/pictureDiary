<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<div class="login">
  <h1>로그인</h1>
  <hr />
  <form method="post" class="login-form">
    <input type="text" class="login-input" name="eamil" placeholder="이메일을 입력하세요." tabindex="1" required="required" />
    <input type="password" class="login-input" name="password" placeholder="비밀번호를 입력하세요." tabindex="2" required="required" />
    <div class="parent">
	    <div class="naverLogin">first</div>
	    <div class="googleLogin">
			<div id="g_id_onload"
		         data-client_id="396812205052-sgmtre571iqcko7ctv504bi625al27vc.apps.googleusercontent.com"
		         data-callback="handleCredentialResponse">
		    </div>
		    <div class="g_id_signin" data-type="icon" data-shape="circle" ></div>
		</div>
	    <div class="kakaoLogin">third</div>
    </div>
    <button type="submit" class="btn btn-primary btn-block btn-large" tabindex="6">로그인</button>
  </form>
  <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">회원가입</div></div>
</div>

<script>

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
 }
 
function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};

function onSignout() {
    google.accounts.id.disableAutoSelect();
  }
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<div class="login">
  <h1>로그인</h1>
  <hr />
  <form method="post" class="login-form">
    <input type="text" class="login-input" name="eamil" placeholder="이메일을 입력하세요." tabindex="1" required="required" />
    <input type="password" class="login-input" name="password" placeholder="비밀번호를 입력하세요." tabindex="2" required="required" />
    <button tabindex="3">네이버</button>
    <a href="http://localhost:9090/auth/google/login"  tabindex="4">구글</a>
    <div class="g-signin2" data-onsuccess="onSignIn"></div>
		<span id="googleLoginBtn" style="cursor: pointer">
			<a href="/login.do">
				<img id="googleLoginImg" src="./images/google.png"  tabindex="5" style="width:40px">
	    </a>
		</span>
    <button type="submit" class="btn btn-primary btn-block btn-large" tabindex="6">로그인</button>
  </form>
  <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">회원가입</div></div>
</div>
<script>
 	/* const onClickGoogleLogin = (e) => {
    	//구글 인증 서버로 인증코드 발급 요청
 		window.open("https://accounts.google.com/o/oauth2/v2/auth?client_id=396812205052-sgmtre571iqcko7ctv504bi625al27vc.apps.googleusercontent.com&redirect_uri=http://localhost:9090/auth/google/login&response_type=code&scope=email%20profile%20openid&access_type=offline", 
 								"구글 로그인", "width=500, height=600")
 	};
	
	const googleLoginBtn = document.getElementById("googleLoginBtn");
	googleLoginBtn.addEventListener("click", onClickGoogleLogin); */
    
</script>
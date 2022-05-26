<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<div class="login">
  <h1>로그인</h1>
  <hr />
  <form method="post" action="${ pageContext.request.contextPath }/user/login.do" class="login-form">
    <input type="text" class="login-input" name="email" id="loginEmail" placeholder="이메일을 입력하세요." tabindex="1" required="required" />
    <input type="password" class="login-input" name="password" id="loginPw" placeholder="비밀번호를 입력하세요." tabindex="2" required="required" />
    <div class="parent">
	    <div class="googleLogin">
			<div id="g_id_onload"
		         data-client_id="396812205052-sgmtre571iqcko7ctv504bi625al27vc.apps.googleusercontent.com"
		         data-callback="handleCredentialResponse"
		         data-auto_select="true"
		 		 data-prompt_parent_id="divonetap">
		    </div>
		    <div class="g_id_signin" data-type="icon" data-shape="circle" ></div>
		</div>
	   <!--  <div class="naverLogin"></div> -->
	   <!--  <div class="kakaoLogin"></div> -->
    </div>
    <button type="submit" class="btn btn-primary btn-block btn-large" onclick="ajaxbtn()" tabindex="6">로그인</button>
  </form>
  <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">회원가입</div></div>
</div>
<script>
function loginPromise(id, email, nickname){
	return new Promise(function(resolve, reject){
		$.ajax({
	   		type: "POST",
	   		url: "${ pageContext.request.contextPath }/user/snsLogin.do",
	   		dataType : "json",
	   		data: {
	   			"id" : id,
	   			"email" : email,
	   			"snsType" : "google"
	   		},
	   		success :function(data){
	   			loginSuccess(data.msg, id, email, nickname);
	   		},
	   		error : function(xhr, status, err) {
				console.log("처리실패", xhr, status, err);
	   		}
	   		
		});	
	});
};

function loginSuccess(msg, id, email, nickname){
	return new Promise(function(resolve, reject){
		if(msg == '소셜 로그인') {
				window.location.reload();
		};
			
		if(msg == '일반 로그인') {
			//confirm("소셜 계정이 연동이 안된 회원입니다. 연동하시겠습니까?");
			Swal.fire({
				text: '소셜 계정이 연동이 안된 회원입니다. 연동하시겠습니까?',
				icon: 'warning',	
				showCancelButton: true,
				confirmButtonColor: '#12B886',
			 	confirmButtonText: '확인',
			 	cancelButtonText: '취소'
			}).then((result) => {
			  if (result.value) {
	              // "확인" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주기
	              // 소셜 회원가입 연동
	              $.ajax({
				   		type: "POST",
				   		url: "${ pageContext.request.contextPath }/user/snsJoin.do",
				   		dataType : "json",
				   		data: {
				   			"id" : id,
				   			"email" : email,
				   			"snsType" : "google"
				   		},
				   		success :function(data){
				   			Swal.fire({
				   				text: data.msg,
				   				confirmButtonColor: '#12B886'
				   			});
				   		},
				   		error : function(xhr, status, err) {
							console.log("처리실패", xhr, status, err);
				   		}
					});	
			  }
			});
		};
		
		if(msg == 'SNS 회원가입'){
			Swal.fire({
				text: '회원이 아닙니다. SNS 회원가입을 진행하시겠습니까?',
				icon: 'question',	
				showCancelButton: true,
				confirmButtonColor: '#12B886',
			 	confirmButtonText: '확인',
			 	cancelButtonText: '취소'
			}).then((result) => {
			  if (result.value) {
				  // ajax 소셜 회원가입
				  $.ajax({
				   		type: "POST",
				   		url: "${ pageContext.request.contextPath }/user/snsJoin.do",
				   		dataType : "json",
				   		data: {
				   			"id" : id,
				   			"email" : email,
				   			"nickname" : nickname,
				   			"snsType" : "google"
				   		},
				   		success :function(data){
				   			Swal.fire({
				   				text: data.msg,
				   				confirmButtonColor: '#12B886'
				   			});
				   		},
				   		error : function(xhr, status, err) {
							console.log("처리실패", xhr, status, err);
				   		}
					});	
			  }
			});
			
		};
	});
};

function errorFunction(){    
	alert('로그인 에러');    
	return false;  
};

// 구글 소셜 로그인 버튼
function handleCredentialResponse(response) {

    // decodeJwtResponse() is a custom function defined by you
    // to decode the credential response.
    const responsePayload = parseJwt(response.credential);
  
//    console.log("ID: " + responsePayload.sub);
//    console.log('Full Name: ' + responsePayload.name);
//    console.log('Given Name: ' + responsePayload.given_name);
//    console.log('Family Name: ' + responsePayload.family_name);
//    console.log("Image URL: " + responsePayload.picture);
//    console.log("Email: " + responsePayload.email); 
//    console.log("token: " + response.credential); 
    
    const id = responsePayload.sub;
    const email = responsePayload.email;
    const nickname = responsePayload.name;

    // Promise로 로그인 ajax 구현
    loginPromise(id, email, nickname)
    .then(loginSuccess)
    .catch(errorFunction);
};

// 구글 정보 읽을 수 있게 변경해주는 함수
function parseJwt (token) {
	const base64Url = token.split('.')[1];
	const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
	const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};

/* function onSignout() {
    google.accounts.id.disableAutoSelect();
} */

</script>
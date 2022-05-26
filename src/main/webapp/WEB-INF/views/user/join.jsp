<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/join.css">

<div class="wrap wd668">
	<div class="container_form">
      <div class="form_txtInput">
        <h1>회원가입</h1>
        <hr />
        <div class="join_form">
          <table>
            <colgroup>
              <col width="30%"/>
              <col width="auto"/>
            </colgroup>
            <tbody>
              <tr>
                <th><span>이메일</span></th>
                <td><input id="email" type="email" placeholder="이메일을 입력하세요."></td>
              </tr>
              <tr>
                <th><span>닉네임</span></th>
                <td><input id="nickname" type="text" placeholder="닉네임을 입력하세요."></td>
              </tr>
              <tr>
                <th><span>비밀번호</span></th>
                <td><input id="password" type="password" placeholder="비밀번호를 입력하세요."></td>
              </tr>
              <tr>
                <th><span>비밀번호 확인</span></th>
                <td><input id="passwordCheck" type="password" placeholder="비밀번호를 확인하세요"></td>
              </tr>
            </tbody>
          </table>
        </div><!-- join_form E  -->
       <div class="btn_wrap">
         <a onclick="joinBtn()">회원가입</a>
       </div>
         <div class="foot"><span>계정이 이미 있으신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">로그인</div></div>
     </div> <!-- form_txtInput E -->
   </div><!-- content E-->
</div> <!-- container E -->

<script>
function joinBtn(){
	const email = $('#email').val();
	const nickname = $('#nickname').val();
	const password = $('#password').val();
	const passwordCheck = $('#passwordCheck').val();

	if(email == "" || nickname == "" || password == "" || passwordCheck == ""){
		Swal.fire({
			text: '필수값을 입력하세요.',
			confirmButtonColor: '#12B886'
		});
		return false;
	};
	
	if(password != passwordCheck){
		Swal.fire({
			text: '비밀번호가 서로 다릅니다.',
			confirmButtonColor: '#12B886'
		});
		return false;
	};
	
	$.ajax({
   		type: "POST",
   		url: "${ pageContext.request.contextPath }/user/join.do",
   		dataType : "json",
   		data: {
   			"email" : email,
   			"nickname" : nickname,
   			"password" : password
   		},
   		success :function(data){
   			// 이메일 중복
   			if(data.msg != null){
   				Swal.fire({
   					text: data.msg,
   					confirmButtonColor: '#12B886'
   				});
   			} else {
	   			Swal.fire({
	   				text: '회원가입이 완료되었습니다.',
	   				confirmButtonColor: '#12B886'
	   			}).then((result) => {
		   			window.location.reload();
	   			});
   			}
   		},
   		error : function(xhr, status, err) {
			console.log("처리실패", xhr, status, err);
   		}
   		
	});	
}
</script>
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
                <td><input type="email" placeholder="이메일을 입력하세요."></td>
              </tr>
              <tr>
                <th><span>닉네임</span></th>
                <td><input type="text" placeholder=""></td>
              </tr>
              <tr>
                <th><span>비밀번호</span></th>
                <td><input type="password" placeholder="비밀번호를 입력해주세요."></td>
              </tr>
              <tr>
                <th><span>비밀번호 확인</span></th>
                <td><input type="password" placeholder="비밀번호를 확인하세요"></td>
              </tr>
            </tbody>
          </table>
        </div><!-- join_form E  -->
       <div class="btn_wrap">
         <a href="javascript:;">다음</a>
       </div>
         <div class="foot"><span>계정이 이미 있으신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">로그인</div></div>
     </div> <!-- form_txtInput E -->
   </div><!-- content E-->
</div> <!-- container E -->
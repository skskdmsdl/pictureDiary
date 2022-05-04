<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<div class="login">
  <h1>로그인</h1>
  <hr />
  <form method="post" class="login-form">
    <input type="text" class="login-input" name="eamil" placeholder="이메일을 입력하세요." tabindex="1" required="required" />
    <input type="password" class="login-input" name="password" placeholder="비밀번호를 입력하세요." tabindex="2" required="required" />
    <button tabindex="3">네이버</button>
    <button tabindex="4">카카오</button>
    <button tabindex="5">구글</button>
    <button type="submit" class="btn btn-primary btn-block btn-large" tabindex="6">로그인</button>
  </form>
  <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" onclick="switchBtn()">회원가입</div></div>
</div>

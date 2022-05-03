<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user.css">

<div class="wrap wd668">
	<div class="container_form">
      <div class="form_txtInput">
        <h2 class="sub_tit_txt">회원가입</h2>
        <p class="exTxt">회원가입을 환영합니다.</p>
        <div class="join_form">
          <table>
            <colgroup>
              <col width="30%"/>
              <col width="auto"/>
            </colgroup>
            <tbody>
              <tr>
                <th><span>아이디</span></th>
                <td><input type="text" placeholder="ID 를 입력하세요."></td>
              </tr>
              <tr>
                <th><span>닉네임</span></th>
                <td><input type="text" placeholder=""></td>
              </tr>
              <tr>
                <th><span>비밀번호</span></th>
                <td><input type="text" placeholder="비밀번호를 입력해주세요."></td>
              </tr>
              <tr>
                <th><span>비밀번호 확인</span></th>
                <td><input type="text" placeholder="비밀번호를 확인하세요"></td>
              </tr>
              <tr class="email">
                <th><span>이메일</span></th>
                <td>
                  <input type="text"  class="email" placeholder="">
                </td>
              </tr>
            </tbody>
          </table>
          <div class="exform_txt"><span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.</span></div>
        </div><!-- join_form E  -->
       <!-- <div class="agree_wrap">
         <div class="checkbox_wrap">
           <input type="checkbox" id="news_letter" name="news_letter" class="agree_chk">
           <label for="news_letter">[선택]뉴스레터 수신동의</label>
         </div>
         <div class="checkbox_wrap mar27">
           <input type="checkbox" id="marketing" name="marketing" class="agree_chk">
           <label for="marketing">[선택]마케팅 목적 개인정보 수집 및 이용에 대한 동의</label>
           <ul class="explan_txt">
             <li><span class="red_txt">항목 : 성별, 생년월일</span></li>
             <li>고객님께서는 위의 개인정보 및 회원정보 수정 등을 통해 추가로 수집하는 개인정보에<br/>
               대해 동의하지 않거나 개인정보를 기재하지 않음으로써 거부하실 수 있습니다.<br/>
               다만 이때 회원 대상 서비스가 제한될 수 있습니다.
             </li>
           </ul>
         </div>
       </div> -->
       <div class="btn_wrap">
         <a href="javascript:;">다음</a>
       </div>
         <div class="foot"><span>아직 회원이 아니신가요?</span><div class="link" tabindex="7" data-testid="switchmode">회원가입</div></div>

     </div> <!-- form_txtInput E -->
   </div><!-- content E-->
</div> <!-- container E -->
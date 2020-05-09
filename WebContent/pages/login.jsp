<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="login">
	<form method="post" action="login">
		<ul>
			<li><input type="text" id="email" placeholder="     이메일 입력"></li>
			<li> <input type="text" id="pass" placeholder="     비밀번호 입력"></li>
			<li><button type="button" id='signIn'>로그인</button></li>
			<li><a href="signUp.jsp" id="signUp">회원가입</a>
			<button type="button" id="findPass">비밀번호 찾기</button></li>
		</ul>	
	</form>
	
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/signUp.js"></script>
<link rel="stylesheet" href="../css/signUp.css">

<title>surVey conneCtion</title>
</head>
<body>
<form method="post" action="">
	<div class="wrap">
		<div class='signUp'>
			<div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
				<ul>
					<li><input type="text" id="email" placeholder="    이메일"><button type="button" id="btnCheckEmail">중복확인</button></li>
					<li><input type="text" id="nick" placeholder="    닉네임"><button type="button" id="btnCheckNick">중복확인</button></li>
					<li><input type="password" id="pass1" placeholder="    비밀번호"></li>
					<li><input type="password" id="pass2" placeholder="    비밀번호 확인"></li>
				</ul>
		</div>
		<div class="rebtn">
			<button type="button" id='btnRegister'>가&nbsp;&nbsp;입&nbsp;&nbsp;하&nbsp;&nbsp;기</button><br>
			<button type="button" id='btnCancel' onClick="history.back(-1)">취소하기</button>
		</div>
	</div>
</form>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/report.js"></script>
<link rel="stylesheet" href="../css/report.css">
</head>
<body>
<div class="rewrap">
	<div class="reTop">
		<h1>관리자 모드</h1>
		<button type="button" id="btnGradeUpdate">등급 갱신</button>
	</div>
	<div class="reMid">
		<div class="reTitle">
			<ul>
				<li>신고자 이메일</li>
				<li>신고 대상 </li>
				<li>신고사유</li>
				<li>처리</li>
			</ul>
		</div>
		<div class="reCont">
		</div>
	</div>
	<div class="reBottom">
		<button type="button" onclick="history.back(-1)">나가기</button>
	</div>
</div>
</body>
</html>
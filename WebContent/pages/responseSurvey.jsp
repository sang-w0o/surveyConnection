<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 응답하기</title>
<%
	if( session==null || session.getAttribute("userInfo")==null ){
%>
	<script>
		alert("로그인 후 이용 가능한 서비스 입니다.");
		location.href = "index.jsp";
	</script>
	
<% 	
	}
%>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/responseSurvey.js"></script>
<link rel="stylesheet" href="../css/responseSurvey.css">
</head>
<body>	

<div class="surwrap">
	<div class="sTop">
		<ul>
			
			<li><button type="button" id="btnReport">설문 신고하기</button></li>
			
			<li><button type="button" id="btnSubmitReport">신고 제출</button><input type="text" id="reportText" placeholder="     신고 사유 입력란"></li>
			
			<li><button type="button" id="btnInterest">관심</button></li>
		</ul>
		
	</div>
	<div class="sMid">
		<div class="questionList">
				
		</div>
	</div>
	<div class="sBottom">
		<button type="submit" id="surBtnReply">응답 제출</button>
		<button type="button" id="surBtnCancel" onclick="history.back(-1)">응답 취소</button>
	</div>
</div>

</body>
</html>
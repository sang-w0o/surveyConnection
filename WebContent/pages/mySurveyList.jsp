<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 설문 보기</title>

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
<script src="../script/myPage.js"></script>
<script src="../script/index.js"></script>
<script src="../script/login.js"></script>
<script src="../script/sendEmail.js"></script>
<script src="../script/changePass.js"></script>
<script src="../script/mysList.js"></script>
<script src="../script/mySurveyList.js"></script>
<script src="../script/topMenu.js"></script>
<link rel="stylesheet" href="../css/myPage.css">
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/sendEmail.css">
<link rel="stylesheet" href="../css/changePass.css">
<link rel="stylesheet" href="../css/mysList.css">
<link rel="stylesheet" href="../css/topMenu.css"> 
</head>
<body>
<body>
<div class="wrap">
	<div class="top">
		<div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
		<jsp:include page="topMenu.jsp"></jsp:include>
	</div>
	<div class="mid">
			<div id="content">
				<jsp:include page="mysList.jsp"></jsp:include> 
			</div>
			<div id="side">
				<div id="member">
					<c:choose>
					<c:when test='${result == null || result == false }'>
						<jsp:include page="login.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="myPage.jsp"></jsp:include>
					</c:otherwise>
					</c:choose>
				</div>
				<div id="changePass">
					<c:choose>
					<c:when test='${result == null || result == false }'>
						<jsp:include page="sendEmail.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="changePass.jsp"></jsp:include>
					</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	<div class="bottom">
		<div id="ad">광고 띄우기</div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>사이트 개요</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/siteInfo.js"></script>
<script src="../script/sendEmail.js"></script>
<script src="../script/changePass.js"></script>
<script src="../script/login.js"></script>
<script src="../script/myPage.js"></script>
<link rel="stylesheet" href="../css/siteInfo.css">
<link rel="stylesheet" href="../css/myPage.css">
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/sendEmail.css">
<link rel="stylesheet" href="../css/changePass.css">
<link rel="stylesheet" href="../css/topMenu.css">
</head>

<body>

	<div class="wrap">
		<div class="top">
			<div id="logo" onClick="location.href='index.jsp'">
				&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion
			</div>
			<jsp:include page="topMenu.jsp"></jsp:include>
		</div>
		<div class="mid">
			<div id="content">
				<div id="logo">
					&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion
				</div>
				<div id="images">
					<img src="../images/write.png" id="imgWrite"> 
					<img src="../images/upload.png" id="imgUpload"> 
					<img src="../images/respond.png" id="imgRespond"> 
					<img src="../images/result.png" id="imgResult">
				</div>
				<div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;VC(surVeyconneCtion)은 회원들이 설문을 등록하고</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;서로의 설문에참여함으로써 표본 수를 확보하는데 도움들 드립니다.</div>
				</div>
				<br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(1)작성하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은회원가입 또는 로그인 후 자신의 설문을 작성할 수 있습니다!</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;설문지의문항에는 단답형 또는 선택형의 종류가 있습니다.</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;설문 작성에 대한 정보는 "이용방법"을 확인하시기 바랍니다.</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(2)등록하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은작성한 설문을 등록할 수 있습니다!</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록된 설문은 다른회원들이 답변할 수 있습니다.</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록한 설문의 최대 표본 수 및 마감 기한 등의 정보는 "이용방법"을
						확인하시기 바랍니다.</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(3)답변하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은 타인의 설문지에 답변할 수 있습니다!</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(4)
						결과 보기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VC에서는
						설문이 마감되면, 해당 설문의 결과를  보기 쉽게 정리해드립니다.</div>
					<div style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="text-decoration:underline;">객관식 문항의 경우</span></div>
					<div style="font-size:14pt">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;해당 문항의 응답 결과를 보기 용이하도록 상이한 그래프의 형태로 보여드립니다.</div>
					<div style="font-size:15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<span style="text-decoration:underline;">주관식 문항의 경우</span></div>
					<div style="font-size:14pt">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;해당 문항의 응답 결과를 모두 하나의 표에 정리하여 보여드립니다.</div>
					<div style="font-size:9pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					(아래는 응답 결과의 예시입니다.)</div>
					<img src="../images/resultExample.png" style="width:800px; height:480px;">
				</div>
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
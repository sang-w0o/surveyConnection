<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="../css/siteInfo.css">
<title>Insert title here</title>
</head>

<body>

	<div class="wrap">
		<div class="top">
			<div id="logo" onClick="location.href='index.jsp'">
				&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion
			</div>
			<div id="menu">
				<ul>
					<li>|</li>
					<li>공지사항
						<ul>
							<li>사이트 소개</li>
							<li>이용방법</li>
						</ul>
					</li>
					<li>|</li>
					<li>설문
						<ul>
							<li>설문 작성</li>
							<li>설문 참여</li>
						</ul>
					</li>
				</ul>

			</div>
		</div>
		<div class="mid">
			<div id="content">
				<div id="logo">
					&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion
				</div>
				<div id="images">
					<img src="../images/write.png" id="imgWrite"> <img
						src="../images/upload.png" id="imgUpload"> <img
						src="../images/respond.png" id="imgRespond"> <img
						src="../images/result.png" id="imgResult">
				</div>
				<div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;VC(surVey
						conneCtion)은 회원들이 설문을 등록하고</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;서로의 설문에
						참여함으로써 표본 수를 확보하는데 도움들 드립니다.</div>
				</div>
				<br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(1)
						작성하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은
						회원가입 또는 로그인 후 자신의 설문을 작성할 수 있습니다!</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;설문지의
						문항에는 단답형 또는 선택형의 종류가 있습니다.</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;설문 작성에 대한 정보는 "이용방법"을 확인하시기 바랍니다.</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(2)
						등록하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은
						작성한 설문을 등록할 수 있습니다!</div>
					<div style="font-size: 15pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록된 설문은 다른
						회원들이 답변할 수 있습니다.</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록한 설문의 최대 표본 수 및 마감 기한 등의 정보는 "이용방법"을
						확인하시기 바랍니다.</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(3)
						답변하기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;회원은
						타인의 설문지에 답변할 수 있습니다!</div>
					<div style="font-size: 15pt">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VC에서는"<span
							style="font-size: 15pt; font-weight: bold">필터문항</span>"을 제공하여 답변을
						검증합니다.
					</div>
					<div style="font-weight: bold">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"필터문항"
						: 누구나 아는 기본적인 문제</div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--> 필터 문항에 오답을 기재한 사람은 설문에 성실하게 임하지
						않았다고 판단합니다.</div>
				</div>
				<br /> <br />
				<div>
					<div style="font-weight: bold; font-size: 20pt;">&nbsp;&nbsp;&nbsp;(4)
						결과 보기</div>
					<div style="font-size: 17pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VC에서는
						설문이 마감되면, 해당 설문의 결과를 보여드립니다.</div>
				</div>
			</div>
			<div id="side">
					<c:choose>
					<c:when test='${result == null || result == false }'>
						<jsp:include page="login.jsp"></jsp:include>
					</c:when>
					<c:otherwise>
						<jsp:include page="myPage.jsp"></jsp:include>
					</c:otherwise>
					</c:choose>
				</div>
		</div>
		<div class="bottom">
			<div id="ad">광고 띄우기</div>
		</div>
	</div>
</body>
</html>
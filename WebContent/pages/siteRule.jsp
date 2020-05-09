<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
	<div class="top">
		<div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
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
			<div id="content">content
				
			</div>
			<div id="side">
				<div id="member">
					<jsp:include page="login.jsp"></jsp:include>
				</div>
			</div>
		</div>
	<div class="bottom">
		<div id="ad">광고 띄우기</div>
	</div>
</div>
</body>
</html>
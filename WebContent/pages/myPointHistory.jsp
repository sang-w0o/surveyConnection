<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/myPointHistory.js"></script>
<link rel="stylesheet" href="../css/myPointHistory.css">
</head>
<body>
<div class="phwrap">
	<div class="pointHistory">
		<div class="phTop">포인트 사용 내역</div>
		<div class="phTitle">
			<ul>
				<li>사유</li>
				<li>포인트</li>
			</ul>
		</div>
		<div class="phCont">
			
			
		</div>
		<div id="total"></div>
		<div class="phBottom">
		
			<ul>
				<li>
					<button type="button" id="btnCancel" onclick="history.back(-1)">뒤로가기</button>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>
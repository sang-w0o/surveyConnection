<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 결과 보기</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/surveyResult.js"></script>
<link rel="stylesheet" href="../css/surveyResult.css">
<link rel="stylesheet" href="../css/subResult.css">
</head>
<body>
<div class="outwrap">
	<div class="resultwrap">
		<jsp:include page="sResult.jsp"></jsp:include>
	</div>
	<div class="subwrap">
		<jsp:include page="subResult.jsp"></jsp:include>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 작성하기</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/surveyForm.js"></script>
<link rel="stylesheet" href="../css/surveyForm.css">
</head>
<body>
<form method="post" action="SurveyInsert.do">
<div class="surwrap">
	<div class="sTop">
		<ul>
			<li id="writerInfo" data-writer="${userInfo.email}">작성자 : ${userInfo.nick } (${userInfo.email})</li>
			<li><input type="text" id="surveyName" placeholder="      제목을 입력 하세요.">
			<select id="selectBox">
				<option>김주성</option>
				<option>바보</option>
				<option>멍청이</option>
			</select></li>
			<li id="isPublic">설문 결과를 <label for="open"><input type="radio" id="open" name="open" value="Y" checked>공개</label>
			<label for="close"><input type="radio" id="close" name="open" value="N">비공개</label>&nbsp;&nbsp;&nbsp;합니다.</li>
		</ul>
	</div>
	<div class="sMid">
		<div class="questionCond">
			<ul>
				<li><label for="choice"><input type="radio" id="choice" name="questionType" value="C">객관식</label><label for="subjective"><input type="radio" id="subjective" name="questionType" value="S" checked>주관식</label></li>
				<li><button type="button" id="addQuestion" name="addQuestion">문항 추가</button></li>
				<li><button type="button" id="deleteQuestion" name="deleteQuestion">문항 삭제</button></li>
			</ul>
		</div>
		<div class="questionList">
				<ul id="cQTitle1">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion1"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle2" >
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion2"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle3">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion3"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle4">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion4"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle5">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion5"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle6">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion6"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle7">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion7"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle8">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion8"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle9">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion9"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용"></li>
				</ul>
				<ul id="cQTitle10">
					<li id="qt">
						<input type="text" placeholder="    문항 제목을 입력하세요" id="cQuestion10"></input>
						<button type="button" id="addChoice" value="2">선택지 추가</button>
						<button type="button" id="deleteChoice" value="2">선택지 삭제</button>
					</li>
					<li><input type="radio" id="choice_num1" name="choice_num" value="1"><input type="text" id="choice_content1" name="choice_content" placeholder="    선택지 내용 입력"></li>
					<li><input type="radio" id="choice_num2" name="choice_num" value="2"><input type="text" id="choice_content2" name="choice_content" placeholder="    선택지 내용 입력"></li>
					<li><input type="radio" id="choice_num3" name="choice_num" value="3"><input type="text" id="choice_content3" name="choice_content" placeholder="    선택지 내용 입력"></li>
					<li><input type="radio" id="choice_num4" name="choice_num" value="4"><input type="text" id="choice_content4" name="choice_content" placeholder="    선택지 내용 입력"></li>
					<li><input type="radio" id="choice_num5" name="choice_num" value="5"><input type="text" id="choice_content5" name="choice_content" placeholder="    선택지 내용 입력"></li>
				</ul>
		</div>
	</div>
	<div class="sBottom">
		<button type="button" id="SurveyReply">설문 제출</button>
		<button type="button" id="sBtnCancel" onclick="history.back(-1)">작성 취소</button>
	</div>
</div>
</form>
</body>
</html>
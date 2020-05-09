<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="surwrap">
	<div class="sTop">
		<ul>
			<li>작성자 : ${userInfo.nick }</li>
			<li><input type="text" id="surveyName" placeholder="      제목을 입력 하세요.">
			<select>
				<option>김주성</option>
				<option>바보</option>
				<option>멍청이</option>
			</select></li>
			<li>설문 결과를 <label for="open"><input type="radio" id="open" name="open" value="Y" checked>공개</label>
			<label for="close"><input type="radio" id="close" name="open" value="N">비공개</label>합니다.</li>
		</ul>
	</div>
	<div class="sMid">
		<div class="questionCond">
			<ul>
				<li><input type="radio" id="choice" name="questionType" value="C"><label for="choice">객관식</label><input type="radio" id="subjective" name="questionType" value="S"><label for="subjective">주관식</label></li>
				<li><button type="button" id="addQuestion" name="addQuestion">문항추가</button></li>
			</ul>
		</div>
		<div class="questionList">
			<div class="choiceQuestion">
				<ul>
					<li><textarea placeholder="    문항 제목을 입력하세요" id="cQuestion"></textarea><button type="button" id="addChoice"></button></li>
					<li><input type="radio" name=""></li>
				</ul>
			</div>
			<div class="subjectiveQuestio">
				<ul>
					<li><textarea placeholder="    문항 제목을 입력하세요" id="sQuesttion"></textarea></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="sBottom">
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="ctwrap">
	<div class="categories">
		<ul>
			<li><button type="button" name="category" value="MY">진행중인 내 설문</button></li>
			<li><button type="button" name="category" value="MY1">마감된 내 설문</button></li>
			<li><button type="button" name="category" value="inter">진행중인 관심 설문</button></li>
			<li><button type="button" name="category" value="inter1">마감된 관심 설문</button></li>
			<li><button type="button" name="category" value="phar">구매한 설문</button></li>
		</ul>
	</div>
	<div class="categorySurvey">
		<div class="cateTitle">
			<ul>
				<li>작성자</li>
				<li>설문제목</li>
				<li>관심수</li>
				<li>작성일자</li>
			</ul>
		</div>
		<div class="cateCont">
		</div>
		<div class="cateBottom">
			<ul>
				<li>
					<button type="button" id="btnFirst">처음</button>
					<button type="button" id="btnPrev">이전</button>
					<button type="button" id="btnNext">다음</button>
					<button type="button" id="btnLast">끝</button>
				</li>
			</ul>
		</div>
	</div>
</div>
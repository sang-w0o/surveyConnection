<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>사이트 이용 방법</title>
<script src="../script/jquery-3.5.0.min.js"></script>
<script src="../script/siteRule.js"></script>
<script src="../script/sendEmail.js"></script>
<script src="../script/changePass.js"></script>
<script src="../script/login.js"></script>
<script src="../script/myPage.js"></script>

<link rel="stylesheet" href="../css/siteRule.css">
<link rel="stylesheet" href="../css/myPage.css">
<link rel="stylesheet" href="../css/login.css">
<link rel="stylesheet" href="../css/sendEmail.css">
<link rel="stylesheet" href="../css/changePass.css">
<link rel="stylesheet" href="../css/topMenu.css">
</head>
<body>
<div class="wrap">
	<div class="top">
		<div id="logo">&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion</div>
		<jsp:include page="topMenu.jsp"></jsp:include>
	</div>
	<div class="mid">
			<div id="content">
				<div id="logo">
					&nbsp;&nbsp;&nbsp;sur<span>V</span>ey&nbsp;&nbsp;&nbsp;<br>conne<span>C</span>tion
				</div>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;VC는 회원들 끼리 서로의 설문에 답변하고, 설문을 올려 충분한 표본 수를 확보하는데 도움을 드리는 서비스 입니다.
				</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;무료로 이용하실 수 있는 서비스인 만큼, VC에서는 부적절한 회원을 가리기 위해 
				<span style="font-weight:bold; font-size:14pt">신고 시스템</span>을 도입했으며,</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;모든 회원에게는 <span style="font-weight:bold; font-size:14pt;">등급제도</span> 가 적용됩니다.
				또한 등급 제도에 따라 각각 상이한 조건들이 있습니다.</div>
				<br/>
				<div style="font-weight:bold; font-size:19pt; text-align:center;"> 등급 제도에 대한 설명</div>
				<br/>
				<div id="tblDiv">
					<table id ="tblInfo">
						<thead>
							<tr>
								<th>등급 및 등급 별 조건</th>
								<th>등급 유지 조건</th>
								<th>설문 표본 최대 인원</th>
								<th>설문 표본 최대 기간</th>
								<th>매달 지급되는 포인트</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>IRON</th>
								<td>없음</td>
								<td>30명</td>
								<td>7일</td>
								<td>10포인트</td>
							</tr>
							<tr>
								<th>BRONZE</th>
								<td>10회 이상</td>
								<td>50명</td>
								<td>14일</td>
								<td>30포인트</td>
							</tr>
							<tr>
								<th>SILVER</th>
								<td>20회 이상</td>
								<td>80명</td>
								<td>21일</td>
								<td>50포인트</td>
							</tr>
							<tr>
								<th>GOLD</th>
								<td>30회 이상</td>
								<td>100명</td>
								<td>28일</td>
								<td>70포인트</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="text-align:center; font-size:10pt;">+) 등급 유지 조건 : 해당 등급을 유지하기 위해 매달 다른 회원의 설문에 참여해야하는 횟수</div>
				<div style="text-align:center; font-size:10pt;">+) 매달 지급되는 포인트의 기준은 갱신 후의 등급 입니다.</div>
				<br/>
				<div style="font-weight:bold; font-size:19pt; text-align:center;"> 신고 시스템에 대한 설명</div>
				<br/>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VC에서의 신고 시스템에는 2가지의 경우가 있습니다.</div>
				<br/>
				<div style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;&nbsp;(1)응답자가 해당 설문 작성자를 신고하는 경우</div>			
				<br/>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;응답자는 설문 응답 도중 부적절하다는 문항이 있다고 판단될 시에, 해당 응답자를 신고할 수 있습니다.</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이 때, 신고자는 <span style="font-size:14pt; font-weight:bold">부적절한 문항 번호와 사유를 필수로 기재</span>해야 합니다.</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이러한 경우의 신고는 관리자가 <span style="font-size:14pt; font-weight:bold">승인 또는 반려</span>할 수 있습니다.</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-weight:bold; font-size:12pt;">승인 시 -></span>해당 신고가 인정되어 해당 설문의 작성자는 신고 누적 회수가 1회 증가합니다.</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-weight:bold; font-size:12pt;">반려 시 -></span>해당 신고는 무효 처리 됩니다.</div>
				<br/>
				<div style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;&nbsp;(2)필터 문항에 오답을 기재하는 경우</div>
				<br/>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;이 경우, 해당 응답자는 설문에 불성실하게 임한 것으로 판단되어 관리자의 개입 없이 신고 회수가 누적됩니다.</div>
				<br/>
				<div style="font-size:14pt; font-weight:bold;">&nbsp;&nbsp;&nbsp;&nbsp;**VC의 모든 회원은 1달 기준 신고 누적 횟수가 4회 이상이면 등급이 1단계 강등됩니다.**</div>
				<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;신고 누적 횟수는 매달 1일에 초기화됩니다.</div>
				
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

$(document).ready(function(){
	
	$('.login #signIn').bindLogin();
	$('.myPage #logOut').bindLogout();
	$('.myPage #btnWithdraw').bindWithdraw();
	$('.cpwrap #btnChange').bindChangePass();
	
	$('.cateBottom #btnFirst').bindGetFirst();
	$('.cateBottom #btnPrev').bindGetPrev();
	$('.cateBottom #btnNext').bindGetNext();
	$('.cateBottom #btnLast').bindGetLast();
	
	$('.categories > ul button').bindGetByCategory();
	
	$('.wrap>.top>#menu>ul>li:nth-child(2)>ul>li:first-child').click(function(){
		location.href = "siteInfo.jsp"
	})
	
	$('.wrap>.top>#menu>ul>li:nth-child(2)>ul>li:last-child').click(function(){
		alert("이용방법");
	})
	$('.wrap>.top>#menu>ul>li:last-child>ul>li:first-child').click(function(){
		alert("설문작성");
	})
	
	$('.wrap>.top>#menu>ul>li:last-child>ul>li:last-child').click(function(){
		alert("설문참여");
	})
	$(".wrap>.top>#logo").click(function(){
		location.href="index.jsp";
	})
	
})

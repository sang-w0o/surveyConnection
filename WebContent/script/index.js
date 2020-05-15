
$.checkIsRegisterable = function(){
	$.ajax({
		url:'../SurveyInsertCheck.do',
		type:'post',
		success:function(data){
			if(data.result){
				location.href = 'surveyForm.jsp'
			}
			else{
				alert(data.message);
			}
		}
	})
}

$(document).ready(function(){

	$('.login #signIn').bindLogin();
	$('.myPage #logOut').bindLogout();
	$('.myPage #btnWithdraw').bindWithdraw();
	$('.cpwrap #btnChange').bindChangePass();
	$('.myPage #showList').bindEnterMyPage();
	
	$(".wrap>.top>#logo").click(function(){
		location.href="index.jsp";
	})
	
})


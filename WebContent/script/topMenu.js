$.fn.bindRedirectSiteInfo = function(){
	$(this).on('click', (function(){
		location.href = 'siteInfo.jsp';
		})
	)
}

$.fn.bindRedirectSiteRule = function(){
	$(this).on('click', (function(){
		location.href = 'siteRule.jsp';
		})
	)
}

$.fn.bindWriteSurvey = function(){
	$(this).on('click', function(){
		$.ajax({
			url:'../MemberLoginCheck.do',
			type:'get',
			success:function(data){
				if(data.result){
					$.checkIsRegisterable();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$.fn.bindParticipateSurvey = function(){
	$(this).on('click', function(){
		$.ajax({
			url:'../MemberLoginCheck.do',
			type:'get',
			success:function(data){
				if(data.result){
					location.href = 'enterSurvey.jsp';
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$.fn.bindViewEndedSurvey = function(){
	$(this).on('click', function(){
		$.ajax({
			url:'../MemberLoginCheck.do',
			type:'get',
			success:function(data){
				if(data.result){
					location.href = 'closeSurvey.jsp';
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$(document).ready(function(){
	$('#viewSiteInfo').bindRedirectSiteInfo();
	$('#viewSiteRule').bindRedirectSiteRule();
	$('#writeSurvey').bindWriteSurvey();
	
	$('#participateSurvey').bindParticipateSurvey();
	
	$('#viewEndedSurvey').bindViewEndedSurvey();
})
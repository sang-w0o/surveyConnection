$.checkAdminAccess = function(){
	$.ajax({
		url:'../CheckAdminAccess.do',
		type:'post',
		success:function(data){
			if(!data.result){
				alert(data.message);
				location.href = 'index.jsp';
			}
			else{
				$.getAllReports();
			}
		}
	})
}

$.fn.bindViewSurvey = function(){
	this.click(function(){
		location.href = "responseSurvey.jsp?s_code=" + $(this).closest('ul').data('s_code') + 
		'&respondent=admin@surveypro.com';
	})
}

$.fn.updateAllGrades = function(){
	$(this).click(function(){
		$.ajax({
			url:'../UpdateAllMembers.do',
			type:'post',
			success:function(data){
				if(data.result){
					alert(data.message);
					location.reload();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$.getAllReports = function(){
	
	$.ajax({
		url:'../ReportGetAll.do',
		type:'get',
		success:function(data){
			$('.reCont ul').remove();
			for(let i = 0; i < data.reports.length; i++){
				let report = data.reports[i];
				let obj = $("<ul>" +
				"<li>" + report.reporter + "</li>" +
				"<li>" + report.reportedWriter + "</li>" + 
				"<li id ='cause'>" + report.cause + "</li>" + 
				"<li><button type='button' id='btnApprove' value='Y'>승인</button>" +
				"<button type='button' id='btnReturn' value='N'>반려</button></li></ul>");
				obj.data('s_code', report.s_code);
				$('.reCont').append(obj);
				obj.find('#cause').bindViewSurvey();
				obj.find('#btnApprove').bindBtnApprove();
				obj.find('#btnReturn').bindBtnRemove();
			}
		}
	})
}

$.fn.bindBtnApprove = function(){
	$(this).click(function(){
		console.log($(this).closest('ul').data('s_code'));
		
		$.ajax({
			url:'../ReportApprove.do',
			type:'post',
			data:{
				s_code : $(this).closest('ul').data('s_code')
			},
			success:function(data){
				if(data.result){
					alert(data.message);
					location.reload();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}
$.fn.bindBtnRemove = function(){
	$(this).click(function(){
		$.ajax({
			url:'../ReportRemove.do',
			type:'post',
			data:{
				s_code : $(this).closest('ul').data('s_code')
			},
			success:function(data){
				if(data.result){
					alert(data.message);
					location.reload();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}


$(document).ready(function(){
	
	$.checkAdminAccess();
	$('#btnGradeUpdate').updateAllGrades();

})
$.fn.bindReportClick = function(){
	this.click(function(){
		if($('.sTop > ul > li:nth-child(4)').css("display")=="none"){
			$('.sTop > ul > li:nth-child(4)').css("display","block");
		}
		else{
			$('.sTop > ul > li:nth-child(4)').css("display","none");
		}
	})
};

$.submitReport = function(){
	
	if($('#reportText').val().trim() == ''){
		alert('신고 사유는 필수 입력 사항입니다.');
		return;
	}
	$.ajax({
		url:'../ReportInsert.do',
		type:'post',
		data:{
			cause: $('#reportText').val(),
			reporter : $('.questionList').data('respondent'),
			s_code : $('.questionList').data('s_code')
		},
		success:function(data){
			alert(data.message);
			if(data.result){
				location.href = "index.jsp";
			}
		}
	})
}

$.fn.bindSubmitReport = function(){
	$(this).one('click', function(){
		$.ajax({
			url:'../ReportCheck.do',
			type:'post',
			data:{
				reporter : $('.questionList').data('respondent'),
				s_code : $('.questionList').data('s_code')
			},
			success:function(data){
				if(data.result){
					$.submitReport();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

$.addInterest = function(){
	$.ajax({
		url:'../InterestInsert.do',
		type:'post',
		data:{
			email: $('.questionList').data('respondent'),
			s_code : $('.questionList').data('s_code')
		},
		success:function(data){
			alert(data.message);
		}
	})
}

$.fn.bindAddInterest = function(){
	$(this).one('click', function(){
		$.ajax({
			url:'../InterestCheck.do',
			type:'post',
			data:{
				email: $('.questionList').data('respondent'),
				s_code : $('.questionList').data('s_code')
			},
			success:function(data){
				if(data.result){
					$.addInterest();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

function showResponseSurvey(s_code) {
	$.ajax({
		url: '../GetSurvey.do',
		type: 'post',
		data: {
			s_code: s_code
		},
		success: function(data) {
			if (data.errno != 0) {
				console.log(data.message);
				return;
			}
			
			let survey = data.survey;
			let s_code = survey.s_code;
		
			let li1 = $('<li>').text('작성자: '+survey.email);
			let li2 = $('<li>').text('카테고리: '+ data.c_desc);
			let li3 = $('<li>').text('제목: '+survey.s_title);
		
			$('#btnReport').closest('li').before(li1);
			$('#btnReport').closest('li').after(li2);
			$('#btnSubmitReport').closest('li').after(li3);
			
			showResponseQuestion(s_code);
		}
	});
}

function showResponseQuestion(s_code) {
	$.ajax({
		url: '../GetQuestion.do',
		type: 'post',
		data: {
			s_code: s_code
		},
		success: function(data) {
			if (data.errno != 0) {
				return;
			}
			for (let i = 0; i < data.list.length; i++) {
				
				let q = data.list[i];
				let s_code = q.s_code;
				let q_number = q.q_number;
				let q_title = q.q_title;
				let q_type = q.q_type;
				
				let li = $('<li>').text('질문' + q_number + '] ' + q_title);
				
				if (q_type == 'C') {
					let ul = $('<ul data-qType="C"></ul>');
					ul.data("q_number", q_number);
					ul.attr('id', 'choiceQ');
					ul.append(li);
					ul.appendTo($('.questionList'));
					showResponseChoice(s_code, q_number);
				}
				else {
					let ul = $('<ul data-qType="S"></ul>');
					ul.data("q_number", q_number);
					ul.attr('id', 'subjectiveQ');
					let li2 = $('<li>');
					let textarea = $('<textarea>');
					textarea.attr('id', 'sTypeRe');
					li2.append(textarea);
					ul.append(li);
					ul.append(li2);
					ul.appendTo($('.questionList'));
				}
			}
		}
	});
}

function showResponseChoice(s_code, q_number) {
	$.ajax({
		url: '../GetChoice.do',
		type: 'post',
		data: {
			s_code: s_code,
			q_number: q_number
		},
		success: function(data) {
			if (data.errno != 0) {
				return;
			}
			let ul = $('.questionList > ul:nth-child(' + q_number + ')');
			for (let i = 0; i < data.list.length; i++) {
				let q = data.list[i];
				let li = $('<li>');
				let label = $('<label><input type="radio" data-num="'+q.choice_num+'" name="choice'+q_number+'"> ' + q.choice_content + '</label>');
				li.append(label);
				ul.append(li);
			}
		}
	});
}

$.sendChoiceResult = function(){
	var choices = [];
	var q_numbers = [];
	let qList = $('.questionList').find('[id=choiceQ]');
	qList.each(function(index, item){
		if($(item).find('input[type=radio]:checked').data('num') != null){
			choices.push($(item).find('input[type=radio]:checked').data('num'));
		}
		q_numbers.push($(item).closest('ul').data('q_number'));
	})
	
	$.ajax({
		url:'../ChoiceResultInsert.do',
		type:'post',
		data:{
			choices:choices,
			s_code:$('.questionList').data('s_code'),
			respondent : $('.questionList').data('respondent'),
			q_numbers:q_numbers
		},
		success:function(data){
			if(data.result){
			}
			else{
				alert(data.message);
			}
		}
	})
}

$.sendSubjectiveResult = function(){
	var answers = [];
	var q_numbers = [];
	let qList = $('.questionList').find('[id=subjectiveQ]');
	qList.each(function(index, item){
		if($(item).find('textarea').val().trim() != ''){
			answers.push(($(item).find('textarea').val()));
		}
		q_numbers.push($(item).closest('ul').data('q_number'));
	})
	
	$.ajax({
		url:'../SubjectiveResultInsert.do',
		type:'post',
		data:{
			answers : answers,
			s_code:$('.questionList').data("s_code"),
			respondent: $('.questionList').data("respondent"),
			q_numbers : q_numbers
		},
		success:function(data){
			if(data.result){
				
			}
			else{
				alert(data.message);
			}
		}
	})
	
}
$.sendResult = function(){
	
	var answers = [];
	var s_q_numbers = [];
	let s_qList = $('.questionList').find('[id=subjectiveQ]');
	s_qList.each(function(index, item){
		if($(item).find('textarea').val().trim() != ''){
			answers.push(($(item).find('textarea').val()));
		}
		s_q_numbers.push($(item).closest('ul').data('q_number'));
	})
	var choices = [];
	var c_q_numbers = [];
	let c_qList = $('.questionList').find('[id=choiceQ]');
	c_qList.each(function(index, item){
		if($(item).find('input[type=radio]:checked').data('num') != null){
			choices.push($(item).find('input[type=radio]:checked').data('num'));
		}
		c_q_numbers.push($(item).closest('ul').data('q_number'));
	})
	
	if((s_q_numbers.length != answers.length) || (c_q_numbers.length != choices.length)){
		alert('모든 문항에 응답하셔야 제출이 가능합니다.');
		return;
	}
	
	if((s_qList.length != 0) && (c_qList.length != 0)){
		$.sendSubjectiveResult();
		$.sendChoiceResult();
		$.submitToPointHistory();
	}
	else if((s_qList.length == 0) && (c_qList.length != 0)){
		$.sendChoiceResult();
		$.submitToPointHistory();
	}
	else if((s_qList.length != 0) && (c_qList.length == 0)){
		$.sendSubjectiveResult();
		$.submitToPointHistory();
	}
	
	
}

$.submitToPointHistory = function(){
	$.ajax({
		url:'../PointHistoryInsertRespondent.do',
		type:'post',
		data:{
			s_code : $('.questionList').data('s_code'),
			respondent : $('.questionList').data('respondent')
		},
		success:function(data){
			if(data.result){
				alert('응답 결과가 제출되었습니다.');
				$.updatePrice();
			}
			else{
				alert(data.message);
			}
		}
	})
}

$.updatePrice = function(){
	$.ajax({
		url:'../SurveyPriceUpdate.do',
		type:'post',
		data:{
			s_code:$('.questionList').data('s_code')
		},
		success:function(data){
			if(data.result){
				location.href = 'index.jsp';
			}
			else{
				alert(data.message);
			}
		}
	})
}

$(document).ready(function(){
	$('#btnReport').bindReportClick();
	$('#btnSubmitReport').bindSubmitReport();
	$('#btnInterest').bindAddInterest();
	
	var address = unescape(location.href);
	console.log(address);
	var loc_s_code = address.indexOf('s_code', 0);
	var loc_respondent = address.indexOf('respondent', 0);
	var s_code = '';
	var respondent = '';

	if (loc_s_code != -1) {
		tmp1 = address.substring(loc_s_code);
	}
	
	if (loc_respondent != -1) {
		tmp2 = address.substring(loc_respondent);
	}

	var arr1 = tmp1.split('&');
	var arr2 = arr1[0].split('=');
	s_code = arr2[1];
	
	var arr3 = tmp2.split('=');
	respondent = arr3[1];
	$('.questionList').data("respondent", respondent);
	$('.questionList').data("s_code", s_code);
	showResponseSurvey(s_code);
	
	$('#surBtnReply').click(function(){
		$.sendResult();
	})
});
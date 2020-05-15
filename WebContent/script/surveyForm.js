var queNum=0;
var MAX_QUE=11;
var MAX_CHO=7;
var MIN_QUE=0;
var MIN_CHO=2;

$.fn.bindAddClick=function(){
	
	$('.sMid>.questionList #addChoice').click(function(){
		let a = $(this).val();
		let ul = $(this).closest('li').closest('ul');
		console.log("추가:"+a);
		$(ul).find("li:nth-child("+a+")>input").css("display","inline-block");
		$(ul).find("li:nth-child("+a+")>input").attr("check", "true");
		
		console.log("추가:"+a);
		++a;
		$(this).val(a>MAX_CHO?MAX_CHO:a);
		$(this).siblings('button#deleteChoice').val(a>MAX_CHO?MAX_CHO:a);
		
	})
	
	$('.sMid > .questionCond #addQuestion').click(function(){
		
		if(++queNum >=11){
			queNum = MAX_QUE;
			alert("문항의 최대 개수는 "+(queNum-1)+"개 입니다.")
			return;
		}
		console.log("추가"+queNum);
		$(".surwrap>.sMid>.questionList>ul:nth-child("+queNum+")").css("display","inline-block");
		
		$(".questionList>ul:nth-child("+queNum+")>li#qt").css("display","inline-block");
		$(".questionList>ul:nth-child("+queNum+")>li#qt>input").css("display","inline-block");
		
		if($('.sMid>.questionCond>ul>li input:checked').val() == "C"){
			$(".questionList>ul:nth-child("+queNum+")>li>button").css("display","inline-block");
			
			let input = $(".questionList>ul:nth-child("+queNum+")>li#qt>input");
			input.attr("checkType", "C");
		}		
		else{
			$(".questionList>ul:nth-child("+queNum+")>li>button").css("display","none");
			
			let input = $(".questionList>ul:nth-child("+queNum+")>li#qt>input");
			input.attr("checkType", "S");
		}
		
		
		
	})
}
$.fn.bindDeleteClick=function(){
	$('.sMid>.questionList #deleteChoice').click(function(){
		let a = $(this).val()-1 < 2 ? 2 : $(this).val()-1 ;
		let ul = $(this).closest('li').closest('ul');
		console.log("삭제:"+a);
		$(ul).find("li:nth-child("+a+")>input").css("display","none");
		$(ul).find("li:nth-child("+a+")>input").removeAttr("check");
		console.log("삭제:"+a);
		$(this).val(a);
		$(this).siblings('button#addChoice').val(a);
	})
	$('.sMid > .questionCond #deleteQuestion').click(function(){
		
		if (queNum == 0) {
			alert("삭제 할 문항이 존재하지 않습니다.");
			return;
		}
		
		console.log("삭제"+queNum);
		$(".questionList>ul:nth-child("+queNum+")>li>button").css("display","none");
		$(".questionList>ul:nth-child("+queNum+")>li#qt>input").css("display","none");
		$(".questionList>ul:nth-child("+queNum+")>li>input").css("display","none");
		$(".questionList>ul:nth-child("+queNum+")>li#qt").css("display","none");
		$(".surwrap>.sMid>.questionList>ul:nth-child("+queNum+")").css("display","none");
		
		let input = $(".questionList>ul:nth-child("+queNum+")>li#qt>input");
		input.removeAttr("checkType");
		
		if(--queNum <= 0){
			queNum = MIN_QUE;
		};
	})
}

$.getCategoryList = function(){
	$('#selectBox option').remove();
	$.ajax({
		url:'../CategoryGetAll.do',
		type:'get',
		success:function(data){
			console.log(data);
			for(let i = 0; i < data.categories.length; i++){
				let category = data.categories[i];
				let obj = $('<option/>' + 
				category.c_desc + '</option>');
				obj.data("c_code", category.c_code)
				$('#selectBox').append(obj);
			}
		}
	})
}

$.fn.bindSurveySubmit = function(){
	
	this.click(function(){
		if(queNum == 0){
			alert('문항이 최소 1개 이상이어야 제출 가능합니다.');
			return;
		}
		$.ajax({
			url:'../SurveyInsert.do',
			type:'post',
			async: false,
			data:{
				s_title:$('#surveyName').val(),
				email: $('#writerInfo').data('writer'),
				c_code: $('#selectBox option:selected').data('c_code'),
				s_public: $('input[name=open]:checked').val()
			},
			success:function(data){
				if(data.result){
					questionSubmit(data.s_code);
					alert(data.message);
					location.href = "index.jsp";
				}
				else{
					alert(data.message);
					location.reload();
				}
			}
			
		})
	})
}

function questionSubmit(s_code) {
	var qArr = [];
	var qArrType = [];
	let qList = $('.questionList>ul>li:first-child>input:first-child');
	qList.each(function(index, item) {
		let flag = $(item).attr('style');
		if (flag == 'display: inline-block;') {
			qArr.push($(item).val());
			qArrType.push($(item).attr('checkType'));
		}
	});

	$.ajax({
		url: '../QuestionInsert.do',
		type: 'post',
		async: false,
		data: {
			qList: qArr,
			qListType: qArrType,
			s_code: s_code
		},
		success: function(data) {
			console.log(data.message);
			choiceSubmit();
		}
	});
}

function choiceSubmit() {
	var finalArr = [];
	let qList = $('.questionList>ul>li:first-child>input:first-child');
	console.log(qList.length);
	qList.each(function(index, item) {
		let flag1 = $(item).attr('checkType');
		var q_number = index + 1;
		if (flag1 == 'C') {
			var tmpArr = [];
			tmpArr.push(q_number);
			
			let lis = $(item).closest('li').siblings('li');
			lis.each(function(index, item) {
				console.log(lis.length);
				let input = $(item).find('input').last();
				let flag2 = $(input).attr('check');
				if (flag2 == 'true') {
					console.log($(input).val());
					tmpArr.push($(input).val());
				}
			});
			finalArr.push(tmpArr);
		}
	});
	
	for (let i = 0; i < finalArr.length; i++) {
		$.ajax({
			url: '../ChoiceInsert.do',
			type: 'post',
			async: false,
			data: {
				choiceList: finalArr[i]
			},
			success: function(data) {
				console.log(data);
			}
		});
	}
}



$(document).ready(function(){
	$.getCategoryList();
	$('.sMid>.questionCond #addQuestion').bindAddClick();
	$('.sMid>.questionCond #deleteQuestion').bindDeleteClick();
	$('#SurveyReply').bindSurveySubmit();
	
})
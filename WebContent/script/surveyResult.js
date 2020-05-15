$.fn.bindResultClick = function(){
	this.click(function(){
		console.log($(this).closest('ul').attr("id"));
		$('.subjectiveR').find('ul').css('display',"none");
		$('.subjectiveR').find('ul#'+$(this).closest('ul').attr("id")+'').css("display","block");
		$('#subTitle').css("display","block");
		$('.subjectiveR').css("display","block");
	})
}

$.loadSurvey = function(){
	var address = unescape(location.href);
	var loc = address.indexOf("?",1);
	var s_code = '';
	if (loc != -1) {
		str = address.substring(loc);
		var arr1 = str.split('&');
		var arr2 = arr1[0].split('=');
		s_code = arr2[1];
	}
	$.ajax({
		url:'../QuestionResultGet.do',
		type:'post',
		data:{
			s_code: s_code
		},
		success:function(data){
			let ult = $('<ul/>').appendTo(".resultTop");
			$('<li>작성자 : '+data.email+'</li>').appendTo(ult);
			$('<li>카테고리 : '+data.category+'</li>').appendTo(ult);
			$('<li>참여자 수 : '+data.sample+'</li>').appendTo(ult);
			$('<li>제목 : '+data.title+'</li>').appendTo(ult);
			
			for(let i = 0 ; i < data.list.length ; i ++){
				let ulm = $('<ul id="q'+i+'"data-qType="'+data.list[i].q_type+'"/>')
				let li = $('<li>문제] '+data.list[i].q_title+'</il>');
				
				if(data.list[i].q_type == "C"){	
					for(let key in data.list[i].choices){
						$('<li>'+key+' : <div id="graph" style="width:'+(400*( data.list[i].choices[key] < 0 || data.sample < 0 ? 0 : data.list[i].choices[key]/data.sample))+'px;"></div> <div id="number">'+data.list[i].choices[key]+'</div></li>')
						.appendTo(ulm);
					}
				}
				else{
					$(ulm).bindResultClick();
					let uls = $('<ul id="q'+i+'">').appendTo('.subjectiveR');
					for(let key in data.list[i].subjectives){
						$('<li>'+data.list[i].subjectives[key]+'</li>').appendTo(uls);
					}
				}
				$(ulm).appendTo(".resultMid");
				$(li).prependTo(ulm);
			}
			//이메일 카테고리 참여자수 설문이름
		}
	})
}

$.checkViewable = function(){
	var address = unescape(location.href);
	var loc = address.indexOf("?",1);
	var s_code = '';
	if (loc != -1) {
		str = address.substring(loc);
		var arr1 = str.split('&');
		var arr2 = arr1[0].split('=');
		s_code = arr2[1];
	}
	$.ajax({
		url:'../CheckResultView.do',
		type:'post',
		data:{
			s_code:s_code
		},
		success:function(data){
			if(data.result){
				$.loadSurvey();
			}
			else{
				alert(data.message);
				location.href = 'index.jsp';
			}
		}
		
	})
}

$(document).ready(function(){
	$.checkViewable();
	$('.resultMid > ul > li').bindResultClick();
})

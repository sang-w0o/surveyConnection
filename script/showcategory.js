var gPage = 1;
$.fn.bindGetByCategory = function(){
	this.click(function(){
		let clicked_c_code = $(this).val();
		$('.cateCont ul').remove();
		$.ajax({
			url:'../SurveyGetByCategory.do',
			type:'get',
			data:{
				page:gPage,
				c_code:clicked_c_code
			},
			success:function(data){
				for(let i = 0 ;i < data.surveys.length; i++){
					let survey = data.surveys[i];
					let obj = $('<ul>' + 
					'<li>' + survey.writer + '</li>' +
					'<li>' + survey.s_title + '</li>' +
					'<li>' + survey.interest_count + '</li>' +
					'<li>' + survey.written_date + '</li>' +
					'</ul>');
					obj.data('survey', survey);
					$('.cateCont').append(obj);
				}
				$('.cateBottom #btnNext').val(clicked_c_code);
				$('.cateBottom #btnFirst').val(clicked_c_code);
				$('.cateBottom #btnPrev').val(clicked_c_code);
				$('.cateBottom #btnLast').val(clicked_c_code);
				gPage = data.page;
			}
		})
	})
}

$.fn.bindGetNext = function(){
	this.click(function(){
		$('.cateCont ul').remove();
		$.ajax({
			url:'../SurveyGetByCategory.do',
			type:'get',
			data:{
				mode:"next",
				c_code:$('.cateBottom #btnNext').val(),
				page:gPage
			},
			success:function(data){
				for(let i = 0 ;i < data.surveys.length; i++){
					let survey = data.surveys[i];
					let obj = $('<ul>' + 
					'<li>' + survey.writer + '</li>' +
					'<li>' + survey.s_title + '</li>' +
					'<li>' + survey.interest_count + '</li>' +
					'<li>' + survey.written_date + '</li>' +
					'</ul>');
					obj.data('survey', survey);
					$('.cateCont').append(obj);
				}
				gPage = data.page;
			}
		})
	})
}

$.fn.bindGetPrev = function(){
	this.click(function(){
		$('.cateCont ul').remove();
		$.ajax({
			url:'../SurveyGetByCategory.do',
			type:'get',
			data:{
				mode:"prev",
				c_code:$('.cateBottom #btnPrev').val(),
				page:gPage
			},
			success:function(data){
				for(let i = 0 ;i < data.surveys.length; i++){
					let survey = data.surveys[i];
					let obj = $('<ul>' + 
					'<li>' + survey.writer + '</li>' +
					'<li>' + survey.s_title + '</li>' +
					'<li>' + survey.interest_count + '</li>' +
					'<li>' + survey.written_date + '</li>' +
					'</ul>');
					obj.data('survey', survey);
					$('.cateCont').append(obj);
				}
				gPage = data.page;
			}
		})
	})
}

$.fn.bindGetFirst = function(){
	this.click(function(){
		$('.cateCont ul').remove();
		$.ajax({
			url:'../SurveyGetByCategory.do',
			type:'get',
			data:{
				mode:"first",
				c_code:$('.cateBottom #btnFirst').val()
			},
			success:function(data){
				for(let i = 0 ;i < data.surveys.length; i++){
					let survey = data.surveys[i];
					let obj = $('<ul>' + 
					'<li>' + survey.writer + '</li>' +
					'<li>' + survey.s_title + '</li>' +
					'<li>' + survey.interest_count + '</li>' +
					'<li>' + survey.written_date + '</li>' +
					'</ul>');
					obj.data('survey', survey);
					$('.cateCont').append(obj);
				}
				gPage = 1;
			}
		})
	})
}

$.fn.bindGetLast = function(){
	currentPage = 10000;
	this.click(function(){
		$('.cateCont ul').remove();
		$.ajax({
			url:'../SurveyGetByCategory.do',
			type:'get',
			data:{
				mode:"last",
				c_code:$('.cateBottom #btnLast').val()
			},
			success:function(data){
				for(let i = 0 ;i < data.surveys.length; i++){
					let survey = data.surveys[i];
					let obj = $('<ul>' + 
					'<li>' + survey.writer + '</li>' +
					'<li>' + survey.s_title + '</li>' +
					'<li>' + survey.interest_count + '</li>' +
					'<li>' + survey.written_date + '</li>' +
					'</ul>');
					obj.data('survey', survey);
					$('.cateCont').append(obj);
				}
				gPage = data.page;
			}
		})
	})
}

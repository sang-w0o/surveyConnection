function showList() {
	
	$.ajax({
		url: '../SurveyGetSurveyInfo.do',
		type: 'post', 
		data: {
			msg: 'deadLine'
		},
		success: function(data) {
			for (let i = 0; i < data.list.length; i++) {
				let sInfo = data.list[i];
				let obj = 
					$('<ul>' +
					'<li>' + sInfo.writer + '</li>' +
					'<li>' + sInfo.s_title + '</li>' +
					'<li>' + sInfo.interest_count + '</li>' +
					'<li>' + sInfo.written_date + '</li>' +
					'<li>' + sInfo.end_date + '</li>' +							
					'</ul>');
				$(obj).appendTo('.deadLineCon');
			}
		}
	});

	$.ajax({
		url: '../SurveyGetSurveyInfo.do',
		type: 'post', 
		data: {
			msg: 'spareSampleNum'
		},
		success: function(data) {
			for (let i = 0; i < data.list.length; i++) {
				let sInfo = data.list[i];
				let obj = 
					$('<ul>' +
					'<li>' + sInfo.writer + '</li>' +
					'<li>' + sInfo.s_title + '</li>' +
					'<li>' + sInfo.interest_count + '</li>' +
					'<li>' + sInfo.written_date + '</li>' +
					'<li>' + sInfo.spare_sample_num + '</li>' +							
					'</ul>');
				$(obj).appendTo('.lowSampleCon');
			}
		}
	});

	$.ajax({
		url: '../SurveyGetSurveyInfo.do',
		type: 'post', 
		data: {
			msg: 'endSurvey'
		},
		success: function(data) {
			for (let i = 0; i < data.list.length; i++) {
				let sInfo = data.list[i];
				let obj = 
					$('<ul>' +
					'<li>' + sInfo.writer + '</li>' +
					'<li>' + sInfo.s_title + '</li>' +
					'<li>' + sInfo.interest_count + '</li>' +
					'<li>' + sInfo.written_date + '</li>' +
					'<li>' + sInfo.price + '</li>' +							
					'</ul>');
				$(obj).appendTo('.closeSurveyCon');
			}
		}
	});
	
}

$(document).ready(function() {
	showList();
});


	
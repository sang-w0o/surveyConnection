$.getClosedSurveyList = function() {
	$.ajax({
		url:'../SurveyGetClosedList.do',
		type:'post',
		success:function(data){
			if(!data.result){
				alert(data.message);
				return;
			}
			
			for (let i = 0; i < data.endSurveyList.length; i++) {
				let sInfo = data.endSurveyList[i];
				if(sInfo.spare_sample_num == null){
					sInfo.spare_sample_num = 0;
				}
				let obj = 
					$("<ul>" +
					"<li>" + sInfo.writer + "</li>" +
					"<li>" + sInfo.s_title + "</li>" +
					"<li>" + sInfo.c_desc + "</li>" +
					"<li>" + sInfo.spare_sample_num + "</li>" +
					"<li id='price'>" + sInfo.price + "</li>" +
					"<li><button type='button' id='btnPurchase" + i + "'>구매하기</button></li>" +
					"</ul>");
				
				$(obj).data('s_code', sInfo.s_code);
				$(obj).data('respondent', data.respondent);
				$(obj).find('button').data('writer_email', sInfo.email);
				$(obj).find('button').data('price', sInfo.price);
				$(obj).find('button').bindPurchaseClick();
				$(obj).appendTo('.cateCont');
			}	
		}
	})
}

$.fn.bindPurchaseClick = function(){
	this.click(function(){
		
		$.ajax({
			url:'../BuyAndSell.do',
			type:'post',
			data:{
				s_code : $(this).closest('ul').data('s_code'),
				buyer : $(this).closest('ul').data('respondent'),
				seller : $(this).data('writer_email'),
				price : $(this).data('price')
			},
			success : function(data){
				if(data.result){
					alert("구매에 성공했습니다.\n'내 설문 보기'의 '구매한 설문 보기'에서 확인하시기 바랍니다.");
					console.log('구매 버튼 누른 후 Update( )호출');
					location.reload();
				}
				else{
					alert(data.message);
				}
			}
		})
	})
}

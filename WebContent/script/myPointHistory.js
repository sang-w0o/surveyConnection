function showPointList(){
	var address = unescape(location.href);
	var loc = address.indexOf("?",1);
	var email = '';
	if (loc != -1) {
		str = address.substring(loc);
		var arr1 = str.split('=', 2);
		email = arr1[1];

		
	}
	$.ajax({
		url:"../PointHistoryGetList.do",
		type:'post',
		data:{
			email:email
		},
		success:function(data){
			$("<span>총 포인트 : "+ data.totalPoint +"</span>").appendTo($('#total'));
			for(let i=0;i<data.list.length;i++){
				let ul = $('<ul/>').appendTo($('.phCont'));
				let type = data.list[i].ph_type;
				switch(type){
					case "S":
						$('<li>"'+data.list[i].s_title+'" 설문 판매</li>').appendTo($(ul));
						$('<li>'+data.list[i].pointchange+'</li>').appendTo($(ul));
						break;
					case "B":
						$('<li>"'+data.list[i].s_title+'" 설문 구매</li>').appendTo($(ul));
						$('<li>'+data.list[i].pointchange+'</li>').appendTo($(ul));
						break;
					case "P":
						$('<li>"'+data.list[i].s_title+'" 설문 참여</li>').appendTo($(ul));
						$('<li>'+data.list[i].pointchange+'</li>').appendTo($(ul));
						break;
					case "A":
						$('<li>등급 갱신으로 인한 포인트 지급</li>').appendTo($(ul));
						$('<li>'+data.list[i].pointchange+'</li>').appendTo($(ul));
						break;
				}
			}
		}
	})
}


$(document).ready(function(){
	showPointList();
})

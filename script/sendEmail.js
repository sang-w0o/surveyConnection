$.fn.bindSendEmail = function(){ 
	this.click(function(){
		if($('.sendwrap #tempPassEmail').val().trim() == ''){
			alert('비밀번호를 찾을 이메일을 입력해주세요.');
			return;
		}
		alert('임시 비밀번호 전송 알림창이 뜰 때 까지 잠시만 기다려 주세요...');
		$.ajax({
			url:'../SendTempPass.do',
			type:'post',
			data:{
				email:$('.sendwrap #tempPassEmail').val()
			},
			success:function(data){
				alert(data.message);
				$('.mid>#side>#changePass').css("display","none");	
				location.reload();
			}
		})
	})
}

$.fn.bindSendEmailCancel = function(){
	this.click(function(){
		$('.mid > #side > #changePass').css('display','none');
	})
}

$(document).ready(function(){
	$('.sendwrap #btnSend').bindSendEmail();
	$('.sendwrap #btnCancel').bindSendEmailCancel();
})
$.fn.bindChangePass = function(){
	
	this.click(function(){
		
		if($('.cpwrap #cpass1').val().trim() == ''){
			alert('변경할 비밀번호를 입력하세요.');
			$('.cpwrap #cpass1').val('').focus();
			return;
		}
		if($('.cpwrap #cpass2').val().trim() == ''){
			alert('변경할 비밀번호의 확인란을 입력하세요.');
			$('.cpwrap #cpass2').val('').focus();
			return;
		}
		if($('.cpwrap #cpass1').val() != $('.cpwrap #cpass2').val()){
			alert('변경할 비밀번호가 일치하지 않습니다.');
			$('.cpwrap #cpass2').val('');
			$('.cpwrap #cpass1').val('').focus();
			return;
		}
		
		$.ajax({
			url:'../MemberPassChange.do',
			type:'post',
			data:{
				changepass:$('.cpwrap #cpass1').val()
			},
			success:function(data){
				alert(data.message);
				$('.cpwrap #btnCancel').trigger('click');
				location.reload();
			}
		})
	
		})
	}



$(document).ready(function(){
	$('.cpwrap #btnCancel').click(function(){
		$('.mid>#side>#changePass').css("display","none");
	})
	
})
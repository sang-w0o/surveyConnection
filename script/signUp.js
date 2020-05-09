var isEmailChecked = false;
var isNickChecked = false;

String.prototype.isMail = function(){
	return new RegExp('^[a-z][a-z0-9_.]{1,20}@[a-z0-9_]{3,20}\.((com|net|gov)|((co|pe|ne|go|ac)\.(kr|en|cn|jp)))$', 'ig').test(this);
}

$.fn.btnRegisterClick = function(){
	$(this).on('click', function(){
		if($('#email').val() == ''){
			alert('이메일을 입력하세요.');
			$('#email').val('').focus();
			return;
		}
		if($('#nick').val() == ''){
			alert('별명을 입력하세요.');
			$('#nick').val('').focus();
			return;
		}
		if($('#pass1').val() == ''){
			alert('비밀번호를 입력하세요.');
			$('#pass1').val('').focus();
			return;
		}
		if($('#pass2').val() == ''){
			alert('비밀번호 확인란을 입력하세요.');
			$('#pass2').val('').focus();
			return;
		}
		if($('#pass1').val() != $('#pass2').val()){
			alert('비밀번호가 일치하지 않습니다.');
			$('#pass2').val('');
			$('#pass1').val('').focus();
			return;
		}
		if(!isEmailChecked){
			alert('이메일 중복 확인을 해주세요.');
			$('#email').focus();
			return;
		}
		if(!isNickChecked){
			alert('별명 중복 확인을 해주세요.');
			$('#nick').focus();
			return;
		}
		$.ajax({
			url:'../MemberInsert.do',
			type:'post',
			data:{
				email:$('#email').val(),
				nick:$('#nick').val(),
				pass1:$('#pass1').val(),
				pass2:$('#pass2').val()
			},
			success:function(data){
				alert(data.message);
				if(data.result){
					$('#btnCancel').trigger('click');
				}
				else{
					$('#btnRegister').btnRegisterClick();
				}
			}
		})
	})
}

$.fn.btnCheckEmailClick = function(){
	$(this).on('click', function(){
		if($('#email').val() == ''){
			alert('이메일을 입력하세요.');
			$('#email').val('').focus();
			return;
		}
		if(!$('#email').val().isMail()){
			alert('올바른 이메일 형식이 아닙니다.');
			$('#email').val('').focus();
			return;
		}
		$.ajax({
			url:'../MemberEmailCheck.do',
			type:'post',
			data:{
				email:$('#email').val(),
			},
			success:function(data){
				alert(data.message);
				if(data.result){
					$('#nick').focus();
					isEmailChecked = true;
				}
				else{
					$('#email').val('').focus();
				}
			}
		})
	})
}

$.fn.btnCheckNickClick = function(){
	$(this).on('click', function(){
		if($('#nick').val() == ''){
			alert('별명을 입력하세요.');
			$('#nick').val('').focus();
			return;
		}
		$.ajax({
			url:'../MemberNickCheck.do',
			type:'post',
			data:{
				nick:$('#nick').val(),
			},
			success:function(data){
				alert(data.message);
				if(data.result){
					$('#pass1').focus();
					isNickChecked = true;
				}
				else{
					$('#nick').val('').focus();
				}
			}
		})
	})
}


$(document).ready(function(){
	$('.wrap>.signUp>#logo').click(function(){
		location.href="index.jsp";
	})
	
	
	$('#btnCheckEmail').btnCheckEmailClick();
	$('#btnCheckNick').btnCheckNickClick();
	$('#btnRegister').btnRegisterClick();
	
	
})
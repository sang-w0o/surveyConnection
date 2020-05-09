
$.fn.bindLogin = function() {
		
	this.click(function(){
		if($('#email').val().trim() == '') {
			alert('이메일을 입력하세요.');
			$('#email').val('').focus();
			return;
		}
		
		if($('#pass').val().trim() == '') {
			alert('비밀번호를 입력하세요.');
			$('#pass').val('').focus();
			return;
		}
				
		$.ajax({
			url: '../Login.do',
			type: 'post',
			data: {
				email: $('#email').val(),
				pass: $('#pass').val()
			},
			success: function(data) {
				alert(data.message);
				location.reload();
			}
		});
	});	
}

$(document).ready(function(){
	$('div.login button#signUp').click(function(){
		location.href='signUp.jsp';
	});
	
	$('.login #findPass').click(function(){
		$('.mid > #side > #changePass').css('display', 'block');
	})
	

})


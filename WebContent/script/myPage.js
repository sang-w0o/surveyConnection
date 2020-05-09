$.fn.bindLogout = function() {
		
		this.click(function(){
			$.ajax({
				url: '../Logout.do',
				type: 'post',
				success: function(data) {
					// 로그아웃 성공
					if (data.errno == 0) {
						alert(data.message);
						location.reload();
					}
					// 로그아웃 실패
					else {
						alert(data.message);
					}
				}
			});
		});		
	}
	
	$.fn.bindWithdraw = function(){
		
		this.click(function(){
			if(confirm('탈퇴 후 30일동안은 재가입 하실 수 없습니다.\n정말 탈퇴 하시겠습니까?')){
			
				let password = prompt("비밀번호를 입력해 주세요.");
				$.ajax({
					url:'../MemberWithdrawInsert.do',
					type:'post',
					data:{
						pass:password
					}	
				}).done(function(data){
						alert(data.message);
						location.reload();
				});
			}
		});
		
	}
	
$(document).ready(function(){
	$('.myPage #changePass').click(function(){
		$('.mid > #side > #changePass').css('display' ,'block');
	})
})
	
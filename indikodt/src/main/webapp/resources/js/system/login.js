var login = new function() {

	var that = this;

	/**=====================================================
	| 최초 실행 이벤트
	*=====================================================*/
	that.init = function() {
		/*-------------
		 | 이벤트 선언.
		 ------------*/
		// 아이디 Enter 이벤트
		$('#id').keypress(function() {
			if(event.keyCode==13)that.focusDown()
		});
		// 비밀번호 Enter 이벤트
		$('#pw').keypress(function() {
			if(event.keyCode==13)that.login()
		});
		// 비밀번호 Enter 이벤트
		$('#loginBtn').click(function() {
			if(isNull($('#id').val())){
				alert("아이디를 입력해주세요.");
				$('#id').focus();
				return;
			}
			if(isNull($('#pw').val())){
				alert("비밀번호를 입력해주세요.");
				$('#pw').focus();
				return;
			}
			that.login();
		});


	},
	that.focusDown = function(){
		$('#pw').focus();
	},
	that.login = function(){

		//로그인 유효성 검사.
		$.ajax ({
			url : Dns +"/login/loginChk.do",
			type : "post",
			dataType : "json",
			data : {id : $("#id").val() , pwd : $("#pw").val() ,chk : $("#saveId").val()},
			error : function() {
				alert("현재 서비스가 원할하지 않습니다.\n 잠시후 다시 이용해 주십시요.");
				return;
			},
			success: function(r) {
				if(r.result=="true"){
					$('#loginFrm').attr('method', 'post');
					$('#loginFrm').attr('action', Dns + '/main.do');
					$('#loginFrm').submit();
				}else{
					alert(r.message);
				}
			}
		});

	}

};

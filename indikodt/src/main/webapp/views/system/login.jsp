<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="kr">
<head>
<jsp:include page="../layout/header.jsp" flush="true"/>
<script type="text/javascript" src="../../../resources/js/system/login.js"></script>
	<%
		Cookie[] cookie = request.getCookies();
		String userId = "";
		if(cookie != null){
			for(int i = 0; i<cookie.length;i++){
				if(cookie[i].getName().trim().equals("userId")){
					userId = cookie[i].getValue();
				}
			}
		}
	%>
	<script type="text/javascript">
		$(document).ready(function(){
			console.log(Dns);
			login.init();
			var id = "<%=userId%>";
			if(id==null||id==""){
				$('input:checkbox[id="saveId"]').prop("checked", false);
			}else{
				$('input:checkbox[id="saveId"]').prop("checked", true);
			}
		});
	</script>
</head>
<body>
  <div id="login_wrap">
    <div id="container">
      <div class="contents">
        <section class="login_box">
          <div class="bg">
            <h2 class="tit">개인택시 조합원관리 로그인</h2>
            <form id="loginFrm" action="#" method="post">
              <div class="row row_id">
                <label for="id" class="blind">아이디 입력</label>
                <input type="text" id="id" name="userId" placeholder="아이디를 입력해주세요."/>
              </div>
              <div class="row row_pw">
                <label for="pw" class="blind">비밀번호 입력</label>
                <input type="password" id="pw" name="password" placeholder="비밀번호를 입력해주세요." />
              </div>
              <div class="checkbox txt">
                <input type="checkbox" id="saveId" name="saveIdCheckbox" />
                <label for="saveId">아이디 저장</label>
              </div>
              <button type="button" id="loginBtn" class="btn_login">
                로그인
              </button>
            </form>
            <p>
              로그인하실때 ID/PW 대소문자를 구분하여 입력하시기 바랍니다.
            </p>
          </div>
        </section>
        <p class="txt_guide">
          본 사이트는 개인택시 조합원 전용 서비스 페이지로 승인된 통합회원만 서비스 이용이 가능합니다. <br />서비스 이용에
          대한 문의사항은 관리자에게 문의바랍니다.
        </p>
      </div>
    </div>
  </div>
</body>
</html>

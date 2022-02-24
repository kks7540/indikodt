<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.indi.kodt.core.spring.*"%>
<html lang="kr">
<head>
	<meta name="autocomplete" content="off"/>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="Cache-Control" content="No-Cache"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>개인택시공제조합</title>
    <!-- stylesheet -->
    <link rel="stylesheet" href="../../resources/assets/css/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/assets/css/custom.css" type="text/css">
    <link rel="stylesheet" href="../../resources/assets/css/style.css" type="text/css">
    <!-- js -->
	<script type="text/javascript" src="../../../resources/assets/js/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="../../../resources/assets/js/jquery.ellipsis.min.js"></script>
	<script type="text/javascript" src="../../../resources/assets/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="../../../resources/assets/js/nice-select/jquery.nice-select.min.js"></script>
	<script type="text/javascript" src="../../../resources/assets/js/style.js"></script>

</head>
<script type="text/javascript">
/*
=============================================
비밀번호 입력 컴포넌트 포커스 이동.
=============================================
 */
function focusDown() {
	$("#pw").focus();
}
/*
=============================================
로그인 처리.
=============================================
 */
function login(){
	var frm = $("#loginFrm");
	frm.attr("action", "<%=CustomDispatcherServlet.getContextPath()%>/login/loginService.do");
	frm.submit();
}
</script>
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
                <input type="text" id="id" ref="id" name="memberId" placeholder="아이디를 입력해주세요." onKeyPress="if(event.keyCode==13)focusDown()" />
              </div>
              <div class="row row_pw">
                <label for="pw" class="blind">비밀번호 입력</label>
                <input type="password" id="pw" ref="pw" name="password" placeholder="비밀번호를 입력해주세요." onKeyPress="if(event.keyCode==13)login();" />
              </div>
              <div class="checkbox txt">
                <input type="checkbox" id="saveId" name="saveIdCheckbox" />
                <label for="saveId">아이디 저장</label>
              </div>
              <button type="button" class="btn_login" onclick="login()">
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

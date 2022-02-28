<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="kr">
<head>
<tiles:insertAttribute name="header"/>
</head>
<script type="text/javascript">
$(function () {
	main.init();
});
</script>
<body data-layout="horizontal" data-topbar="dark">
<tiles:insertAttribute name="topnav" />
  	<div class='wrap'>
	  <div class='container'>  	
  		<div class="contents clearfix">
  			<tiles:insertAttribute name="content"/>
  		</div>
  	  </div>
  	</div>
</body>
</html>

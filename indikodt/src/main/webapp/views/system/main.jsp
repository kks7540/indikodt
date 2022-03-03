<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="kr">
<head>
<jsp:include page="../layout/header.jsp" flush="true"/>
<script type="text/javascript" src="../../../resources/js/system/main.js"></script>
</head>
<script type="text/javascript">
$(function () {
	//메인화면 js init
	main.init();
});
</script>
<body data-layout="horizontal" data-topbar="dark">
	<div id="wrapper">
		<header id="topnav">
			<tiles:insertAttribute name="topnav" />
		</header>
		<div class="card-body">
        <div id="basicwizard" class="basicwizard">
            <ul id ="tabpages" class="nav nav-pills bg-light nav-justified form-wizard-header mb-4">
                <li class="nav-item tab-header">
                    <a id="tabpageHeader1" href="#tabpageBody1" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2 tab-pageHeader-a">
                        <span class="d-none d-sm-inline tab-pageHeader-span-first">
                        <i class="mdi mdi-home mr-1 tap-icon01"></i>
                        </span>
                    </a>
                </li>
                <li class="nav-item tab-header">
                    <a id="tabpageHeader2" href="#tabpageBody2" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2 tab-pageHeader-a">
                        <span class="d-none d-sm-inline tab-pageHeader-span">Profile
                        	<i id="closeTabpage2" class="fe-x tap-icon02" onclick="main.fn_closeTabpasge(this);"></i></span>
                    </a>
                </li>
                <li class="nav-item tab-header">
                    <a id="tabpageHeader3" href="#tabpageBody3" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2 tab-pageHeader-a">
                        <span class="d-none d-sm-inline tab-pageHeader-span">Finish
                        <i id="closeTabpage3" class="fe-x tap-icon02" onclick="main.fn_closeTabpasge(this);"></i></span>
                    </a>
                </li>
            </ul>
            <div id="tabContent" class="tab-content mb-0">
                <div class="tab-pane" id="tabpageBody1">
					<tiles:insertAttribute name="dashboard" />
                </div>
                <div class="tab-pane" id="tabpageBody2">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="name"> First name</label>
                                <div class="col-md-9">
                                    <input type="text" id="name" name="name" class="form-control" value="Francis">
                                </div>
                            </div>
                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="surname"> Last name</label>
                                <div class="col-md-9">
                                    <input type="text" id="surname" name="surname" class="form-control" value="Brinkman">
                                </div>
                            </div>

                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="email">Email</label>
                                <div class="col-md-9">
                                    <input type="email" id="email" name="email" class="form-control" value="cory1979@hotmail.com">
                                </div>
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row -->
                </div>

                <div class="tab-pane" id="tabpageBody3">
                    <jsp:include page="/views/system/dashBoard.jsp" flush="true"/>
                </div>

            </div> <!-- tab-content -->
        </div> <!-- end #basicwizard-->
		</div>
<%--
		  <div class='container'>
	  		<div class="contents clearfix">
	  			<tiles:insertAttribute name="content1"/>
	  		</div>
	  	  </div>
 --%>
	</div>

</body>
</html>

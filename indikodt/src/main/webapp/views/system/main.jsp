<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="kr">
<head>
<jsp:include page="../layout/header.jsp" flush="true"/>
</head>
<script type="text/javascript">
$(function () {
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
            <ul class="nav nav-pills bg-light nav-justified form-wizard-header mb-4">
                <li class="nav-item">
                    <a href="#basictab1" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2"> 
                        <span class="d-none d-sm-inline">
                        <i class="mdi mdi-home mr-1 tap-icon01"></i>
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#basictab2" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2">
                        <span class="d-none d-sm-inline">Profile</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#basictab3" data-toggle="tab" class="nav-link rounded-0 pt-2 pb-2">
                        <span class="d-none d-sm-inline">Finish</span>
                    </a>
                </li>
            </ul>
            <div class="tab-content mb-0">
                <div class="tab-pane" id="basictab1">
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="userName">User name</label>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" id="userName" name="userName" value="Coderthemes">
                                </div>
                            </div>
                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="password"> Password</label>
                                <div class="col-md-9">
                                    <input type="password" id="password" name="password" class="form-control" value="123456789">
                                </div>
                            </div>
                            
                            <div class="form-group row mb-3">
                                <label class="col-md-3 col-form-label" for="confirm">Re Password</label>
                                <div class="col-md-9">
                                    <input type="password" id="confirm" name="confirm" class="form-control" value="123456789">
                                </div>
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row -->
                </div>

                <div class="tab-pane" id="basictab2">
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

                <div class="tab-pane" id="basictab3">
                    <div class="row">
                        <div class="col-12">
                            <div class="text-center">
                                <h2 class="mt-0"><i class="mdi mdi-check-all"></i></h2>
                                <h3 class="mt-0">Thank you !</h3>

                                <p class="w-75 mb-2 mx-auto">Quisque nec turpis at urna dictum luctus. Suspendisse convallis dignissim eros at volutpat. In egestas mattis dui. Aliquam
                                    mattis dictum aliquet.</p>

                                <div class="mb-3">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="customCheck1">
                                        <label class="custom-control-label" for="customCheck1">I agree with the Terms and Conditions</label>
                                    </div>
                                </div>
                            </div>
                        </div> <!-- end col -->
                    </div> <!-- end row -->
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

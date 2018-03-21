<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.submission.entity.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet" href="assets/materialize/css/materialize.min.css"
	media="screen,projection" />
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>
	<div id="wrapper">
		<c:import url="top.jsp"></c:import>
		<c:import url="left.jsp"></c:import>
		<!-- right -->
		<div id="page-wrapper">
			<div class="header">
				<h1 class="page-header">授权管理</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Grant</a></li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-action"></div>
							<div class="card-content">
								<form name=form1 action="SubmissionServlet?method=addMagazine"
									enctype="multipart/form-data" method=post>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<td>#</td>
												<td>姓名</td>
												<td>类型</td>
												<td>学历</td>
												<td>电话</td>
												<td>地址</td>
												<td>操作</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${userList}" var="user" varStatus="status">
												<tr>
													<td>${status.index + 1}</td>
													<td>${user.name}</td>
													<td>${user.type}</td>
													<td>${user.education}</td>
													<td>${user.tel}</td>
													<td>${user.address}</td>
													<td><a class="waves-effect waves-light btn" 
														onClick='grantUser("${user.id}","${user.type}")' >授权</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
								<div class="clearBoth">
									<br />
								</div>
							</div>
						</div>

					</div>
					<!-- /. PAGE INNER  -->
				</div>
				<!-- /. PAGE WRAPPER  -->
			</div>
		</div>
		<!-- right end -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- JS Scripts-->
	<!-- jQuery Js -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- Bootstrap Js -->
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/materialize/js/materialize.min.js"></script>
	<!-- Metis Menu Js -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- Custom Js -->
	<script src="assets/js/custom-scripts.js"></script>
	<script type="text/javascript">
	    function grantUser(id,type) {
	        $.ajax({
	            type : "post",
	            url : "UserServlet",
	            data : {"method":"grantUser","id":id,"type":type},
	            success : function(result) {
	                console.log(result);
	            	if(result == "success") {
	                    alert("授权成功")
	                    location.reload();
	                } else {
	                    alert("授权失败，请重新授权")
	                }
	            }
	        });
	    }
    </script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.submission.entity.Periodical"%>
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
				<h1 class="page-header">期刊管理</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">checked</a></li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-action"></div>
							<div class="card-content">
								<form class="form-horizontal"
									action="MajorEditorServlet?method=addPeriodical" method="post">
									<div class="form-group">
										<label for="inputYear" class="col-sm-2 control-label">期刊年份</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" id="inputYear"
												name="year" placeholder="年份">
										</div>
									</div>
									<div class="form-group">
										<label for="inputNum" class="col-sm-2 control-label">期刊期数</label>
										<div class="col-sm-8">
											<input type="number" class="form-control" name="month"
												id="inputNum" placeholder="期数">
										</div>
									</div>
									<div class="form-inline">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">新建期刊</button>
											<button type="reset" class="btn btn-default">取消</button>
										</div>
									</div>
									<%-- <c:forEach items="${periodicalList}" var="periodical"
										varStatus="status">
										<div class="row form-inline">
											<div class="col-md-4">${periodical.year}</div>
											<div class="col-md-4">${periodical.month}</div>
											<div class="col-md-4">文章管理</div>
											<label class="col-sm-2 control-label">${periodical.year}</label>
											<label class="col-sm-2 control-label">${periodical.month}</label>
											<label class="col-sm-2 control-label">文章管理</label>
										</div>
									</c:forEach> --%>
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
</body>
</html>

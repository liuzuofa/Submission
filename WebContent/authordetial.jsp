<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.submission.entity.Magazine"%>
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
				<h1 class="page-header">Detial Page</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Detial</a></li>
				</ol>
			</div>

			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-action"></div>
							<div class="card-content">
								<form name=form1 action="AuthorServlet?method=submission"
									enctype="multipart/form-data" method=post>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<tbody>
										    <tr id="id">
                                                <td width="120">id</td>
                                                <td><input name="id" value="${magazine.id}" > </td>
                                            </tr>
                                            <tr id="type">
                                                <td width="120">type</td>
                                                <td><input name="type" value="修改稿件" > </td>
                                            </tr>
										    <tr id="editor">
                                                <td width="120">editor</td>
                                                <td><input name="editor" value="${magazine.editor}" > </td>
                                            </tr>
										    <tr id="expert">
                                                <td width="120">expert</td>
                                                <td><input name="expert" value="${magazine.expert}" > </td>
                                            </tr>
											<tr>
                                                <td width="120">标题</td>
                                                <td><c:out value="${magazine.name}"/></td>
                                            </tr>
                                            <tr>
                                                <td width="120">摘要</td>
                                                <td><c:out value="${magazine.summary}"/></td>
                                            </tr>
                                            <tr>
                                                <td width="120">类型</td>
                                                <td><c:out value="${magazine.subject}"/></td>
                                            </tr>
                                            <tr>
                                                <td width="120">编辑建议</td>
                                                <td><c:out value="${magazine.editor_advise}"/></td>
                                            </tr>
                                            <tr>
                                                <td width="120">专家建议</td>
                                                <td><c:out value="${magazine.expert_advise}"/></td>
                                            </tr>
                                            <tr id="resubmission">
                                                <td width="120">再次投稿</td>
                                                <td><input class="form-control" type="file" name="manuscript"></td>
                                            </tr>
                                            <tr id="resubmit">
                                                <td>提交</td>
                                                <td><input class="btn btn-default" type="submit"
                                                    value="提交">
                                                </td>
                                            </tr>
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
				<iframe width="100%" height="800px"
					src="<c:out value="http://localhost:8080/submission/generic/web/viewer.html?file=${magazine.address} " />">
				</iframe>
				<!-- /. PAGE WRAPPER  -->
			</div>

		</div>
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
	   //var odiv=document.getElementById("modalbody");
	   var state = '${magazine.state}';
	   console.log(state);
	   $("#id").hide();
	   $("#type").hide();
	   $("#editor").hide();
	   $("#expert").hide();
	   if (state != "作者修改") {
		  $("#resubmission").hide(); 
		  $("#resubmit").hide(); 
	   }
	</script>
</body>
</html>

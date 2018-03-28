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
				<h1 class="page-header">学科管理</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Subject Manager</a></li>
				</ol>
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-action"></div>
							<div class="card-content">
								<form class="form-horizontal"
									action="UserServlet?method=addSubject" method="post">
									<div class="form-group">
										<label style="height:65px;text-align:right;line-height:30px;" for="inputText" class="col-sm-2 control-label" >学科领域:</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" name="subject" placeholder="请输入学科领域..."
												id="inputText">
										</div>
									</div>
									<div class="form-inline">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">增加学科领域</button>
											<button type="reset" class="btn btn-default">取消</button>
										</div>
									</div>
								</form>
								<div class="clearBoth">
									<br />
								</div>
							</div>

							<div class="card-action"></div>
							<div class="card-content">

								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<td>#</td>
											<td>类型</td>
											<td>专家数量</td>
											<td>操作</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${expertList}" var="expert"
											varStatus="status">
											<tr>
												<td>${status.index + 1}</td>
												<td>${expert.key}</td>
												<td>${expert.value}</td>
												<td><a class="waves-effect waves-light btn"
													onClick='deleteSubject("${expert.key}","${expert.value}")'>删除</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

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
		function deleteSubject(subject, count) {
			if (count == 0) {
				$.ajax({
					type : "post",
					url : "UserServlet",
					data : {
						"method" : "deleteSubject",
						"subject" : subject
					},
					success : function(result) {
						console.log(result);
						if (result == "success") {
							alert('学科删除成功');
							location.reload();
						} else {
							alert("学科删除失败，请重新删除")
						}
					}
				});
			} else {
				if(window.confirm('你确定要删除该领域吗？')){
					$.ajax({
	                    type : "post",
	                    url : "UserServlet",
	                    data : {
	                        "method" : "deleteSubject",
	                        "subject" : subject
	                    },
	                    success : function(result) {
	                        console.log(result);
	                        if (result == "success") {
	                            alert('学科删除成功');
	                            location.reload();
	                        } else {
	                            alert("学科删除失败，请重新删除")
	                        }
	                    }
	                });
	                 return true;
	              }else{
	                 return false;
	             }
			}
		}
	</script>

</body>
</html>

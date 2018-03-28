<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
				<h1 class="page-header">我要投稿</h1>
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">submission</a></li>
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
											<tr>
												<td class="col-md-1" >标题</td>
												<td><input type="text" class="form-control"
													name="title"></td>
											</tr>
											<tr>
												<td>摘要</td>
												<td><input type="text" class="form-control"
													name="summary"></td>
											</tr>
											<tr>
												<td>学科</td>
												<td><select id="subject" class="form-control" name="subject">
														<!-- <option value="自动化基础理论">自动化基础理论</option>
														<option value="自动化技术及设备">自动化技术及设备</option>
														<option value="计算机技术">计算机技术</option>
														<option value="流控技术">流控技术</option>
														<option value="遥感技术">遥感技术</option>
														<option value="远动技术">远动技术</option>
														<option value="自动化技术经济">自动化技术经济</option> -->
												</select></td>
											</tr>
											<tr>
												<td>稿件</td>
												<td><input class="form-control" type="file" name="manuscript"></td>
											</tr>
											<tr id="type">
                                                <td>稿件</td>
                                                <td><!-- <select class="form-control" name="type">
                                                        <option value="初次稿件">初次稿件</option>
                                                        <option value="修改稿件">修改稿件</option>
                                                    </select> -->
                                                    <input name="type" value="初次稿件" >
                                                </td>
                                            </tr>
											<tr>
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
       $("#type").hide();
       $.ajax({
           type : "post",
           url : "UserServlet",
           data : {"method":"getAllSubject"},
           dataType: 'json',
           success : function(result) {
        	   console.log(result);
               addBody(result);
           }
       });
       var odiv=document.getElementById("subject");
       function addBody(result) {
           //result是一个集合,所以需要先遍历
           $.each(result,function(index, obj) {
               var par=document.createElement("option");
               par.value = obj;
               par.innerHTML = obj;
               odiv.appendChild(par);
           });
       }
    </script>
</body>
</html>

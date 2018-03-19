<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.submission.entity.User"%>
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
				<h1 class="page-header">
					个人信息 
				</h1>
				
			</div>
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-action">个人信息 </div>
							<div class="card-content">
								<form name=form2 class="form-horizontal"
									action="UserServlet?method=changeinfo" method="post">
									<div class="form-group">
										<label for="inputEmail" class="col-sm-2 control-label">Email</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="inputEmail"
												readonly name="email" value="${user.email}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputUserType" class="col-sm-2 control-label">用户类型</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="inputUserType"
												readonly name="type" value="${user.type}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputUserName" class="col-sm-2 control-label">姓名</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="inputUserName"
												readonly name="name" value="${user.name}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputUserEducation" class="col-sm-2 control-label">学历</label>
										<div class="col-sm-8">
											<input type="email" class="form-control"
												id="inputUserEducation" name="education"
												value="${user.education}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputUserTel" class="col-sm-2 control-label">电话</label>
										<div class="col-sm-8">
											<input type="email" class="form-control" id="inputUserTel"
												name="tel" value="${user.tel}">
										</div>
									</div>
									<div class="form-group">
										<label for="inputUserAddress" class="col-sm-2 control-label">地址</label>
										<div class="col-sm-8">
											<input type="email" class="form-control"
												id="inputUserAddress" name="address" value="${user.address}">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-8">
											<button type="submit" class="btn btn-default">保存</button>
										</div>
									</div>

								</form>
								<form name=form2 class="form-horizontal"
									action="UserServlet?method=changepassword" method="post">
									<div class="form-group">
										<label for="inputPassword1" class="col-sm-2 control-label">密码</label>
										<div class="col-sm-8">
											<input type="password" class="form-control"
												id="inputPassword1" name="password">
										</div>
									</div>
									<div class="form-group">
                                        <label for="inputPassword2" class="col-sm-2 control-label">新密码</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control"
                                                id="inputPassword2" name="newpassword">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
                                        <div class="col-sm-8">
                                            <input type="password" class="form-control"
                                                id="inputPassword3" name="newpassword1">
                                        </div>
                                    </div>
									<div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-8">
                                            <button type="submit" class="btn btn-default">提交</button>
                                        </div>
                                    </div>
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

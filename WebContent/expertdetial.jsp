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
								<form name=form1 action="SubmissionServlet?method=addMagazine"
									enctype="multipart/form-data" method=post>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<tbody>
											<tr>
                                                <td width="120">标题</td>
                                                <td><c:out value="${magazine.name}"/></td>
                                            </tr>
                                            <tr>
                                                <td width="120">摘要</td>
                                                <td>${magazine.summary}</td>
                                            </tr>
                                            <tr>
                                                <td width="120">类型</td>
                                                <td>${magazine.subject}</td>
                                            </tr>
                                            <tr id="editor_advise">
                                                <td width="120">编辑意见</td>
                                                <td>${magazine.editor_advise}</td>
                                            </tr>
                                            <tr id="expert_advise">
                                                <td width="120">专家意见</td>
                                                <td>${magazine.expert_advise}</td>
                                            </tr>
                                            <tr id="advise">
                                                <td >建议</td>
                                                <td ><input id="advise_text" type="text" /></td>
                                            </tr>
                                            <tr id="btn_expert">
                                                <td colspan=2 style="text-align: center;">
                                                    <input  type="button" value="接受稿件" style="margin-right: 30px" 
                                                            onclick='suggestion("${magazine.id}","agree")' />
                                                    <input type="button" value="修改稿件" style="margin-right: 30px" 
                                                            onclick='suggestion("${magazine.id}","modify")' />
                                                    <input type="button" value="拒绝稿件" style="margin-right: 30px" 
                                                            onclick='suggestion("${magazine.id}","reject")' />
                                                    <input type="button" value="返回" 
                                                            onClick="javascript :history.back(-1);" />
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
		var state = '${magazine.state}';
	    console.log(state);
	    $("#editor_advise").hide(); 
	    $("#expert_advise").hide(); 
	    if (state == "专家已审") {
	    	$("#editor_advise").show(); 
	        $("#expert_advise").show(); 
	        $("#advise").hide(); 
	       $("#btn_expert").hide(); 
	    }
	    function suggestion(id,type) {
	        var advise_text = document.getElementById("advise_text").value;
	        console.log("advise_text = " + advise_text);
	        if(advise_text == '' )
	            alert("请填写建议...");
	        else {
	            $.ajax({
	                type : "post",
	                url : "ExpertServlet",
	                data : {"method":"suggestion","id":${magazine.id},"type":type,"advise":advise_text },
	                success : function(result) {
	                    //console.log(result);
	                    if(result == "success") {
	                    	alert("审核完成")
	                        location.href='ExpertServlet?method=checked'
	                    } else {
	                    	alert("审核失败，请重新提交")
	                    }
	                    
	                }
	            });
	        }
	    }
	</script>
</body>
</html>

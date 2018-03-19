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
				<h1 class="page-header">已审稿件</h1>
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
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<td>#</td>
											<td>标题</td>
											<td>审稿时间</td>
											<td>作者</td>
											<td>学科</td>
											<td>操作</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${magazineList}" var="magazine"
											varStatus="status">
											<tr>
												<td>${status.index + 1}</td>
												<td>${magazine.name}</td>
												<td>${magazine.review_time}</td>
												<td>${magazine.author}</td>
												<td>${magazine.subject}</td>
												<!-- <td><a href=DetialServlet?id=${magazine.id}>查看</a></td> -->
												<td><button class="btn btn-primary" data-toggle="modal"
														data-target="#myModal" onclick="pop(${magazine.id})">分配专家</button></td>
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

	<!-- Modal -->
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		data-backdrop="static" aria-labelledby="myModalLabel"
		data-keyboard="false">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">选择专家</h4>
				</div>
				<div class="modal-body" id="modalbody">
					<!-- <p>
                        <input name="expert" type="radio" id="test1" value="1"/>
                        <label for="test1">小刘</label>
                    </p> -->

				</div>
				<div class="modal-footer">
					<a href="" class="btn btn-default" onclick="removeP()">关闭</a>
					<button class="btn btn-primary" onclick="dispatch()">提交</button>
				</div>
			</div>
		</div>
	</div>
	<!-- modal -->

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
        //var data= [{"id": "1", "name": "小刘"},{"id": "2", "name": "小明"},{"id": "3", "name": "小张"}];
        var magazineId;
        function pop(id) {
        	magazineId = id;
        	console.log("magazineId = " + magazineId);
            $.ajax({
                type : "post",
                url : "UserServlet",
                data : {"method":"getexpert"},
                dataType: 'json',
                success : function(result) {
                    //console.log(result);
                    addBody(result);
                }
            });
        }
        function dispatch() {
        	//var expert_name = $('#modalbody input[name="expert"]:checked').val();
            var expert_name = $('input:radio:checked').val();
            if (typeof(expert_name) != "undefined" ){
            console.log("expert_name = " +expert_name );
                $.ajax({
                    type : "post",
                    url : "EditorServlet",
                    data : {"method":"dispatchexpert","id":magazineId,"expert":expert_name},
                    success : function(result) {
                        console.log(result);
                        console.log(result == "success");
                        if (result == "success" ) {
                            alert("分配成功");
                            removeP();
                            $("[data-dismiss='modal']").click();
                            window.location.reload();
                        }
                    }
                });
            }else{
                alert("请选择老师");
            }
        }
        
        var odiv=document.getElementById("modalbody");
        function addBody(result) {
            //result是一个集合,所以需要先遍历
            $.each(result,function(index, obj) {
                var par=document.createElement("p");
                var para=document.createElement("input");
                para.name="expert";
                para.type="radio";
                para.id="test"+obj.id;
                para.value=obj.name;
                var parb=document.createElement("label");
               // parb.for="test"+obj.id;
                parb.setAttribute("for","test"+obj.id);
                parb.innerHTML=obj.name;
                odiv.appendChild(par);
                par.appendChild(para);    
                par.appendChild(parb);
            });
        }
        function removeP() {
            //$('#myModal').modal('hide');
            while(odiv.hasChildNodes()) //当elem下还存在子节点时 循环继续  
            {  
                odiv.removeChild(odiv.firstChild);  
            }  
        }
    </script>
</body>
</html>

<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>《科技与创新》杂志官方网站！</title>
<meta name="description" content="《科技与创新》杂志官方网站！" />
<meta name="keywords" content="《科技与创新》杂志官方网站！" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/pptBox.js"></script>
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>  
</head>

<body style="background:url(images/bj.jpg) repeat-x;">
	<div class="box_bj">
		<div class="box">
			<!--LOGO-->
			<div class="top">
				<div class="top1">
				<span>欢迎您来到《科技与创新》杂志！</span>
				</div>
				<div class="logo"><img src="images/logo.png" /></div>
			</div>
			<!--导航-->
			<div class="nav">
			  <ul>
				<li style="margin-right:15px; background:none;"><a href='./'>首页</a></li>
                <li><a href="login.jsp">在线登陆</a></li>
                <li><a href="">投稿须知</a></li>
                <li><a href="">杂志目录</a></li>
                <li><a href="">在线投稿</a></li>
                <li><a href="">录用查询</a></li>
                <li><a href="register.jsp">在线注册</a></li>
                <li style="background:none;"><a href="more.php?ChannelID=6">联系我们</a></li>
			  </ul>
			  
			  <span>
				<script language="javascript">
				var week;
				if(new Date().getDay()==0)          week="星期日"
				if(new Date().getDay()==1)          week="星期一"
				if(new Date().getDay()==2)          week="星期二"
				if(new Date().getDay()==3)          week="星期三"
				if(new Date().getDay()==4)          week="星期四"
				if(new Date().getDay()==5)          week="星期五"
				if(new Date().getDay()==6)          week="星期六"
				document.write(new Date().getUTCFullYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日 "+week);
				</script>
			  </span> 
			</div>
			
			<!--广告图片-->
			<div class="banner">
			<object classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000' codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0' width=1000 height=244>
						  <param name=movie value="images/banner.swf">
						  <param name=quality value=high>
						  <embed src="images/banner.png" quality=high pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash' type='application/x-shockwave-flash' width=1000 height=244>
						  </embed>
						</object>
			</div>
			<div class="center">
				<div class="sub_left">
					<!--版权信息-->
					<div class="sub_left_top"></div>
					<div class="sub_banquan_center">
						<div class="bq1_top"><p>版权信息</p></div>
						<div class="bq1_center">国际标准刊号 ISSN 2095－6835<br />
							国内统一刊号 CN 14－1369/N<br />
							<br />
							主　　管　江西省科学技术协会<br />
							主　　办　江西华东交大传媒集团<br />
							出　　版　江西华东交大出版公司<br />
							编　　辑　《科技与创新》编辑部<br />
							社　　址　南昌市双港东大街808号<br />
							<br />
							投稿邮箱　kjycx@188.com<br />
							　　　　　kjycxzzs@126.com<br />
							查稿电话　0791－87045666<br />
							　　　　　0791－87046666<br />
							邮发代号　22－582<br />
							定　　价　每册15元<br />
						</div>
					</div>
					<div class="sub_left_bottom"></div>
					
				</div>
				<!--在线注册-->
				<div class="sub_right">
					<div class="sub_right_top"></div>
					<div class="sub_right_center1">
						<div class="ff_top">
							<p>在线注册</p>
						</div>
						<div class="ff_center1">
							<div class=tishi><b>温馨提示：</b>
								<p> 如果您第一次使用本系统，请先按照下面的步骤注册新账号：</p>
								<p>（1）新用户注册；</p>
								<p>（2）用您填写的账号和密码登录本系统，进入本系统浏览文章或者订阅期刊。</p>
								<p>如果您已经注册过，请在下面的输入框中填写E-mail和密码，登录进入本系统，如果您忘记了自己的密码，请点击这里：找回密码。</p>
							</div>
							<div class="biaodan">
								<form name="form1" action="RegisterServlet" method="post" >
									<ul>
									  <li>邮&nbsp;&nbsp;&nbsp;箱：<input name="email"  type="text" /> </li>
									  <li>密&nbsp;&nbsp;&nbsp;码：<input name="password"  type="password" /></li>
									  <li id="type">类&nbsp;&nbsp;&nbsp;型：<select id="type1" onchange="show()" class="form-control" name="type">
																  <option value="读者">读者</option>
																  <option value="编辑">编辑</option>
																  <option value="专家">专家</option>
																  <option value="主编">主编</option>
                                                                </select> </li>
                                      <li id="field">领&nbsp;&nbsp;&nbsp;域：<select id="field1" class="form-control" name="field">
                                                                  <option value="读者">读者</option>
                                                                  <option value="编辑">编辑</option>
                                                                  <option value="专家">专家</option>
                                                                  <option value="主编">主编</option>
                                                                </select> </li>                          
                                      <li>名&nbsp;&nbsp;&nbsp;字：<input name="name"  type="text" /> </li>
                                      <li>学&nbsp;&nbsp;&nbsp;历：<input name="education"  type="text" /> </li>
                                      <li>电&nbsp;&nbsp;&nbsp;话：<input name="tel"  type="text" /> </li>
                                      <li>地&nbsp;&nbsp;&nbsp;址：<input name="address"  type="text" /> </li>
									  <li>
									      <input  type="submit"  value="提交" style="width:50px; height:25px;"/> 
										  <input type="reset" value="重置" style="width:50px; height:25px;"/>
									  </li>
									</ul>
								</form>
							</div>
						</div>
					</div>
					<div class="sub_right_bottom"></div>
				</div>
		    </div>
		</div>
		<!--底部信息-->
		<div class="sub_bottom_bj">
			<div class="sub_bottom">
				<p>
				投稿邮箱：kjycx@188.com / kjycxzzs@126.com &nbsp; 查稿电话：0791－87045666 / 0791－87046666<br />
				联系地址：南昌市双港东大街808号 编辑部 &nbsp; &nbsp; / &nbsp; &nbsp;南昌市华东交通大学84－84信箱 学术部 &nbsp; &nbsp; &nbsp;&nbsp;<br />
				版权所有 | 《科技与创新》杂志编辑部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 京ICP备88888888号
				</p>
				<p>技术支持：14计算机</p>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	if ($("#type1").val() == "读者") {
        $("#field").hide();
    } else {
        $("#field").show();
    }
	function show() {
		console.log($("#type1").val());
		if ($("#type1").val() == "专家") {
	        $("#field").show();
	    } else {
	    	$("#field").hide();
	    }
	}
            function refuse(a,name) {
                mid = a;
                console.log("mid = " + mid);
                $.ajax({
                    type : "post",
                    url : "ExpertServlet",
                    data : {"method":"refuse","mid":mid,"operator":name},
                    success : function(result) {
                        //console.log(result);
                       if ("success" == result) {
                           alert("拒绝成功");
                           window.location.reload();
                       }
                    }
                });
            }
    </script>
        
</body>
</html>
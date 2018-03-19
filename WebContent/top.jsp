<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.submission.entity.User" %>
<!--TOP  -->
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href=""><i class="large material-icons">insert_chart</i> <strong>在线投稿系统</strong></a>
				
				<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 
				<li>
					<a class="dropdown-button waves-effect waves-dark">
						<b>类型：${user.type}</b>
					</a>
				</li>
				<li>
                    <a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1">
                        <i class="fa fa-user fa-fw"></i> 
                        <b>${user.name}</b>
                        <i class="material-icons right">arrow_drop_down</i>
                    </a>
                </li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
		<ul id="dropdown1" class="dropdown-content">
			<!-- <li>
				<a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
			</li> --> 
			<li>
				<a href="LoginServlet?method=logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
			</li>
		</ul>
		  
<!--/TOP  -->
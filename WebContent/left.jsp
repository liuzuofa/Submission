<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.submission.entity.Menu" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--left menu  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                	<c:forEach items="${menuList}" var="menu">
                    <li>
                        <a href="${menu.path }" class="waves-effect waves-dark"><i class="fa fa-dashboard"></i> ${menu.name }</a>
                    </li>
                    </c:forEach>        
                    
                </ul>

            </div>

        </nav>
<!-- /left menu  -->
package com.submission.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.submission.dao.UserDao;
import com.submission.dao.impl.UserDaoImpl;
import com.submission.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String education = request.getParameter("education");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		User user = new User(email, password, type, name, education, tel, address,"未授权");
		UserDao userdao = new UserDaoImpl();
		if("读者".equals(type)) {
			user.setState("授权");
		}else {
			user.setState("未授权");
		}
		if(userdao.registerUser(user)>0){
			out.print("<script>alert('注册成功');location.href='login.jsp'</script>");
		}else{
			out.print("<script>alert('用户已存在');location.href='register.jsp'</script>");
		}
	}

}

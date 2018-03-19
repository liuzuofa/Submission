package com.submission.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.submission.dao.MenuDao;
import com.submission.dao.UserDao;
import com.submission.dao.impl.MenuDaoImpl;
import com.submission.dao.impl.UserDaoImpl;
import com.submission.entity.Menu;
import com.submission.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String method = request.getParameter("method");
		System.out.println("method = " + method);

		if ("login".equals(method)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email + " " + password);

			UserDao userdao = new UserDaoImpl();
			User user = userdao.loginUser(email, password);
			if (user != null) {
				if ("未授权".equals(user.getState())) {
					out.print("<script>alert('没有权限，请等待管理员给权限');location.href='login.jsp'</script>");
					return;
				}
				String name = user.getName();
				MenuDao menuDao = new MenuDaoImpl();
				int id = user.getId();
				List<Menu> menuList = menuDao.getMenu(id);

				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("menuList", menuList);
				if ("读者".equals(user.getType())) {
					out.print("<script>alert('登录成功');location.href='authorsubmission.jsp'</script>");
				} else if ("编辑".equals(user.getType())) {
					out.print("<script>alert('登录成功');location.href='EditorServlet?method=waitcheck'</script>");
				} else if ("专家".equals(user.getType())) {
					out.print("<script>alert('登录成功');location.href='ExpertServlet?method=waitcheck'</script>");
				} else if ("主编".equals(user.getType())) {
					out.print("<script>alert('登录成功');location.href='MajorEditorServlet?method=employ'</script>");
				} else if ("管理员".equals(user.getType())) {
					out.print("<script>alert('登录成功');location.href='UserServlet?method=getAllUsers'</script>");
				}
			} else {
				out.print("<script>alert('用户名或者密码错误，登录失败');location.href='login.jsp'</script>");
			}
		} else if ("logout".equals(method)) {
			request.getSession().removeAttribute("user");
			out.print("<script>alert('注销成功');location.href='login.jsp'</script>");
		}

	}

}

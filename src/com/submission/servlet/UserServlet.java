package com.submission.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.submission.dao.MagazineDao;
import com.submission.dao.UserDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.dao.impl.UserDaoImpl;
import com.submission.entity.Magazine;
import com.submission.entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// request.toString()
		User user = (User) request.getSession().getAttribute("user");
		UserDao userdao = new UserDaoImpl();
		MagazineDao magazineDao = new MagazineDaoImpl();
		String method = request.getParameter("method");
		if (user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}
		if ("changepassword".equals(method)) {
			String password = request.getParameter("password");
			String newPassword = request.getParameter("newpassword");
			String newPassword1 = request.getParameter("newpassword1");
			System.out.println("password = " + password + " newPassword = " + newPassword + " newPassword1 = " + newPassword1 );
			if (!newPassword.equals(newPassword1)) {
				out.print("<script>alert('新密码不一致，请重新输入');location.href='personal.jsp'</script>");
			} if (password.equals(newPassword1)) {
				out.print("<script>alert('原密码和新密码一致，请重新输入');location.href='personal.jsp'</script>");
			}else {
				int i = userdao.ChangePassword(user, newPassword);
				if (i > 0) {
					out.print("<script>alert('密码修改成功');location.href='personal.jsp'</script>");
				} else {
					out.print("<script>alert('原密码输入错误，请重新输入');location.href='personal.jsp'</script>");
				}
			}
		} else if ("changeinfo".equals(method)) {
			String education = request.getParameter("education");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			User user1 = new User(education, tel, address);
			user1.setEmail(user.getEmail());
			int i = userdao.ChangeInfo(user1);
			if(i> 0) {
				out.print("<script>alert('信息修改成功');location.href='submission.jsp'</script>");
				request.getSession().removeAttribute("user");
				user.setEducation(education);
				user.setTel(tel);
				user.setAddress(address);
				request.getSession().setAttribute("user", user);
			}else {
				out.print("<script>alert('信息修改失败，请重新输入');location.href='submission.jsp'</script>");
			}
		} else if ("getexpert".equals(method)) {
			List<User> userList = userdao.getAllUserByType("专家");
			String expertList = new Gson().toJson(userList);
			out.println(expertList);
		} else if ("regetexpert".equals(method)) {
			String expert = request.getParameter("expert");
			List<User> userList = userdao.getAllUserByType("专家");
			for (int i = 0; i< userList.size(); i++) {
				if(expert.equals(userList.get(i).getName())) {
					userList.remove(i);
				}
			}
			String expertList = new Gson().toJson(userList);
			out.println(expertList);
		} else if ("getAllUsers".equals(method)) {
			List<User> userList = new ArrayList<>();
			userList = userdao.getAllUser();
			for(int i = 0; i<userList.size(); i++) {
				if ("管理员".equals(userList.get(i).getType())) {
					userList.remove(i);
				}
			}
			request.setAttribute("userList", userList);			
			request.getRequestDispatcher("adminmanager.jsp").forward(request, response);
		} else if ("deleteUser".equals(method)) {
			int userId =Integer.parseInt(request.getParameter("id"));
			int result = userdao.deleteUser(userId);
			if (result > 0 ) {
				out.print("success");
			}else {
				out.print("fail");
			}
		} else if ("getGrantUsers".equals(method)) {
			List<User> userList = new ArrayList<>();
			userList = userdao.getAllUserByState("未授权");
			request.setAttribute("userList", userList);			
			request.getRequestDispatcher("admingrant.jsp").forward(request, response);
		} else if ("grantUser".equals(method)) {
			int userId =Integer.parseInt(request.getParameter("id"));
			String type =request.getParameter("type");
			int result = userdao.updateUserStateById(userId,type,"授权");
			if (result > 0 ) {
				out.print("success");
			}else {
				out.print("fail");
			}
		} else if ("getAllMagazine".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByState("");
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("magazinemanager.jsp").forward(request, response);
		} else if ("delete".equals(method)) {
			int magazineId = Integer.parseInt(request.getParameter("id"));
			int result = magazineDao.deleteMagazineById(magazineId);
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		}
	}

}

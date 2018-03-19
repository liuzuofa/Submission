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

import com.submission.dao.MagazineDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.entity.Magazine;
import com.submission.entity.User;

@WebServlet("/ExpertServlet")
public class ExpertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExpertServlet() {
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
		

		User user = (User) request.getSession().getAttribute("user");
		MagazineDao magazineDao = new MagazineDaoImpl();
		if(user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}
		System.out.println("name = " + user.getName());
		
		String method = request.getParameter("method");
		System.out.println("method = " + method);
			
		if("waitcheck".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndExpert("专家待审", user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("expertwaitcheck.jsp").forward(request, response);
		}else if("checked".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndExpert("专家已审", user.getName());
			request.setAttribute("magazineList", magazineList);			
			request.getRequestDispatcher("expertchecked.jsp").forward(request, response);
		} else if("suggestion".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String type = request.getParameter("type");
			String advise = request.getParameter("advise");
			String state = "";
			if("agree".equals(type)) {
				state = "专家已审";
			} else if("modify".equals(type)) {
				state = "作者修改";
			} else if("reject".equals(type)) {
				state ="退稿";
			}
			int result = magazineDao.updateMagazineStateAndAdviseById(id, state, advise, "expert");
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		}
	}
}

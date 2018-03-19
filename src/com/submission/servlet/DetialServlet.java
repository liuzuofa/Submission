package com.submission.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.submission.dao.MagazineDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.entity.Magazine;
import com.submission.entity.User;
import com.submission.util.Utils;

@WebServlet("/DetialServlet")
public class DetialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetialServlet() {
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
		MagazineDao magazineDao = null;

		if (user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}
		
		if ("读者".equals(user.getType())) {
			String id = request.getParameter("id");
			System.out.println("name =" + id);
			magazineDao = new MagazineDaoImpl();
			Magazine magazine = magazineDao.getMagazineById(Integer.parseInt(id));
			request.setAttribute("magazine", magazine);
			request.getRequestDispatcher("authordetial.jsp").forward(request, response);
		}else if("编辑".equals(user.getType())) {
			String id = request.getParameter("id");
			System.out.println("id =" + id);
			magazineDao = new MagazineDaoImpl();
			Magazine magazine = magazineDao.getMagazineById(Integer.valueOf(id));
			
			if (magazine.getReview_time() == null) {
				int result = magazineDao.updateMagazineReviewTimeById(Integer.valueOf(id), Utils.getTime());
				if (result <= 0 ) {
					return;
				}
			}
			request.setAttribute("magazine", magazine);
			request.getRequestDispatcher("editordetial.jsp").forward(request, response);
		}else if("专家".equals(user.getType())) {
			String id = request.getParameter("id");
			System.out.println("id =" + id);
			magazineDao = new MagazineDaoImpl();
			Magazine magazine = magazineDao.getMagazineById(Integer.valueOf(id));
			
			if (magazine.getReview_time() != null && magazine.getExpert() == null) {
				int result = magazineDao.updateMagazineReviewTimeById(Integer.valueOf(id), Utils.getTime());
				if (result <= 0 ) {
					return;
				}
			}
			request.setAttribute("magazine", magazine);
			request.getRequestDispatcher("expertdetial.jsp").forward(request, response);
		}else if("主编".equals(user.getType())) {
			String id = request.getParameter("id");
			System.out.println("name =" + id);
			magazineDao = new MagazineDaoImpl();
			Magazine magazine = magazineDao.getMagazineById(Integer.valueOf(id));
			request.setAttribute("magazine", magazine);
			request.getRequestDispatcher("authordetial.jsp").forward(request, response);
		}

	}

}

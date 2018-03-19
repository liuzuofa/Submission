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
import com.submission.util.Utils;

@WebServlet("/EditorServlet")
public class EditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditorServlet() {
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
		if (user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}
		System.out.println("name = " + user.getName());

		String method = request.getParameter("method");
		System.out.println("method = " + method);

		if ("waitcheck".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByState("编辑待审");
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("editorwaitcheck.jsp").forward(request, response);
		} else if ("checked".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByState("编辑已审");
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("editorchecked.jsp").forward(request, response);
		} else if ("employ".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByState("专家已审");
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("expertchecked.jsp").forward(request, response);
		} else if ("dispatchexpert".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String expert = request.getParameter("expert");
			System.out.println("id = " + id + " expert = " + expert);
			int i = magazineDao.updateMagazineEditorAndExpertById(id, user.getName(), expert);
			if (i > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}

		} else if ("agree".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String advise = request.getParameter("advise");
			int result = magazineDao.updateMagazineStateAndAdviseById(id, "编辑已审", advise, "editor");
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		} else if ("modify".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String advise = request.getParameter("advise");
			int result = magazineDao.updateMagazineStateAndAdviseById(id, "作者修改", advise, "editor");
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		} else if ("reject".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String advise = request.getParameter("advise");
			int result = magazineDao.updateMagazineStateRejectTimeAndAdviseById(id, "退稿", Utils.getTime(), advise,
					"editor");
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		} else if ("employsuggest".equals(method)) {
			int id = Integer.valueOf(request.getParameter("id"));
			String type = request.getParameter("type");
			String state = "";
			if("agree".equals(type)) {
				state = "已录用";
			} else if("reject".equals(type)) {
				state = "退稿";
			}
			int result = magazineDao.updateMagazineStateById(id, state);
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		}

	}
}

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
import com.submission.dao.PeriodicalDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.dao.impl.PeriodicalDaoImpl;
import com.submission.entity.Magazine;
import com.submission.entity.Periodical;
import com.submission.entity.User;
import com.submission.util.Utils;

@WebServlet("/MajorEditorServlet")
public class MajorEditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MajorEditorServlet() {
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
		PeriodicalDao periodicalDao = new PeriodicalDaoImpl();
		if (user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}
		System.out.println("name = " + user.getName());

		String method = request.getParameter("method");
		System.out.println("method = " + method);

		if ("employ".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByState("已录用");
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("majoreditoremploy.jsp").forward(request, response);
		} else if ("getPeriodical".equals(method) ) {
			List<Periodical> periodicalList = new ArrayList<>();
			periodicalList = periodicalDao.getAllPeriodicalByState("未发表");
			out.print(new Gson().toJson(periodicalList));
		} else if ("dispatchPeriodical".equals(method) ) {
			int periodicalId = Integer.parseInt(request.getParameter("id"));
			int magazineId = Integer.parseInt(request.getParameter("mid"));
			int result = magazineDao.updateMagazineStateAndPeriodicalIdById("已发表", magazineId, periodicalId);
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		} else if ("addPeriodical".equals(method)) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			Periodical periodical = new Periodical(year, month, "未发表");
			int result = periodicalDao.addPeriodical(periodical);
			if (result > 0) {
				out.print("<script>alert('期刊创建成功');location.href='majoreditornewperiodical.jsp'</script>");
			}
		} else if ("periodicalManager".equals(method)) {
			List<Periodical> periodicalList = new ArrayList<>();
			periodicalList = periodicalDao.getAllPeriodical();
			request.setAttribute("periodicalList", periodicalList);
			request.getRequestDispatcher("periodicalmanager.jsp").forward(request, response);
		} else if ("articlemanager".equals(method)) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id = " + id);
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByPeriodicalId(id);
			Periodical periodical = periodicalDao.getPeriodicalById(id);
			request.setAttribute("magazineList", magazineList);
			request.setAttribute("periodical", periodical);
			/*request.setAttribute("periodical_id", periodical.getId());
			request.setAttribute("periodical_state", periodical.getState());*/
			request.getRequestDispatcher("articlemanager.jsp").forward(request, response);
		} else if ("delete".equals(method)) {
			int magazineId = Integer.parseInt(request.getParameter("id"));
			int periodicalId = 0;
			int result = magazineDao.updateMagazineStateAndPeriodicalIdById("已录用",magazineId,periodicalId);
			if (result > 0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		}else if ("publish".equals(method)) {
			int periodicalId = Integer.parseInt(request.getParameter("id"));
			int result =periodicalDao.updataPeriodicalStateById(periodicalId, "已发表");
			int result1 = magazineDao.updateMagazinePublishTimeByPeriodicalId(periodicalId, Utils.getTime());
			if (result > 0 && result1>0) {
				out.print("success");
			} else {
				out.print("fail");
			}
		}
	}
}

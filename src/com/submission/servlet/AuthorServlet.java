package com.submission.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.submission.dao.MagazineDao;
import com.submission.dao.impl.MagazineDaoImpl;
import com.submission.entity.Magazine;
import com.submission.entity.User;
import com.submission.util.Utils;

@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorServlet() {
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

		User user = (User) request.getSession().getAttribute("user");
		MagazineDao magazineDao = new MagazineDaoImpl();
		if (user == null) {
			out.print("<script>alert('您还未登录，请先登录');location.href='login.jsp'</script>");
			return;
		}

		String method = request.getParameter("method");
		System.out.println("method = " + method);

		if ("submission".equals(method)) {
			/*String type = request.getParameter("type");
			System.out.println("type = " + type);*/
			Magazine magazine = new Magazine();
			magazine.setAuthor(user.getName());
			String address = uploadFile(request, response, magazine,user.getName());
			magazine.setAddress(address);
			magazine.setSubmission_time(Utils.getTime());
			System.out.println(magazine.toString());
			if ("".equals(address)) {
				out.print("<script>alert('投稿失败');location.href='submission.jsp'</script>");
			} else {
				if ("初次稿件".equals(magazine.getState())) {
					magazine.setState("编辑待审");
					int i = magazineDao.addMagazine(magazine);
					if (i > 0) {
						out.print("<script>alert('投稿成功');location.href='authorsubmission.jsp'</script>");
					} else {
						out.print("<script>alert('投稿失败');location.href='authorsubmission.jsp'</script>");
					}
				} else if("修改稿件".equals(magazine.getState())) {
					if (!("".equals(magazine.getEditor()))) {
						System.out.println("编辑 = " + magazine.getEditor());
						magazine.setState("编辑待审");
					}
					if (!("".equals(magazine.getExpert()))) {
						System.out.println("专家 = " + magazine.getExpert());
						magazine.setState("专家待审");
					}
					int i = magazineDao.updateMagazine(magazine);
					if (i > 0) {
						out.print("<script>alert('修改稿件成功');location.href='AuthorServlet?method=all'</script>");
					} else {
						out.print("<script>alert('修改稿件失败');location.reload();'</script>");
					}
				}
			}
		} else if ("all".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authorall.jsp").forward(request, response);
		} else if ("waitcheck".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("待审",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authorwaitcheck.jsp").forward(request, response);
		} /*else if ("checked".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("已审",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authorchecked.jsp").forward(request, response);
		}*/ else if ("employ".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("录用",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authoremploy.jsp").forward(request, response);
		} else if ("modify".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("修改",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authormodify.jsp").forward(request, response);
		} else if ("back".equals(method)) {
			List<Magazine> magazineList = new ArrayList<>();
			magazineList = magazineDao.getAllMagazineByStateAndAuthor("退稿",user.getName());
			request.setAttribute("magazineList", magazineList);
			request.getRequestDispatcher("authorback.jsp").forward(request, response);
		}

	}

	private String uploadFile(HttpServletRequest request, HttpServletResponse response, Magazine magazine,String userName)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String filePath = "";
		// 生成存储路径
		String storeDirectory = this.getServletContext().getRealPath("/pdf/"+userName);
		File file = new File(storeDirectory);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(storeDirectory + "目录不存在，需要创建");
			file.mkdirs();
		}
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory dff = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload sfu = new ServletFileUpload(dff);
			// 解决上传文件名的中文乱码
			sfu.setHeaderEncoding("UTF-8");
			// 3、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> items = sfu.parseRequest(request);
			System.out.println(items.toString());
			// 获取上传字段
			for (FileItem item : items) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					if ("id".equals(name)) {
						magazine.setId(Integer.parseInt(value));
					} else if ("title".equals(name)) {
						magazine.setName(value);
					} else if ("summary".equals(name)) {
						magazine.setSummary(value);
					} else if ("subject".equals(name)) {
						magazine.setSubject(value);
					} else if ("type".equals(name)) {
						magazine.setState(value);
					} else if ("editor".equals(name)) {
						magazine.setEditor(value);
					} else if ("expert".equals(name)) {
						magazine.setExpert(value);
					}
				} else {
					// 如果fileitem中封装的是上传文件
					// 得到上传的文件名称，
					String filename = item.getName();
					System.out.println("filename is " + filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如： c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
					/*
					 * item.write(new File(storeDirectory, filename)); filePath = storeDirectory +
					 * "\\" + filename; System.out.println("filePath = " + filePath);
					 */
					filePath ="/submission/pdf/"+userName+"/" + filename;
					System.out.println("filePath = " + filePath);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(storeDirectory + "\\" + filename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件上传失败");
		}
		return filePath;

	}

}

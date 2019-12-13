package com.qyc.OneProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.Notice;
import com.qyc.OneProject.sevice.NoticeInterface;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class NoticeMgrServlet
 */
@WebServlet("/NoticeMgrServlet")
public class NoticeMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeMgrServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String pd = request.getParameter("judge");
		if (pd.equals("in")) {// 公告添加
			insert(request, response);
			response.sendRedirect("admin/Admin/AdminRelease.jsp");
		}
		if (pd.equals("se")) {//公告查询
			select(request, response);
		}
		if(pd.equals("Nse")){//公告详情
			NoticeSelect(request,response);
		}
		if (pd.equals("Upload")) {//公告图片上传
			ImageUpload(request, response);
		}
		if(pd.equals("de")){//删除公告
			delete(request,response);
			response.sendRedirect("admin/Admin/AdminReleaseInfo.jsp");
		}
	}
	//删除公告
	void delete(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		Notice notice=new Notice();
		notice.setID(Integer.parseInt(request.getParameter("ID")));
		NoticeInterface nInterface=SchoolFactory.NoticeInterFace();
		nInterface.delete(notice);
		
	}

	//公告详情
	void NoticeSelect(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		NoticeInterface nInterface=SchoolFactory.NoticeInterFace();
		String ID=request.getParameter("ID");
		Notice notice=nInterface.Noselect(ID);
		request.getSession().setAttribute("notice", notice);
		String user=request.getParameter("user");
		if(user.equals("A")){
			response.sendRedirect("admin/Admin/AdminReleaseShow.jsp");
		}
		if(user.equals("T")){
			response.sendRedirect("Teacher/TeacherReleaseShow.jsp");
		}
		if(user.equals("S")){
			response.sendRedirect("Student/StudentReleaseShow.jsp");
		}
	}
	//公告图片上传
	void ImageUpload(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String filename = util.fileupload(this, request, "NoticeImage", "");
			// 结合CKeditor功能
			// ImageContextPath为图片在服务器地址,如upload/123.jpg,非绝对路径
			String ImageContextPath = request.getContextPath() + "/"
					+ "NoticeImage" + "/" + filename;
			response.setContentType("text/html;charset=UTF-8");
			String callback = request.getParameter("CKEditorFuncNum");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",'" + ImageContextPath + "',''" + ")");
			out.println("</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		NoticeInterface nInterface=SchoolFactory.NoticeInterFace();
		List<Notice> list=nInterface.select();
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Notice notice = new Notice();
		Admin admin = (Admin) request.getSession().getAttribute("login");
		notice.setAdmin(admin);
		notice.setNoticeTitle(request.getParameter("NoticeTitle"));
		notice.setNoticeContent(request.getParameter("NoticeContent"));
		notice.setReleaseTime(util.getNowDetailedTime());
		NoticeInterface nInterface = SchoolFactory.NoticeInterFace();
		if (nInterface.insert(notice)) {
			request.getSession().setAttribute("AdInsert", "true");
		} else {
			request.getSession().setAttribute("AdInsert", "false");
		}

	}

}

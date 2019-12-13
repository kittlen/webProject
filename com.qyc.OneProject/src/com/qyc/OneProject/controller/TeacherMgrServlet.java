package com.qyc.OneProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.qyc.OneProject.Model.College;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.TeacherInterface;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class TeacherMgrServlet
 */
@WebServlet("/TeacherMgrServlet")
public class TeacherMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherMgrServlet() {
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
		if (pd != null) {
			if (pd.equals("in")) {// 管理员-添加
				insert(request, response);
				response.sendRedirect("admin/Teacher/Teacher.jsp");
			}
			if (pd.equals("up")) {// 管理员-修改
				update(request, response);
				response.sendRedirect("admin/Teacher/Teacher.jsp");
			}
			if (pd.equals("de")) {// 管理员-删除
				delete(request, response);
				response.sendRedirect("admin/Teacher/Teacher.jsp");
			}
			if (pd.equals("se")) {// 管理员-查询
				TeacherInfo(request, response);
			}
			if (pd.equals("Reset")) {// 密码重置
				ResetPwd(request, response);
				response.sendRedirect("admin/Teacher/Teacher.jsp");
			}
			if (pd.equals("upIn")) {// 基本信息修改
				updateIn(request, response);
				request.setAttribute("Success", "信息修改成功");
				response.sendRedirect("Teacher/TeacherRevise.jsp");
			}
			if (pd.equals("upPwd")) {// 登录密码修改
				boolean pwdpd=updatePwd(request,response);
				if(pwdpd){
					request.getSession().setAttribute("Tpd", "true");
				}else {
					request.getSession().setAttribute("Tpd", "false");
				}
				response.sendRedirect("Teacher/TeacherRevisePwd.jsp");
			}
			if (pd.equals("exit")) {// 退出登录
				TeacherExit(request, response);
			}
		} else {
			Photo(request, response);// 照片修改
			response.sendRedirect("Teacher/TeacherRevise.jsp");
		}
	}

	// 退出登录
	void TeacherExit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("Tlogin", null);
		try {
			request.getRequestDispatcher("Teacher/login.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 管理员-密码重置
	void ResetPwd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setTeacherID(request.getParameter("TeacherID"));
		teacher.setPassword("123456");
		TeacherInterface tea = SchoolFactory.TeacherInterFace();
		tea.RevisePwd(teacher);
	}

	// 照片修改
	void Photo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			util.fileupload(
					this,
					request,
					"Teacher\\TeacherPhoto",
					((Teacher) (request.getSession().getAttribute("Tlogin")))
							.getPhoto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 登录密码修改
	boolean updatePwd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String PastPassword = request.getParameter("PastPassword");
		String NewPassword = request.getParameter("NewPassword");
		TeacherInterface tea = SchoolFactory.TeacherInterFace();
		Teacher teacher = new Teacher();
		teacher.setTeacherID(((Teacher) (request.getSession()
				.getAttribute("Tlogin"))).getTeacherID());
		teacher.setPassword(PastPassword);
		if (tea.login(teacher).getTeacherID() == null) {
			return false;
		}
		teacher.setPassword(NewPassword);
		tea.RevisePwd(teacher);
		((Teacher) request.getSession().getAttribute("Tlogin"))
				.setPassword(NewPassword);
		return true;
	}

	// 基本信息修改
	void updateIn(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Teacher tea = new Teacher();
		tea.setTeacherID(request.getParameter("TeacherID"));
		tea.setName(request.getParameter("Name"));
		tea.setSex(request.getParameter("Sex"));
		tea.setBirthday(request.getParameter("Birthday"));
		tea.setKulture(request.getParameter("Kulture"));
		tea.setPhone(request.getParameter("Phone"));
		tea.setHome(request.getParameter("Home"));
		tea.setRemark(request.getParameter("Remark"));
		TeacherInterface Sch = SchoolFactory.TeacherInterFace();
		Sch.UpdateIn(tea);
		((Teacher) request.getSession().getAttribute("Tlogin")).setName(tea
				.getName());
		((Teacher) request.getSession().getAttribute("Tlogin")).setSex(tea
				.getSex());
		((Teacher) request.getSession().getAttribute("Tlogin")).setBirthday(tea
				.getBirthday());
		((Teacher) request.getSession().getAttribute("Tlogin")).setKulture(tea
				.getKulture());
		((Teacher) request.getSession().getAttribute("Tlogin")).setPhone(tea
				.getPhone());
		((Teacher) request.getSession().getAttribute("Tlogin")).setHome(tea
				.getHome());
		((Teacher) request.getSession().getAttribute("Tlogin")).setRemark(tea
				.getRemark());

	}

	// 管理员-添加
	void insert(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Teacher tea = new Teacher();
		if (request.getParameter("TeacherID") != ""
				&& request.getParameter("Name") != "") {
			tea.setTeacherID(request.getParameter("TeacherID"));
			tea.setName(request.getParameter("Name"));
			College college = new College();
			college.setCollegeID(request.getParameter("CollegeID"));
			tea.setCollege(college);
			tea.setSex(request.getParameter("Sex"));
			tea.setBirthday(request.getParameter("Birthday"));
			tea.setKulture(request.getParameter("Kulture"));
			tea.setPhone(request.getParameter("Phone"));
			tea.setHome(request.getParameter("Home"));
			tea.setPhoto(tea.getTeacherID());
			tea.setPassword("123456");
			tea.setRemark(request.getParameter("Remark"));
			TeacherInterface Sch = SchoolFactory.TeacherInterFace();
			Sch.insert(tea);
		}
	}

	// 管理员-修改
	void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Teacher tea = new Teacher();
		tea.setTeacherID(request.getParameter("TeacherID"));
		tea.setName(request.getParameter("Name"));
		tea.setSex(request.getParameter("Sex"));
		tea.setBirthday(request.getParameter("Birthday"));
		tea.setKulture(request.getParameter("Kulture"));
		tea.setPhone(request.getParameter("Phone"));
		tea.setHome(request.getParameter("Home"));
		tea.setRemark(request.getParameter("Remark"));
		TeacherInterface Sch = SchoolFactory.TeacherInterFace();
		Sch.update(tea);
	}

	// 管理员-删除
	void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String TeacherID = request.getParameter("TeacherID");
		TeacherInterface Sch = SchoolFactory.TeacherInterFace();
		Sch.delete(TeacherID);
	}

	// 管理员-查询
	void TeacherInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		TeacherInterface Sch = SchoolFactory.TeacherInterFace();
		List<Teacher> list = Sch.select(request.getParameter("CollegeID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
}

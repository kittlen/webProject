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

import com.qyc.OneProject.Model.Class;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.StudentInterface;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class StudentMgrServlet
 */
@WebServlet("/StudentMgrServlet")
public class StudentMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentMgrServlet() {
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
				response.sendRedirect("admin/Student/Student.jsp");
			}
			if (pd.equals("up")) {// 管理员-修改
				update(request, response);
				response.sendRedirect("admin/Student/Student.jsp");
			}
			if (pd.equals("de")) {// 管理员-删除
				delete(request, response);
				response.sendRedirect("admin/Student/Student.jsp");
			}
			if (pd.equals("se")) {// 管理员-查询
				StudentInfo(request, response);
			}
			if (pd.equals("Reset")) {// 管理员-密码重置
				ResetPwd(request, response);
				response.sendRedirect("admin/Student/Student.jsp");
			}
			if (pd.equals("upIn")) {// 基本信息修改
				updateIn(request, response);
				request.setAttribute("Success", "信息修改成功");
				response.sendRedirect("Student/StudentRevise.jsp");
			}
			if (pd.equals("upPwd")) {// 登录密码修改
				boolean pwdpd=updatePwd(request,response);
				if(pwdpd){
					request.getSession().setAttribute("Spd", "true");
				}else {
					request.getSession().setAttribute("Spd", "false");
				}
				response.sendRedirect("Student/StudentRevisePwd.jsp");
			}
			if(pd.equals("exit")){//退出登录
				StudentExit(request,response);
			}
		} else {
			Photo(request, response);// 照片修改
			response.sendRedirect("Student/StudentRevise.jsp");
		}
	}
	
	//退出登录
	void StudentExit(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("Slogin", null);
		try {
			request.getRequestDispatcher("Student/login.jsp").forward(request, response);
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
		Student stu = new Student();
		stu.setStu_ID(request.getParameter("Stu_ID"));
		stu.setPassword("123456");
		StudentInterface Sch = SchoolFactory.StudentInterFace();
		Sch.UpdatePwd(stu);

	}

	// 照片修改
	void Photo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			util.fileupload(
					this,
					request,
					"Student\\StudentPhoto",
					((Student) (request.getSession().getAttribute("Slogin")))
							.getPhoto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 密码修改
	boolean updatePwd(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String PastPassword = request.getParameter("PastPassword");
		String NewPassword = request.getParameter("NewPassword");
		StudentInterface Sch = SchoolFactory.StudentInterFace();
		Student student = (Student) (request.getSession()
				.getAttribute("Slogin"));
		Student stu = new Student();
		stu.setStu_ID(student.getStu_ID());
		stu.setPassword(PastPassword);
		if (Sch.login(stu).getStu_ID() == null) {
			return false;
		}
		stu.setPassword(NewPassword);
		Sch.UpdatePwd(stu);
		((Student) request.getSession().getAttribute("Slogin"))
				.setPassword(NewPassword);
		return true;
	}

	// 基本信息修改
	void updateIn(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if (request.getParameter("Stu_ID") != "") {
			Student stu = new Student();
			stu.setStu_ID(request.getParameter("Stu_ID"));
			stu.setName(request.getParameter("Name"));
			stu.setSex(request.getParameter("Sex"));
			stu.setBirth(request.getParameter("Birth"));
			stu.setPhone(request.getParameter("Phone"));
			stu.setFamily(request.getParameter("Family"));
			stu.setRemark(request.getParameter("Remark"));
			StudentInterface Sch = SchoolFactory.StudentInterFace();
			Sch.UpdateIn(stu);
			((Student) (request.getSession().getAttribute("Slogin")))
					.setName(stu.getName());
			((Student) (request.getSession().getAttribute("Slogin")))
					.setSex(stu.getSex());
			((Student) (request.getSession().getAttribute("Slogin")))
					.setBirth(stu.getBirth());
			((Student) (request.getSession().getAttribute("Slogin")))
					.setPhone(stu.getPhone());
			((Student) (request.getSession().getAttribute("Slogin")))
					.setFamily(stu.getFamily());
			((Student) (request.getSession().getAttribute("Slogin")))
					.setRemark(stu.getRemark());
		}
	}

	// 管理员-添加
	void insert(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		if (request.getParameter("Stu_ID") != ""
				&& request.getParameter("Name") != "") {
			Student stu = new Student();
			Class cla = new Class();
			stu.setStu_ID(request.getParameter("Stu_ID"));
			stu.setName(request.getParameter("Name"));
			stu.setSex(request.getParameter("Sex"));
			stu.setBirth(request.getParameter("Birth"));
			cla.setClass_ID(request.getParameter("Class_ID"));
			stu.setTClass(cla);
			stu.setPhone(request.getParameter("Phone"));
			stu.setFamily(request.getParameter("Family"));
			stu.setPhoto(stu.getStu_ID());
			stu.setPassword("123456");
			stu.setRemark(request.getParameter("Remark"));
			StudentInterface Sch = SchoolFactory.StudentInterFace();
			Sch.insert(stu);
		}
	}

	// 管理员-修改
	void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Student stu = new Student();
		stu.setStu_ID(request.getParameter("Stu_ID"));
		stu.setName(request.getParameter("Name"));
		stu.setSex(request.getParameter("Sex"));
		stu.setBirth(request.getParameter("Birth"));
		stu.setPhone(request.getParameter("Phone"));
		stu.setFamily(request.getParameter("Family"));
		stu.setRemark(request.getParameter("Remark"));
		StudentInterface Sch = SchoolFactory.StudentInterFace();
		Sch.update(stu);
	}

	// 管理员-删除
	void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String Stu_ID = request.getParameter("Stu_ID");
		StudentInterface Sch = SchoolFactory.StudentInterFace();
		Sch.delete(Stu_ID);
	}

	// 管理员-查询
	void StudentInfo(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		StudentInterface Sch = SchoolFactory.StudentInterFace();
		List<Student> list = Sch.select(request.getParameter("Class_ID"));
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

}

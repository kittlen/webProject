package com.qyc.OneProject.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.Model.Teacher;
import com.qyc.OneProject.sevice.AdminFactory;
import com.qyc.OneProject.sevice.AdminInterface;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.StudentInterface;
import com.qyc.OneProject.sevice.TeacherInterface;

/**
 * Servlet implementation class LoginMgrServlet
 */
@WebServlet("/LoginMgrServlet")
public class LoginMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMgrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		if(user.equals("S")){//学生登录验证
			SLogin(request,response);
		}
		if(user.equals("T")){//教师登录验证
			TLogin(request,response);
		}
		if(user.equals("A")){//管理员登录验证
			ALogin(request,response);
		}
	}
	// 学生登录验证
		void SLogin(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			Student student = new Student();
			student.setStu_ID(request.getParameter("ID"));
			student.setPassword(request.getParameter("Password"));
			StudentInterface Sch = SchoolFactory.StudentInterFace();
			Student stu = new Student();
			stu = Sch.login(student);
			try {
				if (stu.getStu_ID() == null) {
					request.setAttribute("error", "账号或密码错误");
					request.getRequestDispatcher("Student/login.jsp").forward(
							request, response);
				} else {
					request.getSession().setAttribute("Slogin", stu);
					response.sendRedirect("Student/OptCourseSchedule.jsp");
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	// 教师登录验证
		void TLogin(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			Teacher teacher = new Teacher();
			teacher.setTeacherID(request.getParameter("ID"));
			teacher.setPassword(request.getParameter("Password"));
			TeacherInterface teaIn = SchoolFactory.TeacherInterFace();
			Teacher tea = teaIn.login(teacher);
			try {
				if (tea.getTeacherID() == null) {
					request.setAttribute("error", "账号或密码错误");
					request.getRequestDispatcher("Teacher/login.jsp").forward(
							request, response);
				} else {
					request.getSession().setAttribute("Tlogin", tea);
					response.sendRedirect("Teacher/TimeTables.jsp");
				}
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//管理员登录验证
		void ALogin(HttpServletRequest request, HttpServletResponse response) {
			Admin admin=new Admin();
			admin.setAdminID(request.getParameter("ID"));
			admin.setPassword(request.getParameter("Password"));
			AdminInterface adIn=AdminFactory.AdminInterFace();
			Admin adm=new Admin();
			try {
				adm=adIn.login(admin);
				if(adm.getAdminID()==null){
					request.setAttribute("error", "账号或密码错误");
					request.getRequestDispatcher("admin/Admin/login.jsp").forward(request, response);
				}else {
					request.getSession().setAttribute("login", adm);
					response.sendRedirect("admin/Admin/AdminReleaseInfo.jsp");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

}

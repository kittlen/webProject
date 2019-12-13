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
import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.sevice.DepartmentInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class DepartmentMgrServlet
 */
@WebServlet("/DepartmentMgrServlet")
public class DepartmentMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentMgrServlet() {
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
		String pd=request.getParameter("judge");
		if(pd.equals("in")){
			insert(request, response);response.sendRedirect("admin/Department/Department.jsp");
		}
		if(pd.equals("up")){
			update(request, response);response.sendRedirect("admin/Department/Department.jsp");
		}
		if(pd.equals("de")){
			delete(request, response);response.sendRedirect("admin/Department/Department.jsp");
		}
		if(pd.equals("se")){
			DepartmentInfo(request, response);
		}
	}

	void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("DepartmentID")!=""&&request.getParameter("DepartmentName")!=""){
			Department dep=new Department();
			College col=new College();
			dep.setDepartmentID(request.getParameter("DepartmentID"));
			dep.setDepartmentName(request.getParameter("DepartmentName"));
			col.setCollegeID(request.getParameter("CollegeID"));
			dep.setCollege(col);
			dep.setRemark(request.getParameter("Remark"));
			DepartmentInterface Sch=SchoolFactory.DepartmentInterFace();
			Sch.insert(dep);
		}
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Department dep=new Department();
		College col=new College();
		dep.setDepartmentID(request.getParameter("DepartmentID"));
		dep.setDepartmentName(request.getParameter("DepartmentName"));
		col.setCollegeID(request.getParameter("CollegeID"));
		dep.setCollege(col);
		dep.setRemark(request.getParameter("Remark"));
		DepartmentInterface Sch=SchoolFactory.DepartmentInterFace();
		Sch.update(dep);
	}
	
	void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String DepartmentID=request.getParameter("DepartmentID");
		DepartmentInterface Sch=SchoolFactory.DepartmentInterFace();
		Sch.delete(DepartmentID);
	}
	void DepartmentInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		DepartmentInterface Sch=SchoolFactory.DepartmentInterFace();
		List<Department> list=Sch.select(request.getParameter("CollegeID"));
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
}

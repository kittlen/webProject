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
import com.qyc.OneProject.sevice.CollegeInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class CollegeInUpDe
 */
@WebServlet("/CollegeMgrServlet")
public class CollegeMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeMgrServlet() {
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
			insert(request, response);response.sendRedirect("admin/College/College.jsp");
		}
		if(pd.equals("up")){
			update(request, response);response.sendRedirect("admin/College/College.jsp");
		}
		if(pd.equals("de")){
			delete(request, response);response.sendRedirect("admin/College/College.jsp");
		}
		if(pd.equals("se")){
			CollegeInfo(request, response);
		}
		
	}
	void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("CollegeID")!=""&&request.getParameter("CollegeName")!=""){
			College college=new College();
			college.setCollegeID(request.getParameter("CollegeID"));
			college.setCollegeName(request.getParameter("CollegeName"));
			college.setRemark(request.getParameter("Remark"));
			CollegeInterface Sch=SchoolFactory.CollegeInterFace();
			Sch.insert(college);
		}
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		College college=new College();
		college.setCollegeID(request.getParameter("CollegeID"));
		college.setCollegeName(request.getParameter("CollegeName"));
		college.setRemark(request.getParameter("Remark"));
		CollegeInterface Sch=SchoolFactory.CollegeInterFace();
		Sch.update(college);
	}
	
	void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String CollegeID=request.getParameter("CollegeID");
		CollegeInterface Sch=SchoolFactory.CollegeInterFace();
		Sch.delete(CollegeID);
	}
	void CollegeInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		CollegeInterface Sch=SchoolFactory.CollegeInterFace();
		List<College> list=Sch.select();
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

}

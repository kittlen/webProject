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
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.sevice.ClassInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class ClassMgrServlet
 */
@WebServlet("/ClassMgrServlet")
public class ClassMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassMgrServlet() {
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
			insert(request, response);response.sendRedirect("admin/Class/Class.jsp");
		}
		if(pd.equals("up")){
			update(request, response);response.sendRedirect("admin/Class/Class.jsp");
		}
		if(pd.equals("de")){
			delete(request, response);response.sendRedirect("admin/Class/Class.jsp");
		}
		if(pd.equals("se")){
			ClassInfo(request, response);
		}
	}
	
	void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("Class_ID")!=""&&request.getParameter("GradeName")!=""&&
				request.getParameter("YearName")!=""){
			Class cla=new Class();
			Profession pro=new Profession();
			cla.setClass_ID(request.getParameter("Class_ID"));
			cla.setGradeName(request.getParameter("GradeName"));
			cla.setYearName(request.getParameter("YearName"));
			pro.setProfessionID(request.getParameter("ProfessionID"));
			cla.setProfession(pro);
			cla.setRemark(request.getParameter("Remark"));
			ClassInterface Sch=SchoolFactory.ClassInterFace();
			Sch.insert(cla);
		}
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Class cla=new Class();
		Profession pro=new Profession();
		cla.setClass_ID(request.getParameter("Class_ID"));
		cla.setGradeName(request.getParameter("GradeName"));
		cla.setYearName(request.getParameter("YearName"));
		pro.setProfessionID(request.getParameter("ProfessionID"));
		cla.setProfession(pro);
		cla.setRemark(request.getParameter("Remark"));
		ClassInterface Sch=SchoolFactory.ClassInterFace();
		Sch.update(cla);
	}
	
	void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String Class_ID=request.getParameter("Class_ID");
		ClassInterface Sch=SchoolFactory.ClassInterFace();
		Sch.delete(Class_ID);
	}
	void ClassInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ClassInterface Sch=SchoolFactory.ClassInterFace();
		List<Class> list=Sch.select(request.getParameter("ProfessionID"));
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

}

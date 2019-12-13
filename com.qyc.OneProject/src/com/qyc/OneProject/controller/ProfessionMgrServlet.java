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

import com.qyc.OneProject.Model.Department;
import com.qyc.OneProject.Model.Profession;
import com.qyc.OneProject.sevice.ProfessionInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class ProfessionMgrServlet
 */
@WebServlet("/ProfessionMgrServlet")
public class ProfessionMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessionMgrServlet() {
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
			insert(request, response);response.sendRedirect("admin/Profession/Profession.jsp");
		}
		if(pd.equals("up")){
			update(request, response);response.sendRedirect("admin/Profession/Profession.jsp");
		}
		if(pd.equals("de")){
			delete(request, response);response.sendRedirect("admin/Profession/Profession.jsp");
		}
		if(pd.equals("se")){
			ProfessionInfo(request, response);
		}
	}
		void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
			if(request.getParameter("ProfessionID")!=""&&request.getParameter("ProfessionName")!=""){
				Profession pro=new Profession();
				Department dep=new Department();
				pro.setProfessionID(request.getParameter("ProfessionID"));
				pro.setProfessionName(request.getParameter("ProfessionName"));
				dep.setDepartmentID(request.getParameter("DepartmentID"));
				pro.setDepartment(dep);
				pro.setRemark(request.getParameter("Remark"));
				ProfessionInterface Sch=SchoolFactory.ProfessionInterFace();
				Sch.insert(pro);
			}
		}
		
		void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
			Profession pro=new Profession();
			Department dep=new Department();
			pro.setProfessionID(request.getParameter("ProfessionID"));
			pro.setProfessionName(request.getParameter("ProfessionName"));
			dep.setDepartmentID(request.getParameter("DepartmentID"));
			pro.setDepartment(dep);
			pro.setRemark(request.getParameter("Remark"));
			ProfessionInterface Sch=SchoolFactory.ProfessionInterFace();
			Sch.update(pro);
		}
		
		void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
			String ProfessionID=request.getParameter("ProfessionID");
			ProfessionInterface Sch=SchoolFactory.ProfessionInterFace();
			Sch.delete(ProfessionID);
		}
		void ProfessionInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
			ProfessionInterface Sch=SchoolFactory.ProfessionInterFace();
			List<Profession> list=Sch.select(request.getParameter("DepartmentID"));
			JSONArray json=JSONArray.fromObject(list);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw=response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		}

}

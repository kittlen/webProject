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
import com.qyc.OneProject.Model.Audit;
import com.qyc.OneProject.Model.TeachTask;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.sevice.AdminFactory;
import com.qyc.OneProject.sevice.AuditInterface;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class AuditMgrServlet
 */
@WebServlet("/AuditMgrServlet")
public class AuditMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuditMgrServlet() {
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
		String pd = request.getParameter("judge");
		if(pd.equals("se")){//课程信息
			select(request,response);
		}
		if(pd.equals("in")){//管理员课程审核(事务处理)-课程审核表+课程发布表
			insert(request,response);
			response.sendRedirect("admin/Audit/Audit.jsp");
		}
	}
	//管理员课程审核
	void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String Auditing = new String(request.getParameter("Auditing").getBytes("ISO8859-1"),"UTF-8");
			TeachTask task=new TeachTask();
			task.setID(Integer.parseInt(request.getParameter("TeachTaskID")));
			Audit audit=new Audit();
			audit.setTeachTask(task);
			audit.setAuditDate(util.getNowDetailedTime());
			audit.setAdmin((Admin)(request.getSession().getAttribute("login")));
			AuditInterface aInterface=AdminFactory.AuditInterFace();
			aInterface.insert(audit,Auditing);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取审核状态
		
		
	}
	//课程信息
	void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String Curricula=request.getParameter("Curricula");
			AuditInterface aInterface=AdminFactory.AuditInterFace();
			List<VTeachTask> list=aInterface.select(Curricula);
			JSONArray json=JSONArray.fromObject(list);
			response.setCharacterEncoding("UTF-8");
			PrintWriter pw=response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

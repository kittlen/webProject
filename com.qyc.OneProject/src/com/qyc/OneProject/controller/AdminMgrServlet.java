package com.qyc.OneProject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.sevice.AdminFactory;
import com.qyc.OneProject.sevice.AdminInterface;
import com.qyc.OneProject.util.util;

/**
 * Servlet implementation class AdminMgrServlet
 */
@WebServlet("/AdminMgrServlet")
public class AdminMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMgrServlet() {
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
		if (pd != null) {
			if (pd.equals("upIn")) {//基本信息修改
				updateIn(request, response);
				request.setAttribute("Success", "信息修改成功");
				response.sendRedirect("admin/Admin/AdminRevise.jsp");
			}
			if(pd.equals("upPwd")){//登录密码修改
				boolean pwdpd=updatePwd(request,response);
				if(pwdpd){
					request.getSession().setAttribute("pd", "true");
				}else {
					request.getSession().setAttribute("pd", "false");
				}
				response.sendRedirect("admin/Admin/AdminRevisePwd.jsp");
			}
			if(pd.equals("Reset")){//管理员-密码重置
				ResetPwd(request,response);
			}
			if(pd.equals("exit")){//退出登录
				AdminExit(request,response);
			}
			if(pd.equals("in")){//管理员-添加
				insert(request, response);response.sendRedirect("admin/Admin/Admin.jsp");
			}
			if(pd.equals("up")){//管理员-修改
				update(request, response);response.sendRedirect("admin/Admin/Admin.jsp");
			}
			if(pd.equals("de")){//管理员-删除
				delete(request, response);response.sendRedirect("admin/Admin/Admin.jsp");
			}
			if(pd.equals("se")){//管理员-查询
				AdminInfo(request, response);
			}
		}else {
			Photo(request,response);//照片修改
			response.sendRedirect("admin/Admin/AdminRevise.jsp");
		}
		
	}
	//退出登录
	void AdminExit(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("login", null);
		try {
			request.getRequestDispatcher("admin/Admin/login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//管理员-密码重置
	void ResetPwd(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setAdminID(request.getParameter("AdminID"));
		admin.setPassword("123456");
		AdminInterface adIn=AdminFactory.AdminInterFace();
		adIn.ResetPwd(admin);
		try {
			response.sendRedirect("admin/Admin/Admin.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//管理员添加
	void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("AdminID")!=""&&request.getParameter("Password")!=""){
			Admin adm=new Admin();
			adm.setAdminID(request.getParameter("AdminID"));
			adm.setAdminName(request.getParameter("AdminName"));
			adm.setPassword("123456");
			adm.setPhoto(request.getParameter("AdminID"));
			adm.setPower(request.getParameter("power"));
			adm.setRemark(request.getParameter("Remark"));
			AdminInterface adIn=AdminFactory.AdminInterFace();
			try {
				adIn.insert(adm);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//管理员-修改
	void update(HttpServletRequest request, HttpServletResponse response){
		if(request.getParameter("AdminID")!=""&&request.getParameter("Password")!=""){
			Admin adm=new Admin();
			adm.setAdminID(request.getParameter("AdminID"));
			adm.setAdminName(request.getParameter("AdminName"));
			adm.setPower(request.getParameter("power"));
			adm.setRemark(request.getParameter("Remark"));
			AdminInterface adIn=AdminFactory.AdminInterFace();
			adIn.update(adm);
		}
	}
	
	//管理员-删除
	void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Admin adm=new Admin();
		adm.setAdminID(request.getParameter("AdminID"));
		AdminInterface adIn=AdminFactory.AdminInterFace();
		adIn.delete(adm);
	}
	//管理员-查询
	void AdminInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		AdminInterface adIn=AdminFactory.AdminInterFace();
		List<Admin> list=adIn.select();
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
	//密码修改
	boolean updatePwd(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String PastPassword=request.getParameter("PastPassword");
		String NewPassword=request.getParameter("NewPassword");
		AdminInterface adIn=AdminFactory.AdminInterFace();
		Admin admin=(Admin)(request.getSession().getAttribute("login"));
		Admin adm=new Admin();
		adm.setAdminID(admin.getAdminID());
		adm.setPassword(PastPassword);
		try {
			if(adIn.login(adm).getAdminID()==null){
				return false;
			}
			adm.setPassword(NewPassword);
			adIn.ResetPwd(adm);
			((Admin)request.getSession().getAttribute("login")).setPassword(NewPassword);
			return true;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	//基本信息修改
	void updateIn(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(request.getParameter("AdminID")!=""){
			Admin adm=new Admin();
			adm.setAdminID(request.getParameter("AdminID"));
			adm.setAdminName(request.getParameter("AdminName"));
			adm.setRemark(request.getParameter("Remark"));
			AdminInterface adIn=AdminFactory.AdminInterFace();
			adIn.UpdateIn(adm);
			((Admin)(request.getSession().getAttribute("login"))).setAdminName(adm.getAdminName());
			((Admin)(request.getSession().getAttribute("login"))).setRemark(adm.getRemark());
		}

	}
	//照片修改
	void Photo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			util.fileupload(this, request, "admin\\adminphoto", ((Admin)(request.getSession().getAttribute("login"))).getPhoto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}

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

import com.qyc.OneProject.Model.ClassRoom;
import com.qyc.OneProject.sevice.ClassRoomInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

/**
 * Servlet implementation class ClassRoomMgrServlet
 */
@WebServlet("/ClassRoomMgrServlet")
public class ClassRoomMgrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomMgrServlet() {
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
			insert(request, response);response.sendRedirect("admin/ClassRoom/ClassRoom.jsp");
		}
		if(pd.equals("up")){
			update(request, response);response.sendRedirect("admin/ClassRoom/ClassRoom.jsp");
		}
		if(pd.equals("de")){
			delete(request, response);response.sendRedirect("admin/ClassRoom/ClassRoom.jsp");
		}
		if(pd.equals("se")){
			ClassRoomInfo(request, response);
		}
		if(pd.equals("Nse")){//获取教师名称
			ClassRoomNameInfo(request, response);
		}

	}
	void ClassRoomNameInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String ClassRoomCategory=request.getParameter("ClassRoomCategory");
		ClassRoomInterface Sch=SchoolFactory.ClassRoomInterFace();
		List<ClassRoom> list=Sch.Nameselect(ClassRoomCategory);
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(json.toString());
			pw.close();
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void insert(HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(request.getParameter("ID")!=""&&request.getParameter("ClassRoomName")!=""){
			ClassRoom ClassRoom=new ClassRoom();
			ClassRoom.setID(request.getParameter("ID"));
			ClassRoom.setClassRoomName(request.getParameter("ClassRoomName"));
			ClassRoom.setClassRoomCategory(request.getParameter("ClassRoomCategory"));
			ClassRoom.setRemark(request.getParameter("Remark"));
			ClassRoomInterface Sch=SchoolFactory.ClassRoomInterFace();
			Sch.insert(ClassRoom);
		}
	}
	
	void update(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ClassRoom ClassRoom=new ClassRoom();
		ClassRoom.setID(request.getParameter("ID"));
		ClassRoom.setClassRoomName(request.getParameter("ClassRoomName"));
		ClassRoom.setClassRoomCategory(request.getParameter("ClassRoomCategory"));
		ClassRoom.setRemark(request.getParameter("Remark"));
		ClassRoomInterface Sch=SchoolFactory.ClassRoomInterFace();
		Sch.update(ClassRoom);
	}
	void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String ClassRoomID=request.getParameter("ID");
		ClassRoomInterface Sch=SchoolFactory.ClassRoomInterFace();
		Sch.delete(ClassRoomID);
	}
	void ClassRoomInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ClassRoomInterface Sch=SchoolFactory.ClassRoomInterFace();
		List<ClassRoom> list=Sch.select();
		JSONArray json=JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw=response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

}

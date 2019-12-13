package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Student;
import com.qyc.OneProject.sevice.SchoolFactory;
import com.qyc.OneProject.sevice.StudentInterface;

public class StudentAction implements ModelDriven<Student> {

	private Student stu = new Student();
	private String err;
	private String pd;

	StudentInterface istu = SchoolFactory.StudentInterFace();

	public String Login() {
		Student thisstu = istu.login(stu);
		if (thisstu != null) {
			ActionContext.getContext().getSession().put("Slogin", thisstu);
			return "success";
		} else {
			setErr("�˺Ż��������");
			return "error";
		}
	}

	public String insert() {
		istu.insert(stu);
		return "success";
	}

	// ���˻�����Ϣ�޸�
	public String updateIn() {
		Student thisStu=istu.UpdateIn(stu);
		if (thisStu!=null) {
			ActionContext.getContext().getSession().put("Slogin", thisStu);
		}
		return "success";
	}
	//�����޸�
	public String updatePwd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String PastPassword = request.getParameter("PastPassword");// ������
		String NewPassword = request.getParameter("NewPassword");// ������
		stu.setPassword(PastPassword);
		Student thisStu=null;
		thisStu = istu.login(stu);
		if (thisStu != null) {
			thisStu.setPassword(NewPassword);
			istu.UpdatePwd(thisStu);
			request.getSession().setAttribute("Slogin", thisStu);
			setPd("true");
		} else {
			setPd("false");
		}
		return "success";
	}

	public String update() {
		istu.update(stu);
		return "success";
	}

	public String delete() {
		istu.delete(stu);
		return "success";
	}

	//��������
	public String reset() {
		stu.setPassword("123456");
		istu.UpdatePwd(stu);
		return "success";
	}

	public void StudentInfo() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Student> list = istu.select(request.getParameter("Class_ID"));
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				// TODO Auto-generated method stub
				// ��� xxx �Ǹ�������������˾����� ��Ӧmode�Ķ�Ӧ����
				if (arg1.equals("TClass"))
					return true;
				return false;
			}
		});
		JSONArray json = JSONArray.fromObject(list, config);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public String getPd() {
		return pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

	

}

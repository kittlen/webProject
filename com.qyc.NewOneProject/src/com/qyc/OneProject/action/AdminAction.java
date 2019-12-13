package com.qyc.OneProject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Admin;
import com.qyc.OneProject.sevice.AdminFactory;
import com.qyc.OneProject.sevice.AdminInterface;

public class AdminAction implements ModelDriven<Admin> {
	private Admin admin = new Admin();
	private String err;
	private String pd;

	AdminInterface iadm = AdminFactory.AdminInterFace();

	public String Login() {
		Admin thisAdmin = null;
		try {
			thisAdmin = iadm.login(admin);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (thisAdmin != null) {
			ActionContext.getContext().getSession().put("login", thisAdmin);
			return "success";
		} else {
			setErr("账号或密码错误");
			return "error";
		}
	}

	public String insert() throws NoSuchAlgorithmException {
		iadm.insert(admin);
		return "success";
	}

	public String update() {
		iadm.update(admin);
		return "success";
	}

	public String delete() {
		if (admin.getAdminID().equals(admin)) {
			return "success";
		}
		iadm.delete(admin);
		return "success";
	}

	// 管理员信息修改
	public String updateIn() {
		Admin thisAdm=iadm.UpdateIn(admin);
		if (thisAdm!=null) {
			ActionContext.getContext().getSession().put("login", thisAdm);
		}
		return "success";
	}

	// 重置密码
	public String reset() {
		admin.setPassword("123456");
		iadm.UpdatePwd(admin);
		return "success";
	}

	// 管理员列表
	public void AdminInfo() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Admin> list = iadm.select();
		JSONArray json = JSONArray.fromObject(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	// 修改密码
	public String updatePwd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String PastPassword = request.getParameter("PastPassword");// 旧密码
		String NewPassword = request.getParameter("NewPassword");// 新密码
		admin.setPassword(PastPassword);
		Admin adm = null;
		try {
			adm = iadm.login(admin);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (adm != null) {
			adm.setPassword(NewPassword);
			iadm.UpdatePwd(adm);
			request.getSession().setAttribute("login", adm);
			setPd("true");
		} else {
			setPd("false");
		}
		return "success";
	}

	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
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

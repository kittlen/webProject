package com.qyc.OneProject.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.OneProject.Model.Student;


@SuppressWarnings("serial")
public class StudentPhoto extends ActionSupport {

	private File image; // �ϴ����ļ� ��Ӧjsp�ļ��� <input type="file" accept=" image/jpg"
						// name="image"> name
	private String imageFileName; // �ļ�����
	private String imageContentType; // �ļ�����

	// ��Ƭ�޸�
	public String execute() throws Exception {

		String dirname="Student\\studentphoto";//ͼƬ�ļ���
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Student student = (Student) request.getSession().getAttribute("Slogin");// ��ȡ����
		imageFileName = student.getPhoto();// �����ļ���Ϊ������Ƭ�ֶ�
		
		
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")+dirname;// ��ȡ����������·��+�����ļ�����·��*/
		/*String fi =request.getSession().getServletContext().getRealPath("/")+dirname;*///��һ�ֻ�ȡ·����ʽ
		
		
		/*
		 * //��ȡ��ǰ�����ļ�·�� String
		 * realpath=this.getClass().getClassLoader().getResource
		 * ("../student/studentphoto").getPath();
		 */
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		String type = "."
				+ imageContentType
						.substring(imageContentType.lastIndexOf("/") + 1);// ��ȡ�ļ�����

		if (type.equals(".jpeg")) {// jpg�ļ������ļ����ͻ�ת����jpeg �˴�����ת��
			type = ".jpg";
		}
		if (!type.equals(".jpg")) {// �˴������ļ���ʽ����
			return "success";
		}
		System.out.println("realpath: " + realpath);// ����ļ�����·��
		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(realpath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (image != null) {
			System.out.println("�����ϴ��ļ�");
			File savefile = new File(new File(realpath), imageFileName + type);// �����ļ�·������File����
			// �����Ӧ·���ļ�����,��ɾ���ļ�
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);// ����������File���ļ�imag���Ƶ�savefile��Ӧ·����
			System.out.println("�ϴ����");
			/* ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�"); */
		}
		return "success";
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

}
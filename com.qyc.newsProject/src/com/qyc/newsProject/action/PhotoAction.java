package com.qyc.newsProject.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.UserService;

@SuppressWarnings("serial")
public class PhotoAction extends ActionSupport {

	private File image; // �ϴ����ļ� ��Ӧjsp�ļ��� <input type="file" accept=" image/jpg" name="image"> name
	private String imageFileName; // �ļ�����
	private String imageContentType; // �ļ�����
	private UserService iUserService;//ҵ��
	private String er;//����

	//��Ƭ�޸�
	public String execute() throws Exception {
		String dirname="user/userPhoto";//ͼƬ�ļ���
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User)request.getSession().getAttribute("login");//��ȡ����
		imageFileName=user.getPhoto();//�����ļ���Ϊ������Ƭ�ֶ�
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")+dirname;//��ȡ����������·��+�����ļ�����·��
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		String expandedName = ""; // �ļ���չ��
		if (imageContentType.equals("image/pjpeg")
				|| imageContentType.equals("image/jpeg")) {
			// IE6�ϴ�jpgͼƬ��headimageContentType��image/pjpeg����IE9�Լ�����ϴ���jpgͼƬ��image/jpeg
			expandedName = ".jpg";
		} else if (imageContentType.equals("image/png")
				|| imageContentType.equals("image/x-png")) {
			// IE6�ϴ���pngͼƬ��headimageContentType��"image/x-png"
			expandedName = ".png";
		} else if (imageContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (imageContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			setEr("0");
			return "success";
		}
		System.out.println("realpath: " + realpath);//����ļ�����·��
		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(realpath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (image != null) {
			System.out.println("�����ϴ��ļ�");
			File savefile = new File(new File(realpath), imageFileName+expandedName);//�����ļ�·������File����
			//�����Ӧ·���ļ�����,��ɾ���ļ�
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);//����������File���ļ�imag���Ƶ�savefile��Ӧ·����
			user.setPhotoType(expandedName);
			iUserService.updatePhoto(user);
			System.out.println("�ϴ����");
			/*ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�");*/
		}
		setEr("1");
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

	public String getEr() {
		return er;
	}

	public void setEr(String er) {
		this.er = er;
	}

	public UserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(UserService iUserService) {
		this.iUserService = iUserService;
	}
	

}
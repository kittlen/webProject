package com.qyc.OneProject.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class NoticePhoto {

	private File upload; // �ļ�
	private String uploadContentType; // �ļ�����
	private String uploadFileName; // �ļ���

	/**
	 * ͼƬ�ϴ�
	 * 
	 * @return
	 * @throws IOException
	 */
	public String imgUpload() throws IOException {
		//ͼƬ�ļ���
		String dirname="NoticeImage";
		// ���response,request
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// CKEditor�ύ�ĺ���Ҫ��һ������
		String callback = request.getParameter("CKEditorFuncNum");
		String expandedName = ""; // �ļ���չ��
		if (uploadContentType.equals("image/pjpeg")
				|| uploadContentType.equals("image/jpeg")) {
			// IE6�ϴ�jpgͼƬ��headimageContentType��image/pjpeg����IE9�Լ�����ϴ���jpgͼƬ��image/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png")
				|| uploadContentType.equals("image/x-png")) {
			// IE6�ϴ���pngͼƬ��headimageContentType��"image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'�ļ���ʽ����ȷ������Ϊ.jpg/.gif/.bmp/.png�ļ���');");
			out.println("</script>");
			return null;
		}
		if (upload.length() > 600 * 1024) {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'�ļ���С���ô���600k');");
			out.println("</script>");
			return null;
		}

		InputStream is = new FileInputStream(upload);
		// ͼƬ�ϴ�·��
		String uploadPath = ServletActionContext.getServletContext()
				.getRealPath("/")+dirname;
		String fileName = java.util.UUID.randomUUID().toString(); // ����ʱ��+UUID�ķ�ʽ�漴����
		fileName += expandedName;
		File file = new File(uploadPath);
		if (!file.exists()) { // ���·�������ڣ�����
			file.mkdirs();
		}
		System.out.println(uploadPath);
		File toFile = new File(uploadPath, fileName);
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

		// ����"ͼ��"ѡ�����ʾͼƬ request.getContextPath()Ϊweb��Ŀ��
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + callback
				+ ",'" + request.getContextPath() + "/"+dirname+"/"
				+ fileName + "','')");
		out.println("</script>");
		return null;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}

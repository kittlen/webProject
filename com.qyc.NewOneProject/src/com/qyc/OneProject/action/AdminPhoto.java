package com.qyc.OneProject.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.OneProject.Model.Admin;

@SuppressWarnings("serial")
public class AdminPhoto extends ActionSupport {

	private File image; // 上传的文件 对应jsp文件的 <input type="file" accept=" image/jpg" name="image"> name
	private String imageFileName; // 文件名称 默认为文件默认名
	private String imageContentType; // 文件类型 对应jsp input的accept属性

	//照片修改
	public String execute() throws Exception {
		String dirname="admin\\adminphoto";//图片文件夹
		HttpServletRequest request=ServletActionContext.getRequest();
		Admin admin=(Admin)request.getSession().getAttribute("login");//获取对象
		imageFileName=admin.getPhoto();//设置文件名为对象照片字段
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")+dirname;//获取服务器所在路径+设置文件所在路径
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		String type = "."+imageContentType.substring(imageContentType.lastIndexOf("/")+1);//获取文件类型
		
		/*String type =request.getSession().getServletContext().getRealPath("/")+dirname;*///另一种获取路径方式
		
		/*
		 * //获取当前编译文件路径 String
		 * realpath=this.getClass().getClassLoader().getResource
		 * ("../student/studentphoto").getPath();
		 */
		
		
		if(type.equals(".jpeg")){//jpg文件传输文件类型会转换成jpeg 此处进行转换
			type=".jpg";
		}
		if(!type.equals(".jpg")){//此处用于文件格式设置
			return "success";
		}
		System.out.println("realpath: " + realpath);//输出文件所在路径
		// 如果目录不存在则创建
		File uploadDir = new File(realpath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (image != null) {
			System.out.println("正在上传文件");
			File savefile = new File(new File(realpath), imageFileName+type);//根据文件路径创建File对象
			//如果对应路径文件存在,则删除文件
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);//利用流对象File将文件imag复制到savefile对应路径下
			System.out.println("上传完成");
			/*ActionContext.getContext().put("message", "文件上传成功");*/
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
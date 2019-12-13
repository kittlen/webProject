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

	private File image; // 上传的文件 对应jsp文件的 <input type="file" accept=" image/jpg" name="image"> name
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private UserService iUserService;//业务
	private String er;//错误

	//照片修改
	public String execute() throws Exception {
		String dirname="user/userPhoto";//图片文件夹
		HttpServletRequest request=ServletActionContext.getRequest();
		User user=(User)request.getSession().getAttribute("login");//获取对象
		imageFileName=user.getPhoto();//设置文件名为对象照片字段
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")+dirname;//获取服务器所在路径+设置文件所在路径
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		String expandedName = ""; // 文件扩展名
		if (imageContentType.equals("image/pjpeg")
				|| imageContentType.equals("image/jpeg")) {
			// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
			expandedName = ".jpg";
		} else if (imageContentType.equals("image/png")
				|| imageContentType.equals("image/x-png")) {
			// IE6上传的png图片的headimageContentType是"image/x-png"
			expandedName = ".png";
		} else if (imageContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (imageContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			setEr("0");
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
			File savefile = new File(new File(realpath), imageFileName+expandedName);//根据文件路径创建File对象
			//如果对应路径文件存在,则删除文件
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);//利用流对象File将文件imag复制到savefile对应路径下
			user.setPhotoType(expandedName);
			iUserService.updatePhoto(user);
			System.out.println("上传完成");
			/*ActionContext.getContext().put("message", "文件上传成功");*/
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
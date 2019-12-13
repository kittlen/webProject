package com.qyc.newsProject.action;

import java.io.File;
import java.io.IOException;
import java.util.List;



import net.sf.json.JSONArray;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.newsProject.model.TopImg;
import com.qyc.newsProject.service.TopImgService;
import com.qyc.newsProject.util.util;

@SuppressWarnings("serial")
public class TopImgAction extends ActionSupport {

	private File image; // 上传的文件 对应jsp文件的 <input type="file" accept=" image/jpg"
						// name="image"> name
	private String imageFileName; // 文件名称
	private String imageContentType; // 文件类型
	private String remark;
	private TopImgService iTopImgService;// 业务
	private TopImg topImg;
	private String Ter;// 错误
	private List<TopImg> topImgs;

	// 轮播修改
	public String execute() throws Exception {
		String dirname = "admin/topImg";// 图片文件夹
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")
				+ dirname;// 获取服务器所在路径+设置文件所在路径
		System.out.println("realpath: " + realpath);// 输出文件所在路径
		// 如果目录不存在则创建
		File uploadDir = new File(realpath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (image != null) {
			System.out.println("正在上传文件");
			File savefile = new File(new File(realpath), imageFileName);// 根据文件路径创建File对象
			// 如果对应路径文件存在,则删除文件
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);// 利用流对象File将文件imag复制到savefile对应路径下
			if(save()){
			System.out.println("上传完成");
			}else {
				setTer("0");
				System.out.println("上传失败,信息保存失败");
				return "success";
			}
			/* ActionContext.getContext().put("message", "文件上传成功"); */
		}
		setTer("1");
		return "success";
	}
	public boolean save(){
		topImg.setRemark(remark);
		topImg.setPhoto(imageFileName);
		topImg.setTime(util.getNowTime());
		if(iTopImgService.save(topImg)){
			return true;
		};
		return false;
		
	}
	public void topImgInfo() throws IOException{
		List<TopImg> list=iTopImgService.topImgInfo();
		setTopImgs(list);
		JSONArray json=JSONArray.fromObject(list);
		util.writ(json);
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

	public String getTer() {
		return Ter;
	}

	public void setTer(String ter) {
		Ter = ter;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public TopImgService getiTopImgService() {
		return iTopImgService;
	}

	public void setiTopImgService(TopImgService iTopImgService) {
		this.iTopImgService = iTopImgService;
	}

	public TopImg getTopImg() {
		return topImg;
	}

	public void setTopImg(TopImg topImg) {
		this.topImg = topImg;
	}
	public List<TopImg> getTopImgs() {
		return topImgs;
	}
	public void setTopImgs(List<TopImg> topImgs) {
		this.topImgs = topImgs;
	}

}
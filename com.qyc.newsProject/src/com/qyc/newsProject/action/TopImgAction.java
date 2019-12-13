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

	private File image; // �ϴ����ļ� ��Ӧjsp�ļ��� <input type="file" accept=" image/jpg"
						// name="image"> name
	private String imageFileName; // �ļ�����
	private String imageContentType; // �ļ�����
	private String remark;
	private TopImgService iTopImgService;// ҵ��
	private TopImg topImg;
	private String Ter;// ����
	private List<TopImg> topImgs;

	// �ֲ��޸�
	public String execute() throws Exception {
		String dirname = "admin/topImg";// ͼƬ�ļ���
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/")
				+ dirname;// ��ȡ����������·��+�����ļ�����·��
		System.out.println("realpath: " + realpath);// ����ļ�����·��
		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(realpath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		if (image != null) {
			System.out.println("�����ϴ��ļ�");
			File savefile = new File(new File(realpath), imageFileName);// �����ļ�·������File����
			// �����Ӧ·���ļ�����,��ɾ���ļ�
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			FileUtils.copyFile(image, savefile);// ����������File���ļ�imag���Ƶ�savefile��Ӧ·����
			if(save()){
			System.out.println("�ϴ����");
			}else {
				setTer("0");
				System.out.println("�ϴ�ʧ��,��Ϣ����ʧ��");
				return "success";
			}
			/* ActionContext.getContext().put("message", "�ļ��ϴ��ɹ�"); */
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
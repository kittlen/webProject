package com.qyc.newsProject.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qyc.newsProject.model.Notice;
import com.qyc.newsProject.model.User;
import com.qyc.newsProject.service.NoticeService;
import com.qyc.newsProject.util.util;

public class NoticeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5166531604964251880L;
	private Notice notice;
	private NoticeService iNoticeService;
	private String nsa;// �������
	private int index;// ��ҳ����
	private Notice noticeCont;
	private String deNo;// ɾ������
	private String typeIndex;// ������������
	private String type;// ��������
	private String seatext;// ����
	private String audtype;// ���״̬

	/* ���ŷ��� */
	public String save() {
		List<String> list = util.getImg(notice.getNoticeContent());
		if (list.size() > 0) {
			notice.setNoticephoto1(list.get(0).substring(26,
					list.get(0).length() - 1));
		}
		notice.setUser((User) ServletActionContext.getRequest().getSession()
				.getAttribute("login"));
		notice.setReleaseTime(util.getNowTime());
		notice.setAudit("δ���");
		if (iNoticeService.save(notice)) {
			setNsa("1");
		} else {
			setNsa("0");
		}
		return "success";
	}

	/* ���� */
	public void noticeInfo() throws IOException {
		List<Notice> list = iNoticeService.noticeInfo(index);
		JSONArray json = JSONArray.fromObject(list);
		util.writ(json);
	}

	// ��������
	public String noticecont() {
		Notice thisnNotice = iNoticeService.noticecont(notice);
		ServletActionContext.getRequest().getSession()
				.setAttribute("noticeCont", thisnNotice);
		/* setNoticeCont(thisnNotice); */
		return "success";
	}

	// �����б�
	public void noticeListInfo() throws IOException {
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("login");
		List<Notice> list = iNoticeService.noticeListInfo(user);
		JSONArray json = JSONArray.fromObject(list);
		util.writ(json);
	}

	// ɾ������
	public String delete() {
		iNoticeService.delete(notice);
		setDeNo("1");
		return "success";
	}

	// ���
	public void auditInfo() throws IOException {
		List<Notice> list = iNoticeService.auditInfo();
		util.writ(JSONArray.fromObject(list));
	}

	// ��˽��
	public String auditup() {
		iNoticeService.auditup(notice);
		if (notice.getAudit().equals("���ͨ��")) {
			setAudtype("1");
		}
		if (notice.getAudit().equals("���δͨ��")) {
			setAudtype("2");
		}
		return "success";
	}

	// ������|Ȥ��|�Ķ�
	public void showType() throws IOException {
		List<Notice> list = iNoticeService.noticeTypeInfo(typeIndex, index);
		JSONArray json = JSONArray.fromObject(list);
		util.writ(json);
	}

	// ����
	public void searchInfo() throws IOException {
		List<Notice> list = iNoticeService.seachInfo(seatext);
		util.writ(JSONArray.fromObject(list));
	}

	public String skipType() {
		setType(typeIndex);
		return "success";
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public NoticeService getiNoticeService() {
		return iNoticeService;
	}

	public void setiNoticeService(NoticeService iNoticeService) {
		this.iNoticeService = iNoticeService;
	}

	public String getNsa() {
		return nsa;
	}

	public void setNsa(String nsa) {
		this.nsa = nsa;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Notice getNoticeCont() {
		return noticeCont;
	}

	public void setNoticeCont(Notice noticeCont) {
		this.noticeCont = noticeCont;
	}

	public String getDeNo() {
		return deNo;
	}

	public void setDeNo(String deNo) {
		this.deNo = deNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeIndex() {
		return typeIndex;
	}

	public void setTypeIndex(String typeIndex) {
		this.typeIndex = typeIndex;
	}

	public String getSeatext() {
		return seatext;
	}

	public void setSeatext(String seatext) {
		this.seatext = seatext;
	}

	public String getAudtype() {
		return audtype;
	}

	public void setAudtype(String audtype) {
		this.audtype = audtype;
	}

}

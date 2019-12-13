package com.qyc.newsProject.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

public class util {

	/**
	 * 32λMD5����
	 * 
	 * @param str
	 *            �������ַ���
	 * @return 32λMD5�����ַ���
	 * @throws NoSuchAlgorithmException
	 */
	public static String UseMD5(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		BigInteger bigInteger = new BigInteger(1, md.digest());
		return bigInteger.toString(16);
	}

	/**
	 * ��ȡϵͳ��ǰ����ʱ�� ������
	 * 
	 * @return ϵͳ��ǰ����ʱ��
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(System.currentTimeMillis());
	}

	/**
	 * ��ȡ��ǰʱ���SQLʱ������
	 * 
	 * @return SQLʱ��
	 */
	public static java.sql.Date getSQDate() {
		Date date = new Date();
		// ����ǰʱ��ת��Ϊsqlʱ��
		java.sql.Date transDate = new java.sql.Date(date.getTime());
		return transDate;
	}

	/**
	 * ��ȡϵͳ��ǰ����ʱ�� ������ʱ����
	 * 
	 * @return ϵͳ��ǰ����ʱ��
	 */
	public static String getNowDetailedTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(System.currentTimeMillis());
	}

	/**
	 * ��ȡ����ʱ��Ĳ�
	 * @param oldTime ��ʱ��
	 * @param newTime ��ʱ��
	 * @return ʱ���
	 * @throws ParseException
	 */
	public static String timeDifference(String oldTime, String newTime)
			throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = df.parse(newTime);
		Date d2 = df.parse(oldTime);
		long diff = d1.getTime() - d2.getTime();// �����õ��Ĳ�ֵ��΢�뼶��
		long days = diff / (1000 * 60 * 60 * 24);
		long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours
				* (1000 * 60 * 60))
				/ (1000 * 60);
		String difference = "" + days + "��" + hours + "Сʱ" + minutes + "��";
		return difference;
	}

	/**
	 * ��ȡ��ǰ��������Ӧ��ѧ��
	 * 
	 * @return ��ǰѧ��
	 */
	public static String getNewSemester() {
		String date = getNowTime();
		int y = Integer.parseInt(date.split("-")[0]);
		int M = Integer.parseInt(date.split("-")[1]);
		if (M > 8) {
			return y + "-" + (y + 1) + "ѧ����ѧ��";
		} else {
			return (y - 1) + "-" + (y) + "ѧ����ѧ��";
		}

	}

	/**
	 * ��ȡ��Ӧ��������Ӧ��ѧ�� 0��ǰ���� 1-nǰn���ڶ�Ӧ��ѧ��(1��һ��ѧ�� 2������ѧ��)
	 * 
	 * @param index
	 * @return
	 */
	public static String getSemester(int index) {
		String date = getNowTime();
		int y = Integer.parseInt(date.split("-")[0]);
		int M = Integer.parseInt(date.split("-")[1]);
		if (index % 2 == 0) {
			index /= 2;
			if (M > 8) {
				return (y - index) + "-" + (y + 1 - index) + "ѧ����ѧ��";
			} else {
				return (y - 1 - index) + "-" + (y - index) + "ѧ����ѧ��";
			}
		} else {
			index /= 2;
			if (M > 8) {
				return (y - 1 - index) + "-" + (y - 1 - index) + "ѧ����ѧ��";
			} else {
				return (y - 1 - index) + "-" + (y - index) + "ѧ����ѧ��";
			}

		}

	}

	/**
	 * ���ڽ��쳣����e�еĴ�����Ϣ����Ϊһ��String�� ���������ַ��� �������������־�ļ�����ȥ
	 * 
	 * @param e
	 *            �쳣����
	 * @return �쳣�����е��쳣��Ϣ�ַ���
	 */
	public static String getExceptionMsg(Throwable e) {
		// ���쳣�����е��쳣��¼ת��Ϊ��¼����
		StackTraceElement[] s = e.getStackTrace();
		StringBuffer sb = new StringBuffer();// ��������ȡ���쳣��Ϣ������Ϊһ���ַ���
		for (int i = 0; i < s.length; i++) {
			sb.append("\r\n");
			sb.append(s[i]);
		}
		return sb.toString();
	}

	/**
	 * ���ڵ�¼��ʾ �����һ�ε�����ҳ ����ʾΪ��(����ʾ) ����������ʾ
	 * 
	 * @param str
	 *            ��¼��ʾ
	 * @return �ջ���ĵ�¼��ʾ
	 */
	public static String sendJspNull(String str) {
		if (str.equals("null")) {
			return "";
		}
		return str;
	}

	/**
	 * listתjson��ѭ������
	 * 
	 * @param parmas
	 *            [] ��Ҫ���˵�������
	 * @return jsonCongig listתjson��������
	 */
	public static JsonConfig jsonConfig(final String[] parmas) {
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object arg0, String arg1, Object arg2) {
				// TODO Auto-generated method stub
				// ���college �Ǹ�������������˾����� ��Ӧmodel�Ķ�Ӧ���� (�׵���Сд)
				for (int i = 0; i < parmas.length; i++)
					if (arg1.equals(parmas[i])) {
						return true;
					}
				return false;
			}
		});
		return config;
	}

	/**
	 * ajax���ݻش�
	 * 
	 * @param json
	 *            listת�������jsonArray����
	 * @throws IOException
	 */
	public static void writ(JSONArray json) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	/**
	 * ʵ�ִ���ҳ����ӻ�ȡͼƬ��·��
	 * 
	 * @param news_content
	 *            html����
	 * @return ͼƬ·��list��
	 */
	public static List<String> getImg(String news_content) {
		String regex = "src=\"(.*?)\"";
		List<String> list = new ArrayList<String>();
		Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		Matcher ma = pa.matcher(news_content);
		while (ma.find()) {
			list.add(ma.group());
		}
		return list;
	}

	/**
	 * �ļ��ϴ�����
	 * 
	 * @param servlet
	 *            Servlet����
	 * @param request
	 *            request����
	 * @param dirname
	 *            �ϴ�Ŀ���ļ���
	 * @param fileName
	 *            �ϴ����ļ���
	 * @throws Exception
	 *             �쳣
	 * @return �ļ���
	 */
	public static String fileupload(HttpServlet servlet,
			HttpServletRequest request, String dirname, String fileName)
			throws Exception {
		// �����ϴ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
		factory.setSizeThreshold(1024 * 1024 * 3);
		// ������ʱ�洢Ŀ¼
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		// ��������ļ��ϴ�ֵ
		upload.setFileSizeMax(1024 * 1024 * 40);
		// �����������ֵ (�����ļ��ͱ�������)
		upload.setSizeMax(1024 * 1024 * 50);
		// ���Ĵ���
		upload.setHeaderEncoding("UTF-8");

		// ������ʱ·�����洢�ϴ����ļ�
		// ���·����Ե�ǰӦ�õ�Ŀ¼
		String uploadPath = servlet.getServletContext().getRealPath("/")
				+ dirname;

		// ���Ŀ¼�������򴴽�
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// ���������������ȡ�ļ�����
		List<FileItem> formItems = upload.parseRequest(request);

		if (formItems != null && formItems.size() > 0) {
			// ������������
			for (FileItem item : formItems) {
				// �������ڱ����е��ֶ�
				if (!item.isFormField()) {

					String fName = new File(item.getName()).getName();
					String type = fName.substring(fName.lastIndexOf("."));

					if (fileName.equals("")) {
						fileName = new File(item.getName()).getName();
					} else {
						fileName = fileName + type;
					}
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// �ڿ���̨����ļ����ϴ�·��
					System.out.println(filePath);
					// ����ļ�����,��ɾ��ԭ�ļ�
					if (storeFile.exists()) {
						storeFile.delete();
					}
					// �����ļ���Ӳ��
					item.write(storeFile);
				}
			}
		}
		return fileName;

	}

	/**
	 * ɾ���ļ����������ļ����ļ���
	 *
	 * @param fileName
	 *            Ҫɾ�����ļ���
	 * @return ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println("ɾ���ļ�ʧ��:" + fileName + "�����ڣ�");
			return false;
		} else {
			if (file.isFile())
				return deleteFile(fileName);
			else
				return deleteDirectory(fileName);
		}
	}

	/**
	 * ɾ�������ļ�
	 *
	 * @param fileName
	 *            Ҫɾ�����ļ����ļ���
	 * @return �����ļ�ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		// ����ļ�·������Ӧ���ļ����ڣ�������һ���ļ�����ֱ��ɾ��
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				System.out.println("ɾ�������ļ�" + fileName + "�ɹ���");
				return true;
			} else {
				System.out.println("ɾ�������ļ�" + fileName + "ʧ�ܣ�");
				return false;
			}
		} else {
			System.out.println("ɾ�������ļ�ʧ�ܣ�" + fileName + "�����ڣ�");
			return false;
		}
	}

	/**
	 * ɾ��Ŀ¼��Ŀ¼�µ��ļ�
	 *
	 * @param dir
	 *            Ҫɾ����Ŀ¼���ļ�·��
	 * @return Ŀ¼ɾ���ɹ�����true�����򷵻�false
	 */
	public static boolean deleteDirectory(String dir) {
		// ���dir�����ļ��ָ�����β���Զ������ļ��ָ���
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// ���dir��Ӧ���ļ������ڣ����߲���һ��Ŀ¼�����˳�
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�" + dir + "�����ڣ�");
			return false;
		}
		boolean flag = true;
		// ɾ���ļ����е������ļ�������Ŀ¼
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// ɾ�����ļ�
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// ɾ����Ŀ¼
			else if (files[i].isDirectory()) {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			System.out.println("ɾ��Ŀ¼ʧ�ܣ�");
			return false;
		}
		// ɾ����ǰĿ¼
		if (dirFile.delete()) {
			System.out.println("ɾ��Ŀ¼" + dir + "�ɹ���");
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ð������
	 */
	public static void mpp(int a[]) {

		int x = 0;
		for (int i = a.length; i >= 0; i--) {
			for (int t = 0; t < i - 1; t++) {
				if (a[t] < a[t + 1]) {
					x = a[t + 1];
					a[t + 1] = a[t];
					a[t] = x;
				}
			}
		}
	}

	/**
	 * ��������
	 */
	public static void ksp(int a[], int x, int y) {

		if (x > y) {
			return;
		}// ���ָ�������ʣ��1λʱ�˳��ݹ�
		int start = x;
		int end = y;
		int key = a[x];// ѡһ�����䵱keyֵ
		while (start < end) {
			while (start < end && a[end] <= key) {// ��������濪ʼ,�����������keyֵСʱ
				end--;
			}
			while (start < end && a[start] >= key) {// ������ǰ�濪ʼ.��ǰ�������keyֵ��ʱ
				start++;
			}
			// ������ǰ���keyС��������������key���������
			int z = a[end];
			a[end] = a[start];
			a[start] = z;
		}

		// ��ǰ��������λ����ͬʱ,����keyֵ��ǰ��λ�����ڵ�����ֵ
		if (start >= end) {
			int z = a[start];
			a[start] = key;
			a[x] = z;
		}

		// �������Ϊ�����ֱַ���еݹ�,ֱ��������ָ��ʣ1λ.
		ksp(a, 0, start - 1);
		ksp(a, start + 1, y);

	}

	/**
	 * ������(��ȫ������)
	 */
	public static void dp(int a[], int x, int y) {

		if (y < x) {
			return;
		}// ��������ֻ��һ�����ڵ�ʱ�˳��ݹ�
		int end = y;// �ڵ���
		while (end > x) {// �Ƚ��ӽڵ��븸�ڵ�λ�õ����ִ�С,������ַ��ڸ��ڵ���;
			int w = (end - 1) / 2;// ���ڵ�λ��;
			if (a[end] > a[w]) {
				int z = a[end];
				a[end] = a[w];
				a[w] = z;
			}
			end--;
		}

		// �����һ���ڵ�����ڵ㽻��,�������������������
		int z = a[y];
		a[y] = a[x];
		a[x] = z;
		y--;

		// �ݹ�Ƚ�ʣ�µ��Ӹ��ڵ��С
		dp(a, x, y);

	}

	// ɾ������
	/*
	 * public static void main(String[] args) { // // ɾ�������ļ� // String file =
	 * "c:/test/test.txt"; // DeleteFileUtil.deleteFile(file); //
	 * System.out.println(); // ɾ��һ��Ŀ¼ // String dir =
	 * "D:/home/web/upload/upload/files"; // deleteDirectory(dir); //
	 * System.out.println(); // // ɾ���ļ� // dir = "c:/test/test0"; //
	 * DeleteFileUtil.delete(dir); String file="G:/�½��ļ���"; delete(file);
	 * 
	 * }
	 */
	// �������ڼ��ѧ��
	/*
	 * public static void main(String[] args) { for(int
	 * i=(2019-2015)*2-1;i>0;i--){ System.out.println(getSemester(i)); } }
	 */

}
package com.qyc.OneProject.basicdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ���ݿ�������
 * @author qyc
 *2019-4-2
 */

public class DBconn {

	private String drivername;
	private String url;
	private String user;
	private String password;

	/*
	 * ���ݿ�������Ĺ��췽�����ڹ������ݿ����ʱ�������ļ��л�ȡ���Ӳ�������ע������
	 */
	public DBconn() {
		try {
			Properties pro = new Properties();
			pro.load(DBconn.class.getClassLoader().getResourceAsStream(
					"configure.ini"));
			drivername = pro.getProperty("drivername");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			Class.forName(drivername);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ���Ӷ���
	 * @return ���Ӷ���
	 */
	public Connection getConnection(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ر�Connection,PreparedStatement,ResultSet
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public void DBclose(Connection conn,PreparedStatement ps,ResultSet rs){
			try {
				if(conn!=null)conn.close();
				if(ps!=null)ps.close();
				if(rs!=null)rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

package com.qyc.OneProject.basicdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class BaseDAO extends DBconn {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * �رղ��ͷ�������Դ
	 */
	private void close() {
		DBclose(conn, ps, rs);
	}
	/*****************************SQL��ɾ��************************************/
	/**
	 * ִ����Ӳ������޲�SQL���
	 * 
	 * @param SQL
	 * @return Ӱ�������
	 */
	public int insert(String SQL) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ִ����Ӳ������в�SQL���
	 * 
	 * @param SQL
	 * @param parmas
	 * @return Ӱ�������
	 */
	public int insert(String SQL, Object[] parmas) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			for (int i = 1; i <= parmas.length; i++) {
				ps.setObject(i, parmas[i - 1]);
			}
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ִ���޸Ĳ������޲�SQL���
	 * 
	 * @param SQL
	 * @return Ӱ�������
	 */
	public int update(String SQL) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ִ���޸Ĳ������в�SQL���
	 * 
	 * @param SQL
	 * @param parmas
	 * @return Ӱ�������
	 */
	public int update(String SQL, Object[] parmas) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			for (int i = 1; i <= parmas.length; i++) {
				ps.setObject(i, parmas[i - 1]);
			}
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ִ��ɾ���������޲�SQL���
	 * 
	 * @param SQL
	 * @return Ӱ�������
	 */
	public int delete(String SQL) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * ִ��ɾ���������в�SQL���
	 * 
	 * @param SQL
	 * @param parmas
	 * @return Ӱ�������
	 */
	public int delete(String SQL, Object[] parmas) {
		conn = getConnection();
		int count = 0;
		try {
			ps = conn.prepareStatement(SQL);
			for (int i = 1; i <= parmas.length; i++) {
				ps.setObject(i, parmas[i - 1]);
			}
			count = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * ����ִ����ɾ�Ĳ���
	 * @param SQL sqlָ��
	 * @param parmsa ������
	 * @return ִ��ָ���Ӱ������
	 */
	public int executeBatch(String SQL,Object[][] parmsa){
		conn=getConnection();
		int count=0;
		try {
			ps=conn.prepareStatement(SQL);
			for(int i=0;i<parmsa.length;i++){
				for (int j = 1; j <= parmsa[i].length; j++) {
					ps.setObject(j, parmsa[i][j-1]);
				}
				ps.addBatch();
			}
			//������ÿһλ����ִ������ָ����Ӱ�������
			int[] num=ps.executeBatch();
			for (int i = 0; i < num.length; i++) {
				count+=num[i];
			}
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/*****************************SQL��ѯ************************************/

	/**
	 * ִ�в�ѯ�������޲�SQL���
	 * close(); ��ǰ�رջᵼ���޲���������
	 * @param SQL
	 * @return ResultSet
	 */
	public ResultSet select(String SQL) {
		conn = getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
//			close(); //��ǰ�رջᵼ���޲���������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * ִ�в�ѯ�������в�SQL���
	 * close(); ��ǰ�رջᵼ���޲���������
	 * @param SQL
	 * @param parmas
	 * @return ResultSet
	 */
	public ResultSet select(String SQL, Object[] parmas) {
		conn = getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			for (int i = 1; i <= parmas.length; i++) {
				ps.setObject(i, parmas[i - 1]);
			}
			rs = ps.executeQuery();
//			close(); //��ǰ�رջᵼ���޲���������
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/*****************************�洢������ɾ��************************************/
	
	/**
	 * �洢���̴���:"{call �洢������(?,?,?)}"
	 * ִ������������Ĵ洢����
	 * �洢����:��SQL���ݿ���ִ�д���,�������������
	 * @param procname 
	 * @param parmas
	 * @return Ӱ������
	 */
	public int executePorcNoOutput(String procname,Object[]parmas) {
		conn=getConnection();
		int count=0;
		try {
			CallableStatement cs=conn.prepareCall(procname);
			for (int i = 1; i <= parmas.length; i++) {
				cs.setObject(i, parmas[i-1]);
			}
			count=cs.executeUpdate();
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * �洢���̴���:"{call �洢������(?,?,?)}"
	 * ִ������������Ĵ洢����(�����һλ)
	 * �洢����:��SQL���ݿ���ִ�д���,�������������
	 * �����ָ��Ӧ��������������������(?��ʾ),����������н������������
	 * @param procname 
	 * @param parmas
	 * @return �������
	 */
	public String executePorcOutput(String procname,Object[]parmas) {
		conn=getConnection();
		String rezult="";
		try {
			int i=1;
			CallableStatement cs=conn.prepareCall(procname);
			for (; i <= parmas.length; i++) {
				cs.setObject(i, parmas[i-1]);
			}
			//����ָ���е�ĩλ��ʾ�������
			//����������������ݿ���������
			cs.registerOutParameter(i, Types.VARCHAR);
			cs.execute();//ִ��ָ��
			rezult=cs.getString(i);//��ȡ�������
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rezult;
	}
	
	/*****************************�洢���̷�ҳ***********************************/
	/** ʹ�÷�ҳ�洢����sp_page���з�ҳ��ѯ
	 * @param tablename ����
	 * @param columns ��ѯ�����ֶ���������ֶ���","����
	 * @param Where ��ѯ����
	 * @param pagesize ÿҳ��¼����
	 * @param nowpage ��ǰҳ
	 * @param ordercolumn �����ֶ�
	 * @param ordercolumntype �����ֶ����ͣ�0-��������,1-�ַ�����,2-����ʱ������ 
	 * @param order ����ʽ,0-˳��,1-���� 	 
	 * @param total ���ڷ�����ҳ�� [0]
	 * @return ��ǰҳ�Ľ������ʹ����ϣ��ر����ݿ����
	 */
	public ResultSet selectPage(String tablename, String columns, String Where,
			int pagesize, int nowpage, String ordercolumn, int ordercolumntype,
			int order,int total[]) {
		conn = getConnection();
		try {
			CallableStatement cs = conn
					.prepareCall("{call sp_page(?,?,?,?,?,?,?,?,?)}");
			cs.setObject(1, tablename);
			cs.setObject(2, ordercolumn);
			cs.setObject(3, ordercolumntype);
			cs.setObject(4, order);
			cs.setObject(5, columns);
			cs.setObject(6, pagesize);
			cs.setObject(7, nowpage);
			cs.setObject(8, Where);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.execute();
			total[0]=cs.getInt(9);//������ҳ��
			rs = cs.executeQuery();
			// close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * SQL��ҳ�洢���̴��룺
	 * 
		CREATE PROCEDURE [dbo].[sp_page] 
		
		@strTable varchar(50), --���� 
		@strColumn varchar(50), --�����������з�ҳ 
		@intColType int, --@strColumn�е�����,0-��������,1-�ַ�����,2-����ʱ������ 
		@intOrder bit, --����,0-˳��,1-���� 
		@strColumnlist varchar(800), --Ҫ��ѯ�����ֶ��б�,*��ʾȫ���ֶ� 
		@intPageSize int, --ÿҳ��¼�� 
		@intPageNum int, --ָ��ҳ 
		@strWhere varchar(800), --��ѯ���� 
		@intPageCount int OUTPUT --��ҳ�� 
		AS 
		DECLARE @sql nvarchar(4000) --���ڹ���SQL��� 
		DECLARE @where1 varchar(800) --����������� 
		DECLARE @where2 varchar(800) --����������� 
		IF @strWhere is null or rtrim(@strWhere)='' 
		-- Ϊ�˱���SQL�ؼ������ֶΡ�����������һ������Ϊ����ı�����ӿո� 
		BEGIN --û�в�ѯ���� 
		SET @where1=' WHERE ' 
		SET @where2=' ' 
		END 
		ELSE 
		BEGIN --�в�ѯ���� 
		SET @where1=' WHERE ('+@strWhere+') AND ' 
		SET @where2=' WHERE ('+@strWhere+') ' 
		END 
		
		set @strColumn = ' ' + @strColumn + ' ' 
		set @strColumnlist = ' ' + @strColumnlist + ' ' 
		--����SQL��䣬������ҳ�������㹫ʽΪ ��ҳ�� = Ceiling ( ��¼���� / ҳ��С ) 
		
		SET @sql='SELECT @intPageCount=CEILING((COUNT(*)+0.0)/' 
		+ CAST(@intPageSize AS varchar) 
		+ ') FROM ' + @strTable + @where2 
		
		--ִ��SQL��䣬������ҳ�������������@intPageCount������ 
		
		EXEC sp_executesql @sql,N'@intPageCount int OUTPUT',@intPageCount OUTPUT 
		
		--����ҳ���ŵ���ѯ���ؼ�¼���ĵ�һ���ֶ�ǰ��������ʡ�� 
		
		SET @strColumnlist= Cast(@intPageCount as varchar(30)) + ' as PageCount,' + 
		
		@strColumnlist 
		
		IF @intOrder=0 --���������SQL 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar) + ' ' + 
		@strColumnlist + 
		' FROM ' + @strTable + @where1 + 
		@strColumn + '>(SELECT MAX('+@strColumn+') '+ 
		' FROM (SELECT TOP '+ CAST(@intPageSize*(@intPageNum - 1) AS varchar) + 
		@strColumn + ' FROM '+ @strTable+@where2+'ORDER BY '+@strColumn+') t) ORDER BY '+ 
		
		@strColumn 
		
		ELSE --���콵���SQL 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar) + ' ' + 
		@strColumnlist+ 
		' FROM '+ @strTable + @where1 + 
		@strColumn + '<(SELECT MIN('+@strColumn+') '+ 
		' FROM (SELECT TOP '+ CAST(@intPageSize*(@intPageNum - 1) AS varchar) + 
		@strColumn + ' FROM '+ @strTable+@where2+'ORDER BY '+@strColumn+' DESC) t) ORDER BY '+ 
		@strColumn + ' DESC' 
		
		IF @intPageNum=1--��һҳ 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar(10)) + ' ' + @strColumnlist + ' 
		
		FROM '+@strTable+ 
		@where2+' ORDER BY '+@strColumn + CASE @intOrder WHEN 0 THEN '' ELSE ' DESC' 
		
		END 
		--PRINT @sql 
		EXEC(@sql)
		GO
	 */
	
	/*****************************JDBC����************************************/
	
	/**
	 * ��ʼ����
	 * @return ���ֶ��ύ�����Ӷ���
	 */
	public Connection beginTrans(){
		conn=getConnection();
		try {
			conn.setAutoCommit(false);//�޸��ύ��ʽΪ�ֶ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ִ�д�����Ĵ������ķǲ�ѯ����
	 * @param SQL ����SQLָ��
	 * @param parmas SQL����
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int executeTrans(String SQL,Object[] parmas)throws SQLException{
		int count=0;
		ps=conn.prepareStatement(SQL);
		for(int i=1;i<=parmas.length;i++){
			ps.setObject(i, parmas[i-1]);
		}
		count=ps.executeUpdate();
		return count;
	}
	
	/**
	 * ִ�д�����ķǲ�ѯ����
	 * @param SQL SQLָ��
	 * @return Ӱ������
	 * @throws SQLException
	 */
	public int executeTrans(String SQL)throws SQLException{
		int count=0;
		ps=conn.prepareStatement(SQL);
		count=ps.executeUpdate();
		return count;
	}
	
	/**
	 * �ύ����
	 */
	public void commitTrans() {
		try {
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ����ع�
	 */
	public void rollbackTrans(){
		try {
			conn.rollback();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/******************************END************************************/
	
	public static void main(String[] args) {
		
		/********************************�������ݿ�(��)��ҳ********************************/
		/*BaseDAO dao = new BaseDAO();

		int pagecount = 0;
		int last[]=new int[1];
		try {
			ResultSet rs = dao.selectPage("BooksInfo", "*", "", 15, 1, "id", 1,
					0,last);
			while (rs.next()) {
				pagecount = rs.getInt("PageCount");
			}
			System.out.println(pagecount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/********************************��������********************************/
		/*
		BaseDAO bd=new BaseDAO();
		//���
		String sql="insert into T_Tadd values (?,?)";
		Object t[][]=new Object[1000][2];
		for(int i=0;i<1000;i++){
			t[i][0]="id"+i;
			t[i][1]="X"+i;
		}
		int cou=bd.executeBatch(sql, t);
		System.out.println("Ӱ������"+cou);
		
		//ɾ��
		String sql2="delete from T_Tadd where (id=?)";
		Object t2[][]=new Object[1000][1];
		for(int i=0;i<1000;i++){
			t2[i][0]="id"+i;
		}
		int cou2=bd.executeBatch(sql2, t2);
		System.out.println("Ӱ������"+cou2);*/
		
		/********************************������********************************/
		//����
		/*BaseDAO dao = new BaseDAO();
		dao.beginTrans();//�����ֶ�����
		try {//�������
			int a=dao.executeTrans("update T_Book set name='���˼����' where id=7 ");
			int b=dao.executeTrans("update T_Book set name='���˼����' where id=8 ");
			if(a>0&&b>0){
				dao.commitTrans();//���������Ӱ������,�����ύ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dao.rollbackTrans();//������쳣,���������ع�
		}*/
		
		//��ȷ
		/*BaseDAO dao = new BaseDAO();
		dao.beginTrans();//�����ֶ�����
		try {//�������
			int a=dao.executeTrans("update T_Book set name='���˼����' where id=7 ");
			int b=dao.executeTrans("update T_Book set name='���˼����' where id=12 ");
			if(a>0&&b>0){
				dao.commitTrans();//���������Ӱ������,�����ύ
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dao.rollbackTrans();//������쳣,���������ع�
		}*/
	}
	
}

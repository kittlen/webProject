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
	 * 关闭并释放连接资源
	 */
	private void close() {
		DBclose(conn, ps, rs);
	}
	/*****************************SQL增删改************************************/
	/**
	 * 执行添加操作的无参SQL语句
	 * 
	 * @param SQL
	 * @return 影响的行数
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
	 * 执行添加操作的有参SQL语句
	 * 
	 * @param SQL
	 * @param parmas
	 * @return 影响的行数
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
	 * 执行修改操作的无参SQL语句
	 * 
	 * @param SQL
	 * @return 影响的行数
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
	 * 执行修改操作的有参SQL语句
	 * 
	 * @param SQL
	 * @param parmas
	 * @return 影响的行数
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
	 * 执行删除操作的无参SQL语句
	 * 
	 * @param SQL
	 * @return 影响的行数
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
	 * 执行删除操作的有参SQL语句
	 * 
	 * @param SQL
	 * @param parmas
	 * @return 影响的行数
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
	 * 批量执行增删改操作
	 * @param SQL sql指令
	 * @param parmsa 参数集
	 * @return 执行指令的影响行数
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
			//数组中每一位代表执行这条指令所影响的行数
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
	
	/*****************************SQL查询************************************/

	/**
	 * 执行查询操作的无参SQL语句
	 * close(); 提前关闭会导致无参数集传回
	 * @param SQL
	 * @return ResultSet
	 */
	public ResultSet select(String SQL) {
		conn = getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
//			close(); //提前关闭会导致无参数集传回
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 执行查询操作的有参SQL语句
	 * close(); 提前关闭会导致无参数集传回
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
//			close(); //提前关闭会导致无参数集传回
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/*****************************存储过程增删改************************************/
	
	/**
	 * 存储过程代码:"{call 存储过程名(?,?,?)}"
	 * 执行无输出参数的存储过程
	 * 存储过程:在SQL数据库上执行代码,减轻服务器负担
	 * @param procname 
	 * @param parmas
	 * @return 影响行数
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
	 * 存储过程代码:"{call 存储过程名(?,?,?)}"
	 * 执行有输出参数的存储过程(仅输出一位)
	 * 存储过程:在SQL数据库上执行代码,减轻服务器负担
	 * 传入的指令应包含输入参数与输出参数(?表示),传入的数组中仅包含输入参数
	 * @param procname 
	 * @param parmas
	 * @return 输出参数
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
			//输入指令中的末位表示输出参数
			//设置输出参数的数据库数据类型
			cs.registerOutParameter(i, Types.VARCHAR);
			cs.execute();//执行指令
			rezult=cs.getString(i);//获取输出参数
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rezult;
	}
	
	/*****************************存储过程分页***********************************/
	/** 使用分页存储过程sp_page进行分页查询
	 * @param tablename 表名
	 * @param columns 查询到的字段名，多个字段用","隔开
	 * @param Where 查询条件
	 * @param pagesize 每页记录条数
	 * @param nowpage 当前页
	 * @param ordercolumn 排序字段
	 * @param ordercolumntype 排序字段类型：0-数字类型,1-字符类型,2-日期时间类型 
	 * @param order 排序方式,0-顺序,1-倒序 	 
	 * @param total 用于返回总页数 [0]
	 * @return 当前页的结果集，使用完毕，关闭数据库对象
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
			total[0]=cs.getInt(9);//返回总页数
			rs = cs.executeQuery();
			// close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * SQL分页存储过程代码：
	 * 
		CREATE PROCEDURE [dbo].[sp_page] 
		
		@strTable varchar(50), --表名 
		@strColumn varchar(50), --按该列来进行分页 
		@intColType int, --@strColumn列的类型,0-数字类型,1-字符类型,2-日期时间类型 
		@intOrder bit, --排序,0-顺序,1-倒序 
		@strColumnlist varchar(800), --要查询出的字段列表,*表示全部字段 
		@intPageSize int, --每页记录数 
		@intPageNum int, --指定页 
		@strWhere varchar(800), --查询条件 
		@intPageCount int OUTPUT --总页数 
		AS 
		DECLARE @sql nvarchar(4000) --用于构造SQL语句 
		DECLARE @where1 varchar(800) --构造条件语句 
		DECLARE @where2 varchar(800) --构造条件语句 
		IF @strWhere is null or rtrim(@strWhere)='' 
		-- 为了避免SQL关键字与字段、表名等连在一起，首先为传入的变量添加空格 
		BEGIN --没有查询条件 
		SET @where1=' WHERE ' 
		SET @where2=' ' 
		END 
		ELSE 
		BEGIN --有查询条件 
		SET @where1=' WHERE ('+@strWhere+') AND ' 
		SET @where2=' WHERE ('+@strWhere+') ' 
		END 
		
		set @strColumn = ' ' + @strColumn + ' ' 
		set @strColumnlist = ' ' + @strColumnlist + ' ' 
		--构造SQL语句，计算总页数。计算公式为 总页数 = Ceiling ( 记录个数 / 页大小 ) 
		
		SET @sql='SELECT @intPageCount=CEILING((COUNT(*)+0.0)/' 
		+ CAST(@intPageSize AS varchar) 
		+ ') FROM ' + @strTable + @where2 
		
		--执行SQL语句，计算总页数，并将其放入@intPageCount变量中 
		
		EXEC sp_executesql @sql,N'@intPageCount int OUTPUT',@intPageCount OUTPUT 
		
		--将总页数放到查询返回记录集的第一个字段前，此语句可省略 
		
		SET @strColumnlist= Cast(@intPageCount as varchar(30)) + ' as PageCount,' + 
		
		@strColumnlist 
		
		IF @intOrder=0 --构造升序的SQL 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar) + ' ' + 
		@strColumnlist + 
		' FROM ' + @strTable + @where1 + 
		@strColumn + '>(SELECT MAX('+@strColumn+') '+ 
		' FROM (SELECT TOP '+ CAST(@intPageSize*(@intPageNum - 1) AS varchar) + 
		@strColumn + ' FROM '+ @strTable+@where2+'ORDER BY '+@strColumn+') t) ORDER BY '+ 
		
		@strColumn 
		
		ELSE --构造降序的SQL 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar) + ' ' + 
		@strColumnlist+ 
		' FROM '+ @strTable + @where1 + 
		@strColumn + '<(SELECT MIN('+@strColumn+') '+ 
		' FROM (SELECT TOP '+ CAST(@intPageSize*(@intPageNum - 1) AS varchar) + 
		@strColumn + ' FROM '+ @strTable+@where2+'ORDER BY '+@strColumn+' DESC) t) ORDER BY '+ 
		@strColumn + ' DESC' 
		
		IF @intPageNum=1--第一页 
		
		SET @sql='SELECT TOP '+ CAST(@intPageSize AS varchar(10)) + ' ' + @strColumnlist + ' 
		
		FROM '+@strTable+ 
		@where2+' ORDER BY '+@strColumn + CASE @intOrder WHEN 0 THEN '' ELSE ' DESC' 
		
		END 
		--PRINT @sql 
		EXEC(@sql)
		GO
	 */
	
	/*****************************JDBC事务************************************/
	
	/**
	 * 开始事务
	 * @return 带手动提交的连接对象
	 */
	public Connection beginTrans(){
		conn=getConnection();
		try {
			conn.setAutoCommit(false);//修改提交方式为手动
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 执行带事务的带参数的非查询操作
	 * @param SQL 带参SQL指令
	 * @param parmas SQL参数
	 * @return 影响的行数
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
	 * 执行带事务的非查询操作
	 * @param SQL SQL指令
	 * @return 影响行数
	 * @throws SQLException
	 */
	public int executeTrans(String SQL)throws SQLException{
		int count=0;
		ps=conn.prepareStatement(SQL);
		count=ps.executeUpdate();
		return count;
	}
	
	/**
	 * 提交事务
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
	 * 事务回滚
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
		
		/********************************测试数据库(真)分页********************************/
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
		/********************************批量操作********************************/
		/*
		BaseDAO bd=new BaseDAO();
		//添加
		String sql="insert into T_Tadd values (?,?)";
		Object t[][]=new Object[1000][2];
		for(int i=0;i<1000;i++){
			t[i][0]="id"+i;
			t[i][1]="X"+i;
		}
		int cou=bd.executeBatch(sql, t);
		System.out.println("影响行数"+cou);
		
		//删除
		String sql2="delete from T_Tadd where (id=?)";
		Object t2[][]=new Object[1000][1];
		for(int i=0;i<1000;i++){
			t2[i][0]="id"+i;
		}
		int cou2=bd.executeBatch(sql2, t2);
		System.out.println("影响行数"+cou2);*/
		
		/********************************事务处理********************************/
		//错误
		/*BaseDAO dao = new BaseDAO();
		dao.beginTrans();//设置手动事务
		try {//事务添加
			int a=dao.executeTrans("update T_Book set name='马克思主义' where id=7 ");
			int b=dao.executeTrans("update T_Book set name='马克思主义' where id=8 ");
			if(a>0&&b>0){
				dao.commitTrans();//如果事务有影响行数,事务提交
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dao.rollbackTrans();//如果有异常,则进行事务回滚
		}*/
		
		//正确
		/*BaseDAO dao = new BaseDAO();
		dao.beginTrans();//设置手动事务
		try {//事务添加
			int a=dao.executeTrans("update T_Book set name='马克思主义' where id=7 ");
			int b=dao.executeTrans("update T_Book set name='马克思主义' where id=12 ");
			if(a>0&&b>0){
				dao.commitTrans();//如果事务有影响行数,事务提交
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			dao.rollbackTrans();//如果有异常,则进行事务回滚
		}*/
	}
	
}

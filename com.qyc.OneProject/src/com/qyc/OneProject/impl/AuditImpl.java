package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qyc.OneProject.Model.Audit;
import com.qyc.OneProject.Model.VTeachTask;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.AuditInterface;

public class AuditImpl implements AuditInterface {

	@Override
	public boolean insert(Audit audit, String Auditing) {
		// TODO Auto-generated method stub
		BaseDAO baseDAO = new BaseDAO();
		baseDAO.beginTrans();//设置手动事务
		try {
			String SQL = "update T_TeachTask set Auditing=? where ID=?";
			Object[] parmas = { Auditing, audit.getTeachTask().getID() };			
			
			String SQL2 = "insert into T_Audit (TeachTaskID,AuditDate,AdminID) values "
					+ "(?,?,?)";
			Object[] parmas2 = { audit.getTeachTask().getID(),
					audit.getAuditDate(), audit.getAdmin().getAdminID() };
			
			int a = baseDAO.executeTrans(SQL, parmas);//事务添加
			int b = baseDAO.executeTrans(SQL2, parmas2);//事务添加
			if(a>0&&b>0){
				baseDAO.commitTrans();//如果事务有影响行数,事务提交
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			baseDAO.rollbackTrans();//如果有异常,则进行事务回滚
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<VTeachTask> select(String Curricula) {
		String SQL = "select * from V_teachTask where Curricula=?";
		Object[] parmas = { Curricula };
		ResultSet rs = new BaseDAO().select(SQL, parmas);
		List<VTeachTask> list = new ArrayList<VTeachTask>();
		try {
			while (rs.next()) {
				VTeachTask vt = new VTeachTask();
				vt.setCourse(rs.getString("Course"));
				vt.setProfessionName(rs.getString("ProfessionName"));
				vt.setStudyTime(rs.getInt("StudyTime"));
				vt.setCrediy(rs.getDouble("Crediy"));
				vt.setCurriculumTime(rs.getString("CurriculumTime"));
				vt.setName(rs.getString("Name"));
				vt.setCurricula(rs.getString("Curricula"));
				vt.setAuditing(rs.getString("Auditing"));
				vt.setTeacherID(rs.getString("TeacherID"));
				vt.setProfessionID(rs.getString("ProfessionID"));
				vt.setCourseID(rs.getString("CourseID"));
				vt.setTeachTaskID(rs.getInt("ID"));
				vt.setRemark(rs.getString("Remark"));
				list.add(vt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

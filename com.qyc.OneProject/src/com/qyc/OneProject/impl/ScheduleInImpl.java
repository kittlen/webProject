package com.qyc.OneProject.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.basicdao.BaseDAO;
import com.qyc.OneProject.sevice.ScheduleInterface;

public class ScheduleInImpl implements ScheduleInterface {

	@Override
	public boolean insert(Schedule schedule) {
		// TODO Auto-generated method stub
		if (select(schedule)) {
			String SQL = "insert into T_Schedule (TeachTaskID,ClassRoomID,ClassTime,Classfestival,Remark) "
					+ "values (?,?,?,?,?)";
			Object[] parmas = { schedule.getTeachTaskID(),
					schedule.getClassRoomID(), schedule.getClassTime(),
					schedule.getClassfestival(), schedule.getRemark() };
			int count = new BaseDAO().insert(SQL, parmas);
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 判断是否有相同的数据
	 */
	@Override
	public boolean select(Schedule schedule) {
		// TODO Auto-generated method stub
		String SQL = "select * from T_Schedule where TeachTaskID=? and ClassRoomID=? and ClassTime=? and Classfestival=?";
		Object[] parmas = { schedule.getTeachTaskID(),
				schedule.getClassRoomID(), schedule.getClassTime(),
				schedule.getClassfestival()};
		ResultSet rs = new BaseDAO().select(SQL, parmas);
		int count = 0;
		try {
			while (rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}

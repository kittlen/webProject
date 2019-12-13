package com.qyc.OneProject.impl;

import java.util.List;

import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.ScheduleInterface;

public class ScheduleInImpl implements ScheduleInterface {
	iHibernatedao hb = new Hibernatedao();

	@SuppressWarnings("unchecked")
	@Override
	public boolean insert(Schedule schedule) {
		// TODO Auto-generated method stub
		String HQL = "from Schedule sc where sc.teachTask.ID=? and sc.ClassRoomID=? and sc.ClassTime=? and sc.Classfestival=?";
		Object[] parmas = { schedule.getTeachTask().getID(),
				schedule.getClassRoomID(), schedule.getClassTime(),
				schedule.getClassfestival() };
		List<Schedule> list = hb.select(HQL, parmas);
		if (list.size() == 0) {
			hb.save(schedule);
			return true;
		}
		return false;
	}

	// É¾³ýÄ³ÅäÖÃ¿Î³Ì
	@Override
	public boolean delete(Schedule schedule) {
		int pd = hb.delete(schedule);
		if (pd == 1) {
			return true;
		}
		return false;
	}

}

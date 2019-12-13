package com.qyc.OneProject.action;

import com.opensymphony.xwork2.ModelDriven;
import com.qyc.OneProject.Model.Schedule;
import com.qyc.OneProject.sevice.ScheduleInterface;
import com.qyc.OneProject.sevice.SchoolFactory;

public class ScheduleAction implements ModelDriven<Schedule>{
	private Schedule schedule=new Schedule();
	ScheduleInterface iSI=SchoolFactory.ScheduleInterFace();
	
	
	public String insert(){
		iSI.insert(schedule);
		return "success";
	}
	public String delete(){
		iSI.delete(schedule);
		return "success";
	}

	
	@Override
	public Schedule getModel() {
		// TODO Auto-generated method stub
		return schedule;
	}

}

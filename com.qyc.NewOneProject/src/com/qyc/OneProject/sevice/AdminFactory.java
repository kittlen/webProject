package com.qyc.OneProject.sevice;

import com.qyc.OneProject.impl.AdminImpl;
import com.qyc.OneProject.impl.AuditImpl;

public class AdminFactory {

	public static AdminInterface AdminInterFace() {
		// TODO Auto-generated method stub
		return new AdminImpl();
	}

	public static AuditInterface AuditInterFace(){
		return new AuditImpl();
	}
	
}

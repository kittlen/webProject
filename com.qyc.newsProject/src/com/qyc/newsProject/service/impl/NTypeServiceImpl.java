package com.qyc.newsProject.service.impl;

import java.util.List;

import com.qyc.newsProject.dao.NTypeDao;
import com.qyc.newsProject.model.NType;
import com.qyc.newsProject.service.NTypeService;



public class NTypeServiceImpl implements NTypeService {
	
	private NTypeDao nTypeDao;

	public NTypeDao getnTypeDao() {
		return nTypeDao;
	}

	public void setnTypeDao(NTypeDao nTypeDao) {
		this.nTypeDao = nTypeDao;
	}
	
	@Override
	public List<NType> select() {
		// TODO Auto-generated method stub
		String HQL="from NType nt";
		return nTypeDao.select(HQL);
	}

	
	

	
}

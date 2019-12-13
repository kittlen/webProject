package com.qyc.newsProject.service.impl;

import java.util.List;

import com.qyc.newsProject.dao.TopImgDao;
import com.qyc.newsProject.model.TopImg;
import com.qyc.newsProject.service.TopImgService;



public class TopImgServiceImpl implements TopImgService {
	
	private TopImgDao topImgDao;

	@Override
	public boolean save(TopImg topImg) {
		// TODO Auto-generated method stub
		if(topImgDao.save(topImg)!=null){
			return true;
		}
		return false;
	}
	@Override
	public List<TopImg> topImgInfo() {
		// TODO Auto-generated method stub
		String HQL="from TopImg ti order by ti.time desc,ti.tIID desc";
		List<TopImg> list=topImgDao.selectPage(HQL, 3, 1);
		return list;
	}

	public TopImgDao getTopImgDao() {
		return topImgDao;
	}

	public void setTopImgDao(TopImgDao topImgDao) {
		this.topImgDao = topImgDao;
	}

	
	

	

	
}

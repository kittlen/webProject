package com.qyc.OneProject.impl;

import java.util.List;

import com.qyc.OneProject.Model.Notice;
import com.qyc.OneProject.basedao.Hibernatedao;
import com.qyc.OneProject.basedao.iHibernatedao;
import com.qyc.OneProject.sevice.NoticeInterface;

public class NoticeInImpl implements NoticeInterface {

	iHibernatedao hb=new Hibernatedao();
	
	@Override
	public boolean insert(Notice notice) {
		// TODO Auto-generated method stub
		
		String pd=String.valueOf( hb.save(notice));
		if(!pd.equals("0")){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> select() {
		// TODO Auto-generated method stub
		String HQL="from Notice no order by no.ReleaseTime desc";
		List<Notice> list=hb.selectPage(HQL, 10, 1);
		return list;
	}

	@Override
	public boolean delete(Notice notice) {
		// TODO Auto-generated method stub
		int pd= hb.delete(notice);
		if(pd==1){
			return true;
		}
		return false;
	}

	@Override
	public Notice Noselect(Notice notice) {
		// TODO Auto-generated method stub
		Notice no=(Notice) hb.getObj(Notice.class, notice.getID());
		return no;
	}

	

}

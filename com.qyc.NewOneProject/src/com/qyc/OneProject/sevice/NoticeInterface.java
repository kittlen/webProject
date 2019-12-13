package com.qyc.OneProject.sevice;

import java.util.List;



import com.qyc.OneProject.Model.Notice;

public interface NoticeInterface {
	boolean insert(Notice notice);
	List<Notice> select();
	boolean delete(Notice notice);
	Notice Noselect(Notice notice);

}

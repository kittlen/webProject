package com.qyc.newsProject.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	/**
	 * ʵ�ֶ���ĳ־û�
	 * @param object ���в����Ķ���
	 * @return ��������� 
	 */
	public Serializable save(T object);
	
	/**
	 * ��ȡ��Ӧ�����Ķ���
	 * @param cla ��Ӧ����Ķ�����
	 * @param id ��Ӧ����
	 * @return ��Ӧ�����Ķ���
	 */
	public T getObj(Class<T> cla,Serializable id);
	

	/**
	 * ����ĳ־û��޸�
	 * @param object ���в����Ķ���
	 */
	public void update(T object);
	
	/**
	 * ɾ���ض��־û��Ķ���
	 * @param object ���в����Ķ���
	 */
	public void delete(T object);
	
	/**
	 * ɾ����Ӧ�����ĳ־û�����
	 * @param cla ��Ӧ����Ķ�����
	 * @param id ��Ӧ���������
	 */
	public void delete(Class<T> cla,Serializable id);
	
	/**
	 * HQL����ѯ
	 * @param HQL from Object obj
	 * @return ��ѯ����� list
	 */
	public List<T> select(String HQL);
	
	/**
	 * HQL����ѯ(��ռλ��?)
	 * @param HQL from Object obj where obj.����=?
	 * @param objects ��Ӧռλ������Ӧ�Ĳ���
	 * @return ��ѯ����� list
	 */
	public List<T>  select(String HQL,Object[] parmas);
	
	/**
	 * �ۺϺ�����ѯ
	 * @param HQL
	 * @return �ۺϽ��
	 */
	public Object seleceValue(String HQL);
	
	/**
	 * �������ľۺϺ�����ѯ
	 * @param HQL from Object obj where obj.����=?
	 * @param parmas ������[]
	 * @return �ۺϽ��
	 */
	public Object seleceValue(String HQL,Object[] parmas);
	
	/**
	 * ��ҳ��
	 * @param HQL from Object obj 
	 * @param perCount ÿҳ����������
	 * @return ��ҳ��
	 */
	public Long getPageCount(String HQL,int perCount);
	
	/**
	 * ����������ҳ��
	 * @param HQL from Object obj where obj.����=?
	 * @param parmas ������[]
	 * @param perCount ÿҳ����������
	 * @return ��ҳ��
	 */
	public Long getPageCount(String HQL,Object[] parmas,int perCount);
	
	/**
	 * ��ҳ
	 * @param HQL from Object obj
	 * @param perCount ÿҳ����������
	 * @param index ��ǰҳ 1��ʼ
	 * @return ��ҳ���list
	 */
	public List<T>  selectPage(String HQL,int perCount,int index);
	
	/**
	 * ��������ҳ
	 * @param HQL from Object obj where obj.����=?
	 * @param parmas ������[]
	 * @param perCount ÿҳ����������
	 * @param index ��ǰҳ 1��ʼ
	 * @return ��ҳ���list
	 */
	public List<T>  selectPage(String HQL,Object[] parmas,int perCount,int index);
	
}

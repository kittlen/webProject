package com.qyc.OneProject.basedao;

import java.util.List;

public interface iHibernatedao {
	
	/**
	 * ʵ�ֶ���ĳ־û�
	 * @param object ���в����Ķ���
	 * @return ��������� 0Ϊ���ʧ��
	 */
	public Object save(Object object);
	
	/**
	 * ��ȡ��Ӧ�����Ķ���
	 * @param cla ��Ӧ����Ķ�����
	 * @param object ��Ӧ����
	 * @return ��Ӧ�����Ķ���
	 */
	@SuppressWarnings("rawtypes")
	public Object getObj(Class cla,Object object);
	

	/**
	 * ����ĳ־û��޸�
	 * @param object ���в����Ķ���
	 * @return 1�޸ĳɹ� 0�޸�ʧ��
	 */
	public int update(Object object);
	
	/**
	 * ɾ���ض��־û��Ķ���
	 * @param object ���в����Ķ���
	 * @return 1ɾ���ɹ� 0ɾ��ʧ��
	 */
	public int delete(Object object);
	
	/**
	 * ɾ����Ӧ�����ĳ־û�����
	 * @param cla ��Ӧ����Ķ�����
	 * @param object ��Ӧ���������
	 * @return 1ɾ���ɹ� 0ɾ��ʧ��
	 */
	@SuppressWarnings("rawtypes")
	public int delete(Class cla,Object object);
	
	/**
	 * HQL����ѯ
	 * @param HQL from Object obj
	 * @return ��ѯ����� list
	 */
	@SuppressWarnings("rawtypes")
	public List select(String HQL);
	
	/**
	 * HQL����ѯ(��ռλ��?)
	 * @param HQL from Object obj where obj.����=?
	 * @param objects ��Ӧռλ������Ӧ�Ĳ���
	 * @return ��ѯ����� list
	 */
	@SuppressWarnings("rawtypes")
	public List select(String HQL,Object[] parmas);
	
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
	@SuppressWarnings("rawtypes")
	public List selectPage(String HQL,int perCount,int index);
	
	/**
	 * ��������ҳ
	 * @param HQL from Object obj where obj.����=?
	 * @param parmas ������[]
	 * @param perCount ÿҳ����������
	 * @param index ��ǰҳ 1��ʼ
	 * @return ��ҳ���list
	 */
	@SuppressWarnings("rawtypes")
	public List selectPage(String HQL,Object[] parmas,int perCount,int index);
	
}

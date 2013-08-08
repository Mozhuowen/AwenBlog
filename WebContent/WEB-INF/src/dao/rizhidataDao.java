package dao;

import java.util.*;

import domain.*;

public interface rizhidataDao 
{
	/**
	 * ����Personʵ��
	 * @param id ��Ҫ���ص�Personʵ��������ֵ
	 * @return ���ؼ��ص�Personʵ��
	 */ 
	rizhidata get(Integer id);
	 
	/**
	 * ����Personʵ��
	 * @param person ��Ҫ�����Personʵ��
	 * @return �ոձ����Personʵ���ı�ʶ����ֵ
	 */	
	Integer save(rizhidata rizhi);
	 
	/**
	 * �޸�Personʵ��
	 * @param person ��Ҫ�޸ĵ�Personʵ��
	 */
	void update(rizhidata rizhi);
	
	/**
	 * ɾ��Personʵ��
	 * @param id ��Ҫɾ����Personʵ���ı�ʶ����ֵ
	 */
	void delete(Integer id);
	
	/**
	 * ɾ��Personʵ��
	 * @param person ��Ҫɾ����Personʵ��
	 */
	void delete(rizhidata rizhi);
	
	/**
	 * �����û�������Person
	 * @param name ��ѯ������
	 * @return ָ���û�����Ӧ��ȫ��Person
	 */
	List<rizhidata> findByTitle(String title);
	
	List<rizhidata> findByMonth(int year,int month);
	
	List<Calendar> findByMonth(String gettime,int year,int month);
	
	/**
	 * ��ѯȫ��Personʵ��
	 * @return ȫ��Personʵ��
	 */
	public List<rizhidata> findAllrizhi();
	
	/**
	 * ��ѯ���ݱ���Personʵ��������
	 * @return ���ݱ���Personʵ��������
	 */
	long getrizhiNumber();
	
	public long getrizhiNumber(String sql);
	
	public long getrizhiNumber(String sql,Calendar starttime,Calendar endtime);

	public List<rizhidata> searchByTitle(String title);
	public List<rizhidata> searchByKeyWord(String keyword);
	List findByPage(final String hql, final int offset, final int pageSize);
	List findByPage(final String hql , final Object value ,final int offset, final int pageSize);
	List findByPage(final String hql, final Object[] values,final int offset, final int pageSize);
	List findByPage(final String hql , final long starttime,final long endtime,final int offset, final int pageSize);
}
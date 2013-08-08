package dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;

import dao.*;
import domain.*;

public class sortsDaoHibernate
	extends HibernateDaoSupport implements sortsDao
{
	/**
	 * ����ʵ��
	 * @param id ��Ҫ���ص�ʵ���ı�ʶ����ֵ
	 * @return ָ��id��Ӧ��ʵ��
	 */ 
	public sorts get(Integer id)
	{
		return getHibernateTemplate()
			.get(sorts.class, id); 
	}
	
	/**
	 * ����ʵ��
	 * @param person ��Ҫ�����ʵ��
	 * @return �ոձ����ʵ���ı�ʶ����ֵ
	 */   
	public Integer save(sorts sort)
	{
		return (Integer)getHibernateTemplate()
			.save(sort);
	}
	
	/**
	 * �޸�ʵ��
	 * @param ��Ҫ�޸ĵ�ʵ��
	 */
	public void update(sorts sort)
	{
		getHibernateTemplate().update(sort);
	}
	
	/**
	 * ɾ��ʵ��
	 * @param id ��Ҫɾ����ʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * ɾ��ʵ��
	 * @param person ��Ҫɾ����ʵ��
	 */
	public void delete(sorts sort)
	{
		getHibernateTemplate().delete(sort);
	}
	
	/**
	 * �����û�������
	 * @param name ��ѯ������
	 * @return ָ���û�����Ӧ��ȫ��
	 */
	public List<sorts> findByName(String name)
	{
		return (List<sorts>)getHibernateTemplate()
			.find("from sorts s where s.name= ?" , name);
	}
	
	/**
	 * ��ѯȫ��ʵ��
	 * @return ȫ��ʵ��
	 */
	public List<String> findAllsortnames()
	{
		return (List<String>)getHibernateTemplate()
			.find("select name from sorts");
	}
	public List findAllsorts()
	{
		return (List<sorts>)getHibernateTemplate()
			.find("from sorts");
	}
	public List<rizhidata> getAllrizhi(int sortid)
	{
		return (List<rizhidata>)getHibernateTemplate()
			.find("select rizhi from sorts s where s.sortid=?",sortid);
	}
	
	/**
	 * ��ѯ���ݱ���ʵ��������
	 * @return ���ݱ���ʵ��������
	 */
	public long getsortsNumber()
	{
		return (Long)getHibernateTemplate().find
			("select count(*) from sorts as s")
			.get(0);
	}

	public List<sorts> searchByName(String name)
	{
		name = "%"+name+"%";
		return (List<sorts>)getHibernateTemplate()
			.find("from sorts s where s.name like ?",name);
	}
}
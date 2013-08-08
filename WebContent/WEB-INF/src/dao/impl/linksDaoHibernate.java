package dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;

import dao.*;
import domain.*;

public class linksDaoHibernate
	extends HibernateDaoSupport implements linksDao
{
	/**
	 * ����ʵ��
	 * @param id ��Ҫ���ص�ʵ���ı�ʶ����ֵ
	 * @return ָ��id��Ӧ��ʵ��
	 */ 
	public links get(Integer id)
	{
		return getHibernateTemplate()
			.get(links.class, id); 
	}
	
	/**
	 * ����ʵ��
	 * @param person ��Ҫ�����ʵ��
	 * @return �ոձ����ʵ���ı�ʶ����ֵ
	 */   
	public Integer save(links link)
	{
		return (Integer)getHibernateTemplate()
			.save(link);
	}
	
	/**
	 * �޸�ʵ��
	 * @param ��Ҫ�޸ĵ�ʵ��
	 */
	public void update(links link)
	{
		getHibernateTemplate().update(link);
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
	public void delete(links link)
	{
		getHibernateTemplate().delete(link);
	}
	
	public List<links> findAlllinks()
	{
		return (List<links>)getHibernateTemplate().find("from links");
	}
	
	public long getlinksNumber()
	{
		return (Long)getHibernateTemplate().find("select count(*) from links as l").get(0);
	}
}
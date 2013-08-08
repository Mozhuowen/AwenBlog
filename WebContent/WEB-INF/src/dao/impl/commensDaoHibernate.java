package dao.impl;

import java.sql.SQLException;
import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;

import dao.*;
import domain.*;

public class commensDaoHibernate
	extends HibernateDaoSupport implements commensDao
{
	/**
	 * ����ʵ��
	 * @param id ��Ҫ���ص�ʵ���ı�ʶ����ֵ
	 * @return ָ��id��Ӧ��ʵ��
	 */ 
	public commens get(Integer id)
	{
		return getHibernateTemplate()
			.get(commens.class, id); 
	}
	
	/**
	 * ����ʵ��
	 * @param person ��Ҫ�����ʵ��
	 * @return �ոձ����ʵ���ı�ʶ����ֵ
	 */   
	public Integer save(commens commen)
	{
		return (Integer)getHibernateTemplate()
			.save(commen);
	}
	
	/**
	 * �޸�ʵ��
	 * @param ��Ҫ�޸ĵ�ʵ��
	 */
	public void update(commens commen)
	{
		getHibernateTemplate().update(commen);
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
	public void delete(commens commen)
	{
		getHibernateTemplate().delete(commen);
	}
	
	/**
	 * �����û�������
	 * @param name ��ѯ������
	 * @return ָ���û�����Ӧ��ȫ��
	 */
	public List<commens> findByAuthor(String author)
	{
		return (List<commens>)getHibernateTemplate()
			.find("from commens c where c.name= ?" , author);
	}
	public List<commens> findByRizhiid(int id)
	{
		String query = "from commens c where c.rizhi.rizhiid="+id;
		return (List<commens>)getHibernateTemplate()
			.find(query);
	}
	
	/**
	 * ��ѯȫ��ʵ��
	 * @return ȫ��ʵ��
	 */
	public List findAllcommens()
	{
		return (List<commens>)getHibernateTemplate()
			.find("from commens");
	}
	
	/**
	 * ��ѯ���ݱ���ʵ��������
	 * @return ���ݱ���ʵ��������
	 */
	public long getcommensNumber()
	{
		return (Long)getHibernateTemplate().find
			("select count(*) from commens as c")
			.get(0);
	}

	public List<commens> searchBycontent(String content)
	{
		content = "%"+content+"%";
		return (List<commens>)getHibernateTemplate()
			.find("from commens c where c.content like ?",content);
	}
	
	public List<commens> searchByback_content(String back_content)
	{
		back_content = "%"+back_content+"%";
		return (List<commens>)getHibernateTemplate()
			.find("from commens c where c.content like ?",back_content);
	}
	
	public List<commens> searchByAuthor(String author)
	{
		author = "%"+author+"%";
		return (List<commens>)getHibernateTemplate()
			.find("from commens c where c.author like ?",author);
	}
	//��ҳ��ѯ����
	/**
	 * ʹ��hql�����з�ҳ��ѯ
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	public List findByPage(final String hql, 
			final int offset, final int pageSize)
		{
			//ͨ��һ��HibernateCallback������ִ�в�ѯ
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					//ִ��Hibernate��ҳ��ѯ
					List result = session.createQuery(hql)
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
			return list;
		}
}
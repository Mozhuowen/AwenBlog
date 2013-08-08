package dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.HibernateException;
import java.sql.SQLException;
import java.sql.Timestamp;

import dao.*;
import domain.*;

public class rizhidataDaoHibernate
	extends HibernateDaoSupport implements rizhidataDao
{
	/**
	 * ����Personʵ��
	 * @param id ��Ҫ���ص�Personʵ���ı�ʶ����ֵ
	 * @return ָ��id��Ӧ��Personʵ��
	 */ 
	public rizhidata get(Integer id)
	{
		return getHibernateTemplate()
			.get(rizhidata.class, id); 
	}
	
	/**
	 * ����Personʵ��
	 * @param person ��Ҫ�����Personʵ��
	 * @return �ոձ����Personʵ���ı�ʶ����ֵ
	 */   
	public Integer save(rizhidata rizhi)
	{
		return (Integer)getHibernateTemplate()
			.save(rizhi);
	}
	
	/**
	 * �޸�Personʵ��
	 * @param person ��Ҫ�޸ĵ�Personʵ��
	 */
	public void update(rizhidata rizhi)
	{
		getHibernateTemplate().update(rizhi);
	}
	
	/**
	 * ɾ��Personʵ��
	 * @param id ��Ҫɾ����Personʵ���ı�ʶ����ֵ
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * ɾ��Personʵ��
	 * @param person ��Ҫɾ����Personʵ��
	 */
	public void delete(rizhidata rizhi)
	{
		getHibernateTemplate().delete(rizhi);
	}
	
	/**
	 * �����û�������Person
	 * @param name ��ѯ������
	 * @return ָ���û�����Ӧ��ȫ��Person
	 */
	public List<rizhidata> findByTitle(String title)
	{
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata r where r.title = ?" , title);
	}
	
	/**
	 * ��ѯȫ��Personʵ��
	 * @return ȫ��Personʵ��
	 */
	public List findAllrizhi()
	{
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata");
	}
	
	/**
	 * ��ѯ���ݱ���Personʵ��������
	 * @return ���ݱ���Personʵ��������
	 */
	public long getrizhiNumber()
	{
		return (Long)getHibernateTemplate().find
			("select count(*) from rizhidata as r")
			.get(0);
	}
	public long getrizhiNumber(String sql)
	{
		String query = "select count(*) "+sql;
		return (Long)getHibernateTemplate().find
			(query)
			.get(0);
	}
	public long getrizhiNumber(String sql,Calendar starttime,Calendar endtime)
	{
		String query = "select count(*) "+sql;
		return (Long)getHibernateTemplate().find
			(query,starttime,endtime)
			.get(0);
	}

	public List<rizhidata> searchByTitle(String title)
	{
		title = "%"+title+"%";
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata r where r.title like ?",title);
	}
	public List<rizhidata> searchByKeyWord(String keyword)
	{
		keyword = "%"+keyword+"%";
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata r where r.content like ?",keyword);
	}
	
	public List<rizhidata> findByMonth(int year,int month)
	{
		Calendar time = Calendar.getInstance();
		Calendar starttime = Calendar.getInstance();
		time.set(year, month, 1);
		starttime.set(year, month, 1);
		Calendar endtime = null;
		int lastdayOfmonth = 0;
		while(time.get(Calendar.MONTH)==month)
		{
			lastdayOfmonth = time.get(Calendar.DAY_OF_MONTH);
			time.add(Calendar.DATE,1);
		}
		time.set(year, month,lastdayOfmonth);
		endtime = time;
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata r where r.time>=? and r.time<=?",starttime,endtime);
	}
	
	public List<Calendar> findByMonth(String gettime,int year,int month)
	{
		Calendar time = Calendar.getInstance();
		Calendar starttime = Calendar.getInstance();
		time.set(year, month, 1);
		starttime.set(year, month, 1,0,0);
		Calendar endtime = null;
		int lastdayOfmonth = 0;
		while(time.get(Calendar.MONTH)==month)
		{
			lastdayOfmonth = time.get(Calendar.DAY_OF_MONTH);
			time.add(Calendar.DATE,1);
		}
		time.set(year, month,lastdayOfmonth,24,0);
		endtime = time;
		return (List<Calendar>)getHibernateTemplate()
			.find("select time from rizhidata r where r.time>=? and r.time<=?",starttime,endtime);
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

		/**
		 * ʹ��hql�����з�ҳ��ѯ
		 * @param hql ��Ҫ��ѯ��hql���
		 * @param value ���hql��һ��������Ҫ���룬value���Ǵ���hql���Ĳ���
		 * @param offset ��һ����¼����
		 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
		 * @return ��ǰҳ�����м�¼
		 */
		public List findByPage(final String hql , final Object value ,
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
						//Ϊhql��䴫�����
						.setParameter(0, value) 
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
			return list;
		}

		/**
		 * ʹ��hql�����з�ҳ��ѯ
		 * @param hql ��Ҫ��ѯ��hql���
		 * @param values ���hql�ж����������Ҫ���룬values���Ǵ���hql�Ĳ�������
		 * @param offset ��һ����¼����
		 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
		 * @return ��ǰҳ�����м�¼
		 */
		public List findByPage(final String hql, final Object[] values,
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
					Query query = session.createQuery(hql);
					//Ϊhql��䴫�����
					for (int i = 0 ; i < values.length ; i++)
					{
						query.setParameter( i, values[i]);
					}
					List result = query.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
			return list;
		}
		//��ѯ��ʼ����ʱ��Ľ����
		public List findByPage(final String hql , final long starttime,final long endtime,final int offset, final int pageSize)
		{
			
			//ͨ��һ��HibernateCallback������ִ�в�ѯ
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					Timestamp st = new Timestamp(starttime);
					Timestamp et = new Timestamp(endtime);
					//ִ��Hibernate��ҳ��ѯ
					List result = session.createQuery(hql)
						//Ϊhql��䴫�����
						.setTimestamp("starttime",st)
						.setTimestamp("endtime", et)
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
			return list;
		}
}
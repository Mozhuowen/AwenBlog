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
	 * 加载Person实例
	 * @param id 需要加载的Person实例的标识属性值
	 * @return 指定id对应的Person实例
	 */ 
	public rizhidata get(Integer id)
	{
		return getHibernateTemplate()
			.get(rizhidata.class, id); 
	}
	
	/**
	 * 保存Person实例
	 * @param person 需要保存的Person实例
	 * @return 刚刚保存的Person实例的标识属性值
	 */   
	public Integer save(rizhidata rizhi)
	{
		return (Integer)getHibernateTemplate()
			.save(rizhi);
	}
	
	/**
	 * 修改Person实例
	 * @param person 需要修改的Person实例
	 */
	public void update(rizhidata rizhi)
	{
		getHibernateTemplate().update(rizhi);
	}
	
	/**
	 * 删除Person实例
	 * @param id 需要删除的Person实例的标识属性值
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 删除Person实例
	 * @param person 需要删除的Person实例
	 */
	public void delete(rizhidata rizhi)
	{
		getHibernateTemplate().delete(rizhi);
	}
	
	/**
	 * 根据用户名查找Person
	 * @param name 查询的人名
	 * @return 指定用户名对应的全部Person
	 */
	public List<rizhidata> findByTitle(String title)
	{
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata r where r.title = ?" , title);
	}
	
	/**
	 * 查询全部Person实例
	 * @return 全部Person实例
	 */
	public List findAllrizhi()
	{
		return (List<rizhidata>)getHibernateTemplate()
			.find("from rizhidata");
	}
	
	/**
	 * 查询数据表中Person实例的总数
	 * @return 数据表中Person实例的总数
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
	//分页查询函数
	/**
	 * 使用hql语句进行分页查询
	 * @param hql 需要查询的hql语句
	 * @param offset 第一条记录索引
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	public List findByPage(final String hql, 
			final int offset, final int pageSize)
		{
			//通过一个HibernateCallback对象来执行查询
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//实现HibernateCallback接口必须实现的方法
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					//执行Hibernate分页查询
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
		 * 使用hql语句进行分页查询
		 * @param hql 需要查询的hql语句
		 * @param value 如果hql有一个参数需要传入，value就是传入hql语句的参数
		 * @param offset 第一条记录索引
		 * @param pageSize 每页需要显示的记录数
		 * @return 当前页的所有记录
		 */
		public List findByPage(final String hql , final Object value ,
			final int offset, final int pageSize)
		{
			//通过一个HibernateCallback对象来执行查询
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//实现HibernateCallback接口必须实现的方法
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					//执行Hibernate分页查询
					List result = session.createQuery(hql)
						//为hql语句传入参数
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
		 * 使用hql语句进行分页查询
		 * @param hql 需要查询的hql语句
		 * @param values 如果hql有多个个参数需要传入，values就是传入hql的参数数组
		 * @param offset 第一条记录索引
		 * @param pageSize 每页需要显示的记录数
		 * @return 当前页的所有记录
		 */
		public List findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize)
		{
			//通过一个HibernateCallback对象来执行查询
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//实现HibernateCallback接口必须实现的方法
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					//执行Hibernate分页查询
					Query query = session.createQuery(hql);
					//为hql语句传入参数
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
		//查询开始结束时间的结果集
		public List findByPage(final String hql , final long starttime,final long endtime,final int offset, final int pageSize)
		{
			
			//通过一个HibernateCallback对象来执行查询
			List list = getHibernateTemplate()
				.executeFind(new HibernateCallback()
			{
				//实现HibernateCallback接口必须实现的方法
				public Object doInHibernate(Session session)
					throws HibernateException, SQLException
				{
					Timestamp st = new Timestamp(starttime);
					Timestamp et = new Timestamp(endtime);
					//执行Hibernate分页查询
					List result = session.createQuery(hql)
						//为hql语句传入参数
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
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

public class tongjiDaoHibernate
	extends HibernateDaoSupport implements tongjiDao
{
	public tongji get(Integer id)
	{
		return getHibernateTemplate().get(tongji.class,id);
	}
	 
	public Integer save(tongji tj)
	{
		return (Integer)getHibernateTemplate()
		.save(tj);
	}
	
	public List<tongji> findbytime(Calendar time)
	{
		return (List<tongji>)getHibernateTemplate()
		.find("from tongji t where t.time=?" , time);
	}
	
	public List<tongji> findbyip(String ip)
	{
		return (List<tongji>)getHibernateTemplate()
		.find("from tongji t where t.ip=?" , ip);
	}
	
	public List<tongji> findbyurl(String url)
	{
		String query = "from tongji t where t.url like '%"+url+"%'";
		return (List<tongji>)getHibernateTemplate()
		.find(query);
	}
	
	public long getCountbytime(Calendar starttime,Calendar endtime)
	{
		return (Long)getHibernateTemplate().find("select count(*) from tongji t where t.time>=? and t.time<=?",starttime,endtime).get(0);
	}
	public long getCount()
	{
		return (Long)getHibernateTemplate().find("select count(*) from tongji").get(0);
	}
	
	public List findByPage(final String hql, final int offset, final int pageSize)
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
}
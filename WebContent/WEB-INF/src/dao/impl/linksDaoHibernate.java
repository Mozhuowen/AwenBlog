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
	 * 加载实例
	 * @param id 需要加载的实例的标识属性值
	 * @return 指定id对应的实例
	 */ 
	public links get(Integer id)
	{
		return getHibernateTemplate()
			.get(links.class, id); 
	}
	
	/**
	 * 保存实例
	 * @param person 需要保存的实例
	 * @return 刚刚保存的实例的标识属性值
	 */   
	public Integer save(links link)
	{
		return (Integer)getHibernateTemplate()
			.save(link);
	}
	
	/**
	 * 修改实例
	 * @param 需要修改的实例
	 */
	public void update(links link)
	{
		getHibernateTemplate().update(link);
	}
	
	/**
	 * 删除实例
	 * @param id 需要删除的实例的标识属性值
	 */
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	/**
	 * 删除实例
	 * @param person 需要删除的实例
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
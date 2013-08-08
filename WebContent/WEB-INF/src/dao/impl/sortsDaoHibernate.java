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
	 * 加载实例
	 * @param id 需要加载的实例的标识属性值
	 * @return 指定id对应的实例
	 */ 
	public sorts get(Integer id)
	{
		return getHibernateTemplate()
			.get(sorts.class, id); 
	}
	
	/**
	 * 保存实例
	 * @param person 需要保存的实例
	 * @return 刚刚保存的实例的标识属性值
	 */   
	public Integer save(sorts sort)
	{
		return (Integer)getHibernateTemplate()
			.save(sort);
	}
	
	/**
	 * 修改实例
	 * @param 需要修改的实例
	 */
	public void update(sorts sort)
	{
		getHibernateTemplate().update(sort);
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
	public void delete(sorts sort)
	{
		getHibernateTemplate().delete(sort);
	}
	
	/**
	 * 根据用户名查找
	 * @param name 查询的人名
	 * @return 指定用户名对应的全部
	 */
	public List<sorts> findByName(String name)
	{
		return (List<sorts>)getHibernateTemplate()
			.find("from sorts s where s.name= ?" , name);
	}
	
	/**
	 * 查询全部实例
	 * @return 全部实例
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
	 * 查询数据表中实例的总数
	 * @return 数据表中实例的总数
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
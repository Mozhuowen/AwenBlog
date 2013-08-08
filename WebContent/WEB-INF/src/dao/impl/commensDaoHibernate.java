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
	 * 加载实例
	 * @param id 需要加载的实例的标识属性值
	 * @return 指定id对应的实例
	 */ 
	public commens get(Integer id)
	{
		return getHibernateTemplate()
			.get(commens.class, id); 
	}
	
	/**
	 * 保存实例
	 * @param person 需要保存的实例
	 * @return 刚刚保存的实例的标识属性值
	 */   
	public Integer save(commens commen)
	{
		return (Integer)getHibernateTemplate()
			.save(commen);
	}
	
	/**
	 * 修改实例
	 * @param 需要修改的实例
	 */
	public void update(commens commen)
	{
		getHibernateTemplate().update(commen);
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
	public void delete(commens commen)
	{
		getHibernateTemplate().delete(commen);
	}
	
	/**
	 * 根据用户名查找
	 * @param name 查询的人名
	 * @return 指定用户名对应的全部
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
	 * 查询全部实例
	 * @return 全部实例
	 */
	public List findAllcommens()
	{
		return (List<commens>)getHibernateTemplate()
			.find("from commens");
	}
	
	/**
	 * 查询数据表中实例的总数
	 * @return 数据表中实例的总数
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
}
package dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.*;

import dao.*;
import domain.*;

public class usersDaoHibernate
	extends HibernateDaoSupport implements usersDao
{
	
	public users get(Integer id)
	{
		return getHibernateTemplate()
		.get(users.class, id); 
	}
	 
	public Integer save(users user)
	{
		return (Integer)getHibernateTemplate()
		.save(user);
	}
	 
	public void update(users user)
	{
		getHibernateTemplate().update(user);
	}
	
	public void delete(Integer id)
	{
		getHibernateTemplate().delete(get(id));
	}
	
	public void delete(users user)
	{
		getHibernateTemplate().delete(user);
	}

	public List<users> findByName(String name)
	{
		return (List<users>)getHibernateTemplate().find("from users u where u.name=?",name);
	}
	
	public users findByprivilege(int privilege)
	{
		return (users)getHibernateTemplate().find("from users u where u.privilege=?",privilege).get(0);
	}

	public List<users> findAllusers()
	{
		return (List<users>)getHibernateTemplate().find("from users");
	}

	public long getusersNumber()
	{
		return (Long)getHibernateTemplate().find("select count(*) from users u").get(0);
	}

	public List<users> searchByName(String name)
	{
		name = "%"+name+"%";
		return (List<users>)getHibernateTemplate()
				.find("from users as u where u.name like ?",name);
	}

}
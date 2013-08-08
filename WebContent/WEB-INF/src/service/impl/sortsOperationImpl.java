package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class sortsOperationImpl implements sortsOperation
{
	private rizhidataDao rizhi;
	private commensDao commen;
	private sortsDao sort;
	private usersDao user;
	private linksDao links;
	
	//为依赖注入设置方法-
	public void setRizhi(rizhidataDao rizhi)
	{
		this.rizhi = rizhi;
	}
	public void setCommen(commensDao commen)
	{
		this.commen = commen;
	}
	public void setSort(sortsDao sort)
	{
		this.sort = sort;
	}
	public void setUser(usersDao user)
	{
		this.user = user;
	}
	public void setLinks(linksDao link)
	{
		this.links = link;
	}
	
	public int addSort(String name)
	{
		sorts s  = new sorts(name);
		sort.save(s);
		return ADD_SUC;
	}
	
	public int update(int userId,String name)
	{
		sorts s = sort.get(userId);
		s.setName(name);
		sort.update(s);
		return UPDATE_SUC;
	}
	
	public int update(int userId,String name,Set<rizhidata> rizhidata)
	{
		sorts s = sort.get(userId);
		s.setName(name);
		s.setRizhidata(rizhidata);
		sort.update(s);
		return UPDATE_SUC;
	}
	
	public int update(int userId,String name,String[] rizhiTitle)
	{
		sorts s = sort.get(userId);
		s.setName(name);
		Set<rizhidata> tmpSet = new HashSet();
		for (int i = 0;i<rizhiTitle.length;i++)
			tmpSet.add(rizhi.findByTitle(rizhiTitle[i]).get(0));
		s.setRizhidata(tmpSet);
		sort.update(s);
		return UPDATE_SUC;
	}
	
	public int update(int userId,String name,int[] rizhiId)
	{
		sorts s = sort.get(userId);
		s.setName(name);
		Set<rizhidata> tmpSet = new HashSet();
		for (int i = 0;i<rizhiId.length;i++)
			tmpSet.add(rizhi.get(rizhiId[i]));
		s.setRizhidata(tmpSet);
		sort.update(s);
		return UPDATE_SUC;
	}
	
	public int delete(int userId)
	{
		sort.delete(userId);
		return UPDATE_SUC;
	}
	
	public int addSort(String name,Set<rizhidata> rizhilist)
	{
		sorts s = new sorts(name);
		s.setRizhidata(rizhilist);
		sort.save(s);
		return ADD_SUC;
	}
	
	public int addSort(String name,String[] rizhiTitle)
	{
		sorts s = new sorts(name);
		Set<rizhidata> tmplist = new HashSet();
		for (int i = 0;i<rizhiTitle.length;i++)
			tmplist.add(rizhi.findByTitle(rizhiTitle[i]).get(0));
		return ADD_SUC;
	}
	 
	public int addSort(String name,int[] rizhiId)
	{
		sorts s = new sorts(name);
		Set<rizhidata> tmplist = new HashSet();
		for (int i = 0;i<rizhiId.length;i++)
			tmplist.add(rizhi.get(rizhiId[i]));
		return ADD_SUC;
	}
	
	public List<sorts> getAllsorts()
	{
		return sort.findAllsorts();
	}
	public List<String> getAllsortnames()
	{
		return sort.findAllsortnames();
	}
	public sorts getSortbyid(int sortid)
	{
		return sort.get(sortid);
	}
}
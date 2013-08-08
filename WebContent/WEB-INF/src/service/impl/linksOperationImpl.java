package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class linksOperationImpl implements linksOperation
{
	private rizhidataDao rizhi;
	private commensDao commen;
	private sortsDao sort;
	private usersDao user;
	private linksDao links;
	
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
	
	public int addLinks(String sitename,String url,String description,int visible)
	{
		links l = new links(sitename,url,description,visible);
		links.save(l);
		return ADD_SUC;
	}
	
	public int update(int linkid,String sitename,String url,String description,int visible)
	{
		links l = links.get(linkid);
		l.setSitename(sitename);
		l.setUrl(url);
		l.setDescription(description);
		l.setVisible(visible);
		links.update(l);
		return UPDATE_SUC;
	}
	
	public int delete(int linkid)
	{
		links.delete(linkid);
		return DELETE_SUC;
	}
	
	public List<links> getAlllinks()
	{
		return links.findAlllinks();
	}
}
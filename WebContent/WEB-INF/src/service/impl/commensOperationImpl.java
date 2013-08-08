package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class commensOperationImpl implements commensOperation
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
	
	//增加评论方法
    public int addCommen(String author,String content,String back_content)
    {
    	commens c = new commens(author,content);
    	commen.save(c);
    	return ADD_SUC;
    }
    public int addCommen(String author,String ip,String email,String content)
    {
    	commens c = new commens(author,ip,email,content);
    	commen.save(c);
    	return ADD_SUC;
    }
	
	public int updata(int commenId,String author,String content,String back_content)
	{
		commens c = commen.get(commenId);
		c.setAuthor(author);
		c.setContent(content);
		c.setBack_content(back_content);
		commen.update(c);
		return UPDATE_SUC;
	}
	
	public int delete(int commenId)
	{
		commens c = commen.get(commenId);
		commen.delete(c);
		return DELETE_SUC;
	}
	
	public long getcommensNumber()
	{
		return commen.getcommensNumber();
	}
	
	public List<commens> searchByKeyword(String keyword)
	{
		List<commens> tmpList1 = commen.searchBycontent(keyword);
		List<commens> tmpList2 = commen.searchByback_content(keyword);
		ArrayList<commens> arraylist = new ArrayList();
		arraylist.addAll(tmpList1);
		arraylist.addAll(tmpList2);
		return arraylist;
	}
	
	public List<commens> searchByAuthor(String author)
	{
		return commen.searchByAuthor(author);
	}
	
	public List<commens> getAllcommens()
	{
		return commen.findAllcommens();
	}
	
	public List<commens> findByRizhiid(int id)
	{
		return commen.findByRizhiid(id);
	}
	public List findByPage(final String hql, final int offset, final int pageSize)
	{
		return commen.findByPage(hql, offset, pageSize);
	}
}
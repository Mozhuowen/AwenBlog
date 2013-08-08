package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_edit_article_action implements Action
{
	private int blogid;
	private rizhidataDao rizhi;
	private sortsDao sort;
	private rizhidata r;
	private List<sorts> s;


	public void setBlogid(int b)
	{
		this.blogid = b;
	}
	public int getBlogid()
	{
		return this.blogid;
	}
	public void setRizhi(rizhidataDao r)
	{
		this.rizhi = r;
	}
	public rizhidataDao getRizhi()
	{
		return this.rizhi;
	}
	public void setR(rizhidata rr)
	{
		this.r = rr;
	}
	public rizhidata getR()
	{
		return this.r;
	}
	public void setS(List<sorts> ss)
	{
		this.s = ss;
	}
	public List<sorts> getS()
	{
		return this.s;
	}
	public void setSort(sortsDao sss)
	{
		this.sort = sss;
	}
	public sortsDao getSort()
	{
		return this.sort;
	}
	
	public String execute() throws Exception
	{
		setR(rizhi.get(blogid));
		setS(sort.findAllsorts());
		return SUCCESS;
	}
}
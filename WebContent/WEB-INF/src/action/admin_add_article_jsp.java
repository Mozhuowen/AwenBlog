package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_add_article_jsp implements Action
{
	private sortsOperation sort;
	private List<sorts> sortslist;
	public void setSort(sortsOperation s)
	{
		this.sort = s;
	}
	public sortsOperation getSort()
	{
		return this.sort;
	}
	public void setSortslist(List<sorts> s)
	{
		this.sortslist = s;
	}
	public List<sorts> getSortslist()
	{
		return this.sortslist;
	}
	public String execute() throws Exception
	{
		List<sorts> tmplist = sort.getAllsorts();
		setSortslist(tmplist);
		return SUCCESS;
	}
}
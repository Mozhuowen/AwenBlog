package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class testaction implements Action
{
	private String tip;
	private String test;
	private rizhiOperation rizhi;
	public void setRizhi(rizhiOperation r)
	{
		this.rizhi = r;
	}
	public rizhiOperation getRizhi()
	{
		return this.rizhi;
	}
	public void setTip(String t)
	{
		this.tip = t;
	}
	public String getTip()
	{
		return this.tip;
	}
	public void setTest(String s)
	{
		this.test = s;
	}
	public String getTest()
	{
		return this.test;
	}
	public String execute() throws Exception
	{
		List<rizhidata> tmplist = rizhi.searchContent("CONTENT");
		setTip(tmplist.get(3).getTitle());
		if(tip!=null)
			return SUCCESS;
		else
			return ERROR;
	}
}
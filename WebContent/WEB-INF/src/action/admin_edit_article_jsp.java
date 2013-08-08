package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_edit_article_jsp implements Action
{
	private rizhiOperation rizhi;   //依赖注入
	private sortsOperation sort;    //依赖注入
	private int sortid = 0;
	private List<sorts>  sortlist;
	private List<rizhidata> rizhilist;
	
	public void setSort(sortsOperation s)
	{
		this.sort = s;
	}
	public sortsOperation getSort()
	{
		return this.sort;
	}
	public void setSortid(int s)
	{
		this.sortid = s;
	}
	public int getSortid()
	{
		return this.sortid;
	}
	public void setSortlist(List<sorts> s )
	{
		this.sortlist = s;
	}
	public List<sorts> getSortlist()
	{
		return this.sortlist;
	}
	public void setRizhi(rizhiOperation r)
	{
		this.rizhi = r;
	}
	public rizhiOperation getRizhi()
	{
		return this.rizhi;
	}
	public void setRizhilist(List<rizhidata> r)
	{
		this.rizhilist = r;
	}
	public List<rizhidata> getRizhilist()
	{
		return this.rizhilist;
	}
	
	public String execute() throws Exception
	{
		setSortlist(sort.getAllsorts());
		List<rizhidata> tmplist = rizhi.getAllrizhi();
		Collections.sort(tmplist,new Comparator<rizhidata>(){  //排序日志,最近发表的的排前面
			public int compare(rizhidata r1,rizhidata r2)
			{
				if(r1.getTime().getTimeInMillis()<r2.getTime().getTimeInMillis())
					return 1;
				else if(r1.getTime().getTimeInMillis()>r2.getTime().getTimeInMillis())
					return -1;
				else
					return 0;
			}
	});
		setRizhilist(tmplist);
		return SUCCESS;
	}
	
	public String sort() throws Exception
	{
		setSortlist(sort.getAllsorts());
		if(sortid!=0)
		{
			sorts s = sort.getSortbyid(sortid);
			List<rizhidata> tmplist = new ArrayList(s.getRizhidata());
			Collections.sort(tmplist,new Comparator<rizhidata>(){  //排序日志,最近发表的的排前面
				public int compare(rizhidata r1,rizhidata r2)
				{
					if(r1.getTime().getTimeInMillis()<r2.getTime().getTimeInMillis())
						return 1;
					else if(r1.getTime().getTimeInMillis()>r2.getTime().getTimeInMillis())
						return -1;
					else
						return 0;
				}
		});
			setRizhilist(tmplist);
			return SUCCESS;
		}
		return ERROR;
	}
}
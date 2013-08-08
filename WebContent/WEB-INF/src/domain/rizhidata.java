package domain;

import java.util.*;
/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
public class rizhidata
{
	//标识属性
	private int rizhiid;
//	private String user;
	public Calendar time;
	private String content;
	private String precontent;
	private String title;
	private users user;
	private int iscomment;
	private int visible;
	private int visitimes;
	private int stick;
	private String attachmentfilename;
	//N－N关联关系，使用Set来保存关联实体
	private Set<sorts> sorts = new HashSet<sorts>();
	//1-N关系，用set保存
	private Set<commens> commens = new HashSet<commens>();

	//无参数的构造器
	public rizhidata()
	{
	}
	//初始化全部属性的构造器
	public rizhidata(users user , String title,Calendar time,String content,String precontent)
	{
		this.rizhiid = rizhiid;
		this.user = user;
		this.title = title;
		this.time = time;
		this.content = content;
		this.precontent = precontent;
	}
	public rizhidata(users user , String title,Calendar time,String content,String precontent,int iscomment,int visible,int stick,String attachmentfilename)
	{
		this.user = user;
		this.title = title;
		this.time = time;
		this.content = content;
		this.precontent = precontent;
		this.iscomment = iscomment;
		this.visible = visible;
		this.stick = stick;
		this.attachmentfilename = attachmentfilename;
	}

	//personid属性的setter和getter方法
	public void setRizhiid(int rizhiid)
	{
		this.rizhiid = rizhiid;
	}
	public int getRizhiid()
	{
		return this.rizhiid;
	}

	//user属性的setter和getter方法
	public void setUser(users user)
	{
		this.user = user;
	}
	public users getUser()
	{
		return this.user;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//time属性的setter和getter方法
	public void setTime(Calendar time)
	{
		this.time = time;
	}
	public Calendar getTime()
	{
		return this.time;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	public void setPrecontent(String precontent)
	{
		this.precontent = precontent;
	}
	public String getPrecontent()
	{
		return this.precontent;
	}

	public void setUsers(users users)
	{
		this.user = users;
	}
	public users getUsers()
	{
		return this.user;
	}

	public void setSorts(Set<sorts> sorts)
	{
		this.sorts = sorts;
	}
	public Set<sorts> getSorts()
	{
		return this.sorts;
	}

	public void setCommens(Set<commens> commens)
	{
		this.commens = commens;
	}
	public Set<commens> getCommens()
	{
		return this.commens;
	}
	
	public void setIscomment(int i)
	{
		this.iscomment = i;
	}
	public int getIscomment()
	{
		return this.iscomment;
	}
	public void setVisible(int v)
	{
		this.visible = v;
	}
	public int getVisible()
	{
		return this.visible;
	}
	public void setStick(int s)
	{
		this.stick = s;
	}
	public int getStick()
	{
		return this.stick;
	}
	public void setVisitimes(int v)
	{
		this.visitimes = v;
	}
	public int getVisitimes()
	{
		return this.visitimes;
	}
	public void setAttachmentfilename(String a)
	{
		this.attachmentfilename = a;
	}
	public String getAttachmentfilename()
	{
		return this.attachmentfilename;
	}
	//重写equals方法
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()==rizhidata.class)
		{
			rizhidata rizhi = (rizhidata)obj;
			return (this.getTitle()+this.getTime())== (rizhi.getTitle()+rizhi.getTime());
		}
		return false;
	}
}
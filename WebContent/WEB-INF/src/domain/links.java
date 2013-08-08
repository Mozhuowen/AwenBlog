package domain;

import java.util.*;

public class links
{
	//标识属性
	private int linkid;
	private String sitename;
	private String url;
	private String description;
	private int visible;

	//无参数的构造器
	public links()
	{
	}
	//初始化全部属性的构造器
	public links(String sitename,String url,String description,int visible)
	{
		this.sitename = sitename;
		this.url = url;
		this.description = description;
		this.visible = visible;
	}

	//personid属性的setter和getter方法
	public void setLinkid(int linkid)
	{
		this.linkid = linkid;
	}
	public int getLinkid()
	{
		return this.linkid;
	}
	public void setSitename(String s)
	{
		this.sitename = s;
	}
	public String getSitename()
	{
		return this.sitename;
	}
	public void setUrl(String u)
	{
		this.url = u;
	}
	public String getUrl()
	{
		return this.url;
	}
	public void setDescription(String d)
	{
		this.description = d;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setVisible(int v)
	{
		this.visible = v;
	}
	public int getVisible()
	{
		return this.visible;
	}
	
	//重写equals方法
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()== links.class)
		{
			links link  = (links)obj;
			return this.getUrl()== link.getUrl();
		}
		return false;
	}
}
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
public class sorts
{
	//标识属性
	private int sortid;
	private String name;
	
	//N－N关联关系，使用Set来保存关联实体
	private Set<rizhidata> rizhidata
		= new HashSet<rizhidata>();

	//无参数的构造器
	public sorts()
	{
	}
	//初始化全部属性的构造器
	public sorts(String name)
	{
		this.name = name;
	}

	//personid属性的setter和getter方法
	public void setSortid(int sortid)
	{
		this.sortid = sortid;
	}
	public int getSortid()
	{
		return this.sortid;
	}

	//user属性的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//addresses属性的setter和getter方法
	public void setRizhidata(Set<rizhidata> rizhidata)
	{
		this.rizhidata = rizhidata;
	}
	public Set<rizhidata> getRizhidata()
	{
		return this.rizhidata;
	}
	
	
	//重写equals方法
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()== sorts.class)
		{
			sorts sort  = (sorts)obj;
			return this.getName()== sort.getName();
		}
		return false;
	}
}
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
	//��ʶ����
	private int sortid;
	private String name;
	
	//N��N������ϵ��ʹ��Set���������ʵ��
	private Set<rizhidata> rizhidata
		= new HashSet<rizhidata>();

	//�޲����Ĺ�����
	public sorts()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public sorts(String name)
	{
		this.name = name;
	}

	//personid���Ե�setter��getter����
	public void setSortid(int sortid)
	{
		this.sortid = sortid;
	}
	public int getSortid()
	{
		return this.sortid;
	}

	//user���Ե�setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	//addresses���Ե�setter��getter����
	public void setRizhidata(Set<rizhidata> rizhidata)
	{
		this.rizhidata = rizhidata;
	}
	public Set<rizhidata> getRizhidata()
	{
		return this.rizhidata;
	}
	
	
	//��дequals����
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
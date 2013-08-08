package domain;

import java.util.*;

public class tongji
{
	private int tongjiid;
	private Calendar time;
	private String ip;
	private String url;
	
	public tongji()
	{
	}
	public tongji(Calendar time,String ip,String url)
	{
		this.time = time;
		this.ip = ip;
		this.url = url;
	}
	public void setTongjiid(int t)
	{
		this.tongjiid = t;
	}
	public int getTongjiid()
	{
		return this.tongjiid;
	}
	public void setTime(Calendar c)
	{
		this.time = c;
	}
	public Calendar getTime()
	{
		return this.time;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public String getIp()
	{
		return this.ip;
	}
	public void setUrl(String u)
	{
		this.url = u;
	}
	public String getUrl()
	{
		return this.url;
	}
	//÷ÿ–¥equals∑Ω∑®
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()==tongji.class)
		{
			tongji tongji = (tongji)obj;
			return this.tongjiid == tongji.getTongjiid() ;
		}
		return false;
	}
}
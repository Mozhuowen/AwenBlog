package domain;

import java.util.*;

public class commens
{
	//��ʶ����
	private int commenid;
	private String author;   //��������������Ƿÿͣ��ʲ�������users��
	private String ip;
	private String email;
	private String content;
	private String back_content;
	private rizhidata rizhi;
	private Calendar time;

	//�޲����Ĺ�����
	public commens()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public commens(String author,String content,String back_content)
	{
		this.author = author;
		this.content = content;
		this.back_content = back_content;
	}
	public commens(String author,String ip,String email,String content)
	{
		this.author = author;
		this.ip = ip;
		this.email = email;
		this.content = content;
	}
	public commens(String author,String content)
	{
		this.author = author;
		this.content = content;
	}

	//personid���Ե�setter��getter����
	public void setCommenid(int commenid)
	{
		this.commenid = commenid;
	}
	public int getCommenid()
	{
		return this.commenid;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	public void setBack_content(String back_content)
	{
		this.back_content = back_content;
	}
	public String getBack_content()
	{
		return this.back_content;
	}

	public void setRizhi(rizhidata rizhi)
	{
		this.rizhi = rizhi;
	}
	public rizhidata getRizhi()
	{
		return this.rizhi;
	}
	public void setIp(String i)
	{
		this.ip = i;
	}
	public String getIp()
	{
		return this.ip;
	}
	public void setEmail(String e)
	{
		this.email = e;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setTime(Calendar c)
	{
		this.time = c;
	}
	public Calendar getTime()
	{
		return this.time;
	}
	//��дequals����
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()==commens.class)
		{
			commens commen = (commens)obj;
			return this.getCommenid()== commen.getCommenid();
		}
		return false;
	}

}
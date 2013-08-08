package domain;

import java.util.*;

public class users
{
	//��ʶ����
	private int userid;
	private String name;
	private String pass;
	private int privilege;
	private String petname;      //�ǳ�
	private String sex;         //�Ա�
	private String qq;         //QQ
	private String email;       //email
	private String homepage;    //��ҳ
	private String birth_year;   //������
	private String hobby;       //����
	private String profession;    //�س�
	private String description;    //��������
	private Set<rizhidata> rizhi = new HashSet<rizhidata>();

	//�޲����Ĺ�����
	public users()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public users(String name,String pass,int privilege)
	{
		this.name = name;
		this.pass = pass;
		this.privilege = privilege;
	}

	//personid���Ե�setter��getter����
	public void setUserid(int userid)
	{
		this.userid = userid;
	}
	public int getUserid()
	{
		return this.userid;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	public void setPrivilege(int privilege)
	{
		this.privilege = privilege;
	}
	public int getPrivilege()
	{
		return this.privilege;
	}

	public void setRizhi(Set<rizhidata> rizhi)
	{
		this.rizhi = rizhi;
	}
	public Set<rizhidata> getRizhi()
	{
		return this.rizhi;
	}
	public void setPetname(String s)
	{
		this.petname = s;
	}
	public String getPetname()
	{
		return this.petname;
	}
	public void setSex(String s)
	{
		this.sex = s;
	}
	public String getSex()
	{
		return this.sex;
	}
	public void setQq(String s)
	{
		this.qq = s;
	}
	public String getQq()
	{
		return this.qq;
	}
	public void setEmail(String s)
	{
		this.email = s;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setHomepage(String s)
	{
		this.homepage = s;
	}
	public String getHomepage()
	{
		return this.homepage;
	}
	public void setBirth_year(String s)
	{
		this.birth_year = s;
	}
	public String getBirth_year()
	{
		return this.birth_year;
	}
	public void setHobby(String s)
	{
		this.hobby = s;
	}
	public String getHobby()
	{
		return this.hobby;
	}
	public void setProfession(String s)
	{
		this.profession = s;
	}
	public String getProfession()
	{
		return this.profession;
	}
	public void setDescription(String s)
	{
		this.description = s;
	}
	public String getDescription()
	{
		return this.description;
	}
	//��дequals����
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj!= null
				&&obj.getClass()== users.class)
		{
			users user  = (users)obj;
			return this.getUserid()== user.getUserid();
		}
		return false;
	}
}
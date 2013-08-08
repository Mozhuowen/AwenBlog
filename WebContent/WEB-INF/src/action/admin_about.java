package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_about implements Action
{
	private static final String SUCCESS = "success";
	private static final String EDIT = "edit";
	
	private usersOperation  user;      //����ע��
	private users currentuser;    
	private String petname;      //�ǳ�
	private String sex;         //�Ա�
	private String qq;         //QQ
	private String email;       //email
	private String homepage;    //��ҳ
	private String birth_year;   //������
	private String hobby;       //����
	private String profession;    //�س�
	private String description;    //��������
	
	public void setUser(usersOperation u)
	{
		this.user = u;
	}
	public usersOperation getUser()
	{
		return this.user;
	}
	public void setCurrentuser(users u)
	{
		this.currentuser = u;
	}
	public users getCurrentuser()
	{
		return this.currentuser;
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
	
	
	public String execute() throws Exception
	{
		users u = user.finduser(603);
		setCurrentuser(u);
		return EDIT;
	}
	
	public String edit() throws Exception
	{
		users u = user.finduser(603);
		int id = u.getUserid();
		if(0 != user.updateabout(id, petname, sex, qq, email, homepage, birth_year, hobby, profession, description))
			return ERROR;
		else
			return SUCCESS;
	}
}
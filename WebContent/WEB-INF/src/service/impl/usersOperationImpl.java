package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class usersOperationImpl implements usersOperation
{
	private rizhidataDao rizhi;
	private commensDao commen;
	private sortsDao sort;
	private usersDao user;
	private linksDao links;
	
	//Ϊ����ע�����÷���-
	public void setRizhi(rizhidataDao rizhi)
	{
		this.rizhi = rizhi;
	}
	public void setCommen(commensDao commen)
	{
		this.commen = commen;
	}
	public void setSort(sortsDao sort)
	{
		this.sort = sort;
	}
	public void setUser(usersDao user)
	{
		this.user = user;
	}
	public void setLinks(linksDao link)
	{
		this.links = link;
	}
	
	//�����û�����
	public int addUser(String name,String pass,int privilege)
	{
		List<users> tmpList = user.findByName(name);
		if(tmpList.size()>0)
			return ADD_FAIL;
		else
		{
			users u = new users(name,pass,privilege);
			user.save(u);   //�־û�����
			return ADD_SUC;
		}
	}
	
	public int updata(int userId,String name,String pass,int privilege)
	{
		//��ȡ�û�����
		users u = user.get(userId);
		if(u == null)
			return UPDATE_FAIL;
		else
		{
			u.setName(name);
			u.setPass(pass);
			u.setPrivilege(privilege);
			user.update(u);
			return UPDATE_SUC;
		}
	}
	public int updateabout(int userId,String petname,String sex,String qq,String email,String homepage,String birth_year,String hobby,String profession,String description)
	{
		//��ȡ�û�����
		users u = user.get(userId);
		if(u == null)
			return UPDATE_FAIL;
		else
		{
			u.setPetname(petname);
			u.setSex(sex);
			u.setQq(qq);
			u.setEmail(email);
			u.setHomepage(homepage);
			u.setBirth_year(birth_year);
			u.setHobby(hobby);
			u.setProfession(profession);
			u.setDescription(description);
			user.update(u);
			return UPDATE_SUC;
		}
	}
	
	public users finduser(int privilege)
	{
		return user.findByprivilege(privilege);
	}
	
	public int delete(int userId)
	{
		users u = user.get(userId);
		user.delete(u);
		return DELETE_SUC;
	}
	
	public List<users> searchByName(String name)
	{
		List<users> tmpList = user.searchByName(name);
		return tmpList;
	}
	
	public List<users> getAllusers()
	{
		return user.findAllusers();
	}
}
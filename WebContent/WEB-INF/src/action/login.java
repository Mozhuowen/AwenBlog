package action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class login implements Action
{
	private usersOperation user;    //“¿¿µ◊¢»Î
	private String username;
	private String password;
	
	public void setUser(usersOperation u)
	{
		this.user = u;
	}
	public usersOperation getUser()
	{
		return this.user;
	}
	public void setUsername(String u)
	{
		this.username = u;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setPassword(String p)
	{
		this.password = p;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	ActionContext ctx = ActionContext.getContext();
	public String execute() throws Exception
	{
		String ip = org.apache.struts2.ServletActionContext.getRequest().getRemoteAddr();
		
		List<users> u = user.searchByName(username);
		if(u.isEmpty())
			return ERROR;
		boolean flag = false;
		if(u.get(0).getPass().equals(password)&&u.get(0).getPrivilege()==603)
			flag = true;
		if(flag)
		{
			ctx.getSession().put("auth", "true");
			ctx.getSession().put("ip", ip);
			return SUCCESS;
		}
		else
			return ERROR;
			
		
	}
	
	public String logout() throws Exception
	{
		if(ctx.getSession().containsKey("ip"))
			ctx.getSession().remove("ip");
		if(ctx.getSession().containsKey("auth"))
			ctx.getSession().remove("auth");
		return "logout";
	}
}
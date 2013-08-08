package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_users implements Action
{
	private static final String EDIT_SUC = "edit_success";
	private static final String EDIT1_SUC = "edit1_success";
	private static final String DELETE_SUC = "delete_success";
	private static final String ADD_SUC = "add_success";
	private static final String UPDATE_SUC = "update_success";
	
	private usersOperation user;
	private usersDao userr;
	private int userid;
	private users currentuser;
	private String oldpassword;
	private String newpassword;
	private String confirpassword;
	private String submit;
	
	public void setUser(usersOperation u)
	{
		this.user = u;
	}
	public usersOperation getUser()
	{
		return this.user;
	}
	public void setUserid(int u)
	{
		this.userid = u;
	}
	public int getUserid()
	{
		return this.userid;
	}
	public void setOldpassword(String o)
	{
		this.oldpassword = o;
	}
	public String getOldpassword()
	{
		return this.oldpassword;
	}
	public void setNewpassword(String n)
	{
		this.newpassword = n;
	}
	public String getNewpassword()
	{
		return this.newpassword;
	}
	public void setConfirpassword(String c)
	{
		this.confirpassword = c;
	}
	public String getConfirpassword()
	{
		return this.confirpassword;
	}
	public void setUserr(usersDao u)
	{
		this.userr = u;
	}
	public usersDao getUserr()
	{
		return this.userr;
	}
	public void setCurrentuser(users c)
	{
		this.currentuser = c;
	}
	public users getCurrentuser()
	{
		return this.currentuser;
	}
	public void setSubmit(String s)
	{
		this.submit = s;
	}
	public String getSubmit()
	{
		return this.submit;
	}

	
	public String execute() throws Exception
	{
		users u = user.finduser(603);
		setCurrentuser(u);
		return SUCCESS;
	}
	public String update() throws Exception
	{
		users u = user.finduser(603);
		if (!u.getPass().equals(oldpassword) ||!newpassword.equals(confirpassword))
			return ERROR;
		else if(0 != user.updata(userid, u.getName(), newpassword, 603))
			return ERROR;
		else
			return UPDATE_SUC;
	}
}
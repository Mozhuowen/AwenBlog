package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_links implements Action
{
	private static final String EDIT = "edit";
	private static final String ADD_SUC = "add_success";
	private static final String DELETE_SUC = "delete_success";
	
	private linksOperation link;    //“¿¿µ◊¢»Î
	private linksDao linkdao;      //“¿¿µ◊¢»Î
	private List<links> linklist;
	private int linkid;
	private links currentlink;
	private String sitename;
	private String url;
	private String description;
	private int visible;
	private String submit;
	
	public void setLink(linksOperation l)
	{
		this.link = l;
	}
	public linksOperation getLink()
	{
		return this.link;
	}
	public void setLinklist(List<links> l)
	{
		this.linklist = l;
	}
	public List<links> getLinklist()
	{
		return this.linklist;
	}
	public void setLinkid(int l)
	{
		this.linkid = l;
	}
	public int getLinkid()
	{
		return this.linkid;
	}
	public void setCurrentlink(links l)
	{
		this.currentlink = l;
	}
	public links getCurrentlink()
	{
		return this.currentlink;
	}
	public void setLinkdao(linksDao l)
	{
		this.linkdao = l;
	}
	public linksDao getLinkdao()
	{
		return this.linkdao;
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
		setLinklist(link.getAlllinks());
		return SUCCESS;
	}
	
	public String edit() throws Exception
	{
		setCurrentlink(linkdao.get(linkid));
		return EDIT;
	}
	
	public String add() throws Exception
	{	
		if(linkid != 0)
		{
			if(0 == link.update(linkid, sitename, url, description, visible))
			{
				setLinklist(link.getAlllinks());
				return ADD_SUC;
			}
			else
				return ERROR;
		}
		else
		{
			if(0 == link.addLinks(sitename, url, description, visible))
			{
				setLinklist(link.getAlllinks());
				return ADD_SUC;
			}
			else
				return ERROR;
		}			
	}
	
	public String delete() throws Exception
	{
		if(0 == link.delete(linkid))
			return DELETE_SUC;
		else
			return ERROR;
	}
}
package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_sorts implements Action
{
	private static final String EDIT_SUC = "edit_success";
	private static final String EDIT1_SUC = "edit1_success";
	private static final String DELETE_SUC = "delete_success";
	private static final String ADD_SUC = "add_success";
	private static final String NULLADD = "nulladd";
	
	private sortsOperation sort;      //����ע��
	private sortsDao sortdao;
	public List<sorts> sortlist;  
	public sorts currentsort;         //��jspҳ�����
	public int[] sortid;
	public String sortname;
	public String submit;
	public String tip;
	
	public void setSort(sortsOperation sort)
	{
		this.sort = sort;
	}
	public sortsOperation getSort()
	{
		return this.sort;
	}
	public void setSortlist(List<sorts> sortlist)
	{
		this.sortlist = sortlist;
	}
	public List<sorts> getSortlist()
	{
		return this.sortlist;
	}
	public void setCurrentsort(sorts cs)
	{
		this.currentsort = cs;
	}
	public sorts getCurrentsort()
	{
		return this.currentsort;
	}
	public void setSortname(String s) throws Exception
	{
		this.sortname = new String(s.getBytes("GBK"),"GBK");
	}
	public String getSortname()
	{
		return this.sortname;
	}
	public void setSortdao(sortsDao s)
	{
		this.sortdao = s;
	}
	public sortsDao getSortdao()
	{
		return this.sortdao;
	}
	public void setSubmit(String s)
	{
		this.submit = s;
	}
	public String getSubmit()
	{
		return this.submit;
	}
	public void setTip(String t)
	{
		this.tip = t;
	}
	public String getTip()
	{
		return this.tip;
	}
	
	//Ĭ���г����еľ���ķ�����Ϣ
	public String execute() throws Exception
	{
		setSortlist(sort.getAllsorts());
		return SUCCESS;
	}
	//����edit����
	public String edit() throws Exception
	{
		setCurrentsort(sortdao.get(sortid[0]));
		return EDIT_SUC;
	}

	//����delete����
	public String delete() throws Exception
	{
		if (0 == sort.delete(sortid[0]))
			return DELETE_SUC;
		else
			return ERROR;
	}
	//����add����
	public String add() throws Exception
	{
		setTip(sortname);
		if(sortid == null)   //�������
		{
			if (0 == sort.addSort(sortname))
				return ADD_SUC;
			else
				return ERROR;
		}
		else             //����������
		{
			if (0 == sort.update(sortid[0], sortname))
				return EDIT1_SUC;
			else
				return ERROR;
		}
	}
	public String nulladd()
	{
		sorts s = null;
		setCurrentsort(s);
		return NULLADD;
	}
}
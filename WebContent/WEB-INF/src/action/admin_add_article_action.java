package action;

import com.opensymphony.xwork2.Action;

import java.io.*;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_add_article_action implements Action
{
	//�����������
	public static final String UPDATE_SUC = "update_success";
	public static final String DELETE_SUC = "delete_success";
	public static final String DELETE_FAIL = "delete_fail";
	
	private String tip;      //Ԥ�� ����Ϣ��ʾ
	private rizhiOperation rizhi;     //service���
	private String title;     //��־��Ŀ
	private String author;    //����
	private int[] sortid;      //���,struts2�Զ������������뼯�ϡ������ת��
	private String description ;          //����
	private String content;      //����
	private int iscomment;    //�Ƿ���������
	private int visible;      //�Ƿ�ɼ�
	private int stick;        //�Ƿ��ö�
	private File attachment;  //����              //�ϴ����ļ�
	private String attachmentContentType;   //struts2��Ҫ��װ�ļ���������
	private String attachmentFileName;      //struts2��Ҫ��װ�ϴ��ļ�������,��ʽ��"�ֶ���+FileName",��ͬ
	private String savepath;               //��struts2.xml�ļ��������� ֵ
	private String action;              //Ԥ��
	private String submit;             //�ύ��ť
	private int[] blogid;              //���ر����ݣ��������������־��ID
	
	public void setTip(String tip)
	{
		this.tip = tip;
	}
	public String getTip()
	{
		return this.tip;
	}
	public void setRizhi(rizhiOperation rizhi)
	{
		this.rizhi = rizhi;
	}
	public rizhiOperation getRizhi()
	{
		return this.rizhi;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}
	public void setAuthor(String a)
	{
		this.author = a;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public void setSortid(int[] s)
	{
		this.sortid = s;
	}
	public int[] getSortid()
	{
		return this.sortid;
	}
	public void setDescription(String d)
	{
		this.description = d;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setContent(String c)
	{
		this.content = c;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setIscomment(int i)
	{
		this.iscomment = i;
	}
	public int getIscomment()
	{
		return this.iscomment;
	}
	public void setVisible(int v)
	{
		this.visible = v;
	}
	public int getVisible()
	{
		return this.visible;
	}
	public void setStick(int s)
	{
		this.stick = s;
	}
	public int getStick()
	{
		return this.stick;
	}
	public void setAttachment(File a)
	{
		this.attachment = a;
	}
	public File getAttachment()
	{
		return this.attachment;
	}
	public void setAttachmentContentType(String a)
	{
		this.attachmentContentType = a;
	}
	public String getAttachmentContentType()
	{
		return this.attachmentContentType;
	}
	public void setAttachmentFileName(String a)
	{
		this.attachmentFileName = a;
	}
	public String getAttachmentFileName()
	{
		return this.attachmentFileName;
	}
	public void setSavepath(String s)
	{
		this.savepath = s;
	}
	public String getSavepath()
	{
		return this.savepath;
	}
	public void setAction(String a)
	{
		this.action = a;
	}
	public String getAction()
	{
		return this.action;
	}
	public void setSubmit(String s)
	{
		this.submit = s;
	}
	public String getSubmit()
	{
		return this.submit;
	}
	public void setBlogid(int[] b)
	{
		this.blogid = b;
	}
	public int[] getBlogid()
	{
		return this.blogid;
	}
                                                                                                                                           	
	public String execute() throws Exception
	{
		setTip(getTitle()+" "+getSortid()+" "+getContent()+" "+getIscomment()+" "+getAttachmentFileName()+" "+getAttachmentContentType());
		//�����ϴ��ļ�
		if(attachment!=null)
		{
			FileOutputStream fos = new FileOutputStream(getSavepath()+"\\"+getAttachmentFileName());
			FileInputStream fis = new FileInputStream(getAttachment());
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0)
			{
				fos.write(buffer, 0, len);
			}
			if(fos!=null)
				fos.close();
			if(fis!=null)
				fis.close();
		}
		//�����ϴ��ļ�����
		//������־�����
//		int[] sortss = {sortid};
		if (0 == rizhi.addRizhi(title, author, Calendar.getInstance(), description, content, sortid,iscomment,visible,stick,attachmentFileName))
		{
			return SUCCESS;
		}
		else
			return ERROR;
	}
	
	public String update() throws Exception
	{
		//�����ϴ��ļ�
		if(attachment!=null)
		{
			FileOutputStream fos = new FileOutputStream(getSavepath()+"\\"+getAttachmentFileName());
			FileInputStream fis = new FileInputStream(getAttachment());
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0)
			{
				fos.write(buffer, 0, len);
			}
			if(fos!=null)
				fos.close();
			if(fis!=null)
				fis.close();
		}
		//�����ϴ��ļ�����
		//������־�����
//		int[] sortss = {sortid};
		if (0 == rizhi.update(blogid[0],title, author, Calendar.getInstance(), description, content, sortid,iscomment,visible,stick,attachmentFileName))
		{
			return UPDATE_SUC;
		}
		else
			return ERROR;
	}
	public String delete() throws Exception
	{
		for(int i = 0;i<blogid.length;i++)
		{
			if (0 != rizhi.delete(blogid[i]))
				return ERROR;
		}
		return DELETE_SUC;
	}
}
package action;

import com.opensymphony.xwork2.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class admin_uploadimg implements Action
{
	private File attachment;  //����              //�ϴ����ļ�
	private String attachmentContentType;   //struts2��Ҫ��װ�ļ���������
	private String attachmentFileName;      //struts2��Ҫ��װ�ϴ��ļ�������,��ʽ��"�ֶ���+FileName",��ͬ
	private String savepath;               //��struts2.xml�ļ��������� ֵ
	private String name;
	private String submit;
	
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
	public void setName(String n)
	{
		this.name = n;
	}
	public String getName()
	{
		return this.name;
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
		setName("���ϴ��ļ�");
		return SUCCESS;
	}
	
	public String upload() throws Exception
	{
		if(attachment!=null)
		{
			String filename = getAttachmentFileName();
			int pos = filename.indexOf(".");
			filename = filename.substring(pos);     //��ȡ�ļ���ʽ
			String prefit = String.valueOf(Calendar.getInstance().getTimeInMillis());
			prefit = prefit.substring(6);     //��ȡ��ʱ������6λ��Ϊ�����
			filename = prefit+filename;    //���յ��ļ���
			FileOutputStream fos = new FileOutputStream(getSavepath()+"\\"+filename);
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
			String imgname = "imgx/"+filename.replace(".", "_");
			setName(imgname);
			return "upload";
		}
		else
		{
			setName("û���ļ�");
			
			return "nofile";
		}
		
	}
}
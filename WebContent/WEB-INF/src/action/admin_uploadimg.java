package action;

import com.opensymphony.xwork2.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class admin_uploadimg implements Action
{
	private File attachment;  //附件              //上传的文件
	private String attachmentContentType;   //struts2需要封装文件类型属性
	private String attachmentFileName;      //struts2需要封装上传文件名属性,格式是"字段名+FileName",上同
	private String savepath;               //在struts2.xml文件中配置其 值
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
		setName("请上传文件");
		return SUCCESS;
	}
	
	public String upload() throws Exception
	{
		if(attachment!=null)
		{
			String filename = getAttachmentFileName();
			int pos = filename.indexOf(".");
			filename = filename.substring(pos);     //获取文件格式
			String prefit = String.valueOf(Calendar.getInstance().getTimeInMillis());
			prefit = prefit.substring(6);     //获取以时间毫秒后6位最为随机数
			filename = prefit+filename;    //最终的文件名
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
			setName("没有文件");
			
			return "nofile";
		}
		
	}
}
package action;

import com.opensymphony.xwork2.Action;
import java.util.*;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class admin_comments implements Action
{
	private static final String LIST = "list";
	private static final String LIST_CONTENT = "list_content";
	private static final String EDIT = "edit";
	private static final String DELETE_SUC = "delete_success";
	
	private commensOperation comment;      //ÒÀÀµ×¢Èë
	private commensDao commentsdao;       //ÒÀÀµ×¢Èë
	private rizhiOperation rizhi;         //ÒÀÀµ×¢Èë
	private List<commens> comments;       
	private commens currentcomment;
	private rizhidata currentrizhi;
	private int blogid;
	private int commentid;
	private String content;
	private String back_content;
	private String author;
	private String ip;
	private String email;
	private String submit;
	
	public void setRizhi(rizhiOperation r)
	{
		this.rizhi = r;
	}
	public rizhiOperation getRizhi()
	{
		return this.rizhi; 
	}
	public void setComment(commensOperation c)
	{
		this.comment = c;
	}
	public commensOperation getComment()
	{
		return this.comment;
	}
	public void setComments(List<commens> c)
	{
		this.comments = c;
	}
	public List<commens> getComments()
	{
		return this.comments;
	}
	public void setCurrentcomment(commens c)
	{
		this.currentcomment = c;
	}
	public commens getCurrentcomment()
	{
		return this.currentcomment;
	}
	public void setBlogid(int b)
	{
		this.blogid = b;
	}
	public int getBlogid()
	{
		return this.blogid;
	}
	public void setCommentsdao(commensDao c)
	{
		this.commentsdao = c;
	}
	public commensDao getCommensdao()
	{
		return this.commentsdao;
	}
	public void setCommentid(int c)
	{
		this.commentid = c;
	}
	public int getCommentid()
	{
		return this.commentid;
	}
	public void setContent(String c)
	{
		this.content = c;
	}
	public String getContent()
	{
		return this.content;
	}
	public  void setBack_content(String b)
	{
		this.back_content = b;
	}
	public String getBack_content()
	{
		return this.back_content;
	}
	public void setAuthor(String a)
	{
		this.author = a;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public void setIp(String i)
	{
		this.ip = i;
	}
	public String getIp()
	{
		return this.ip;
	}
	public void setEmail(String e)
	{
		this.email = e;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setSubmit(String s)
	{
		this.submit = s;
	}
	public String getSubmit()
	{
		return this.submit;
	}
	public void setCurrentrizhi(rizhidata r)
	{
		this.currentrizhi = r;
	}
	public rizhidata getCurrentrizhi()
	{
		return this.currentrizhi;
	}
	
	
	public String execute() throws Exception
	{
		List<commens> tmplist = comment.findByRizhiid(blogid);
		setComments(tmplist);
		setCurrentrizhi(rizhi.getRizhi(blogid));
		return SUCCESS;
		
	}
	
	public String edit() throws Exception
	{
		commens c = commentsdao.get(commentid);
		setCurrentcomment(c);
		return EDIT;
	}
	//¸üÐÂÆÀÂÛ
	public String edit_content() throws Exception
	{
		if(0 == comment.updata(commentid, author, content, back_content))
		{
			List<commens> tmplist = comment.findByRizhiid(blogid);
			setComments(tmplist);
			return LIST_CONTENT;
		}
		else
			return ERROR;
	}
	//É¾³ýÆÀÂÛ
	public String delete() throws Exception
	{
		if(0 == comment.delete(commentid))
			return DELETE_SUC;
		else
			return ERROR;
	}
	
}
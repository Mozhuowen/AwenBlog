package action;

import com.opensymphony.xwork2.Action;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;


public class blog_index implements Action
{
	private static final String LIST = "list";
	private static final String SORT = "sort";
	private static final String SEARCH = "search";
	private static final String SHOW = "show";
	private static final String COMMENT = "comment";
	private static final String ABOUT  = "about";
	
	private rizhiOperation rizhi;         //����ע��
	private calendarOperation calendar;   //����ע��
	private sortsOperation sort;         //����ע��
	private commensOperation commen;     //����ע��
	private linksOperation link;         //����ע��
	private usersOperation user;         //����ע��
	private tongjiDao tongji;            //����ע��
	private List<String> calenderlist;     //������ʾÿ����������ַ���
	private String currentyear;           //��ǰ���
	private String currentmonth;          //��ǰ�·�
	private String premonth;              //ǰһ����
	private String nextmonth;              //�¸���
	private String currentyearmonthstr;     //�Ҳ�������ʾ�������ַ���
	private List<rizhidata> rizhiabstract;       //��־ժҪ��ʾ
	private long rizhicount;      //��־����
	private int pagesize;        //ÿҳ��ʾ����
	private int pagecount;      //��ҳ��
	private int page = 1;       //��ǰҳ��
	private List pages;        //����ǰ��jsp������ҳ����
	private int year = 0;      //��ѯָ��ʱ�����־��
	private int month = 0;     //��ѯָ��ʱ�����־��
	private int day = 0;       //��ѯָ��ʱ�����־��
	private List<sorts> sorts;   //���༯
	private int sortid = 0;      //ָ������ID
	private int currentsortid;   //��ǰ����
	private List<String> Archives;    //Archives�ַ�������
	private String search;        //�����ؼ���
	private int blogid = 0;      //��ǰ��־ID
	private rizhidata currentrizhi;     //��ǰ��־
	private LinkedList<commens> currentcommen;    //��ǰ���ۼ�
	private String author = null;           //��������
	private String email = null;            //������Email
	private String content = null;          //��������
	public String submit = null;
	public List<rizhidata> recentArticle;   //�����־
	public List<commens> recentComments;   //�������
	public List<links> links;        //����
	public users currentuser;        //��ǰ�û�����
	private long commentcount;      //����������
	private long todayvisit;       //���������
	private long allvisit;         //��ʷ������
	private long currentrizhicount;  //�������½���־������ʾ
	 
	public void setRizhi(rizhiOperation r)
	{
		this.rizhi = r;
	}
	public rizhiOperation getRizhi()
	{
		return this.rizhi;
	}
	public void setSort(sortsOperation s)
	{
		this.sort = s;
	}
	public sortsOperation getSort()
	{
		return this.sort;
	}
	public void setCalendar(calendarOperation c)
	{
		this.calendar = c;
	}
	public void setCalendarlist(List<String> c)
	{
		this.calenderlist = c;
	}
	public List<String> getCalendarlist()
	{
		return this.calenderlist;
	}
	public void setCurrentyear(String c)
	{
		this.currentyear = c;
	}
	public String getCurrentyear()
	{
		return this.currentyear;
	}
	public void setCurrentmonth(String c)
	{
		this.currentmonth = c;
	}
	public String getCurrentmonth()
	{
		return this.currentmonth;
	}
	public void setPremonth(String c)
	{
		this.premonth = c;
	}
	public String getPremonth()
	{
		return this.premonth;
	}
	public void setNextmonth(String c)
	{
		this.nextmonth = c;
	}
	public String getNextmonth()
	{
		return this.nextmonth;
	}
	public void setCurrentyearmonthstr(String c)
	{
		this.currentyearmonthstr = c;
	}
	public String getCurrentyearmonthstr()
	{
		return this.currentyearmonthstr;
	}
	public void setRizhiabstract(List<rizhidata> r)
	{
		this.rizhiabstract = r;
	}
	public List<rizhidata> getRizhiabstract()
	{
		return this.rizhiabstract;
	}
	public void setRizhicount(long r)
	{
		this.rizhicount = r;
	}
	public long getRizhicount()
	{
		return this.rizhicount;
	}
	public void setPagesize(int p)
	{
		this.pagesize = p;
	}
	public int getPagesize()
	{
		return this.pagesize;
	}
	public void setPagecount(int p)
	{
		this.pagecount = p;
	}
	public int getPagecount()
	{
		return this.pagecount;
	}
	public void setPage(int c)
	{
		this.page = c;
	}
	public int getPage()
	{
		return this.page;
	}
	public void setPages(List p)
	{
		this.pages = p;
	}
	public List getPages()
	{
		return this.pages;
	}
	public void setYear(int y)
	{
		this.year = y;
	}
	public int getYear()
	{
		return this.year;
	}
	public void setMonth(int m)
	{
		this.month = m;
	}
	public int getMonth()
	{
		return this.month;
	}
	public void setDay(int d)
	{
		this.day = d;
	}
	public int getDay()
	{
		return this.day;
	}
	public void setSorts(List<sorts> s)
	{
		this.sorts = s;
	}
	public List<sorts> getSorts()
	{
		return this.sorts;
	}
	public void setSortid(int s)
	{
		this.sortid = s;
	}
	public int getSortid()
	{
		return this.sortid;
	}
	public void setCurrentsortid(int s)
	{
		this.currentsortid = s;
	}
	public int getCurrentsortid()
	{
		return this.currentsortid;
	}
	public void setArchives(List<String> a)
	{
		this.Archives = a;
	}
	public List<String> getArchives()
	{
		return this.Archives;
	}
	public void setSearch(String s)
	{
		this.search = s;
	}
	public String getString()
	{
		return this.search;
	}
	public void setBlogid(int b)
	{
		this.blogid = b; 
	}
	public int getBlogid()
	{
		return this.blogid;
	}
	public void setCurrentrizhi(rizhidata r)
	{
		this.currentrizhi = r;
	}
	public rizhidata getCurrentrizhi()
	{
		return this.currentrizhi;
	}
	public void setCurrentcommen(LinkedList<commens> c)
	{
		this.currentcommen = c;
	}
	public LinkedList<commens> getCurrentcommen()
	{
		return this.currentcommen;
	}
	public void setAuthor(String a)
	{
		this.author = a;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public void setEmail(String e)
	{
		this.email = e;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setContent(String c)
	{
		this.content = c;
	}
	public String getContent()
	{
		return this.content;
	}
	public void setSubmit(String s)
	{
		this.submit = s;
	}
	public String getSubmit()
	{
		return this.submit;
	}
	public void setBlogid(String b)
	{
		this.blogid = Integer.parseInt(b);
	}
	public void setRecentArticle(List<rizhidata> r)
	{
		this.recentArticle = r;
	}
	public List<rizhidata> getRecentArticle()
	{
		return this.recentArticle;
	}
	public void setRecentComments(List<commens> c)
	{
		this.recentComments = c;
	}
	public List<commens> getRecentComments()
	{
		return this.recentComments;
	}
	public void setCommen(commensOperation c)
	{
		this.commen = c;
	}
	public commensOperation getCommen()
	{
		return this.commen;
	}
	public void setLinks(List<links> l)
	{
		this.links = l;
	}
	public List<links> getLinks()
	{
		return this.links;
	}
	public void setLink(linksOperation l)
	{
		this.link = l;
	}
	public linksOperation getLink()
	{
		return this.link;
	}
	public void setCurrentuser(users u)
	{
		this.currentuser = u;
	}
	public users getCurrentuser()
	{
		return this.currentuser;
	}
	public void setUser(usersOperation u)
	{
		this.user = u;
	}
	public usersOperation getUser()
	{
		return this.user;
	}
	public void setCommentcount(long c)
	{
		this.commentcount = c;
	}
	public long getCommentcount()
	{
		return this.commentcount;
	}
	public void setTodayvisit(long t)
	{
		this.todayvisit = t;
	}
	public long getTodayvisit()
	{
		return this.todayvisit;
	}
	public void setAllvisit(long a)
	{
		this.allvisit = a;
	}
	public long getAllvisit()
	{
		return this.allvisit;
	}
	public void setTongji(tongjiDao t)
	{
		this.tongji = t;
	}
	public tongjiDao getTongji()
	{
		return this.tongji;
	}
	public void setCurrentrizhicount(long c)
	{
		this.currentrizhicount = c;
	}
	public long getCurrentrizhicount()
	{
		return this.currentrizhicount;
	}
	
	public String execute() throws Exception
	{
		//��ʼ�Ҳ�calendarģ��
		calendar();
		//calendarģ�鴦�����
		//��ʼ��־ժҪ����ģ��
		rizhiabstract(page,year,month,day);
		//��־ժҪ����ģ�����
		//�׶�ҳ������
		button();
		//�׶�ҳ�����ݴ������	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//����ͳ��
		tongji();
//		System.out.println(sortstr.get(0));
		
		return SUCCESS;
	}
	//��ʾվ����Ϣ
	public String about() throws Exception
	{
		//��ʼ�Ҳ�calendarģ��
		calendar();
		//calendarģ�鴦�����
		//�����û���Ϣ
		setCurrentuser(user.finduser(603));
		//�׶�ҳ������
		button();
		//�׶�ҳ�����ݴ������	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//blog info
		tongji();
		setRizhicount(rizhi.getRizhinumber());
//		System.out.println(sortstr.get(0));
		
		return ABOUT;
	}
	//show��ʾ��־��ϸ����ģʽ
	public String show() throws Exception
	{
		if(blogid==0)
		{
			execute();
			return SUCCESS;
		}
		//addvisitime
		rizhi.visitimes(blogid);
		rizhidata tmprizhi = rizhi.getRizhi(blogid);
		//��ʼ�Ҳ�calendarģ��
		calendar();
		//calendarģ�鴦�����
		//��ʼ��־��ʾ����ģ��
		setCurrentrizhi(tmprizhi);
		//��־��ʾ����ģ�����
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//comments
		setCurrentcommen(commens(tmprizhi.getCommens()));
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		if(content!=null)
		{
//			System.out.println("enter commenMethor1");
			String ip = org.apache.struts2.ServletActionContext.getRequest().getRemoteAddr();
			if(commens(author,email,ip,Calendar.getInstance(),content))
				return COMMENT;
		}
		tongji();
		setRizhicount(rizhi.getRizhinumber());
		return SHOW;
	}
	//listģʽ
	public String list() throws Exception
	{
		//��ʼ�Ҳ�calendarģ��
		calendar();
		//calendarģ�鴦�����
		//��ʼ��־ժҪ����ģ��
		rizhiabstract(page,year,month,day);
		//��־ժҪ����ģ�����
		//�׶�ҳ������
		button();
		//�׶�ҳ�����ݴ������	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//blog info
		tongji();
		setRizhicount(rizhi.getRizhinumber());
		return LIST;
	}
	//��sorts��ʾ��־ժҪ
	public String sort() throws Exception
	{
		if(sortid==0)    //δ����sortid���������ģʽ
		{
			execute();
			return SUCCESS;
		}
		calendar();
		//������־����
		getSortrizhi(page,year,month,day);
		//�׶�ҳ������
		button();
		//�׶�ҳ�����ݴ������	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//blog info
		tongji();
		setRizhicount(rizhi.getRizhinumber());
		
		return SORT;
	}
	//����ģʽ
	public String search() throws Exception
	{
		if(search==null)
		{
			execute();
			return SUCCESS;
		}
		calendar();
		//��־����
		List<rizhidata> rizhilist = rizhi.searchTitle(search);
		setRizhicount(rizhilist.size());   //��־����
		setCurrentrizhicount(rizhilist.size());
		Collections.sort(rizhilist,new Comparator<rizhidata>(){  //������־
			public int compare(rizhidata r1,rizhidata r2)
			{
				if(r1.getTime().getTimeInMillis()<r2.getTime().getTimeInMillis())
					return 1;
				else if(r1.getTime().getTimeInMillis()>r2.getTime().getTimeInMillis())
					return -1;
				else
					return 0;
			}
		});
		int endpage = 0;
		if((page-1)*3+3>rizhilist.size())
			endpage = rizhilist.size();
		else
			endpage = (page-1)*3+3;		
		List<rizhidata> tmplist = rizhilist.subList((page-1)*3, endpage);
		setRizhiabstract(tmplist);
		//��־�������
		//�׶�ҳ������
		button();
		//�׶�ҳ�����ݴ������	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//blog info
		tongji();
		setRizhicount(rizhi.getRizhinumber());
		return SEARCH;
	}
	//������־����ģ��
	public void getSortrizhi(int page,int year,int month,int day) throws Exception
	{
		setCurrentsortid(sortid);
		sorts s = sort.getSortbyid(sortid);
		List<rizhidata> rizhilist = new ArrayList(s.getRizhidata());
		if(month!=0)   //�޳����������ڵ���־��
		{
			for (int i = 0;i<rizhilist.size();i++)
			{
				Calendar starttime = Calendar.getInstance();
				Calendar endtime = Calendar.getInstance();
				Calendar tmptime = Calendar.getInstance();
				tmptime.set(year,month,1);
				starttime.set(year, month, 1, 0, 0);
				int lastday = 0;
				while(tmptime.get(Calendar.MONTH)==month)
				{
					lastday = tmptime.get(Calendar.DAY_OF_MONTH);
					tmptime.add(Calendar.DAY_OF_MONTH, 1);
				}
				endtime.set(year, month, lastday, 24,0);
				//����ʼ����ʱ����������濪ʼ�޳����������ڵ���־
				if(rizhilist.get(i).getTime().getTimeInMillis()>endtime.getTimeInMillis() && rizhilist.get(i).getTime().getTimeInMillis()<starttime.getTimeInMillis())
					rizhilist.remove(i);
			}
		}
		Collections.sort(rizhilist,new Comparator<rizhidata>(){  //������־,�������ĵ���ǰ��
				public int compare(rizhidata r1,rizhidata r2)
				{
					if(r1.getTime().getTimeInMillis()<r2.getTime().getTimeInMillis())
						return 1;
					else if(r1.getTime().getTimeInMillis()>r2.getTime().getTimeInMillis())
						return -1;
					else
						return 0;
				}
		});
		int endpage = 0;
		if((page-1)*3+3>rizhilist.size())
			endpage = rizhilist.size();
		else
			endpage = (page-1)*3+3;		
		List<rizhidata> tmplist = rizhilist.subList((page-1)*3, endpage);
//		setRizhicount(tmplist.size());    //������־����
		setCurrentrizhicount(tmplist.size());
		setRizhiabstract(tmplist);
	}
	
	//�������ۼ�����ǰ���޷�ʵ�������д����ڸĽ��Ż�
	public LinkedList<commens> commens(Set<commens> cc)
	{
		LinkedList<commens> tmpcom = new LinkedList(cc);
		Collections.sort(tmpcom,new Comparator<commens>(){  //�������ۣ������۵���ǰ��
			public int compare(commens c1,commens c2)
			{
				return (int)(c1.getCommenid()-c2.getCommenid());
			}
	});
		return tmpcom;
	}
	//������־�ύ
	public boolean commens(String author,String email,String ip,Calendar time,String content)
	{
		if(0 == rizhi.addcomment(blogid, author, ip, email,time, content))
			return true;
		else
			return false;
	}

	//�Ҳ�calendarģ��
	public void calendar() throws Exception
	{
		if(month==0)
		{
			setCalendarlist(calendar.getIndexcalendar());
			setCurrentyearmonthstr(calendar.getCurrentyearmonthstr());
			setCurrentmonth(calendar.getCurrentmonth());
		}
		else
		{
			setCalendarlist(calendar.getIndexcalendar(year,month));
			setCurrentyearmonthstr(calendar.getCurrentyearmonthstr(year,month));
			setCurrentmonth(String.valueOf(month));
		}
		setCurrentyear(calendar.getCurrentyear());
		
		
	}
	//�����ַ�������
	//��־ժҪ����ģ��
	public void rizhiabstract(int page,int year,int month,int day) throws Exception
	{
		if(month == 0)     //���û���趨�κ����ڣ���ȡȫ����־
		{
			String sql = "from rizhidata r order by r.time desc";
			long tmplong = rizhi.getRizhinumber(sql);
			setRizhicount(tmplong);   //��־����
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, (page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
		else if (day == 0)     //ȡĳһ�µ���־��
		{
			month -=1;
			Calendar starttime = Calendar.getInstance();
			Calendar endtime = Calendar.getInstance();
			Calendar tmptime = Calendar.getInstance();
			tmptime.set(year,month,1);
			starttime.set(year, month, 1, 0, 0);
			int lastday = 0;
			while(tmptime.get(Calendar.MONTH)==month)
			{
				lastday = tmptime.get(Calendar.DAY_OF_MONTH);
				tmptime.add(Calendar.DAY_OF_MONTH, 1);
			}
			endtime.set(year, month, lastday, 24,0);
			String sql = "from rizhidata r where r.time>=:starttime and r.time<=:endtime order by r.time desc";
			String sql_count = "from rizhidata r where r.time>? and r.time<? order by r.time desc";
			long tmplong = rizhi.getRizhinumber(sql_count, starttime, endtime);
			setRizhicount(tmplong);   //��־����
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, starttime.getTimeInMillis(), endtime.getTimeInMillis(),(page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
		else     //ȡĳһ�����־��
		{
			month -=1;
			Calendar starttime = Calendar.getInstance();
			Calendar endtime = Calendar.getInstance();
			starttime.set(year, month, day, 0, 0);
			endtime.set(year, month, day, 24,0);
			String sql = "from rizhidata r where r.time>:starttime and r.time<:endtime order by r.time desc";
			String sql_count = "from rizhidata r where r.time>? and r.time<? order by r.time desc";
			long tmplong = rizhi.getRizhinumber(sql_count, starttime, endtime);
			setRizhicount(tmplong);   //��־����
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, starttime.getTimeInMillis(), endtime.getTimeInMillis(),(page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
	}
	//��ȡ�����־����ʱ����Ϊ10ƪ
	public void recentArticle() throws Exception
	{
		String sql = "from rizhidata r order by r.time desc";
		List<rizhidata> rizhilist = rizhi.findByPage(sql, 0, 10);
		setRecentArticle(rizhilist);
	}
	//��ȡ������ۣ���ʱ����Ϊ10,��־��������ҳ����������
	public void recentComments() throws Exception
	{
		String sql = "from commens c order by c.time desc";
		List<commens> commenlist = commen.findByPage(sql, 0, 10);
		setRecentComments(commenlist);
		setCommentcount(commen.getcommensNumber());
	}
	public void tongji() throws Exception
	{
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH);  //ע���·ݴ��㿪ʼ������Ͳ���1��
		int day = now.get(Calendar.DAY_OF_MONTH);
		Calendar starttime = Calendar.getInstance();
		Calendar endtime = Calendar.getInstance();
		starttime.set(year, month, day, 0, 0);
		endtime.set(year, month, day, 24, 0);
		setTodayvisit(tongji.getCountbytime(starttime,endtime));
		setAllvisit(tongji.getCount());
	}
	//�׶�ҳ�봦��
	//�׶�ҳ������ģ��
	public void button() throws Exception
	{
		long rizhic = currentrizhicount;
		setPagesize(10);       //��ʾ����
		int pagec = (int)rizhic/10;
		if (rizhic%10 != 0)
			pagec +=1;
		setPagecount(pagec);    //��ҳ��
		if(page==0)
			setPage(1);    //��ǰҳ��
		else
			setPage(page);
		List tmplist = new ArrayList();
		for(int i = 1;i<=pagec;i++)
			tmplist.add(i);
		setPages(tmplist);   //Ϊ����jsp����
	}
	//����Archives�ַ���ģ��
	public List<String> getArchivesStr() throws Exception
	{
		Calendar starttime = Calendar.getInstance();
		starttime.set(2013, 6, 1, 0, 0);  //2013.7.1Ϊ��ʼʱ��
		Calendar now = Calendar.getInstance();
		List<String> tmplist = new ArrayList();
		while (starttime.get(Calendar.MONTH)<=now.get(Calendar.MONTH))
		{
			String str = calendar.getCurrentyearmonthstr(starttime.get(Calendar.YEAR), starttime.get(Calendar.MONTH), "reverse");
			tmplist.add(str);
			starttime.add(Calendar.MONTH, 1);
		}
		return tmplist;
	}
}
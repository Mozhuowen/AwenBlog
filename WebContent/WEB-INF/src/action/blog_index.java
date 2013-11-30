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
	
	private rizhiOperation rizhi;         //依赖注入
	private calendarOperation calendar;   //依赖注入
	private sortsOperation sort;         //依赖注入
	private commensOperation commen;     //依赖注入
	private linksOperation link;         //依赖注入
	private usersOperation user;         //依赖注入
	private tongjiDao tongji;            //依赖注入
	private List<String> calenderlist;     //用于显示每行日历表的字符集
	private String currentyear;           //当前年份
	private String currentmonth;          //当前月份
	private String premonth;              //前一个月
	private String nextmonth;              //下个月
	private String currentyearmonthstr;     //右侧日历显示的年月字符串
	private List<rizhidata> rizhiabstract;       //日志摘要显示
	private long rizhicount;      //日志总数
	private int pagesize;        //每页显示数量
	private int pagecount;      //总页数
	private int page = 1;       //当前页数
	private List pages;        //方便前段jsp迭代的页数集
	private int year = 0;      //查询指定时间的日志集
	private int month = 0;     //查询指定时间的日志集
	private int day = 0;       //查询指定时间的日志集
	private List<sorts> sorts;   //分类集
	private int sortid = 0;      //指定分类ID
	private int currentsortid;   //当前分类
	private List<String> Archives;    //Archives字符串容器
	private String search;        //搜索关键字
	private int blogid = 0;      //当前日志ID
	private rizhidata currentrizhi;     //当前日志
	private LinkedList<commens> currentcommen;    //当前评论集
	private String author = null;           //评论作者
	private String email = null;            //评论者Email
	private String content = null;          //评论内容
	public String submit = null;
	public List<rizhidata> recentArticle;   //最近日志
	public List<commens> recentComments;   //最近评论
	public List<links> links;        //链接
	public users currentuser;        //当前用户对象
	private long commentcount;      //共有评论数
	private long todayvisit;       //几天访问数
	private long allvisit;         //历史访问数
	private long currentrizhicount;  //用于右下角日志总数显示
	 
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
		//开始右侧calendar模块
		calendar();
		//calendar模块处理结束
		//开始日志摘要处理模块
		rizhiabstract(page,year,month,day);
		//日志摘要处理模块结束
		//底端页码数据
		button();
		//底端页码数据处理结束	
		setSorts(sort.getAllsorts());
		//Archives
		setArchives(getArchivesStr());
		//RecentArticle
		recentArticle();
		//RecentComments
		recentComments();
		//All Links
		setLinks(link.getAlllinks());
		//访问统计
		tongji();
//		System.out.println(sortstr.get(0));
		
		return SUCCESS;
	}
	//显示站长信息
	public String about() throws Exception
	{
		//开始右侧calendar模块
		calendar();
		//calendar模块处理结束
		//设置用户信息
		setCurrentuser(user.finduser(603));
		//底端页码数据
		button();
		//底端页码数据处理结束	
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
	//show显示日志详细内容模式
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
		//开始右侧calendar模块
		calendar();
		//calendar模块处理结束
		//开始日志显示处理模块
		setCurrentrizhi(tmprizhi);
		//日志显示处理模块结束
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
	//list模式
	public String list() throws Exception
	{
		//开始右侧calendar模块
		calendar();
		//calendar模块处理结束
		//开始日志摘要处理模块
		rizhiabstract(page,year,month,day);
		//日志摘要处理模块结束
		//底端页码数据
		button();
		//底端页码数据处理结束	
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
	//按sorts显示日志摘要
	public String sort() throws Exception
	{
		if(sortid==0)    //未定义sortid则调用正常模式
		{
			execute();
			return SUCCESS;
		}
		calendar();
		//分类日志处理
		getSortrizhi(page,year,month,day);
		//底端页码数据
		button();
		//底端页码数据处理结束	
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
	//搜索模式
	public String search() throws Exception
	{
		if(search==null)
		{
			execute();
			return SUCCESS;
		}
		calendar();
		//日志处理
		List<rizhidata> rizhilist = rizhi.searchTitle(search);
		setRizhicount(rizhilist.size());   //日志总数
		setCurrentrizhicount(rizhilist.size());
		Collections.sort(rizhilist,new Comparator<rizhidata>(){  //排序日志
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
		//日志处理结束
		//底端页码数据
		button();
		//底端页码数据处理结束	
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
	//分类日志处理模块
	public void getSortrizhi(int page,int year,int month,int day) throws Exception
	{
		setCurrentsortid(sortid);
		sorts s = sort.getSortbyid(sortid);
		List<rizhidata> rizhilist = new ArrayList(s.getRizhidata());
		if(month!=0)   //剔除不符合日期的日志集
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
				//处理开始结束时间结束，下面开始剔除不符合日期的日志
				if(rizhilist.get(i).getTime().getTimeInMillis()>endtime.getTimeInMillis() && rizhilist.get(i).getTime().getTimeInMillis()<starttime.getTimeInMillis())
					rizhilist.remove(i);
			}
		}
		Collections.sort(rizhilist,new Comparator<rizhidata>(){  //排序日志,最近发表的的排前面
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
//		setRizhicount(tmplist.size());    //处理日志总数
		setCurrentrizhicount(tmplist.size());
		setRizhiabstract(tmplist);
	}
	
	//处理评论集排序，前端无法实现排序，有待后期改进优化
	public LinkedList<commens> commens(Set<commens> cc)
	{
		LinkedList<commens> tmpcom = new LinkedList(cc);
		Collections.sort(tmpcom,new Comparator<commens>(){  //排序评论，先评论的排前面
			public int compare(commens c1,commens c2)
			{
				return (int)(c1.getCommenid()-c2.getCommenid());
			}
	});
		return tmpcom;
	}
	//处理日志提交
	public boolean commens(String author,String email,String ip,Calendar time,String content)
	{
		if(0 == rizhi.addcomment(blogid, author, ip, email,time, content))
			return true;
		else
			return false;
	}

	//右侧calendar模块
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
	//分类字符集处理
	//日志摘要处理模块
	public void rizhiabstract(int page,int year,int month,int day) throws Exception
	{
		if(month == 0)     //如果没有设定任何日期，提取全部日志
		{
			String sql = "from rizhidata r order by r.time desc";
			long tmplong = rizhi.getRizhinumber(sql);
			setRizhicount(tmplong);   //日志总数
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, (page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
		else if (day == 0)     //取某一月的日志集
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
			setRizhicount(tmplong);   //日志总数
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, starttime.getTimeInMillis(), endtime.getTimeInMillis(),(page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
		else     //取某一天的日志集
		{
			month -=1;
			Calendar starttime = Calendar.getInstance();
			Calendar endtime = Calendar.getInstance();
			starttime.set(year, month, day, 0, 0);
			endtime.set(year, month, day, 24,0);
			String sql = "from rizhidata r where r.time>:starttime and r.time<:endtime order by r.time desc";
			String sql_count = "from rizhidata r where r.time>? and r.time<? order by r.time desc";
			long tmplong = rizhi.getRizhinumber(sql_count, starttime, endtime);
			setRizhicount(tmplong);   //日志总数
			setCurrentrizhicount(tmplong);
			List<rizhidata> rizhilist = rizhi.findByPage(sql, starttime.getTimeInMillis(), endtime.getTimeInMillis(),(page-1)*10, 10);
			setRizhiabstract(rizhilist);
		}
	}
	//获取最近日志，暂时设置为10篇
	public void recentArticle() throws Exception
	{
		String sql = "from rizhidata r order by r.time desc";
		List<rizhidata> rizhilist = rizhi.findByPage(sql, 0, 10);
		setRecentArticle(rizhilist);
	}
	//获取最近评论，暂时设置为10,日志总数设置页放在这里面
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
		int month = now.get(Calendar.MONTH);  //注意月份从零开始，这里就不加1了
		int day = now.get(Calendar.DAY_OF_MONTH);
		Calendar starttime = Calendar.getInstance();
		Calendar endtime = Calendar.getInstance();
		starttime.set(year, month, day, 0, 0);
		endtime.set(year, month, day, 24, 0);
		setTodayvisit(tongji.getCountbytime(starttime,endtime));
		setAllvisit(tongji.getCount());
	}
	//底端页码处理
	//底端页码数据模块
	public void button() throws Exception
	{
		long rizhic = currentrizhicount;
		setPagesize(10);       //显示数量
		int pagec = (int)rizhic/10;
		if (rizhic%10 != 0)
			pagec +=1;
		setPagecount(pagec);    //总页数
		if(page==0)
			setPage(1);    //当前页数
		else
			setPage(page);
		List tmplist = new ArrayList();
		for(int i = 1;i<=pagec;i++)
			tmplist.add(i);
		setPages(tmplist);   //为方便jsp迭代
	}
	//处理Archives字符串模块
	public List<String> getArchivesStr() throws Exception
	{
		Calendar starttime = Calendar.getInstance();
		starttime.set(2013, 6, 1, 0, 0);  //2013.7.1为开始时间
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
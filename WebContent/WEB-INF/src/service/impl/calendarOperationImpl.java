package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class calendarOperationImpl implements calendarOperation
{
	private rizhidataDao rizhidao;     //依赖注入DAO组件
	
	public void setRizhidao(rizhidataDao rizhi)
	{
		this.rizhidao = rizhi;
	}
	
	public List<String> getIndexcalendar()   //获取当月日历
	{
		Calendar rightnow = Calendar.getInstance();
		Calendar lastdayOfmonth = null;
		int year = rightnow.get(Calendar.YEAR);
		int month = rightnow.get(Calendar.MONTH);
		List<String> datelist = new ArrayList<String>();
		List<String> tmplist = new ArrayList<String>();
		Map<String,String> rmap = new HashMap<String ,String>();
		//rmap为日志的时间组成的时间集
		List<Calendar> r = rizhidao.findByMonth("gettime",year, month);
		//System.out.println("r sql size():"+r.size());
		for (int i = 0;i<r.size();i++)
		{
			String day = String.valueOf(r.get(i).get(Calendar.DAY_OF_MONTH));
			rmap.put(day, day);
			
		}
		//System.out.println("rmap size:"+rmap.size());
		
		rightnow.set(year,month,1,0,0);    //设置为每月开始第一天，以便于遍历
		while (rightnow.get(Calendar.MONTH) == month)    //获取当月的每一天,遍历开始
		{
			int firstday = rightnow.get(Calendar.DAY_OF_MONTH);
			String currentday = String.valueOf(firstday);
			if(rmap.containsKey(currentday))     //判断处理该天是否有日志
			{
				currentday  = "<a href=?year="+year+"&month="+(month+1)+"&day="+currentday+"><b>"+currentday+"</b></a>";
			}
			if(firstday == 1)      //如果是第一天，判断前面是否有空白
			{
				int week = rightnow.get(Calendar.DAY_OF_WEEK);
				if (week!=1)    //填充月初空白
				{
					for (int i = 1;i<week ;i++ )
					{
						tmplist.add("x");
					}
					tmplist.add(currentday);
				}
				else
					tmplist.add(currentday);
			}
			else
				tmplist.add(currentday);

			lastdayOfmonth = rightnow;
			rightnow.add(Calendar.DATE,1);
		}   

		int weekx = lastdayOfmonth.get(Calendar.DAY_OF_WEEK);   //获取最后一天
		if(weekx!=7)     //填充月末空白
		{
			for(int i = 0;i<=7-weekx;i++)
			{
				tmplist.add("x");
			}
		}

		//按每星期填充list
		for (int i = 0;i<tmplist.size();i+=7)
		{
			int j=0;
			String currentStr = "<tr>";        //每行
			for (;j<7 ;j++ )         
			{
				if((i+j)<tmplist.size())     //处理每列
				{
					String tmpstr = null;
					if(tmplist.get(i+j).equals("x"))
						tmpstr = "<td class='cal_day1'>"+tmplist.get(i+j)+"</td>";
					else
						tmpstr = "<td class='cal_day3'>"+tmplist.get(i+j)+"</td>";
					currentStr += tmpstr;

				}

			}
			currentStr +="</tr>";
			datelist.add(currentStr);       //每行填入list
		}
		
		return datelist;
	}
	
	//获取指定月份日历，有一定的代码复用，后期要优化
	public List<String> getIndexcalendar(int year,int month)
	{
		month -=1;    //Calendar中的MONTH从0开始
		Calendar rightnow = Calendar.getInstance();
		Calendar lastdayOfmonth = null;
//		int year = rightnow.get(Calendar.YEAR);
//		int month = rightnow.get(Calendar.MONTH);
		List<String> datelist = new ArrayList<String>();
		List<String> tmplist = new ArrayList<String>();
		Map<String,String> rmap = new HashMap<String ,String>();
		//rmap为日志的时间组成的时间集
		List<Calendar> r = rizhidao.findByMonth("gettime",year, month);
		System.out.println("r sql size():"+r.size());
		for (int i = 0;i<r.size();i++)
		{
			String day = String.valueOf(r.get(i).get(Calendar.DAY_OF_MONTH));
			rmap.put(day, day);
			
		}
		System.out.println("rmap size:"+rmap.size());
		
		rightnow.set(year,month,1,0,0);    //设置为每月开始第一天，以便于遍历
		while (rightnow.get(Calendar.MONTH) == month)    //获取当月的每一天,遍历开始
		{
			int firstday = rightnow.get(Calendar.DAY_OF_MONTH);
			String currentday = String.valueOf(firstday);
			if(rmap.containsKey(currentday))     //判断处理该天是否有日志
			{
				currentday  = "<a href=?year="+year+"&month="+(month+1)+"&day="+currentday+"><b>"+currentday+"</b></a>";
			}
			if(firstday == 1)      //如果是第一天，判断前面是否有空白
			{
				int week = rightnow.get(Calendar.DAY_OF_WEEK);
				if (week!=1)    //填充月初空白
				{
					for (int i = 1;i<week ;i++ )
					{
						tmplist.add("x");
					}
					tmplist.add(currentday);
				}
				else
					tmplist.add(currentday);
			}
			else
				tmplist.add(currentday);

			lastdayOfmonth = rightnow;
			rightnow.add(Calendar.DATE,1);
		}   

		int weekx = lastdayOfmonth.get(Calendar.DAY_OF_WEEK);   //获取最后一天
		if(weekx!=7)     //填充月末空白
		{
			for(int i = 0;i<=7-weekx;i++)
			{
				tmplist.add("x");
			}
		}

		//按每星期填充list
		for (int i = 0;i<tmplist.size();i+=7)
		{
			int j=0;
			String currentStr = "<tr>";        //每行
			for (;j<7 ;j++ )         
			{
				if((i+j)<tmplist.size())     //处理每列
				{
					String tmpstr = null;
					if(tmplist.get(i+j).equals("x"))
						tmpstr = "<td class='cal_day1'>"+tmplist.get(i+j)+"</td>";
					else
						tmpstr = "<td class='cal_day3'>"+tmplist.get(i+j)+"</td>";
					currentStr += tmpstr;

				}

			}
			currentStr +="</tr>";
			datelist.add(currentStr);       //每行填入list
		}
		
		return datelist;
	}
	
	public String getCurrentyear()
	{
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.YEAR));
	}
	
	public String getCurrentmonth()
	{
		Calendar c = Calendar.getInstance();
		return String.valueOf(c.get(Calendar.MONTH)+1);
	}
	
	
	public String getCurrentyearmonthstr()
	{
		String year = getCurrentyear();
		int month = Integer.parseInt(getCurrentmonth())-1;
		String[] monthStr = {"January","February","March","April","May","June","July","August","September","October"
				,"November","December"};
		return year+" "+monthStr[month];
	}
	
	public String getCurrentyearmonthstr(int year,int month)
	{
		month -=1;
		String[] monthStr = {"January","February","March","April","May","June","July","August","September","October"
				,"November","December"};
		return year+" "+monthStr[month];
	}
	public String getCurrentyearmonthstr(int year,int month,String reverse)
	{
	//	System.out.println(month);
	//	month -=1;
		String[] monthStr = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		return monthStr[month]+" "+year;
	}
}
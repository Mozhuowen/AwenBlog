package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class calendarOperationImpl implements calendarOperation
{
	private rizhidataDao rizhidao;     //����ע��DAO���
	
	public void setRizhidao(rizhidataDao rizhi)
	{
		this.rizhidao = rizhi;
	}
	
	public List<String> getIndexcalendar()   //��ȡ��������
	{
		Calendar rightnow = Calendar.getInstance();
		Calendar lastdayOfmonth = null;
		int year = rightnow.get(Calendar.YEAR);
		int month = rightnow.get(Calendar.MONTH);
		List<String> datelist = new ArrayList<String>();
		List<String> tmplist = new ArrayList<String>();
		Map<String,String> rmap = new HashMap<String ,String>();
		//rmapΪ��־��ʱ����ɵ�ʱ�伯
		List<Calendar> r = rizhidao.findByMonth("gettime",year, month);
		//System.out.println("r sql size():"+r.size());
		for (int i = 0;i<r.size();i++)
		{
			String day = String.valueOf(r.get(i).get(Calendar.DAY_OF_MONTH));
			rmap.put(day, day);
			
		}
		//System.out.println("rmap size:"+rmap.size());
		
		rightnow.set(year,month,1,0,0);    //����Ϊÿ�¿�ʼ��һ�죬�Ա��ڱ���
		while (rightnow.get(Calendar.MONTH) == month)    //��ȡ���µ�ÿһ��,������ʼ
		{
			int firstday = rightnow.get(Calendar.DAY_OF_MONTH);
			String currentday = String.valueOf(firstday);
			if(rmap.containsKey(currentday))     //�жϴ�������Ƿ�����־
			{
				currentday  = "<a href=?year="+year+"&month="+(month+1)+"&day="+currentday+"><b>"+currentday+"</b></a>";
			}
			if(firstday == 1)      //����ǵ�һ�죬�ж�ǰ���Ƿ��пհ�
			{
				int week = rightnow.get(Calendar.DAY_OF_WEEK);
				if (week!=1)    //����³��հ�
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

		int weekx = lastdayOfmonth.get(Calendar.DAY_OF_WEEK);   //��ȡ���һ��
		if(weekx!=7)     //�����ĩ�հ�
		{
			for(int i = 0;i<=7-weekx;i++)
			{
				tmplist.add("x");
			}
		}

		//��ÿ�������list
		for (int i = 0;i<tmplist.size();i+=7)
		{
			int j=0;
			String currentStr = "<tr>";        //ÿ��
			for (;j<7 ;j++ )         
			{
				if((i+j)<tmplist.size())     //����ÿ��
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
			datelist.add(currentStr);       //ÿ������list
		}
		
		return datelist;
	}
	
	//��ȡָ���·���������һ���Ĵ��븴�ã�����Ҫ�Ż�
	public List<String> getIndexcalendar(int year,int month)
	{
		month -=1;    //Calendar�е�MONTH��0��ʼ
		Calendar rightnow = Calendar.getInstance();
		Calendar lastdayOfmonth = null;
//		int year = rightnow.get(Calendar.YEAR);
//		int month = rightnow.get(Calendar.MONTH);
		List<String> datelist = new ArrayList<String>();
		List<String> tmplist = new ArrayList<String>();
		Map<String,String> rmap = new HashMap<String ,String>();
		//rmapΪ��־��ʱ����ɵ�ʱ�伯
		List<Calendar> r = rizhidao.findByMonth("gettime",year, month);
		System.out.println("r sql size():"+r.size());
		for (int i = 0;i<r.size();i++)
		{
			String day = String.valueOf(r.get(i).get(Calendar.DAY_OF_MONTH));
			rmap.put(day, day);
			
		}
		System.out.println("rmap size:"+rmap.size());
		
		rightnow.set(year,month,1,0,0);    //����Ϊÿ�¿�ʼ��һ�죬�Ա��ڱ���
		while (rightnow.get(Calendar.MONTH) == month)    //��ȡ���µ�ÿһ��,������ʼ
		{
			int firstday = rightnow.get(Calendar.DAY_OF_MONTH);
			String currentday = String.valueOf(firstday);
			if(rmap.containsKey(currentday))     //�жϴ�������Ƿ�����־
			{
				currentday  = "<a href=?year="+year+"&month="+(month+1)+"&day="+currentday+"><b>"+currentday+"</b></a>";
			}
			if(firstday == 1)      //����ǵ�һ�죬�ж�ǰ���Ƿ��пհ�
			{
				int week = rightnow.get(Calendar.DAY_OF_WEEK);
				if (week!=1)    //����³��հ�
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

		int weekx = lastdayOfmonth.get(Calendar.DAY_OF_WEEK);   //��ȡ���һ��
		if(weekx!=7)     //�����ĩ�հ�
		{
			for(int i = 0;i<=7-weekx;i++)
			{
				tmplist.add("x");
			}
		}

		//��ÿ�������list
		for (int i = 0;i<tmplist.size();i+=7)
		{
			int j=0;
			String currentStr = "<tr>";        //ÿ��
			for (;j<7 ;j++ )         
			{
				if((i+j)<tmplist.size())     //����ÿ��
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
			datelist.add(currentStr);       //ÿ������list
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
package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface calendarOperation
{
	public static final int ADD_SUC = 0;
	
	
	List<String> getIndexcalendar();              //获取当月日历
	
	List<String> getIndexcalendar(int year,int month);   //获取指定月份日历
	
	String getCurrentyearmonthstr();
	
	String getCurrentyearmonthstr(int year,int month);
	
	String getCurrentyear();
	
	String getCurrentmonth();
	
	String getCurrentyearmonthstr(int year,int month,String reverse);
	
}
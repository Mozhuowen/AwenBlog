package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface sortsOperation
{
	public static final int ADD_SUC = 0;
	public static final int ADD_FAIL = 1;
	public static final int UPDATE_SUC = 0;
	public static final int UPDATE_FAIL = 1;
	public static final int DELETE_SUC = 0;
	public static final int DELETE_FAIL = 1;
	public static final int SEARCH_SUC = 0;
	public static final int SEATCH_FAIL = 1;
	
	int addSort(String name);
	
	int update(int userId,String name);
	
	int update(int userId,String name,Set<rizhidata> rizhilist);
	
	int update(int userId,String name,String[] rizhiTitle);
	
	int update(int userId,String name,int [] rizhiId);
	
	int delete(int userId);
	
	int addSort(String name,Set<rizhidata> rizhilist);
	
	int addSort(String name,String[] rizhiTitle);
	 
	int addSort(String name,int[] rizhiId);
	
	List<sorts> getAllsorts();
	
	List<String> getAllsortnames();
	
	sorts getSortbyid(int sortid);
}
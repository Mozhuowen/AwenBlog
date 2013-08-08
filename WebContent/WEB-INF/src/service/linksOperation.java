package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface linksOperation
{
	public static final int ADD_SUC = 0;
	public static final int ADD_FAIL = 1;
	public static final int UPDATE_SUC = 0;
	public static final int UPDATE_FAIL = 1;
	public static final int DELETE_SUC = 0;
	public static final int DELETE_FAIL = 1;
	
	int addLinks(String sitename,String url,String description,int visible);
	
	int update(int linkid,String sitename,String url,String description,int visible);
	
	int delete(int linkid);
	
	List<links> getAlllinks();
}
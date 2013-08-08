package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface usersOperation
{
	public static final int ADD_SUC = 0;
	public static final int ADD_FAIL = 1;
	public static final int UPDATE_SUC = 0;
	public static final int UPDATE_FAIL = 1;
	public static final int DELETE_SUC = 0;
	public static final int DELETE_FAIL = 1;
	public static final int SEARCH_SUC = 0;
	public static final int SEATCH_FAIL = 1;
	
	int addUser(String name,String pass,int privilege);
	
	int updata(int userId,String name,String pass,int privilege);
	
	int updateabout(int userId,String petname,String sex,String qq,String email,String homepage,String birth_year,String hobby,String profession,String description);
	
	int delete(int userId);
	
	users finduser(int privilege);
	
	List<users> searchByName(String name);
	
	List<users> getAllusers();
}
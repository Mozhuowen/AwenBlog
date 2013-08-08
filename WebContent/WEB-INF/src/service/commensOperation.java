package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface commensOperation
{
	public static final int ADD_SUC = 0;
	public static final int ADD_FAIL = 1;
	public static final int UPDATE_SUC = 0;
	public static final int UPDATE_FAIL = 1;
	public static final int DELETE_SUC = 0;
	public static final int DELETE_FAIL = 1;
	public static final int SEARCH_SUC = 0;
	public static final int SEATCH_FAIL = 1;
	
	int addCommen(String author,String content,String back_content);
	
	int addCommen(String author,String email,String ip,String content);
	
	int updata(int commenId,String author,String content,String back_content);
	
	int delete(int commenId);
	
	long getcommensNumber();
	
	List<commens> searchByKeyword(String keyword);
	
	List<commens> searchByAuthor(String author);
	
	List<commens> getAllcommens();
	
	List<commens> findByRizhiid(int id);
	
	List findByPage(final String hql, final int offset, final int pageSize);
}
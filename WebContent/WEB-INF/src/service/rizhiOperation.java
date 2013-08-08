package service;

import dao.*;
import dao.impl.*;
import domain.*;
import java.util.*;

public interface rizhiOperation
{
	public static final int ADD_SUC = 0;
	public static final int ADD_FAIL = 1;
	public static final int UPDATE_SUC = 0;
	public static final int UPDATE_FAIL = 1;
	public static final int DELETE_SUC = 0;
	public static final int DELETE_FAIL = 1;
	public static final int SEARCH_SUC = 0;
	public static final int SEATCH_FAIL = 1;
	
	int addRizhi(String title,String author,Calendar time,String precontent,String content,String[] sorts);
	
	int addRizhi(String title,String author,Calendar time,String precontent,String content,int[] sortsid);
	
	int addRizhi(String title,String author,Calendar time,String precontent,String content,int[] sortsid,int iscomment,int visible,int stick,String filename);
	
	int update(int rizhiId,String title,String author,Calendar time,String precontent,String content,String[] sorts);
	
	int update(int rizhiId,String title,String author,Calendar time,String precontent,String content,int[] sortsid,int iscomment,int visible,int stick,String filename);
	
	int delete(int rizhiId);
	
	int addcomment(int rizhiId,String author,String ip,String email,Calendar time,String content);
	
	long getRizhinumber();
	
	long getRizhinumber(String sql);
	
	long getRizhinumber(String sql,Calendar starttime,Calendar endtime);
	
	List<rizhidata> searchContent(String keyword);
	
	List<rizhidata> searchTitle(String title);
	
	List<rizhidata> getAllrizhi();
	
	rizhidata getRizhi(int id);
	
	List findByPage(final String hql, 
			final int offset, final int pageSize);
	
	List findByPage(final String hql , final Object value ,
			final int offset, final int pageSize);
	
	List findByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);
	
	List findByPage(final String hql , final long starttime,final long endtime,
			final int offset, final int pageSize);
	
	void visitimes(int id);
}
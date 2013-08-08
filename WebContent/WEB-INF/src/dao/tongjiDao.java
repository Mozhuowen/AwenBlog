package dao;

import java.util.*;

import domain.*;

public interface tongjiDao 
{
	
	tongji get(Integer id);
	 
	Integer save(tongji tj);
	
	long getCountbytime(Calendar time,Calendar endtime);
	
	long getCount();
	
	List<tongji> findbytime(Calendar time);
	
	List<tongji> findbyip(String ip);
	
	List<tongji> findbyurl(String url);
	
	List findByPage(final String hql, final int offset, final int pageSize);
}
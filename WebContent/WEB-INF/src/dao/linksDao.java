package dao;

import java.util.*;

import domain.*;

public interface linksDao 
{
	
	links get(Integer id);
	 
	Integer save(links link);
	 
	void update(links link);
	
	void delete(Integer id);
	
	void delete(links link);

	public List<links> findAlllinks();

	long getlinksNumber();

}
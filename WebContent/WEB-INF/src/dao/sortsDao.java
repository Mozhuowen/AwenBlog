package dao;

import java.util.*;

import domain.*;

public interface sortsDao 
{
	
	sorts get(Integer id);
	 
	Integer save(sorts sort);
	 
	void update(sorts sort);
	
	void delete(Integer id);
	
	void delete(sorts sort);

	List<sorts> findByName(String name);
	
	List<String> findAllsortnames();

	public List<sorts> findAllsorts();

	long getsortsNumber();

	public List<sorts> searchByName(String name);
}
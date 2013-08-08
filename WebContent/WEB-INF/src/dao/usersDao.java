package dao;

import java.util.*;

import domain.*;

public interface usersDao 
{
	
	users get(Integer id);
	 
	Integer save(users user);
	 
	void update(users user);
	
	void delete(Integer id);
	
	void delete(users user);

	List<users> findByName(String name);

	public List<users> findAllusers();
	
	users findByprivilege(int privilege);

	long getusersNumber();

	public List<users> searchByName(String name);

}
package dao;

import java.util.*;

import domain.*;

public interface commensDao 
{
	
	commens get(Integer id);
	 
	Integer save(commens commen);
	 
	void update(commens commen);
	
	void delete(Integer id);
	
	void delete(commens commen);

	List<commens> findByAuthor(String author);
	
	List<commens> findByRizhiid(int id);

	public List<commens> findAllcommens();

	long getcommensNumber();

	public List<commens> searchByAuthor(String author);
	public List<commens> searchBycontent(String content);
	public List<commens> searchByback_content(String back_content);
	
	List findByPage(final String hql, final int offset, final int pageSize);
}
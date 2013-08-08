package dao;

import java.util.*;

import domain.*;

public interface rizhidataDao 
{
	/**
	 * 加载Person实例
	 * @param id 需要加载的Person实例的主键值
	 * @return 返回加载的Person实例
	 */ 
	rizhidata get(Integer id);
	 
	/**
	 * 保存Person实例
	 * @param person 需要保存的Person实例
	 * @return 刚刚保存的Person实例的标识属性值
	 */	
	Integer save(rizhidata rizhi);
	 
	/**
	 * 修改Person实例
	 * @param person 需要修改的Person实例
	 */
	void update(rizhidata rizhi);
	
	/**
	 * 删除Person实例
	 * @param id 需要删除的Person实例的标识属性值
	 */
	void delete(Integer id);
	
	/**
	 * 删除Person实例
	 * @param person 需要删除的Person实例
	 */
	void delete(rizhidata rizhi);
	
	/**
	 * 根据用户名查找Person
	 * @param name 查询的人名
	 * @return 指定用户名对应的全部Person
	 */
	List<rizhidata> findByTitle(String title);
	
	List<rizhidata> findByMonth(int year,int month);
	
	List<Calendar> findByMonth(String gettime,int year,int month);
	
	/**
	 * 查询全部Person实例
	 * @return 全部Person实例
	 */
	public List<rizhidata> findAllrizhi();
	
	/**
	 * 查询数据表中Person实例的总数
	 * @return 数据表中Person实例的总数
	 */
	long getrizhiNumber();
	
	public long getrizhiNumber(String sql);
	
	public long getrizhiNumber(String sql,Calendar starttime,Calendar endtime);

	public List<rizhidata> searchByTitle(String title);
	public List<rizhidata> searchByKeyWord(String keyword);
	List findByPage(final String hql, final int offset, final int pageSize);
	List findByPage(final String hql , final Object value ,final int offset, final int pageSize);
	List findByPage(final String hql, final Object[] values,final int offset, final int pageSize);
	List findByPage(final String hql , final long starttime,final long endtime,final int offset, final int pageSize);
}
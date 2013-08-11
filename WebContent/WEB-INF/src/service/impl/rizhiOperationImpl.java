package service.impl;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;

import java.util.*;

public class rizhiOperationImpl implements rizhiOperation
{
	private rizhidataDao rizhi;
	private commensDao commen;
	private sortsDao sort;
	private usersDao user;
	private linksDao links;
	
	//为依赖注入设置方法-
	public void setRizhi(rizhidataDao rizhi)
	{
		this.rizhi = rizhi;
	}
	public rizhidataDao getRizhi()
	{
		return this.rizhi;
	}
	public void setCommen(commensDao commen)
	{
		this.commen = commen;
	}
	public void setSort(sortsDao sort)
	{
		this.sort = sort;
	}
	public void setUser(usersDao user)
	{
		this.user = user;
	}
	public void setLinks(linksDao link)
	{
		this.links = link;
	}
	
	//增加日志方法
	public int addRizhi(String title,String author,Calendar time,String precontent,String content,String[] sortss)
	{
		users u = user.findByprivilege(603);
		rizhidata r = new rizhidata(u,title,time,content,precontent);
		rizhi.save(r);        //先持久化，为方便下面sorts表添加相关数据库键
		Set<sorts> sortSet = new HashSet();
		for (int i = 0;i<sortss.length;i++)
		{
			List<sorts> tmpSorts = sort.findByName(sortss[i]);
			if (tmpSorts.size()==0)    //所选的类别还没有
			{
				sorts s = new sorts(sortss[i]);
				s.getRizhidata().add(r);
				sort.save(s);
				sortSet.add(s);
			}
			else                       //类别已经存在
			{
				for (int j = 0;j<tmpSorts.size();j++)
					sortSet.add(tmpSorts.get(j));
			}
			
		}
		r.setSorts(sortSet);     //设置类别
		rizhi.update(r);        //不要忘记更新
		return ADD_SUC;
	}
	
	public int addRizhi(String title,String author,Calendar time,String precontent,String content,int[] sortid)
	{
		users u = user.findByprivilege(603);
		if (u == null)
			return ADD_FAIL;
		rizhidata r = new rizhidata(u,title,time,content,precontent);
		rizhi.save(r);        //先持久化，为方便下面sorts表添加相关数据库键
		Set<sorts> sortSet = new HashSet();
		for (int i = 0;i<sortid.length;i++)
		{
			sortSet.add(sort.get(sortid[i]));	
		}
		r.setSorts(sortSet);     //设置类别
		rizhi.update(r);        //不要忘记更新
		return ADD_SUC;
	}
	
	public int addRizhi(String title,String author,Calendar time,String precontent,String content,int[] sortsid,int iscomment,int visible,int stick,String filename)
	{
		users u = user.findByprivilege(603);
		if (u == null)
			return ADD_FAIL;
		rizhidata r = new rizhidata(u,title,time,content,precontent,iscomment,visible,stick,filename);
		rizhi.save(r);        //先持久化，为方便下面sorts表添加相关数据库键
		Set<sorts> sortSet = new HashSet();
		for (int i = 0;i<sortsid.length;i++)
		{
			sortSet.add(sort.get(sortsid[i]));	
		}
		r.setSorts(sortSet);     //设置类别
		rizhi.update(r);        //不要忘记更新
		
		return ADD_SUC;
	}
	public int update(int rizhiId,String title,String author,Calendar time,String precontent,String content,int[] sortsid,int iscomment,int visible,int stick,String filename)
	{
		rizhidata tmpRizhi = rizhi.get(rizhiId);
		tmpRizhi.setTitle(title);
		//获取用户对象
		users tmpU = user.findByprivilege(603);
		tmpRizhi.setUser(tmpU);
		tmpRizhi.setTime(time);
		tmpRizhi.setPrecontent(precontent);
		tmpRizhi.setContent(content);
		tmpRizhi.setIscomment(iscomment);
		tmpRizhi.setVisible(visible);
		tmpRizhi.setStick(stick);
		tmpRizhi.setAttachmentfilename(filename);
		rizhi.update(tmpRizhi);   //先持久化，为方便下面usrs sorts表添加相关数据库键
		tmpU.getRizhi().add(tmpRizhi);     //修改user对象对应的rizhidata集
		//设置sorts
		Set<sorts> sortSet = new HashSet();
		for (int i = 0;i<sortsid.length;i++)
		{
			sortSet.add(sort.get(sortsid[i]));	
		}
		tmpRizhi.setSorts(sortSet);     //设置类别
		rizhi.update(tmpRizhi);
		return UPDATE_SUC;
	}
	public int update(int rizhiId,String title,String author,Calendar time,String precontent,String content,String[] sortss)
	{
		rizhidata tmpRizhi = rizhi.get(rizhiId);
		tmpRizhi.setTitle(title);
		//获取用户对象
		users tmpU = user.findByprivilege(603);
		tmpRizhi.setUser(tmpU);
		tmpRizhi.setTime(time);
		tmpRizhi.setPrecontent(precontent);
		tmpRizhi.setContent(content);
		rizhi.save(tmpRizhi);   //先持久化，为方便下面usrs sorts表添加相关数据库键
		tmpU.getRizhi().add(tmpRizhi);     //修改user对象对应的rizhidata集
		//设置sorts
		Set<sorts> sortSet = new HashSet();
		for (int i = 0;i<sortss.length;i++)
		{
			List<sorts> tmpSorts = sort.findByName(sortss[i]);   //判断当前sort是否存在
			if (tmpSorts.size()==0)    //所选的类别还没有
			{
				sorts s = new sorts(sortss[i]);
				s.getRizhidata().add(tmpRizhi);
				sort.save(s);
				sortSet.add(s);
			}
			else                       //类别已经存在
			{
				for (int j = 0;j<tmpSorts.size();j++)
					sortSet.add(tmpSorts.get(j));
			}
			
		}
		tmpRizhi.setSorts(sortSet);//修改持久化对象
		rizhi.update(tmpRizhi);
		return UPDATE_SUC;
	}
	
	public int delete(int rizhiId)
	{
		rizhidata tmpRizhi = rizhi.get(rizhiId);
		rizhi.delete(tmpRizhi);
		return DELETE_SUC;
	}
	public int addcomment(int rizhiId,String author,String ip,String email,Calendar time,String content)
	{
		rizhidata tmpRizhi = rizhi.get(rizhiId);
		commens tmpcom = new commens(author,ip,email,content);
		tmpcom.setRizhi(tmpRizhi);
		tmpcom.setTime(time);
		commen.save(tmpcom);
		tmpRizhi.getCommens().add(tmpcom);
		rizhi.update(tmpRizhi);
		return ADD_SUC;
	}
	
	public long getRizhinumber()
	{
		return rizhi.getrizhiNumber();
	}
	public long getRizhinumber(String sql)
	{
		return rizhi.getrizhiNumber(sql);
	}
	public long getRizhinumber(String sql,Calendar starttime,Calendar endtime)
	{
		return rizhi.getrizhiNumber(sql, starttime, endtime);
	}
	
	public List<rizhidata> searchContent(String keyword)
	{
		List<rizhidata> tmpList = rizhi.searchByKeyWord(keyword);
		return tmpList;
	}
	public List<rizhidata> searchTitle(String title)
	{
		List<rizhidata> tmplist = rizhi.searchByTitle(title);
		return tmplist;
	}
	public List<rizhidata> getAllrizhi()
	{
		return rizhi.findAllrizhi();
	}
	public rizhidata getRizhi(int id)
	{
		return rizhi.get(id);
	}
	
	public List findByPage(final String hql, final int offset, final int pageSize)
	{
		return rizhi.findByPage(hql, offset, pageSize);
	}
	
	public List findByPage(final String hql , final Object value ,final int offset, final int pageSize)
	{
		return rizhi.findByPage(hql, value, offset, pageSize);
	}
	
	public List findByPage(final String hql, final Object[] values,final int offset, final int pageSize)
	{
		return rizhi.findByPage(hql, values, offset, pageSize);
	}
	
	public List findByPage(final String hql , final long starttime,final long endtime,final int offset, final int pageSize)
	{
		return rizhi.findByPage(hql, starttime, endtime, offset, pageSize);
	}
	
	public void visitimes(int id)
	{
		rizhidata tmprizhi = rizhi.get(id);
		int time = 0;
		try
		{
			time = tmprizhi.getVisitimes();	
		}
		catch(Exception e)
		{
		}
		tmprizhi.setVisitimes(++time);
		rizhi.update(tmprizhi);
	}
}
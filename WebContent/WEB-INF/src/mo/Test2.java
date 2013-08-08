package mo;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;
import service.impl.*;

import org.springframework.context.*;
import org.springframework.context.support.*;
import java.util.*;

public class Test2
{
	public static void main(String[] args)
	{
		//创建Spring容器
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("testBean.xml");
		//获取DAO组件
	//	rizhidataDao rzdao = (rizhidataDao)ctx.getBean("rizhidataDao");
		rizhiOperationImpl r = (rizhiOperationImpl)ctx.getBean("rizhiOperationImpl");
		usersOperationImpl u = (usersOperationImpl)ctx.getBean("usersOperationImpl");
		String[] sortss ={"test1","test3"};
/*		if (r.addRizhi("SPRINGtitle1", "SPRINGauthor", Calendar.getInstance(), "SPRINGprecontent1", "SPRINGcontent1", sortss)== 0)
		{
			System.out.println("add suc!");
		}    */
/*		List<rizhidata> list = r.searchContent("CONTEN");
		if(list.size()>0)
		{
			for (int i = 0;i<list.size();i++)
			{
				rizhidata ri = list.get(i);
				System.out.println(ri.getTitle());
			}
		}   */
	//	users testU = new users("testU","testPass",100);
		u.addUser("testU","testPass",100);
		List<users> testU = u.getAllusers();
		for(int i = 0;i<testU.size();i++)
		{
			System.out.println(testU.get(i).getName());
		}
		
	}
		
}
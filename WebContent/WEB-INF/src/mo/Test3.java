package mo;

import dao.*;
import dao.impl.*;
import domain.*;
import service.*;
import service.impl.*;

import org.springframework.context.*;
import org.springframework.context.support.*;

import java.util.*;

public class Test3
{
	
	public static void main(String[] args)
	{
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("testBean.xml");
		//获取DAO组件
//		rizhidataDao rzdao = (rizhidataDao)ctx.getBean("rizhidataDao");
		calendarOperationImpl u = (calendarOperationImpl)ctx.getBean("calendar");
		List<String> tmp = u.getIndexcalendar();
		for (int i = 0;i<tmp.size();i++)
		{
			System.out.println(tmp.get(i));
		}
	}
}
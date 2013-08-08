package mo;

import dao.*;
import dao.impl.*;
import domain.*;

import org.springframework.context.*;
import org.springframework.context.support.*;
import java.util.*;

public class Test
{
	public static void main(String[] args)
	{
		//创建Spring容器
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("bean.xml");
		//获取DAO组件
		rizhidataDao rzdao = (rizhidataDao)ctx.getBean("rizhidataDao");
		//循环插入10条记录
/*		for (int i = 0 ; i < 10  ; i++ )
		{
			pdao.save(new rizhidata("testawen", "testtitle"+i,Calendar.getInstance(),"testcontent"+i,"testprecontent"+i));
		}
		//调用DAO组件的方法  */
		System.out.println(rzdao.getrizhiNumber());
		List<rizhidata> rzList = rzdao.findAllrizhi();
		rizhidata testRizhi = rzList.get(5);
		System.out.println(testRizhi.getUser()+"   "+testRizhi.getPrecontent());
		List<rizhidata> rzSearch = rzdao.searchByKeyWord("test");
		System.out.println(rzSearch.size());
		//////////////////////////////////////
		sortsDao sdao = (sortsDao)ctx.getBean("sortsDao");
		sorts s = new sorts("testSorts");
		s.getRizhidata().add(testRizhi);
		sdao.save(s);
		
		testRizhi.getSorts().add(s);
		rzdao.save(testRizhi);
		//System.out.println(sdao.getsortsNumber());
	}
}
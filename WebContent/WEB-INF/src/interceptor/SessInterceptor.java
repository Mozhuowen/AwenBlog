package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import action.*;

public class SessInterceptor
	extends AbstractInterceptor
{

	public String intercept(ActionInvocation invocation)
		throws Exception
	{                                                             
		HttpServletRequest request = ServletActionContext.getRequest();
		ActionContext ctx = invocation.getInvocationContext();
		String path = request.getServletPath();    //获取请求路径
		String test = new String("admin");
		if(path.indexOf(test)==-1)    //路径如果 不是后台地址则检查刷新率
		{			
			Calendar testtime = (Calendar)ctx.getSession().get("time");
			if(testtime==null)
			{
				testtime = Calendar.getInstance();
				testtime.setTimeInMillis(1000);
			}
			if(Calendar.getInstance().getTimeInMillis()-testtime.getTimeInMillis()<500)
				return "refresh";
		}	  
	//	System.out.println("Sess start!");
		//交给下个拦截器
		String result = invocation.invoke();
	//	System.out.println("Sess end!");
		//记录访问时间
		ctx.getSession().put("time", Calendar.getInstance());
		return result;
	}
}
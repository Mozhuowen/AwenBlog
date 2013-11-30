package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import action.*;
import dao.*;
import domain.*;

public class LogInterceptor
	extends AbstractInterceptor
{
	private tongjiDao tongji;   //依赖注入
	
	public void setTongji(tongjiDao t)
	{
		this.tongji = t;
	}
	public tongjiDao getTongji()
	{
		return this.tongji;
	}
	
	public String intercept(ActionInvocation invocation)
	throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getServletPath()+"?"+request.getQueryString();  //获取请求路径
		String ip = request.getRemoteAddr();      //获取客户IP
		tongji tj = new tongji(Calendar.getInstance(),ip,url);
		tongji.save(tj);   //持久化数据
	//	System.out.println("Log start!");
		String result = invocation.invoke();
	//	System.out.println("Log end!");
		return result;
	}
}
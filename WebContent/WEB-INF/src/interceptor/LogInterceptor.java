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
	private tongjiDao tongji;   //����ע��
	
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
		String url = request.getServletPath()+"?"+request.getQueryString();  //��ȡ����·��
		String ip = request.getRemoteAddr();      //��ȡ�ͻ�IP
		tongji tj = new tongji(Calendar.getInstance(),ip,url);
		tongji.save(tj);   //�־û�����
	//	System.out.println("Log start!");
		String result = invocation.invoke();
	//	System.out.println("Log end!");
		return result;
	}
}
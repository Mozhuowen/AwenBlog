package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

import action.*;

public class PowerInterceptor
	extends AbstractInterceptor
{
	public String intercept(ActionInvocation invocation)
	throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getServletPath();    //��ȡ����·��
		String ip = request.getRemoteAddr();       //��ȡ�ͻ���IP
		String admin = new String("admin");
		if(path.indexOf(admin)!=-1)         //����Ǻ�̨����·�������Ȩ��
		{
			if (!check(ip))
				return "error";
		}
		System.out.println(path);
		System.out.println("Power start!");
		String result = invocation.invoke();
		System.out.println("Power end!");
		return result;
	}
	
	public boolean check(String ip) throws Exception    //Ȩ�޼�鷽��
	{
		ActionContext ctx = ActionContext.getContext();
		if(ip.equals((String)ctx.getSession().get("ip"))&&"true".equals(ctx.getSession().get("auth")))
			return true;
		else
			return false;
	}
}
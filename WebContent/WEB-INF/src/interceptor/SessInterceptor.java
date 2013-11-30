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
		String path = request.getServletPath();    //��ȡ����·��
		String test = new String("admin");
		if(path.indexOf(test)==-1)    //·����� ���Ǻ�̨��ַ����ˢ����
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
		//�����¸�������
		String result = invocation.invoke();
	//	System.out.println("Sess end!");
		//��¼����ʱ��
		ctx.getSession().put("time", Calendar.getInstance());
		return result;
	}
}
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp" type="text/css">

</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%">
<tr>
<td>
<tr><td height="40">
<a href=><b>ɾ��<s:property value="currentrizhi.title"/>��ȫ������</b></a></td></tr>
</table><table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder">
<table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<tr>
 <td class="tblhead" colspan="3"><b>${currentrizhi.title}�������б�</b></td>
</tr>

<tr bgcolor="#CCCCCC">
 <td align="center" width="26%"><b>��������Ϣ</b></td>
 <td align="center" width="60%"><b>��������</b></td>
 <td align="center" width="14%"><b>��������</b></td>
</tr>
<s:iterator value="comments" id="cc">
<tr class=firstalt><td><b>Name:</b>${author}<br>
<b>E-mail:</b><span class="size3">${email}</span><br>
<b>IP:</b><span class="size3">${ip}</span></td>
<td>${content}</td>
<td align="center">[<a href="admin_comments!edit?commentid=${commenid}">�༭</a>] [<a href="admin_comments!delete?commentid=${commenid}">ɾ��</a>]</td>
</tr>
</s:iterator>
</table>
</td>
</tr>
</table>
<br>
<center>
Processed in 0.016905 second(s), 5 queries
<br></body>
</html>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp" type="text/css">

</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<SCRIPT language=JavaScript>
function CheckAll(form) {
	for (var i=0;i<form.elements.length;i++) {
		var e = form.elements[i];
		if (e.name != 'chkall')
		e.checked = form.chkall.checked;
    }
}
</SCRIPT>
<table width="96%" border="0" align="center" cellspacing="0" cellpadding="1">
<tr>
	<td><b>�����б�</b></td>
</tr>
<s:iterator value="sortlist" id="ss">
<tr>
<td><li><a href=admin_edit_article!sort?sortid=${ss.sortid}><b>${ss.name}</b></a></td>
</tr>
</s:iterator>
</table>
<br>
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder">
<table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form action="admin_add_article_action!delete"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="7"><b>All</b></td>
</tr>
<tr bgcolor="#CCCCCC">
 <td align="center" width="6%" nowrap><b>״̬</b></td>
 <td width="36%"><b>���±���</b></td>
 <td align="center" width="12%" nowrap><b>����</b></td>
 <td align="center" width="6%" nowrap><b>����</b></td>
 <td align="center" width="18%" nowrap><b>ʱ��</b></td>
 <td align="center" width="18%" nowrap><b>�������</b></td>
 <td align="center" width="4%" nowrap><input name="chkall" value="on" type="checkbox" onclick="CheckAll(this.form)"></td>
</tr>
<!-- ��������ʼ -->
<s:iterator value="rizhilist" id="rlist">
<tr class="firstalt"><td align="center" nowrap>
<s:if test="visible == 1">
��ʾ
</s:if>
<s:else>
����
</s:else>
</td>
<td><table width="100%" border="0" cellspacing="0" cellpadding="0"><tr><td><a href="!show?blogid=<s:property value="rizhiid"/>" target="_blank"><s:property value="title"/></a></td><td align="right" nowrap></td></tr></table></td>
<td align="center" nowrap>
<s:iterator value="#rlist.sorts" id="sset">
	<s:property value="name"/>|
</s:iterator>
</td>
<td align="center" class="size3" nowrap>${rlist.commens.size()}</td>
<td align="center" class="size3" nowrap><s:date name="time"/></td>
<td align="center" nowrap>[<a href="admin_edit_article_action?blogid=${rizhiid}">�༭</a>][<a href="admin_comments?blogid=${rizhiid}">��������</a>][<a href="admin_add_article_action!delete?blogid=${rizhiid}">ɾ��</a>]</td>
<td align="center" nowrap><input type="checkbox" name="blogid" value="${rlist.rizhiid}">
<input type="hidden" name="attachment[0]" value="1">
</td>
</tr>
</s:iterator>
<!-- �������� -->
<tr class=secondalt><td colspan="7"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"><tr><td>���� <font color=#000000><b>${rizhilist.size()}</b></font> ����¼</td>
<td align=right>
</td></tr></table>
</td></tr>
<input type="hidden" name="action" value="domoredel">
<tr class="tblhead">
<td colspan="7" align="center">
 <input class="formbutton" accesskey="" type="submit" name="" value="ɾ��ѡ������" >
</td></tr>
</form>
</table>
</td>
</tr>
</table>
<br>
<center>
<br></body>
</html> 
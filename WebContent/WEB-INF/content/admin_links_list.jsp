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
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder"><table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form action="admin_links!delete"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="5"><b><b>链接列表（目前共有 2 个链接）</b></b></td>
</tr>
<tr bgcolor="#CCCCCC">
	<td align="center" width="6%"><b>状态</b></td>
	<td align="center" width="18%"><b>站点名称</b></td>
	<td align="center" width="60%"><b>站点 URL</b></td>
	<td align="center" width="12%"><b>管理操作</b></td>
  <td align="center" width="4%" nowrap><input name="chkall" value="on" type="checkbox" onclick="CheckAll(this.form)"></td>
</tr>
<s:iterator value="linklist" id="ll">
<tr class=firstalt>
<td align=center>
<s:if test="visible == 1">
显示
</s:if>
<s:else>
隐藏
</s:else>
</td>
<td align=center>${sitename}</td>
<td>${url}</td>
<td align=center>[<a href=admin_links!edit?linkid=${linkid}>编辑</a>] [<a href=admin_links!delete?linkid=${linkid}>删除</a>]</td>
<td align="center" nowrap><input type="checkbox" name="link[2]" value="1"></td>
</tr>
</s:iterator>
<tr class="tblhead">
<td colspan="5" align="center">
 <input class="formbutton" accesskey="" type="submit" name="" value="删除选定链接" >
</td></tr>
</form>
</table>
</td>
</tr>
</table>
<br>
<center>
Processed in 0.018579 second(s), 4 queries
<br></body>
</html>
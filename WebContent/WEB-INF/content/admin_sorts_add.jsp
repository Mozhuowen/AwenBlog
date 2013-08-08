<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp" type="text/css">

</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder"><table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form action="admin_sorts!add"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="2"><b>添加分类</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td>分类名称:</td>
	<td><input class="formfield" type="text" name="sortname" size="35" maxlength="50" value="${currentsort.name}" ></td>
</tr>
<s:if test="#currentsort!=null">
<input type="hidden" name="sortid" value="${currentsort.sortid}">
</s:if>
<tr class="tblhead">
<td colspan="2" align="center">
 <input class="formbutton" accesskey="y" type="submit" name="submit" value="提交" >
 <input class="formbutton" accesskey="r" type="reset" name="" value="重置" >
</td></tr>
</form>
</table>
</td>
</tr>
</table><br>
<br>
<center>
<br></body>
</html>
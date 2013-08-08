<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp" type="text/css">

</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<form method="post" action="login">
<br><table cellpadding="0" cellspacing="0" border="0" align="center" width="250" class="tblborder">
<tr>
<td class="tdborder"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1">
 <tr id="cat">  <td class="tblhead" colspan="2" height="25" align="center">  <b>登陆入口</b>  </td> </tr> <tr class="firstalt"><td width="118">用户名:</td>  <td width="232"><input type="text" name="username" value="" class="formfield"></td></tr> <tr class="secondalt"><td width="118">密码:</td>  <td width="232"><input type="password" name="password" value="" class="formfield"></td></tr> <tr class="tblhead"><td colspan="2" align="center"><input type="submit" value="登陆" class="formbutton"> <input type="reset" value="重置" class="formbutton"></td></tr></table></td></tr></table></form><p align="center">Powered by 90Blog</p></body></html>
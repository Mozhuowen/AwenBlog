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
<form action="admin_comments!edit_content"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="2"><b>编辑评论</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td>评论人:</td>
	<td><input class="formfield" type="text" name="author" size="35" maxlength="50" value="${currentcomment.author}" ></td>
</tr>
<tr class="secondalt" nowrap>
	<td>评论人E-mail:</td>
	<td><input class="formfield" type="text" name="email" size="35" maxlength="50" value="${currentcomment.email}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td valign="top">评论内容:</td>
	<td><textarea class="formfield" type="text" name="content" cols="75" rows="20" >${currentcomment.content}</textarea></td>
</tr>
<tr class="secondalt" nowrap>
	<td valign="top">回复:</td>
	<td><textarea class="formfield" type="text" name="back_content" cols="75" rows="20" >${currentcomment.back_content}</textarea></td>
</tr>
<input type="hidden" name="commentid" value="${currentcomment.commenid}">
<input type="hidden" name="blogid" value="${currentcomment.rizhi.rizhiid}">
<tr class="tblhead">
<td colspan="2" align="center">
 <input class="formbutton" accesskey="y" type="submit" name="submit" value="提交" >
 <input class="formbutton" accesskey="r" type="reset" name="" value="重置" >
</td></tr>
</form>
</table>
</td>
</tr>
</table>
<br>
<center>
Processed in 0.028064 second(s), 4 queries
<br></body>
</html>
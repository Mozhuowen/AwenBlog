<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp.css" type="text/css">

</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder"><table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form action="admin_about!edit"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="2"><b>����Ա��ϸ����</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td><b>�ǳ�</b><br></td>
	<td><input class="formfield" type="text" name="petname" size="35" maxlength="50" value="${currentuser.petname}" ></td>
</tr>
<tr class="secondalt" nowrap>
	<td><b>�Ա�</b><br>�Ա�</td>
	<td><input class="formfield" type="text" name="sex" size="35" maxlength="50" value="${currentuser.sex}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td><b>QQ</b><br></td>
	<td><input class="formfield" type="text" name="qq" size="10" maxlength="10" value="${currentuser.qq}" ></td>
</tr>
<tr class="secondalt" nowrap>
	<td><b>E-mail</b><br>��ʹ�õ�E-mail</td>
	<td><input class="formfield" type="text" name="email" size="35" maxlength="50" value="${currentuser.email}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td><b>��ҳ</b><br></td>
	<td><input class="formfield" type="text" name="homepage" size="35" maxlength="50" value="${currentuser.homepage}" ></td>
</tr>

<tr class="firstalt" nowrap>
	<td><b>����֮��</b><br>Ϊ�˱�����˽��ֻ��д���</td>
	<td><input class="formfield" type="text" name="birth_year" size="10" maxlength="10" value="${currentuser.birth_year}" ></td>
</tr>
<tr class="secondalt" nowrap>
	<td><b>����</b><br></td>
	<td><input class="formfield" type="text" name="hobby" size="35" maxlength="50" value="${currentuser.hobby}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td><b>�س�</b><br></td>
	<td><input class="formfield" type="text" name="profession" size="35" maxlength="50" value="${currentuser.profession}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td valign="top"><b>��������</b><br>�򵥻���ϸȫ����</td>
	<td><textarea class="formfield" type="text" name="description" cols="50" rows="7" >${currentuser.description}</textarea></td>
</tr>
<tr class="tblhead">
<td colspan="2" align="center">
 <input class="formbutton" accesskey="y" type="submit" name="submit" value="�ύ" >
 <input class="formbutton" accesskey="r" type="reset" name="" value="����" >
</td></tr>
</form>
</table>
</td>
</tr>
</table>
<br>
<center>
Processed in 0.016353 second(s), 3 queries
<br></body>
</html>
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<META content="text/html; charset=gb2312" http-equiv="Content-Type">
<link href="./cp" rel="stylesheet" type="text/css">
</head>
<body>
<form action="admin_uploadimg!upload" enctype="multipart/form-data" method="post">
<table>
<tr>
<td>ѡ���ļ�</td><td><input type="file" name="attachment"/> </td><td><input type="submit" name="submit" value="�ύ"/></td>
</tr>
</table>
<br>
</form>
${name}��<a href="${name}">${name}</a>
</body>
</html>
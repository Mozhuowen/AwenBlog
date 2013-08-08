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
<form action="admin_links!add"  method="post" name="" >
<tr id="cat">
	<td class="tblhead" colspan="2"><b>添加链接</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td>网站标题:</td>
	<td><input class="formfield" type="text" name="sitename" size="35" maxlength="50" value="${currentlink.sitename}" ></td>
</tr>
<tr class="secondalt" nowrap>
	<td>网站地址:</td>
	<td><input class="formfield" type="text" name="url" size="35" maxlength="50" value="${currentlink.url}" ></td>
</tr>
<tr class="firstalt" nowrap>
	<td valign="top">网站描述:</td>
	<td><textarea class="formfield" type="text" name="description" cols="50" rows="7" >${currentlink.description}</textarea></td>
</tr>
<tr class="secondalt">
	<td valign="top">显示?</td>
	<td><select name="visible">
<option value="1" 
<s:if test="#currentlink.visible == 1">
selected
</s:if>
 class="">是</option>
<option value="0" 
<s:else>
selected
</s:else>
 class="">否</option>
</select>
</td></tr>
<input type="hidden" name="linkid" value="${currentlink.linkid}">
<tr class="tblhead">
<td colspan="2" align="center">
 <input class="formbutton" accesskey="y" type="submit" name="submit" value="提交" >
 <input class="formbutton" accesskey="r" type="reset" name="" value="重置" >
</td></tr>
</form>
</table>
</td>
</tr>
</table><SCRIPT language=JavaScript>
function CheckAll(form) {
	for (var i=0;i<form.elements.length;i++) {
		var e = form.elements[i];
		if (e.name != 'chkall')
		e.checked = form.chkall.checked;
    }
}
</SCRIPT>

<br>
<center>
Processed in 0.088833 second(s), 3 queries
<br></body>
</html>
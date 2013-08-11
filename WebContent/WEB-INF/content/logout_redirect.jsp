<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<STYLE type=text/css>
BODY {
	FONT-SIZE: 12px;
	SCROLLBAR-ARROW-COLOR: #000000;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif";
	SCROLLBAR-BASE-COLOR: #828fa2;
}
TD {
	FONT-SIZE: 12px;
	FONT-FAMILY: "Verdana", "Arial", "Helvetica", "sans-serif";
}
A:active {
	COLOR: #000000; TEXT-DECORATION: underline
}
A:visited {
	COLOR: #455164; TEXT-DECORATION: underline
}
A:hover {
	COLOR: #000000; TEXT-DECORATION: none
}
A:link {
	COLOR: #455164; TEXT-DECORATION: underline
}
</STYLE>
<TITLE>系统消息</TITLE>
</head>
<body leftmargin="10" topmargin="10" marginwidth="10" marginheight="10" style="table-layout:fixed; word-break:break-all">
<table width="100%" border="0" cellspacing="0" cellpadding="0" height="95%" align="center">
<tr align="center" valign="middle">
	<td>
	<table border="0" cellspacing="0" cellpadding="10" width="60%">
	<tr>
		<td style="BACKGROUND-IMAGE: url(img/dot_width)" height="1"></td>
	</tr>
	<tr>
	  <td height="120" align="center" nowrap>退出成功，准备跳转</td>
	  </tr>
	<tr>
	  <td style="BACKGROUND-IMAGE: url(img/dot_width)" height="1"></td>
	  </tr>
	</table>
	</td>
</tr>
</table>
<script language="javascript">
function test(){
window.location="./";
}
setTimeout("test()",2000);
</script> 
</body>
</html>
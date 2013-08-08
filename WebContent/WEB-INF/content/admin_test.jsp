<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
    <title>控制面版</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    </head>
	<frameset cols="180,*" framespacing="0" frameborder="yes" border="1" bordercolor="#000000">
		<frame name="menuFrame" noresize scrolling="yes" src="admin_menu" frameborder="no" border="0">
		<frameset rows="25,*" frameborder="no" border="0" framespacing="1"> 
			<frame name="topRFrame" noresize scrolling="no" src="admin_top">
			<frame name="mainFrame" noresize scrolling="yes" src="admin_add_article_jsp">
		</frameset>
	</frameset>
    <noframes>
	<body text="#000000">
    </body>
	</noframes>
    </html>

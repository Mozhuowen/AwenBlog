<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<HEAD><TITLE>My Blog</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312"><LINK href="./cp" type=text/css rel=stylesheet></HEAD>
<BODY style="TABLE-LAYOUT: fixed; WORD-BREAK: break-all" leftMargin=20 topMargin=20 marginheight="20" marginwidth="20">
<TABLE class=tblborder cellSpacing=0 cellPadding=0 width="96%" align=center border=0>
<TBODY>
<TR>
<TD class=tdborder>
<TABLE cellSpacing=1 cellPadding=4 width="100%" align=center border=0>
<TBODY>
<TR id=cat>
<TD class=tblhead colSpan=4><B>现有分类列表（目前共有 1 个分类）</B></TD></TR>
<TR bgColor=#cccccc>
<TD noWrap align=middle width="4%"><B>排序</B></TD>
<TD align=middle width="32%"><B>分类名</B></TD>
<TD align=middle width="32%"><B>文章数量数量</B></TD>
<TD align=middle width="32%"><B>管理操作</B></TD></TR>
<!-- 开始进行类别迭代 -->
<s:iterator value="sortlist" id="ss">
<TR class=firstalt>
<TD noWrap align=middle>${sortid}</TD>
<TD align=middle>${name}</TD>
<TD align=middle>${ss.rizhidata.size()}</TD>
<TD align=middle>[<A href="admin_sorts!edit?sortid=${sortid}">编辑</A>] [<A href="admin_sorts!delete?sortid=${sortid}">删除</A>]</TD>
</TR>
</s:iterator>
<!-- 类别迭代结束 -->
<TR class=tblhead>
<TD align=middle colSpan=4></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE><BR>
<CENTER>Processed in 0.020655 second(s), 4 queries <BR></CENTER></BODY>
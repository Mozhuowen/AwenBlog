<%@ page contentType="text/html; charset=GBK" language="java" errorPage="error" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="awen ����,m90����,רע��Java EE��Android��ϵͳ�ܹ���Linux�����簲ȫ">
<META NAME="keywords" CONTENT="java,java ee,android,ϵͳ�ܹ�,Linux,���簲ȫ">
<title>Awen's Blog</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="table-layout:fixed; word-break:break-all">
<script charset="utf-8" src="./editor/kindeditor.js"></script>
<script charset="utf-8" src="./editor/lang/zh_CN.js"></script>
<TABLE width=870 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD><DIV style="FONT-SIZE: 18px; MARGIN: 25px 0px 7px; FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;font-weight: bolder;"><A href="./">Awen(����)'s Blog</A></DIV>
        <FONT color="#404040" style="FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;">רע��Java EE��Android��ϵͳ�ܹ���Linux�����簲ȫ</FONT></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>
</TABLE>
<TABLE width=870 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD height=30 align="left" valign="top" style="FONT-SIZE: 14px">
      <P><b>View Mode:</b> <a href=""><b>Normal</b></a> | <b><a href="!list">List</a></b></P>
    </TD>
    <TD align="right" valign="top" style="FONT-SIZE: 14px"><A href="./"><B>Home</B></A> | <A 
      href="!about"><B>About Me</B></A> | <A 
      href="index.php?action=rss"><B>RSS</B></A> | <A 
      href="test_login"><B>Control Panel</B></A></TD>
  </TR>
  <TR>
    <TD height="1" colspan="2" style="BACKGROUND-IMAGE: url(img/dot_width)"></TD>
  </TR>
</TABLE>
<TABLE width=870 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD width="670" vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="96%" align="center" border=0>
        
          <TR>
            <TD height=20></TD>
          </TR>
        
      </TABLE>

<!-- ÿƪ��־������ʼ -->
<s:iterator value="rizhiabstract" id="rr">
  <table width="98%" border="0" style="table-layout:fixed; word-break:break-all">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="40"><font class="title"><img src="img/at" border="0"></font></td>
        <td class="title">${rr.title}</td>
      </tr>
    </table>            
      <font color="#777777" class="f11">Submitted
    by <a href="mailto:youname@domain.com"><b>${rr.user.name}</b></a>&nbsp;on&nbsp;<s:date name="#rr.time"/></font></td>
  </tr>
  <tr>
    <td style="padding-top: 15px;padding-bottom: 15px;">${rr.precontent}</td>
  </tr>
  <tr>
    <td style="padding-top: 15px;padding-bottom: 15px;"></td>
  </tr>
  <tr>
    <td><a href="!show?blogid=${rr.rizhiid}">�Ķ�ȫ��</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="index.php?sortid=2">
    	<!-- ��ʼ������� -->
    	<s:iterator value="#rr.sorts" id="ss">
      		<a href="!sort?sortid=${ss.sortid}">${ss.name}</a>&nbsp;
      	</s:iterator></a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="!show?blogid=${rr.rizhiid}#comment">����</a>(${rr.commens.size()})&nbsp;&nbsp;|&nbsp;&nbsp;�������:
      ${rr.visitimes}</td>
  </tr>
</table>
<TABLE width="98%" border="0" cellPadding="0" cellSpacing="0">
  <TR>
    <TD height="20"></TD>
  </TR>
  <TR>
    <TD style="BACKGROUND-IMAGE: url(img/dot_width)" height="1"></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>
</TABLE>
</s:iterator>
<!-- ÿƪ��־�������� -->
<!-- �׶�ҳ��ͳ�� -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="15"></td>
  </tr>
</table>
<table width="98%" border="0">
  <tr>
  	<!-- ��� -->
    <td>����&nbsp;<font color=#000000><b>${currentrizhicount}</b></font>&nbsp;����¼&nbsp;&nbsp;<font color=#000000><b>${pagesize}</b></font>&nbsp;��/ҳ</td>
    <!-- �Ҳ� -->
    <s:if test="#current!=0">
    	<td align="right"><a href="!sort?page=<s:if test="page==1">1</s:if><s:else>${page-1}</s:else>&year=${year}&month=${month}&day=${day}&sortid=${currentsortid}"><font face=webdings>9</font></a>  
 		<s:iterator value="pages" id="pp">
    		<s:if test="#pp==page">
    			<u><b>${pp}</b></u> 
    		</s:if>
    		<s:else>
    			<a href="?page=${pp}&year=${year}&month=${month}&day=${day}&sortid=${currentsortid}">${pp}</a> 
    		</s:else>    	 
    	</s:iterator>
    	<a href="?page=<s:if test="page==pagecount">${page}</s:if><s:else>${page+1}</s:else>&year=${year}&month=${month}&day=${day}&sortid=${currentsortid}"><Font face=webdings>:</font></a></td>
  	</s:if>
  	<s:else>
  		<td align="right"><a href="?page=<s:if test="page==1">1</s:if><s:else>${page-1}</s:else>&year=${year}&month=${month}&day=${day}"><font face=webdings>9</font></a>  
 		<s:iterator value="pages" id="pp">
    		<s:if test="#pp==page">
    			<u><b>${pp}</b></u> 
    		</s:if>
    		<s:else>
    			<a href="?page=${pp}&year=${year}&month=${month}&day=${day}">${pp}</a> 
    		</s:else>    	 
    	</s:iterator>
    	<a href="?page=<s:if test="page==pagecount">${page}</s:if><s:else>${page+1}</s:else>&year=${year}&month=${month}&day=${day}"><Font face=webdings>:</font></a></td>
  	</s:else>
  </tr>
</table>
<!-- �׶�ҳ��ͳ�ƽ��� -->
      <TABLE cellSpacing=0 cellPadding=0 width="96%" align="center" border=0>
        
          <TR>
            <TD height=20></TD>
          </TR>
        
      </TABLE></TD>
    <TD vAlign=top align=center width=200 style="table-layout:fixed; word-break:break-all"><table width="100%" border="0" cellspacing="0" cellpadding="0" class=righttable>
      <tr>
        <td align="center"><SCRIPT language=javascript>
function checksearch(search) {
	if (search.search.value==""){
	alert("��δ���������ؼ���.");
	return false;
	}
}
        </SCRIPT>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TR>
              <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Calendar</b></TD>
            </TR>
            <TR>
              <TD>&nbsp;</TD>
            </TR>
          </TABLE>          
          <table cellpadding="0" cellspacing="0" width="90%">
            <tr>
              <td align="center"><a href="?year=${currentyear}&month=<s:if test="currentmonth==1">1</s:if><s:else>${currentmonth-1}</s:else>"><font face="Webdings" >7</font></a> <a href="?year=${currentyear}&month=${currentmonth}">${currentyearmonthstr}</a> <a href="?year=${currentyear}&month=<s:if test="currentmonth==12">12</s:if><s:else>${currentmonth+1}</s:else>"><font face="Webdings">8</font></a></td>
            </tr>
          </table>
          <table cellpadding="0" cellspacing="0" width="90%">
            <tr>
              <td height="10"></td>
            </tr>
          </table>
          <table width="85%" cellpadding="0" cellspacing="0">
            <tr align="center">
              <td><b><font color="#CC0000">��</font></b></td>
              <td><b>һ</b></td>
              <td><b>��</b></td>
              <td><b>��</b></td>
              <td><b>��</b></td>
              <td><b>��</b></td>
              <td><b>��</b></td>
            </tr>
			<!-- BEGIN RowGetCalendar -->
			<s:iterator value="calendarlist" id="cc">
				${cc}
			</s:iterator>
			<!-- END RowGetCalendar -->
          </table><BR>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Category</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">
                <!-- BEGIN RowSort -->
				<s:iterator value="sorts" id="ss">
					[<a href="">RSS</a>] <a href="!sort?sortid=${ss.sortid}">${ss.name}</a>
					<br>
				</s:iterator>
        		<!-- END RowSort -->
                </TD>
              </TR>
            </TBODY>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Archives</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">
				<!-- BEGIN RowCalendar -->
					<s:iterator value="Archives" id="aa">
						<a href="?year=${currentyear}&month=${currentmonth}">${aa}</a>
						<br>
					</s:iterator>
				<!-- END RowCalendar --></TD>
              </TR>
            </TBODY>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Search</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
            <FORM method="POST" action="!search" name="search" onSubmit="return checksearch(this)">
              <TR>
                <TD style="PADDING-LEFT: 5px"><table border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><INPUT class="formfield" style="FONT-WEIGHT: normal; FONT-SIZE: 11px; LINE-HEIGHT: normal; FONT-STYLE: normal; FONT-VARIANT: normal" 
                  maxLength="30" size="15" name="search">
                      </td>
                      <td style="PADDING-LEFT: 5px"><INPUT class="formbutton" type="submit" style="FONT-WEIGHT: normal; FONT-SIZE: 11px; LINE-HEIGHT: normal; FONT-STYLE: normal; FONT-VARIANT: normal" value="Go!">
                      </td>
                    </tr>
                  </table>
                </TD>
              </TR>
            </FORM>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Recent
                    Articles</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">
				<!-- BEGIN RowNewBlog -->
				<s:iterator value="recentArticle" id="re">						
					<a href="!show?blogid=${re.rizhiid}">${re.title}</a><br>
				</s:iterator>
				<!-- END RowNewBlog -->
				</TD>
              </TR>
            </TBODY>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Recent
                    Comments</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">
				<!-- BEGIN RowNewCM -->
				<s:iterator value="recentComments" id="rc">
					<a href="!show?blogid=${rc.rizhi.rizhiid}#comment">${rc.content}</a><DIV class="newcminfo">- ${rc.author}</DIV>
				</s:iterator>
				<!-- END RowNewCM --></TD>
              </TR>
            </TBODY>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Blog
                    Info</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">���з���: ${sorts.size()}<br>
��������: ${rizhicount}<br>
��������: ${commentcount}<br>
���շ���: ${todayvisit}<br>
�ܹ�����: ${allvisit}</TD>
              </TR>
            </TBODY>
          </TABLE>
          <br>
          <TABLE cellSpacing=0 cellPadding=0 width="90%" border=0>
            <TBODY>
              <TR>
                <TD bgColor="#cccccc" style="PADDING-LEFT: 5px"><b>Links</b></TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
              </TR>
              <TR>
                <TD style="PADDING-LEFT: 5px">
                <s:iterator value="links" id="ll">
                  	<a href="${ll.url}" target="_blank" title="${ll.description}">${ll.sitename}</a><br>
                  </s:iterator>
                </TD>
              </TR>
            </TBODY>
          </TABLE>          
          <br>
          <!-- END RowMenu -->
        </td>
      </tr>
    </table>      
    </TD>
  </TR>
</TABLE>
<br>
<table border="0" align="center" cellpadding="3" cellspacing="5">
  <tr>
    <td align="center" style="FONT-SIZE: 11px">Copyright (C) 2013 m90-Blog All Rights Reserved.</td>
  </tr>
  
</table>
<br>
</body>
</html>
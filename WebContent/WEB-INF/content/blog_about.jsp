<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="awen 博客,m90博客,专注于Java EE、Android、系统架构、Linux和网络安全">
<META NAME="keywords" CONTENT="java,java ee,android,系统架构,Linux,网络安全">
<title>{TheBlogTitle} - {SmallTitle}</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="table-layout:fixed; word-break:break-all">
<TABLE width=770 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD><DIV style="FONT-SIZE: 18px; MARGIN: 25px 0px 7px; FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;font-weight: bolder;"><A href="./">Awen(阿文)'s Blog</A></DIV>
        <FONT color="#404040" style="FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;">专注于Java EE、Android、系统架构、Linux和网络安全</FONT></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>
</TABLE>
<TABLE width=770 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD height=30 align="left" valign="top" style="FONT-SIZE: 14px">
      <P><b>View Mode:</b> <a href=""><b>Normal</b></a> | <b><a href="!list">List</a></b></P>
    </TD>
    <TD align="right" valign="top" style="FONT-SIZE: 14px"><A href="./"><B>Home</B></A> | <A 
      href="about"><B>About Me</B></A> | <A 
      href=""><B>RSS</B></A> | <A 
      href="test_login"><B>Control Panel</B></A></TD>
  </TR>
  <TR>
    <TD height="1" colspan="2" style="BACKGROUND-IMAGE: url(img/dot_width)"></TD>
  </TR>
</TABLE>
<TABLE width=770 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD width="570" vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="96%" align="center" border=0>
        
          <TR>
            <TD height=20></TD>
          </TR>
        
      </TABLE>

<!-- 左侧中间部分开始 -->
<table width="98%" border="0">
  <tr>
	<td width="38"><font class="title"><img src="img/at" border="0"></font></td>
	<td class="title">关于我</td>
  </tr>
</table>
<TABLE cellSpacing=0 cellPadding=0 width="96%" align="center" border=0>
  <TR>
    <TD height=20></TD>
  </TR>
</TABLE>
<table width="94%" border="0" align="center">

  <tr valign="top">
    <td nowrap width="80"><b>昵称:</b></td>
    <td>${currentuser.petname}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>性别:</b></td>
    <td>${currentuser.sex}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>QQ:</b></td>
    <td>${currentuser.qq}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>E-mail:</b></td>
    <td>${currentuser.email}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>主页:</b></td>
    <td>${currentuser.homepage}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>出生之年:</b></td>
    <td>${currentuser.birth_year}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>爱好:</b></td>
    <td>${currentuser.hobby}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>特长:</b></td>
    <td>${currentuser.profession}</td>
  </tr>	

  <tr valign="top">
    <td nowrap width="80"><b>个人描述:</b></td>
    <td>${currentuser.description}</td>
  </tr>	

</table>
<!-- 左侧中间部分结束结束 -->
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
	alert("您未输入搜索关键字.");
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
              <td><b><font color="#CC0000">日</font></b></td>
              <td><b>一</b></td>
              <td><b>二</b></td>
              <td><b>三</b></td>
              <td><b>四</b></td>
              <td><b>五</b></td>
              <td><b>六</b></td>
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
                <TD style="PADDING-LEFT: 5px">共有分类: ${sorts.size()}<br>
共有文章: ${rizhicount}<br>
共有评论: ${commentcount}<br>
今日访问: ${todayvisit}<br>
总共访问: ${allvisit}</TD>
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
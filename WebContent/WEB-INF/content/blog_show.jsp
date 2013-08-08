<%@ page contentType="text/html; charset=GBK" language="java" errorPage="innodb" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="description" content="awen 博客,m90博客,专注于Java EE、Android、系统架构、Linux和网络安全">
<META NAME="keywords" CONTENT="java,java ee,android,系统架构,Linux,网络安全">
<title>{TheBlogTitle} - {SmallTitle}</title>
<link href="style" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" style="table-layout:fixed; word-break:break-all">
<TABLE width=870 border=0 align="center" cellPadding=0 cellSpacing=0>
  <TR>
    <TD><DIV style="FONT-SIZE: 18px; MARGIN: 25px 0px 7px; FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;font-weight: bolder;"><A href="./">Awen(阿文)'s Blog</A></DIV>
        <FONT color="#404040" style="FONT-FAMILY: Georgia, verdana, Arial, Helvetica, sans-serif;">专注于Java EE、Android、系统架构、Linux和网络安全</FONT></TD>
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
      href=""><B>RSS</B></A> | <A 
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
<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- 左侧中间部分开始 -->
<table width="98%" border="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="40"><font class="title"><img src="img/at" border="0"></font></td>
          <td class="title">${currentrizhi.title}</td>
        </tr>
      </table>
        <font color="#777777" class="f11">Submitted by <a href="mailto:youname@domain.com"><b>${currentrizhi.user.name}</b></a> on
        <s:date name="currentrizhi.time"/></font>
        <s:iterator value="currentrizhi.sorts" id="ss">
         <b><a href="!sort?sortid=${ss.sortid}">${ss.name}</a></b>
         </s:iterator>
         </td>
  </tr>
  <tr>
    <td style="padding-top: 15px;padding-bottom: 15px;"> <SPAN style="DISPLAY: inline! important; FLOAT: none; WORD-SPACING: 0px; FONT: 14px/25px 微软雅黑, Tahoma, Verdana, 宋体; TEXT-TRANSFORM: none; COLOR: rgb(0,0,0); TEXT-INDENT: 0px; WHITE-SPACE: normal; LETTER-SPACING: normal; BACKGROUND-COLOR: rgb(255,255,255); orphans: 2; widows: 2; -webkit-text-size-adjust: auto; -webkit-text-stroke-width: 0px">${currentrizhi.content}</SPAN></td>
  </tr>
  <tr>
    <td style="padding-top: 15px;padding-bottom: 15px;"></td>
  </tr>
</table>
<TABLE cellSpacing=0 cellPadding=0 width="96%" align="center" border=0>
  <TR>
    <TD height=20><a name="#comment"></a></TD>
  </TR>
</TABLE>
<table width="100%" border="0">
  <tr>
    <td width="38"><font class="title"><img src="img/at" border="0"></font></td>
    <td class="title">评论</td>
  </tr>
</table>
<TABLE width="98%" border="0" cellPadding="0" cellSpacing="0">
  <TR>
    <TD height="10"></TD>
  </TR>
  <TR>
    <TD style="BACKGROUND-IMAGE: url(img/dot_width)" height="1"></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>
</TABLE>
<table width="98%" border="0" style="table-layout:fixed; word-break:break-all">
	<!--一个评论单元开始-->
	<s:iterator value="currentcommen" id="cc" status="st">
  <tr>
    <td height="5"></td>
  </tr>

  <tr>
    <td><a name="cm${st.index+1}"></a>${cc.content}</td>
  </tr>
  <s:if test="#cc.back_content!=null">
  <tr>
    <td>站长回复:</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${cc.back_content}</td>
  </tr>
  </s:if>
  <TR>
    <TD height="20"></TD>
  </TR> 
  <tr>
    <td align="right"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td align="right" class="f11"><font color="#7C7C7C">Post by <a href="mailto:youname@domaincom">${cc.author}</a> <s:date name="#cc.time"/></font></td>
        <td width="30" align="right" nowrap class="f11"># <strong>${st.index+1}</strong></td>
      </tr>
    </table>      
    </td>
  </tr>
  <TR>
    <TD height="20"></TD>
  </TR>
  <TR>
    <TD style="BACKGROUND-IMAGE: url(img/dot_width)" height="1"></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>
  </s:iterator>
  <!--一个评论单元结束-->


  <TR>
    <TD height="20"></TD>
  </TR>
  <TR>
    <TD height="20"></TD>
  </TR>

</table>


<script language="JavaScript">
function ProcessArticle(){
	if(document.form.author.value == ''){
		alert('请输入您的名字');
		document.form.author.focus();
		return false;
	}
	if(document.form.content.value == ''){
		alert('请输入评论内容');
		return false;
	}
		return true;
}
var ValidationPassed = true;
function submitonce(theform) {	
	if (document.all||document.getElementById) {
		for (i=0;i<theform.length;i++) {
			var tempobj=theform.elements[i];
			if(tempobj.type.toLowerCase()=="submit"||tempobj.type.toLowerCase()=="reset") {
				tempobj.disabled=true;
			}
		}
	}
}
function ctlkey() {
	if(event.ctrlKey && window.event.keyCode==13) {
		submitonce(document.form);
		if(ValidationPassed) {
			document.form.submit();
		}
	}
	if(event.altKey && (window.event.keyCode==83 || window.event.keyCode==115)) {
		submitonce(document.form);
		if(ValidationPassed) {
			document.form.submit();
		}
	}
}
var ie = (document.all) ? true :false
if (ie)	{
	window.document.onkeydown=ctlkey;
}
</script>
<table width="98%" border="0">
  <tr>
    <td width="38"><font class="title"><img src="img/at" border="0"></font></td>
    <td class="title">添加评论</td>
    <td align="right"><font color="#7C7C7C">已经有 ${currentrizhi.commens.size()} 人参与评论</font></td>
  </tr>
</table>
<TABLE width="98%" border="0" cellPadding="0" cellSpacing="0">
  <TR>
    <TD height="10"></TD>
  </TR>
</TABLE>
<table width="96%" border="0" cellpadding="0" cellspacing="10">
  <form action="!show?blogid=${currentrizhi.rizhiid}" method="post" name="form" onSubmit="return ProcessArticle()">
      <tr>
        <td>您的名字:<br><input name="author" type="text" size="50" maxlength="20"  value="" class="formfield"></td></tr>
      <tr>
        <td>您的E-mail:<br><input name="email" type="text" size="50" maxlength="100"  value="" class="formfield"></td></tr>
      <tr>
        <td>评论内容:<br><textarea name="content" cols="80" rows="8" class="formfield"></textarea></td></tr>
      <tr>
        <td>
          <input type="submit" value="submit" class="formbutton">
        【
        Alt+S 或 Ctrl+Enter 快速提交 】</td>
      </tr>
  </form>
</table>
<!-- 左侧中间部分结束 -->
<!-- //////////////////////////////////////////////////////////////////////////////////////////////////////// -->

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
				<!-- END RowNewBlog --></TD>
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
                  <!-- BEGIN RowLink -->
                  <s:iterator value="links" id="ll">
                  	<a href="${ll.url}" target="_blank" title="${ll.description}">${ll.sitename}</a><br>
                  </s:iterator>
                  <!-- END RowLink -->
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
<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>My Blog</title>
<meta content="text/html; charset=gb2312" http-equiv="Content-Type">
<link rel="stylesheet" href="./cp" type="text/css">
<link rel="stylesheet" href="./editor/themes/default/default.css" />
<link rel="stylesheet" href="./editor/plugins/code/prettify.css" />
</head>
<body leftmargin="20" topmargin="20" marginwidth="20" marginheight="20"  style="table-layout:fixed; word-break:break-all">
<script language="JavaScript">
	function ProcessArticle(){
		if(document.form.title.value == ''){
			alert('请输入标题.');
			document.form.title.focus();
			return false;
		}
		if(document.form.sortid.value == ''){
			alert('请选择分类.');
			document.form.sortid.focus();
			return false;
		}
		if(document.form.content.value == ''){
			alert('请输入内容.');
			return false;
		}
			return true;
	}
</script>
<script charset="utf-8" src="./editor/kindeditor.js"></script>
<script charset="utf-8" src="./editor/lang/zh_CN.js"></script>
<script charset="utf-8" src="./editor/plugins/code/prettify.js"></script>
<script>
		var editor;
		
		KindEditor.ready(function(K) {
			var options = {
					cssPath : './editor/plugins/code/prettify.css',
					uploadJson : './editor/jsp/upload_json.jsp',
					fileManagerJson : './editor/jsp/file_manager_json.jsp',
					allowFileManager : true,
			        filterMode : true
			};
			editor = K.create('textarea[name="content"]', options);
			
		});
		function submit0()
		{
			// 取得HTML内容
			html = editor.html();

			// 同步数据后可以直接取得textarea的value
			editor.sync();
			html = document.getElementById('editor_id').value; // 原生API
			html = K('#editor_id').val(); // KindEditor Node API
			html = $('#editor_id').val(); // jQuery

			// 设置HTML内容
			editor.html('HTML内容');
		}
	</script>
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder">		
<table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form name="form" action="admin_add_article_action" method="post" onSubmit="return submit0()">
<tr id="cat">
	<td class="tblhead" colspan="2"><b>添加文章</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td>文章标题:</td>
	<td><input class="formfield" type="text" name="title" size="35" maxlength="50" value="" ></td>
</tr>
<tr class="secondalt">
<td>选择分类:</td>
<td>
<s:iterator value="sortslist">
	<input type="checkbox" name="sortid" value ="<s:property value="sortid"/>" ><s:property value="name"/>
</s:iterator>
</select>
</td>
</tr>
<tr class="firstalt" nowrap>
	<td valign="top">文章描述:<br>不支持HTML<br><br>如果不写就在首页显示全部内容</td>
	<td><textarea class="formfield" type="text" name="description" cols="80" rows="7" ></textarea></td>
</tr>
<tr class="secondalt" nowrap>
	<td valign="top">文章内容:</td>
	<!-- 正文输入框 -->
	<td><textarea id="editor_id" name="content" style="width:700px;height:300px;">
	</textarea></td>
</tr>
</td></tr>
<tr class="firstalt">
	<td valign="top">是否允许访客对本文进行评论?</td>
	<td><select name="iscomment". >
<option value="1" selected class="">是</option>
<option value="0" class="">否</option>
</select>
</td></tr>
<tr class="secondalt">
	<td valign="top">显示?</td>
	<td><select name="visible". >
<option value="1" selected class="">是</option>
<option value="0" class="">否</option>
</select>
</td></tr>
<tr class="firstalt">
	<td valign="top">置顶?</td>
	<td><select name="stick". >
<option value="1" class="">是</option>
<option value="0" selected class="">否</option>
</select>
</td></tr>
<tr class="secondalt" nowrap>
	<td>附件:<br>最大允许:1048576字节</td>
	<td><input class="formfield" type="file" name="attachment" ></td>
</tr>
<input type="hidden" name="action" value="addblog">
<input type="hidden" name="author" value="testU">
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
<br></body>
</html> 
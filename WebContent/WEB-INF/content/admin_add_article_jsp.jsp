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
			alert('���������.');
			document.form.title.focus();
			return false;
		}
		if(document.form.sortid.value == ''){
			alert('��ѡ�����.');
			document.form.sortid.focus();
			return false;
		}
		if(document.form.content.value == ''){
			alert('����������.');
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
			// ȡ��HTML����
			html = editor.html();

			// ͬ�����ݺ����ֱ��ȡ��textarea��value
			editor.sync();
			html = document.getElementById('editor_id').value; // ԭ��API
			html = K('#editor_id').val(); // KindEditor Node API
			html = $('#editor_id').val(); // jQuery

			// ����HTML����
			editor.html('HTML����');
		}
	</script>
<table cellpadding="0" cellspacing="0" border="0" align="center" width="96%" class="tblborder">
<tr>
<td class="tdborder">		
<table width="100%" align="center" border="0" cellspacing="1" cellpadding="4">
<form name="form" action="admin_add_article_action" method="post" onSubmit="return submit0()">
<tr id="cat">
	<td class="tblhead" colspan="2"><b>�������</b></td>
</tr>
<tr class="firstalt" nowrap>
	<td>���±���:</td>
	<td><input class="formfield" type="text" name="title" size="35" maxlength="50" value="" ></td>
</tr>
<tr class="secondalt">
<td>ѡ�����:</td>
<td>
<s:iterator value="sortslist">
	<input type="checkbox" name="sortid" value ="<s:property value="sortid"/>" ><s:property value="name"/>
</s:iterator>
</select>
</td>
</tr>
<tr class="firstalt" nowrap>
	<td valign="top">��������:<br>��֧��HTML<br><br>�����д������ҳ��ʾȫ������</td>
	<td><textarea class="formfield" type="text" name="description" cols="80" rows="7" ></textarea></td>
</tr>
<tr class="secondalt" nowrap>
	<td valign="top">��������:</td>
	<!-- ��������� -->
	<td><textarea id="editor_id" name="content" style="width:700px;height:300px;">
	</textarea></td>
</tr>
</td></tr>
<tr class="firstalt">
	<td valign="top">�Ƿ�����ÿͶԱ��Ľ�������?</td>
	<td><select name="iscomment". >
<option value="1" selected class="">��</option>
<option value="0" class="">��</option>
</select>
</td></tr>
<tr class="secondalt">
	<td valign="top">��ʾ?</td>
	<td><select name="visible". >
<option value="1" selected class="">��</option>
<option value="0" class="">��</option>
</select>
</td></tr>
<tr class="firstalt">
	<td valign="top">�ö�?</td>
	<td><select name="stick". >
<option value="1" class="">��</option>
<option value="0" selected class="">��</option>
</select>
</td></tr>
<tr class="secondalt" nowrap>
	<td>����:<br>�������:1048576�ֽ�</td>
	<td><input class="formfield" type="file" name="attachment" ></td>
</tr>
<input type="hidden" name="action" value="addblog">
<input type="hidden" name="author" value="testU">
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
<br></body>
</html> 
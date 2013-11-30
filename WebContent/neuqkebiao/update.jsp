<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="org.json.*" %>
<%

JSONObject json = new JSONObject();
Map describe = new HashMap();
String editionNumber = "1.0.0";
String downloadURL = "http://m90.me/neuqkebiao/neuqkebiao.apk";
describe.put("1. ", "1.0.0版本发布，内置了全校的班级课表，方便师生使用");
describe.put("2. ", "兼容版本为安卓4.0及以上版本");
json.put("editionNumber",editionNumber);
json.put("downloadURL", downloadURL);
json.put("describe", describe);
out.println(json.toString());
%>

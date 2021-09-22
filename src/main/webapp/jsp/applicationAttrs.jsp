<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>UTF-8</title>
<%
  String appName = application.getAttribute("appName").toString();
%>
</head>
<body>
system.app-name 
<%=appName%>
</body>
</html>
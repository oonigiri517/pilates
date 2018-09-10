<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Lesson" %>
<%
Lesson les1=(Lesson)request.getAttribute("lesson1");
Lesson les2=(Lesson)request.getAttribute("lesson2");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>レッスン履歴照会画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
<form action="/Pilates/Output" method="post">
	<input type="date" name="lesson1"  >
～
	<input type="date" name="lesson2" >

   <input type="submit" value="送信">
   <input type="hidden" value="1"  name="page">
</form>
<%if((les1!=null)&&(les2!=null)){ %>
<%=les1.getDate() %>～
<%=les2.getDate() %>
<%} %>
</body>
</html>
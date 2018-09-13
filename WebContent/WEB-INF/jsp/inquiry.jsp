<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Lesson"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Lesson les1 = (Lesson) request.getAttribute("lesson1");
	Lesson les2 = (Lesson) request.getAttribute("lesson2");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>レッスン履歴照会画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="form-wrapper">
		<c:if test="${not empty msg}">
			<p><font color=red>${msg}</font></p>
		</c:if>

		<h1>履歴照会</h1>

		<form action="/Pilates/Output" method="post">
			<input type="date" name="lesson1"> ～ <input type="date" name="lesson2">
			<div class="button-panel">
				<input type="hidden" value="1" name="page">
				<input type="submit" name="submit" class="button" title="送信" value="出力"><br><br>
				<input value="戻る" onclick="history.back();" class="button" type="button">
			</div>
		</form>
		<%
			if ((les1 != null) && (les2 != null)) {
		%>
		<%=les1.getDate()%>～
		<%=les2.getDate()%>
		<%
			}
		%>
		<br> <br>
	</div>
</body>
</html>
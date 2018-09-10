<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>レッスン予定日編集画面</title>
</head>
<body>

	<div class="form-wrapper" align="center">
		<h1>レッスン予定日編集画面</h1>
		<p>日付を選択してください</p>
		<br>
		<form action="get">
			<select name="date">
				<option value="2018">2018年</option>
				<option value="2019">2019年</option>
				<option value="2020">2020年</option>
				<option value="2021">2021年</option>
				<option value="2022">2022年</option>
				<option value="2023">2023年</option>
			</select> <select name="month">
				<%
					for (int i = 1; i <= 12; i++) {
				%>
				<option value="i"><%=i%></option>
				<%
					}
				%>
			</select> <select name="day">
				<%
					for (int y = 1; y <= 31; y++) {
				%>
				<option value="y"><%=y%></option>
				<%
					}
				%>

			</select> <select name="time">
				<%
					for (int g = 1; g <= 24; g++) {
				%>
				<option value="g"><%=g%></option>
				<%
					}
				%>
			</select> <br> <br>
			<div class="button-panel">
				<input type="submit" class="button" title="送信" value="送信">
			</div>
			<br> <br>
		</form>
	</div>
</body>
</html>
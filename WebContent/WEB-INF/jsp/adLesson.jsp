<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
<title>レッスン予定日編集画面</title>
</head>
<body>

	<div class="form-wrapper" align="center">
		<h1>レッスン予定日編集画面</h1>
		<p>レッスン予定日変更（追加・削除）</p>
		<br>
		<form action="/servlet/EditLesson" method="post">
			<input type="date" name="lesson"> <br> <br> <select
				id="time">
				<%
					for (int i = 1; i <= 24; i++) {
				%>
				<option value="i"><%=i%>時
				</option>
				<%
					}
				%>
			</select> <br>
			<div class="button-panel">
				<input type="submit" class="button" title="追加" value="追加"> <br>
				<br> <input type="submit" class="button" title="送信" value="削除">
			</div>
		</form>
		<br> <br>


		<p>レッスン枠追加 日付選択</p>
		<br>
		<form action="/servlet/EditLesson" method="post">
			<input type="date" name="lesson"> <input type="date"
				name="name2"> <br> <br>
			<div class="button-panel">
				<input type="submit" class="button" title="送信" value="追加">
			</div>
			<br> <br>

		</form>
	</div>
</body>
</html>
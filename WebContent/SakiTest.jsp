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
		<form action="/servlet/EditLesson" method="post">
			<input type="date" name="lesson"> <input type="date"
				name="name2"> <br> <br>
			<div class="button-panel">
				<input type="submit" class="button" title="送信" value="送信">
			</div>
			<br> <br>

		</form>
	</div>
</body>
</html>
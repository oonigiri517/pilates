<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Pilatise管理画面</title>
</head>
<body>
<h1>レッスン予定日編集</h1>
	<p>希望の操作を選択してください</p>
	<form action="/Pilates/Admin" method="get">
	<p><input type="button" value="レッスン予定日編集" onclick="/Pilates/adLesson.jsp"></p>
	<p><input type="button" value="予約キャンセル" onclick="#"></p>
	<p><input type="button" value="予約履歴" onclick="#"></p>
	<p><input type="button" value="顧客一覧" onclick="#"></p>
	<br></br>
    <p><input type="button" value="TOPへ戻る" onclick="/Pilates/login.jsp"></p>
<a href="/Pilates/login.jsp">TOPへ</a>
</form>
</body>
</html>
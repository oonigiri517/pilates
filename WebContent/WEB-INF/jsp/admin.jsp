<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>管理画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />


</head>
<body>
	<div class="form-wrapper" align="center">
		<h1>各種変更一覧</h1>
		<br>
		<p>希望の操作を選択してください</p>
		<br>
		<div class="button-panel">
		<form action="/Pilates/Admin" method="post">
		<input type="submit" name="submit" class="button" value="レッスン日編集"><br><br>
		<input type="submit" name="submit" class="button" value="予約キャンセル"><br><br>
		<input type="submit" name="submit" class="button" value="予約履歴"><br><br>
		</form>

		<form action="/Pilates/Output" method="post">
		<input type="submit" class="button" value="顧客一覧"><br><br>
		</form>
		</div>
		<br> <br>

	</div>
</body>
</html>
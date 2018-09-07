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
		<ul>
			<li><a href="/Pilates/Admin?page=l1">レッスン予定日編集画面</a></li>
			<li><a href="/Pilates/Admin?page=l2">予約キャンセル</a></li>
			<li><a href="/Pilates/Admin?page=l3">予約履歴</a></li>
			<li><a href="/Pilates/Output">顧客一覧</a></li>
		</ul>
		<br> <br>
		<ul>
			<li><a href="#">Topへ</a></li>
		</ul>
		<br> <br>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>予約キャンセル画面</title>
</head>
<body>
<h1>予約キャンセル</h1>
<br></br>
<form action="/Pilates/Reservation.java" method="post">
予約番号入力 ※半角小文字
<br></br>
<input type="text" name = "number">
予約済日時入力 ※半角小文字
<br></br>
<input type="text" name = "date">
メールアドレス入力
<br></br>
<input type="text" name = "addres">
<input type="submit" value="送信">

</form>

</body>
</html>
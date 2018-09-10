<<<<<<< Updated upstream
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>予約キャンセル画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>

<body>
	<div class="form-wrapper" align="center">
		<h1>予約キャンセル</h1>
		<br></br>
		<form action="/Pilates/Reservation.java" method="post">
			<div class="form-item">
				<label for="予約番号 ※半角小文字"></label> <input type="text" name="number"
					required="required" placeholder="予約番号入力 ※半角小文字"></input>
			</div>
			<div class="form-item">
				<label for="予約済日時入力 ※半角小文字"></label> <input type="text" name="date"
					required="required" placeholder="予約済日時入力 ※半角小文字"></input>
			</div>
			<div class="form-item">
				<label for="メールアドレス"></label> <input type="text" name="addres"
					required="required" placeholder="メールアドレス入力"></input>
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="実行" value="Cancel"></input>
			</div>
			<br>
		</form>
	</div>
</body>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>予約キャンセル画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>

<body>
	<div class="form-wrapper" align="center">
		<h1>予約キャンセル</h1>
		<br></br>
		<form action="/Pilates/Reservation.java" method="post">
			<div class="form-item">
				<label for="予約番号 ※半角小文字"></label> <input type="text" name="number"
					required="required" placeholder="予約番号入力 ※半角小文字"></input>
			</div>
			<div class="form-item">
				<label for="予約済日時入力 ※半角小文字"></label> <input type="text" name="date"
					required="required" placeholder="予約済日時入力 ※半角小文字"></input>
			</div>
			<div class="form-item">
				<label for="メールアドレス"></label> <input type="text" name="addres"
					required="required" placeholder="メールアドレス入力"></input>
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="実行" value="Cancel"></input>
			</div>
			<br>
		</form>
	</div>
</body>

>>>>>>> Stashed changes
</html>
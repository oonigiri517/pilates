<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>Relax Pilates 管理画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
=======
<<<<<<< Updated upstream
<title>Pilatise管理画面</title>
</head>
<body>
<h1>Pilates管理画面</h1>
<form action="/Pilates/Login" method="post">
ユーザー名:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
=======
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>Relax Pilates 管理画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
>>>>>>> master
	<div class="form-wrapper">
		<h1>Sign In</h1>

		<form action="/Pilates/Login" method="post">
			<div class="form-item">
				<label for="username"></label> <input type="text" name="name"
<<<<<<< HEAD
					 placeholder="User name"></input>
			</div>
			<div class="form-item">
				<label for="password"></label> <input type="password"
					name="pass"  placeholder="Password"></input>
=======
					required="required" placeholder="User name"></input>
			</div>
			<div class="form-item">
				<label for="password"></label> <input type="password"
					name="password" required="required" placeholder="Password"></input>
>>>>>>> master
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="Sign In" value="Sign In"></input>
			</div>
		</form>
		<div class="form-footer">
			<p></p>
			<p></p>
		</div>
	</div>
<<<<<<< HEAD
=======
>>>>>>> Stashed changes
>>>>>>> master
</body>
</html>





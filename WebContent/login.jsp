<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/login.css" type="text/css" rel="stylesheet" />
<title>ピラティススタジオ | Relax Pilates 管理画面</title>
</head>
<body>
<div class="form-wrapper">
  <h1>Sign In</h1>

  <form action="/Pilates/Login" method="post">
    <div class="form-item">
      <label for="email"></label>
      <input type="text" name="name" required="required" placeholder="User name"></input>
    </div>
    <div class="form-item">
      <label for="password"></label>
      <input type="password" name="password" required="required" placeholder="Password"></input>
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
</body>
</html>


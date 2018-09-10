<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Cancel"%>
<%
	Cancel cancel = (Cancel) session.getAttribute("cancel");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<link href="css/admin.css" type="text/css" rel="stylesheet" />
<title>予約キャンセル確認画面</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="form-wrapper">
		<h1>以下の予約を取り消します</h1>
		<p>よろしいですか？</p>
		<p>
		予約番号:<%=cancel.getNumber()%><br> 予約日時:<%=cancel.getDate()%><br>
		メールアドレス:<%=cancel.getMail()%><br>
		</p>
	</div>
</body>
</html>
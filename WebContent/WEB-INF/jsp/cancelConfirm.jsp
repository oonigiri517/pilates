<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Cancel" %>
<%
Cancel cansel = (Cancel) session.getAttribute("cancel");
%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>予約キャンセル確認画面</title>
</head>
<body>
<p>下記の予約を取り消します。</p>
</p>
予約番号:<%= cancel.getNumber() %><br>
予約日時:<%= cancel.getDate() %><br>
メールアドレス:<%= cancel.getMail() %><br>
</p>
</body>
</html>
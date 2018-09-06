<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Pilatise管理画面</title>
<style>
li{
  border: 1px solid #222;
  width: 200px;
  margin-bottom: 5px;
  list-style: none;
  background-color: green;
  color:white;

}
a:active {
  color:white;
  text-decoration: none;
}
a:link {
  color:white;
  text-decoration: none;

}
a:visited {
  color:white;
  text-decoration: none;

}

</style>
</head>
<body>
<h1>レッスン予定日編集</h1>
<ul>
<li><a href="/Pilates/Admin?page=l1">レッスン予定日編集画面</a></li>
<li><a href="/Pilates/Admin?page=l2">予約キャンセル</a></li>
<li><a href="/Pilates/Admin?page=l3">予約履歴</a></li>
<li><a href="/Pilates/Output">顧客一覧</a></li>
</ul>
</body>
</html>
<!-- 確認画面(行く先はReserve.java(servlet)) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ReserveData,model.Color,java.util.HashMap" %>
<%
ReserveData reserveData=(ReserveData) session.getAttribute("reserveData");
Color color=new Color();
HashMap<String,String> emsRsv = (HashMap<String,String>)request.getAttribute("emsRsv");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ピラティススタジオ | Relax Pilates 確認画面</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link href="css/reset.css" type="text/css" rel="stylesheet" />
	<link href="css/common.css" type="text/css" rel="stylesheet" />
	<link href="css/menu.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>

	<jsp:include page="/menu.jsp"/>

<!-- css使う文 -->
<link rel="stylesheet" href="css/formConfirm.css">
</head>
<body>
<div id="wrapper">
<h2>確認画面</h2>

<%
if(emsRsv != null && emsRsv.size()>0){
	if(emsRsv.containsKey("reserved")){
		out.print(emsRsv.get("reserved"));
	}
}
%>

<form action="/Pilates/Reserve" method="post">

<table>
<tr>
<th>姓</th>
<td><%=reserveData.getFamily_name() %></td>
</tr>

<tr>
<th>名</th>
<td><%=reserveData.getFirst_name() %></td>
</tr>

<tr>
<th>メールアドレス</th>
<td><%=reserveData.getMail() %></td>
</tr>

<tr>
<th>確認用</th>
<td><%=reserveData.getConfMail() %></td>
</tr>

<tr>
<th>電話番号</th>
<td><%=reserveData.getTel() %></td>
</tr>

<tr>
<th>備考</th>
<td><%=reserveData.getMemo() %></td>
</tr>
</table>
<div class="kakutei">
<input type="submit" value="確定" class="button">



<span class="button">
<a href="/Pilates/Form?action=cancel">キャンセル</a></span>
</div>


</form>

</div>
<footer>
<jsp:include page="/footer.jsp"/>
</footer>
</body>
</html>
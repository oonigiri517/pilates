<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" import="model.CalSchedule"
	import="model.Schedule" import="bo.LessonLogic"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ピラティススタジオ | Relax Pilates</title>
	<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link href="css/reset.css" type="text/css" rel="stylesheet" />
	<link href="css/common.css" type="text/css" rel="stylesheet" />
	<link href="css/menu.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>

	<jsp:include page="/menu.jsp"/>
</head>
<style type="text/css">
p {	width: 100%;}

p.example {	line-height: 50%;}
table {width:45%;
	  margin:2%
	  }
td.nakami{height:5em;}
</style>
<body>
	<div id="main">
		<div id="mainInner">
			<h2><img src="images/menuTtl4.png" width="210" height="60" alt="Menu メニュー" /></h2>
		</div>
	<!-- #main -->
	</div>

	<div id="contentsArea" class="clearfix">
			<div id="contentsInner">
			<div id="wrapper">

	<!-- 当月分カレンダー作成情報の生成 -->
	<%
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = 1;
		cal.set(year, month, day);
		int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	%>
    <div style="display:flex;">


	<table border='1'>
	<!-- 当月分年月日表示部分 -->
	<caption><%=year%>年<%=month + 1%>月</caption>
	<tr>
	<%String[] week = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };%>

	<!-- 当月分曜日表示欄 -->
	<%for (int i = 0; i < 7; i++) {%>
		<td bgcolor="blue" align="center"><font color="white"><%=week[i]%></font></td>
	<%}%>
	<tr>

		<!-- 当月分日付表示部分のテーブル作成 -->
		<%for (int i = 0; i < weekday; i++) {%>
			<td></td>
		<%}%>

		<!-- 当月分日付表示部分のループ開始 -->
		<%for (int d = 1; d <= maxDate; d++) {
			if ((d + weekday - 1) % 7 == 0) {%>
				</tr><tr>
			<%}%>
			<td align="center"<%if((d + weekday - 1) % 7 == 0){%>bgcolor="#ff9999"<%} %>><%=d%><br/>
			<table><tr><td class="nakami">
			<%	LessonLogic SLC = new LessonLogic();
				Schedule SLL = SLC.showSchedule(d);
				String[] SL = SLL.getSchedule();
				int sll = SL.length;
				System.out.println(sll);
			%>

			<!-- 休みor締切のとき -->
			<%if (sll == 3) {%>
				<pre><%=SL[2]%></pre>

			<!-- レッスンが1回の時 -->
			<%} else if (sll == 4) {%>
				<%if (SL[3] == "満員") {%>
					<pre><%=SL[2]%><br>
					<%=SL[3]%></pre>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>"><br>
						<pre><%=SL[3]%></pre>
					</form>
				<%} %>

			<!-- レッスンが2回ある時 -->
 			<%} else if (sll == 6) {%>

 				<!-- 1回目 -->
 				<%if (SL[3] == "満員") {%>
 					<pre><%=SL[2]%><br>
 					<%=SL[3]%></pre>
 				<%}else {%>
 					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>"><br>
						<pre><%=SL[3]%></pre>
					</form>
				<%}%>

				<!-- 2回目 -->
				<%if (SL[5] == "満員") {%>
					<pre><%=SL[4]%><br>
					<%=SL[5]%></pre>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
					<input type="hidden" name="YMD" value="<%=DAYS%>">
					<input type="hidden" name="TIME" value="<%=SL[4]%>">
					<input type="submit" name="LT" value="<%=SL[4]%>"><br>
					<pre><%=SL[5]%></pre>
					</form>
				<%}%>
			<%}%>
		</td></tr></table>
	<%}%></tr></table>
	<!-- 当月分日付表示部分のループ終了 -->


	<!-- 翌月分カレンダー作成情報の生成 -->
	<%
		Calendar cal2 = Calendar.getInstance();
		int year2 = cal2.get(Calendar.YEAR);
		cal2.add(Calendar.MONTH, 1);
		int month2 = cal2.get(Calendar.MONTH);
		int day2 = 1;
		cal2.set(year2, month2, day2);
		int weekday2 = cal2.get(Calendar.DAY_OF_WEEK) - 1;
		int maxDate2 = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
	%>




	<table border='1'>
	<!-- 翌月分年月日表示部分 -->
	<caption><%=year%>年<%=month2 + 1%>月</caption>
	<tr>
	<%String[] week2 = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };%>

	<!-- 翌月分曜日表示欄 -->
	<%for (int i = 0; i < 7; i++) {%>
		<td bgcolor="blue" align="center"><font color="white"><%=week2[i]%></font></td>
	<%}%>
	<tr>

		<!-- 翌月分日付表示部分のテーブル作成 -->
		<%for (int i = 0; i < weekday2; i++) {%>
			<td></td>
		<%}%>

		<!-- 翌月分日付表示部分のループ開始 -->
		<%for (int d = 1; d <= maxDate2; d++) {
			if ((d + weekday2 - 1) % 7 == 0) {%>
				</tr><tr>
			<%}%>
			<td align="center"<%if((d + weekday2 - 1) % 7 == 0){%>bgcolor="#ff9999"<%} %>><%=d%><br/>
			<table><tr><td class="nakami">
			<%	LessonLogic SLC = new LessonLogic();
				Schedule SLL = SLC.showSchedule2(d);
				String[] SL = SLL.getSchedule();
				int sll = SL.length;
				System.out.println(sll);
			%>

			<!-- 休みor締切のとき -->
			<%if (sll == 3) {%>
				<pre><%=SL[2]%></pre>
			<!-- レッスンが1回の時 -->
			<%} else if (sll == 4) {%>
				<%if (SL[3] == "満員") {%>
					<pre><%=SL[2]%><br>
					<%=SL[3]%></pre>
				<%} else { %>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>"><br>
						<pre><%=SL[3]%></pre>
					</form>
				<%}%>

			<!-- レッスンが2回ある時 -->
			<%} else if (sll == 6) {%>

				<!-- 1回目 -->
				<%if (SL[3] == "満員") {%>
					<pre><%=SL[2]%><br>
					<%=SL[3]%></pre>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>"><br>
						<pre><%=SL[3]%></pre>
					</form>
				<%}%>

				<!-- 2回目 -->
				<%if (SL[5] == "満員") {%>
					<%=SL[4]%><br>
					<%=SL[5]%>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[4]%>">
						<input type="submit" name="LT" value="<%=SL[4]%>"><br>
						<pre><%=SL[5]%></pre>
					</form>
				<%}%>
			<%}%>
		</td></tr></table></td>
	<%}%></tr></table>
	</div>
	<!-- 翌月分日付表示部分のループ終了 -->
	</div></div></div>
<footer>
<jsp:include page="/footer.jsp"/>
</footer>
</body>
</html>
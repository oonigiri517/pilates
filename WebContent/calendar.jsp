<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"
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
	<link href="css/calendar.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/function.js"></script>

	<jsp:include page="/menu.jsp"/>
</head>
<body>
		<div id="main">
			<div id="mainInner">
				<h2><img src="images/menuTtl4.png" width="210" height="60" alt="Menu メニュー" /></h2>
			</div>
		<!-- #main --></div>
<div class="contentsInner">
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


	<table class="calendar" border='1'>
	<!-- 当月分年月日表示部分 -->
	<caption><%=year%>年<%=month + 1%>月</caption>
	<tr>
	<%String[] week = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };%>

	<!-- 当月分曜日表示欄 -->
	<%for (int i = 0; i < 7; i++) {%>
		<td bgcolor="#A7F1FF" align="center"><font color="#fff"><%=week[i]%></font></td>
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
			<td style="height:4em"align="center"valign="top"<%if((d + weekday - 1) % 7 == 0){%>bgcolor="#ff9999"<%} %>>
			<p class="hiduke"><%=d%></p>
			<table><tr><td class="nakami">
			<%	LessonLogic SLC = new LessonLogic();
				Schedule SLL = SLC.showSchedule(d);
				String[] SL = SLL.getSchedule();
				int sll = SL.length;
				System.out.println(sll);
			%>

			<!-- 休みor締切のとき -->
			<%if (sll == 3) {%>
				<%=SL[2]%>

			<!-- レッスンが1回の時 -->
			<%} else if (sll == 4) {%>
				<%if (SL[3] == "FULL") {%>

					<%=SL[3]%>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>">
						<%=SL[3]%>
					</form>
				<%} %>

			<!-- レッスンが2回ある時 -->
 			<%} else if (sll == 6) {%>

 				<!-- 1回目 -->
 				<%if (SL[3] == "FULL") {%>
 				<%=SL[3]%><br>
 				<%}else {%>
 					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>">
						<%=SL[3]%>
					</form>
				<%}%>

				<!-- 2回目 -->
				<%if (SL[5] == "FULL") {%>

					<%=SL[5]%>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year, month+1, d);%>
					<form action="/Pilates/Form" method="get">
					<input type="hidden" name="YMD" value="<%=DAYS%>">
					<input type="hidden" name="TIME" value="<%=SL[4]%>">
					<input type="submit" name="LT" value="<%=SL[4]%>">
					<%=SL[5]%>
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




	<table class="calendar" border='1'>
	<!-- 翌月分年月日表示部分 -->
	<caption><%=year%>年<%=month2 + 1%>月</caption>
	<tr>
	<%String[] week2 = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };%>

	<!-- 翌月分曜日表示欄 -->
	<%for (int i = 0; i < 7; i++) {%>
		<td bgcolor="#A7F1FF" align="center"><font color="white"><%=week2[i]%></font></td>
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
			<td align="center"valign="top"<%if((d + weekday2 - 1) % 7 == 0){%>bgcolor="#ff9999"<%} %>>
			<p class="hiduke"><%=d%></p>
			<table><tr><td class="nakami">
			<%	LessonLogic SLC = new LessonLogic();
				Schedule SLL = SLC.showSchedule2(d);
				String[] SL = SLL.getSchedule();
				int sll = SL.length;
				System.out.println(sll);
			%>

			<!-- 休みor締切のとき -->
			<%if (sll == 3) {%>
				<%=SL[2]%>
			<!-- レッスンが1回の時 -->
			<%} else if (sll == 4) {%>
				<%if (SL[3] == "FULL") {%>

					<%=SL[3]%>
				<%} else { %>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>">
						<%=SL[3]%>
					</form>
				<%}%>

			<!-- レッスンが2回ある時 -->
			<%} else if (sll == 6) {%>

				<!-- 1回目 -->
				<%if (SL[3] == "FULL") {%>

					<%=SL[3]%><br>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[2]%>">
						<input type="submit" name="LT" value="<%=SL[2]%>">
						<%=SL[3]%>
					</form>
				<%}%>

				<!-- 2回目 -->
				<%if (SL[5] == "FULL") {%>
					<%=SL[4]%><br>
					<%=SL[5]%>
				<%} else {%>
					<% String DAYS=String.format("%04d-%02d-%02d", year2, month2+1, d);%>
					<form action="/Pilates/Form" method="get">
						<input type="hidden" name="YMD" value="<%=DAYS%>">
						<input type="hidden" name="TIME" value="<%=SL[4]%>">
						<input type="submit" name="LT" value="<%=SL[4]%>">
						<%=SL[5]%>
					</form>
				<%}%>
			<%}%>
		</td></tr></table></td>
	<%}%></tr></table>
	</div>
	<!-- 翌月分日付表示部分のループ終了 -->
	</div>
	<br>
	<br>
	<br>
	<br>
<footer>
<jsp:include page="/footer.jsp"/>
</footer>
</body>
</html>
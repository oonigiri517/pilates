<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" import="model.CalSchedule"
	import="model.Schedule" import="bo.LessonLogic"%>


<!DOCTYPE html>
<html>
<style type="text/css">
p {
	width: 100%;
}

p.example {
	line-height: 50%;
}
</style>
<body>
	<%
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = 1;
		cal.set(year, month, day);
		int weekday = cal.get(Calendar.DAY_OF_WEEK) - 1;
		int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	%>
	<%=year%>
	<%=month + 1%>
	<table border='1'>
		<tr>
			<%
				String[] week = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };
			%>
			<%
				for (int i = 0; i < 7; i++) {
			%>
			<td bgcolor="blue" align="center"><font color="white"><%=week[i]%></font></td>
			<%
				}
			%>

		<tr>
			<%
				for (int i = 0; i < weekday; i++) {
			%>
			<td></td>
			<%
				}
			%>
			<%
				for (int d = 1; d <= maxDate; d++) {
					if ((d + weekday - 1) % 7 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
			%>
			<td align="center"><%=d%><br />
				<table>

					<tr>
						<td>
							<%
								LessonLogic SLC = new LessonLogic();
									Schedule SLL = SLC.showSchedule(d);
									String[] SL = SLL.getSchedule();
									int sll = SL.length;
									System.out.println(sll);
							%> <%
 	if (sll == 3) {
 %> <%=SL[2]%> <%
 	} else if (sll == 4) {
 %>
							<%
								if (SL[3] == "満員") {
							%> <%=SL[2]%><br> <%=SL[3]%> <%
 	} else {
 %>
 <% String DAYS=String.format("%04d-%02d-%02d", year, month, d);%>
							<form action="/Pilates/Form" method="get">
							<input type="hidden" name="YMD" value="<%=DAYS%>">
							<input type="hidden" name="TIME" value="<%=SL[2]%>">
								<input type="submit" name="LT" value="<%=SL[2]%>">
								<%=SL[3]%></form> <%
 	}
 %> <%
 	} else if (sll == 6) {
 %> <%
 	if (SL[3] == "満員") {
 %> <%=SL[2]%><br>
							<%=SL[3]%> <%
 	} else {
 %>
							<% String DAYS=String.format("%04d-%02d-%02d", year, month, d);%>
                            							<form action="/Pilates/Form" method="get">
                            							<input type="hidden" name="YMD" value="<%=DAYS%>">
                            							<input type="hidden" name="TIME" value="<%=SL[2]%>">
                            								<input type="submit" name="LT" value="<%=SL[2]%>">
								<%=SL[3]%></form> <%
 	}
 %> <%
 	if (SL[5] == "満員") {
 %> <%=SL[4]%><br> <%=SL[5]%>
							<%
								} else {
							%>
<% String DAYS=String.format("%04d-%02d-%02d", year, month, d);%>
							<form action="/Pilates/Form" method="get">
							<input type="hidden" name="YMD" value="<%=DAYS%>">
							<input type="hidden" name="TIME" value="<%=SL[4]%>">
								<input type="submit" name="LT" value="<%=SL[4]%>">							<input type="submit" name="LT" value="<%=SL[4]%>">
								<%=SL[5]%></form> <%
 	}
 %> <%
 	}
 %>
						</td>
					</tr>
					<%--<%}--%>
				</table></td>
			<%
				}
			%>
		</tr>
	</table>
	<%
		Calendar cal2 = Calendar.getInstance();
		int year2 = cal2.get(Calendar.YEAR);
		int month2 = cal2.get(Calendar.MONTH);
		cal2.add(Calendar.MONTH, 1);
		int day2 = 1;
		cal2.set(year2, month2, day2);
		int weekday2 = cal2.get(Calendar.DAY_OF_WEEK) - 1;
		int maxDate2 = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
	%>
	<%=year2%>
	<%=month2 + 1%>
	<table border='1'>
		<tr>
			<%
				String[] week2 = { "Sun", "mon", "Tue", "Wed", "Thu", "Fri", "Sta" };
			%>
			<%
				for (int i = 0; i < 7; i++) {
			%>
			<td bgcolor="blue" align="center"><font color="white"><%=week2[i]%></font></td>
			<%
				}
			%>

		<tr>
			<%
				for (int i = 0; i < weekday2; i++) {
			%>
			<td></td>
			<%
				}
			%>
			<%
				for (int d = 1; d <= maxDate2; d++) {
					if ((d + weekday2 - 1) % 7 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
			%>
			<td align="center"><%=d%><br />
				<table>
					<tr>
						<td>
							<%
								LessonLogic SLC = new LessonLogic();
									Schedule SLL = SLC.showSchedule2(d);
									String[] SL = SLL.getSchedule();
									int sll = SL.length;
									System.out.println(sll);
							%> <%
 	if (sll == 3) {
 %> <%=SL[2]%> <%
 	} else if (sll == 4) {
 %>
							<%
								if (SL[3] == "満員") {
							%> <%=SL[2]%><br> <%=SL[3]%> <%
 	} else {
 %>
<% String DAYS=String.format("%04d-%02d-%02d", year2, month2, d);%>
							<form action="/Pilates/Form" method="get">
							<input type="hidden" name="YMD" value="<%=DAYS%>">
							<input type="hidden" name="TIME" value="<%=SL[2]%>">
								<input type="submit" name="LT" value="<%=SL[2]%>">
															<%=SL[3]%></form> <%
 	}
 %> <%
 	} else if (sll == 6) {
 %> <%
 	if (SL[3] == "満員") {
 %> <%=SL[2]%><br>
							<%=SL[3]%> <%
 	} else {
 %>
<% String DAYS=String.format("%04d-%02d-%02d", year2, month2, d);%>
							<form action="/Pilates/Form" method="get">
							<input type="hidden" name="YMD" value="<%=DAYS%>">
							<input type="hidden" name="TIME" value="<%=SL[2]%>">
								<input type="submit" name="LT" value="<%=SL[2]%>">
							<%=SL[3]%></form> <%
 	}
 %> <%
 	if (SL[5] == "満員") {
 %> <%=SL[4]%><br> <%=SL[5]%>
							<%
								} else {
							%>
<% String DAYS=String.format("%04d-%02d-%02d", year2, month2, d);%>
							<form action="/Pilates/Form" method="get">
							<input type="hidden" name="YMD" value="<%=DAYS%>">
							<input type="hidden" name="TIME" value="<%=SL[4]%>">
								<input type="submit" name="LT" value="<%=SL[4]%>">
								<%=SL[5]%></form> <%}%> <%} %>
						</td>
					</tr>
					<%--<%}--%>
				</table></td>
			<%} %>
		</tr>
	</table>

</body>
</html>
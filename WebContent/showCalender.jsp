<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>


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
		int year = 2018;
		int month = 7;
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
					<%
						for (int i = 1; i <= 4; i++) {
					%>
					<tr>
						<td>
							<form action="post">
								<a
									href="aaaaa.com?y=<%=year%>&m=<%=month + 1%>&d=<%=d%>&class=<%=i%>">
									<img src="./image/fig.jpg" />
								</a>
							</form>
						</td>
					</tr>
					<%}%>
				</table></td>
			<%} %>
		</tr>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.Calendar"
 		  import="model.CalSchedule"
		  import="model.Schedule"
		  import="bo.LessonLogic"
 %>


<!DOCTYPE html>
<html>
<style type="text/css">

p { width: 100%; }

p.example { line-height: 50%; }

</style>
<body>
<%
Calendar cal = Calendar.getInstance();
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int day = 1;
cal.set(year, month, day);
int weekday=cal.get(Calendar.DAY_OF_WEEK)-1;
int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
%>
<%=year%>
<%=month+1%>
<table border='1'>
<tr>
<%String[] week={"Sun","mon","Tue","Wed","Thu","Fri","Sta"}; %>
<%for(int i=0;i<7;i++){%>
	<td bgcolor="blue" align="center" ><font color="white"><%=week[i] %></font></td>
<%}%>
<tr>
<%for(int i=0;i<weekday;i++){%>
	<td></td>
<%}%>
<%for(int d=1;d<=maxDate;d++){
	if((d+weekday-1)%7==0){%>
		</tr><tr>
	<%} %>
	<td align="center">
	<%=d%><br/>
	<table>
	<%--<%for(int i=1;i<=4;i++){--%>
	<tr><td>
	<%
	LessonLogic SLC=new LessonLogic();
	Schedule SLL=SLC.showSchedule(d);
	String[] SL=SLL.getSchedule();
	int sll=SL.length;
	System.out.println(sll);%>
	<%if(sll==3){%>
		<%=SL[2] %>
	<%}else if(sll==4){ %>
		<%if(SL[3]=="満員"){ %>
			<%=SL[2] %><br>
			<%=SL[3]%>
		<%}else{ %>
			<form action="/Pilates/Form" method="get">
			<input type="submit" name="LT" value="<%=SL[2]%>">
			<%=SL[3]%></form>
		<%}%>
	<%}else if(sll==6){ %>
		<%if(SL[3]=="満員"){ %>
			<%=SL[2] %><br>
			<%=SL[3]%>
		<%}else{ %>
			<form action="/Pilates/Form" method="get">
			<input type="submit" name="LT" value="<%=SL[2]%>">
			<%=SL[3]%></form>
		<%}%>
		<%if(SL[5]=="満員"){ %>
			<%=SL[4] %><br>
			<%=SL[5] %>
		<%}else{ %>
			<form action="/Pilates/Form" method="get">
			<input type="submit" name="LT" value="<%=SL[4]%>">
			<%=SL[5]%></form>
		<%}%>

		<%} %>
	</td></tr>
	<%--<%}--%>
	</table>
	</td>
<%} %>
</tr>
</table>

</body>
</html>
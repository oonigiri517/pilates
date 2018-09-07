<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.CalendarLogic"
import="java.util.Calendar"
import="bo.LessonLogic"
import="model.Schedule"

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%CalendarLogic CalLog=new CalendarLogic();%>
<%=CalLog.calendarLogic()%>

</body>
</html>
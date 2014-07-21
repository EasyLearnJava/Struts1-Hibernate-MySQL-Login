<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Struts 1.x JSP Success</title>
</head>
<body>

	<%
		String user = (String) request.getAttribute("reqName");
	%>

	<table class="logout">
		<tr>
			<td><a href="logout.do"> Log Out ...</a></td>
		</tr>
		<tr>
			<td class="success">Welcome <b><%=user%></b> you have successfully
				logged in to the application ... :)
			</td>
		</tr>
	</table>

</body>
</html>
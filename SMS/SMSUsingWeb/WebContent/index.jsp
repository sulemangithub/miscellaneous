<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME MYway2sms</h3>
<form action="SendSMSSerlvet" method="post">
<table border="3" bgcolor="#344121">
<tr><td>MOBILE NO:</td><td><input type="text" name="no"></td></tr>
<tr><td colspan="2">MESSAGE:</td></tr>
<tr><td colspan="2"><textarea name="message" cols="30"></textarea></td></tr>
<tr><td><input type="submit" value="send"></td></tr>
</table>
</form>
</body>
</html>
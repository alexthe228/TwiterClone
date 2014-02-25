<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Tweets</title>
</head>
<body bgcolor="#333333">

<h1 style="font-family:arial;color:white;font-size:48px;">Chemodan tweets: </h1>
<hr style = "color:white;font-size:48px;">
<br>
<center>
<br>
<h1 style="font-family:arial;color:white;font-size:32px;">You have sucessefully logged in as <%= request.getAttribute("Username") %></h1>
<br>
<form action="Tweet/<%= request.getAttribute("Username") %>" method=get>
<input type="submit" value="Continue">
</form>

</center>
</body>
</html>
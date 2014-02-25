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
<form action="Login" method=get>
<h1 style="font-family:arial;color:white;font-size:32px;">Existing user</h1>
<p style="color:white">username : <input name="username1" rcols="50" maxlength="120"></input> </p>
<p style="color:white">password : <input name="password1" rcols="50" maxlength="120"></input> </p>
<input type="submit" value="Login">
</form>

<br>
<form action="Login" method=post>
<h1 style="font-family:arial;color:white;font-size:32px;">New user</h1>
<p style="color:white">username : <input name="username" rcols="50" maxlength="120"></input> </p>
<p style="color:white">password : <input name="password" rcols="50" maxlength="120"></input> </p>
<p style="color:white">email : <input name="email" rcols="50" maxlength="120"></input> </p>
<input type="submit" value="Register">
</form>

</center>
</body>
</html>
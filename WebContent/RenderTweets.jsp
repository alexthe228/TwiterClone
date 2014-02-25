<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ page import="com.stores.*" %>
<%@ page import="java.util.*" %>
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
<%
System.out.println("In render");
List<TweetStore> lTweet = (List<TweetStore>)request.getAttribute("Tweets");
if (lTweet==null){
 %>
<p>No Tweet found</p>
<%
}else{
%>


<%
String newtweet;
Iterator<TweetStore> iterator;


iterator = lTweet.iterator();
while (iterator.hasNext()){
TweetStore ts = (TweetStore)iterator.next();

%>
<p style="color:white;"> <a href="/ac32007examples/Tweet/<%=ts.getUser() %>" style="background-color:white;color:black;text-decoration: none;">  <%= ts.getTweet() %></a> by <%= ts.getUser()%></p><%

}
}
%>

<br>
<form action="Tweet" method=post>
<textarea name="tweettext" rows="4" cols="50" autofocus" ></textarea>
<br>
<input type="submit" value="Submit">
</form>

</center>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" href="indexStyle.css">
</head>
<body>

<form action="login" method="post">
<h1>Delhi Public School</h1>
<h2>Admin Login</h2>
Email<input type="text" name="email" required/>
Password<input type="password" name="password" required/>
<input type="submit" value="Sign in">

</form> 
<%
if(request.getAttribute("error")!=null){
	out.println(request.getAttribute("error"));
}
%>

</body>
</html>
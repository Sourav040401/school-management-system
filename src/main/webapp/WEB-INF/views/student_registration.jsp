<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        label {
            font-size: 1.1em;
            color: #333;
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #5c6bc0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.1em;
        }

        input[type="submit"]:hover {
            background-color: #3f4ccf;
        }

        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 1.2em;
            color: green;
        }

    </style>
</head>

<body>
    <h2>Add Student</h2>
    <form action="addStudent" method="post">
        <label for="name">Name</label>
        <input type="text" name="name" required/>

        <label for="email">Email</label>
        <input type="text" name="email" required/>

        <label for="mobile">Mobile</label>
        <input type="text" name="mobile" required/>

        <input type="submit" value="Save"/>
    </form>

    <%
        if(request.getAttribute("msg") != null){
            out.println("<div class='message'>" + request.getAttribute("msg") + "</div>");
        }
    %>

</body>
</html>

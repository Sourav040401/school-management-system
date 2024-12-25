<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update</title>
    <style>
        /* Body and overall page layout */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Form styling */
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
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
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1em;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #5c6bc0;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.1em;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #3f4ccf;
        }

        /* Message styling */
        .message {
            text-align: center;
            margin-top: 20px;
            font-size: 1.2em;
            color: green;
        }

    </style>
</head>
<body>
    <h2>Update Student Information</h2>
    <form action="updateStudent" method="post">
        <label for="email">Email</label>
        <input type="text" name="email" value="<%= request.getAttribute("email") %>" required />

        <label for="mobile">Mobile</label>
        <input type="text" name="mobile" value="<%= request.getAttribute("mobile") %>" required />

        <input type="submit" value="Update"/>
    </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Students</title>
    <style>
        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #5c6bc0;
            color: white;
        }

        td {
            background-color: #fff;
        }

        tr:nth-child(even) td {
            background-color: #f9f9f9;
        }

        tr:hover td {
            background-color: #e0e0e0;
        }

        /* Links (Delete and Update) */
        a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
        }

        a:hover {
            color: #d32f2f;
        }

        /* Overall table container */
        .table-container {
            max-width: 900px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <h2>All Students</h2>
    <div class="table-container">
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Delete</th>
                <th>Update</th>
            </tr>
            <%
                ResultSet res = (ResultSet)request.getAttribute("result");
                while(res.next()) {
            %>
            <tr>
                <td><%= res.getString(1) %></td>
                <td><%= res.getString(2) %></td>
                <td><%= res.getString(3) %></td>
                <td><a href="deleteStudent?email=<%= res.getString(2) %>">Delete</a></td>
                <td><a href="updateStudent?email=<%= res.getString(2) %>&mobile=<%= res.getString(3) %>">Update</a></td>
            </tr>
            <% 
                }
            %>
        </table>
    </div>
</body>
</html>

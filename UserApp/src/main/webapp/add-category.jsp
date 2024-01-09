<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp"  %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UserApp | Create Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #008080;
            color: #fff;
            cursor: pointer;
        }

        a {
            position: absolute;
            top: 10px;
            left: 10px;
            color: #008080;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <a href="category.jsp">All Categories</a>

    <form action="createCategory" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>

        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select><br>

        <input type="submit" value="Save">
    </form>
</body>
</html>

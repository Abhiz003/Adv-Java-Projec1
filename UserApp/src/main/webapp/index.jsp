<%@page import="com.myWebApp.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String msg = (String)session.getAttribute("message");
	session.removeAttribute("message");

	User user = (User)session.getAttribute("user");
	
	if(user != null) 
		response.sendRedirect("dashboard.jsp");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | Login</title>
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

        h1 {
            color: #008080;
        }

        form {
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
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

        p {
            margin-top: 16px;
        }

        a {
            color: #008080;
            text-decoration: none;
        }
    </style>
</head>
<body>
	<h1>Login here</h1>
	<p><%= msg != null ? msg : "" %> </p>
	<form action="doLogin" method="post">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Login">
    </form>

    <p>Don't have an account? <a href="signup.jsp">Sign up here</a></p>
</body>
</html>
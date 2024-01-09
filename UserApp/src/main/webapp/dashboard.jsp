<%@page import="com.myWebApp.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="partials/header.jsp" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | Dashboard</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            padding: 10px;
            color: #fff;
            text-align: right;
        }

        section {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .jumbotron {
            background-color: #007bff;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        h1 {
            font-family: 'Pacifico', cursive;
            font-size: 2.5em;
            color: #333;
        }

        p {
            color: #555;
            line-height: 1.6;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
       
</head>
<body>
	
	 <header>
        <form action="logout" method="Post">
            <button type="submit">Logout</button>
        </form>
    </header>

    <section>
        <div class="jumbotron">
            <h1>Hello, <%= user.getName() %></h1>
            <p>Welcome to your dashboard. Here are some dummy elements:</p>
        </div>

        <div>
            <ul>
                <li><strong>Task 1:</strong> Complete Lorem ipsum dolor sit amet</li>
                <li><strong>Task 2:</strong> Consectetur adipiscing elit</li>
                <li><strong>Task 3:</strong> Sed do eiusmod tempor incididunt</li>
            </ul>
        </div>
        
        <p><a href="change-profile.jsp">Change Profile</a></p>
        
        
            <a href="category.jsp"><button>Category Manager</button></a>
        
    </section>
</body>
</html>
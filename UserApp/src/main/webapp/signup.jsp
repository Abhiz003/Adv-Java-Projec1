<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%
HashMap<String,String> errors = (HashMap<String,String>)session.getAttribute("errors");

if(errors == null) {
	 errors = new HashMap<String,String>();
}
%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserApp | SignUp</title>
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

        input,
        select {
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
	<h1>Sign Up here</h1>

    <form action="doSignUp" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
<span class="error"><% if(errors.containsKey("name")) {out.println(errors.get("name"));} %></span>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
<span class="error"><% if(errors.containsKey("email")) {out.println(errors.get("email"));} %></span>
		<label for="password">Password:</label>
        <input type="password" id="pass" name="password" required><br>
        			<span class="error"><% if(errors.containsKey("password")) {out.println(errors.get("password"));} %> </span>	
   <!--  <label for="mobile">Mobile:</label>
        <input type="tel" id="mobile" name="mobile" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select><br>   -->

        <input type="submit" value="Sign Up">
    </form>

    <p>Already have an account? <a href="index.jsp">Login here</a></p>
</body>
</html>
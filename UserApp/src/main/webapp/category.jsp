<%@page import="com.myWebApp.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myWebApp.dbUtil.DBconnection"%>
<%@page import="com.myWebApp.repository.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="partials/header.jsp"  %>
<%
String msg = (String)session.getAttribute("msg");
session.removeAttribute("msg");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>UserApp | Category Manager</title>
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

        a {
            text-decoration: none;
            
        }

        button {
            background-color: #008080;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #008080;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

    </style>
</head>
<body>
<!-- this object will be create  only once -->
<%! CategoryDao categoryDao = new CategoryDao(new DBconnection()); %>
    <p><a href="add-category.jsp"><button>Create New Category +</button></a></p>
	<p><b><%=msg != null ? msg : "" %></b></p>

<% ArrayList<Category>  categories = categoryDao.fetchAll(); 
	if(categories.size() > 0) {
		%>
		
		
    <table>
        <tr>
            <th>SrNo.</th>
            <th>Title</th>
            <th>Status</th>
            <th>Created At</th>
            <th>Updated At</th>
            <th>Actions</th>
        </tr>
        
       <%
       for(Category category : categories) {
    	   %>
    	   <tr>
    	   		<td><%= category.getCatId()%></td>
    	   		<td><%= category.getTitle()%></td>
    	   		<td><%= category.getStatus()%></td>
    	   		<td><%= category.getCreatedAt() %></td>
    	   		<td><%= category.getUpdatedAt() %></td>
    	   		<td>
    	   		<a href="#<%=category.getCatId() %>"><button>UPDATE</button></a> 
    	   		| <a href="deleteCategory?id=<%=category.getCatId() %>"><button>DELETE</button></a></td>
    	   </tr>
    	   <%
       }
       %>
        
        
        
    </table>
		
		<% 
	}
%>



</body>
</html>

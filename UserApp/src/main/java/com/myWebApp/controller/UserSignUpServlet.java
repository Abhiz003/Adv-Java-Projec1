package com.myWebApp.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

import com.myWebApp.dbUtil.DBconnection;
import com.myWebApp.model.User;
import com.myWebApp.repository.UserDao;

/**
 * Servlet implementation class UserSignUpServlet
 */

@WebServlet(name="UserSignUp", urlPatterns={"/doSignUp"})
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao; 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpServlet() {
        super();
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	DBconnection dbCon = new DBconnection();
    	this.userDao = new UserDao(dbCon);// this  we have to acces outside the method 
    	System.out.println("we got connection");
    }
    
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		HashMap<String, String> errors = new HashMap<String, String>();
		if(name.isEmpty()) {
			errors.put("name","Name is required");
		}
		else if(name.length() <=2) {
			errors.put("name","Name must be atleast 2 characters long.");
		}
		
		
		
		if(email.isEmpty()) {
			errors.put("email","Email is requied");
		} else if(!email.contains("@")) {
			errors.put("email","Invalid email address");
		}
		
		
		if(password.isEmpty()) {
			errors.put("password","Password is requied");
		}else if(password.length() <= 6) {
			errors.put("password","Password must be 6 characters long");
		}
		
		HttpSession session = req.getSession();
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);
			res.sendRedirect("signup.jsp");
			return;
		}
		
		User user = new User(name, email, password);
		
		boolean isRegistered = userDao.registerUser(user);
		
		if(isRegistered) {
			user.setPassword("");
			session.setAttribute("user", user);
			res.sendRedirect("dashboard.jsp");
		}else {
			res.sendRedirect("signup.jsp");
		}
	}

}

package com.myWebApp.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.myWebApp.dbUtil.DBconnection;
import com.myWebApp.model.User;
import com.myWebApp.repository.UserDao;

/**
 * Servlet implementation class UserLoginServlet
 */

@WebServlet(name="UserLogin", urlPatterns = {"/doLogin"})
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
       
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	userDao = new UserDao(new DBconnection()); // we calling dbcon constructor
    	super.init(config);
    }
    
   
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userDao.authenticate(new User(email, password));
		System.out.println(user);
		HttpSession session = request.getSession(); // session creation
		if(user != null) {
			session.setAttribute("user", user);
			response.sendRedirect("dashboard.jsp");
		} else {
			session.setAttribute("message", "Invalid Email / password");
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}

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
import com.myWebApp.model.Category;
import com.myWebApp.repository.CategoryDao;

/**
 * Servlet implementation class CreateCategoryServlet
 */
@WebServlet("/createCategory")
public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategoryServlet() {
        super();
       
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    	super.init(config);
    	this.categoryDao = new CategoryDao(new DBconnection());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		Category category = new Category(title, status);
	
		boolean result = this.categoryDao.create(category);
		
		HttpSession session = request.getSession();
		
		//String actionURL;
		if(result) {
			session.setAttribute("msg", "Category created successfully.");
			//actionURL = "category.jsp";
		} else {
			session.setAttribute("msg", "Something went wrong");
		}
		
		
		
		 response.sendRedirect("category.jsp");
		
		
		
		
		
	}

}

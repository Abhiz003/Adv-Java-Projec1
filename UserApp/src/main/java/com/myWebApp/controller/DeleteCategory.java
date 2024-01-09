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
import com.myWebApp.repository.CategoryDao;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategory() {
        super();
       
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    	super.init(config);
    	this.categoryDao = new CategoryDao(new DBconnection());
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String catId = request.getParameter("id");
		
		int categoryId = 0;
		if(catId != null) {
			categoryId = Integer.parseInt(catId);
		}
		
		boolean isDeleted = categoryDao.delete(categoryId);
		
		HttpSession session = request.getSession();
		if(isDeleted) {
			session.setAttribute("msg", "Category Deleted successfully.");
		} else {
			session.setAttribute("msg", "Category Deletion Failed.");
		}
		
		response.sendRedirect("category.jsp");
		
	}

	
}

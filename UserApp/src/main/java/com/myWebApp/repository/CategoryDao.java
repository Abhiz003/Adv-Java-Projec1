package com.myWebApp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.myWebApp.dbUtil.DBconnection;
import com.myWebApp.model.Category;

public class CategoryDao {
private DBconnection dbConnection;
	
	public CategoryDao(DBconnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	
	public boolean create(Category category) {
		String query = "Insert into categories (title, status) values (?,?)";
		
		Connection con = dbConnection.createConnection();
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, category.getTitle());
			pst.setString(2, category.getStatus());
		
			int affectedRows = pst.executeUpdate();
		
			return affectedRows > 0;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void fetchOne() {
		String  query = "select catId, title, status, createdAt, updatedAt from categories";
		
try {
			
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Category> fetchAll() {
		String  query = "select catId, title, status, createdAt, updatedAt from categories";
		
		try {
			
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			ArrayList<Category> categories = new ArrayList<Category>();
			while(rs.next()) {
	
				categories.add(new Category(
						rs.getInt("catId"),
						rs.getString("title"),
						rs.getString("status"),
						rs.getString("createdAt"),
						rs.getString("updatedAt")
						));
				
//				Category category = new Category();
//				category.setCatId(rs.getInt("catId"));
//				category.setTitle(rs.getString("title"));
//				category.setStatus(rs.getString("status"));
//				categories.add(category);
				
			}
			return categories;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delete( int catId) {
		String query = "Delete from categories where catId=?";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, catId);
			int affectedRows =pst.executeUpdate();
			
			
			return affectedRows > 0;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	
	
}

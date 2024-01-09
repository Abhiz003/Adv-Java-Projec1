package com.myWebApp.model;

public class Category {
	private int catId;
	private String title;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	public Category() {
		
	}

	public Category(String title, String status) {
		this.title = title;
		this.status = status;
	
	}


	public Category(int catId, String title, String status, String createdAt, String updatedAt) {
		super();
		this.catId = catId;
		this.title = title;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}

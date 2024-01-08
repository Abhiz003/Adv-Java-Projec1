package com.myWebApp.model;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private int age;
	private String gender;
	
	
	public User() {
		super();	
	}

	//signup time 
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	//login time
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	
	
	
	
	
	
	
	
	
}

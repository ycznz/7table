package com.pro.domain;

public class Category {

	private int categoryId;
	
	private String categoryName;
	
	private String categoryDesc;

	public int getCategoryId() {
		return categoryId;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Category(int categoryId, String categoryName, String categoryDesc) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}

	public Category(String categoryName, String categoryDesc) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
	}
	
	
}

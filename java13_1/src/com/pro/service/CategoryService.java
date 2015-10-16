package com.pro.service;

import java.util.List;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public interface CategoryService {

public void addCatetory(Category category);
	
	public void deleteCategoryById(int categoryId);
	
	public void updateCategory(Category category);
	
	public Category findCategoryById(int categoryId);
	
	public PageModel<Category> queryCategorys(int currentPage,int pageSize);
	
	public List<Category> queryAllCategorys();
}

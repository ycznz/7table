package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public interface CategoryDao {

	public void addCatetory(Connection conn,Category category)throws Exception;
	
	public void deleteCategoryById(Connection conn,int categoryId)throws Exception;
	
	public void updateCategory(Connection conn,Category category)throws Exception;
	
	public Category findCategoryById(Connection conn,int categoryId)throws Exception;
	
	public PageModel<Category> queryCategorys(Connection conn,int currentPage,int pageSize)throws Exception;

	public List<Category> queryAllCategorys(Connection conn)throws Exception;
}

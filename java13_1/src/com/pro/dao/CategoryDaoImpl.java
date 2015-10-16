package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Category;
import com.pro.util.PageModel;

public class CategoryDaoImpl extends BaseDao implements CategoryDao {

	public void addCatetory(Connection conn, Category category) throws Exception {
		String sql="insert into categorys(category_id,category_name,category_desc) values(seq_hehe.nextval,?,?)";
		Object[] param={category.getCategoryName(),category.getCategoryDesc()};
		
		this.exeSql(conn, sql, param);
	}

	@Override
	public void deleteCategoryById(Connection conn, int categoryId)
			throws Exception {
			String sql="delete from categorys where category_id=?";
			Object[] param={categoryId};
			
			this.exeSql(conn, sql, param);// TODO Auto-generated method stub
		
	}

	@Override
	public Category findCategoryById(Connection conn, int categoryId)
			throws Exception {
		ResultSet rs=null;
		String sql="select * from categorys where category_id=?";
		Object[] param={categoryId};
		
		rs=this.getRs(conn, sql, param);
		Category category=null;
		if(rs.next()){
			category=new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			category.setCategoryDesc(rs.getString("category_desc"));
		}
		return category;
	}

	@Override
	public PageModel<Category> queryCategorys(Connection conn, int currentPage,
			int pageSize) throws Exception {
		ResultSet rs=null;
		List<Category> categoryList=new ArrayList<Category>();
		String sql="select * from (select rownum rn,c.* from (select * from categorys order by category_id desc) c where rownum<=?) where rn>?";
		Object[] param={currentPage*pageSize,(currentPage-1)*pageSize};
		
		rs=this.getRs(conn, sql, param);
		Category category=null;
		while(rs.next()){
			category=new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			category.setCategoryDesc(rs.getString("category_desc"));
			
			categoryList.add(category);
		}
		PageModel<Category> pageModel=new PageModel<Category>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(categoryList);
		pageModel.setPageSize(pageSize);
		
		int totalRecord=this.getRowCount(conn, "select count(*) from categorys", null); 
		
		pageModel.setTotalRecord(totalRecord);
		
		return pageModel;
	}

	/**
	 * 修改类别
	 */
	public void updateCategory(Connection conn, Category category)
			throws Exception {

		String sql="update categorys set category_name=?,category_desc=? where category_id=?";
		Object[] param={category.getCategoryName(),category.getCategoryDesc(),category.getCategoryId()};
		
		this.exeSql(conn, sql, param);
	}

	@Override
	public List<Category> queryAllCategorys(Connection conn) throws Exception {
		ResultSet rs=null;
		List<Category> categoryList=new ArrayList<Category>();
		String sql="select * from categorys";
		Object[] param=null;
		
		rs=this.getRs(conn, sql, param);
		Category category=null;
		while(rs.next()){
			category=new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			category.setCategoryDesc(rs.getString("category_desc"));
			
			categoryList.add(category);
		}
		return categoryList;
	}

}

package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.pro.dao.CategoryDao;
import com.pro.dao.CategoryDaoImpl;
import com.pro.domain.Category;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public void addCatetory(Category category) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryDao.addCatetory(conn, category);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteCategoryById(int categoryId) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryDao.deleteCategoryById(conn, categoryId);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Category findCategoryById(int categoryId) {
		Connection conn = null;
		Category category = null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			category = categoryDao.findCategoryById(conn, categoryId);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return category;
	}

	@Override
	public PageModel<Category> queryCategorys(int currentPage, int pageSize) {
		Connection conn = null;
		PageModel<Category> pageModel = null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			pageModel = categoryDao.queryCategorys(conn, currentPage, pageSize);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pageModel;
	}

	@Override
	public void updateCategory(Category category) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryDao.updateCategory(conn, category);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Category> queryAllCategorys() {
		Connection conn = null;
		 List<Category> categoryList = null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			categoryList = categoryDao.queryAllCategorys(conn);

			conn.commit();// 提交
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();// 操作失败，回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				DbHelper.closeAll(conn);// 关闭连接对象
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return categoryList;
	}

}

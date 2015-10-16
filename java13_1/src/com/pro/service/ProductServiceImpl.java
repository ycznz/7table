package com.pro.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pro.dao.CategoryDao;
import com.pro.dao.CategoryDaoImpl;
import com.pro.dao.ProductDao;
import com.pro.dao.ProductDaoImpl;
import com.pro.dao.ProviderDao;
import com.pro.dao.ProviderDaoImpl;
import com.pro.domain.Category;
import com.pro.domain.Product;
import com.pro.domain.Provider;
import com.pro.util.DbHelper;
import com.pro.util.PageModel;

public class ProductServiceImpl implements ProductService {

	public void addProduct(Product product) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProductDao productDao=new ProductDaoImpl();
			productDao.addProduct(conn, product);

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

	public void deleteProductById(int productId) {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProductDao productDao=new ProductDaoImpl();
			productDao.deleteProductById(conn, productId);

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

	public Product findProductById(int productId) {
		Connection conn = null;
		Product product=null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProductDao productDao=new ProductDaoImpl();
			product = productDao.findProductById(conn, productId);

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
		return product;
	}

	public PageModel<Product> queryProducts(int currentPage, int pageSize)
			 {
		Connection conn = null;
		PageModel<Product> pageModel=null;
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProductDao productDao=new ProductDaoImpl();
			pageModel = productDao.queryProducts(conn, currentPage, pageSize);

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

	public void updateProduct(Product product)  {
		Connection conn = null;

		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			ProductDao productDao=new ProductDaoImpl();
			productDao.updateProduct(conn, product);

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
	public Map<String, Object> findAllProviderCategory2Map() {
		Connection conn = null;
		 
		Map<String, Object> maps=new HashMap<String,Object>(); 
		try {
			conn = DbHelper.getConn();
			conn.setAutoCommit(false);// 设置手动提交

			CategoryDao categoryDao = new CategoryDaoImpl();
			List<Category> categoryList = categoryDao.queryAllCategorys(conn);
			
			ProviderDao providerDao=new ProviderDaoImpl();
			List<Provider> providerList = providerDao.queryAllProviders(conn);

			maps.put("categoryList", categoryList);
			maps.put("providerList", providerList);
			
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
		return maps;
	}

}

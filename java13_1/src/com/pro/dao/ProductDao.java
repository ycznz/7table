package com.pro.dao;

import java.sql.Connection;

import com.pro.domain.Product;
import com.pro.util.PageModel;

public interface ProductDao {

	public void addProduct(Connection conn, Product product) throws Exception;

	public void deleteProductById(Connection conn, int productId)
			throws Exception;

	public void updateProduct(Connection conn, Product product)
			throws Exception;

	public Product findProductById(Connection conn, int productId)
			throws Exception;

	public PageModel<Product> queryProducts(Connection conn, int currentPage,
			int pageSize) throws Exception;

}
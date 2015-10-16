package com.pro.service;

import java.util.Map;

import com.pro.domain.Product;
import com.pro.util.PageModel;

public interface ProductService {
	
	public void addProduct(Product product);

	public void deleteProductById(int productId);

	public void updateProduct(Product product);

	public Product findProductById(int productId);

	public PageModel<Product> queryProducts(int currentPage, int pageSize);
	
	public Map<String,Object> findAllProviderCategory2Map();
}

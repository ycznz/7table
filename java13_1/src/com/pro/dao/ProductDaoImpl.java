package com.pro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pro.domain.Product;
import com.pro.util.PageModel;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	/**
	 *  PRODUCT_ID    NUMBER(6)                       NOT NULL,
	  CATEGORY_ID   NUMBER(6),
	  PROVIDER_ID   NUMBER(6),
	  PRODUCT_NAME  VARCHAR2(30 BYTE),
	  INCOME_PRICE  NUMBER(6),
	  QUANTITY      NUMBER(6),
	  SALES_PRICE   NUMBER(6)	 
	 */
	public void addProduct(Connection conn,Product product) throws Exception{
		String sql="insert into products(PRODUCT_ID,CATEGORY_ID,PROVIDER_ID,PRODUCT_NAME,INCOME_PRICE,QUANTITY,SALES_PRICE) values(seq_hehe.nextval,?,?,?,?,?,?)";
		Object[] param={product.getCategoryId(),product.getProviderId(),product.getProductName(),product.getIncomePrice(),product.getQuantity(),product.getSalesPrice()};
		
		this.exeSql(conn, sql, param);
	}
	
	public void deleteProductById(Connection conn,int productId) throws Exception{
		String sql="delete from products where product_Id=?";
		Object[] param={productId};
		
		this.exeSql(conn, sql, param);
	}
	
	public void updateProduct(Connection conn,Product product) throws Exception{
		String sql="update products set CATEGORY_ID=?,PROVIDER_ID=?,PRODUCT_NAME=?,INCOME_PRICE=?,QUANTITY=?,SALES_PRICE=? where product_Id=?";
		Object[] param={product.getProviderId(),product.getProductName(),product.getIncomePrice(),product.getQuantity(),product.getSalesPrice(),product.getCategoryId()};
		
		this.exeSql(conn, sql, param);
	}
	
	public Product findProductById(Connection conn,int productId) throws Exception{
		String sql="select * from products where PRODUCT_ID=?";
		Object[] param={productId};
		ResultSet rs=null;
		rs=this.getRs(conn, sql, param);
		Product product=null;
		if(rs.next()){
			product=new Product();
			product.setCategoryId(rs.getInt("CATEGORY_ID"));
			product.setIncomePrice(rs.getDouble("INCOME_PRICE"));
			product.setProductId(rs.getInt("product_Id"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setProviderId(rs.getInt("PROVIDER_ID"));
			product.setQuantity(rs.getInt("QUANTITY"));
			product.setSalesPrice(rs.getDouble("SALES_PRICE"));
		}
		
		return product;
	}
	public PageModel<Product> queryProducts(Connection conn,int currentPage,int pageSize) throws Exception{
		String sql="select * from (select rownum rn,p.* from (select * from products order by product_id desc) p where rownum<=?) where rn>?";
		Object[] param={(currentPage*pageSize),(currentPage-1)*pageSize};
		
		List<Product> productList=new ArrayList<Product>();
		ResultSet rs=null;
		rs=this.getRs(conn, sql, param);
		Product product=null;
		while(rs.next()){
			product=new Product();
			product.setCategoryId(rs.getInt("CATEGORY_ID"));
			product.setIncomePrice(rs.getDouble("INCOME_PRICE"));
			product.setProductId(rs.getInt("product_Id"));
			product.setProductName(rs.getString("PRODUCT_NAME"));
			product.setProviderId(rs.getInt("PROVIDER_ID"));
			product.setQuantity(rs.getInt("QUANTITY"));
			product.setSalesPrice(rs.getDouble("SALES_PRICE"));
			
			productList.add(product);
		}
		
		PageModel<Product> pageModel=new PageModel<Product>();
		pageModel.setCurrentPage(currentPage);
		pageModel.setList(productList);
		pageModel.setPageSize(pageSize);
		
		int totalRecord=this.getRowCount(conn, "select count(*) from products", null);
		pageModel.setTotalRecord(totalRecord);
		
		return pageModel;
	}
}

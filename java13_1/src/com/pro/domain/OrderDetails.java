package com.pro.domain;

/**
 *ORDER_ID    NUMBER(6),
  PRODUCT_ID  NUMBER(6),
  QUANTITY    NUMBER(6),
  DISCOUNT    NUMBER(6)
 * @author Administrator
 *
 */
public class OrderDetails {

	private int orderId;
	
	private int productId;
	
	private int quantity;
	
	private double discount;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
}

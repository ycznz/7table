package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.OrderDetails;

public class OrderDetailDaoImpl extends BaseDao implements OrderDetailDao {

	@Override
	public void addOrderDetail(Connection conn,
			List<OrderDetails> orderDetailList) throws Exception {
		
		String sql="insert into ORDER_DETAIL(ORDER_ID,PRODUCT_ID,QUANTITY) values(?,?,?)";
		this.exe(conn, sql, orderDetailList);
	}

}

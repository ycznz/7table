package com.pro.dao;

import java.sql.Connection;
import java.util.List;

import com.pro.domain.OrderDetails;

public interface OrderDetailDao {

	public void addOrderDetail(Connection conn,List<OrderDetails> orderDetailList)throws Exception;
}

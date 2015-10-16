package com.pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.pro.domain.OrderDetails;

public class BaseDao {
	/**
	 * 增删改的方法
	 * @param conn
	 * @param sql
	 * @param param 填充问号的数据，装在此数组中。注意：数组元素的个数，一定是和问号的个数相对应的。
	 */
	public void exeSql(Connection conn,String sql,Object[] param) throws Exception{
		//String sql="insert into t_user(userId,userName,password) values(?,?,?)";		
		PreparedStatement pstmt=null;
		pstmt=conn.prepareStatement(sql);
		
		if(param!=null){
			for(int i=0;i<param.length;i++){
				//将数组中对应数据通过循环，一个一个放入问号所在位置
				pstmt.setObject(i+1, param[i]);
			}
		}
		pstmt.executeUpdate();//增删改操作。		
	}
	
	/**
	 * 调用此方法，将拿到查询的结果集
	 * @param conn
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public ResultSet getRs(Connection conn,String sql,Object[] param) throws Exception{
		//String sql="select * from t_user where userId=? and userName=?";	
		ResultSet rs=null;//结果集。
		
		PreparedStatement pstmt=null;
		pstmt=conn.prepareStatement(sql);
		
		if(param!=null){
			for(int i=0;i<param.length;i++){
				//将数组中对应数据通过循环，一个一个放入问号所在位置
				pstmt.setObject(i+1, param[i]);
			}
		}
		rs=pstmt.executeQuery();//查操作。	
		//返回结果集
		return rs;
	}
	
	/**
	 * 总记录数
	 * @param conn
	 * @param sql
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(Connection conn,String sql,Object[] param) throws Exception{
		ResultSet rs=this.getRs(conn, sql, param);
		int count=0;
		if(rs.next()){
			count=rs.getInt(1);
		}
		return count;
	}
	
	/**
	 * ORDER_ID    NUMBER(6),
	  PRODUCT_ID  NUMBER(6),
	  QUANTITY    NUMBER(6),
	  DISCOUNT    NUMBER(6)
	 * @param conn
	 * @param sql
	 * @param detailList
	 * @throws Exception
	 */
	public void exe(Connection conn,String sql,List<OrderDetails> detailList)throws Exception{
		//insert into ORDER_DETAIL(ORDER_ID,PRODUCT_ID,QUANTITY) values(?,?,?);
		PreparedStatement pstmt=null;
		pstmt=conn.prepareStatement(sql);
		
		for(int i=0;i<detailList.size();i++){
			OrderDetails od=detailList.get(i);
			pstmt.setInt(1, od.getOrderId());
			pstmt.setInt(2, od.getProductId());
			pstmt.setInt(3, od.getQuantity());
			
			pstmt.addBatch();
		}
		pstmt.executeBatch();
	}	
}

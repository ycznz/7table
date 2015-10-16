package com.pro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//静态方法，又称为类方法。可以直接用类名来调用。DbHelper.getConn()
//静态方法比对象的方法出生的要早。对象的方法是创建对象后，才可以调用。
//而静态方法是jvm加载类后就可以调用了
public class DbHelper {
	/**
	 * 得到连接对象
	 * 自已不处理，让别人去处理。就throws Exception
	 */
	public static Connection getConn() throws Exception{
		//确定数据库，根据厂家提供的数据库驱动类。
		Class.forName("oracle.jdbc.OracleDriver");			
		//1，要有连接。
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		
		return conn;		
	}	
	/**
	 * 关闭
	 * @throws Exception 
	 */
	public static void closeAll(Connection conn) throws Exception{
		if(conn!=null){//如果连接对象不为空。那我们就去关闭他
			conn.close();
		}
	}
}

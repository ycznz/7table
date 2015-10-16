package com.pro.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.pro.domain.Users;
import com.pro.service.UserService;
import com.pro.service.UserServiceImpl;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//map的key不能重复，会fu盖。可以空值空键
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("key1", "fbb");
		maps.put("key2", "zw");
		maps.put("key3", "zp");
		maps.put("key1", "nd");
		maps.put(null, null);
		
		//List<String> list1=new ArrayList<String>();
		//List<String> list2=new ArrayList<String>();
		//maps.put("gys", list1);
		//maps.put("lb", list2);
		
		String name = (String) maps.get("key1");
		//System.out.println(name);
		System.out.println(maps.size());
		System.out.println(maps);
		
		if(maps.containsKey("key3")){
			System.out.println(maps.get("key3"));
		}
		
		Set<String> keySet = maps.keySet();
//		Iterator<String> it = keySet.iterator();
//		while(it.hasNext()){
//			String next = it.next();
//			System.out.println("== "+next);
//		}
		
//		for (String str : keySet) {
//			System.out.println(str+"  -");
//		}
		
		Set<Entry<String,Object>> entrySet = maps.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		//注意。删除后返回的是此键对应的值
		Object remove = maps.remove("key3");
		System.out.println(remove);
	}
	/**
	 * 集合添加数据：集合对象.add(值);
	 * 从集合中取数据：集合对象.get(索引位置);
	 */

	private static void a1() {
		Users user=new Users();		
		user.setUserId(4);
		user.setUserName("wwsds");
		user.setPassword("123dsd");
		
		UserService userService=new UserServiceImpl();
		//调用业务对象的添加方法,传入user
		//userService.saveUser(user);
		
		
		//修改
		//userService.editUser(user);
		//删除
		//userService.removeUser(4);
		
		List<Users> userList = userService.findAllUser();
		for(int i=0;i<userList.size();i++){
			//从集合中，使用get(索引)来取某一位置上的值
			Users us=userList.get(i);
			System.out.println(us.getUserId()+":"+us.getUserName()+":"+us.getPassword());
		}
		
		System.out.println("操作结束。。");
	}
}

package com.pro.oo;

public class Tea {

	public String name;
	
	public void jk(){
		System.out.println("讲课。。");
	}

	public Tea() {
		System.out.println("父类无参构造");
	}
	public Tea(String name) {
		System.out.println("父类一参构造"+name);
	}
	
}

package com.pro.oop.a;

public class Test {

	public void xx(Tea tea){
		tea.jk();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Tea tea=new JavaTea();
//		tea.jk();
		
		JavaTea javaTea=new JavaTea();
		
		Test test=new Test();
		test.xx(javaTea);
	}

}

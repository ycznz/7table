package com.pro.oo;

public class Test1 {
	
	//多态：根据传入的对象的不同，而动态调用不同对象的方法
	public void run(Tea tea){
		tea.jk();
	}
		
	public static void main(String[] args) {
		//new JavaTea()调用构造函数
		JavaTea javaTea=new JavaTea(18,"张三");
		PhpTea phpTea=new PhpTea();
		
		//Tea tea=new JavaTea(18,"张三");
		//等号右边给哪一个子类，我们的tea对象就是哪个子类。
		//Tea tea=new PhpTea();
		//tea.jk();
		//
		/////
		
		Test1 t=new Test1();
		t.run(phpTea);		
	}
}

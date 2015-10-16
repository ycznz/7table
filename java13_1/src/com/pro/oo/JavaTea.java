package com.pro.oo;
/**
 * 不重复建造车轮
 * 继承：根据现有类派生出新类的机制，新类中具有基类的属性和方法.
 * @author Administrator
 * 在有继承关系时，如何用自已的方法，如何调用父类的方法？
 * 重写：把父类的方法在子类中重新写一遍。注意：方法访问修饰符，必须大于
 *       或等于父类方法。绝对不能小于父类的方法。
 * 构造函数：和类同名，无返回类型，new时被调用，
 *         作用：第一时间初始化对象
 * 重载：方法参数的个数，类型，顺序不同。也称为：方法签名不同。
 */
public class JavaTea extends Tea{	
	
	public JavaTea(String name) {
		System.out.println("子类一参构造");
	}
	public JavaTea() {
		System.out.println("子类无参构造");
	}
	public JavaTea(String name,int age) {
		System.out.println("子类二参构造age");
	}
	public JavaTea(int age,String name) {
		super(name);//必须第一时间调用
		System.out.println("子类二参构造name");		
	}
	@Override//?
	public void jk() {
		System.out.println("打开eclipse。。");
		super.jk();//调用父类的jk方法
	}	
}

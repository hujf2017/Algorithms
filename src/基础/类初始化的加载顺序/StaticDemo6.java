package 基础.类初始化的加载顺序;

/**
 * 1.先执行父类的静态方法 ，然后执行自己的静态方法  包括这俩静态方法里的衍生
 * 2.执行父类的动态方法 ，构造方法
 * 3.执行自己的动态方法，构造方法
 *
 */
public class StaticDemo6 {
	public static void main(String[] args) {
 		new SB();
	}
}
 
class SA {
 
	D d;
	// 1.先从父类的静态开始  后面不会在使用
	static {
		System.out.println("A 1");
	}
	//6. 动态方法1
	{
		System.out.println("A 2");
		//7调用这个的构造方法  第10步走完回这  调用这个的构造方法
		d = new D();
	}
 	//11 调用构造方法
	public SA() {
		System.out.println("A 3");
	}
 
}
 
class SB extends SA {
	//2.调用自己的实例化
	static C c = new C();

	//5.上面回来之后继续，调用自己静态方法  到这里就把所有的自己和父类的静态方法给用完了  该走动态方法了  先看父类  后面不会在使用
	static {
		System.out.println("B 1");
	}
	//12 调用自己的动态方法
	{
		System.out.println("B 2");
	}
	//13 调用自己的构造方法
	public SB() {
		System.out.println("B 3");
	}
}
 
class C {
	//4.调用C的构造方法   9调用父类构造方法 不会再去调用静态方法
	public C() {
		System.out.println("C");
	}
	//3.调用c的静态方法  后面不会在使用
	static {
		System.out.println("c1");
	}
}
 
class D extends C {
	 // 10 调用自己的 类构造方法    返回类实例化地方
	public D() {
		System.out.println("D");
	}
	//8.调用c的子类的静态方法  后面不会在使用
	static {
		System.out.println("d1");
	}
}
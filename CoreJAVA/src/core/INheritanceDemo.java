package core;
//single
class A{	//parent(base)
	public void classA() {
		System.out.println("hello class A");
	}
}
class B extends A{	//child(derived)
	public void classB() {
		System.out.println("hello class B");
	}
}
//multilevel
class C extends B{
	public void classC() {
		System.out.println("class C");
	}
}
public class INheritanceDemo {
	public static void main(String[] args) {
		B b = new B();
		b.classA();
		b.classB();
		C c = new C();
		c.classA();
		c.classB();
		c.classC();
	}
}

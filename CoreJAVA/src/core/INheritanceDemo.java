package core;

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
public class INheritanceDemo {
	public static void main(String[] args) {
		B b = new B();
		b.classA();
		b.classB();
	}
}

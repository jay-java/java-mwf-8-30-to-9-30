package core;
class Laptop{
	public void data(int j) {
		System.out.println("data 1 method : "+j);
	}
	public void data(String name) {
		System.out.println("data 2 method : "+name);
	}
}
public class Overloading {
	public static void main(String[] args) {
		Laptop laptop  = new Laptop();
		laptop.data(1);
		laptop.data("java");
	}
}

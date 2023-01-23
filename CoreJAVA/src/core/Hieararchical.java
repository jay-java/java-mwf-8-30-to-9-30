package core;
class AA{
	public void classA() {
		System.out.println("run inside AA");
	}
}
class BB extends AA{
	public void classB() {
		System.out.println("run inside BB");
	}
}
class CC extends AA{
	public void classC() {
		System.out.println("run inside CC");
	}
}
public class Hieararchical {
	public static void main(String[] args) {
		BB bb = new BB();
		bb.classA();
		bb.classB();
		CC cc = new CC();
		cc.classA();
		cc.classC();
	}
}

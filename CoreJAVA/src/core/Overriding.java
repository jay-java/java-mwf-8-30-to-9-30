package core;
class Phone{
	public void calling() {
		System.out.println("phone calling");
	}
}
class CellPhone extends Phone{
	public void calling() {
		System.out.println("cellphone calling");
		super.calling();
	}
}
public class Overriding {
	public static void main(String[] args) {
		CellPhone c = new CellPhone();
		c.calling();
	}
}

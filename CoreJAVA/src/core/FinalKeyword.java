package core;
final class Mobile{
	final int i=1;
	public final void price() {
		 //i++;
		System.out.println("mobile : 100000 : "+i);
	}
}
class Tablet extends Mobile{
	public void price() {
		super.price();
		System.out.println("tablet : 40000");
	}
}
public class FinalKeyword {
	public static void main(String[] args) {
		Tablet tablet = new Tablet();
		tablet.price();
	}
}

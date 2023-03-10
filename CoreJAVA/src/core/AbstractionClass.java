package core;

abstract class RBI{
	abstract public void interest();
	abstract public void homeloan();
	public static void repoRate() {
		System.out.println("repo rate : +-4%");
	}
}
class SBI extends RBI{

	@Override
	public void interest() {
		// TODO Auto-generated method stub
		System.out.println("sbi interest : 5%");
	}

	@Override
	public void homeloan() {
		// TODO Auto-generated method stub
		System.out.println("sbi homeloan : 7%");
	}
	
}
class PNB extends RBI{

	@Override
	public void interest() {
		// TODO Auto-generated method stub
		System.out.println("pnb interest : 6%");
	}

	@Override
	public void homeloan() {
		// TODO Auto-generated method stub
		System.out.println("pnb homeloan : 8%");
	}
	
}
class JAVA extends RBI{

	@Override
	public void interest() {
		// TODO Auto-generated method stub
		System.out.println("java interest 7%");
	}

	@Override
	public void homeloan() {
		// TODO Auto-generated method stub
		System.out.println("java homeloan : 9%");
	}
}
public class AbstractionClass {
	public static void main(String[] args) {
		SBI sbi = new SBI();
		sbi.interest();
		sbi.homeloan();
		sbi.repoRate();
		SBI.repoRate();
		PNB pnb = new PNB();
		pnb.interest();
		pnb.homeloan();
		PNB.repoRate();
		JAVA java = new JAVA();
		java.interest();
		java.homeloan();
		JAVA.repoRate();
	}
}

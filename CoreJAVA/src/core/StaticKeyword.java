package core;
class Data{
	static {
		System.out.println("static inside data class");
	}
	int rollno;
	String name;
	double per;
	static String cname = "TOPS";
	Data(int rollno,String name,double per){
		this.rollno = rollno;
		this.name = name;
		this.per = per;
	}
	public void showData() {
		System.out.println("rollno : "+rollno+" name : "+name+" per : "+per+" cname : "+cname);
	}
	public static void run() {
		System.out.println("statcic method");
	}
}
public class StaticKeyword {
	static {
		System.out.println("static inside main class");
	}
	public static void main(String[] args) {
		Data d1 = new Data(1, "tirrth", 60.6);
		d1.showData();
		Data d2 = new Data(2, "priyanka", 60.2);
		d2.showData();
		Data d3 = new Data(3, "sherwin", 60.4);
		d3.showData();
		Data d4 = new Data(4, "gaurang", 60.7);
		d4.showData();
		Data d5 = new Data(5, "dhaval", 60.7);
		d5.showData();
		Data.run();
	}
}

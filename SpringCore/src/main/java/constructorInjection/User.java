package constructorInjection;

public class User {
	private int a, b;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int a, int b) {
		super();
		System.out.println("integer cons");
		this.a = a;
		this.b = b;
	}

	public User(String a, String b) {
		super();
		System.out.println("String cons");
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
	}

	@Override
	public String toString() {
		return "User [a=" + a + ", b=" + b + "]";
	}

//	private int id;
//	private String name;
//	private double per;
//	public User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public User(String id, String name, String per) {
//		super();
//		System.out.println("setting values by cons argument String");
//		this.id = Integer.parseInt(id);
//		this.name = name;
//		this.per = Double.parseDouble(per);
//	}
//	public User(int id, String name, double per) {
//		super();
//		System.out.println("setting values by cons argument defualt");
//		this.id = id;
//		this.name = name;
//		this.per = per;
//	}
//	
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", per=" + per + "]";
//	}

}

package core;

class Call {
	int id;
	String name;

	Call() {
		System.out.println("this is default cons");
	}

	Call(int id) {
		System.out.println("id : " + id);
	}

	Call(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("id : " + id);
		System.out.println("name : " + name);
	}

	public void calling() {
		System.out.println("id : " + id + " name : " + name);
	}
}

class Call2 {
	int id;
	String name;

	Call2(Call call1) {
		this.id = call1.id;
		this.name = call1.name;
		System.out.println("id : " + id);
		System.out.println("name : " + name);
	}
}

class Call3 {
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}

public class ConstructorDemo {
	public static void main(String[] args) {
//		Call call1 = new Call(10,"java");
//		call1.calling();
//		Call2 call2 = new Call2(call1);
		Call3 c1 = new Call3();
		c1.setId(12);
//		c1.id=1;
		Call3 c2 = new Call3();
		c2.setId(13);
//		c2.id=1;
		System.out.println(c1.getId());
		System.out.println(c2.getId());
	}
}

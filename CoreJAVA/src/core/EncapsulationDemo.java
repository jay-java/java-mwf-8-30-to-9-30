package core;
class Student{
	private int id;
	private String name;
	private float per;
	Student(int id,String name,float per){
		this.id=id;
		this.name=name;
		this.per=per;
	}
	@Override
	public String toString() {
		return "["+"id : "+id+" name : "+name+" per : "+per+"]";
	}
}
public class EncapsulationDemo {
	public static void main(String[] args) {
		Student student1 = new Student(1, "sherwin", 67.76f);
//		student1.id=2;
		Student student2 = new Student(2, "priyanka", 68.76f);
		Student student3 = new Student(3, "dhaval", 69.76f);
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
	}
}

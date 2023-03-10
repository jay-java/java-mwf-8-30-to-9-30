package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student2 implements Serializable{
	int id;
	String name;
	double per;
	public Student2(int id, String name, double per) {
		super();
		this.id = id;
		this.name = name;
		this.per = per;
	}
	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", per=" + per + "]";
	}
}
public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("serialize.txt");

		Student2 student2 = new Student2(1, "java", 99.4);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(student2);
		oos.flush();
		oos.close();
		System.out.println("object written");
		
		FileInputStream fis = new FileInputStream("serialize.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student2 s = (Student2)ois.readObject();
		System.out.println(s);
 		
	}
}

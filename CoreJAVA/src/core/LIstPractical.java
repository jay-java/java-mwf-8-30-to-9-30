package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee{
	int id;
	String name;
	double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}
public class LIstPractical {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "c", 40000);
		Employee e2 = new Employee(2, "c++", 50000);
		Employee e3 = new Employee(3, "python", 60000);
		Employee e4 = new Employee(4, "java", 70000);
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		System.out.println(list);
		Iterator<Employee> iterator  = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

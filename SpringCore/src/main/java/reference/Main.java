package reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("reference/reference.xml");
		Person p1 =(Person)con.getBean("p1");
		System.out.println(p1);
	}
}

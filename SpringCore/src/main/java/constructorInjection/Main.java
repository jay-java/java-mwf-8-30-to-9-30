package constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("constructorInjection/constructorinjection.xml");
		User u = (User) con.getBean("u1");
		System.out.println(u);
	}
}

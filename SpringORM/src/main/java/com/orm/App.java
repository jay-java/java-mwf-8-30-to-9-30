package com.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext con  =new ClassPathXmlApplicationContext("com/orm/config.xml");
		User u1 = new User(1,"java",9876854);
		UserDao dao = (UserDao)con.getBean("dao");
		dao.insertUser(u1);
		System.out.println("data inserted");
	}
}

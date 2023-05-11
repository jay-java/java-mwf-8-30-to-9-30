package com.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext con  =new ClassPathXmlApplicationContext("com/orm/config.xml");
		User u1 = new User(2,"c++",9876854);
		UserDao dao = (UserDao)con.getBean("dao");
		List<User> list = dao.getAllUser();
		System.out.println(list);
		System.out.println("data inserted");
	}
}

package core;

import java.util.Scanner;

class Demo{
	public void run() {
		System.out.println("hello java");
	}
}
public class UserIInput {
	public static void main(String[] args) {
		System.out.println("hello main method");
		Demo d = new Demo();
		d.run();
		int i;
		System.out.println("enter i = ");
		Scanner scanner = new Scanner(System.in);
		i = scanner.nextInt();
		System.out.println(i);
//		scanner.close();
		
		String name;
		System.out.println("enter name : ");
		name = scanner.next();
		System.out.println(name);
		
		char c;
		System.out.println("enter c = ");
		c = scanner.next().charAt(0);
		System.out.println(c);
	}
	
}

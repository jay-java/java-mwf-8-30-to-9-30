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
		scanner.close();
		
	}
	
}

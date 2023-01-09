package core;

import java.util.Scanner;

public class ConditionalStatements {
	public static void main(String[] args) {
		int i, j, k;
		System.out.println("enter i = ");
		Scanner scanner = new Scanner(System.in);
		i = scanner.nextInt();
		System.out.println("entet j =");
		j = scanner.nextInt();
		// 1.if
		if (i > j) {
			System.out.println("i is grater than j");
		}

		// 2.if else
		if (i > j) {
			System.out.println("i is grater than j");
		} else {
			System.out.println("j is greater than i");
		}

		// 3.nested if
		int age;
		System.out.println("enter age : ");
		age = scanner.nextInt();
		if (age > 18) {
			if (age < 60) {
				System.out.println("eligible");
			} else {
				System.out.println("age is greater than 18 but less than 60");
			}
		} else {
			System.out.println("age is less than 18");
		}

		// else if ladder
		int marks;
		System.out.println("enter marks : ");
		marks = scanner.nextInt();
		if (marks < 35) {
			System.out.println("fail");
		} else if (marks >= 35 && marks <= 50) {
			System.out.println("D grade");
		} else if (marks >= 51 && marks <= 70) {
			System.out.println("C grade");
		} else if (marks >= 71 && marks <= 80) {
			System.out.println("B grade");
		} else if (marks >= 81 && marks <= 90) {
			System.out.println("A grade");
		} else if (marks >= 91 && marks <= 100) {
			System.out.println("A+ grade");
		} else {
			System.out.println("invalid input");
		}

		// 5.Switch case
		int lang;
		System.out.println("enter your choice : ");
		lang = scanner.nextInt();
		switch (lang) {
		case 1:
			System.out.println("you selected english");
			break;
		case 2:
			System.out.println("you selected hindi");
			break;
		case 3:
			System.out.println("you selected gujarati");
			break;
		default:
			System.out.println("invalid");
		}
	}
}

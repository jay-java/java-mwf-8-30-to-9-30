package core;

import java.util.InputMismatchException;
import java.util.Scanner;
class division{//B
	public void divide()  {
		int i,j,k;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter i = ");
		i = scanner.nextInt();
		System.out.println("enter j = ");
		j = scanner.nextInt();
		k = i/j;
		System.out.println(k);
		throw new ArithmeticException();
	}
}
public class ExceptionDemo {//A
	public static void main(String[] args) {
		try {
			division d = new division();
			d.divide();
		} catch (ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}
		catch (InputMismatchException e) {
			System.out.println("-------");
		}
		
		
		
		
		
//		try {
//			int i,j,k;
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("enter i = ");
//			i = scanner.nextInt();
//			System.out.println("enter j = ");
//			j = scanner.nextInt();
//			k = i/j;
//			System.out.println(k);
//			System.exit(1);
//		} catch (ArithmeticException e) {
//			System.out.println("number cannot divide by zero");
//		}
//		catch (InputMismatchException e) {
//			System.out.println("number cannot divide by string ");
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			System.out.println("this will execute everytime");
//		}
	}
}

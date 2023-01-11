package core;

import java.util.Scanner;

public class ArrayDemo {
	public static void main(String[] args) {
		int i[] = {1,2,3,4,5};
		for(int n=0;n<i.length;n++) {
			System.out.println(i[n]);
		}
		int size;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter size of array : ");
		size = scanner.nextInt();
		
		int arr[] = new int[size];
		for(int index=0;index<arr.length;index++) {
			System.out.print("enter value at arr["+index+"] : ");
			arr[index] = scanner.nextInt();
		}
		for(int index=0;index<arr.length;index++) {
			System.out.println("value at arr["+index+"] is "+arr[index]);
		}
		
		int sum=0;
		for(int index=0;index<arr.length;index++) {
			sum = sum+arr[index];
		}
		System.out.println("sum : "+sum);
		
		int num;
		int counter=0;
		System.out.println("enter number to search in array : ");
		num = scanner.nextInt();
		for(int index=0;index<arr.length;index++) {
			if(num == arr[index]) {
				counter++;
			}
		}
		if(counter==1) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
}

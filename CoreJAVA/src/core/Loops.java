package core;


public class Loops {
	public static void main(String[] args) {
		System.out.println("for loop ------");
		for(int i=5;i<=5;i++) {
			System.out.println(i);
		}
		System.out.println("while loop ---");
		int j = 1;
		while(j<=5) {
			System.out.println(j);
			j++;
		}	
		System.out.println("do while loop ---");
		int k=6;
		do {
			System.out.println(k);
			k++;
		}
		while(k<=5);
		
		for(int a=1;a<=5;a++) {
			
			for(int b=1;b<=a;b++) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}

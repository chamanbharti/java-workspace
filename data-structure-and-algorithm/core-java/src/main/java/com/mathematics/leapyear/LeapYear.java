package mathematics.leapyear;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter year to check leap year");
		int year = input.nextInt();
		
//		if(year % 400 ==0 || year % 4 ==0)
//			System.out.println("Leap Year");
//		else
//			System.out.println("not leap year");
		
		if(year % 4 ==0) {
			if(year % 100 !=0 || year % 400 ==0)
				System.out.println("Leap Year");
			else
				System.out.println("not leap year");
		}
		else {
			System.out.println("not leap year");
		}
	}

}

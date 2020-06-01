package problem;

import java.util.Scanner;

public class String_1152 {	// น้มุ 1152น๘	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str.trim();
		
		String[] arr = str.split(" ");
		
		if(str.isEmpty())
			System.out.println(0);
		else {
			System.out.println(arr.length);
		}
		
		sc.close();
	}
}
package problem;

import java.util.Scanner;

public class Math1_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int i=1;
		int num = 1;
		
		while(true) {
			if(x <= num) {
				if(i%2 == 0)
					System.out.println((i-(num - x)) + "/" + (1+(num - x)));	
				else
					System.out.println((1+(num - x)) + "/" + (i-(num - x)));
				break;
			}
			num += ++i;
		}
		
		sc.close();
	}

}

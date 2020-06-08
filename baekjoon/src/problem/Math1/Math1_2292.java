package problem.Math1;

import java.util.Scanner;

public class Math1_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int i = 1;
		int num = 1;
		
		while(true){
			if(n <= num) {
				System.out.println(i);
				break;
			}
			num += 6*i;
			i++;
		}
	/*	¹æ¹ý 2
		if(n == 1) {
			System.out.println(1);
		}
		else {
			n = n-2;
			while(true) {
				if(n >= 3*(Math.pow(i, 2)) - 3*i && n < 3*(Math.pow(i+1, 2)) - 3*(i+1)) {
					System.out.println(i+1);
					break;
				}
				i++;
			}
		}
	*/	
		sc.close();
	}

}

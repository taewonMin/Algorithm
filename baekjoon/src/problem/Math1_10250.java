package problem;

import java.util.Scanner;

public class Math1_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();		// 입력 개수
		int height, width, n;
		int[] result = new int[t];
		
		for(int i=0; i<t; i++) {
			height = sc.nextInt();	// 호텔 높이
			width = sc.nextInt();	// 호텔 넓이
			n = sc.nextInt();		// n번째 손님
						
			if(n % height == 0)
				result[i] = height*100 + (n-1)/height + 1;
			else
				result[i] = n%height*100 + (n-1)/height + 1;
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}

}

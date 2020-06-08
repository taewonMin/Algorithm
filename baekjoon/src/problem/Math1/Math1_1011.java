package problem.Math1;

import java.util.Scanner;

public class Math1_1011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] rst = new int[T];
		
		for(int i = 0; i<T; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int dst = y-x;
			int sqrtDst = (int)Math.sqrt(dst);		// 거리의 제곱근
			rst[i] = 2*sqrtDst - 1;
			
			if(sqrtDst != Math.sqrt(dst)) {			// 소수점이 있으면
				rst[i]++;
				if(dst > sqrtDst*sqrtDst + sqrtDst)
					rst[i]++;
			}
		}
		
		for(int i=0; i<T; i++)
			System.out.println(rst[i]);
		
		sc.close();
	}

}

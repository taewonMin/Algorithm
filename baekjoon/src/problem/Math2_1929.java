package problem;

import java.util.Scanner;

public class Math2_1929 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			boolean[] prime = new boolean[N+1];
			
			for(int i=2; i<=Math.sqrt(N); i++) {
				if(prime[i] == false)	{				// 소수이면
					int n = 2;
					// 배수를 모두 지움
					for(int j=i*n; j<=N; j=i*n) {
						prime[j] = true;
						n++;	
					}
				}
			}
			
			for(int i=M; i<=N; i++) {
				if(i != 1 && prime[i] == false) 		// 소수이면
					System.out.println(i);
			}
			
			sc.close();
	}
}
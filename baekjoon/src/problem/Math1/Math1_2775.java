package problem.Math1;

import java.util.Scanner;

public class Math1_2775 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int t = sc.nextInt();		// 입력 개수
			int k, n;
			int[] result = new int[t];
			int[] room = new int[14];
			
			for(int i=0; i<t; i++) {
				k = sc.nextInt();	// k층
				n = sc.nextInt();	// n호
				
				if(n == 1) {
					result[i] = 1;
					continue;
				}
				for(int j=0; j<room.length; j++)
					room[j] = j+1;
				
				for(int j=0; j<k; j++) {
					for(int m=1; m<room.length; m++) {
						room[m] = room[m-1] + room[m];
						if(j == k-1 && m == n-1) {	// 구하는 층에 도달하면
							result[i] = room[m];
							break;
						}
					}	
				}
			}
        
			for(int i=0; i<t; i++)
				System.out.println(result[i]);
			
			sc.close();
	}
}
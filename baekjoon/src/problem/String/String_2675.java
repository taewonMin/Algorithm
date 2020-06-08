package problem.String;

import java.util.Arrays;
import java.util.Scanner;

public class String_2675 {	// 백준 2675번
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	// test case num
		
		String[] result = new String[t];
		
		Arrays.fill(result, "");
	
		
		for(int i=0; i<t; i++) {
			int r = sc.nextInt();	// 1 <= R <= 8
			String s = sc.next();	// 1 < S <= 20
			for(int j=0; j<s.length(); j++) {	// 한글자씩 자르기
				String temp = Character.toString(s.charAt(j));
				for(int k=0; k<r; k++) {	// 글자당 r만큼 반복
					result[i] += temp;
				}
			}
		}
		
		// 출력
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
	
		sc.close();
	}
}

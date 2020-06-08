package problem.String;

import java.util.Arrays;
import java.util.Scanner;

public class String_2675 {	// ���� 2675��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	// test case num
		
		String[] result = new String[t];
		
		Arrays.fill(result, "");
	
		
		for(int i=0; i<t; i++) {
			int r = sc.nextInt();	// 1 <= R <= 8
			String s = sc.next();	// 1 < S <= 20
			for(int j=0; j<s.length(); j++) {	// �ѱ��ھ� �ڸ���
				String temp = Character.toString(s.charAt(j));
				for(int k=0; k<r; k++) {	// ���ڴ� r��ŭ �ݺ�
					result[i] += temp;
				}
			}
		}
		
		// ���
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
	
		sc.close();
	}
}

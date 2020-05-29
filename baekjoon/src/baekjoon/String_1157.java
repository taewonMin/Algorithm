package baekjoon;

import java.util.Scanner;

public class String_1157 {	// 백준 1157번
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next().toUpperCase();
		
		int[] cnt = new int[26];	// 알파벳 빈도수 저장
		
		int max = 0;
		int pos = 0;
		char result = '?';
		
		for(int i=0; i<str.length(); i++) {
			pos = str.charAt(i) - 65;
			cnt[pos]++;
			if(max < cnt[pos]) {
				max = cnt[pos];
				result = str.charAt(i);
			}
			else if(max == cnt[pos]) {
				result = '?';
			}
		}
	
		System.out.println(result);
		
		sc.close();
	}
}
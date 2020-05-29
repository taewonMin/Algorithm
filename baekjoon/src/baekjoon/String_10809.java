package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class String_10809 {	// น้มุ 10809น๘

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] abc = new int[26];
		Arrays.fill(abc, -1);
		
		String input = br.readLine();
		int num;
	
		for(int i=0; i<input.length(); i++) {
			num = input.charAt(i) - 97;
			if(abc[num] == -1) {
				abc[num] = i;
			}
		}
		
		String result = "";
		for(int i=0; i<26; i++) {
			result += abc[i] + " ";
		}
		System.out.println(result);
	}

}

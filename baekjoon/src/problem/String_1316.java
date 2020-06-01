package problem;

import java.util.Scanner;

public class String_1316 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int num = sc.nextInt();		// 단어 입력 개수
			int result = num;			// 그룹 단어의 개수
			String[] word = new String[num];
			
			for(int i=0; i<num; i++) {
				word[i] = sc.next();
				boolean[] check = new boolean[26];
				
				for(int j=0; j<word[i].length(); j++) {
					if(j > 0 && word[i].charAt(j-1) != word[i].charAt(j)) {	 // 이전 글자와 달라지면
						// 현재 글자가 이미 나온 글자인지 체크
						if(check[word[i].charAt(j) - 97] == true) {
							result--;
							break;
						}
					}
					check[word[i].charAt(j) - 97] = true;	// 한번 나온 글자는 체크
				}
			}
			
			System.out.println(result);
			
			
			sc.close();
	}

}

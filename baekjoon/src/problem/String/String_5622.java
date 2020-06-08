package problem.String;

import java.util.Scanner;

public class String_5622 {

	public static void main(String[] args) {	// 백준 5622번
			Scanner sc = new Scanner(System.in);
		
			int result = 0;	// 제일 가까운 번호 2초
			int num;	// 입력 문자를 숫자로 변환
			
			String input = sc.nextLine();	// 입력받은 문자열
			
			for(int i=0; i<input.length(); i++) {	// 문자열 길이만큼 반복
				num = input.charAt(i) - 65;
				if(num >= 18) {
					num--;
					if(num == 24) 
						num--;
				}
				result += num/3 + 3;
			}
			
			System.out.println(result);
	
			sc.close();
	}

}

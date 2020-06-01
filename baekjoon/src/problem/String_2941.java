package problem;

import java.util.Scanner;

public class String_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		// 规过 1 - switch case
		/*int result = 0;
		
		for(int i=0; i<str.length(); i++) {
			result++;
			switch(str.charAt(i)) {
			case '=':
				if(i > 1 && str.charAt(i-1) == 'z' && str.charAt(i-2) == 'd')
					result--;
				result--;
				break;
			case '-':
				result--;
				break;
			case 'j':
				if(i > 0 && (str.charAt(i-1) == 'n' || str.charAt(i-1) == 'l')) {
					result--;
					break;
				}
			}
		}*/
	
		
		// 规过 2 - contains, replace function
		String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<word.length; i++) {
			if(str.contains(word[i])) {
				str = str.replace(word[i], "*");
			}
		}
		
		System.out.println(str.length());

		sc.close();
	}


}

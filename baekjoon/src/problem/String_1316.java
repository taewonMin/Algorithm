package problem;

import java.util.Scanner;

public class String_1316 {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int num = sc.nextInt();		// �ܾ� �Է� ����
			int result = num;			// �׷� �ܾ��� ����
			String[] word = new String[num];
			
			for(int i=0; i<num; i++) {
				word[i] = sc.next();
				boolean[] check = new boolean[26];
				
				for(int j=0; j<word[i].length(); j++) {
					if(j > 0 && word[i].charAt(j-1) != word[i].charAt(j)) {	 // ���� ���ڿ� �޶�����
						// ���� ���ڰ� �̹� ���� �������� üũ
						if(check[word[i].charAt(j) - 97] == true) {
							result--;
							break;
						}
					}
					check[word[i].charAt(j) - 97] = true;	// �ѹ� ���� ���ڴ� üũ
				}
			}
			
			System.out.println(result);
			
			
			sc.close();
	}

}

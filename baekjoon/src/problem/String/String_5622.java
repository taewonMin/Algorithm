package problem.String;

import java.util.Scanner;

public class String_5622 {

	public static void main(String[] args) {	// ���� 5622��
			Scanner sc = new Scanner(System.in);
		
			int result = 0;	// ���� ����� ��ȣ 2��
			int num;	// �Է� ���ڸ� ���ڷ� ��ȯ
			
			String input = sc.nextLine();	// �Է¹��� ���ڿ�
			
			for(int i=0; i<input.length(); i++) {	// ���ڿ� ���̸�ŭ �ݺ�
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

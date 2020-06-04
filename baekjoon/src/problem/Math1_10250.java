package problem;

import java.util.Scanner;

public class Math1_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();		// �Է� ����
		int height, width, n;
		int[] result = new int[t];
		
		for(int i=0; i<t; i++) {
			height = sc.nextInt();	// ȣ�� ����
			width = sc.nextInt();	// ȣ�� ����
			n = sc.nextInt();		// n��° �մ�
						
			if(n % height == 0)
				result[i] = height*100 + (n-1)/height + 1;
			else
				result[i] = n%height*100 + (n-1)/height + 1;
		}
		
		for(int i=0; i<t; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}

}

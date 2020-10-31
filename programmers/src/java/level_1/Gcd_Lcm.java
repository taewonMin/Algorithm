package level_1;

public class Gcd_Lcm {
	class Solution {
	    public int[] solution(int n, int m) {
	        int[] answer = new int[2];
	        
	        answer[0] = gcd(n, m);		// �ִ�����
	        answer[1] = n*m/gcd(n,m);	// �ּҰ����
	        
	        return answer;
	    }
	    
	    int gcd(int a, int b){	// ��Ŭ���� ȣ����
			return a%b==0 ? b : gcd(b, a%b);
	    }
	}
}

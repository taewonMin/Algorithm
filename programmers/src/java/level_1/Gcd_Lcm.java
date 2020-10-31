package level_1;

public class Gcd_Lcm {
	class Solution {
	    public int[] solution(int n, int m) {
	        int[] answer = new int[2];
	        
	        answer[0] = gcd(n, m);		// 최대공약수
	        answer[1] = n*m/gcd(n,m);	// 최소공배수
	        
	        return answer;
	    }
	    
	    int gcd(int a, int b){	// 유클리드 호제법
			return a%b==0 ? b : gcd(b, a%b);
	    }
	}
}

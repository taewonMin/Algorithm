package level_1;

public class Collatz {
	class Solution {
	    public int solution(int num) {
	        int answer = 0;
	        long num2 = num;    // int로 하면 overflow가 생길 수 있음
	        while(num2!=1){
	        	if(answer==500){
	        		answer = -1;
	        		break;
	        	}
	        	if(num2%2==0){	// 짝수이면
	        		num2 /= 2;
	        	}else{	// 홀수이면
	        		num2 = 3*num2 + 1;
	        	}
	        	answer++;
	        }
	        
	        return answer;
	    }
	}
}

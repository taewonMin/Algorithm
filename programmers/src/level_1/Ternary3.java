package level_1;

import java.util.Stack;

public class Ternary3 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        //3진법으로 바꾼 자리수 구하기
	        int pow = 0;
	        while(true){
	        	if(Math.pow(3, pow)<=n && n<Math.pow(3, ++pow)){
	        		break;
	        	}
	        }
	        //3진법으로 바꾼후 뒤집고 10진법 변환
	        for(int i=0; i<pow; i++){
	        	answer += n%3*Math.pow(3,pow-1-i);
	        	n /= 3;
	        }
	      
	        //stack을 이용한 방법
	/*       Stack<Integer> stack = new Stack<Integer>();
	        while(true){
	            stack.push(n%3);
	            n /= 3;
	            if(n==0)
	            	break;
	        }
	        int size = stack.size();
	        for(int i=0; i<size; i++){
	    		answer += stack.pop()*Math.pow(3, i);
	        }
	*/
	        return answer;
	    }
	}
}

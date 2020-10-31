package level_1;

import java.util.Stack;

public class Ternary3 {
	class Solution {
	    public int solution(int n) {
	        int answer = 0;
	        //3�������� �ٲ� �ڸ��� ���ϱ�
	        int pow = 0;
	        while(true){
	        	if(Math.pow(3, pow)<=n && n<Math.pow(3, ++pow)){
	        		break;
	        	}
	        }
	        //3�������� �ٲ��� ������ 10���� ��ȯ
	        for(int i=0; i<pow; i++){
	        	answer += n%3*Math.pow(3,pow-1-i);
	        	n /= 3;
	        }
	      
	        //stack�� �̿��� ���
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

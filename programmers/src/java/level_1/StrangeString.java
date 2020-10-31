package java.level_1;

public class StrangeString {
	class Solution {
	    public String solution(String s) {
	    	String answer = "";
	        String[] temp = s.split("");
	        int cnt = 0;
	        for(int i=0; i<temp.length; i++){
	    		if(temp[i].equals(" ")){
	    			answer += temp[i].toLowerCase();
	    			cnt = 0;
	    		}else{
	    			if(cnt%2==0){	// 짝수번째 문자이면
	        			answer += temp[i].toUpperCase();
	        		}else{
	        			answer += temp[i].toLowerCase();
	            	}
	    			cnt++;
	    		}
	        }
	        return answer;
	    }
	}
}

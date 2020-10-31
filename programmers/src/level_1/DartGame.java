package level_1;

public class DartGame {
	class Solution {
	    public int solution(String dartResult) {
	        int answer = 0;
	        int[] score = new int[3];
	        int idx = 0;
	        for(int i=0; i<dartResult.length(); i++){
	        	char temp = dartResult.charAt(i);
	        	switch(temp){
	        		case '*':	//이전숫자&현재숫자 2배
	        			if(idx > 1)
	        				score[idx-2] *= 2;
	    				score[idx-1] *= 2;
	        			break;
	        		case '#':	//-1 곱하기
	        			score[idx-1] *= -1;
	        			break;
	        		case 'S':	//1제곱
	        			break;
	        		case 'D':	//2제곱
	        			score[idx-1] = (int)Math.pow(score[idx-1],2);
	        			break;
	        		case 'T':	//3제곱
	        			score[idx-1] = (int)Math.pow(score[idx-1],3);
	        			break;
	        		case '0':	//숫자10
	        			if(i>0 && dartResult.charAt(i-1)=='1'){	//첫번째 숫자가 아니고 앞의숫자가 1이면
	        				score[idx-1] = 10;
	        				break;
	        			}
	    			default:	// 숫자
	        			score[idx++] = temp-48;
	        	}
	        }
	        for(int i=0; i<score.length; i++){
	        	answer += score[i];
	        }
	        return answer;
	    }
	}
}

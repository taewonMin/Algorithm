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
	        		case '*':	//��������&������� 2��
	        			if(idx > 1)
	        				score[idx-2] *= 2;
	    				score[idx-1] *= 2;
	        			break;
	        		case '#':	//-1 ���ϱ�
	        			score[idx-1] *= -1;
	        			break;
	        		case 'S':	//1����
	        			break;
	        		case 'D':	//2����
	        			score[idx-1] = (int)Math.pow(score[idx-1],2);
	        			break;
	        		case 'T':	//3����
	        			score[idx-1] = (int)Math.pow(score[idx-1],3);
	        			break;
	        		case '0':	//����10
	        			if(i>0 && dartResult.charAt(i-1)=='1'){	//ù��° ���ڰ� �ƴϰ� ���Ǽ��ڰ� 1�̸�
	        				score[idx-1] = 10;
	        				break;
	        			}
	    			default:	// ����
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

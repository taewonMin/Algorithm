package level_1;

import java.util.Stack;

public class PlusNum2 {
	class Solution {
	    public int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        
	        Stack<Integer> stack = new Stack<>();	// �ٱ���
	        for(int i=0; i<moves.length; i++){
	        	for(int j=0; j<board.length; j++){	// �Ʒ��� ����Ž��
	        		int doll = board[j][moves[i]-1];	//������ ����
	        		if(doll != 0){	// ������� ������
	        			board[j][moves[i]-1] = 0;	// ����
	        			if(stack.isEmpty()){
	        				stack.push(doll);
	        				break;
	        			}else{
	        				if(stack.peek()==doll){	// ���� �����̸�
	        					stack.pop();
	        					answer+=2;
	        				}else{
	        					stack.push(doll);
	        				}
	        				break;
	        			}
	        		}
	        	}
	        }
	        return answer;
	    }
	}
}



package programmers;

import java.util.Stack;

public class Dolldraw {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] board = {
							{0,0,0,0,0},
							{0,0,1,0,3},
							{0,2,5,0,1},
							{4,2,4,4,2},
							{3,5,1,3,1}
						};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(sol.solution(board, moves));
	}
}


class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();	// 바구니
        for(int i=0; i<moves.length; i++){
        	for(int j=0; j<board.length; j++){	// 아래로 순차탐색
        		int doll = board[j][moves[i]-1];	//인형의 종류
        		if(doll != 0){	// 비어있지 않으면
        			board[j][moves[i]-1] = 0;	// 뺀다
        			if(stack.isEmpty()){
        				stack.push(doll);
        				break;
        			}else{
        				if(stack.peek()==doll){	// 같은 인형이면
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
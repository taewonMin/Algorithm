package java.level_1;

public class PressKeypad {
	class Solution {
	    public String solution(int[] numbers, String hand) {
	        String answer = "";
	        Pos.hand = hand;
	        Pos left = new Pos(1);	//�޼� �ʱ���ġ : 4,1
	        Pos right = new Pos(3);	//������ �ʱ���ġ : 4,3
	        for(int i=0; i<numbers.length; i++){
	        	if(numbers[i]==0)
	        		numbers[i]=11;
	        	if(numbers[i]%3==2){	//2,5,8,0
	        		//�Ÿ���
	        		if(left.distance(numbers[i]) < right.distance(numbers[i])){
	        			left.setPos(numbers[i]);
	        			answer += "L";
	        		}else if(left.distance(numbers[i]) > right.distance(numbers[i])){
	        			right.setPos(numbers[i]);
	        			answer += "R";
	        		}else{	//�Ÿ��� ������
	        			answer += hand.equals("right") ? right.setPos(numbers[i]) : left.setPos(numbers[i]);
	        		}
	        	}else if(numbers[i]%3==1){	//1,4,7
	        		answer += left.setPos(numbers[i]);
	        	}else{	//3,6,9
	        		answer += right.setPos(numbers[i]);
	        	}
	        }
	        return answer;
	    }
	}
}

class Pos{
	int row = 4;
	int col = 0;
	static String hand;
	
	Pos(int col){
		this.col = col;
	}
	
	int distance(int n){
		int dis = Math.abs(col-2);	// �� �Ÿ�
		dis += Math.abs(row-(n/3+1)); // �� �Ÿ�
		return dis;
	}
	
	String setPos(int n){
		if(n%3==2){	// ���
			col = 2;
			row = n/3+1;
			return hand.equals("right") ? "R" : "L";
		}else if(n%3==1){	// �޼�
			col = 1;
			row = n/3+1;
			return "L";
		}else{	// ������
			col = 3;
			row = n/3;
			return "R";
		}
	}
}
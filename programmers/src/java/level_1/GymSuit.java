package level_1;

public class GymSuit {
	class Solution {
	    public int solution(int n, int[] lost, int[] reserve) {
	        int answer = n-lost.length;	//������ ���� �� �ִ� �л� ��
	        // �Ҿ�������� �����ִ»�� ����
	        for(int i=0; i<lost.length; i++){	
	        	for(int j=0; j<reserve.length; j++){
	        		if(lost[i]==reserve[j]){
	        			lost[i] = -1;
	        			reserve[j] = -1;
	        			answer++;
	        			break;
	        		}
	        	}
	        }
	        
	        for(int i=0; i<lost.length; i++){
	        	for(int j=0; j<reserve.length; j++){
	        		if(lost[i]==reserve[j]-1 || lost[i]==reserve[j]+1){
	        			reserve[j] = -1;
	        			answer++;
	        			break;
	        		}
	        	}
	        }
	        
	        
	// �׽�Ʈ���̽� 7�� �� �ȵǴ��� �� ���� ���٤�������������
//	      boolean[] lostStd = new boolean[n];	// �Ҿ���� �л� üũ �迭
	        
//	      for(int i=0; i<lost.length; i++){	// �Ҿ�������� true
//	      	lostStd[lost[i]-1] = true;
//	      }
	        
//	        for(int i=0; i<reserve.length; i++){
//	        	if(lostStd[reserve[i]-1]==true){	// ������ ������ �ִ� �л��� �Ҿ��������
//	        		lostStd[reserve[i]-1] = false;
//	        	}else if(reserve[i]!=1 && lostStd[reserve[i]-2]==true){	// ������ ������ �ִ� �л��� �չ�ȣ	
//	        		lostStd[reserve[i]-2] = false;
//	        	}else if(reserve[i]!=n && lostStd[reserve[i]]==true){	// ������ ������ �ִ� �л��� �޹�ȣ
//	        		lostStd[reserve[i]] = false;
//	        	}else{
//	        		continue;
//	        	}
//	        	answer++;
//	        }
	        
	        return answer;
	    }
	}
}

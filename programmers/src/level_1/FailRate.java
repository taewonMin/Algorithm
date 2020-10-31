package level_1;

public class FailRate {
	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] reach = new int[N+1];		// �ش� ���������� ������ ��� ��
	        int[] challenger = new int[N+1];// �ش� ���������� ���������� Ŭ���� ���� ���� ��� ��
	        for(int i=0; i<stages.length; i++){
	        	if(stages[i]<=N)
	        		challenger[stages[i]]++;
	        	if(stages[i]==N+1)
	    			stages[i]--;
	        	for(int j=1; j<=stages[i]; j++){
	        		reach[j]++;
	        	}
	        }
	        // ������ : ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� / ���������� ������ �÷��̾� ��
	        float[] fail = new float[N+1];	//������
	        for(int i=1; i<N+1; i++){
	    		fail[i] = reach[i]==0 ? 0 : (float)challenger[i]/reach[i];
	        }
	        // �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭 return
	        for(int i=0; i<fail.length-1; i++){
	        	int maxIdx = 1;
	        	//�ִ� ã��
		        for(int j=2; j<fail.length; j++){
	        		if(fail[j]>fail[maxIdx])
	            		maxIdx = j;
		        }
		        fail[maxIdx] = -1f;
		        answer[i] = maxIdx;
	        }
	        return answer;
	    }
	}
}

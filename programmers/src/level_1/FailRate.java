package level_1;

public class FailRate {
	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] reach = new int[N+1];		// 해당 스테이지를 도달한 사람 수
	        int[] challenger = new int[N+1];// 해당 스테이지에 도달했지만 클리어 하지 못한 사람 수
	        for(int i=0; i<stages.length; i++){
	        	if(stages[i]<=N)
	        		challenger[stages[i]]++;
	        	if(stages[i]==N+1)
	    			stages[i]--;
	        	for(int j=1; j<=stages[i]; j++){
	        		reach[j]++;
	        	}
	        }
	        // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	        float[] fail = new float[N+1];	//실패율
	        for(int i=1; i<N+1; i++){
	    		fail[i] = reach[i]==0 ? 0 : (float)challenger[i]/reach[i];
	        }
	        // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열 return
	        for(int i=0; i<fail.length-1; i++){
	        	int maxIdx = 1;
	        	//최댓값 찾기
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

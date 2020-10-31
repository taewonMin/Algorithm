package level_1;

import java.util.ArrayList;

public class PracticeTest {
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] cnt = new int[3];	// 정답횟수 세기
	        //1 12345
	    	int[] checkArr = {1,2,3,4,5};
	        //2 21232425
	        int[] checkArr1 = {2,1,2,3,2,4,2,5};
	        //3 31245 각 2번씩
	        int[] checkArr2 = {3,3,1,1,2,2,4,4,5,5};
	        for(int i=0; i<answers.length; i++){
	        	if(checkArr[i%checkArr.length]==answers[i]){	//1
	        		cnt[0]++;
	        	}
	        	if(checkArr1[i%checkArr1.length]==answers[i]){	//2
	        		cnt[1]++;
	        	}
	        	if(checkArr2[i%checkArr2.length]==answers[i]){	//3
	        		cnt[2]++;
	        	}
	        }
	        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);	// 최댓값 찾기
	        ArrayList<Integer> temp = new ArrayList<>();
	        for(int i=0; i<cnt.length; i++){
	        	if(cnt[i]==max){
	        		temp.add(i+1);	//최대 정답자 찾기
	        	}
	        }
	        int[] answer = new int[temp.size()];
	        for(int i=0; i<temp.size(); i++){
	        	answer[i] = temp.get(i);
	        }
	        
	        return answer;
	    }
	}
}

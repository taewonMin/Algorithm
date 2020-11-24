package level_2;

import java.util.HashMap;
import java.util.Map;

public class Spy {	// 위장
	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        
	        // 각 부위 별로 Map에 옷의 수량을 저장
	        Map<String, Integer> map = new HashMap<>();
	        for (int i = 0; i < clothes.length; i++) {
	    		map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1)+1);
			}
	        
	        for(Integer i : map.values()) {
	        	answer *= i;
	        }
	        
	        return answer-1;
	    }
	}
}

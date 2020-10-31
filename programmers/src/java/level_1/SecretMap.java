package level_1;

public class SecretMap {
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        
	        String[][] map = new String[n][n];
	        for(int i=0; i<map.length; i++){
	        	for(int j=map[i].length-1; j>-1; j--){
	        		map[i][j] = (arr1[i]%2==1 || arr2[i]%2==1) ? "#" : " ";
	        		arr1[i]/=2;
	        		arr2[i]/=2;
	        	}
	        	answer[i] = "";
	        	for(int j=0; j<map[i].length; j++){
	        		answer[i] += map[i][j];
	        	}
	        }
	        
	        return answer;
	    }
	}
}

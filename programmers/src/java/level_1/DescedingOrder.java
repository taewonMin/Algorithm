package level_1;

import java.util.Arrays;
import java.util.ArrayList;

public class DescedingOrder {

	class Solution {
	    public long solution(long n) {
	        long answer = 0;
	        /*String[] temp = String.valueOf(n).split("");
	        String str = "";
	        
	        Arrays.sort(temp);
	        
	        for(int i=temp.length-1; i>-1; i--){
	        	str += temp[i];
	        }
	        answer = Long.parseLong(str);*/
	        
	        // 아래 코드가 더 빠름
	        ArrayList<Long> temp = new ArrayList<>();
	        temp.add(n%10);
	        while(true){
	            n /= 10;
	        	if(n==0)
	        		break;
	        	//내림차순 정렬
	        	int len = temp.size();
	        	for(int i=0; i<len; i++){
	        		if(n%10 >= temp.get(i)){
	        			temp.add(i,n%10);
	        			break;
	        		}
	        		if(i == len-1)
	        			temp.add(n%10);
	        	}
	        }
	        String str = "";
	        for(int i=0; i<temp.size(); i++){
	        	str += temp.get(i);
	        }
	        answer = Long.parseLong(str);
	        return answer;
	    }
	}
}

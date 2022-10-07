package skill_test.level_1;

import java.util.ArrayList;
import java.util.List;

class Prob_1{
    public static void main(String[] args) {
        System.out.println(new Solution().solution(125));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        while(n > 2){
            list.add(n%3);
            n /= 3;
        }
        list.add(n%3);

        int k = 1;
        for(int i=list.size()-1; i>=0; i--){
            answer += list.get(i)*k;
            k*=3;
        }

        return answer;
    }
}
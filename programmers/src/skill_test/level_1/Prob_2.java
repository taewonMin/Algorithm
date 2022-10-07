package skill_test.level_1;

public class Prob_2 {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}

class Solution {
    char[] type = new char[26];
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for(int i=0; i<survey.length; i++){
            int score = choices[i]-4;
            if(score < 0){
                type[survey[i].charAt(0) - 'A'] += score*-1;
            }else if(score > 0){
                type[survey[i].charAt(1) - 'A'] += score;
            }
        }

        answer += getType('R', 'T');
        answer += getType('C', 'F');
        answer += getType('J', 'M');
        answer += getType('A', 'N');

        return answer;
    }

    public char getType(char left, char right){
        if(type[left-'A'] >= type[right-'A']){
            return left;
        }else{
            return right;
        }
    }
}
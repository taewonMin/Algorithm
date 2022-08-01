package level_2.BruteForce;

// 카펫
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Carpet{
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] res = sol.solution(24, 24);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            int b = brown/2 + 2;
            int d = (int) Math.sqrt(Math.pow(b, 2)-4*(brown+yellow));
            answer = new int[]{(b+d)/2, (b-d)/2};

            return answer;
        }
    }
}
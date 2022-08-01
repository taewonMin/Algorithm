package level_1.BruteForce;

// 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class MinSquare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int maxWidth = 0;
            int maxHeight = 0;
            for(int i=0; i<sizes.length; i++){
                int max = Math.max(sizes[i][0], sizes[i][1]);
                int min = Math.min(sizes[i][0], sizes[i][1]);

                maxWidth = Math.max(maxWidth, max);
                maxHeight = Math.max(maxHeight, min);
            }

            return maxWidth*maxHeight;
        }
    }
}

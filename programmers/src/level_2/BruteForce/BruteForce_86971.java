package level_2.BruteForce;

// 전력망을 둘로 나누기
// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class BruteForce_86971 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }

    static class Solution {
        public static boolean[][] map;
        public static int[] visited;
        public static boolean[][] complete;
        public static int visitCnt = 1;

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            map = new boolean[n][n];
            visited = new int[n];
            complete = new boolean[n][n];
            for(int i=0; i<wires.length; i++){
                int x = wires[i][0]-1;
                int y = wires[i][1]-1;
                map[x][y] = true;
                map[y][x] = true;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] && complete[i][j]==false){
                        map[i][j] = false;
                        map[j][i] = false;
                        answer = Math.min(answer, Math.abs(2*dfs(i)-n));
                        map[i][j] = true;
                        map[j][i] = true;
                        complete[j][i] = true;
                        visitCnt++;
                    }
                }
            }

            return answer;
        }

        public static int dfs(int start){
            visited[start] = visitCnt;
            int cnt = 1;
            for(int i=0; i<map.length; i++){
                if(map[start][i] && visited[i]!=visitCnt){
                    cnt += dfs(i);
                }
            }
            return cnt;
        }
    }
}

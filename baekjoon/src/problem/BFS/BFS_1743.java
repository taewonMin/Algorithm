package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 음식물 피하기
public class BFS_1743 {
    public static int N,M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] cond = br.readLine().split(" ");
        N = Integer.parseInt(cond[0]);
        M = Integer.parseInt(cond[1]);
        int K = Integer.parseInt(cond[2]);
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<K; i++){
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]==false && map[i][j]==1){
                    result = Math.max(result, bfs(i,j));
                }
            }
        }

        System.out.println(result);
        br.close();
    }

    public static int bfs(int x, int y){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];
                if(oob(nx, ny) || visited[nx][ny] || map[nx][ny]==0) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

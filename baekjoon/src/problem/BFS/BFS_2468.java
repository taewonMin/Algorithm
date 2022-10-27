package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 안전 영역
public class BFS_2468 {
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int result = 1;
        int min = Integer.MAX_VALUE;
        int max = 0;
        map = new int[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for(int k=min; k<=max; k++){
            int cnt = 0;
            visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]==false && map[i][j] > k){
                        bfs(i,j,k);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
        br.close();
    }

    public static void bfs(int x, int y, int water){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i=0; i<4; i++){
                int nx = node[0]+dx[i];
                int ny = node[1]+dy[i];
                if(oob(nx, ny) || visited[nx][ny] || map[nx][ny] <= water) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}

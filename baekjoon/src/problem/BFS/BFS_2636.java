package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 치즈
public class BFS_2636 {
    public static int N,M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static List<int[]> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        int totalCnt = 0;
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                if(map[i][j]==1) totalCnt++;
            }
        }
        int time = 0;
        while(true){
            time++;
            int cnt = meltCheese();
            totalCnt -= cnt;
            if(totalCnt==0){
                System.out.println(time);
                System.out.println(cnt);
                break;
            }
        }

        br.close();
    }

    public static int meltCheese(){
        bfs();

        int cnt = edges.size();
        for(int[] edge : edges){
            map[edge[0]][edge[1]] = 0;
        }
        edges.clear();

        return cnt;
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited = new boolean[N][M];
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];
                if(oob(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if(map[nx][ny]==1){
                    edges.add(new int[]{nx,ny});
                }else{
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

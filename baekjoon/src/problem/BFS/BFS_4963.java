package problem.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 섬의 개수
public class BFS_4963 {
    public static int N,M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = input[1];
            M = input[0];
            if(N==0 && M==0) break;

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(visited[i][j]==false && map[i][j]==1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i=0; i<8; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];
                if(oob(nx, ny) || visited[nx][ny] || map[nx][ny]==0) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 테트로미노
public class Simulation_14500 {
    public static int N,M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int score = 0;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(i,j,0,map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(score);

        br.close();
    }

    public static void dfs(int x, int y, int k, int sum){
        if(k==3){
            score = Math.max(score, sum);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(oob(nx, ny) || visited[nx][ny]){
                continue;
            }
            // ㅜ 모양 탐색
            if(k==1){
                visited[nx][ny] = true;
                dfs(x,y,k+1,sum+map[nx][ny]);
                visited[nx][ny] = false;  
            }
            visited[nx][ny] = true;
            dfs(nx,ny,k+1,sum+map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

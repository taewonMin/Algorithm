package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 로봇 청소기
public class Simulation_14503 {
    public static int[][] map;
    public static int N,M,r,c,d;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        map[r][c] = 2;
        dfs(r, c);
        System.out.println(answer);

        br.close();
    }

    public static void dfs(int x, int y){
        boolean noClean = true;
        for(int i=0; i<4; i++){
            d = (d+3)%4;
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(map[nx][ny]==2 || map[nx][ny]==1){
                continue;
            }
            answer++;
            noClean = false;
            map[nx][ny] = 2;
            dfs(nx, ny);
            break;
        }
        if(noClean){
            int nx = x+dx[(d+2)%4];
            int ny = y+dy[(d+2)%4];
            if(map[nx][ny]!=1){
                dfs(nx, ny);
            }
        }
    }
}

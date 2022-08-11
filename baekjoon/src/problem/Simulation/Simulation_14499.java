package problem.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주사위 굴리기
public class Simulation_14499 {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int[] dice = new int[4];
    public static int top=0, left=0, right=0;
    public static int[][] map;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int N,M,x,y,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int dir = Integer.parseInt(st.nextToken())-1;
            moveDice(dir);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void moveDice(int dir) throws IOException{
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        if(oob(nx, ny)){
            return;
        }
        if(dir==0){ // 동쪽
            int temp = dice[top];
            dice[top] = left;
            left = dice[(top+2)%4];
            dice[(top+2)%4] = right;
            right = temp;
        }else if(dir==1){ // 서쪽
            int temp = dice[top];
            dice[top] = right;
            right = dice[(top+2)%4];
            dice[(top+2)%4] = left;
            left = temp;
        }else if(dir==2){ // 북쪽
            top = (top+1)%4;
        }else if(dir==3){   // 남쪽
            top = (top+3)%4;
        }
        copyNum(nx, ny);
        x = nx;
        y = ny;

        bw.write(dice[top]+"\n");
    }

    // 숫자 복사
    public static void copyNum(int x, int y){
        if(map[x][y]==0){
            map[x][y] = dice[(top+2)%4];
        }else{
            dice[(top+2)%4] = map[x][y];
            map[x][y] = 0;
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 연구소
public class Simulation_14502 {
    public static int N, M;
    public static int[][] map;
    public static ArrayList<int[]> birus = new ArrayList<>();
    public static int visit = 2;
    public static int emptySpace, result = 0;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        emptySpace = N*M-3;
        map = new int[N][M];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<M; j++){
                if(map[i][j]!=0){
                    emptySpace--;
                    if(map[i][j]==2){
                        birus.add(new int[]{i,j});
                    }
                }
            }
        }

        selectWall(0, 0, 0);
        System.out.println(result);

        br.close();
    }

    public static void selectWall(int k, int row, int col){
        if(k==3){
            int[][] copyMap = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]==2){
                        copyMap[i][j] = visit;
                    }else{
                        copyMap[i][j] = map[i][j];
                    }
                }
            }
            bfs(copyMap);
            visit++;
            return;
        }

        for(int i=row; i<N; i++){
            for(int j=col; j<M; j++){
                if(map[i][j]==0){
                    map[i][j] = 1;
                    selectWall(k+1, row+(j+1)/M, (j+1)%M);
                    map[i][j] = 0;
                }
            }
            col = 0;
        }
    }

    public static void bfs(int[][] map){
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(birus);
        int cnt = emptySpace;

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i=0; i<4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if(oob(nx,ny) || map[nx][ny]!=0){
                    continue;
                }
                map[nx][ny] = visit;
                cnt--;
                queue.offer(new int[]{nx, ny});
            }
        }

        result = Math.max(result, cnt);
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

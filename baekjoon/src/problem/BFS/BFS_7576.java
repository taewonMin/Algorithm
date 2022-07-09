package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 토마토
public class BFS_7576 {
    public static int[][] box;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int nonRipeCnt = 0;
    public static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        box = new int[input[1]][input[0]];
        visited = new boolean[input[1]][input[0]];
        for(int i=0; i<input[1]; i++){
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<input[0]; j++){
                if(box[i][j]!=-1){
                    if(box[i][j]==0){
                        nonRipeCnt++;
                    }else{
                        queue.offer(new int[]{i,j,0});
                        visited[i][j] = true;
                    }
                }
            }
        }

        if(nonRipeCnt==0){
            System.out.println(0);
        }else if(queue.isEmpty()){
            System.out.println(-1);
        }else{
            bfs();
        }

        br.close();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] tomato = queue.poll();
            for(int i=0; i<4; i++){
                int x = tomato[0]+dx[i];
                int y = tomato[1]+dy[i];
                if(boundaryCheck(x, y) && box[x][y] != -1 && visited[x][y]==false){
                    nonRipeCnt--;
                    if(nonRipeCnt==0){
                        System.out.println(tomato[2]+1);
                        return;
                    }
                    queue.offer(new int[]{x,y,tomato[2]+1});
                    visited[x][y] = true;
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean boundaryCheck(int x, int y){
        return 0 <= x && x < box.length && 0 <= y && y < box[0].length;
    }
}

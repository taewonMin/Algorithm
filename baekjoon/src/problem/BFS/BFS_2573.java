package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 빙산
public class BFS_2573 {
    public static int[][] iceberg;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        iceberg = new int[input[0]][input[1]];
        visited = new boolean[input[0]][input[1]];
        for(int i=0; i<input[0]; i++){
            iceberg[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int cnt = 0;
        loopOut:
        while(true){
            boolean yearCheck = false;
            for(int i=1; i<input[0]-1; i++){
                for(int j=1; j<input[1]-1; j++){
                    if(visited[i][j]==false && iceberg[i][j]!=0){
                        if(yearCheck){
                            System.out.println(cnt);
                            break loopOut;
                        }else{
                            bfs(i,j);
                            yearCheck = true;
                        }
                    }
                }
            }

            if(yearCheck==false){
                System.out.println(0);
                break;
            }

            for(boolean[] visit : visited){
                Arrays.fill(visit, false);
            }
            cnt++;
        }

        br.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i=0; i<4; i++){
                int posX = pos[0]+dx[i];
                int posY = pos[1]+dy[i];
                if(visited[posX][posY]==false){   
                    if(iceberg[posX][posY]==0){ // 빙산이 없는곳
                        if(iceberg[pos[0]][pos[1]] > 0){
                            iceberg[pos[0]][pos[1]]--;
                        }
                    }else{
                        queue.offer(new int[]{posX, posY});
                        visited[posX][posY] = true;
                    }
                }
            }
        }
    }
}

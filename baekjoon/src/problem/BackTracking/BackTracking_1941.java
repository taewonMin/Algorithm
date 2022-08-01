package problem.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 소문난 칠공주
public class BackTracking_1941{
    public static char[][] pos = new char[5][5];
    public static boolean[][] selected = new boolean[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int result = 0;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            pos[i] = br.readLine().toCharArray();
        }

        combination(0, 0);

        System.out.println(result);

        br.close();
    }

    // 25개 자리중 7개 선택
    public static void combination(int cnt, int num){
        if(cnt==7){
            for(boolean[] visit : visited){
                Arrays.fill(visit, false);
            }
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(selected[i][j] == true){
                        bfs(i, j);
                        return;
                    }
                }
            }
        }
        if(num==25){
            return;
        }

        int x = num/5;
        int y = num%5;
        selected[x][y] = true;
        combination(cnt+1, num+1);  // 선택
        selected[x][y] = false;
        combination(cnt, num+1); // 미선택
    }

    // 선택한 7개 위치가 연결되어있는지 확인
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        int cnt = 1;    // 연결된 개수
        int yCnt = pos[x][y]=='Y' ? 1 : 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i=0; i<4; i++){
                int posX = node[0]+dx[i];
                int posY = node[1]+dy[i];
                if(boundaryCheck(posX, posY) && !visited[posX][posY] && selected[posX][posY]){
                    visited[posX][posY] = true;
                    if(pos[posX][posY]=='Y'){
                        if(yCnt==3){
                            return;
                        }
                        yCnt++;
                    }
                    queue.offer(new int[]{posX, posY});
                    cnt++;
                }
            }
            if(cnt==7){
                result++;
                break;
            }
        }
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }
}
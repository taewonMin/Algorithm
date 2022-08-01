package problem.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 소문난 칠공주
public class BackTracking_1941{
    public static char[][] pos = new char[5][5];
    public static boolean[][] selected = new boolean[5][5];
    public static int[][] visited = new int[5][5];
    public static int visit = 1;
    public static int result = 0;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            pos[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0);

        System.out.println(result);

        br.close();
    }

    // 25개 자리중 7개 선택
    public static void combination(int cnt, int num, int yCnt){
        if(cnt==7){
            if(yCnt < 4){
                // bfs((num-1)/5, (num-1)%5);
                if(dfs((num-1)/5, (num-1)%5) == 7){
                    result++;
                }
                visit++;
            }
            return;
        }
        if(num==25){
            return;
        }

        int x = num/5;
        int y = num%5;
        selected[x][y] = true;
        combination(cnt+1, num+1, yCnt+(pos[x][y]=='Y' ? 1:0));  // 선택
        selected[x][y] = false;
        combination(cnt, num+1, yCnt); // 미선택
    }

    // 선택한 7개 위치가 연결되어있는지 확인
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = visit;

        int cnt = 1;    // 연결된 개수
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i=0; i<4; i++){
                int posX = node[0]+dx[i];
                int posY = node[1]+dy[i];
                if(boundaryCheck(posX, posY) && visited[posX][posY]!=visit && selected[posX][posY]){
                    visited[posX][posY] = visit;
                    queue.offer(new int[]{posX, posY});
                    cnt++;
                }
            }
        }
        if(cnt==7){
            result++;
        }
    }

    public static int dfs(int x, int y){
        int cnt = 1;
        visited[x][y] = visit;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(boundaryCheck(nx, ny) && visited[nx][ny]!=visit && selected[nx][ny]){
                cnt += dfs(nx,ny);
            }
        }
        return cnt;
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<5 && 0<=y && y<5;
    }
}
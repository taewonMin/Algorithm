package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Puyo Puyo
public class Simulation_11559 {
    public static char[][] game = new char[12][6];
    public static boolean[][] visited = new boolean[12][6];
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static boolean isRemoved = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<game.length; i++){
            game[i] = br.readLine().toCharArray();
        }

        int result = 0;
        while(true){
            for(int i=0; i<game.length; i++){
                for(int j=0; j<game[i].length; j++){
                    if(game[i][j] != '.' && visited[i][j]==false){
                        explosion(i, j);
                    }
                }
            }

            if(isRemoved){
                result++;
                isRemoved = false;

                pressDown();
                for(boolean[] visit : visited){
                    Arrays.fill(visit, false);
                }
            }else{
                break;
            }
        }

        System.out.println(result);

        br.close();
    }

    // 아래로 땡기기
    public static void pressDown(){
        for(int i=0; i<game[0].length; i++){
            int cnt = 0;
            for(int j=game.length-1; j>=0; j--){
                if(game[j][i]=='.'){
                    cnt++;
                }else if(cnt > 0){
                    game[j+cnt][i] = game[j][i];
                    game[j][i] = '.';
                }
            }
        }
    }

    // 4개 이상인 뿌요 터트리기
    public static void explosion(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        List<int[]> removeList = new ArrayList<>();
        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            removeList.add(pos);

            for(int i=0; i<4; i++){
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if(oob(nx,ny) || visited[nx][ny] || game[nx][ny]!=game[pos[0]][pos[1]]){
                    continue;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        if(removeList.size()>3){
            for(int[] pos : removeList){
                game[pos[0]][pos[1]] = '.';
            }
            isRemoved = true;
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=game.length || y<0 || y>=game[0].length;
    }
}

package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 양
public class BFS_3184 {
    public static int N, M, sheepCnt=0, wolfCnt=0;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j]==false && map[i][j]!='#'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(sheepCnt+" "+wolfCnt);

        br.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        int wolf = map[x][y]=='v' ? 1 : 0;
        int sheep = map[x][y]=='o' ? 1 : 0;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];
                if(oob(nx, ny) || visited[nx][ny] || map[nx][ny]=='#') continue;
                if(map[nx][ny]=='v'){
                    wolf++;
                }else if(map[nx][ny]=='o'){
                    sheep++;
                }
                queue.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }

        if(sheep > wolf){
            sheepCnt += sheep;
        }else{
            if(wolf > 0){
                wolfCnt += wolf;
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

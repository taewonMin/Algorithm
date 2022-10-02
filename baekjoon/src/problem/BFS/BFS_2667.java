package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 단지번호붙이기
public class BFS_2667 {
    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && visited[i][j]==false){
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int cnt : result){
            System.out.println(cnt);
        }

        br.close();
    }

    public static int bfs(int x, int y){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];
                if(oob(nx,ny) || visited[nx][ny] || map[nx][ny]==0) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx,ny});
                cnt++;
            }
        }

        return cnt;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}

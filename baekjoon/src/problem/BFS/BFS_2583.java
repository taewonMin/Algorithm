package problem.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 영역 구하기
public class BFS_2583 {
    public static int n,m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[m][n];
        visited = new boolean[m][n];
        int K = Integer.parseInt(input[2]);
        for(int k=0; k<K; k++){
            int[] coord = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=coord[1]; i<coord[3]; i++){
                for(int j=coord[0]; j<coord[2]; j++){
                    map[i][j] = 1;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false && map[i][j]==0){
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);
        bw.write(result.size()+"\n");
        for(int num : result){
            bw.write(num+" ");
        }
        
        br.close();
        bw.flush();
        bw.close();
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
                if(oob(nx, ny) || visited[nx][ny] || map[nx][ny]==1) continue;
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                cnt++;
            }
        }
        
        return cnt;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=m || y<0 || y>=n;
    }
}

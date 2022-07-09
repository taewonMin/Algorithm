package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 그림
public class BFS_1926 {
    public static int[][] picture;
    public static boolean[][] visited;
    public static int[] dx = {-1, 0, 1, 0}; // 행
    public static int[] dy = {0, 1, 0, -1}; // 열
    public static int max = 0;
    public static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        picture = new int[input[0]][input[1]];
        visited = new boolean[input[0]][input[1]];
        for(int i=0; i<input[0]; i++){
            picture[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0; i<input[0]; i++){
            for(int j=0; j<input[1]; j++){
                if(visited[i][j]==false && picture[i][j]==1){
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
        
        br.close();
    }    

    public static void bfs(int x, int y){
        int area = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            area++;
            for(int i=0; i<4; i++){
                int row = pos[0]+dx[i];
                int col = pos[1]+dy[i];
                if(boundaryCheck(row, col) && visited[row][col]==false && picture[row][col]==1){
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }
        if(max < area){
            max = area;
        }
    }

    public static boolean boundaryCheck(int x, int y){
        return 0 <= x && x < picture.length && 0 <= y && y < picture[0].length;
    }
}

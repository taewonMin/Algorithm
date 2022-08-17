package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Maaaaaaze
public class Simulation_16985 {
    public static int[][][] maze = new int[5][5][5];
    public static int[][][] visited = new int[5][5][5];
    public static int[] selected = new int[5];
    public static boolean[] visitedBoard = new boolean[5];
    public static int visit = 1;
    public static int[] dx = {0,0,-1,0,1,0};
    public static int[] dy = {0,0,0,1,0,-1};
    public static int[] dz = {-1,1,0,0,0,0};
    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                maze[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        escapeMaze(0);
        System.out.println(result==Integer.MAX_VALUE ? -1 : result);

        br.close();
    }

    public static void escapeMaze(int k){
        if(k==5){
            stacking(0);
            return;
        }

        for(int i=0; i<4; i++){
            escapeMaze(k+1);
            rotation(k);
        }
    }

    // 회전
    public static void rotation(int n){
        int[][] temp = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                temp[i][j] = maze[n][4-j][i];
            }
        }
        maze[n] = temp;
    }

    // 판 쌓기
    public static void stacking(int k){
        if(k==5){
            int[][][] copyMaze = new int[5][5][5];
            for(int i=0; i<5; i++){
                copyMaze[i] = maze[selected[i]-1];
            }
            if(copyMaze[0][0][0]==1 && copyMaze[4][4][4]==1){
                bfs(copyMaze);
                visit++;
            }
            return;
        }
        for(int i=0; i<5; i++){
            if(!visitedBoard[i]){
                visitedBoard[i] = true;
                selected[k] = i+1;
                stacking(k+1);
                visitedBoard[i] = false;
                selected[k] = 0;
            }
        }
    }

    // 미로 탈출 여부 탐색
    public static void bfs(int[][][] maze){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0,0,0));
        visited[0][0][0] = visit;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<6; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int nz = node.z + dz[i];
                if(oob(nx, ny, nz) || visited[nz][nx][ny]==visit || maze[nz][nx][ny]==0){
                    continue;
                }
                if(nz==4 && nx==4 && ny==4){
                    result = Math.min(result, node.distance+1);
                    return;
                }
                queue.offer(new Node(nx,ny,nz,node.distance+1));
                visited[nz][nx][ny] = visit;
            }
        }
    }

    public static boolean oob(int x, int y, int z){
        return x<0 || x>=5 || y<0 || y>=5 || z<0 || z>=5;
    }

    static class Node {
        int x;
        int y;
        int z;
        int distance;

        Node(int x, int y, int z, int distance){
            this.x = x;
            this.y = y;
            this.z = z;
            this.distance = distance;
        }
    }
}

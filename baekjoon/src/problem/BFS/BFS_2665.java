package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 미로만들기
public class BFS_2665 {
    public static int N;
    public static int[][] maze;
    public static boolean[][][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    
    static class Node{
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        maze = new int[N][N];
        int wallCnt = 0;
        for(int i=0; i<N; i++){
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                if(maze[i][j]==0) wallCnt++;
            }
        }
        visited = new boolean[N][N][wallCnt+1];

        System.out.println(bfs());
        br.close();
    }

    public static int bfs(){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.cnt-o2.cnt);
        queue.offer(new Node(0,0,0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];

                if(nx==N-1 && ny==N-1){
                    return node.cnt;
                }

                if(oob(nx, ny)) continue;
                if(maze[nx][ny]==1){
                    if(visited[nx][ny][node.cnt]) continue;
                    visited[nx][ny][node.cnt] = true;
                    queue.offer(new Node(nx,ny,node.cnt));
                }else{
                    if(visited[nx][ny][node.cnt+1]) continue;
                    visited[nx][ny][node.cnt+1] = true;
                    queue.offer(new Node(nx,ny,node.cnt+1));
                }
            }
        }

        return -1;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}

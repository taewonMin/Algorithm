package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 알고스팟
public class BFS_1261 {
    public static int N,M;
    public static int[][] maze;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    static class Node{
        int x;
        int y;
        int wall;

        Node(int x, int y, int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[0]);
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs(){
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.wall-o2.wall));
        queue.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(oob(nx, ny) || visited[nx][ny]) continue;
                if(nx==N-1 && ny==M-1){
                    return node.wall;
                }
                visited[nx][ny] = true;
                int wall = node.wall;
                if(maze[nx][ny]==1) wall++;
                queue.offer(new Node(nx, ny, wall));
            }
        }

        return -1;
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=M;
    }
}

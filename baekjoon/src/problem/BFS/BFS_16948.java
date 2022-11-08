package problem.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 데스 나이트
public class BFS_16948 {
    static int N,r,c;
    static boolean[][] visited;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N][N];

        sc.nextLine();
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        System.out.println(bfs(r1, c1));
        sc.close();
    }

    static int bfs(int r1, int c1){
        int cnt = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r1, c1, 0));
        visited[r1][c1] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x==r && node.y==c){
                return node.cnt;
            }

            for(int i=0; i<6; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(oob(nx, ny) || visited[nx][ny]) continue;
                queue.offer(new Node(nx,ny,node.cnt+1));
                visited[nx][ny] = true;
            }
        }

        return cnt;
    }

    static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }
}

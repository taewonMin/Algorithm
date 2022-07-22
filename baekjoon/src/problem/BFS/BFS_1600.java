package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 말이 되고픈 원숭이
public class BFS_1600 {
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[] horseDx = {-2,-1,1,2,2,1,-1,-2};
    public static int[] horseDy = {1,2,2,1,-1,-2,-2,-1};
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map = new int[input[1]][input[0]];
        visited = new boolean[K+1][input[1]][input[0]];
        for(int i=0; i<input[1]; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        if(input[0]==1 && input[1]==1){
            System.out.println(0);
        }else{
            bfs();
        }

        br.close();
    }

    public static void bfs(){
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(0, 0, 0, 0));

        while(!queue.isEmpty()){
            Monkey monkey = queue.poll();
            if(monkey.k < K){   // 말 움직임
                for(int i=0; i<8; i++){
                    int x = monkey.x+horseDx[i];
                    int y = monkey.y+horseDy[i];
                    int k = monkey.k+1;
                    if(x==map.length-1 && y==map[0].length-1){
                        System.out.println(monkey.cnt+1);
                        return;
                    }
                    if(boundaryCheck(x, y) && visited[k][x][y]==false && map[x][y]==0){
                        queue.offer(new Monkey(x, y, k, monkey.cnt+1));
                        visited[k][x][y] = true;
                    }
                }
            }

            // 인접방향
            for(int i=0; i<4; i++){
                int x = monkey.x+dx[i];
                int y = monkey.y+dy[i];
                int k = monkey.k;
                if(x==map.length-1 && y==map[0].length-1){
                    System.out.println(monkey.cnt+1);
                    return;
                }
                if(boundaryCheck(x, y ) && visited[k][x][y]==false && map[x][y]==0){
                    queue.offer(new Monkey(x, y, k, monkey.cnt+1));
                    visited[k][x][y] = true;
                }
            }
        }

        System.out.println(-1);
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<map.length && 0<=y && y<map[0].length;
    }

    static class Monkey{
        int x;
        int y;
        int k;  // 말 이동 사용 횟수
        int cnt;    // 동작수

        Monkey(int x, int y, int k, int cnt){
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}

package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 치킨 배달
public class Simulation_15686 {
    public static int N, M;
    public static int[][] map;
    public static List<int[]> chickens = new ArrayList<>();
    public static int[][] selected;
    public static int totalCnt = 0;
    public static int result = Integer.MAX_VALUE;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];
        map = new int[N][N];
        selected = new int[M][2];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    totalCnt++;
                }else if(map[i][j] == 2){
                    chickens.add(new int[]{i,j});
                }
            }
        }

        backTracking(0, 0);
        System.out.println(result);

        br.close();
    }

    public static void backTracking(int cnt, int idx){
        if(cnt==M){
            bfs();
            return;
        }

        for(int i=idx; i<chickens.size(); i++){
            selected[cnt] = chickens.get(i);
            backTracking(cnt+1, i+1);
        }
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int[] pos : selected){
            queue.offer(new Node(pos[0],pos[1],0));
            visited[pos[0]][pos[1]] = true;
        }

        int distance = 0;
        int cityCnt = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(oob(nx, ny) || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Node(nx, ny, node.distance+1));
                if(map[nx][ny]==1){
                    cityCnt++;
                    distance += node.distance+1;
                    if(cityCnt==totalCnt){
                        result = Math.min(result, distance);
                        return;
                    }
                }
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }

    static class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

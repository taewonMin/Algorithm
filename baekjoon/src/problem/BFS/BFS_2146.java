package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 다리 만들기
public class BFS_2146 {
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int minLength = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 섬 구분
        int islandNum = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==false && map[i][j]==1){
                    islandCheck(i,j, islandNum++);
                }
            }
        }

        // 다리 길이 체크
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] > 0){
                    for(boolean[] visit : visited){
                        Arrays.fill(visit, false);
                    }
                    bfs(i,j);
                }
            }
        }

        System.out.println(minLength);

        br.close();
    }

    public static void islandCheck(int x, int y, int islandNum){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        map[x][y] = islandNum;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i=0; i<4; i++){
                int posX = pos[0]+dx[i];
                int posY = pos[1]+dy[i];
                if(boundaryCheck(posX, posY) && visited[posX][posY]==false && map[posX][posY]==1){
                    queue.offer(new int[]{posX, posY});
                    visited[posX][posY] = true;
                    map[posX][posY] = islandNum;
                }
            }
        }
    }

    public static void bfs(int x, int y){
        int islandNum = map[x][y];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int posX = node.x+dx[i];
                int posY = node.y+dy[i];
                if(boundaryCheck(posX, posY) && visited[posX][posY]==false && map[posX][posY] != islandNum){
                    if(map[posX][posY]==0){ // 바다이면
                        queue.offer(new Node(posX,posY,node.length+1));
                        visited[posX][posY] = true;
                    }else{   // 다른 섬에 도착
                        minLength = Math.min(minLength, node.length);
                        return;
                    }
                }
            }
        }
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x< map.length && 0<=y && y<map.length;
    }

    static class Node{
        int x;
        int y;
        int length;

        Node(int x, int y, int length){
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}

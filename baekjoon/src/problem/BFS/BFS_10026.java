package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 적록색약
public class BFS_10026 {
    public static char[][] paint;
    public static boolean[][] visited;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paint = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            paint[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==false){
                    bfs(i,j, false);
                    cnt++;
                }
            }
        }

        for(boolean[] i : visited){
            for(int j=0; j<i.length; j++){
                i[j] = false;
            }
        }

        int cnt2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]==false){
                    bfs(i,j, true);
                    cnt2++;
                }
            }
        }

        System.out.println(cnt+" "+cnt2);

        br.close();
    }

    // 일반 사람
    public static void bfs(int x, int y, boolean isBlind){
        Queue<Color> queue = new LinkedList<>();
        queue.offer(new Color(x,y,paint[x][y]));
        visited[x][y] = true;

        while(!queue.isEmpty()){
            Color color = queue.poll();
            for(int i=0; i<4; i++){
                int posX = color.x+dx[i];
                int posY = color.y+dy[i];
                if(boundaryCheck(posX, posY) && visited[posX][posY]==false && conditionCheck(posX, posY, color.color, isBlind)){
                    queue.offer(new Color(posX, posY, color.color));
                    visited[posX][posY] = true;
                }
            }
        }
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<paint.length && 0<=y && y<paint.length;
    }

    public static boolean conditionCheck(int x, int y, char currentColor, boolean isBlind){
        if(isBlind){
            if(currentColor=='B'){
                return paint[x][y]=='B';
            }else{
                return paint[x][y]!='B';
            }
        }else{
            return currentColor==paint[x][y];
        }
    }

    static class Color {
        int x;
        int y;
        char color;

        Color(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}

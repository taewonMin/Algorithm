package problem.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 상범 빌딩
public class BFS_6593 {
    static int L,N,M;
    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {0,0,-1,0,1,0};   // 상하북동남서
    static int[] dy = {0,0,0,1,0,-1};
    static int[] dz = {1,-1,0,0,0,0};

    static class Node{
        int x; 
        int y;
        int z;
        int dis;

        Node(int x, int y, int z, int dis){
            this.x = x;
            this.y = y;
            this.z = z;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(input[0]==0 && input[1]==0 && input[2]==0) break;

            L = input[0];
            N = input[1];
            M = input[2];
            map = new char[L][N][M];
            visited = new boolean[L][N][M];
            int[] start = {}, end = {};
            for(int k=0; k<L; k++){
                for(int i=0; i<N; i++){
                    map[k][i] = br.readLine().toCharArray();
                    for(int j=0; j<M; j++){
                        if(map[k][i][j]=='S'){
                            start = new int[]{i,j,k};
                        }else if(map[k][i][j]=='E'){
                            end = new int[]{i,j,k};
                        }
                    }
                }
                br.readLine();
            }

            int cnt = bfs(start, end);
            if(cnt==-1){
                bw.write("Trapped!\n");
            }else{
                bw.write("Escaped in "+cnt+" minute(s).\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static int bfs(int[] start, int[] end){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start[0], start[1], start[2], 0));
        visited[start[2]][start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x==end[0] && node.y==end[1] && node.z==end[2]) return node.dis;

            for(int i=0; i<6; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                int nz = node.z+dz[i];
                if(oob(nx, ny, nz) || visited[nz][nx][ny] || map[nz][nx][ny]=='#') continue;
                queue.offer(new Node(nx,ny,nz,node.dis+1));
                visited[nz][nx][ny] = true;
            }
        }

        return -1;
    }

    static boolean oob(int x, int y, int z){
        return x<0 || x>=N || y<0 || y>=M || z<0 || z>=L;
    }
}

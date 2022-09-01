package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 구슬 탈출 2
public class Simulation_13460 {
    public static int N,M;
    public static char[][] map;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        M = input[1];

        map = new char[N][M];
        int rx=0,ry=0,bx=0,by=0;
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j]=='R'){
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                }else if(map[i][j]=='B'){
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                }
            }
        }
        bfs(new Node(rx,ry,bx,by,0));

        br.close();
    }

    public static void bfs(Node start){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.cnt < 10){
                for(int i=0; i<4; i++){
                    boolean isMoved = false;
                    int nrx = node.rx;
                    int nry = node.ry;
                    int nbx = node.bx;
                    int nby = node.by;
    
                    // 파란 구슬 이동
                    while(map[nbx+dx[i]][nby+dy[i]]=='.'){
                        nbx += dx[i];
                        nby += dy[i];
                        isMoved = true;
                    }
                    if(map[nbx+dx[i]][nby+dy[i]]=='O'){
                        continue;
                    }
                    // 빨간 구슬 이동
                    while(map[nrx+dx[i]][nry+dy[i]]=='.'){
                        nrx += dx[i];
                        nry += dy[i];
                        isMoved = true;
                    }
                    if(map[nrx+dx[i]][nry+dy[i]]=='O'){
                        System.out.println(node.cnt+1);
                        return;
                    }
    
                    // 같은 칸에 멈췄으면
                    if(nrx==nbx && nry==nby){
                        if(i==0){
                            if(node.rx < node.bx){
                                nbx++;
                            }else{
                                nrx++;
                            }
                        }else if(i==1){
                            if(node.ry < node.by){
                                nry--;
                            }else{
                                nby--;
                            }
                        }else if(i==2){
                            if(node.rx < node.bx){
                                nrx--;
                            }else{
                                nbx--;
                            }
                        }else{
                            if(node.ry < node.by){
                                nby++;
                            }else{
                                nry++;
                            }
                        }
                    }
                    if(isMoved){
                        queue.offer(new Node(nrx, nry, nbx, nby, node.cnt+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Node{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        Node(int rx, int ry, int bx, int by, int cnt){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }
}

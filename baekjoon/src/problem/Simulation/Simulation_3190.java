package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 뱀
public class Simulation_3190 {
    public static int N;
    public static int[][] map;
    public static Deque<int[]> snake = new LinkedList<>();
    public static ArrayList<Node> rotateInfo = new ArrayList<>();
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int headDir = 0;
    public static int time = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];    // 사과 1, 뱀 2
        map[0][0] = 2;
        snake.add(new int[]{0,0});
        for(int i=0; i<K; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[input[0]-1][input[1]-1] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            String[] input = br.readLine().split(" ");
            rotateInfo.add(new Node(Integer.parseInt(input[0]), input[1]));
        }

        gameStrat();
        System.out.println(time);

        br.close();
    }

    public static void gameStrat(){
        while(true){
            time++;
            // 갈 수 있는지 체크
            int[] head = snake.getFirst();
            int nx = head[0]+dx[headDir];
            int ny = head[1]+dy[headDir];
            if(oob(nx, ny) || map[nx][ny]==2){
                break;
            }
            snake.addFirst(new int[]{nx, ny});
            if(map[nx][ny]==0){
                int[] tail = snake.removeLast();
                map[tail[0]][tail[1]] = 0;
            }
            map[nx][ny] = 2;

            changeHead();
        }
    }

    // 방향 전환
    public static void changeHead(){
        if(!rotateInfo.isEmpty()){
            Node info = rotateInfo.get(0);
            if(info.time==time){
                if(info.dir.equals("L")){
                    headDir = (headDir+3)%4;
                }else{
                    headDir = (headDir+1)%4;
                }
                rotateInfo.remove(0);
            }
        }
    }

    public static boolean oob(int x, int y){
        return x<0 || x>=N || y<0 || y>=N;
    }

    static class Node{
        int time;
        String dir;

        Node(int time, String dir){
            this.time = time;
            this.dir = dir;
        }
    }
}

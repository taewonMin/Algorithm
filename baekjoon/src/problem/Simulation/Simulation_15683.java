package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 감시
public class Simulation_15683 {
    public static int[][] room;
    public static int result = Integer.MAX_VALUE;
    public static List<Camera> cameras = new ArrayList<>();
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        room = new int[input[0]][input[1]];
        for(int i=0; i<input[0]; i++){
            room[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<input[1]; j++){
                int num = room[i][j];
                if(num != 0 && num != 6){
                    cameras.add(new Camera(i, j, num));
                }
            }
        }

        backTracking(0);
        System.out.println(result);

        br.close();
    }

    public static void backTracking(int depth){
        if(depth == cameras.size()){
            int cnt = 0;
            for(int[] i : room){
                for(int j : i){
                    if(j==0){
                        cnt++;
                    }
                }
            }
            result = Math.min(result, cnt);
            return;
        }

        List<int[]> temp = new ArrayList<>();
        Camera camera = cameras.get(depth);
        switch(camera.num){
            case 1:
                for(int i=0; i<4; i++){
                    checkCCTV(camera, dx[i], dy[i], temp);
                    backTracking(depth+1);
                    reset(temp);
                }
                break;
            case 2:
                for(int i=0; i<2; i++){
                    for(int j=0; j<2; j++){
                        checkCCTV(camera, dx[2*j+i], dy[2*j+i], temp);
                    }
                    backTracking(depth+1);
                    reset(temp);
                }
                break;
            case 3:
                for(int i=0; i<4; i++){
                    for(int j=0; j<2; j++){
                        checkCCTV(camera, dx[(i+j)%4], dy[(i+j)%4], temp);
                    }
                    backTracking(depth+1);
                    reset(temp);
                }
                break;
            case 4:
                for(int i=0; i<4; i++){
                    for(int j=0; j<3; j++){
                        checkCCTV(camera, dx[(i+j)%4], dy[(i+j)%4], temp);
                    }
                    backTracking(depth+1);
                    reset(temp);
                }
                break;
            case 5:
                for(int i=0; i<4; i++){
                    checkCCTV(camera, dx[i], dy[i], temp);
                }
                backTracking(depth+1);
                reset(temp);
                break;    
        }
    }

    // 카메라 감시 구역 체크
    public static void checkCCTV(Camera camera, int dx, int dy, List<int[]> temp){
        int x = camera.x + dx;
        int y = camera.y + dy;
        while(boundaryCheck(x, y) && room[x][y]!=6){
            if(room[x][y]==0){
                room[x][y] = -1;
                temp.add(new int[]{x,y});
            }
            x += dx;
            y += dy;
        }
    }

    // 카메라 감시 구역 리셋
    public static void reset(List<int[]> temp){
        while(!temp.isEmpty()){
            int[] pos = temp.remove(0);
            room[pos[0]][pos[1]] = 0;
        }
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<room.length && 0<=y && y<room[0].length;
    }

    static class Camera{
        int x;
        int y;
        int num;

        Camera(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}

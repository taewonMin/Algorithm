package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 경사로
public class Simulation_14890 {
    public static int N,L;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cond = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N=cond[0];
        L=cond[1];
        
        int[][] map = new int[N][N];
        int[][] map2 = new int[N][N];
        for(int i=0; i<N; i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<N; j++){
                map[i][j] = arr[j];
                map2[j][i] = arr[j];
            }
        }

        checkRoad(map);
        checkRoad(map2);
        System.out.println(result);

        br.close();
    }

    public static void checkRoad(int[][] map){
        for(int i=0; i<N; i++){
            int cnt = 1;
            int height = map[i][0];
            boolean isRoad = true;
            for(int j=1; j<N; j++){
                if(map[i][j]==height){
                    cnt++;
                }else if(map[i][j]-height==1){  // 높아지면
                    if(cnt >= L){
                        cnt=1;
                        height++;
                    }else{
                        isRoad = false;
                        break;
                    }
                }else if(map[i][j]-height==-1){ // 낮아지면
                    int success = setDownSlide(map, i, j);
                    if(success==-1){
                        isRoad = false;
                        break;
                    }
                    cnt=0;
                    height--;
                    j=success;
                }else{
                    isRoad = false;
                    break;
                }
            }
            if(isRoad) result++;
        }
    }

    public static int setDownSlide(int[][] map, int x, int y){
        int length = 0;
        int height = map[x][y];
        while(y < N && length < L && map[x][y]==height){
            length++;
            y++;
        }
        if(length==L){
            return y-1;
        }else{
            return -1;
        }
    }
}

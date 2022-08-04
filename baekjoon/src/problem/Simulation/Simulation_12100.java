package problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2048(Easy)
public class Simulation_12100 {
    public static int N;
    public static int[][] map;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        backTracking(0, map);
        System.out.println(result);

        br.close();
    }

    public static void backTracking(int depth, int[][] mapArr){
        if(depth==5){
            for(int[] arr : mapArr){
                for(int i : arr){
                    result = Math.max(result, i);
                }
            }
            return;
        }

        int top;
        boolean merged;
        int[][] copyArr = new int[N][N];
        for(int k=0; k<4; k++){
            for(int i=0; i<N; i++){
                copyArr[i] = mapArr[i].clone();
            }
            for(int i=0; i<N; i++){ // 열
                top = -1;
                merged = false;
                for(int j=0; j<N; j++){ // 행
                    if(copyArr[j][i]!=0){
                        if(top > -1 && copyArr[top][i] == copyArr[j][i] && merged==false){
                            copyArr[top][i] *= 2;
                            merged = true;
                        }else{
                            copyArr[++top][i] = copyArr[j][i];
                            merged = false;
                        }
                        if(top != j){
                            copyArr[j][i] = 0;
                        }
                    }
                }
            }
            backTracking(depth+1, copyArr);
            mapArr = rotation(mapArr);
        }
    }

    public static int[][] rotation(int[][] arr){
        int[][] rotate = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                rotate[i][j] = arr[j][N-1-i];
            }
        }

        return rotate;
    }
}

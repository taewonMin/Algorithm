package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 가장 큰 정사각형
public class DP_1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] arr = new int[input[0]][input[1]];
        int[][] dp = new int[input[0]][input[1]];
        int max = 0;
        for(int i=0; i<input[0]; i++){
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<input[1]; j++){
                if(arr[i][j]==1){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    }

                    max = Math.max(max, dp[i][j]*dp[i][j]);
                }
            }
        }

        System.out.println(max);

        br.close();
    }
}

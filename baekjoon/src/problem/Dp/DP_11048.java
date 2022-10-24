package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 이동하기
public class DP_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[][] dp = new int[n][m];
        for(int i=0; i<input[0]; i++){
            dp[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int max = 0;
                if(i>0 && j>0)  max = Math.max(max, dp[i-1][j-1]);
                if(i>0)  max = Math.max(max, dp[i-1][j]);
                if(j>0)  max = Math.max(max, dp[i][j-1]);
                dp[i][j] += max;
            }
        }

        System.out.println(dp[n-1][m-1]);
        br.close();
    }
}

package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 자두나무
public class DP_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] future = new int[input[0]];
        for(int i=0; i<input[0]; i++){
            future[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        int[][] dp = new int[input[0]+1][input[1]+1];
        for(int i=1; i<=input[0]; i++){
            for(int j=0; j<=input[1]; j++){
                if(j>i) break;

                int cnt = j%2+1 == future[i-1] ? 1 : 0;
                if(j==0){
                    dp[i][j] = dp[i-1][j]+cnt;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+cnt;
                }
                if(i==input[0]){
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
        br.close();
    }
}

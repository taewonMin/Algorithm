package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 동전
public class DP_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] coins = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][M+1];
            for(int j=1; j<=N; j++){
                dp[j][0] = 1;
                for(int k=1; k<=M; k++){
                    if(k < coins[j-1]){
                        dp[j][k] = dp[j-1][k];
                    }else{
                        dp[j][k] = dp[j-1][k]+dp[j][k-coins[j-1]];
                    }
                }
            }
            System.out.println(dp[N][M]);
        }

        br.close();
    }
}

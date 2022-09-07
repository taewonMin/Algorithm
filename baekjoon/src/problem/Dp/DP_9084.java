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
            int[] dp = new int[M+1];
            dp[0] = 1;
            for(int j=0; j<N; j++){
                for(int k=coins[j]; k<=M; k++){
                    dp[k] += dp[k-coins[j]];
                }
            }
            System.out.println(dp[M]);
        }

        br.close();
    }
}

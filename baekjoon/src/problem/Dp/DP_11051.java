package problem.Dp;

import java.util.Scanner;

// 이항 계수 2
public class DP_11051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            dp[i][0] = dp[i][i] = 1;
            for(int j=1; j<i; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%10007;
            }
        }
        System.out.println(dp[N][K]);

        sc.close();
    }
}

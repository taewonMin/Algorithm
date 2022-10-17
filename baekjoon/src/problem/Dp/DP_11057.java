package problem.Dp;

import java.util.Arrays;
import java.util.Scanner;

// 오르막 수
public class DP_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[10][N+1];
        Arrays.fill(dp[0], 1);
        for(int i=0; i<10; i++){
            dp[i][1] = i+1;
        }
        for(int i=2; i<=N; i++){
            for(int j=1; j<10; j++){
                dp[j][i] = (dp[j-1][i] + dp[j][i-1])%10007;
            }
        }

        System.out.println(dp[9][N]);

        sc.close();
    }
}

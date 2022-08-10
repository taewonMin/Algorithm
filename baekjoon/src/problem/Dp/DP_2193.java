package problem.Dp;

import java.util.Scanner;

// 이친수
public class DP_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] dp = new long[N+1][2];   // [현재자리][숫자]
        dp[1] = new long[]{0,1};

        for(int i=2; i<=N; i++){
            dp[i] = new long[]{dp[i-1][0]+dp[i-1][1], dp[i-1][0]};
        }

        System.out.println(dp[N][0]+dp[N][1]);

        sc.close();
    }
}

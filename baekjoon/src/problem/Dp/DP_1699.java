package problem.Dp;

import java.util.Arrays;
import java.util.Scanner;

// 제곱수의 합
public class DP_1699 {
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        System.out.println(calc(N));

        sc.close();
    }

    public static int calc(int n){
        if(dp[n]==Integer.MAX_VALUE){
            for(int i=(int)Math.sqrt(n); i>=1; i--){
                dp[n] = Math.min(dp[n], calc(n-i*i)+1);
            }
        }
        return dp[n];
    }
}

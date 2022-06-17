package problem.Dp;

import java.util.Scanner;

// 피보나치 수 2
public class Dp_2748 {
    public static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new long[n+1];
        dp[1] = 1;

        System.out.println(fibonacci(n));

        sc.close();
    }

    public static long fibonacci(int N){
        if(dp[N] != 0 || N==0){
            return dp[N];
        }
        dp[N] = fibonacci(N-1) + fibonacci(N-2);
        return dp[N];
    }
}

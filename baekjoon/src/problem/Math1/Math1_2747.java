package problem.Math1;

import java.util.Scanner;

// 피보나치 수
public class Math1_2747 {
    public static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n+1];
        dp[1] = 1;

        System.out.println(fib(n));

        sc.close();
    }

    public static int fib(int n){
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

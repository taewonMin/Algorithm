package problem.Dp;

import java.util.Scanner;

// 알고리즘 수업 - 피보나치 수 1
public class Dp_24416{
    public static int count1=0;
    public static int count2=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fib(n);
        fibonacci(n);

        System.out.println(count1 + " " + count2);

        sc.close();
    }

    public static int fib(int n){
        if(n==1 || n==2){
            count1++;
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }

    public static int fibonacci(int n){
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for(int i=3; i<=n; i++){
            count2++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
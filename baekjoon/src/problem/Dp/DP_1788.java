package problem.Dp;

import java.util.Scanner;

// 피보나치 수의 확장
public class DP_1788 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[Math.abs(n)+1];
        dp[0] = 0;
        if(dp.length > 1){
            dp[1] = 1;
        }

        for(int i=2; i<dp.length; i++){
            if(n>0){
                dp[i] = (dp[i-1]+dp[i-2])%1000000000;
            }else{
                dp[i] = (dp[i-2]-dp[i-1])%1000000000;
            }
        }

        int N = Math.abs(n);
        System.out.println(dp[N]==0 ? 0 : (dp[N]>0 ? 1 : -1));
        System.out.println(Math.abs(dp[N]));

        sc.close();
    }
}

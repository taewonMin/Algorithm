package problem.Dp;

import java.util.Scanner;

// 1로 만들기 2
public class DP_12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N+1];
        int[] path = new int[N+1];
        dp[1] = 0;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+1;
            path[i] = i-1;
            if(i%2==0 && dp[i/2]+1 < dp[i]){
                dp[i] = dp[i/2]+1;
                path[i] = i/2;
            }
            if(i%3==0 && dp[i/3]+1 < dp[i]){
                dp[i] = dp[i/3]+1;
                path[i] = i/3;
            }
        }

        System.out.println(dp[N]);
        int num = N;
        while(num>0){
            System.out.print(num+" ");
            num = path[num];
        }

        sc.close();
    }
}

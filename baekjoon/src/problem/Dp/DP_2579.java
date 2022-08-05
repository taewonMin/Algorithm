package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
public class DP_2579 {
    public static int[] dp, stair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stair = new int[n];
        for(int i=0; i<n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n];
        dp[0] = stair[0];
        if(n > 1) dp[1] = stair[0]+stair[1];
        if(n > 2) dp[2] = Math.max(stair[0],stair[1])+stair[2];

        System.out.println(recursive(n-1));

        br.close();
    }

    public static int recursive(int n){
        if(dp[n]==0){
            dp[n] = Math.max(recursive(n-2), recursive(n-3)+stair[n-1]) + stair[n];
        }
        return dp[n];
    }
}

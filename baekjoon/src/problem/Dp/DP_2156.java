package problem.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
public class DP_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = wine[0];
        if(N>1) dp[1] = wine[0]+wine[1];
        if(N>2) dp[2] = Math.max(dp[1], Math.max(wine[2]+wine[1], wine[2]+wine[0]));

        for(int i=3; i<N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(wine[i]+dp[i-2], wine[i]+wine[i-1]+dp[i-3]));
        }

        System.out.println(dp[N-1]);
        br.close();
    }
}
